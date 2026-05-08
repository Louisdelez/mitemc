# 01 — Player mechanics

How the MITE player differs from vanilla Minecraft. Every number here is cross-checked against `MITE-RB-2025` (MIT-licensed continuation).

## Health

### Curve

```
max_health = min(20, floor(level / 5) * 2 + 6)
```

| XP level | Max HP | Hearts visible |
|---------:|------:|---------------:|
| 0        | 6     | 3              |
| 5        | 8     | 4              |
| 10       | 10    | 5              |
| 15       | 12    | 6              |
| 20       | 14    | 7              |
| 25       | 16    | 8              |
| 30       | 18    | 9              |
| 35+      | 20    | 10 (cap)       |

The vanilla 10-hearts/20-HP value is reached at level 35 and never exceeded. Players cannot go above 10 hearts even with attribute modifiers stacking.

### Application

The formula is recomputed on every tick (or every world load / dimension change / respawn) and applied via the `MAX_HEALTH` attribute. If current health exceeds the new max (e.g., level lost in lava), it is clamped down.

## Hunger — five-category system

MITE replaces the vanilla single hunger bar with a 5-axis nutrient model. Each axis runs **0 → 5** (saturation) and has its own exhaustion accumulator that gates depletion.

| Category | Drained by | Replenished by |
|---|---|---|
| **Fruits** | Damage taken (especially fall) | Apples, berries, melon, sweet fruits |
| **Vegetables** | Combat (swing, attack), shield use | Carrots, potatoes, vegetables |
| **Grain** | Walking, sprinting, swimming | Bread, pasta, grain-based items |
| **Dairy** | Falling damage delta | Milk, cheese, dairy products |
| **Protein** | Combat, jumping | Meat (raw or cooked), eggs, fish |

### Constants

| Field | Value |
|---|---:|
| Starting saturation per category | 8.0 |
| Initial DataTracker value | 12.0 (set on player init) |
| Max saturation | 5.0 |
| Exhaustion threshold to consume 1 saturation | 4.0 |
| `addExhaustion` multiplier inside HungerManager | ×1.5 |

### Update logic (per tick)

Every server tick, for each category:

1. If `categoryExhaustion > 4`: subtract 4 from exhaustion, decrement saturation by 1 (or set vanilla `exhaustion = 5` if already empty — triggers the vanilla starvation pipeline).
2. If vanilla `exhaustion > 4`: subtract 4, decrement food level if saturation is empty, otherwise consume saturation.
3. If `foodLevel == 0` and exhaustion ≥ 4: deal 1 starvation damage.
4. Every 30 minutes (`20 * 60 * 30` ticks): subtract 1 from food level unconditionally (long-term slow drain).

### Per-action exhaustion costs

| Action | Category | Cost | Modifier |
|---|---|---:|---|
| Walking on ground (per tick) | Grain | 0.01 | — |
| Sprinting (extra) | Grain | +0.03 | — |
| Swimming up | Grain | 0.01 | — |
| Swimming up | Vegetables | 0.1 | — |
| Tool swing | Vegetables | 0.01 | hot biome ×10 |
| Attacking entity | Vegetables | 0.01 | hot biome ×10 |
| Attack hit (PROTEIN) | Protein | 0.25 | hot biome ×2 |
| Shield block | Protein | 0.1 | hot biome ×2 |
| Jump (sprinting) | Vegetables | 0.2 | hot biome ×2 |
| Jump (idle) | Grain | 0.005 | hot biome ×2 |
| Jump (idle) | Vegetables | 0.05 | hot biome ×2 |
| Damage taken (per damage HP) | Fruits | 0.5 | hot biome ×1.5 |
| Fall damage (per damage HP) | Dairy | 0.5 | — |
| Per-tick baseline | All 5 | 0.0001 | hot ×10, cold ÷10 |

### Temperature modifiers

| Condition | Per-tick exhaustion |
|---|---:|
| Normal biome (0.5 ≤ temp ≤ 1.5) | 0.0001 |
| Hot biome (temp > 1.5 OR ultrawarm dim) | 0.001 (×10) |
| Cold biome (temp < 0.5) | 0.00001 (÷10) |

These multipliers apply to the per-tick exhaustion AND amplify combat-related categories.

### Rain

Player exposed to rain (sky access at their position): +0.01 vanilla `exhaustion` per tick on top of the baseline. This is independent of the temperature-based rate.

### Movement speed scaling

```
speed = base_speed + base_speed * (grain_saturation / max_saturation) * 0.075
speed = lerp(cold_lerp, speed, speed * 0.75)
```

A well-fed player (full Grain) is ~7.5 % faster. Cold biomes interpolate the speed down to 75 % of normal, smoothly over time (`cold_lerp` ramps from 0 → 1 over ~100 ticks).

### Damage scaling

Outgoing attack damage scales with PROTEIN saturation:

```
damage = saturation_protein / max_saturation
```

A starving player (Protein 0) deals 0 damage. A fully-fed player (Protein 5) deals exactly the vanilla weapon damage.

## Reach distance

Custom per held item (interpolation: vanilla creative reach is 5.0; MITE survival default is 1.5):

| Held item | Reach |
|---|---:|
| Nothing / non-tool | 1.5 |
| Stick | 1.75 (+0.25) |
| Bone | 1.75 (+0.25) |
| Branch (MITE) | 2.5 (+1.0) |
| Wooden cudgel | 1.75 (+0.25) |
| Wooden club | 2.0 (+0.5) |
| Knife (any tier) | 1.75 (+0.25) |
| Dagger (any tier) | 2.0 (+0.5) |
| Hatchet (any tier) | 2.0 (+0.5) |
| Stone shovel | 2.0 (+0.5) |
| Shovel (other tiers) | 2.25 (+0.75) |
| Pickaxe / Axe / Sword / Hoe | 2.25 (+0.75) |
| War hammer | 2.25 (+0.75) |
| Mattock | 2.25 (+0.75) |
| Shears | 2.0 (+0.5) |
| Scythe | 2.5 (+1.0) |
| Spear / Trident | 2.75 (+1.25) |
| Creative mode | 5.0 (vanilla cap) |

The "extra" column is `reach - 1.5`. Reach is checked when attacking (a too-far target ignores the swing).

## Spawn invincibility

For the first **600 ticks (30 seconds)** of a player's life, all attacker-driven damage is canceled. Environmental damage (fall, suffocation, lava, drowning, starvation, fire) still applies.

The `aliveTime` counter increments every tick, resets on death (post-death update sets it to 0).

## Inventory weight (carry slowdown)

Each item type has a weight value (see `kelvin.mite.main.resources.Resources`). The total inventory weight modifies movement:

| Inventory weight | Movement speed |
|---|---|
| ≤ 65 % of `MAX_CARRY` | 1.0× (full speed) |
| 65 %–100 % of MAX_CARRY | linear interpolation between 1.0× and 0.8× |
| > 100 % of MAX_CARRY | 0.8× (capped) |

This is layered on top of the GRAIN-based speed scaling, so a heavy + starving player is double-penalized.

## Persistence (NBT)

The following fields are stored per-player NBT and survive save/load:

| NBT key | Type | Meaning |
|---|---|---|
| `AcquiredIron` | bool | Once true, persists. Used to gate certain late achievements. |
| `Fruit` / `Vegetables` / `Grain` / `Dairy` / `Protein` | float | Saturation per category |
| `AliveTime` | int | Tick counter for spawn invincibility |
| `foodLevel` / `foodSaturationLevel` / `foodExhaustionLevel` / `foodTickTimer` | (vanilla) | Standard hunger plumbing |

## Block-breaking speed (per state of the player)

See [02-blocks-tools.md](./02-blocks-tools.md) for the full matrix. As a player-side note:

- Speed is multiplied by 1.25 if Vegetables saturation is full, scaled linearly down to 1.0 at zero.
- If `foodLevel == 0` OR `health ≤ 1`: speed × 0.5.
- If the targeted block has no block entity: speed × 0.05 (most simple blocks).
- Gravel / gravel-variants: speed × 0.75.

## Delta vs. vanilla — quick summary

| Vanilla | MITE |
|---|---|
| 10 hearts / 10 food, full from level 0 | 3 hearts / level-gated, +1 every 5 levels |
| 1 hunger bar | 5 nutrient categories |
| Hunger drains uniformly | Hunger drains per activity by category |
| Reach 4.5 (survival) | Reach 1.5 + per-tool bonus |
| No spawn invincibility | 30 s post-spawn grace |
| No inventory weight | Carry-weight slowdown |
| Constant attack damage | Damage scales with Protein saturation |

## Relevant config knobs in MITEMC

```toml
[phase1.starting_stats]
starting_hearts = 3            # MITE = 3
[phase1.hunger]
basal_exhaustion_per_tick = 0.0001  # MITE baseline
```

The 5-category hunger is **not yet implemented** in MITEMC — it requires a Capability + GUI rewrite. The single-axis vanilla bar with MITE-correct exhaustion rates is the current shortcut. See [PROGRESS.md](../../PROGRESS.md) for the punch list.

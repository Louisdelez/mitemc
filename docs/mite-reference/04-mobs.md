# 04 — Mobs & entities

How MITE retunes vanilla mobs and what entities it adds.

## Vanilla mobs — MITE tweaks

`MITE-RB-2025` heavily uses Mixins to retune vanilla mob behavior. Confirmed changes:

### Zombie (`ZombieEntityMixin` — 735 lines, the heaviest)

| Behavior | MITE |
|---|---|
| HP | Vanilla (20 / 10 hearts) |
| Attack damage | Vanilla |
| Sun damage | Disabled for "ghoul" subtype zombies; vanilla for others |
| Persistence | Aggressive: zombies stay loaded longer |
| Reach | Vanilla |
| Drop table | Adjusted: more rotten flesh on average; chance for bone |
| Sound | Vanilla |
| Custom: paralysis bite (ghoul) | Slowness IV + Mining Fatigue II for 4 s |

### Wolf (`WolfEntityMixin` — 264 lines)

| Behavior | MITE |
|---|---|
| Spawn behavior | Hostile by default in some biomes (dire wolves) |
| HP | Vanilla wolf 8 / dire wolf 20 |
| Damage | Vanilla 4 / dire wolf 6 |
| Pack behavior | Reinforced — wolves call peers when attacked |
| Tame requirement | Vanilla bones |

### Creeper (`CreeperEntityMixin` — 228 lines)

| Behavior | MITE |
|---|---|
| Explosion radius | Vanilla 3 — but **Infernal Creeper** subtype 5 |
| Charged behavior | Vanilla |
| Fire-immunity (Infernal) | Yes |
| Spawn | Infernal in Nether biomes |

### Other vanilla mobs (LivingEntityMixin)

| Mob | Tweak |
|---|---|
| Skeleton | Wight subtype hits drain food exhaustion |
| Spider | Wood spider subtype: forest biomes; demon spider: deep caves, periodic leaps |
| Phantom / Shadow | Shadow subtype: spawns ONLY at light level 0 |
| Blaze / Fire elemental | Overworld variant in deep caves; longer follow range |
| Iron Golem | Vanilla |
| Cow / Pig / Sheep / Chicken | Custom hunger/thirst goals (see below) |
| Horse | `HorseKicking` — horses can kick |

## MITE-added hostile mobs

The original Avernite MITE roster (10 species) targeted by the MITEMC port:

### Dire wolf

| Stat | Value |
|---|---|
| HP | 20 |
| Attack damage | 6 |
| Movement speed | 0.35 (vanilla wolf is 0.30) |
| Follow range | 24 blocks |
| Spawn | Overworld surface, twilight, packs of 2–4 |
| AI | Always-hostile to players (does not bypass via taming) |
| Drops | 1–2 bones |

### Wood spider

| Stat | Value |
|---|---|
| HP | 14 |
| Attack damage | 3 |
| Speed | 0.36 |
| Spawn | Forest biomes, daytime allowed |
| AI | Climbs walls (vanilla spider AI) |
| Drops | 0–2 string, 0–1 spider eye |

### Ghoul

| Stat | Value |
|---|---|
| HP | 24 |
| Attack damage | 4 |
| Speed | 0.24 |
| Spawn | Cave layers below Y=0 |
| AI | Does not burn in sunlight; bite applies Slowness IV + Mining Fatigue II for 4 s |
| Drops | 0–3 rotten flesh, 0–1 bone |

### Wight

| Stat | Value |
|---|---|
| HP | 18 |
| Attack damage | 4 |
| Speed | 0.28 |
| Spawn | Cave layers / tombs |
| AI | No bow; melee only; hits drain 4 hunger exhaustion from player |
| Drops | 0–3 bone, 0–2 arrows |

### Shadow

| Stat | Value |
|---|---|
| HP | 16 |
| Attack damage | 5 |
| Speed | 0.30 |
| Spawn | **Only at light level 0** (custom check) |
| AI | Stays in pure darkness; no sun sensitivity |
| Drops | 0–2 rotten flesh, 0–1 coal |

### Invisible stalker

| Stat | Value |
|---|---|
| HP | 18 |
| Attack damage | 5.5 |
| Speed | 0.27 |
| Spawn | Cave layers |
| AI | Permanent self-Invisibility (re-applied every 200 ticks) |
| Drops | 0–2 rotten flesh, 0–1 glass bottle |

### Hellhound

| Stat | Value |
|---|---|
| HP | 24 |
| Attack damage | 7 |
| Speed | 0.36 |
| Spawn | Nether |
| AI | Fire-immune; ignites target on hit (5 s) |
| Drops | 1–2 bone, 0–1 blaze powder |

### Demon spider

| Stat | Value |
|---|---|
| HP | 20 |
| Attack damage | 5 |
| Speed | 0.34 |
| Spawn | Deep caves (Y < -16 typical) |
| AI | Periodic leap toward target every ~3 s if within 8 blocks |
| Drops | 0–2 string, 0–2 spider eye |

### Infernal creeper

| Stat | Value |
|---|---|
| HP | 24 |
| Movement speed | 0.30 |
| Explosion knockback resistance | 0.5 (medium) |
| Explosion radius | ~5 blocks (vanilla creeper is 3) |
| Spawn | Nether |
| AI | Fire-immune; modest fall resistance |
| Drops | 1–3 gunpowder, 0–1 nether wart |

### Fire elemental

| Stat | Value |
|---|---|
| HP | 24 |
| Attack damage | 6 |
| Speed | 0.25 |
| Follow range | 32 blocks |
| Spawn | Cave layers below Y=0 (overworld blaze cousin) |
| AI | Same as Blaze (fireballs at distance, fire-immune) |
| Drops | 1–2 blaze rod |

## Animal AI tweaks

`MITE-RB-2025/entity/goal/*` adds new goals to vanilla passive mobs:

### `CanEatGrass`

Cows, sheep, and the bear apply `CanEatGrass`: when nearby grass is detected, the animal pathfinds to it and consumes it (turns the grass block to dirt). Restores their hunger meter.

### `DrinkWaterGoal`

Animals seek water blocks within 8 blocks when their thirst meter is below threshold.

### `EntityAIWatchAnimal` (436 lines)

Predator-prey awareness. Wolves track sheep, foxes track chickens, etc. — they actively hunt rather than passive.

### `FoodTargetGoal`

Animals consider plant blocks and seed-related items as food targets, scoring them for pathfinding decisions.

### `HungryAnimal` interface

Cow, pig, sheep, chicken implement a hunger meter. If they go too long without eating grass / drinking water, they take starvation damage.

| Animal | Eats | Drinks | Death from starvation |
|---|---|---|---|
| Cow | Grass | Water | Yes |
| Sheep | Grass | Water | Yes |
| Pig | Grass / dirt | Water | Yes |
| Chicken | Seeds, grass | Water | Yes |

## MITE-added passive mobs

| Mob | Spawn | Behavior |
|---|---|---|
| **Bear** (`BearEntity`) | Forest, taiga | Neutral; aggressive when provoked or with cub nearby; drops meat + leather |
| **Turkey** (`TurkeyEntity`) | Plains, forest edges | Like vanilla chicken but bigger, stronger drops |

## Mob spawning

`ChunkGeneratorMixin` (317 lines) injects MITE mobs into biome spawn lists:

- Overworld surface: Dire wolf, wood spider, bear (forests); turkey (plains)
- Cave layers (Y < 0): Ghoul, wight, demon spider, fire elemental, invisible stalker
- Light level 0 anywhere: Shadow
- Nether: Hellhound, infernal creeper

Spawn weights from `WeightRegistry.java` (290 lines): each species has a per-biome weight, with deeper layers favoring scarier mobs.

## Living entity base behavior (all mobs + players)

`LivingEntityMixin` retunes damage handling and healing for every `LivingEntity` subclass.

### Natural healing rate

A living entity heals 1 HP every N seconds, where N depends on Fruits saturation (players only):

```
heal_interval_seconds = 60 * lerp(fruits/max_fruits, 5, 2.5)
```

| Player Fruits | Heal interval per HP |
|---|---:|
| 0 / 5 (empty) | 5 minutes (300 s) |
| 1.25 / 5 | ~4.4 minutes (~265 s) |
| 2.5 / 5 (half) | ~3.75 minutes (~225 s) |
| 3.75 / 5 | ~3.1 minutes (~190 s) |
| 5 / 5 (full) | 2.5 minutes (150 s) |

For non-player entities (mobs, animals): 1 HP every 5 minutes flat.

### Damage handling order

1. **Invulnerability checks** — creative, dead, client-side, fire-immune with Fire Resistance: damage canceled.
2. **Shield block check** — if `blockedByShield(source)` returns true and source is not a projectile: routed to `takeShieldHit`.
3. **Shield damage accumulator** — accumulates damage over a 1-second sliding window.
4. **Shield disable** — if accum > threshold, disables shield for `60 * (accum / 12)` ticks.

### Shield mechanics

| Property | Value |
|---|---|
| Default shield damage threshold (player) | 4 HP |
| Non-player attacker threshold | `ShieldTier.getProtectionLevel()` |
| Shield damage accum window | 1 second (resets on inactivity) |
| Shield disable formula | `60 * (damage_accum / 12)` ticks |

### Knockback multipliers per attacker weapon

| Weapon | Multiplier vs. base 0.5 |
|---|---:|
| Bare hand / axe | × 1.0 |
| Sword | × 1.25 |
| Shovel | × 1.75 |
| Trident | × 2.0 |

Status effect bonuses (sprinting attacker only):
- Speed effect: +0.1 × amplifier
- Strength effect: +0.05 × amplifier

### Shield disable chance

```
disable_chance = 0.25 + 0.05 * efficiency_level
if attacker is sprinting: disable_chance += 0.75
```

`efficiency_level` is total Efficiency enchantment on attacker gear. If the roll succeeds, shield enters cooldown for the disable time.

### Knockback resistance

`GENERIC_KNOCKBACK_RESISTANCE` attribute honored as in vanilla. Armored mobs resist knockback proportionally.

## Spawn placement table

| Mob class | Placement type | Light level | Heightmap |
|---|---|---|---|
| Surface monsters (dire wolf, wood spider) | ON_GROUND | Any | MOTION_BLOCKING_NO_LEAVES |
| Cave monsters (ghoul, wight, demon spider, invisible stalker, fire elemental) | ON_GROUND | Any | MOTION_BLOCKING_NO_LEAVES |
| Shadow | ON_GROUND | **Light = 0 only** | MOTION_BLOCKING_NO_LEAVES |
| Nether monsters (hellhound, infernal creeper) | ON_GROUND | Any | MOTION_BLOCKING_NO_LEAVES |

## In MITEMC implementation

- **10 hostile entities**: registered with placeholder vanilla renderers and starter stats. **Real custom AI behaviors are not implemented**; only the entity class with stat overrides exists.
- **Animal hunger**: simplified `AnimalHungerHandler` for cow/sheep/pig/chicken. Real grass-eating + water-drinking goals are on the punch list.
- **Bear, turkey**: not registered.
- **Mob mixin tweaks** (zombie persistence, wolf packing, etc.): not implemented.
- **Living entity natural healing curve** (Fruits-saturation-dependent): not implemented.
- **Custom shield mechanics** (accumulator, weapon-multiplier knockback, disable chance): not implemented.

See [PROGRESS.md](../../PROGRESS.md) for the punch list.

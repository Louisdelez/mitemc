# 02 — Blocks & tools

How block-breaking gates work, and the exact tool tier matrix.

## Block-breaking — bare-hand restrictions

The most player-visible MITE rule: **you cannot break "real" blocks with your bare hands.**

When the player holds **nothing** or a non-tool item, the block-break speed is computed as:

| Target block | Effective speed |
|---|---|
| Logs (any wood) | -1.0 (impossible) |
| Stone non-cobblestone | -1.0 |
| Metal blocks (iron, gold, copper) | -1.0 |
| Ice / packed ice | -1.0 |
| Cobblestone family | 20.0 (very fast — explicit MITE buff) |
| Soil / grass / dirt / sand | × 0.75 (slower than vanilla, still possible) |
| Plant blocks | vanilla speed |
| Block has no block entity | ×0.05 if base speed ≤ 1 (very slow) |

A "non-tool" item is any item that does not implement `ToolItem` / `TridentItem`. Holding, e.g., a torch counts as bare-hand for break-speed purposes.

## Block-breaking — wrong tier penalty

When a tool of insufficient tier hits a block:

| Scenario | Speed |
|---|---|
| Stone tool on logs (any wood) | -1.0 (impossible) |
| Stone pickaxe on regular stone (non-cobblestone variant) | -1.0 |
| Right-tier tool on cobblestone | min 20.0 (always fast) |

This is on top of the vanilla "incorrect tool" penalty.

## Block hardness modifiers (vs. vanilla)

MITE-RB-2025 retunes several vanilla blocks. Cross-checked highlights:

| Block | Vanilla hardness | MITE hardness | Note |
|---|---:|---:|---|
| Cobblestone | 2.0 | unchanged | But always fast-break (see above) |
| Stone | 1.5 | unchanged | But unbreakable without correct tool tier |
| Logs (Oak, Birch, etc.) | 2.0 | unchanged | Stone-axe minimum |
| Iron block | 5.0 | unchanged | Iron-pickaxe minimum |
| MITE Log Block | (custom) | 2.0 | Replaces vanilla log; same hardness, stricter tool gate |

## Tool tier reference table

Cross-checked from `MITE-RB-2025/items/SurvivalItemTier.java`. Each tool is an enum entry of `(harvestLevel, maxUses, efficiency, attackDamage, enchantability, repairItem)`.

### Pickaxes

| Material | Mining lvl | Base uses | Efficiency | Att. dmg | Enchant. | Repair |
|---|---:|---:|---:|---:|---:|---|
| Wood | 0 | 10 | 2.0 | 0.0 | 15 | Planks |
| Flint | 0 | 8 | 2.0 (min clamp) | 0.0 | 15 | (placeholder repair) |
| Stone | 1 | 3 | 2.0 (min) | 1.0 | 5 | Cobblestone |
| Copper | 2 | 15 | 2.0 (min) | 1.5 | 14 | Copper ingot |
| Iron | 2 | 50 | 3.0 | 2.0 | 14 | Iron ingot |
| Diamond | 3 | 150 | 4.0 | 3.0 | 10 | Diamond |
| Gold | 0 | 15 | 3.0 | 0.0 | 22 | Gold ingot |

### Axes

| Material | Mining lvl | Base uses | Efficiency | Att. dmg | Enchant. |
|---|---:|---:|---:|---:|---:|
| Wood | 0 | 10 | 2.0 | 0.0 | 15 |
| Flint | 0 | 8 | 2.0 (min) | 0.0 | 15 |
| Stone | 1 | 3 | 2.0 (min) | 1.0 | 5 |
| Copper | 2 | 15 | 2.0 (min) | 1.5 | 14 |
| Iron | 2 | 50 | 3.0 | 2.0 | 14 |
| Diamond | 3 | 150 | 4.0 | 3.0 | 10 |
| Gold | 0 | 15 | 3.0 | 0.0 | 22 |

### Hatchets

A "hatchet" is a smaller axe: same `maxUses` value but multiplied by **3/8**.

| Material | Effective durability |
|---|---:|
| Wood | 3 |
| Flint | 3 |
| Stone | 1 |
| Copper | 5 |
| Iron | 18 |
| Diamond | 56 |
| Gold | 5 |

### Swords

Sword durability multiplier: **9/8** (sturdiest).

| Material | Effective durability | Att. dmg |
|---|---:|---:|
| Wood | 11 | 0.0 |
| Flint | 9 | 0.0 |
| Stone | 3 | 1.0 |
| Copper | 33 (base 30) | 1.5 |
| Iron | 56 | 2.0 |
| Diamond | 168 | 3.0 |
| Gold | 16 | 0.0 |

### Knives (short swords)

Knife durability multiplier: **4/8** = ½.

| Material | Effective durability |
|---|---:|
| Wood | 5 |
| Flint | 4 |
| Stone | 1 |
| Copper | 10 |
| Iron | 25 |
| Diamond | 75 |
| Gold | 7 |

### Hoes

Hoe durability multiplier: **6/8** = ¾.

| Material | Effective durability |
|---|---:|
| Wood | 7 |
| Flint | 6 |
| Stone | 2 |
| Copper | 11 |
| Iron | 37 |
| Diamond | 112 |
| Gold | 11 |

### Shovels

Shovel durability multiplier: **12/8** = 1.5×.

| Material | Effective durability |
|---|---:|
| Wood | 12 |
| Flint | 30 |
| Stone | 4 |
| Copper | 45 |
| Iron | 75 |
| Diamond | 225 |
| Gold | 22 |

## Efficiency clamp

Note in `SurvivalItemTier`: any tool with `efficiency < 2.0` is clamped to **2.0**. This means stone tools (which would be 1.0) effectively run at 2.0 for mining-speed purposes.

## Mining levels

| Level | Material | Examples |
|---:|---|---|
| 0 | Wood, Flint, Gold | Punch sand, dirt, soil |
| 1 | Stone | Coal, lapis, redstone-ish |
| 2 | Copper, Iron | Iron ore, gold ore |
| 3 | Diamond | Diamond ore, ancient debris-style |

This is the same scale as vanilla 1.16-era harvest levels. MITE keeps it.

## Tool decay rates

`MITE-RB-2025/main/resources/ToolDecayRates.java` (706 lines) contains a per-(tool, block) durability cost table. Highlights:

- Breaking a block of hardness `H` with a tool of efficiency `E` costs roughly `floor(H / E)` durability.
- Stone tools take **3-4× more damage** than vanilla per block break.
- Diamond tools are **at parity** with vanilla.
- Hatchets/Knives wear faster than full axes/swords (per their durability multipliers).

The full matrix is too long to inline here; see the source for verification.

## Block tags MITE introduces

| Tag | Members |
|---|---|
| `mite_log` | All MITE-replaced logs (oak/birch/etc. via `MITELogBlock`) |
| `mite_grass` | Grass blocks that have a "tilled / dead" variant |
| `gravel_variants` | Gravel-like blocks that share the speed×0.75 modifier |

## Delta vs. vanilla — block-breaking summary

| Vanilla | MITE |
|---|---|
| Bare hand: works on most blocks (slow) | Bare hand: -1.0 on logs / stone / metal / ice |
| Cobblestone: stone-tier | Cobblestone: explicitly fast-break (≥ 20.0) |
| Tool tiers: 4 levels | 4 levels but with copper inserted at level 2 alongside iron, retuned durabilities |
| Wood pickaxe valid for stone | Same (vanilla) |
| Stone pickaxe valid for stone variants | Stone pickaxe blocked from non-cobblestone stone |

## In MITEMC implementation

- `BareHandRestrictionHandler` — handles the bare-hand block-break penalty via `PlayerEvent.BreakSpeed`.
- `ModToolTiers` — currently uses placeholder values; needs to be retuned to match the table above.
- The full per-(tool, block) durability cost matrix is on the punch list (Phase 2.5).

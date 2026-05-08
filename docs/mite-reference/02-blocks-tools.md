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

## Tool durability (post-MITE retuning)

MITE re-tunes vanilla tool durability with massive scaling. The values below are the actual maxDamage values applied at runtime by `VanillaTweaks`:

### Vanilla tools

| Tool | Vanilla | MITE | Multiplier |
|---|---:|---:|---:|
| Wooden shovel | 59 | 200 | 3.4× |
| Stone pickaxe / axe | 131 | 900 | 6.9× |
| Stone shovel | 131 | 200 | 1.5× |
| Iron shovel | 250 | 3 200 | 12.8× |
| Iron pickaxe | 250 | 9 600 | 38.4× |
| Iron axe | 250 | 9 600 | 38.4× |
| Iron sword | 250 | 6 400 | 25.6× |
| Iron hoe | 250 | 6 400 | 25.6× |
| Golden shovel | 32 | 1 600 | 50× |
| Golden pickaxe | 32 | 4 800 | 150× |
| Golden axe | 32 | 4 800 | 150× |
| Golden sword | 32 | 3 200 | 100× |
| Golden hoe | 32 | 3 200 | 100× |
| Anvil | 1 | **396 800** | 396 800× |

> The anvil number isn't a typo — MITE makes anvils essentially permanent.

### Items deliberately nerfed

| Item | Vanilla | MITE | Effect |
|---|---:|---:|---|
| Bow | 384 | 32 | Bows break very fast |
| Flint and steel | 64 | 16 | Lighter has 16 uses |
| Fishing rod | 64 | 16 | Few casts before snapping |
| Carrot on a stick | 25 | 25 | unchanged |
| Warped fungus on stick | 25 | 25 | unchanged |
| Shears | 238 | 6 400 | (buffed instead) |

### Vanilla armor — MITE values

| Piece | Vanilla | MITE | Note |
|---|---:|---:|---|
| Leather helmet | 55 | 10 | Crumbles fast |
| Leather chestplate | 80 | 16 | |
| Leather leggings | 75 | 14 | |
| Leather boots | 65 | 8 | |
| Chainmail helmet | 165 | 40 | |
| Chainmail chestplate | 240 | 64 | |
| Chainmail leggings | 225 | 56 | |
| Chainmail boots | 195 | 32 | |
| Gold helmet | 77 | 40 | |
| Gold chestplate | 112 | 64 | |
| Gold leggings | 105 | 56 | |
| Gold boots | 91 | 32 | |

(Iron / diamond / netherite armor durabilities unchanged from vanilla.)

### MITE-added tools

| Tool | Durability |
|---|---:|
| Flint hatchet | 400 |
| Flint shovel | 400 |
| Flint axe | 1 200 |
| Flint knife | 400 |
| Spear (basic) | 1 200 |
| Wooden cudgel | 200 |
| Wooden club | 400 |
| Copper pickaxe | 4 800 |
| Copper axe | 4 800 |
| Copper hoe | 3 200 |
| Copper sword | 3 200 |
| Copper shovel | 1 600 |
| Copper knife | 1 600 |
| Copper hatchet | 1 600 |
| Copper spear | 3 200 |
| Silver pickaxe | 4 800 |
| Silver axe | 4 800 |
| Silver hoe | 3 200 |
| Silver sword | 3 200 |
| Silver shovel | 1 600 |
| Silver knife | 1 600 |
| Silver hatchet | 1 600 |
| Silver spear | 3 200 |

> Mithril and adamantium tiers are part of Avernite's original design (not in MITE-RB-2025); the MITEMC port targets the full chain.

## Vanilla block strength retunes

`VanillaTweaks` reduces several vanilla block strengths to make foraging / harvesting flow better in survival:

| Block | Vanilla strength | MITE strength |
|---|---:|---:|
| Lily pad | 0 | 0.08 |
| Grass / tall grass | 0 | 0.08 |
| Dead bush | 0 | 0.08 |
| Sweet berry bush | 0 | 0.03 |
| Sugar cane | 0 | 0.25 |
| Seagrass / tall seagrass | 0 | 0.08 |
| Kelp / kelp plant | 0 | 0.25 |
| Obsidian | 50 | **0.5** (massive nerf) |
| Furnace | 3.5 | 0.2 (massive nerf) |
| Crafting table | 2.5 | 0.25 |
| Hay block | 0.5 | 0.1 |

This makes obsidian / furnaces breakable bare-handed in seconds. Combined with the bare-hand restrictions table above (which makes other blocks impossible), this carves out specific player flows.

## Stack size limits

MITE caps most stacks at **32 max** instead of vanilla 64. Specific rules from `VanillaTweaks.ChangeStackSizes()`:

### Block items default to 4

Most placeable blocks stack to only **4 per slot** (bonus inventory pressure).

### Block-item exceptions

| Stack size | Items |
|---:|---|
| 32 | Plant blocks, grass, fern, dead bush, snow, lily pad, kelp, dried kelp, honeycomb |
| 8 | Cobblestone, all planks, all wool colors, slabs, stairs, pressure plates, fences, ladder, rails, pumpkin, melon, vines, carpets, MITE log blocks |
| 16 | Saplings, torches, redstone torches, lanterns, soul lanterns, iron bars, stained glass panes, paintings, signs, redstone, repeater, comparator, flower pot, item frame, carrot, potato, skull blocks |
| 4 (default) | Everything else (stone, dirt, ores, etc.) |

### Item exceptions (non-block)

| Stack size | Items |
|---:|---|
| 64 | Wheat seeds, paper, pumpkin seeds, melon seeds, gold/copper/silver/iron nuggets, flint shards, nether wart |
| 32 | Default (most non-block items) |
| 16 | Iron / gold / copper / silver / netherite / mithril ingots, apple, coal, charcoal, charred food, bowl, string, feather, gunpowder, wheat, bread, flint, porkchop / cooked porkchop, painting, golden apple / enchanted golden apple, snowball, leather, clay ball, sugar cane, book, slime ball, egg, cooked egg, compass, clock, glowstone dust, cod / cooked cod, all foods (except stews), all dyes, blaze rod, ghast tear, spider eye, fermented spider eye, rock |
| 8 | Bucket |
| 1 | Stews (per vanilla — already 1) |

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

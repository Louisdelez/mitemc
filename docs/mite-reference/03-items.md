# 03 — Items, food, materials

The full item catalog and food-nutrient profiles.

## Item categories MITE adds

The items below are introduced or retuned in `MITE-RB-2025`. Items not listed are vanilla.

### Tools (per material × type, see [02-blocks-tools.md](./02-blocks-tools.md))

7 materials × 7 tool types = 49 tool items:
- Materials: Wood, Flint, Stone, Copper, Iron, Diamond, Gold
- Tool types: Pickaxe, Axe, Hatchet (small axe), Sword, Knife (short sword), Hoe, Shovel

Plus Avernite's wider arsenal (registered separately, names from `ItemRegistry`):

| Item | Notes |
|---|---|
| **Cudgel** (`CudgelItem`) | Wooden — primitive blunt weapon. Reach +0.25. |
| **Club** (`ClubItem`) | Wooden — heavier blunt weapon. Reach +0.5. |
| **Branch** (`BRANCH`) | Foraged item, used for crafting and as a stand-in long stick. Reach +1.0. |
| **War hammer** (`MiteWarhammerItem`) | Heavy crushing weapon. Reach +0.75. |
| **Mattock** (`MiteMattockItem`) | Pickaxe + shovel combo. Reach +0.75. |
| **Scythe** (`ScytheItem`) | Wide-arc plant harvester. Reach +1.0. |
| **Spear** (`SpearItem`) | Long melee/throw weapon. Reach +1.25. |

### Foraging items

| Item | Source | Use |
|---|---|---|
| Stick | Vanilla, but also drops from leaves | Crafting |
| Branch | Random spawn on the ground / tree generation | Crafting reach-bonus item |
| Flint | Gravel + handcrafting | Tool cores |
| Sifter | Hand-craftable filtering tool | Process gravel into flint, etc. |

### Food / cookery items

| Item | Description |
|---|---|
| Custom Bowl | Reusable container for stews / soups |
| Custom Egg | Egg item with nutrition profile |
| Compost | Agricultural fertilizer |
| MITE Cake | Cake with multi-nutrient profile |
| (many more — see `ItemRegistry`) |  |

## Food nutrient profiles — complete table

Every food item registered in `MITE-RB-2025/registry/NutrientsRegistry.java`. Values shown as `(F V G D P)` for **F**ruits / **V**egetables / **G**rain / **D**airy / **P**rotein. When the player eats the item, each value is added to the corresponding saturation (capped at 5.0).

> Items not listed here add 0 to all 5 categories (the `DEFAULT` Nutrients entry).

### Vanilla foods (with MITE nutrient profiles)

| Item | F | V | G | D | P |
|---|---:|---:|---:|---:|---:|
| Apple | 2 | 0 | 0 | 0 | 0 |
| Golden apple | 4 | 0 | 0 | 0 | 0 |
| Enchanted golden apple | 4 | 0 | 0 | 0 | 0 |
| Sweet berries | 1 | 0 | 0 | 0 | 0 |
| Glow berries | 3 | 0 | 0 | 0 | 0 |
| Melon | 2 | 0 | 0 | 0 | 0 |
| Glistering melon slice | 4 | 0 | 0 | 0 | 0 |
| Melon seeds | 1 | 0 | 0 | 0 | 0 |
| Pumpkin pie | 0 | 4 | 2 | 3 | 2 |
| Pumpkin seeds | 0 | 1 | 1 | 0 | 1 |
| Carrot | 0 | 1 | 0 | 0 | 0 |
| Golden carrot | 0 | 4 | 0 | 0 | 1 |
| Potato (raw) | 0 | 2 | 2 | 0 | 1 |
| Baked potato | 0 | 3 | 4 | 0 | 3 |
| Beetroot | 0 | 2 | 0 | 0 | 0 |
| Beetroot soup | 0 | 4 | 0 | 0 | 0 |
| Bread | 0 | 1 | 4 | 0 | 0 |
| Wheat seeds | 0 | 1 | 1 | 0 | 0 |
| Cake (slice) | 0 | 0 | 3 | 4 | 0 |
| Cookie | 0 | 0 | 3 | 0 | 2 |
| Mushroom stew | 0 | 2 | 0 | 0 | 2 |
| Brown mushroom | 0 | 1 | 0 | 0 | 1 |
| Red mushroom | 0 | 1 | 0 | 0 | 1 |
| Kelp | 0 | 1 | 0 | 0 | 0 |
| Dried kelp | 0 | 1 | 0 | 0 | 0 |
| Spider eye | 0 | 0 | 0 | 0 | 1 |
| Egg | 0 | 0 | 0 | 0 | 1 |
| Honey bottle | 0 | 0 | 0 | 0 | 2 |
| Honeycomb | 0 | 0 | 0 | 0 | 2 |
| Milk bucket | 0 | 0 | 0 | 4 | 0 |
| Beef (raw) | 0 | 0 | 0 | 0 | 2 |
| Cooked beef | 0 | 0 | 0 | 0 | 4 |
| Mutton (raw) | 0 | 0 | 0 | 0 | 2 |
| Cooked mutton | 0 | 0 | 0 | 0 | 4 |
| Porkchop (raw) | 0 | 0 | 0 | 0 | 2 |
| Cooked porkchop | 0 | 0 | 0 | 0 | 4 |
| Rabbit (raw) | 0 | 0 | 0 | 0 | 1 |
| Cooked rabbit | 0 | 0 | 0 | 0 | 3 |
| Chicken (raw) | 0 | 0 | 0 | 0 | 1 |
| Cooked chicken | 0 | 0 | 0 | 0 | 3 |
| Cod (raw) | 0 | 0 | 0 | 0 | 1 |
| Cooked cod | 0 | 0 | 0 | 0 | 3 |
| Salmon (raw) | 0 | 0 | 0 | 0 | 1 |
| Cooked salmon | 0 | 0 | 0 | 0 | 3 |
| Tropical fish | 0 | 0 | 0 | 0 | 1 |

### MITE-added foods

| Item | F | V | G | D | P |
|---|---:|---:|---:|---:|---:|
| Sweet berries (MITE variant) | 1 | 0 | 0 | 0 | 0 |
| Orange | 2 | 0 | 0 | 0 | 0 |
| Banana | 2 | 0 | 0 | 0 | 0 |
| Banana split | 1 | 1 | 0 | 1 | 0 |
| Blueberries | 1 | 0 | 0 | 0 | 0 |
| Blueberry muffin | 1 | 0 | 1 | 0 | 0 |
| Cherries | 1 | 0 | 0 | 0 | 0 |
| Lemon | 1 | 0 | 0 | 0 | 0 |
| Sorbet | 3 | 0 | 0 | 0 | 0 |
| Onion | 0 | 1 | 0 | 0 | 0 |
| Salad | 0 | 2 | 1 | 0 | 0 |
| Mashed potatoes | 0 | 2 | 2 | 3 | 1 |
| Vegetable soup | 0 | 4 | 2 | 0 | 4 |
| Cream of vegetable soup | 0 | 4 | 2 | 2 | 1 |
| Cream of mushroom soup | 0 | 2 | 0 | 2 | 2 |
| Pumpkin soup | 2 | 2 | 0 | 0 | 1 |
| Chicken soup | 1 | 2 | 0 | 0 | 2 |
| Beef stew | 0 | 3 | 0 | 0 | 4 |
| Porridge | 1 | 1 | 1 | 0 | 0 |
| Cereal | 0 | 0 | 1 | 1 | 0 |
| Brownie | 0 | 0 | 1 | 0 | 0 |
| Cookie dough | 0 | 0 | 2 | 0 | 0 |
| Cheese | 0 | 0 | 0 | 2 | 0 |
| Ice cream | 0 | 0 | 0 | 2 | 0 |
| Chocolate ice cream | 0 | 1 | 0 | 1 | 0 |
| Milk bowl | 0 | 0 | 0 | 2 | 0 |
| Bacon (raw) | 0 | 0 | 0 | 0 | 1 |
| Cooked bacon | 0 | 0 | 0 | 0 | 2 |
| Cooked egg | 0 | 0 | 0 | 0 | 2 |
| Raw worm | 0 | 0 | 0 | 0 | 1 |
| Cooked worm | 0 | 0 | 0 | 0 | 1 |
| Turkey (raw) | 0 | 0 | 0 | 0 | 1 |
| Cooked turkey | 0 | 0 | 0 | 0 | 3 |
| Flax seeds | 0 | 1 | 1 | 0 | 1 |
| Flour | 0 | 0 | 1 | 0 | 0 |
| Dough | 0 | 0 | 1 | 0 | 0 |

### Items with no nutrient profile

Compost, custom bowl (empty), books, raw materials, tools — all default to `(0 0 0 0 0)`.

## Inventory weight system

Each item has an integer weight. The total inventory weight modifies movement speed (see [01-player.md § Inventory weight](./01-player.md#inventory-weight-carry-slowdown)).

### Weight derivation rules

#### Block items (computed from block material)

| Material | Base weight |
|---|---:|
| Stone | 8 |
| Metal | 20 |
| Wood | 4 |
| Ice | 3 |
| Dense ice | 5 |
| Gourd (pumpkin/melon) | 3 |
| Nether wood | 7 |
| Piston | 10 |
| Redstone lamp | 8 |
| Amethyst | 5 |
| Shulker box | 40 |
| Soil (dirt/grass/sand) | 10 |
| Wool | 3 |

#### Block-name modifiers (additive to base material)

| Name contains | Weight delta |
|---|---:|
| `iron` | +10 |
| `copper` | +5 |
| `silver` | +5 |
| `deepslate` | +2 |
| `mithril` | +10 |
| `ancient_metal` | +10 |
| `netherrite` | +20 |
| `adamantium` | +20 |
| `log` | +5 |

#### Block-name overrides (replace value)

| Name contains | Weight |
|---|---:|
| `plank` | 2 |
| `button` | 1 |

#### Block-shape modifiers (multiplicative)

| Shape | Multiplier |
|---|---|
| `stair` | × 0.5 |
| `slab` | × 0.25 |

### Item weights (non-block)

Default item weight: **1**. Modifiers stack:

| Material/category | Delta |
|---|---:|
| Iron-named | +7 |
| Copper-named | +5 |
| Silver-named | +5 |
| Flint-named | +1 |
| Gold-named | +12 |
| Mithril-named | +8 |
| Netherrite-named | +15 |
| Adamantium-named | +15 |
| Stone-named | +8 |
| Wood-named | +3 |
| Lapis-named | +2 |
| Nether-named | +3 |
| Warped-named | +4 |
| Crimson-named | +4 |
| Leather-named | +3 |

(Nuggets and chips are exempted from these material modifiers — they keep weight 1.)

### Item-class overrides

| Item type | Weight |
|---|---:|
| Shield | 5 |
| Ender pearl | 1 |
| Ender eye | 2 |
| Blaze rod | 1 |
| Clay ball | 1 |
| Brick | 2 |
| Wheat | 1 |
| Bucket (empty) | 4 |
| Water bucket | 5 |
| Milk bucket | 5 |
| Lava bucket | 5 |
| Bowl | 1 |
| Stew item (any soup/stew) | 1 |
| Elytra | 3 |
| Bow | 3 |
| Trident | 5 |
| Nautilus shell | 1 |
| Book / writable / written / enchanted | 2 |
| Golden apple | 15 |
| Enchanted golden apple | 20 |
| Fishing rod | 4 |
| Carrot on stick | 5 |
| Warped fungus on stick | 5 |
| Saddle | 5 |
| Horse armor | base + 5 |
| Chain | 3 |
| Lapis lazuli | 3 |
| Shears | 4 |
| Leather | 2 |

### Final modifiers (multiplicative, applied at end)

| Trigger | Multiplier |
|---|---|
| Name contains `ingot` | × 0.5 |
| `isFood()` returns true | + 2 (additive) |
| Tool item | × 1.2 |
| Hoe | × 0.75 (further) |
| Axe | × 1.1 (further) |
| Shovel | × 0.75 (further) |
| Spear | + 5 (additive) |
| Armor | × 1.5 |
| Armor — head slot | × 0.5 |
| Armor — legs slot | × 0.8 |
| Armor — feet slot | × 0.4 |
| (Armor — chest slot keeps the × 1.5 base) | — |

### Examples

| Item | Computed weight |
|---|---:|
| Wood plank | 2 |
| Cobblestone | 8 |
| Iron block | 20 + 10 = **30** |
| Iron ingot | 1 + 7 = 8, × 0.5 (ingot) = **4** |
| Iron pickaxe | (1 + 7) × 1.2 = **9.6 ≈ 9** |
| Iron axe | (1 + 7) × 1.2 × 1.1 = **10.56 ≈ 10** |
| Iron shovel | (1 + 7) × 1.2 × 0.75 = **7.2 ≈ 7** |
| Iron helmet | (1 + 7) × 1.5 × 0.5 = **6** |
| Iron chestplate | (1 + 7) × 1.5 = **12** |
| Iron leggings | (1 + 7) × 1.5 × 0.8 = **9.6 ≈ 9** |
| Iron boots | (1 + 7) × 1.5 × 0.4 = **4.8 ≈ 4** |
| Diamond | 1 (no material modifier in item name as written) — verify in source |
| Cooked beef | 1 + 2 (food) = **3** |
| Mithril ingot | (1 + 8) × 0.5 = **4.5 ≈ 4** |
| Adamantium pickaxe | (1 + 15) × 1.2 = **19.2 ≈ 19** |
| Trident | 5 + 5 (spear-class) = **10** |

The `MAX_CARRY` constant determines the cap; movement speed degrades linearly between 65% and 100% of cap, then stays at 0.8× speed beyond.

## Materials

| Material | Acquired from | Used for |
|---|---|---|
| **Stick** | Crafting from planks; drops from leaves | Tool handles, cudgel, etc. |
| **Branch** | Found on ground / tree gen | Spear, scythe handles |
| **Flint** | Gravel (or sifter) | Flint tools — flint era |
| **Cobblestone** | Mining stone | Cobble tools, basic structures |
| **Stone** | Mining + smelting cobble | Decorative |
| **Copper ingot** | Smelting copper ore | Copper tools (intermediate) |
| **Iron ingot** | Smelting iron ore | Iron tools |
| **Gold ingot** | Smelting gold ore | Gold tools, decorative |
| **Diamond** | Mining diamond ore | Diamond tools |

In the **original MITE 1.6.4 by Avernite**, additional metals existed:

- **Silver** — between iron and mithril
- **Mithril** — high-tier, magical
- **Adamantium** — top-tier, mythic age

These are part of the canonical MITE design; `MITE-RB-2025` simplifies by sticking with vanilla materials. The MITEMC port keeps Avernite's full chain (silver / mithril / adamantium) as the target.

## Crafting recipes (MITE deviations from vanilla)

Common changes:

| Recipe | Change |
|---|---|
| **Pickaxe** | Recipe pattern unchanged but requires the "MITE crafting table" (handcraft for stone-tier and below); MITE adds a custom UI for selecting variants |
| **Stick** | Now also obtainable from leaves (passive drop) |
| **Bowl** | Reusable across recipes |
| **Compost** | New recipe combining plant matter + dirt |
| **Branch + handle items** | New crafting paths |

Many recipes use the MITE crafting select screen (`screens/CraftingSelectScreen.java`) which extends vanilla crafting with category filtering and a recipe book.

## Smelting

Smelting follows MITE's tiered furnace progression (which Avernite's original design enforced even though `MITE-RB-2025` simplified to vanilla furnaces):

| Furnace | Capable of |
|---|---|
| Vanilla furnace | Cooking + iron-tier and below |
| Obsidian furnace | + mithril-tier |
| Netherrack furnace | + adamantium-tier |

In the original Avernite mod, attempting to smelt mithril/adamantium in a vanilla furnace silently fails. The intermediate clay/sandstone ovens were available for cooking only.

## Item categorization

For inventory and creative tab purposes, MITE-RB-2025 uses these categories:

- Tools (pickaxes, axes, swords, etc.)
- Food (raw/cooked/processed)
- Materials (ingots, ores, gems)
- Crafting (sticks, branches, etc.)
- Decorative
- Special (compost, sifter, custom UI items)

## In MITEMC implementation

- **Tools registered**: 50 (10 families × 5 materials), but with placeholder stat values. Need to be retuned per the [02-blocks-tools.md](./02-blocks-tools.md) tables.
- **Food nutrient system**: not yet implemented (would require Capability rewriting + custom HUD).
- **Crafting select UI**: not yet implemented (would require custom client-side Screen).
- **Sifter / branch / cudgel / club**: not yet registered.

See [PROGRESS.md](../../PROGRESS.md) for the punch list.

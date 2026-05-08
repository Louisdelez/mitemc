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

## Food nutrient profiles

Each food item, when eaten, distributes points across the 5 hunger categories.
Cross-checked from `MITE-RB-2025/registry/NutrientsRegistry.java`.

> Format: `(Fruits | Vegetables | Grain | Dairy | Protein)` — values are added to current saturation, capped at 5.0.

### Vanilla food retuned

| Item | Fruits | Veg | Grain | Dairy | Protein |
|---|---:|---:|---:|---:|---:|
| Apple | 2 | 0 | 0 | 0 | 0 |
| Carrot | 0 | 2 | 0 | 0 | 0 |
| Potato (raw) | 0 | 1 | 0 | 0 | 0 |
| Baked potato | 0 | 2 | 1 | 0 | 0 |
| Bread | 0 | 0 | 3 | 0 | 0 |
| Wheat | 0 | 0 | 1 | 0 | 0 |
| Cookie | 0 | 0 | 1 | 1 | 0 |
| Beetroot | 0 | 1 | 0 | 0 | 0 |
| Beetroot soup | 0 | 3 | 0 | 0 | 0 |
| Mushroom stew | 0 | 2 | 0 | 0 | 0 |
| Sweet berries | 1 | 0 | 0 | 0 | 0 |
| Glow berries | 1 | 0 | 0 | 0 | 0 |
| Melon slice | 1 | 0 | 0 | 0 | 0 |
| Pumpkin pie | 1 | 1 | 1 | 1 | 0 |
| Cake (slice) | 0 | 0 | 1 | 2 | 0 |
| Milk bucket | 0 | 0 | 0 | 3 | 0 |
| Cooked beef | 0 | 0 | 0 | 0 | 3 |
| Beef raw | 0 | 0 | 0 | 0 | 1 |
| Cooked porkchop | 0 | 0 | 0 | 0 | 3 |
| Cooked chicken | 0 | 0 | 0 | 0 | 2 |
| Raw chicken | 0 | 0 | 0 | 0 | 1 |
| Cooked salmon | 0 | 0 | 0 | 0 | 2 |
| Cooked cod | 0 | 0 | 0 | 0 | 2 |
| Egg | 0 | 0 | 0 | 1 | 1 |

> Exact values may differ slightly between MITE-RB-2025 and original MITE; the structure is the canonical one.

### Special MITE foods

| Item | Fruits | Veg | Grain | Dairy | Protein | Note |
|---|---:|---:|---:|---:|---:|---|
| MITE Cake | 1 | 1 | 2 | 2 | 0 | Multi-nutrient |
| Compost | 0 | 0 | 0 | 0 | 0 | Not eaten — used as fertilizer |
| Custom Egg | 0 | 0 | 0 | 1 | 1 | |

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

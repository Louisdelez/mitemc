# 07 — Crafting & recipes

How crafting flows differ from vanilla, and the recipe catalog.

## Crafting infrastructure deltas

### MITE crafting table

`MITECraftingTableBlock` replaces the vanilla crafting table for some recipe categories. Strength is reduced (0.25 vs vanilla 2.5), making it bare-hand-breakable in seconds — but it gates higher-tier recipes that the vanilla table cannot fulfill.

### Custom crafting select screen

`CraftingSelectScreen` (235 lines, client-side `Screen` subclass) provides a recipe browser and selector overlaying the vanilla 3×3 grid:

| Property | Value |
|---|---|
| Texture | `mite:textures/gui/container/crafting.png` |
| Window dimensions | 176 × 166 px |
| Inventory slots displayed | 9 hotbar + 27 main = 36 slots, 18 px each |
| Animated 3D crafting table preview | Yes — rotates per `crafting_yaw`, `crafting_pitch` |
| Slot hover highlight | `0x80808080` overlay rectangle |
| Selected-slot indicator | Texture region (176, 30, 16, 16) |
| Pause game when open | No (`isPauseScreen()` returns false) |
| Inventory key (E) closes screen | Yes |

The 3D crafting table is rendered live on screen via the `EntityRenderDispatcher` infrastructure, with a fixed pitch of -30° and adjustable yaw.

### Cooking recipe serializer

`CookingRecipeSerializerMixin` (118 lines) modifies how furnace/smelting recipes are deserialized to support MITE's tier-aware fuel system.

## Vanilla recipe deltas

| Recipe | Vanilla | MITE |
|---|---|---|
| Wooden pickaxe | 3 planks + 2 sticks | Same shape; available bare-hand |
| Stone pickaxe | 3 cobble + 2 sticks | Same shape; needs MITE crafting select |
| Iron pickaxe | 3 iron + 2 sticks | Same; iron-tier required |
| Crafting table | 4 planks | Same — but block strength now 0.25 |
| Furnace | 8 cobble | Same — but strength now 0.2 |
| Stick | 2 planks | Same — also drops from leaves passively |
| Bowl | 3 planks | Same — but reusable across stews |

## MITE-added crafting recipes

### Foraging-tier (bare-hand crafting, no table needed)

| Recipe | Inputs | Output |
|---|---|---|
| Flint shard | 2× flint (2x1 grid) | 4 flint shards |
| Sifter | 4 sticks + 2 planks (specific pattern) | 1 sifter |
| Cudgel | 1 stick + 1 stone (or wood-only variant) | 1 wooden cudgel |
| Branch | (passively spawn — not crafted) | — |

### Stone-tier (MITE crafting table required)

| Recipe | Inputs | Output |
|---|---|---|
| Flint hatchet | 1 flint + 1 stick | 1 flint hatchet |
| Flint shovel | 1 flint + 2 sticks | 1 flint shovel |
| Flint axe | 3 flint + 2 sticks | 1 flint axe |
| Flint knife | 1 flint shard + 1 stick | 1 flint knife |
| Stone tools (vanilla shapes, MITE crafting table required) | Per vanilla | Per vanilla |
| Wooden club | 2 planks + 1 stick | 1 wooden club |

### Iron-tier and beyond

Standard vanilla recipes apply for iron / gold / diamond / netherite tools and armor. MITE-RB-2025 adds copper and silver intermediates:

| Recipe | Inputs | Output |
|---|---|---|
| Copper pickaxe | 3 copper ingot + 2 sticks | 1 copper pickaxe |
| Copper axe | 3 copper ingot + 2 sticks | 1 copper axe |
| Copper sword | 2 copper ingot + 1 stick | 1 copper sword |
| Copper shovel | 1 copper ingot + 2 sticks | 1 copper shovel |
| Copper hoe | 2 copper ingot + 2 sticks | 1 copper hoe |
| Copper hatchet | 2 copper ingot + 2 sticks | 1 copper hatchet |
| Copper knife | 1 copper ingot + 1 stick | 1 copper knife |
| Copper spear | 2 copper ingot + 2 sticks (vertical) | 1 copper spear |
| (Silver — same patterns as copper, with silver ingot input) | | |

### MITE-specific tools (any material)

| Recipe | Inputs | Output |
|---|---|---|
| War hammer | 5 metal + 1 stick (T-shape) | 1 war hammer |
| Mattock | 2 metal + 1 stick (split pick + shovel head) | 1 mattock |
| Scythe | 3 metal + 1 stick + 1 branch | 1 scythe |
| Spear | 2 metal + 1 stick (long stick variant) | 1 spear |
| Custom bowl | 4 sticks + 1 plank (deeper bowl) | 1 custom bowl |

### Food / cookery

Most recipes use a "shapeless mixing" pattern — drop ingredients into the crafting grid in any order:

| Recipe | Inputs | Output |
|---|---|---|
| Salad | Carrot + lettuce + onion + custom bowl | 1 salad |
| Vegetable soup | Carrot + potato + onion + custom bowl | 1 vegetable soup |
| Beef stew | Cooked beef + carrot + potato + custom bowl | 1 beef stew |
| Mashed potatoes | 2 baked potato + milk bowl | 1 mashed potatoes |
| Cream of mushroom soup | 2 brown mushroom + custom bowl + milk | 1 cream of mushroom |
| Cream of vegetable soup | Carrot + potato + onion + milk + custom bowl | 1 cream of vegetable |
| Pumpkin soup | 1 pumpkin + custom bowl + onion | 1 pumpkin soup |
| Chicken soup | 1 cooked chicken + carrot + custom bowl | 1 chicken soup |
| Banana split | Banana + ice cream + cherries | 1 banana split |
| Sorbet | 3 fruit + ice | 1 sorbet |
| Cookie dough | 1 dough + 1 chocolate | 1 cookie dough (uncooked) |
| Brownie | 1 cookie dough → smelt | 1 brownie |
| Cereal | 1 wheat + 1 milk bowl | 1 cereal |
| Porridge | 2 wheat + 1 milk bowl | 1 porridge |
| Cheese | 1 milk bowl → time | 1 cheese |
| Ice cream | 1 milk bowl + 1 ice → place in cold biome | 1 ice cream |
| Compost | 4 plant matter + 1 dirt | 1 compost |
| Dough | 1 flour + 1 water bucket | 1 dough |
| Flour | 1 wheat → grind via custom action | 1 flour |
| Blueberry muffin | 1 blueberries + 1 dough | 1 blueberry muffin |
| Pumpkin pie | 1 pumpkin + 1 sugar + 1 egg + 1 wheat | 1 pumpkin pie (vanilla recipe matches) |

## Smelting deltas

### Furnace tier requirements

| Furnace block | Smelting tier max |
|---|---|
| Vanilla furnace | Iron-tier (cooked food, iron, gold, copper) |
| Obsidian furnace (Avernite original) | Mithril-tier |
| Netherrack furnace (Avernite original) | Adamantium-tier |

`MITE-RB-2025` ships only the vanilla furnace; the obsidian and netherrack furnaces are part of Avernite's original design (preserved in the MITEMC port target).

### Smelting recipes

| Input | Output | Time |
|---|---|---|
| Raw iron | Iron ingot | 200 t (10 s) |
| Raw copper | Copper ingot | 200 t |
| Raw gold | Gold ingot | 200 t |
| Iron ore | Iron ingot | 200 t |
| Cobblestone | Stone | 200 t |
| Sand | Glass | 200 t |
| Wood | Charcoal | 200 t |
| Raw chicken | Cooked chicken | 200 t |
| Raw beef | Cooked beef | 200 t |
| Raw porkchop | Cooked porkchop | 200 t |
| Raw cod | Cooked cod | 200 t |
| Raw salmon | Cooked salmon | 200 t |
| Raw rabbit | Cooked rabbit | 200 t |
| Raw mutton | Cooked mutton | 200 t |
| Cooked egg | (from raw egg, MITE-added recipe) | 200 t |
| Cooked bacon | (from raw bacon) | 200 t |
| Cooked turkey | (from raw turkey) | 200 t |
| Cooked worm | (from raw worm) | 200 t |
| Cookie dough | Brownie | 200 t |
| (charred food) | overcooked variant when left too long | — |

### Charred food mechanic

Food items left in furnace too long become "charred" (`ItemRegistry.CHARRED_FOOD`) — edible but with reduced nutrient profile. This requires the player to extract food in a timely window.

### Blasting / smoking

| Furnace block | Smelting type | Default speed multiplier |
|---|---|---|
| Vanilla furnace | smelting | 1.0× |
| Blast furnace | blasting | 2.0× (vanilla) |
| Smoker | smoking | 2.0× (vanilla) |

## Recipe gating per material/era

`MITE-RB-2025` doesn't strictly gate recipes by player progression beyond the tool tier requirement (you need a stone pickaxe to mine iron, etc.). Avernite's original MITE introduced explicit gating where high-tier ingredients couldn't be combined in primitive crafting tables.

The MITEMC port preserves the tier-gated furnace requirement (mithril needs obsidian furnace) but does not currently gate the crafting table itself.

## In MITEMC implementation

- **MITE crafting table block**: not implemented (vanilla crafting table only).
- **Custom crafting select screen**: not implemented.
- **Recipe gating**: tier-aware furnace gating implemented (Phase 3); tier-aware crafting table gating on the punch list.
- **Most MITE-added cookery recipes**: not registered. Onion, manure, lore book recipes exist; full cookery chain on the punch list.
- **Charred food mechanic**: not implemented.
- **Sifter as a usable tool**: not implemented.

See [PROGRESS.md](../../PROGRESS.md) for the punch list.

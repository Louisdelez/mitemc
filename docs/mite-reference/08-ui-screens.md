# 08 — UI & client-side screens

Custom GUIs and HUD elements MITE introduces.

## Crafting select screen

`screens/CraftingSelectScreen.java` (235 lines) — a custom recipe browser that overlays the vanilla 3×3 grid.

### Layout

| Property | Value |
|---|---|
| Texture asset | `mite:textures/gui/container/crafting.png` |
| Window size | 176 × 166 px (matches vanilla inventory chrome) |
| Position | Centered on screen (computed from `getScaledWidth/Height`) |
| Slot grid | 9 hotbar (bottom row) + 27 main inventory (3×9) |
| Slot pixel size | 18 × 18 px each, items rendered at 16 × 16 |
| Inventory slot offsets | Hotbar at y=142, main inv y=84/102/120 |
| Pause game | No |
| Close key | `keyInventory` (configurable, default E) |

### Visual features

| Feature | Behavior |
|---|---|
| Background | Texture region (0, 167, 88, 70) at offset (44, 8) |
| Foreground inventory chrome | Texture region (0, 0, 176, 166) |
| 3D crafting table preview | Live-rendered using `EntityRenderDispatcher` at center |
| Crafting table animation | Rotates per `crafting_yaw` and `crafting_pitch = -30°` |
| Hover highlight | Slot rect filled with `0x80808080` |
| Selected slot | Texture region (176, 30, 16, 16) overlay |
| Stack count | Drawn in lower-right of slot when count > 1 |

The 3D crafting table renders via `ItemEntity` machinery — a phantom `ItemEntity` is created with a crafting table stack, then `entityRenderDispatcher.render` draws it with custom matrix transformations (Z-translation 1050, scale 300, quaternion rotations from pitch/yaw).

### Mouse / keyboard handlers

| Input | Action |
|---|---|
| Mouse move | Updates `hovered_slot` based on cursor position |
| Left click | Sets `selected_slot = hovered_slot` |
| Inventory key (E) | Calls `onClose()` |

The screen does not implement vanilla's drag-to-spread or shift-click — it is purely for selection / browsing, not item movement.

## In-game HUD modifications

`mixin/client/InGameHudMixin` (184 lines) modifies the vanilla HUD to display MITE-specific state.

### Hunger HUD

The vanilla single-bar food display is replaced by a 5-segment indicator showing each nutrient category:

| Category | Visual |
|---|---|
| Fruits | Apple icon + saturation bar |
| Vegetables | Carrot icon + bar |
| Grain | Bread icon + bar |
| Dairy | Milk icon + bar |
| Protein | Steak icon + bar |

Each bar is 5 segments wide (matching saturation 0–5). The bars are stacked vertically on the right side of the HUD, displacing the vanilla armor / experience bars.

### Inventory weight indicator

A weight bar appears below the hotbar showing:
- Current carry weight
- Slowdown threshold (65 % of MAX_CARRY)
- Hard cap (MAX_CARRY)

When current weight exceeds the slowdown threshold, the bar turns yellow. Beyond MAX_CARRY: red.

### Cold / hot indicator

Small icon overlay in the corner when player is in a cold or hot biome:
- Snowflake when biome.temperature < 0.5
- Sun when biome.temperature > 1.5 OR ultrawarm dimension

### Day counter

The HUD optionally shows the in-game day number (configurable). MITE uses this to drive the moon-phase mechanics (`MoonHelper.IsBlueMoon(day_time)`).

## Inventory screen modifications

`mixin/client/InventoryScreenMixin` (200 lines) adds:

- **Weight per item tooltip** — hovering an item shows its weight contribution
- **Total inventory weight** displayed at top of inventory
- **Nutrient profile preview** — hovering a food item shows its (F/V/G/D/P) values
- **Tier badge** on tools — small icon indicating mining level (0/1/2/3)

## Crafting screen mixin

`mixin/client/CraftingScreenMixin` (147 lines) adds the recipe-select button and integrates `CraftingSelectScreen` as an overlay.

## Player interaction manager

`mixin/client/ClientPlayerInteractionManagerMixin` (126 lines) tunes block-breaking client-side:

- Sends MITE-specific packets when interacting with `MITELogBlock`
- Cancels client-side break particles when bare-hand-breaking is forbidden (the block won't actually break, so showing particles is misleading)

## Debug HUD

`mixin/client/rendering/DebugHudMixin` (157 lines) — adds MITE-specific debug overlay (F3 menu):
- Current nutrient saturations (5 categories)
- Inventory weight / max carry
- Biome temperature category (hot / normal / cold)
- Alive time (for spawn invincibility countdown)

## Custom block model rendering

| Mixin | Purpose |
|---|---|
| `BlockModelRendererMixin` (149 lines) | Custom render path for MITE blocks |
| `MutableQuadViewImplMixin` (139 lines) | Quad transformation hooks |
| `BufferBuilderMixin` (160 lines) | Vertex buffer changes for MITE-aware shading |
| `OverlayVertexConsumerMixin` (164 lines) | Overlays for cracked / damaged blocks |
| `AbstractQuadRendererMixin` (117 lines) | Per-quad render dispatching |
| `FluidRendererMixin` (295 lines) | Custom water / lava rendering with MITE overlays |

These all support the MITE visual treatment — slightly different shading, custom block textures (e.g., MITE log block), and overlay effects.

## Horse model client mixin

`mixin/client/HorseEntityModelMixin` (180 lines) — re-poses horses with custom animations (driving the horse-kicking behavior).

## Resource locations

| Identifier | Where |
|---|---|
| `mite:textures/gui/container/crafting.png` | Crafting select screen background |
| `mite:textures/gui/hud/nutrients.png` | 5-category HUD |
| `mite:textures/gui/hud/weight.png` | Weight indicator |
| `mite:textures/entity/...` | MITE-added entity skins |

## In MITEMC implementation

- **Crafting select screen**: not implemented.
- **5-category nutrient HUD**: not implemented.
- **Inventory weight indicator**: not implemented.
- **Cold / hot icon overlay**: not implemented.
- **Day counter HUD**: not implemented.
- **Weight tooltips on items**: not implemented.
- **Nutrient profile preview tooltip**: not implemented.
- **Tier badges on tools**: not implemented.
- **Custom block / fluid renderers**: not implemented.

See [PROGRESS.md](../../PROGRESS.md) for the punch list. UI work is the heaviest single category — most of the visible "MITE feel" lives in these client-side renderers.

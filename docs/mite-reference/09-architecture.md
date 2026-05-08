# 09 — Architecture overview

How MITE-RB-2025 is structured internally, and what the corresponding NeoForge port shape looks like.

## High-level package layout (`MITE-RB-2025`)

```
kelvin.mite/
├── main/                    Bootstrap, mod entry, shared resources
│   ├── Mite.java                Mod entry point
│   └── resources/
│       ├── MiteHungerManager        Capability-like interface for 5-cat hunger
│       ├── Resources                Inventory weight constants
│       ├── ToolDecayRates           Per-(tool, block) durability cost table
│       ├── DelayedDamage            Damage queueing for shield mechanics
│       ├── MoonHelper               Blue moon detection
│       ├── FastNoiseLite            Third-party noise lib
│       └── SnowAccumulation         Snow depth tracking
│
├── registry/                Item / block / nutrient / weight registration
│   ├── ItemRegistry             All MITE-added items
│   ├── BlockRegistry            All MITE-added blocks + tags
│   ├── NutrientsRegistry        Food → (F/V/G/D/P) mapping
│   ├── WeightRegistry           Item → weight value mapping
│   ├── VanillaTweaks            Reflection-based vanilla retunes
│   └── ModEntities              MITE entity types (bear, turkey)
│
├── blocks/                  MITE-added block classes
│   ├── MITELogBlock             Custom log block respecting MITE break rules
│   ├── MITEFurnaceBlock         Tier-aware furnace
│   ├── MITECraftingTableBlock   Custom crafting table
│   ├── MiteGrassBlock           Grass with tilled / dead state
│   ├── MitePlantBlock           Crop-style plants
│   ├── MiteTallPlantBlock       Tall flowers / wheat
│   ├── MiteRockBlock            Foragable rock spawns
│   ├── MiteCakeBlock            Multi-nutrient cake
│   ├── MiteFarmlandBlock        Farmland with thirst tracking
│   └── entity/
│       ├── CropBlockEntity          Per-crop tick state
│       └── FarmlandBlockEntity      Per-farmland water tracker
│
├── items/                   MITE-added item classes
│   ├── SurvivalItemTier         Custom tool tier enum
│   ├── ClubItem, CudgelItem
│   ├── HatchetItem, KnifeItem, DaggerItem
│   ├── ScytheItem, SpearItem
│   ├── MiteWarhammerItem, MiteMattockItem
│   ├── ShieldTier               Shield protection levels
│   ├── BurnableBlockItem        Items consumed by fire when stacked
│   ├── CompostItem              Fertilizer
│   ├── CustomBowlItem, CustomEggItem
│   └── SifterItem               Convert gravel to flint shards
│
├── entity/                  Custom entities + AI goals
│   ├── BearEntity
│   ├── TurkeyEntity
│   ├── AnimalWatcherEntity      Internal helper for AI
│   ├── CreeperData, WolfData    Spawn-context data
│   ├── PlayerInterface          Cross-cutting player API
│   ├── HungryAnimal             Interface for hunger-tracked animals
│   ├── GrassEater               Marker for grass-eating animals
│   ├── HorseKicking             Horse kick attack
│   └── goal/
│       ├── CanEatGrass
│       ├── DrinkWaterGoal
│       ├── EntityAIWatchAnimal      Predator-prey awareness
│       ├── FoodTargetGoal           Food-aware targeting
│       └── (more)
│
├── mixin/                   All Mixin classes (Fabric-style targeting)
│   ├── HungerManagerMixin           5-cat hunger
│   ├── ChunkGeneratorMixin          Worldgen
│   ├── CookingRecipeSerializerMixin Tier-aware furnace recipes
│   ├── ServerWorldMixin             World-tick hooks
│   ├── entity/
│   │   ├── PlayerEntityMixin            Player base behavior
│   │   ├── LivingEntityMixin            Damage / shield / heal
│   │   ├── ZombieEntityMixin            Zombie behavior
│   │   ├── CreeperEntityMixin           Creeper variants
│   │   ├── WolfEntityMixin              Dire wolf logic
│   │   ├── SpiderEntityMixin
│   │   ├── SquidEntityMixin
│   │   ├── AnimalEntityMixin            Base animal hunger/thirst
│   │   ├── ChickenEntityMixin
│   │   ├── CowEntityMixin
│   │   ├── PigEntityMixin
│   │   ├── HorseBaseEntityMixin         Kicking
│   │   └── FallingBlockEntityMixin
│   ├── block/
│   │   ├── BlockMixin                   Base block behavior tweaks
│   │   ├── CropBlockMixin               Crop tick tweaks
│   │   └── AbstractFurnaceBlockEntityMixin
│   ├── item/
│   │   └── ItemMixin                    Item base behavior
│   ├── client/
│   │   ├── InventoryScreenMixin         Custom inventory chrome
│   │   ├── CraftingScreenMixin          Recipe-select integration
│   │   ├── InGameHudMixin               5-cat HUD
│   │   ├── DebugHudMixin                F3 additions
│   │   ├── ClientPlayerInteractionManagerMixin  Break-speed packets
│   │   ├── HorseEntityModelMixin        Horse poses
│   │   └── rendering/
│   │       ├── BlockModelRendererMixin
│   │       ├── BufferBuilderMixin
│   │       ├── FluidRendererMixin
│   │       ├── MutableQuadViewImplMixin
│   │       ├── OverlayVertexConsumerMixin
│   │       └── AbstractQuadRendererMixin
│   └── structures/
│       ├── DesertTempleGeneratorMixin
│       └── StructureFeatureMixin
│
├── screens/                 Client-side custom Screen classes
│   └── CraftingSelectScreen         Recipe browser overlay
│
└── structures/              Custom world structures
    └── MiteVillageStructure         MITE village generator
```

## Architectural patterns

### Mixin-first design

`MITE-RB-2025` is built on **SpongePowered Mixin**, the Fabric-style modding approach. Roughly 60 % of the codebase is Mixin classes that surgically modify vanilla MC classes:

- `@Inject(at = @At("HEAD"), method = "...")` — runs MITE code at the start of a vanilla method
- `@Inject(at = @At("RETURN"))` — runs at the end
- `@Shadow` — references a private vanilla field/method
- `@Mutable` — allows write access to a `final` shadow field

This is fundamentally different from NeoForge, which uses **events** for most modification points.

### Capability-like data attachment

MITE attaches data to entities (player nutrients, animal hunger, creeper baby flag) using:

1. **DataTracker** (`TrackedData<T>`) for synchronized client-server fields (e.g., player FRUITS / VEGETABLES values)
2. **NBT serialization** for persistent state (NBT keys: `Fruit`, `Vegetables`, `Grain`, `Dairy`, `Protein`, `AliveTime`, `AcquiredIron`)
3. **Interface contracts** like `MiteHungerManager`, `HungryAnimal`, `PlayerInterface` — the Mixin makes the vanilla class implement the interface, then other code casts to the interface

### Reflection for vanilla retunes

`VanillaTweaks` uses Java reflection to mutate vanilla static fields (block strength, item durability, stack size). Specifically:

```
Field PROPERTIES = AbstractBlock.class.getDeclaredFields()[10];
PROPERTIES.setAccessible(true);
properties.strength(...)

Field MAX_DAMAGE = Item.class.getDeclaredFields()[10];
MAX_DAMAGE.setAccessible(true);
MAX_DAMAGE.set(item, damage);
```

This is brittle (depends on field index in obfuscated MC class), but works for the MC version targeted.

### Per-action exhaustion routing

Player actions (walk, sprint, jump, attack, swim, take damage) each call into `MiteHungerManager.addExhaustion(category, amount)` with a specific category. The hunger system maintains 5 separate exhaustion accumulators and depletes saturations independently.

### Client-server packet boundary

Most MITE state lives on the server and is synced to the client via:

1. **Vanilla DataTracker** for per-entity fields (5 hunger categories on player)
2. **Custom MITE packets** for non-entity state (inventory weight, biome temperature category)
3. **NBT in inventory** for item-specific state (charred food timer, custom bowl contents)

## NeoForge port shape

To translate MITE-RB-2025's Fabric Mixin architecture to NeoForge events:

| Fabric Mixin pattern | NeoForge equivalent |
|---|---|
| `@Inject` on player tick | `PlayerTickEvent.Post` |
| `@Inject` on damage | `LivingIncomingDamageEvent` |
| `@Inject` on entity init | `EntityJoinLevelEvent` |
| `@Inject` on attribute creation | `EntityAttributeCreationEvent` |
| `@Inject` on block break speed | `PlayerEvent.BreakSpeed` |
| `@Inject` on block place | `BlockEvent.EntityPlaceEvent` |
| `@Inject` on item use | `PlayerInteractEvent.RightClickItem` / `RightClickBlock` |
| `@Inject` on crafting result | `PlayerEvent.ItemCraftedEvent` |
| `@Inject` on render HUD | `RenderGuiOverlayEvent` |
| `DataTracker<T>` | `SynchedEntityData` (still vanilla) or NeoForge `Capability` / `IAttachmentSerializer` |
| `MiteHungerManager` interface cast | NeoForge data attachment via `AttachmentType` |
| `VanillaTweaks` reflection | NeoForge `IItemExtension` overrides + Mixin (where event isn't enough) |

NeoForge Mixin is supported but discouraged — events cover most MITE Mixin sites cleanly. For things events can't handle (custom break-speed gradient per-tool-per-block, vanilla `getCloneItemStack` override, vanilla furnace recipe filter), Mixin remains the right tool.

## Key invariants the port must preserve

1. **Player health attribute is the source of truth for max HP.** Use `Attributes.MAX_HEALTH` modifiers, not `setBaseValue`, so other mods that touch the same attribute compose cleanly.
2. **Saturation values are floats clamped 0–5.** Each per-action exhaustion call is small (0.001–0.5); they accumulate across many ticks.
3. **Reach distance is computed in `attack(target)`, not stored on the player.** A player swapping items mid-combat sees their reach change instantly.
4. **Spawn invincibility is purely tick-counted.** No NBT field for it — `Player.tickCount` is the canonical timer.
5. **Inventory weight is recalculated every tick.** No caching; computing it is cheap (~36 hashmap lookups).
6. **Blue moon overrides take precedence over hunger-driven AI.** Specifically for dire wolves: hunger-driven player aggro is suppressed during blue moon nights.
7. **`ChunkGeneratorMixin` runs in worldgen thread.** Any mutable state it touches must be thread-safe.

## Build / runtime layering

```
┌─────────────────────────────────────┐
│ Vanilla Minecraft 1.21.1 client     │
├─────────────────────────────────────┤
│ NeoForge 21.1.228 loader + APIs     │
├─────────────────────────────────────┤
│ MITEMC mod (your code)              │
│ ├─ Java event handlers              │
│ ├─ Mixins (where needed)            │
│ ├─ Datapack: recipes / tags / advs  │
│ └─ Resources: lang / textures / models│
└─────────────────────────────────────┘
```

`mite-rb-2025`'s Fabric stack maps approximately:

```
Vanilla 1.16/1.17 client + Fabric loader  ↔  Vanilla 1.21.1 + NeoForge
SpongePowered Mixin                        ↔  NeoForge events (mostly) + Mixin (fallback)
mod.json                                   ↔  neoforge.mods.toml
.mixins.json                               ↔  same (Mixin works on both loaders)
```

## Project layout in MITEMC (your repo)

```
mod/src/main/
├── java/com/mitemc/
│   ├── MITEMC.java                  Mod entry, registry + event registration
│   ├── Constants.java               IDs, log
│   ├── config/Config.java           NeoForge ModConfigSpec
│   ├── registries/                  ModItems / ModBlocks / ModEntities / ModEffects / ModSounds / ModTools / ModEnchantments / ModCreativeTabs / ModBlockEntities / ModTags
│   ├── items/                       Custom item classes (tool factory, lore book)
│   ├── blocks/                      Custom blocks (crops, furnaces, strongbox)
│   ├── entities/                    Custom entity classes (10 hostile)
│   ├── effects/                     StarvationWeaknessEffect
│   ├── events/                      Game-bus and mod-bus event handlers
│   ├── client/MitemcClient.java     Client-only entity renderers
│   └── mixins/                      (empty for now — events suffice)
└── resources/
    ├── META-INF/neoforge.mods.toml
    ├── mitemc.mixins.json           Wired but no Mixins yet
    ├── pack.mcmeta
    ├── assets/mitemc/
    │   ├── lang/                    EN/FR/DE/ES/IT
    │   ├── models/                  Item + block models
    │   ├── blockstates/
    │   └── textures/                (currently empty — punch list)
    └── data/
        ├── mitemc/
        │   ├── recipes/             Crafting + smelting JSONs
        │   ├── advancements/        Phase trees + survival tree
        │   ├── enchantment/         7 enchant JSONs
        │   ├── loot_tables/blocks/  Block drops
        │   ├── loot_tables/entities/ Entity drops
        │   ├── tags/                Block/item/enchantment tags
        │   └── worldgen/            Configured + placed features
        └── neoforge/biome_modifier/ Spawn weights + ore injection
```

## See also

- [MITE-RB-2025 source on GitHub](https://github.com/trist79/MITE-RB-2025) — the open-source MIT reimplementation we're using as reference
- [mite-renewed](https://github.com/MinecraftIsTooEasy/mite-renewed) — Jeff's GPL continuation
- [Original Avernite forum thread](https://www.minecraftforum.net/forums/mapping-and-modding-java-edition/minecraft-mods/1294284-minecraft-is-too-easy-mite-mod) — design intent

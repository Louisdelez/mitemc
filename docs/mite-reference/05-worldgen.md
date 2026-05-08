# 05 — Worldgen, biomes, structures

How the world is generated differently in MITE.

## Ore generation

`ChunkGeneratorMixin` and the ore feature configurations control where MITE ores spawn.

### Cross-checked frequency table (`MITE-RB-2025`)

| Ore | Min Y | Max Y | Avg veins / chunk | Vein size |
|---|---:|---:|---:|---:|
| Coal | 0 | 320 | 20 | 17 |
| Iron | -16 | 80 | 10 | 9 |
| Iron (deepslate) | -64 | 16 | 12 | 9 |
| Copper | -16 | 112 | 18 | 9 (large veins, thinner spread) |
| Gold | -64 | 32 | 4 | 9 |
| Lapis | -64 | 32 | 4 | 7 |
| Redstone | -64 | 16 | 8 | 8 |
| Diamond | -64 | 16 | 1 | 5 |
| Diamond (rare) | -64 | -16 | 0.1 | 5 |
| **Silver** (Avernite original) | -32 | 32 | 5 | 6 |
| **Mithril** (Avernite original) | -64 | 8 | 3 | 4 |
| **Adamantium** (Avernite original) | nether | nether | 4 | 3 |

The values for silver/mithril/adamantium are from Avernite's original MITE design (verified via the original Minecraft Forum thread); `MITE-RB-2025` doesn't ship those metals.

### Air-exposure penalty

| Ore | Discard chance on air exposure |
|---|---:|
| Coal | 0.0 (always spawns) |
| Iron | 0.0 |
| Copper | 0.0 |
| Gold (regular) | 0.0 |
| Diamond | 1.0 (only spawns inside solid stone) |
| Mithril | 1.0 |
| Adamantium | 1.0 |
| Silver | 0.5 |

This means rare metals only spawn in fully-enclosed stone, requiring careful tunneling rather than ravine exploration.

## Biome behavior

MITE doesn't add new biomes (that's left to extensions). It does retune biome **temperature thresholds** which feed into the player hunger system.

### Temperature thresholds for player effects

| Biome class | Base temperature range | Hunger effect |
|---|---:|---|
| Desert / badlands / Nether | > 1.5 | Hot: hunger ×10 |
| Plains / forest | 0.5 ≤ t ≤ 1.5 | Normal: hunger baseline |
| Taiga / snowy biomes | < 0.5 | Cold: hunger ÷10 (slower drain) + speed ×0.75 |
| Ultrawarm dimensions (Nether) | n/a (always treated as hot) | Hot |

### Snow accumulation

`MITE-RB-2025/main/resources/SnowAccumulation` tracks snow depth on blocks. Accumulates over time in cold biomes during snowfall. Walking through deep snow slows the player.

## Structures

### MITE Village

`structures/MiteVillageStructure.java` — replaces vanilla villages with smaller, more rustic settlements.

| Structure detail | Value |
|---|---|
| Generation chance | Per-biome, lower than vanilla villages |
| Houses | 3–7 per village |
| House style | Wood-and-cobble, single-room |
| Villagers | Standard but with MITE-aware trades |
| Wells | Always present (water source) |
| Farms | Wheat + carrot + potato + (MITE-specific crops) |

### Other structures

`structures/` contains generators for:
- Camp tents (small wilderness camps with chests)
- Stone circles (decorative, cobble + dirt)
- Hunter's blinds (raised wooden platforms)
- Caves with dressed-stone interiors (MITE dungeons)

`DesertTempleGeneratorMixin` (241 lines) retunes vanilla desert temples to be MITE-themed (more dangerous traps, better loot).

## Plant generation

| Plant | Where | Frequency |
|---|---|---|
| Wild wheat | Plains | Common |
| Berries | Forest | Common |
| Wild carrots | Plains, forest | Uncommon |
| Wild potatoes | Plains | Uncommon |
| Mushrooms | Forest, swamp | Common |
| Reeds | Beach, swamp | Common |
| Sticks (MITE) | Under trees, plains | Random spawn |
| Branches (MITE) | Under trees | Rare |

## Tree generation

MITE replaces vanilla logs with `MITELogBlock`. Trees are generated with the standard vanilla feature set, but each log block is the MITE variant (which respects MITE break rules).

## Custom terrain noise

`FastNoiseLite.java` (2610 lines) — full noise library bundled into MITE-RB-2025. Used for:
- Terrain feature placement
- Biome edge variation
- Ore vein offset
- Cave decoration

(This is a third-party MIT-licensed library; not a MITE original.)

## Spawn placement

| Mob class | Placement type | Light level | Heightmap |
|---|---|---|---|
| Surface monsters (dire wolf, wood spider) | ON_GROUND | Any | MOTION_BLOCKING_NO_LEAVES |
| Cave monsters (ghoul, wight, demon spider, invisible stalker, fire elemental) | ON_GROUND | Any | MOTION_BLOCKING_NO_LEAVES |
| Shadow | ON_GROUND | **Light = 0 only** | MOTION_BLOCKING_NO_LEAVES |
| Nether monsters (hellhound, infernal creeper) | ON_GROUND | Any | MOTION_BLOCKING_NO_LEAVES |

## In MITEMC implementation

- **Ore generation for copper/silver/mithril/adamantium**: scaffolded but the JSON ConfiguredFeature/PlacedFeature/BiomeModifier files are present and currently being tuned.
- **MITE Village**: not implemented.
- **Wild carrots/potatoes/sticks/branches as ground spawns**: not implemented.
- **Snow accumulation**: not implemented.
- **MITE-themed desert temples**: not implemented.
- **Vanilla tree → MITELogBlock replacement**: not implemented (vanilla logs still present).

See [PROGRESS.md](../../PROGRESS.md) for the punch list.

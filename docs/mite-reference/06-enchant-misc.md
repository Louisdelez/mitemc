# 06 — Enchantments, achievements, polish

The seven MITE enchantments, the achievement tree, and other player-visible details.

## Avernite's seven MITE enchantments

These are documented in the original MITE forum thread and Avernite's design notes:

### Speed (boots only)

| Property | Value |
|---|---|
| Slot | Feet armor only |
| Max level | III |
| Effect | +5% movement speed per level (additive multiplied) |
| Anvil cost | 4 (level I) → 12 (level III) |
| Min cost | 10 + 10 per level above I |
| Max cost | 50 + 10 per level above I |

### Stun (weapons)

| Property | Value |
|---|---|
| Slot | Mainhand weapon |
| Max level | II |
| Effect | On hit: applies Slowness II for 1–2 s (level I) / 1.5–3 s (level II) |
| Anvil cost | 2 (level I) → 4 (level II) |

### Fortune (Greater Fortune in MITEMC, mining tools)

| Property | Value |
|---|---|
| Slot | Mining tools (pickaxe, war hammer) |
| Max level | V (vs. vanilla III) |
| Effect | Adds extra ore drops; behaves like vanilla Fortune but capped higher |
| Anvil cost | 16 (level V — expensive) |
| Mutual exclusion | With vanilla Fortune |

### Regeneration (armor)

| Property | Value |
|---|---|
| Slot | Any armor piece |
| Max level | II |
| Effect | Tick effect: applies vanilla Regeneration I (level I) or II (level II) every 5 ticks (¼ second) |
| Anvil cost | 8 |

### Fertility (hoes)

| Property | Value |
|---|---|
| Slot | Mainhand, hoe-class items |
| Max level | III |
| Effect | While held, surrounding crops receive bonus random ticks |
| Bonus radius | I: 1×1×1, II: 3×1×3, III: 5×1×5 |
| Bonus tick rate | I: 1/s, II: 2/s, III: 4/s |
| Anvil cost | 4 |

### Tree Felling (axes)

| Property | Value |
|---|---|
| Slot | Mainhand, axe-class items |
| Max level | I |
| Effect | When the player breaks a log block: chain-break every connected log, capped at 96 blocks |
| Durability cost | 1 per log felled |
| BFS direction | 26 neighbors (handles diagonal trees) |
| Anvil cost | 8 |

### Vampiric (swords)

| Property | Value |
|---|---|
| Slot | Mainhand, sword-class items |
| Max level | III |
| Effect | On direct hit: attacker gains Regeneration I/II/III for 1–2/1–3/1–4 s |
| Trigger condition | Direct hits only (not thorns / kill aura / DoT) |
| Anvil cost | 8 |

## Anvil costs — pattern

MITE sets all enchantments at higher anvil costs than vanilla equivalents to enforce the "every enchantment is precious" feel:

| Vanilla | MITE |
|---|---|
| Sharpness V → 4 levels | Vampiric III → 8 levels |
| Fortune III → 4 levels | Greater Fortune V → 16 levels |

## Achievements / advancements

The original MITE design (Avernite, 12 achievements) maps to a survival progression tree:

| # | Achievement | Trigger |
|---:|---|---|
| 1 | Origins | Begin a MITE world |
| 2 | First Stick | Forage a stick from leaves |
| 3 | First Flint | Knap a flint shard |
| 4 | First Hatchet | Craft a flint hatchet |
| 5 | Day One Survived | Survive 24,000 ticks (1 in-game day) |
| 6 | Iron Bridge | Smelt your first iron ingot |
| 7 | Mithril Touch | Smelt mithril (requires obsidian furnace) |
| 8 | Adamantium | Smelt adamantium (requires netherrack furnace) |
| 9 | Hunter | Slay a hostile mob |
| 10 | Bestiary | Slay one of every MITE species (challenge) |
| 11 | All Seven | Possess one item with each MITE enchantment |
| 12 | Mythic Hand | Hold an adamantium ingot |

In `MITE-RB-2025`, advancement chain matches MC 1.16/1.17 conventions (vanilla `Advancement` JSON). `MITEMC` uses MC 1.21.1 advancement schema.

## Strongbox

Avernite's strongbox: a player-locked chest variant for multiplayer.

| Property | Value |
|---|---|
| Storage | 27 slots (single-chest layout) |
| Hardness | 5.0 |
| Blast resistance | 1200 (obsidian-class) |
| Required tool | Pickaxe (any tier) |
| Owner | Set on placement to placer's UUID |
| Open access | Owner only; OPs (permission level ≥ 2) bypass |
| Hopper interaction | Blocked (no `IItemHandler` exposed) |
| Variants | Iron / mithril / adamantium (incremental durability) |

## Sound design

MITE adds custom sound events:
- Strongbox locked refuse — short clink
- Crop blight develops — wet crackle
- Lore book flip — page turn
- Furnace crackle — ambient when running

These are *placeholder* IDs in the MITEMC port (no `.ogg` files shipped yet).

## Particle design

| Particle | Where |
|---|---|
| Blight spore | Drifts up from blighted crops |
| Lore dust | Spawn ring on lore book right-click |
| Strongbox spark | Red flash on locked-open attempt |
| Furnace flame | Custom higher-temperature flame for obsidian/netherrack furnaces |

## In-game lore journals

Avernite's original MITE included developer notes / books embedded as readable lore items. The MITEMC port treats these as 5 distinct items (origins, stone_age, forge, deep, mythic) with prose written fresh per session.

> **Important**: the MITEMC lore book contents are written in the spirit of Avernite's design philosophy but are **not** the original notes. The original notes from the Minecraft Forum thread are not reproduced here.

## In MITEMC implementation

- **7 enchantments**: registered, 5 fully data-driven, 2 Java-backed (Tree Felling and Fertility).
- **Greater Fortune**: registered but the loot-table integration that grants the level V curve is on the punch list.
- **Strongbox**: iron variant implemented; mithril/adamantium variants on the punch list.
- **Sound `.ogg` files**: zero shipped; only IDs reserved.
- **Particles**: not implemented.
- **Achievements**: 35 advancement JSON files (per phase + survival tree).

See [PROGRESS.md](../../PROGRESS.md) for the punch list.

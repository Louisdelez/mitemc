# MITE Reference Documentation

A structured, factual description of how the original **MITE (Minecraft Is Too Easy)** mod by Avernite behaves, prepared so the MITEMC port to Minecraft 1.21.1 / NeoForge can target the same gameplay rules.

This is a **gameplay-mechanics reference**, not a port of source code. It captures rules, formulas, and numerical thresholds that govern player experience, so a fresh implementation in modern Minecraft API can reproduce the same feel.

## Sources of truth

The original MITE jar (Avernite, MC 1.6.4, R196) is closed-source. To compile this reference we used:

| Source | License | What we got from it |
|---|---|---|
| [`MITE-RB-2025` (trist79 / Kevin Merrill)](https://github.com/trist79/MITE-RB-2025) | MIT | Authoritative reimplementation. Every number/formula here was cross-checked against this codebase. |
| [`mite-renewed` (Jeff)](https://github.com/MinecraftIsTooEasy/mite-renewed) | GPL-3.0 | Avernite-permitted continuation. Used for verification on a few mechanics. |
| [Original Minecraft Forum thread](https://www.minecraftforum.net/forums/mapping-and-modding-java-edition/minecraft-mods/1294284-minecraft-is-too-easy-mite-mod) | Public posts | Avernite's own design intent and behavior descriptions. |
| Public encyclopedia articles | Public | Cross-reference for player-visible behaviors. |

## Documents in this set

1. [**01-player.md**](./01-player.md) (199 lines) — Player mechanics: health curve, 5-category hunger, temperature, reach, damage, spawn invincibility, inventory weight.
2. [**02-blocks-tools.md**](./02-blocks-tools.md) (326 lines) — Block hardness × tool tier matrix, bare-hand restrictions, durability scaling, vanilla retunes, stack size limits.
3. [**03-items.md**](./03-items.md) (363 lines) — Tool catalog (7 materials × 7 families), 80+ food nutrient profiles, full inventory weight system.
4. [**04-mobs.md**](./04-mobs.md) (386 lines) — Mob roster with stats, AI patterns, drops, animal behaviors, LivingEntity damage/healing/shield mechanics, creeper + wolf deep dives.
5. [**05-worldgen.md**](./05-worldgen.md) (130 lines) — Ore generation, biome temperature thresholds, MITE villages.
6. [**06-enchant-misc.md**](./06-enchant-misc.md) (159 lines) — 7 MITE enchantments, achievements, strongbox, sound, particles.
7. [**07-crafting-recipes.md**](./07-crafting-recipes.md) (184 lines) — Crafting/smelting recipes, MITE crafting select screen, recipe gating per tier, charred food.
8. [**08-ui-screens.md**](./08-ui-screens.md) (149 lines) — All client-side custom GUIs: crafting select screen, 5-cat hunger HUD, weight indicator, inventory tooltips, debug HUD additions.
9. [**09-architecture.md**](./09-architecture.md) (266 lines) — How MITE-RB-2025 is structured (Mixin-first), data attachment patterns, NeoForge port mapping, key invariants to preserve.

**Total: 2215 lines across 10 files.**

## How to read these docs

- **Tables of numbers** are facts extracted from the open-source reimplementations or directly observable mod behavior — not copyrightable on their own.
- **Prose explanations** are written fresh in this repository.
- **Code blocks** are pseudocode or modern-MC NeoForge implementation snippets (our code), never decompiled MITE source.
- Each section flags the **delta from vanilla Minecraft** so a porter knows exactly what needs to change.

## Cross-reference table

The following maps each MITE mechanic to the file in `MITE-RB-2025` where it is implemented (for porters who want to verify):

| Mechanic | MITE-RB-2025 location |
|---|---|
| Player health curve | `mixin/entity/PlayerEntityMixin.java` |
| 5-category hunger | `mixin/HungerManagerMixin.java`, `main/resources/MiteHungerManager` |
| Tool tier values | `items/SurvivalItemTier.java` |
| Block break restrictions | `mixin/entity/PlayerEntityMixin.java#getBlockBreakingSpeed` |
| Tool decay rates | `main/resources/ToolDecayRates.java` |
| Food nutrients | `registry/NutrientsRegistry.java` |
| Mob AI tweaks | `mixin/entity/*Mixin.java` (Zombie, Wolf, Creeper, Player, etc.) |
| Worldgen | `mixin/ChunkGeneratorMixin.java` |
| Animal behavior | `entity/goal/*Goal.java` |
| MITE blocks | `blocks/*.java`, `registry/BlockRegistry.java` |

## Project goal

Use this reference to drive the [MITEMC](../../README.md) port: a from-scratch NeoForge 1.21.1 mod that reproduces the gameplay described here, without copying any closed-source MITE code.

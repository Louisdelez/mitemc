---
title: FAQ
description: Frequently asked questions about MITEMC.
sidebar:
  order: 13
---

## General

### Is MITEMC the same as MITE?

**No.** MITEMC is a port of Avernite's MITE (R196, MC 1.6.4) to **Minecraft 26.1** on **NeoForge**, restoring the design while running on modern foundations. The original MITE is frozen at 1.6.4. See [migration guide](/en/guides/migration/).

### Why "MITEMC"?

Short for "MITE for Minecraft" + clear suffix. The original MITE name (Minecraft Is Too Easy) is preserved everywhere it matters — in advancements, lore, and the spirit of the design.

### Does MITEMC need Forge?

**No.** MITEMC is a NeoForge mod. NeoForge ≥ 26.1.x required. NeoForge is the post-2023 community fork of Forge and the de-facto standard for content-heavy mods in 2026.

### Can I install MITEMC alongside other mods?

Yes — NeoForge mods coexist by default. Conflict points to watch:

- **Other mods that touch player attributes** (max health, hunger) may overwrite MITEMC's modifiers. We use a named `phase1_max_health` modifier so nothing else collides.
- **Other agriculture mods** that introduce new crops are fine; MITEMC's crops are namespaced.
- **Other enchantment mods** that add Fortune-V variants conflict with our Greater Fortune — the `exclusive_set` tag should auto-resolve.

## Gameplay

### I keep dying on day 1. Is that intentional?

**Yes.** Three hearts means a single zombie hit takes a third of your life. The intended path is foraging → flint → shelter on night 1, not engagement. See [Survival Basics](/en/guides/survival-basics/).

### My crops keep dying — is that a bug?

It's the **blight system** ([agriculture reference](/en/reference/agriculture/)). Mature crops have a small chance per random-tick to develop blight. Cure with manure. Or set `crop_blight_chance = 0` in [config](/en/reference/configuration/) if you don't want it.

### Why can't I open this strongbox?

It's a [strongbox](/en/reference/strongbox/) you didn't place — only its owner (placer) and OPs can open. Break it (drops contents) or have the owner open it for you.

### Why does my pickaxe break iron ore but not silver ore?

Silver ore requires copper-tier or higher in MITEMC. Vanilla pickaxe-tiers only cover iron's ore. See [Tool Tiers](/en/reference/tool-tiers/).

### I have a Greater Fortune V pickaxe but my drops aren't different from regular Fortune III. Why?

Phase 6 ships Greater Fortune as a registry entry — the actual loot-table integration that grants the extra rolls is on the Phase 6.5 punch list. Use vanilla Fortune III for now; it works as expected.

## Server / multiplayer

### Are MITEMC servers performant?

Most handlers are server-tick scoped with cheap predicates. The known load points:

- `FertilityHandler` scans a small area on player tick (only when a Fertility hoe is held).
- `AnimalHungerHandler` runs every 100 ticks per animal — capped well.
- `AnimalManureHandler` tick chance is 0.01% per cow/pig — barely measurable.

A single profiler pass is on the punch list for Phase 7.5.

### Can I disable a phase entirely?

Not via config in one switch — but you can override per-system:

- Phase 1 player rebalance: set `starting_hearts=10`, `starting_food=10`, `basal_exhaustion_per_tick=0.0`.
- Phase 4 mobs: ship a datapack overriding `data/neoforge/biome_modifier/mitemc_spawns.json` with empty spawners.
- Phase 5 agriculture: set `crop_blight_chance=0`, `animal_manure_chance=0`.

### Permissions?

The strongbox checks permission level ≥ 2 for the OP override. Standard NeoForge permission integration applies.

## Translations

### My language isn't supported.

MITEMC ships in English, French, German, Spanish, Italian. To add another: copy `wiki/src/content/docs/en/` to a new locale folder, translate, add the locale in `wiki/astro.config.mjs`, and copy `mod/src/main/resources/assets/mitemc/lang/en_us.json` to your language's lang code. PRs welcome — see [CONTRIBUTING-TRANSLATIONS](https://github.com/MITEMC/mitemc/blob/main/wiki/CONTRIBUTING-TRANSLATIONS.md).

### A translation is wrong / sounds awkward.

PRs welcome. See the same contributing guide.

## Compatibility

### What about the Chinese MITE community ecosystem (FishModLoader, ModernMite)?

MITEMC targets NeoForge directly, while FishModLoader is a Fabric-style loader for MC 1.6.4. They're different platforms — MITEMC isn't a port of FishModLoader work. We do credit the modern MITE community in [CREDITS.md](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md).

### Will adamantium tools work in modpacks?

Yes — they extend vanilla item classes (SwordItem, AxeItem, PickaxeItem) and use the standard durability/damage system. Tinkers, JEI, REI all see them as standard tool items.

## Bugs

### I found a bug.

[Open an issue](https://github.com/MITEMC/mitemc/issues) with: MC version, NeoForge version, mod loader logs, and a minimal reproduction. The PROGRESS log notes API uncertainties (e.g., `BlockEvent.CropGrowEvent.Pre` signature, `RecipeBookType.FURNACE` constant) — those are the most likely first-build adjustment points.

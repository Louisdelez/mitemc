---
title: Migrating from MITE 1.6.4
description: Coming from Avernite's original MITE? Here's what changed.
sidebar:
  order: 3
---

If you played the original MITE (R196 on Minecraft 1.6.4), this is the cheat sheet for what carries over and what changed.

## TL;DR

MITEMC is a **faithful port**, not a remake. The intent is: a 2026 player who installs MITEMC should feel like they're playing the same mod Avernite made — with all the modern niceties (NeoForge, datapack overrides, multilingual UI) underneath.

## Mechanics carried over

| MITE R196 mechanic                                  | MITEMC status |
|-----------------------------------------------------|---------------|
| 3-hearts / 3-food start, +1 per 5 XP levels         | ✓ identical   |
| Basal metabolism (idle hunger drain)                | ✓ identical   |
| Rain accelerates hunger                             | ✓ identical   |
| Starvation weakness (can't break/place blocks)      | ✓ identical   |
| Stick from leaves                                   | ✓ identical   |
| 9 tool families (cudgel/club/hatchet/knife/dagger/war_hammer/battle_axe/mattock/scythe) | ✓ + shovel ergonomic addition |
| 5 metal materials (flint/copper/silver/mithril/adamantium) | ✓ identical |
| Tool tier mining gates                              | ✓ identical with modern tag system |
| 4 furnace tiers (clay/sandstone/obsidian/netherrack)| ✓ identical |
| Heat tier gates smelting recipes                    | ✓ identical, item-tag-driven |
| 10 hostile mobs (dire wolf, wood spider, ghoul…)    | ✓ identical |
| Onion crop + blight + manure                        | ✓ identical |
| 7 enchantments (speed/stun/fortune/regen/fertility/tree felling/vampiric) | ✓ identical, "Greater Fortune" replaces vanilla collision |
| Strongbox (player-locked metal chest)               | ✓ identical |

## Behavioral changes

| Concern                          | MITE R196 | MITEMC                                                    |
|----------------------------------|-----------|-----------------------------------------------------------|
| Mod loader                       | None (raw) | NeoForge                                                 |
| Forge compatibility              | Refused (~500 base classes) | Native NeoForge — no compat layer needed |
| Datapack overrides               | Impossible | All recipes / tags / advancements overridable             |
| Translations                     | English-ish | EN/FR/DE/ES/IT, parity-checked                          |
| Configuration                    | Code-baked | Runtime TOML config for Phase 1 + Phase 5 numbers         |
| Custom geo models for mobs       | None       | Vanilla renderers as placeholders (custom models pending) |
| Adamantium drop                  | Direct ingot | Now drops `raw_adamantium_chunk`, smelt in netherrack furnace (cleaner pipeline) |
| Tool durability formula          | Block-hardness scaled | Vanilla durability for now (Phase 6.5 brings Mixin) |

## What's not yet ported

| MITE R196 feature                              | MITEMC status        |
|------------------------------------------------|----------------------|
| Time-based crafting (recipes take ticks)       | Punch list — Mixin into crafting completion |
| Fuel quality (heat capacity per fuel)          | Infrastructure ready, runtime not yet enforcing |
| Custom geo models / textures for new mobs      | Punch list           |
| Animal seek-food AI (proactive pathfind)       | Phase 5.5 follow-up  |
| Greater Fortune extra-roll loot integration    | Phase 6.5 follow-up  |
| In-game lore journals from Avernite's notes    | ✓ Done as 5 lore books in Phase 7 |

## Save data

MITE 1.6.4 saves are **not** transferable. The chunk format, item NBT, entity types — all changed irrecoverably between MC 1.6.4 and 26.1. If you have a beloved MITE world, the way to honor it is to take screenshots, then start fresh.

## Identical IDs?

No. MITE 1.6.4 used numeric IDs (the old block/item ID system). MITEMC uses `mitemc:<name>` namespaced IDs. Examples:

| MITE R196 (numeric) | MITEMC (namespaced)            |
|---------------------|--------------------------------|
| Iron Hatchet        | `mitemc:iron_hatchet` (vanilla iron) |
| Copper Pickaxe      | `mitemc:copper_war_hammer`     |
| Mithril Ore         | `mitemc:mithril_ore`           |
| Strongbox           | `mitemc:iron_strongbox`        |

If you're scripting with `/give`, use the new IDs.

## Mod community

The Chinese MITE community (Bilibili, QQ groups) has been keeping MITE alive since 2014. MITEMC is a separate effort; we credit them in [CREDITS.md](https://github.com/Louisdelez/mitemc/blob/main/docs/CREDITS.md). If you're coming from FishModLoader / ModernMite, MITEMC is a parallel modern port — pick whichever ecosystem fits your group.

## See also

- [Getting Started](/en/guides/getting-started/) — fresh-install walkthrough.
- [Configuration](/en/reference/configuration/) — all knobs.
- [FAQ](/en/reference/faq/) — common questions.

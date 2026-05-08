---
title: Extensions roadmap
description: What's planned beyond the faithful 1:1 port.
sidebar:
  order: 14
---

The original ROADMAP closes at **Phase 8**: 100% wiki coverage and the design framework for post-1:1 expansion. Anything below this line is post-port — the project's continuation rather than its completion.

## Design rule for extensions

Every post-1:1 feature must answer: *would Avernite have shipped this?* If the answer needs three paragraphs of justification, it goes in `mitemc-extended`, not `mitemc`. The base mod stays faithful.

Concrete consequences:

- **No new dimensions in the base mod.** The Mythic Age conceptually exists as the adamantium plateau; building a literal Mythic Dimension belongs in extended.
- **No quest UI in the base mod.** Vanilla advancements are the diegetic interface — adding a quest journal would compete with them.
- **No magic skill tree.** MITE's "magic" is enchantments + materials, not a separate progression axis.

## Planned extensions (`mitemc-extended`, future repository)

### 1. Mythic Dimension

A new dimension reachable from a netherrack-furnace-crafted portal frame. Adamantium-tier mobs, mythic-only crafting recipes, raid-style structures. **Status:** design notes only.

### 2. Expanded biomes

- **Cursed Forest** — overworld biome with a high natural blight chance and stronger wood spider spawns.
- **Glacial Wastes** — extreme cold biome where `cold_biome_mult` is 4× instead of 2×.
- **Mythic Caverns** — sub-Y=-32 cavern biome where adamantium ore generates and demon spiders are 3× more common.

**Status:** biome JSON drafts in `docs/extensions/biomes/` (not yet authored).

### 3. Multiplayer servers infrastructure

- **Strongbox tiers** — mithril and adamantium variants with explosion immunity, dimension-tracking, anti-creative-break.
- **Player-bound enchantments** — enchantments that bind to UUID, can't be PVP-stripped.
- **Server-only commands** — `/mitemc reset_player <uuid>`, `/mitemc grant_lore_book all <player>`, etc.

**Status:** design only.

### 4. Quality polish (likely to land before extensions)

These are deferred from the 1:1 phases:

- **Custom geo models + textures** for the 10 hostile mobs (Phase 4 ships vanilla renderers as placeholders).
- **Texture pass** for all 50 tools, 4 ores, raw chunks, lore books — currently using missing-texture placeholders.
- **Sound `.ogg` authoring** for the 4 reserved sound IDs (Phase 7).
- **Greater Fortune loot integration** so the V max level actually grants extra-roll bonuses (Phase 6.5).
- **Fuel quality enforcement** so wood/coal/lava/blaze rod gate furnace tiers (Phase 3.5).
- **Animal seek-food AI** so cows/sheep proactively pathfind to grass (Phase 5.5).
- **Custom particles** for blight transitions, lore book flips, strongbox refusal (Phase 7.5).
- **Custom recipe-time UI** — Mixin into crafting to enforce time-based recipes (Phase 2.5 follow-up).

These are tracked in [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md) under "Tech debt" rolling lists.

## Versioning

The base mod (`mitemc`) follows **semantic versioning per-phase**:

- 0.x.0 — pre-release ports (current)
- 1.0.0 — when all 8 phases are validated against a real NeoForge 26.1 build
- 1.x.0 — patch passes (Phase X.5 polish work)
- 2.0.0 — extensions begin shipping (separate `mitemc-extended` jar; coexists with base)

`mitemc-extended` versions itself independently and depends on `mitemc` ≥ 1.0.0.

## Contribution policy for extensions

If you want to ship a feature that isn't in the 1:1 spec:

1. Open a discussion issue tagged `extension-proposal`.
2. Identify the *closest* MITE R196 anchor (if any). Pure invention is fine but should be honest about it.
3. Draft as a `mitemc-extended` PR, not a `mitemc` PR.
4. Translation parity is enforced for extensions too — same i18n rules apply.

The base mod accepts only features that map back to Avernite's intent. Extensions can do anything.

## See also

- [Roadmap](https://github.com/MITEMC/mitemc/blob/main/ROADMAP.md) — the closed 8-phase 1:1 plan.
- [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md) — live work log, including punch lists.
- [Credits](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md) — Avernite, the modern MITE community, and contributors.

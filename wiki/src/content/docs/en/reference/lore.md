---
title: Lore
description: In-game lore books and design philosophy.
sidebar:
  order: 11
---

Phase 7 ships **5 lore books** that double as a player-facing design diary. Each is an item; right-clicking displays a translated, multi-paragraph passage in chat in the player's language. The text honors the spirit of Avernite's developer notes from the original MITE forum thread.

## The five books

| Book ID                       | Title             | Theme                                |
|-------------------------------|-------------------|--------------------------------------|
| `mitemc:lore_book_origins`    | Origins           | Why MITE exists at all               |
| `mitemc:lore_book_stone_age`  | Stone Age         | Phase 1 — scarcity as tutorial       |
| `mitemc:lore_book_forge`      | The Forge         | Phases 2–3 — patience as progression |
| `mitemc:lore_book_deep`       | The Deep          | Phase 4 — depth as ramp              |
| `mitemc:lore_book_mythic`     | Mythic Age        | Phase 6+ — the mountain that exists  |

## Reading

Right-click any lore book to print its title and body to chat. The body is laid out as multiple paragraphs separated by blank lines. The full text lives in `lang/<locale>.json` under keys `lore.mitemc.book.<id>.title` and `lore.mitemc.book.<id>.body`.

## Crafting

Each book is a shapeless craft: vanilla writable book + a phase-marker item. No book is gated behind a phase you haven't reached, so you can collect them out of order:

| Book        | Recipe                              |
|-------------|-------------------------------------|
| Origins     | writable book + flint shard         |
| Stone Age   | writable book + stone               |
| The Forge   | writable book + copper ingot        |
| The Deep    | writable book + bone                |
| Mythic Age  | writable book + adamantium ingot    |

The marker items are small enough to be obtainable in the matching phase but not artificially gated.

## Design philosophy

The lore books exist for two reasons:

1. **Narrative cohesion** — a hardcore mod without a story feels punitive. A short passage explaining *why* a mechanic is there reframes it as intentional rather than hostile.
2. **Translation showcase** — the books are the longest prose passages in the project (~3 paragraphs each). They prove the i18n stack handles real text, not just labels.

If you want to add new lore books, the pattern is small:
- Subclass `LoreBookItem` is *not* needed; just register a new `LoreBookItem(key, props)` with a fresh string key.
- Add `lore.mitemc.book.<key>.title` and `lore.mitemc.book.<key>.body` to all five `lang/<locale>.json` files.
- Optional: a recipe and a survival-tree trigger.

## Phase 7 advancement

Holding any lore book triggers `mitemc:survival_tree/first_lore`. Holding all five contributes to `survival_tree/completionist`.

## See also

- [Advancements](/en/reference/advancements/) — where lore plugs into the survival tree.
- [Roadmap](https://github.com/MITEMC/mitemc/blob/main/ROADMAP.md) — the full multi-phase plan.

---
title: Advancements
description: Full advancement tree across all phases plus the survival tree overview.
sidebar:
  order: 10
---

MITEMC ships **35 advancements** organized into seven per-phase trees plus one cross-phase summary tree.

## Per-phase trees

Each phase has its own milestone chain, displayed in the vanilla advancements UI under its own tab.

### Phase 1 — Survival foundations
```
phase1/root → first_stick → first_flint
```

### Phase 2 — Metal age
```
phase2/root → first_copper → first_silver → first_mithril → first_adamantium
```
`first_adamantium` is a challenge frame.

### Phase 3 — Furnace hierarchy
```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```
`netherrack_furnace` is a challenge frame.

### Phase 4 — Bestiary
```
phase4/root → first_kill → all_ten
```
`all_ten` is a challenge frame.

### Phase 5 — Agriculture
```
phase5/root → first_onion → cure_blight (goal) → full_pantry
```
`full_pantry` is a challenge frame requiring 16 onions + 16 wheat + 16 carrots.

### Phase 6 — Enchantments + strongbox
```
phase6/root → first_enchant → strongbox
phase6/root → first_enchant → all_seven (challenge)
```

## Survival tree (Phase 7 — cross-phase summary)

Twelve milestones that don't replace the phase trees but offer a flat completion overview:

| Slug                | Trigger                                              | Frame     |
|---------------------|------------------------------------------------------|-----------|
| `origins`           | First tick on a MITEMC world (root)                  | task      |
| `first_food`        | Consume any food                                     | task      |
| `first_kill`        | Player-killed any entity                             | task      |
| `first_metal`       | Any MITEMC ingot in inventory                        | task      |
| `first_furnace`     | Any MITEMC furnace block in inventory                | task      |
| `first_crop`        | Onion in inventory                                   | task      |
| `first_enchant`     | Hold an item with any MITEMC enchant                 | task      |
| `first_strongbox`   | Iron strongbox in inventory                          | task      |
| `first_lore`        | Any lore book in inventory                           | task      |
| `bestiary`          | Slay one of every MITEMC species                     | challenge |
| `mythic`            | Adamantium ingot in inventory                        | challenge |
| `completionist`     | Hold adamantium + strongbox + all enchants + onion + lore | challenge |

The survival tree's parent is `survival_tree/origins` (its own root), so it sits separately from the phase trees in the advancements UI.

## Triggers used

- `minecraft:tick` — root advancements
- `minecraft:inventory_changed` — most milestone advancements (with `items` predicate)
- `minecraft:player_killed_entity` — kill milestones (with optional `entity_properties` for species filter)
- `minecraft:consume_item` — food milestones
- `minecraft:item_used_on_block` — interaction milestones (e.g., manure on a blighted crop)

## Customizing

Advancement JSON lives at `data/mitemc/advancements/<phase>/*.json`. Two kinds of override:

- **Disable**: copy the JSON into a datapack with `{ "criteria": {} }` and an empty parent — the engine treats it as unobtainable.
- **Reskin**: keep the criteria, change the icon/title/description.

Players who want to remove the challenge ones in particular can ship a small datapack that empties their criteria.

## Tag

`#mitemc:all_enchantments` — used by `phase6/first_enchant`, `phase6/all_seven`, `survival_tree/first_enchant`, and `survival_tree/completionist` to detect any of the seven MITEMC enchantments on an item.

## See also

- [Lore](/en/reference/lore/) — narrative books that complete the survival_tree's `first_lore`.
- [Bestiary](/en/bestiary/) — what's hunted for `all_ten` / `bestiary`.
- [Enchantments](/en/reference/enchantments/) — what counts for `first_enchant`.

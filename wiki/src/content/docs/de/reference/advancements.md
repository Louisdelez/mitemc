---
title: Fortschritte
description: Vollständiger Fortschrittsbaum aller Phasen plus die Übersicht des Survival-Trees.
sidebar:
  order: 10
---

MITEMC liefert **35 Fortschritte**, organisiert in sieben Phasenbäume plus einen phasenübergreifenden Übersichtsbaum.

## Pro-Phasen-Bäume

Jede Phase hat ihre eigene Meilensteinkette, im Vanilla-Fortschrittsmenü unter eigenem Reiter.

### Phase 1 — Überlebensfundamente
```
phase1/root → first_stick → first_flint
```

### Phase 2 — Metallzeitalter
```
phase2/root → first_copper → first_silver → first_mithril → first_adamantium
```
`first_adamantium` ist Challenge-Rahmen.

### Phase 3 — Ofenhierarchie
```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```
`netherrack_furnace` ist Challenge-Rahmen.

### Phase 4 — Bestiarium
```
phase4/root → first_kill → all_ten
```
`all_ten` ist Challenge-Rahmen.

### Phase 5 — Landwirtschaft
```
phase5/root → first_onion → cure_blight (Ziel) → full_pantry
```
`full_pantry` ist Challenge mit 16 Zwiebeln + 16 Weizen + 16 Karotten.

### Phase 6 — Verzauberungen + Tresor
```
phase6/root → first_enchant → strongbox
phase6/root → first_enchant → all_seven (Challenge)
```

## Survival-Tree (Phase 7 — phasenübergreifend)

Zwölf Meilensteine, die die Phasenbäume nicht ersetzen, aber eine flache Komplettierungsübersicht bieten:

| Slug                | Auslöser                                                 | Rahmen    |
|---------------------|----------------------------------------------------------|-----------|
| `origins`           | Erster Tick in einer MITEMC-Welt (root)                  | task      |
| `first_food`        | Beliebige Nahrung konsumieren                            | task      |
| `first_kill`        | Spieler tötet beliebige Entität                          | task      |
| `first_metal`       | Beliebiger MITEMC-Barren im Inventar                     | task      |
| `first_furnace`     | Beliebiger MITEMC-Ofen-Block im Inventar                 | task      |
| `first_crop`        | Zwiebel im Inventar                                      | task      |
| `first_enchant`     | Item mit MITEMC-Verzauberung halten                      | task      |
| `first_strongbox`   | Eisentresor im Inventar                                  | task      |
| `first_lore`        | Beliebiges Lore-Buch im Inventar                         | task      |
| `bestiary`          | Eine Kreatur jeder MITEMC-Art erlegen                    | challenge |
| `mythic`            | Adamantium-Barren im Inventar                            | challenge |
| `completionist`     | Adamantium + Tresor + alle Verzauberungen + Zwiebel + Lore | challenge |

Der Parent ist `survival_tree/origins` (eigene Wurzel), daher steht der Tree separat von den Phasenbäumen im UI.

## Verwendete Auslöser

- `minecraft:tick` — Wurzel-Fortschritte
- `minecraft:inventory_changed` — die meisten Meilensteine (mit `items`-Predicate)
- `minecraft:player_killed_entity` — Töten-Meilensteine (optional `entity_properties` für Artfilter)
- `minecraft:consume_item` — Nahrungsmeilensteine
- `minecraft:item_used_on_block` — Interaktionsmeilensteine (z. B. Mist auf befallene Pflanze)

## Anpassen

Fortschritts-JSON liegt unter `data/mitemc/advancements/<phase>/*.json`. Zwei Override-Arten:

- **Deaktivieren**: JSON in ein Datapack kopieren mit `{ "criteria": {} }` und leerem Parent — engine behandelt es als unerreichbar.
- **Reskin**: Kriterien behalten, Icon/Titel/Beschreibung ändern.

Wer die Challenges entfernen will, kann ein kleines Datapack ausliefern, das ihre Kriterien leert.

## Tag

`#mitemc:all_enchantments` — von `phase6/first_enchant`, `phase6/all_seven`, `survival_tree/first_enchant` und `survival_tree/completionist` benutzt, um beliebige der sieben MITEMC-Verzauberungen auf einem Item zu erkennen.

## Siehe auch

- [Lore](/de/reference/lore/) — Erzählbücher, die `first_lore` im Survival-Tree erfüllen.
- [Bestiarium](/de/bestiary/) — was für `all_ten` / `bestiary` gejagt wird.
- [Verzauberungen](/de/reference/enchantments/) — was für `first_enchant` zählt.

---
title: Lore
description: Lore-Bücher im Spiel und Designphilosophie.
sidebar:
  order: 11
---

Phase 7 liefert **5 Lore-Bücher**, die zugleich als spielerseitiges Design-Tagebuch dienen. Jedes ist ein Item; Rechtsklick zeigt eine übersetzte mehrabsätzige Passage im Chat in der Spielsprache. Der Text ehrt den Geist der Entwicklernotizen Avernites aus dem ursprünglichen MITE-Forum-Thread.

## Die fünf Bücher

| Buch-ID                      | Titel               | Thema                                |
|------------------------------|---------------------|--------------------------------------|
| `mitemc:lore_book_origins`   | Anfänge             | Warum MITE überhaupt existiert       |
| `mitemc:lore_book_stone_age` | Steinzeit           | Phase 1 — Knappheit als Tutorial     |
| `mitemc:lore_book_forge`     | Die Schmiede        | Phasen 2–3 — Geduld als Progression  |
| `mitemc:lore_book_deep`      | Die Tiefe           | Phase 4 — Tiefe als Rampe            |
| `mitemc:lore_book_mythic`    | Mythisches Zeitalter| Phase 6+ — der existierende Berg     |

## Lesen

Rechtsklick auf ein Lore-Buch druckt Titel und Body in den Chat. Der Body besteht aus mehreren durch Leerzeilen getrennten Absätzen. Der Volltext lebt in `lang/<locale>.json` unter den Schlüsseln `lore.mitemc.book.<id>.title` und `lore.mitemc.book.<id>.body`.

## Crafting

Jedes Buch ist ein shapeless Crafting: Vanilla-Schreibbuch + Phasen-Marker-Item. Kein Buch ist hinter einer noch nicht erreichten Phase gesperrt — sie können in beliebiger Reihenfolge gesammelt werden:

| Buch                 | Rezept                                  |
|----------------------|-----------------------------------------|
| Anfänge              | Schreibbuch + Feuersteinsplitter        |
| Steinzeit            | Schreibbuch + Stein                     |
| Die Schmiede         | Schreibbuch + Kupferbarren              |
| Die Tiefe            | Schreibbuch + Knochen                   |
| Mythisches Zeitalter | Schreibbuch + Adamantium-Barren         |

Die Marker-Items sind klein genug, um in der jeweiligen Phase erreichbar zu sein, ohne künstliche Sperre.

## Designphilosophie

Die Lore-Bücher existieren aus zwei Gründen:

1. **Erzählerische Kohärenz** — eine harte Mod ohne Story wirkt strafend. Eine kurze Passage erklärt, *warum* eine Mechanik existiert, und rahmt sie als beabsichtigt statt feindselig.
2. **Übersetzungsdemonstration** — die Bücher sind die längsten Prosapassagen im Projekt (~3 Absätze pro Stück). Sie beweisen, dass der i18n-Stack echten Text trägt, nicht nur Labels.

Wer neue Lore-Bücher hinzufügt, folgt einem kleinen Muster:
- Subklasse von `LoreBookItem` *nicht* nötig; einfach einen neuen `LoreBookItem(key, props)` mit einem frischen String-Schlüssel registrieren.
- `lore.mitemc.book.<key>.title` und `lore.mitemc.book.<key>.body` in alle fünf `lang/<locale>.json` aufnehmen.
- Optional: ein Rezept und ein Survival-Tree-Trigger.

## Phase-7-Fortschritt

Beliebiges Lore-Buch zu halten löst `mitemc:survival_tree/first_lore` aus. Alle fünf zu halten trägt zu `survival_tree/completionist` bei.

## Siehe auch

- [Fortschritte](/de/reference/advancements/) — wo Lore in den Survival-Tree eingreift.
- [Roadmap](https://github.com/Louisdelez/mitemc/blob/main/ROADMAP.md) — der vollständige Mehrphasenplan.

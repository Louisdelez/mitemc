---
title: Werkzeuge & Waffen
description: Vollständige Referenz der 10 MITEMC-Werkzeugfamilien.
sidebar:
  order: 4
---

MITEMC liefert **10 Werkzeugfamilien** — die 9 aus Avernites MITE plus eine Schaufel der Ergonomie wegen. Jede Familie ist in **5 Materialien** registriert (Feuerstein, Kupfer, Silber, Mithril, Adamantium), das ergibt **50 neue Items**. Vanilla-Werkzeuge aus Eisen, Gold, Diamant und Netherite koexistieren; MITEMC dupliziert sie nicht.

## Familienmatrix

| Familie              | Vanilla-Eltern  | Schadensbonus | Angriffsgeschw. | Rolle                                       |
|----------------------|-----------------|---------------|------------------|---------------------------------------------|
| Knüppel              | schwertähnlich  | niedrig (+1)  | -3,4             | Stumpf, betont Rückstoß                     |
| Keule                | schwertähnlich  | niedrig+ (+2) | -3,2             | Schneller als Knüppel, weniger Rückstoß     |
| Beil                 | Axt             | mittel (+3)   | -3,0             | Kleine Axt, schnellerer Angriff             |
| Messer               | schwertähnlich  | niedrig (+1)  | -1,8             | Sehr schnell, Pflanzenernte                 |
| Dolch                | schwertähnlich  | niedrig+ (+2) | -1,6             | Backstab-Gefühl, schnell                    |
| Kriegshammer         | Spitzhacke      | hoch (+5)     | -3,4             | Schwer; baut Stein ab                       |
| Streitaxt            | Axt             | hoch (+6)     | -3,5             | Langsam, schwerster Schlag                  |
| Bipenne (Mattock)    | Spitzhacke      | mittel (+3)   | -2,8             | Spitzhacken-/Schaufel-Kombi                 |
| Sense                | Hacke           | mittel (+2)   | -2,6             | Pflanzen-Flächenernte                       |
| Schaufel             | Schaufel        | niedrig (+1,5)| -3,0             | Klassisches Graben                          |

Die Werte sind Startabstimmungen aus der MITE-R196-Matrix — jede Position ist data-driven und über das kommende Schadensmatrix-Datapack neu balancierbar.

## Material × Stufe

| Material   | Abbau-Stufe       | Haltbarkeit | Tempo | Schadensbonus | Verzauberbark. |
|------------|-------------------|-------------|-------|---------------|----------------|
| Feuerstein | Stein-äquivalent  | 30          | 3,0   | +0,5          | 6              |
| Kupfer     | Eisen-äquivalent  | 180         | 5,0   | +1,5          | 12             |
| Eisen      | (Vanilla)         | 250         | 6,0   | +2,0          | 14             |
| Silber     | mittel            | 400         | 7,0   | +2,0          | 16             |
| Mithril    | hoch              | 900         | 9,0   | +3,0          | 22             |
| Adamantium | Spitze            | 2200        | 12,0  | +5,0          | 10             |

## Abbau-Sperren

Jede Stufe hat einen Tag mit Blöcken, die sie **nicht** abbauen kann. Höhere Stufen erben die unteren Sperren.

| Stufe       | Kann nicht abbauen                            |
|-------------|-----------------------------------------------|
| Feuerstein  | `#minecraft:incorrect_for_stone_tool`         |
| Kupfer      | `#mitemc:needs_silver_tool`                   |
| Silber      | `#mitemc:needs_mithril_tool`                  |
| Mithril     | `#mitemc:needs_adamantium_tool`               |
| Adamantium  | (keine — Spitzenstufe)                        |

`#mitemc:needs_silver_tool` enthält `#mitemc:needs_mithril_tool`, das wiederum `#mitemc:needs_adamantium_tool` enthält — die Tag-Vererbung macht die Schwerarbeit.

## So liest man eine Werkzeug-ID

Die Item-ID kodiert beide Achsen: `mitemc:<material>_<familie>`.

Beispiele:
- `mitemc:flint_hatchet` — Anfangsbeil zum Fällen.
- `mitemc:copper_war_hammer` — erstes schweres Werkzeug, das Vanilla-Eisenerz abbaut.
- `mitemc:adamantium_dagger` — schnellste Endgame-Waffe.

## Siehe auch

- [Werkzeugstufen](/de/reference/tool-tiers/) — Block → erforderliche Stufe.
- [Materialien](/de/reference/materials/) — Erzgenese, Schmelze, Roh-Drops.
- [Rezepte](/de/recipes/) — exakte Crafting-Muster.

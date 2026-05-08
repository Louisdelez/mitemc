---
title: Öfen
description: Hitzestufen, Brennstoffqualität und die Schmelzmatrix.
sidebar:
  order: 6
---

MITEMCs Schmelzkette ersetzt das „Erz in den Ofen schieben" durch echten Fortschritt. Vier neue Ofenblöcke, jeder mit eigener Hitzestufe, regeln, welche Metalle ihr verhütten könnt.

## Die Kette

```
Lehmofen (0)  →  Sandsteinofen (1)  →  Obsidianofen (2)  →  Netherrack-Ofen (3)
```

Der Vanilla-Ofen wird als **Stufe 1** behandelt — kompatibel zu einem Sandsteinofen.

## Hitzestufen

| Stufe | Block                | Licht wenn an | Tempo × | Brennstoffhinweise                          |
|------:|----------------------|--------------:|--------:|---------------------------------------------|
|    0  | Lehmofen             | 13            | 0,75 ×  | Kohle, Holzkohle, Holz — primitives Kochen  |
|    1  | Sandsteinofen        | 13            | 1,00 ×  | Wie Vanilla-Ofen                            |
|    2  | Obsidianofen         | 14            | 1,40 ×  | Lava-Eimer empfohlen                        |
|    3  | Netherrack-Ofen      | 15            | 1,80 ×  | Lohenruten schalten Adamantium frei         |

## Was schmilzt jede Stufe?

| Rezept                                   | Min. Stufe | Tag-Sperre                                |
|------------------------------------------|-----------:|-------------------------------------------|
| Vanilla-Nahrung / Eisen / Kupfer         |          0 | (keine)                                   |
| `raw_copper_chunk` → `copper_ingot`      |          0 |                                           |
| `raw_silver_chunk` → `silver_ingot`      |          0 |                                           |
| `raw_mithril_chunk` → `mithril_ingot`    |          2 | `#mitemc:requires_obsidian_furnace`       |
| `raw_adamantium_chunk` → `adamantium_ingot` |       3 | `#mitemc:requires_netherrack_furnace`     |

Die Sperre erfolgt über Item-Tags — liegt das *Ergebnis* eines Schmelzrezepts in `#mitemc:requires_obsidian_furnace` und der Ofen ist unter Stufe 2, wird das Rezept stillschweigend übersprungen (Input bleibt, kein Brennstoff verbraucht).

## Öfen craften

| Ofen                | Rezept                                                        |
|---------------------|---------------------------------------------------------------|
| Lehmofen            | 8× Terrakotta im Ofenring                                     |
| Sandsteinofen       | 8× Sandstein im Ofenring                                      |
| Obsidianofen        | 8× Obsidian + 1 Vanilla-Ofen mittig                           |
| Netherrack-Ofen     | 8× Netherziegel + 1 Obsidianofen + 1 Lohenrute (oben rechts)  |

Siehe [Rezepte](/de/recipes/) für die visuellen Muster.

## Brennstoffqualität

Phase 3 legt das Fundament für **Brennstoffqualität**, auch wenn die Laufzeit aktuell nur die Vanilla-Brennzeiten ehrt. Die Infrastruktur unterscheidet z. B. Holz (niedrige Hitze) vs. Lava-Eimer (anhaltende Obsidian-Hitze) vs. Lohenrute (einziger Brennstoff für Netherrack-Stufe).

Beim nächsten Datapack-Durchlauf wird folgende Tabelle kanonisch:

| Brennstoff        | Hitzekapazität | Hinweise                                       |
|-------------------|---------------:|------------------------------------------------|
| Stock / Bretter   | 1              | Nur Lehm-Stufe                                 |
| Kohle / Holzkohle | 1              | Nur Lehm-Stufe                                 |
| Kohleblock        | 2              | Sandstein-Stufe                                |
| Lava-Eimer        | 2              | Sandstein + Obsidian; lange Brennzeit          |
| Lohenrute         | 3              | Erforderlich für Netherrack-Stufe              |

## Phase-3-Fortschrittskette

```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```

`netherrack_furnace` ist eine Challenge-Advancement (goldener Rahmen).

## Siehe auch

- [Materialien](/de/reference/materials/) — Erzerträge und Roh-Drops.
- [Werkzeugstufen](/de/reference/tool-tiers/) — was jedes verhüttete Metall freischaltet.
- [Rezepte](/de/recipes/) — exakte Crafting-Muster für die Öfen.

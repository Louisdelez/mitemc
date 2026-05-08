---
title: Werkzeugstufen
description: Welches Werkzeug baut was ab.
sidebar:
  order: 2
---

## Die Kette

```
Hände → Feuerstein → Kupfer → Eisen → Silber → Mithril → Adamantium
```

Jede Stufe baut ihr eigenes Erz und eine Stufe darunter ab. Vanilla-Eisen sitzt zwischen MITEMCs Kupfer und Silber und überbrückt natürlich.

## Block → erforderliche Stufe

| Block                   | Erforderliche Stufe | Hinweise                                      |
|-------------------------|---------------------|-----------------------------------------------|
| Holz (Stämme)           | Beil+               | Keine Stämme mit bloßen Händen                |
| Blätter                 | keine               | Frei schlagen; Chance auf Stock               |
| Stein                   | Feuerstein+         | Spitzhacke oder Kriegshammer                  |
| Kohleerz                | Feuerstein+         |                                               |
| Vanilla-Eisenerz        | Feuerstein+         | Erlaubt; Kupfer empfohlen für vollen Ertrag   |
| `mitemc:copper_ore`     | Feuerstein+         | Dropt `raw_copper_chunk`                      |
| `mitemc:silver_ore`     | Kupfer+             | **Steinwerkzeuge bauen kein Silber ab**       |
| `mitemc:mithril_ore`    | Silber+             |                                               |
| `mitemc:adamantium_ore` | Mithril+            | Und nur Obsidianofen-Schmelze für den Barren  |

## Werkzeugfamilien

MITEMC liefert **10 Werkzeugfamilien** über die Vanilla-Spitzhacke/Axt/Schaufel/Schwert/Hacke hinaus:

- Knüppel, Keule — stumpfe Waffen (Rückstoß)
- Beil, Streitaxt — Holz + Spalten (Axt-Klasse)
- Messer, Dolch — schnelle Nahkampfwaffen, Pflanzenernte
- Kriegshammer — Stein + schwerer Nahkampf (Spitzhacken-Klasse)
- Bipenne — Kombi-Graben (Spitzhacken-Klasse)
- Sense — Flächenernte (Hacken-Klasse)
- Schaufel — vanilla-typisches Graben

Die volle Schaden-/Geschwindigkeits-/Sperren-Matrix steht in der [Referenz Werkzeuge & Waffen](/de/reference/tools-and-weapons/).

## Phase-2-Fortschrittskette

```
phase2/root  →  first_copper  →  first_silver  →  first_mithril  →  first_adamantium
```

Jede Stufe wird als Toast angezeigt und schaltet die nächste frei. `first_adamantium` ist eine Challenge-Advancement (goldener Rahmen).

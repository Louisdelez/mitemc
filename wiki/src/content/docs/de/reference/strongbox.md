---
title: Tresor
description: Spielergebundene Metallkiste für Mehrspieler.
sidebar:
  order: 9
---

Ein **Tresor** ist eine Truhe, die nur ihr Besitzer öffnen kann. Gedacht für Mehrspielerserver, in denen geteilte Basen privates Lager brauchen, das weder Trichter noch andere Spieler abzapfen können.

## Eisentresor — `mitemc:iron_strongbox`

| Eigenschaft           | Wert                                       |
|-----------------------|--------------------------------------------|
| Lagerplatz            | 27 Slots (Einzel-Truhen-Layout)            |
| Härte                 | 5,0                                        |
| Sprengwiderstand      | 1200 (Obsidian-Klasse)                     |
| Erforderliches Werkzeug| Spitzhacke                                |
| Stapelgröße           | 1 (als Item)                               |
| Besitzer              | UUID des Platzierers                       |

## Funktion

1. **Platzieren.** Die UUID des platzierenden Spielers wird per `setPlacedBy` ans BE gebunden.
2. **Rechtsklick** zum Öffnen. Das `useWithoutItem` des Blocks liest die Besitzer-UUID:
   - Nicht gesetzt (Legacy): öffnet für alle.
   - Stimmt mit Spieler überein: öffnet.
   - Stimmt nicht überein und Spieler **ist kein OP** (Permission-Level ≥ 2): Verweigerung mit übersetzter Nachricht.
3. **Abbauen.** Inhalte fallen am Boden (`playerWillDestroy`-Hook), der Block selbst dropt über die Loot-Table.

Der OP-Override ist gewollt: Server-Admins können jeden Tresor öffnen. Wer das nicht will, überschreibt per Permission-System.

## Crafting

```
I I I
I C I    (I = Eisenbarren, C = Kiste)
I I I
```

8 Eisenbarren im Ring um eine Vanilla-Kiste.

## Trichter-Verhalten

Tresore implementieren **keine** Hopper-Schnittstellen. Trichter können weder einzahlen noch entnehmen — sprengfest, trichterfest.

## Mehrspieler-Hinweise

- Besitzer-UUID überlebt Server-Neustarts (NBT-Schlüssel `Owner`).
- Ändert sich die UUID des Besitzers (selten, aber möglich bei Offline-Mode), ist der Tresor faktisch verwaist — mit Admin-Tools öffnen.
- Tresore sind **nicht** abbau-geschützt — jeder kann sie zerlegen. Inhalte landen auf dem Boden; Tresor-Item ebenfalls. Behandle sie als physische Safes, die aus der Wand gerissen werden können.

## Künftige Varianten

Die Roadmap reserviert Platz für höhere Tier-Tresore nach Phase 7:

- **Mithril-Tresor** — Sprengimmunität + Dimensions-Tracking.
- **Adamantium-Tresor** — widersteht zusätzlich Kreativ-Abbau.

Nicht in Phase 6.

## Phase-6-Fortschritt

`mitemc:phase6/strongbox` löst aus, sobald du einen Tresor im Inventar hast.

## Siehe auch

- [Verzauberungen](/de/reference/enchantments/) — das andere Phase-6-System.
- [Werkzeuge & Waffen](/de/reference/tools-and-weapons/) — Spitzhacke nötig zum Abbauen.

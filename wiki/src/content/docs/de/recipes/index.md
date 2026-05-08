---
title: Rezepte
description: Crafting-Rezepte, die MITEMC einführt oder ändert.
sidebar:
  order: 1
---

Dieser Abschnitt wird perspektivisch automatisch aus dem Datapack der Mod generiert. Unten: alle Phase-1- und Phase-2-Rezepte in der Reihenfolge, in der man sie entdeckt.

## Phase 1 — Sammeln

### Stock aus Blättern *(passiv)*
Kein Craft — gebrochene oder verfallende Blätter haben 4 % Chance auf einen Stock (25 % davon bei natürlichem Verfall).

## Phase 2 — Werkzeug-Crafting

Jede Werkzeugfamilie hat ein festes Muster. Die Material-Plätze füllt **Feuersteinsplitter** für Feuerstein-Werkzeuge bzw. der entsprechende **Barren** für Kupfer-/Silber-/Mithril-/Adamantium-Werkzeuge. `S` = Stock, `M` = Material.

### Knüppel — `[ M / M / S ]`
```
. M .
. M .
. S .
```

### Keule — `[ MMM / S / S ]`
```
M M M
. S .
. S .
```

### Beil — `[ MM / MS / S ]`
```
M M .
M S .
. S .
```

### Messer — klein (2 Felder)
```
M . .
S . .
```

### Dolch — klein (2 Felder)
```
. M .
. S .
```

### Kriegshammer — `[ MMM / MSM / S ]`
```
M M M
M S M
. S .
```

### Streitaxt — gleiches Muster wie Kriegshammer
Die Form ist identisch; das Rezept unterscheidet sich nur über die Ergebnis-ID.

### Bipenne — `[ MMM / S / S ]`
```
M M M
. S .
. S .
```

### Sense — `[ MM / SM / S ]`
```
M M .
. S M
. S .
```

### Schaufel — Vanilla-Form
```
. M .
. S .
. S .
```

## Schmelze

| Eingabe              | Ausgabe        | Methode  | Zeit  |
|----------------------|----------------|----------|-------|
| raw_copper_chunk     | copper_ingot   | smelting | 10 s  |
| raw_copper_chunk     | copper_ingot   | blasting | 5 s   |
| raw_silver_chunk     | silver_ingot   | smelting | 10 s  |
| raw_silver_chunk     | silver_ingot   | blasting | 5 s   |
| raw_mithril_chunk    | mithril_ingot  | smelting | 10 s  |
| raw_mithril_chunk    | mithril_ingot  | blasting | 5 s   |

Adamantium-Erz dropt direkt den Barren — Phase 3 wird das hinter einem Netherrack-Ofen sperren.

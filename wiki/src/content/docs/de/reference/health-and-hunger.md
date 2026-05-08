---
title: Leben & Hunger
description: Exakte Regeln für Spielerstats in MITEMC.
sidebar:
  order: 1
---

Die Signaturmechanik von MITEMC: Sie starten zerbrechlich und werden mit Erfahrung stärker.

## Startwerte

| Stat            | Vanilla | MITEMC |
|-----------------|---------|--------|
| Max. Herzen     | 10      | **3**  |
| Max. Hungerleisten | 10   | **3**  |
| Natürliche Regen. | ja    | langsam |
| Grundumsatz     | keiner  | passive Erschöpfung |

## Wachstumskurve

Alle **5 XP-Stufen** erhalten Sie **+1 Herz und +1 Hungerleiste**, gedeckelt bei den Vanilla-10/10.

| XP-Stufe | Herzen | Hunger |
|----------|--------|--------|
| 0        | 3      | 3      |
| 5        | 4      | 4      |
| 10       | 5      | 5      |
| 15       | 6      | 6      |
| 20       | 7      | 7      |
| 25       | 8      | 8      |
| 30       | 9      | 9      |
| 35+      | 10     | 10     |

## Grundumsatz

Auch im Stehen verbraucht Ihr Charakter Energie. Standardrate: **0,0005 pro Tick** (0,01 pro Sekunde). Bei voller Sättigung leert das eine Hungerleiste in etwa 3 Spielminuten.

## Regenstrafe

Bei Regenexposition wird der Grundumsatz mit **3×** multipliziert. Ein Dach oder beliebiger fester Block über dem Kopf hebt die Strafe auf.

## Hungerschwäche

Wenn der Hunger **unter 1 Symbol** fällt (interner Wert < 1):

- Effekt **Hungerschwäche** wird angewendet (kosmetische Anzeige).
- **Langsamkeit II** wird angewendet.
- Sie können **keine Blöcke abbauen oder platzieren**.

Der Zustand endet, sobald Sie etwas essen, das den Hunger auf 1 oder mehr bringt.

## Konfiguration

Alle Werte sind in `config/mitemc-common.toml` einstellbar. Siehe [Konfigurationsreferenz](/de/reference/config/) für das vollständige TOML.

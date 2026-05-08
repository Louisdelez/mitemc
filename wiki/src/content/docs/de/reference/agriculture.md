---
title: Landwirtschaft
description: Pflanzen, Pflanzenbrand, Mist, Wetter und Temperatur.
sidebar:
  order: 7
---

Phase 5 verwandelt das Farmen aus „setzen und vergessen" in einen Risikokalender: Pflanzen können mitten in der Saison verfaulen, Regen beschleunigt und bedroht zugleich, und kalte Biome verbrennen den Hunger schneller.

## Die Zwiebelpflanze

`mitemc:onion_crop` erweitert das Vanilla-`CropBlock` um eine zusätzliche Block-State-Eigenschaft: **`blighted`** (boolean).

| Eigenschaft | Werte  | Effekt                                                              |
|-------------|--------|---------------------------------------------------------------------|
| `age`       | 0–7    | Standardprogression                                                 |
| `blighted`  | bool   | Wenn `true`, Wachstum gestoppt; reife Pflanze gibt nur Samen        |

### Drops

| Bedingung                       | Drop                                          |
|---------------------------------|-----------------------------------------------|
| Beliebiges Alter                | 1× Zwiebelsamen                               |
| `age=7`, `blighted=false`       | + 1–2 Zwiebeln                                |
| `age=7`                         | + 0–2 zusätzliche Samen (Glück-Boost)         |
| `age=7`, `blighted=true`        | nur die Samen — keine Zwiebeln                |

Zwiebel: Nahrung 2, Sättigung 0,4 — bescheiden, gedacht für Eintöpfe.

## Pflanzenbrand

Eine **reife, nicht befallene** MITEMC-Pflanze hat pro Random-Tick eine Chance auf Befall (`crop_blight_chance`, Standard 0,5 %). Einmal befallen:

- Wachstum ist **gestoppt** (Block bleibt bei `age=7`).
- Pro Random-Tick wird eine Chance ausgewürfelt, einen **horizontalen Nachbarn** zu infizieren, der ebenfalls reif und sauber ist (`blight_spread_chance`, Standard 10 %).
- Die Ernte gibt keine Zwiebel (nur Samen).
- Rechtsklick mit Mist räumt das `BLIGHTED`-Flag.

Verbreitung erfolgt mit einem Nachbarn pro Tick, gewählt aus den vier Himmelsrichtungen. Eine unbeobachtete Reihe reifer Zwiebeln wird letztlich komplett befallen — Erntepläne machen.

## Mist

| Quelle                                 | Verhalten                                                              |
|----------------------------------------|------------------------------------------------------------------------|
| Random-Tick von Kuh / Schwein          | Chance pro Tick, ein `mitemc:manure`-Item zu droppen (Standard 0,01 %) |
| Rechtsklick auf eine befallene MITEMC-Pflanze | Räumt das BLIGHTED-Flag, verbraucht 1 Mist                       |
| Rechtsklick auf eine Vanilla-Pflanze   | Wirkt wie Knochenmehl (rückt Alter zufällig vor)                       |

Mist lässt **keine** Bäume, kein Gras und keine Blumen wachsen — nur Pflanzen.

## Wettereffekte

| Wetter  | Effekt                                                                                |
|---------|---------------------------------------------------------------------------------------|
| Regen   | Spieler im Freien: Hunger ×3 (Phase 1)                                                |
| Regen   | MITEMC-Pflanzen mit Himmelszugang: ~20 % bonus Wachstums-Tick pro Random-Tick         |
| Regen   | Angeln: ~25 % Chance auf Bonus-Drop (Kabeljau oder Seetang) pro Fang                  |

Das Zusammenspiel aus Bonuswachstum und Brand-Risiko ist gewollt: Regen füttert deine Felder und füttert die Fäule.

## Temperatur

Steht ein Spieler in einem Biom unterhalb `cold_biome_threshold` (Standard 0,2), wird der Grundumsatz mit `cold_biome_mult` (Standard 2,0) multipliziert. Stapeleffekte:

| Bedingungen                            | Effektiver Grundumsatz-Multiplikator |
|----------------------------------------|------------------------------------:|
| Warmes Biom, geschützt                 | 1,0×                                |
| Warmes Biom, im Regen                  | 3,0×                                |
| Kaltes Biom, geschützt                 | 2,0×                                |
| Kaltes Biom, im Regen                  | 4,0× (3 + 2 − 1, Deltas gestapelt)  |

Schnee- und Frostbiome leeren den Hunger schnell — Trockenfleisch einpacken.

## Phase-5-Fortschrittskette

```
phase5/root  →  first_onion  →  cure_blight (Ziel)  →  full_pantry (Herausforderung)
```

`full_pantry` verlangt 16 Zwiebeln, 16 Weizen und 16 Karotten — Beweis einer tragfähigen Nahrungswirtschaft.

## Konfigurationsstellschrauben

Alle Phase-5-Werte stehen unter `[phase5]` in `config/mitemc-common.toml`:

```toml
[phase5.agriculture]
crop_blight_chance     = 0.005
blight_spread_chance   = 0.10
rain_growth_chance     = 0.20
animal_manure_chance   = 0.0001

[phase5.environment]
cold_biome_mult        = 2.0
cold_biome_threshold   = 0.2
rain_fishing_bonus     = 0.25
```

Nach Geschmack tunen — Vanilla-Feel-Server können Brand auf 0 senken; Hardcore-Server hochdrehen auf 0,02.

## Siehe auch

- [Leben & Hunger](/de/reference/health-and-hunger/) — Grundumsatz, Regenstrafe.
- [Öfen](/de/reference/furnaces/) — was mit der Ernte tun.
- [Bestiarium](/de/bestiary/) — Tiere, die Mist droppen und gefüttert werden müssen.

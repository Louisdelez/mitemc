---
title: Konfiguration
description: Alle MITEMC-Stellschrauben an einem Ort.
sidebar:
  order: 12
---

Alle MITEMC-Tunables liegen in `config/mitemc-common.toml` (beim ersten Start erstellt). Die Datei wird regeneriert, wenn sie fehlt; Teiländerungen bleiben beim Update erhalten.

## Phase 1 — Überlebensfundamente

```toml
[phase1.starting_stats]
starting_hearts        = 3
starting_food          = 3
level_interval         = 5
hearts_per_interval    = 1
food_per_interval      = 1
max_hearts_cap         = 10
max_food_cap           = 10

[phase1.hunger]
basal_exhaustion_per_tick   = 0.0005
rain_multiplier             = 3.0
starvation_threshold        = 1

[phase1.foraging]
sticks_from_leaves       = true
stick_from_leaf_chance   = 0.04
```

## Phase 5 — Landwirtschaft, Wetter, Umgebung

```toml
[phase5.agriculture]
crop_blight_chance       = 0.005
blight_spread_chance     = 0.10
rain_growth_chance       = 0.20
animal_manure_chance     = 0.0001

[phase5.environment]
cold_biome_mult          = 2.0
cold_biome_threshold     = 0.2
rain_fishing_bonus       = 0.25
```

## Tuning-Rezepte

| Ziel                              | Empfohlene Änderungen                                            |
|-----------------------------------|------------------------------------------------------------------|
| **Vanilla-ish** (leicht)          | `starting_hearts=10`, `starting_food=10`, `crop_blight_chance=0` |
| **Hardcore** (echtes MITE-Gefühl) | `crop_blight_chance=0.02`, `cold_biome_mult=3.0`, `rain_multiplier=5.0` |
| **Kein Agrarrisiko**              | `crop_blight_chance=0`, `blight_spread_chance=0`                 |
| **Mehrspielerfreundlicher Hunger**| `basal_exhaustion_per_tick=0.0002`, `rain_multiplier=2.0`        |

## Reload-Verhalten

NeoForge-`COMMON`-Configs werden beim Weltladen neu geladen. Live-Bearbeitung in einer Sitzung:
1. `config/mitemc-common.toml` bearbeiten.
2. Speichern, dann erneut in die Welt eintreten (für manche Werte nicht zwingend; manche Attribut-Caches benötigen ein Respawn).

## Phasen ohne dedizierte Config

- **Phase 2** (Werkzeuge, Erze) — Rezepte und Stufenmappings im Datapack-JSON; keine Runtime-Knöpfe.
- **Phase 3** (Öfen) — Hitzestufen sind Enum mit `speedMultiplier()`-Tabelle; keine Runtime-Knöpfe (Rebuild nötig).
- **Phase 4** (Mobs) — Attribute im Code; Spawn-Gewichte in `data/neoforge/biome_modifier/*.json`. Override per Datapack.
- **Phase 6** (Verzauberungen) — JSON-Definitionen; `min_cost`/`max_cost`/`weight` per Datapack-Overlay editierbar.
- **Phase 7** (Lore, Fortschritte) — nur Datapack.

Phase-1- und Phase-5-Sektionen sind die runtime-tunbaren, weil sie das Per-Tick-Spielgefühl direkt beeinflussen.

## Override per Datapack

Jede datapack-getriebene Datei kann in einem serverseitigen Datapack überschrieben werden: Tags, Rezepte, Fortschritte, Biome-Modifier, Verzauberungen, Loot-Tables. Datei am gleichen Pfad unter `data/mitemc/...` ablegen, um zu ersetzen.

## Siehe auch

- [Leben & Hunger](/de/reference/health-and-hunger/) — wie Phase-1-Werte sich anfühlen.
- [Landwirtschaft](/de/reference/agriculture/) — Phase-5-Spezifika.

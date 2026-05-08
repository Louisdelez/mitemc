---
title: Configurazione
description: Tutte le manopole MITEMC, in un unico posto.
sidebar:
  order: 12
---

Tutti i parametri MITEMC vivono in `config/mitemc-common.toml` (creato al primo avvio). Il file viene rigenerato se manca; le modifiche parziali sono preservate al update.

## Fase 1 — Fondamenta di sopravvivenza

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

## Fase 5 — Agricoltura, meteo, ambiente

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

## Ricette di taratura

| Obiettivo                            | Modifiche consigliate                                            |
|--------------------------------------|------------------------------------------------------------------|
| **Quasi-vanilla** (light)            | `starting_hearts=10`, `starting_food=10`, `crop_blight_chance=0` |
| **Hardcore** (vero feeling MITE)     | `crop_blight_chance=0.02`, `cold_biome_mult=3.0`, `rain_multiplier=5.0` |
| **Senza rischio agricolo**           | `crop_blight_chance=0`, `blight_spread_chance=0`                 |
| **Fame friendly multigiocatore**     | `basal_exhaustion_per_tick=0.0002`, `rain_multiplier=2.0`        |

## Comportamento di reload

Le config `COMMON` di NeoForge si ricaricano al caricamento del mondo. Per editare in sessione:
1. Modificare `config/mitemc-common.toml`.
2. Salvare e rientrare nel mondo.

## Fasi senza config dedicata

- **Fase 2** (strumenti, minerali) — JSON datapack.
- **Fase 3** (forni) — enum con tabella `speedMultiplier()`.
- **Fase 4** (mob) — attributi nel codice; pesi spawn in `data/neoforge/biome_modifier/*.json`.
- **Fase 6** (incantesimi) — definizioni JSON.
- **Fase 7** (lore, traguardi) — solo datapack.

## Override via datapack

Qualunque file data-driven può essere sovrascritto in datapack lato server: tag, ricette, traguardi, modificatori di bioma, incantesimi, loot table.

## Vedi anche

- [Salute e fame](/it/reference/health-and-hunger/)
- [Agricoltura](/it/reference/agriculture/)

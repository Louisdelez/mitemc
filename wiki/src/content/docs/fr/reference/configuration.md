---
title: Configuration
description: Tous les boutons de réglage MITEMC, au même endroit.
sidebar:
  order: 12
---

Tous les paramètres ajustables MITEMC vivent dans `config/mitemc-common.toml` (créé au premier lancement). Le fichier est régénéré s'il manque ; les modifications partielles sont préservées à la mise à jour.

## Phase 1 — Fondations de survie

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

## Phase 5 — Agriculture, météo, environnement

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

## Recettes de réglage

| Objectif                            | Modifications recommandées                                       |
|-------------------------------------|------------------------------------------------------------------|
| **Quasi-vanilla** (lite)            | `starting_hearts=10`, `starting_food=10`, `crop_blight_chance=0` |
| **Hardcore** (vrai feeling MITE)    | `crop_blight_chance=0.02`, `cold_biome_mult=3.0`, `rain_multiplier=5.0` |
| **Sans risque agricole**            | `crop_blight_chance=0`, `blight_spread_chance=0`                 |
| **Faim multijoueur-friendly**       | `basal_exhaustion_per_tick=0.0002`, `rain_multiplier=2.0`        |

## Comportement de rechargement

Les configs `COMMON` NeoForge se rechargent au chargement du monde. Pour éditer en session :
1. Modifier `config/mitemc-common.toml`.
2. Sauvegarder, puis rentrer dans le monde (pas strictement requis pour certaines valeurs ; certains caches d'attributs nécessitent un respawn).

## Phases sans config dédiée

- **Phase 2** (outils, minerais) — recettes et mappings de paliers en JSON datapack ; pas de boutons runtime.
- **Phase 3** (fours) — paliers de chaleur en enum avec table `speedMultiplier()` ; pas de boutons runtime (rebuild requis).
- **Phase 4** (mobs) — attributs par défaut en code ; poids de spawn dans `data/neoforge/biome_modifier/*.json`. Override via datapack.
- **Phase 6** (enchantements) — définitions JSON ; `min_cost` / `max_cost` / `weight` éditables via overlay datapack.
- **Phase 7** (lore, advancements) — datapack uniquement.

Les sections phase 1 et phase 5 sont les ajustables en runtime parce qu'elles affectent directement le feeling par tick.

## Override via datapack

Tout fichier data-driven peut être overridé dans un datapack côté serveur : tags, recettes, advancements, biome modifiers, enchantements, loot tables. Déposez un fichier au même chemin sous `data/mitemc/...` du datapack pour remplacer.

## Voir aussi

- [Vie et faim](/fr/reference/health-and-hunger/) — comment les chiffres de la Phase 1 se ressentent en jeu.
- [Agriculture](/fr/reference/agriculture/) — spécifiques de la Phase 5.

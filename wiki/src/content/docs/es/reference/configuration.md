---
title: Configuración
description: Cada perilla de MITEMC, en un solo sitio.
sidebar:
  order: 12
---

Todos los ajustes MITEMC viven en `config/mitemc-common.toml` (creado al primer arranque). El archivo se regenera si falta; las ediciones parciales se preservan en actualización.

## Fase 1 — Cimientos de supervivencia

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

## Fase 5 — Agricultura, clima, entorno

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

## Recetas de afinado

| Objetivo                            | Cambios recomendados                                             |
|-------------------------------------|------------------------------------------------------------------|
| **Casi-vanilla** (suave)            | `starting_hearts=10`, `starting_food=10`, `crop_blight_chance=0` |
| **Hardcore** (verdadero MITE)       | `crop_blight_chance=0.02`, `cold_biome_mult=3.0`, `rain_multiplier=5.0` |
| **Sin riesgo agrícola**             | `crop_blight_chance=0`, `blight_spread_chance=0`                 |
| **Hambre amigable multijugador**    | `basal_exhaustion_per_tick=0.0002`, `rain_multiplier=2.0`        |

## Comportamiento de recarga

Las configs `COMMON` de NeoForge se recargan al cargar mundo. Editar en sesión:
1. Editar `config/mitemc-common.toml`.
2. Guardar y reentrar al mundo.

## Fases sin config dedicada

- **Fase 2** (herramientas, minerales) — recetas y mappings de nivel en JSON datapack.
- **Fase 3** (hornos) — niveles de calor enum con tabla `speedMultiplier()`.
- **Fase 4** (mobs) — atributos en código; pesos de spawn en `data/neoforge/biome_modifier/*.json`.
- **Fase 6** (encantamientos) — definiciones JSON; `min_cost`/`max_cost`/`weight` editables vía overlay datapack.
- **Fase 7** (lore, logros) — solo datapack.

## Override vía datapack

Cualquier archivo data-driven puede sobreescribirse en datapack del lado servidor: tags, recetas, logros, modificadores de bioma, encantamientos, loot tables.

## Ver también

- [Salud y hambre](/es/reference/health-and-hunger/) — cómo se sienten los números de la Fase 1.
- [Agricultura](/es/reference/agriculture/) — específicos de la Fase 5.

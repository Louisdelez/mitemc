---
title: Agriculture
description: Crops, blight, manure, weather, and temperature.
sidebar:
  order: 7
---

Phase 5 turns farming from "set and forget" into a calendar of risks: crops can rot mid-season, rain accelerates and threatens at once, and cold biomes burn your hunger faster.

## The onion crop

`mitemc:onion_crop` extends vanilla `CropBlock` with one extra block-state property: **`blighted`** (boolean).

| Property   | Values | Effect                                                            |
|------------|--------|-------------------------------------------------------------------|
| `age`      | 0–7    | Standard crop progression                                         |
| `blighted` | bool   | While `true`, growth is suppressed; mature crop drops only seeds  |

### Drops

| Condition                       | Drop                                       |
|---------------------------------|--------------------------------------------|
| Any age                         | 1× onion seeds                             |
| `age=7`, `blighted=false`       | + 1–2 onions                               |
| `age=7`                         | + 0–2 extra onion seeds (Fortune-boosted)  |
| `age=7`, `blighted=true`        | only the seeds — no onions                 |

Onion food: nutrition 2, saturation 0.4 — modest, designed to combine into stews.

## Crop blight

A **mature, non-blighted** MITEMC crop has a per-random-tick chance to develop blight (`crop_blight_chance`, default 0.5%). Once blighted:

- Growth is **paused** (the block won't progress out of `age=7`).
- The block re-rolls per random-tick to **infect a horizontal neighbour** that is also mature and non-blighted (`blight_spread_chance`, default 10%).
- Harvesting it yields no onion (only seeds).
- Manure right-click clears the `BLIGHTED` flag.

Spread is one neighbour per tick, picked among the four cardinal directions. A row of mature onions left unattended will eventually all turn — plan for harvesting.

## Manure

| Source                | Behavior                                                            |
|-----------------------|---------------------------------------------------------------------|
| Cow / pig random tick | Per-tick chance to drop a `mitemc:manure` item (default 0.01%)      |
| Right-click on a blighted MITEMC crop | Clears the BLIGHTED flag, consumes 1 manure        |
| Right-click on any vanilla crop | Acts as bone meal (advances age randomly)                |

Manure does **not** grow trees, grass, or flowers — it's a crop-only fertilizer.

## Weather effects

| Weather   | Effect                                                                 |
|-----------|------------------------------------------------------------------------|
| Rain      | Player exposed to sky: hunger ×3 (Phase 1)                             |
| Rain      | MITEMC crops with sky access: ~20% bonus growth tick per random-tick   |
| Rain      | Fishing: ~25% chance of a bonus drop (cod or kelp) per catch           |

The bonus growth + blight risk is intentional: rain feeds your fields and feeds the rot.

## Temperature

When a player stands in a biome below `cold_biome_threshold` (default 0.2), basal metabolism is multiplied by `cold_biome_mult` (default 2.0×). Stack effects:

| Conditions                              | Effective basal multiplier vs. baseline |
|-----------------------------------------|----------------------------------------:|
| Warm biome, sheltered                   | 1.0×                                    |
| Warm biome, in rain                     | 3.0×                                    |
| Cold biome, sheltered                   | 2.0×                                    |
| Cold biome, in rain                     | 4.0× (3 + 2 − 1, deltas stacked)        |

Snowy and frozen biomes drain hunger fast — pack jerky.

## Phase 5 advancement chain

```
phase5/root  →  first_onion  →  cure_blight (goal)  →  full_pantry (challenge)
```

`full_pantry` requires 16 onions, 16 wheat, and 16 carrots — proof of a sustainable food economy.

## Configuration knobs

All Phase 5 numbers live under `[phase5]` in `config/mitemc-common.toml`:

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

Tune for your taste — vanilla-feel servers can drop blight to 0; hardcore servers can crank to 0.02.

## See also

- [Health & Hunger](/en/reference/health-and-hunger/) — basal exhaustion, rain penalty.
- [Furnaces](/en/reference/furnaces/) — what to do with your harvest.
- [Bestiary](/en/bestiary/) — animals that drop manure and need feeding.

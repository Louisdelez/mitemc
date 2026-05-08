---
title: Configuration
description: Every MITEMC config knob, in one place.
sidebar:
  order: 12
---

All MITEMC tunables live in `config/mitemc-common.toml` (created on first launch). The file is regenerated if missing; partial edits are preserved on update.

## Phase 1 — Survival foundations

```toml
[phase1.starting_stats]
starting_hearts        = 3        # Hearts the player starts with (1..10)
starting_food          = 3        # Food icons the player starts with (1..10)
level_interval         = 5        # XP levels per +1 heart / +1 food
hearts_per_interval    = 1        # Hearts gained per interval (0..10)
food_per_interval      = 1        # Food icons gained per interval (0..10)
max_hearts_cap         = 10       # Hard cap regardless of level (1..30)
max_food_cap           = 10       # Hard cap regardless of level (1..20)

[phase1.hunger]
basal_exhaustion_per_tick   = 0.0005   # Idle exhaustion rate
rain_multiplier             = 3.0      # ×basal when exposed to rain
starvation_threshold        = 1        # Below this, can't break/place blocks

[phase1.foraging]
sticks_from_leaves       = true        # Toggle leaf → stick drops entirely
stick_from_leaf_chance   = 0.04        # Probability per leaf-decay/break
```

## Phase 5 — Agriculture, weather, environment

```toml
[phase5.agriculture]
crop_blight_chance       = 0.005       # Mature MITEMC crop blight chance per random-tick
blight_spread_chance     = 0.10        # Blight spread chance per random-tick
rain_growth_chance       = 0.20        # Bonus growth tick chance during rain
animal_manure_chance     = 0.0001      # Cow/pig per-tick manure drop chance

[phase5.environment]
cold_biome_mult          = 2.0         # Basal exhaustion ×= this in cold biomes
cold_biome_threshold     = 0.2         # Biome temperature below = cold (vanilla 0.0–0.2)
rain_fishing_bonus       = 0.25        # Extra-loot probability when fishing in rain
```

## Tuning recipes

| Goal                              | Recommended changes                                              |
|-----------------------------------|------------------------------------------------------------------|
| **Vanilla-ish** (lite difficulty) | `starting_hearts=10`, `starting_food=10`, `crop_blight_chance=0` |
| **Hardcore** (true MITE feel)     | `crop_blight_chance=0.02`, `cold_biome_mult=3.0`, `rain_multiplier=5.0` |
| **No agriculture risk**           | `crop_blight_chance=0`, `blight_spread_chance=0`                 |
| **Multiplayer-friendly hunger**   | `basal_exhaustion_per_tick=0.0002`, `rain_multiplier=2.0`        |

## Reload behavior

NeoForge `COMMON` configs reload on world load. To live-edit during a session:
1. Edit `config/mitemc-common.toml`.
2. Save, then re-enter the world (not strictly required for some values; some attribute caches need a respawn).

## Phases without dedicated config

- **Phase 2** (tools, ores) — recipes and tier mappings live in datapack JSON; no runtime knobs.
- **Phase 3** (furnaces) — heat tiers are an enum with a `speedMultiplier()` table; no runtime knobs (rebuild required to change).
- **Phase 4** (mobs) — attribute defaults in code; spawn weights in `data/neoforge/biome_modifier/*.json`. Override via datapack.
- **Phase 6** (enchantments) — JSON definitions; `min_cost` / `max_cost` / `weight` editable via datapack overlay.
- **Phase 7** (lore, advancements) — datapack-only.

The phase-1 and phase-5 sections are the runtime-tunable ones because they directly affect per-tick player feel.

## Override via datapack

Any datapack-driven file can be overridden in a server-side datapack: tags, recipes, advancements, biome modifiers, enchantments, loot tables. Drop a file at the same path under your datapack's `data/mitemc/...` to replace.

## See also

- [Health & Hunger](/en/reference/health-and-hunger/) — how Phase 1 numbers feel in play.
- [Agriculture](/en/reference/agriculture/) — Phase 5 specifics.

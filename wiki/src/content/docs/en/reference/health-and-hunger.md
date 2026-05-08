---
title: Health & Hunger
description: Exact rules for player stats in MITEMC.
sidebar:
  order: 1
---

MITEMC's signature mechanic: you start fragile and grow stronger with experience.

## Starting values

| Stat             | Vanilla | MITEMC |
|------------------|---------|--------|
| Max hearts       | 10      | **3**  |
| Max food icons   | 10      | **3**  |
| Natural regen    | yes     | slow   |
| Basal metabolism | none    | passive exhaustion |

## Growth curve

Every **5 XP levels** you gain **+1 heart and +1 food icon**, capped at the vanilla 10/10.

| XP level | Hearts | Food |
|----------|--------|------|
| 0        | 3      | 3    |
| 5        | 4      | 4    |
| 10       | 5      | 5    |
| 15       | 6      | 6    |
| 20       | 7      | 7    |
| 25       | 8      | 8    |
| 30       | 9      | 9    |
| 35+      | 10     | 10   |

## Basal metabolism

Even standing still, your character expends energy. The default exhaustion rate is **0.0005 per tick** (0.01 per second). At full saturation that depletes one food icon roughly every 3 in-game minutes.

## Rain penalty

Exposed to rain, basal exhaustion is multiplied by **3×**. A roof or any solid block above your head suppresses the penalty.

## Starvation weakness

When food drops **below 1 icon** (internal value < 1):

- The **Starvation Weakness** effect is applied (cosmetic indicator).
- **Slowness II** is applied.
- You **cannot break or place blocks**.

The state ends as soon as you eat anything that brings food back to or above 1.

## Configuration

All values are tunable in `config/mitemc-common.toml`. See the [config reference](/en/reference/config/) for the full TOML.

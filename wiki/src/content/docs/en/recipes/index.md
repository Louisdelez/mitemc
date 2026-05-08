---
title: Recipes
description: Crafting recipes introduced or changed by MITEMC.
sidebar:
  order: 1
---

This section will eventually auto-generate from the mod's datapack. Below: every Phase 1 + Phase 2 recipe in the order you'll discover them.

## Phase 1 — Foraging

### Stick from leaves *(passive)*
Not a craft — leaves dropped or broken have a 4 % chance to yield a stick (25 % of that on natural decay).

## Phase 2 — Tool crafting

Each tool family has a fixed pattern. Material slots are filled with **flint shards** for flint tools and the appropriate **ingot** for copper/silver/mithril/adamantium tools. `S` = stick, `M` = material.

### Cudgel — `[ M / M / S ]`
```
. M .
. M .
. S .
```

### Club — `[ MMM / S / S ]`
```
M M M
. S .
. S .
```

### Hatchet — `[ MM / MS / S ]`
```
M M .
M S .
. S .
```

### Knife — small (2 cells)
```
M . .
S . .
```

### Dagger — small (2 cells)
```
. M .
. S .
```

### War Hammer — `[ MMM / MSM / S ]`
```
M M M
M S M
. S .
```

### Battle Axe — same pattern as War Hammer
The shape is identical; the recipe is distinguished by the result item ID.

### Mattock — `[ MMM / S / S ]`
```
M M M
. S .
. S .
```

### Scythe — `[ MM / SM / S ]`
```
M M .
. S M
. S .
```

### Shovel — vanilla-style
```
. M .
. S .
. S .
```

## Smelting

| Input              | Output         | Method   | Time |
|--------------------|----------------|----------|------|
| raw_copper_chunk   | copper_ingot   | smelting | 10 s |
| raw_copper_chunk   | copper_ingot   | blasting | 5 s  |
| raw_silver_chunk   | silver_ingot   | smelting | 10 s |
| raw_silver_chunk   | silver_ingot   | blasting | 5 s  |
| raw_mithril_chunk  | mithril_ingot  | smelting | 10 s |
| raw_mithril_chunk  | mithril_ingot  | blasting | 5 s  |

Adamantium ore drops the ingot directly — Phase 3 will gate it behind a netherrack furnace.

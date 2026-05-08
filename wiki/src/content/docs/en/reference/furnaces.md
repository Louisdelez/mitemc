---
title: Furnaces
description: Heat tiers, fuel quality and the smelting matrix.
sidebar:
  order: 6
---

MITEMC's smelting chain replaces "shove ore in furnace" with a real progression. Four new furnace blocks, each with its own heat tier, gate which metals you can refine.

## The chain

```
Clay Oven (0)  →  Sandstone Oven (1)  →  Obsidian Furnace (2)  →  Netherrack Furnace (3)
```

The vanilla furnace is treated as **tier 1** — equivalent to a sandstone oven for compatibility.

## Heat tiers

| Tier | Block               | Light when lit | Speed × | Fuel notes                              |
|-----:|---------------------|---------------:|--------:|-----------------------------------------|
|   0  | Clay Oven           | 13             | 0.75 ×  | Coal, charcoal, wood — primitive cooking |
|   1  | Sandstone Oven      | 13             | 1.00 ×  | Same as vanilla furnace                 |
|   2  | Obsidian Furnace    | 14             | 1.40 ×  | Lava buckets recommended                |
|   3  | Netherrack Furnace  | 15             | 1.80 ×  | Blaze rods unlock adamantium            |

## What can each tier smelt?

| Recipe                              | Min tier | Tag gating                              |
|-------------------------------------|---------:|-----------------------------------------|
| Vanilla food / iron / copper        |        0 | (none)                                  |
| `raw_copper_chunk` → `copper_ingot` |        0 |                                         |
| `raw_silver_chunk` → `silver_ingot` |        0 |                                         |
| `raw_mithril_chunk` → `mithril_ingot` |     2 | `#mitemc:requires_obsidian_furnace`     |
| `raw_adamantium_chunk` → `adamantium_ingot` |  3 | `#mitemc:requires_netherrack_furnace`   |

The gating is enforced via item tags — if the *result* of a smelting recipe is in `#mitemc:requires_obsidian_furnace` and the furnace is below tier 2, the recipe is silently skipped (the input stays unchanged, no fuel is consumed).

## Crafting the furnaces

| Furnace             | Recipe                                            |
|---------------------|---------------------------------------------------|
| Clay Oven           | 8× terracotta in a furnace ring                   |
| Sandstone Oven      | 8× sandstone in a furnace ring                    |
| Obsidian Furnace    | 8× obsidian + 1 vanilla furnace in the center     |
| Netherrack Furnace  | 8× nether bricks + 1 obsidian furnace + 1 blaze rod (top-right) |

See [Recipes](/en/recipes/) for the visual patterns.

## Fuel quality

Phase 3 lays the foundation for **fuel quality** even though the runtime currently honors only vanilla burn-time values. The infrastructure is in place to differentiate, e.g., wood (low heat) vs. lava bucket (sustained obsidian-tier heat) vs. blaze rod (only fuel that unlocks netherrack-tier output).

When the next datapack pass lands, this table will become canonical:

| Fuel             | Heat capacity | Notes                                        |
|------------------|--------------:|----------------------------------------------|
| Stick / planks   | 1             | Clay-tier only                               |
| Coal / charcoal  | 1             | Clay-tier only                               |
| Coal block       | 2             | Sandstone-tier                               |
| Lava bucket      | 2             | Sandstone+obsidian; long burn time           |
| Blaze rod        | 3             | Required for netherrack-tier smelts          |

## Phase 3 advancement chain

```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```

`netherrack_furnace` is a challenge advancement (gold border).

## See also

- [Materials](/en/reference/materials/) — ore yields and raw drops.
- [Tool Tiers](/en/reference/tool-tiers/) — what each smelted metal unlocks.
- [Recipes](/en/recipes/) — exact crafting patterns for the furnaces.

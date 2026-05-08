---
title: Materials
description: Ore generation, raw drops, and smelting.
sidebar:
  order: 5
---

MITEMC adds four metals to the vanilla material set: **copper, silver, mithril, adamantium**.
(Iron, gold, redstone, lapis, diamond, emerald and netherite remain vanilla.)

## Ore blocks

| Ore                        | Found in       | Hardness | XP drop | Drops                    |
|----------------------------|----------------|----------|---------|--------------------------|
| `mitemc:copper_ore`        | overworld stone| 3.0      | 0       | `raw_copper_chunk`       |
| `mitemc:silver_ore`        | deep stone     | 4.0      | 0–2     | `raw_silver_chunk`       |
| `mitemc:mithril_ore`       | deep stone     | 5.0      | 2–5     | `raw_mithril_chunk`      |
| `mitemc:adamantium_ore`    | netherrack     | 7.0      | 4–8     | `adamantium_ingot` (1–2) |

Adamantium drops the ingot directly because only Nether-fired furnaces can smelt the raw form, and we don't yet ship raw adamantium as a holding item.

## Mining requirements

| Ore                   | Minimum tool tier   |
|-----------------------|---------------------|
| `copper_ore`          | flint (stone-equiv) |
| `silver_ore`          | copper              |
| `mithril_ore`         | silver              |
| `adamantium_ore`      | mithril             |

Vanilla iron ore: copper-tier in MITEMC (it lives in `#minecraft:needs_stone_tool` — flint can mine it via vanilla rules but the spirit is "use copper or up").

## Smelting

| Recipe                     | Type     | Time    | XP   |
|----------------------------|----------|---------|------|
| raw_copper → copper_ingot  | smelting | 200 t   | 0.7  |
| raw_silver → silver_ingot  | smelting | 200 t   | 0.7  |
| raw_mithril → mithril_ingot| smelting | 200 t   | 0.7  |
| (each above)               | blasting | 100 t   | 0.7  |

Phase 3 introduces tiered furnaces (clay, sandstone, obsidian, netherrack) that gate which metals can melt where. Until Phase 3 ships, vanilla furnace handles all four.

## Future: deepslate variants

Phase 3 will add deepslate-prefixed variants for silver/mithril/adamantium (Nether will be unchanged). These will share the same loot tables but with different textures and slightly higher hardness.

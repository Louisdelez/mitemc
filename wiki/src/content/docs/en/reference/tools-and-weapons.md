---
title: Tools & Weapons
description: Full reference of the 10 MITEMC tool families.
sidebar:
  order: 4
---

MITEMC ships **10 tool families** — the 9 from Avernite's MITE plus a shovel for ergonomics. Each family is registered in **5 materials** (flint, copper, silver, mithril, adamantium), giving **50 new items**. Vanilla iron, gold, diamond and netherite tools coexist; MITEMC does not duplicate them.

## Family matrix

| Family       | Vanilla parent | Damage bonus | Attack speed | Role                              |
|--------------|----------------|--------------|--------------|-----------------------------------|
| Cudgel       | Sword-like     | low (+1)     | -3.4         | Blunt, knockback emphasis         |
| Club         | Sword-like     | low+ (+2)    | -3.2         | Faster than cudgel, less knockback|
| Hatchet      | Axe            | mid (+3)     | -3.0         | Small axe, faster attack          |
| Knife        | Sword-like     | low (+1)     | -1.8         | Very fast, plant harvest          |
| Dagger       | Sword-like     | low+ (+2)    | -1.6         | Backstab feel, fast               |
| War Hammer   | Pickaxe        | high (+5)    | -3.4         | Heavy; mines stone                |
| Battle Axe   | Axe            | high (+6)    | -3.5         | Slow, heaviest strike             |
| Mattock      | Pickaxe        | mid (+3)     | -2.8         | Pick + shovel combo               |
| Scythe       | Hoe            | mid (+2)     | -2.6         | Plant area harvest                |
| Shovel       | Shovel         | low (+1.5)   | -3.0         | Standard digging                  |

Numbers are starting tunings inherited from MITE R196's matrix — every entry is data-driven and can be rebalanced via the upcoming damage matrix datapack.

## Material × tier

| Material   | Mining tier | Durability | Speed | Damage bonus | Enchantability |
|------------|-------------|------------|-------|--------------|----------------|
| Flint      | stone-equiv | 30         | 3.0   | +0.5         | 6              |
| Copper     | iron-equiv  | 180        | 5.0   | +1.5         | 12             |
| Iron       | (vanilla)   | 250        | 6.0   | +2.0         | 14             |
| Silver     | mid         | 400        | 7.0   | +2.0         | 16             |
| Mithril    | high        | 900        | 9.0   | +3.0         | 22             |
| Adamantium | top         | 2200       | 12.0  | +5.0         | 10             |

## Mining gates

Each tier has a tag of blocks it **cannot** mine. Higher tiers inherit lower gates.

| Tier        | Cannot mine                                  |
|-------------|----------------------------------------------|
| Flint       | `#minecraft:incorrect_for_stone_tool`        |
| Copper      | `#mitemc:needs_silver_tool`                  |
| Silver      | `#mitemc:needs_mithril_tool`                 |
| Mithril     | `#mitemc:needs_adamantium_tool`              |
| Adamantium  | (none — top tier)                            |

`#mitemc:needs_silver_tool` includes `#mitemc:needs_mithril_tool` which includes `#mitemc:needs_adamantium_tool` — tag inheritance does the heavy lifting.

## How to read a tool item

The item ID encodes both axes: `mitemc:<material>_<family>`.

Examples:
- `mitemc:flint_hatchet` — starter axe-class for chopping logs.
- `mitemc:copper_war_hammer` — first heavy tool that mines vanilla iron ore.
- `mitemc:adamantium_dagger` — fastest endgame weapon.

## See also

- [Tool Tiers](/en/reference/tool-tiers/) — block → required tier table.
- [Materials](/en/reference/materials/) — ore generation, smelting, raw drops.
- [Recipes](/en/recipes/) — exact crafting patterns.

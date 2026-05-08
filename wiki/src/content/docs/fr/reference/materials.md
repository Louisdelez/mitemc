---
title: Matériaux
description: Génération de minerai, drops bruts et fonte.
sidebar:
  order: 5
---

MITEMC ajoute quatre métaux au panel vanilla : **cuivre, argent, mithril, adamantium**.
(Fer, or, redstone, lapis, diamant, émeraude et netherite restent vanilla.)

## Blocs de minerai

| Minerai                    | Lieu             | Dureté | Drop XP | Drops                       |
|----------------------------|------------------|--------|---------|-----------------------------|
| `mitemc:copper_ore`        | pierre overworld | 3,0    | 0       | `raw_copper_chunk`          |
| `mitemc:silver_ore`        | pierre profonde  | 4,0    | 0–2     | `raw_silver_chunk`          |
| `mitemc:mithril_ore`       | pierre profonde  | 5,0    | 2–5     | `raw_mithril_chunk`         |
| `mitemc:adamantium_ore`    | netherrack       | 7,0    | 4–8     | `adamantium_ingot` (1–2)    |

L'adamantium drop directement le lingot car seuls les fours alimentés par le Nether savent fondre la forme brute, et nous n'embarquons pas encore d'item « adamantium brut ».

## Exigences de minage

| Minerai               | Palier minimal      |
|-----------------------|---------------------|
| `copper_ore`          | silex (équiv. pierre)|
| `silver_ore`          | cuivre              |
| `mithril_ore`         | argent              |
| `adamantium_ore`      | mithril             |

Minerai de fer vanilla : palier cuivre dans MITEMC (il est dans `#minecraft:needs_stone_tool` — le silex peut le miner via les règles vanilla, mais l'esprit est « cuivre ou plus »).

## Fonte

| Recette                    | Type     | Temps   | XP   |
|----------------------------|----------|---------|------|
| cuivre brut → lingot cuivre  | smelting | 200 t   | 0,7  |
| argent brut → lingot argent  | smelting | 200 t   | 0,7  |
| mithril brut → lingot mithril| smelting | 200 t   | 0,7  |
| (chacune ci-dessus)        | blasting | 100 t   | 0,7  |

La Phase 3 introduira des fours par palier (argile, grès, obsidienne, netherrack) qui filtreront quels métaux fondent où. Tant que la Phase 3 n'a pas été livrée, le four vanilla traite les quatre.

## Futur : variantes deepslate

La Phase 3 ajoutera les variantes deepslate pour argent/mithril/adamantium (le Nether reste inchangé). Mêmes loot tables mais textures différentes et dureté légèrement supérieure.

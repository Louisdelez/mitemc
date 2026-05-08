---
title: Fours
description: Paliers de chaleur, qualité du combustible et matrice de fonte.
sidebar:
  order: 6
---

La chaîne de fonte de MITEMC remplace le « met le minerai dans le four » par une vraie progression. Quatre nouveaux blocs de four, chacun avec son palier de chaleur, contrôlent quels métaux vous pouvez raffiner.

## La chaîne

```
Four en argile (0)  →  Four en grès (1)  →  Four en obsidienne (2)  →  Four en roche du Nether (3)
```

Le four vanilla est traité comme **palier 1** — équivalent à un four en grès pour la compatibilité.

## Paliers de chaleur

| Palier | Bloc                       | Lumière allumée | Vitesse × | Combustible                                |
|-------:|----------------------------|----------------:|----------:|--------------------------------------------|
|     0  | Four en argile             | 13              | 0,75 ×    | Charbon, carbone de bois, bois — cuisson primitive |
|     1  | Four en grès               | 13              | 1,00 ×    | Identique au four vanilla                  |
|     2  | Four en obsidienne         | 14              | 1,40 ×    | Seaux de lave recommandés                  |
|     3  | Four en roche du Nether    | 15              | 1,80 ×    | Verges de blaze pour débloquer l'adamantium |

## Que peut fondre chaque palier ?

| Recette                                  | Palier min | Tag de verrouillage                       |
|------------------------------------------|-----------:|-------------------------------------------|
| Nourriture / fer / cuivre vanilla        |          0 | (aucun)                                   |
| `raw_copper_chunk` → `copper_ingot`      |          0 |                                           |
| `raw_silver_chunk` → `silver_ingot`      |          0 |                                           |
| `raw_mithril_chunk` → `mithril_ingot`    |          2 | `#mitemc:requires_obsidian_furnace`       |
| `raw_adamantium_chunk` → `adamantium_ingot` |       3 | `#mitemc:requires_netherrack_furnace`     |

Le verrouillage passe par des tags d'items — si le *résultat* d'une recette est dans `#mitemc:requires_obsidian_furnace` et le four est sous le palier 2, la recette est silencieusement ignorée (l'entrée reste, aucun combustible n'est consommé).

## Crafting des fours

| Four                       | Recette                                                      |
|----------------------------|--------------------------------------------------------------|
| Four en argile             | 8× terre cuite en anneau de four                             |
| Four en grès               | 8× grès en anneau de four                                    |
| Four en obsidienne         | 8× obsidienne + 1 four vanilla au centre                     |
| Four en roche du Nether    | 8× briques du Nether + 1 four en obsidienne + 1 verge de blaze (en haut à droite) |

Voir [Recettes](/fr/recipes/) pour les patrons visuels.

## Qualité du combustible

La Phase 3 pose les fondations de la **qualité du combustible**, même si le runtime n'utilise pour l'instant que les durées de combustion vanilla. L'infrastructure est en place pour différencier, par exemple, bois (chaleur basse) vs. seau de lave (chaleur soutenue palier obsidienne) vs. verge de blaze (seul combustible débloquant le palier netherrack).

Quand la prochaine passe datapack arrive, ce tableau deviendra canonique :

| Combustible        | Capacité de chaleur | Notes                                        |
|--------------------|--------------------:|----------------------------------------------|
| Bâton / planches   | 1                   | Palier argile uniquement                     |
| Charbon / carbone de bois | 1            | Palier argile uniquement                     |
| Bloc de charbon    | 2                   | Palier grès                                  |
| Seau de lave       | 2                   | Grès + obsidienne ; longue combustion        |
| Verge de blaze     | 3                   | Requis pour les fontes palier netherrack     |

## Chaîne d'advancements de la Phase 3

```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```

`netherrack_furnace` est une advancement de type challenge (cadre doré).

## Voir aussi

- [Matériaux](/fr/reference/materials/) — rendements de minerai et drops bruts.
- [Paliers d'outils](/fr/reference/tool-tiers/) — ce que chaque métal fondu débloque.
- [Recettes](/fr/recipes/) — patrons de craft exacts pour les fours.

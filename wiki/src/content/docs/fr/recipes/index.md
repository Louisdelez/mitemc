---
title: Recettes
description: Recettes de craft introduites ou modifiées par MITEMC.
sidebar:
  order: 1
---

Cette section sera générée automatiquement depuis le datapack du mod. Ci-dessous : toutes les recettes de la Phase 1 + Phase 2 dans l'ordre où vous les découvrez.

## Phase 1 — Cueillette

### Bâton depuis les feuilles *(passif)*
Pas un craft — les feuilles cassées ou qui meurent ont 4 % de chance de donner un bâton (25 % de ce taux à la décrépitude naturelle).

## Phase 2 — Crafting d'outils

Chaque famille d'outil a un patron fixe. Les emplacements matériau sont remplis par des **éclats de silex** pour les outils en silex et par le **lingot** correspondant pour les outils en cuivre/argent/mithril/adamantium. `B` = bâton, `M` = matériau.

### Gourdin — `[ M / M / B ]`
```
. M .
. M .
. B .
```

### Massue — `[ MMM / B / B ]`
```
M M M
. B .
. B .
```

### Hachette — `[ MM / MB / B ]`
```
M M .
M B .
. B .
```

### Couteau — petit (2 cases)
```
M . .
B . .
```

### Dague — petite (2 cases)
```
. M .
. B .
```

### Marteau de guerre — `[ MMM / MBM / B ]`
```
M M M
M B M
. B .
```

### Hache de combat — même patron que le marteau de guerre
La forme est identique ; la recette se distingue par l'ID du résultat.

### Pioche-hache — `[ MMM / B / B ]`
```
M M M
. B .
. B .
```

### Faux — `[ MM / BM / B ]`
```
M M .
. B M
. B .
```

### Pelle — patron vanilla
```
. M .
. B .
. B .
```

## Fonte

| Entrée               | Sortie         | Méthode  | Temps |
|----------------------|----------------|----------|-------|
| raw_copper_chunk     | copper_ingot   | smelting | 10 s  |
| raw_copper_chunk     | copper_ingot   | blasting | 5 s   |
| raw_silver_chunk     | silver_ingot   | smelting | 10 s  |
| raw_silver_chunk     | silver_ingot   | blasting | 5 s   |
| raw_mithril_chunk    | mithril_ingot  | smelting | 10 s  |
| raw_mithril_chunk    | mithril_ingot  | blasting | 5 s   |

Le minerai d'adamantium drop le lingot directement — la Phase 3 le verrouillera derrière un four en roche du Nether.

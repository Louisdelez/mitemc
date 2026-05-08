---
title: Vie et faim
description: Règles exactes des stats du joueur dans MITEMC.
sidebar:
  order: 1
---

La mécanique signature de MITEMC : vous démarrez fragile et grandissez avec l'expérience.

## Valeurs de départ

| Stat              | Vanilla | MITEMC |
|-------------------|---------|--------|
| Cœurs max         | 10      | **3**  |
| Icônes de faim    | 10      | **3**  |
| Régén. naturelle  | oui     | lente  |
| Métabolisme basal | aucun   | épuisement passif |

## Courbe de progression

Tous les **5 niveaux d'XP**, vous gagnez **+1 cœur et +1 icône de faim**, plafonnés au 10/10 vanilla.

| Niveau XP | Cœurs | Faim |
|-----------|-------|------|
| 0         | 3     | 3    |
| 5         | 4     | 4    |
| 10        | 5     | 5    |
| 15        | 6     | 6    |
| 20        | 7     | 7    |
| 25        | 8     | 8    |
| 30        | 9     | 9    |
| 35+       | 10    | 10   |

## Métabolisme basal

Même immobile, votre personnage dépense de l'énergie. Le taux d'épuisement par défaut est de **0,0005 par tick** (0,01 par seconde). À saturation pleine, cela vide une icône de faim en environ 3 minutes en jeu.

## Pénalité de pluie

Exposé à la pluie, l'épuisement basal est multiplié par **3×**. Un toit ou n'importe quel bloc plein au-dessus de la tête supprime la pénalité.

## Faiblesse par la faim

Quand la faim tombe **sous 1 icône** (valeur interne < 1) :

- L'effet **Faiblesse par la faim** s'applique (indicateur cosmétique).
- **Lenteur II** s'applique.
- Vous ne pouvez **plus casser ni poser de blocs**.

L'état se termine dès que vous mangez quelque chose qui ramène la faim à 1 ou plus.

## Configuration

Toutes les valeurs sont ajustables dans `config/mitemc-common.toml`. Voir la [référence de la config](/fr/reference/config/) pour le TOML complet.

---
title: Outils et armes
description: Référence complète des 10 familles d'outils MITEMC.
sidebar:
  order: 4
---

MITEMC livre **10 familles d'outils** — les 9 du MITE d'Avernite plus une pelle pour le confort. Chaque famille est enregistrée dans **5 matériaux** (silex, cuivre, argent, mithril, adamantium), soit **50 nouveaux items**. Les outils vanilla en fer, or, diamant et netherite coexistent ; MITEMC ne les double pas.

## Matrice des familles

| Famille            | Parent vanilla | Bonus dégâts | Vitesse d'attaque | Rôle                                  |
|--------------------|----------------|--------------|-------------------|---------------------------------------|
| Gourdin (cudgel)   | type épée      | faible (+1)  | -3,4              | Contondant, recul marqué              |
| Massue (club)      | type épée      | faible+ (+2) | -3,2              | Plus rapide qu'un gourdin, moins de recul |
| Hachette           | hache          | moyen (+3)   | -3,0              | Petite hache, attaque plus rapide     |
| Couteau            | type épée      | faible (+1)  | -1,8              | Très rapide, récolte de plantes       |
| Dague              | type épée      | faible+ (+2) | -1,6              | Sensation de coup dans le dos, rapide |
| Marteau de guerre  | pioche         | élevé (+5)   | -3,4              | Lourd ; mine la pierre                |
| Hache de combat    | hache          | élevé (+6)   | -3,5              | Lente, frappe la plus puissante       |
| Pioche-hache (mattock) | pioche     | moyen (+3)   | -2,8              | Combo pioche + pelle                  |
| Faux               | houe           | moyen (+2)   | -2,6              | Récolte en zone                       |
| Pelle              | pelle          | faible (+1,5)| -3,0              | Creusage standard                     |

Les chiffres sont les réglages de départ hérités de la matrice MITE R196 — chaque entrée est data-driven et rééquilibrable via le datapack matrice de dégâts à venir.

## Matériau × palier

| Matériau   | Palier de minage  | Durabilité | Vitesse | Bonus dégâts | Enchant. |
|------------|-------------------|------------|---------|--------------|----------|
| Silex      | équiv. pierre     | 30         | 3,0     | +0,5         | 6        |
| Cuivre     | équiv. fer        | 180        | 5,0     | +1,5         | 12       |
| Fer        | (vanilla)         | 250        | 6,0     | +2,0         | 14       |
| Argent     | mid               | 400        | 7,0     | +2,0         | 16       |
| Mithril    | élevé             | 900        | 9,0     | +3,0         | 22       |
| Adamantium | sommet            | 2200       | 12,0    | +5,0         | 10       |

## Verrous de minage

Chaque palier a un tag de blocs qu'il **ne peut pas** miner. Les paliers supérieurs héritent des verrous inférieurs.

| Palier      | Ne peut pas miner                            |
|-------------|----------------------------------------------|
| Silex       | `#minecraft:incorrect_for_stone_tool`        |
| Cuivre      | `#mitemc:needs_silver_tool`                  |
| Argent      | `#mitemc:needs_mithril_tool`                 |
| Mithril     | `#mitemc:needs_adamantium_tool`              |
| Adamantium  | (aucun — sommet)                             |

`#mitemc:needs_silver_tool` inclut `#mitemc:needs_mithril_tool` qui inclut `#mitemc:needs_adamantium_tool` — l'héritage de tags fait le travail.

## Lire un identifiant d'outil

L'ID encode les deux axes : `mitemc:<materiau>_<famille>`.

Exemples :
- `mitemc:flint_hatchet` — hachette de départ pour couper les bûches.
- `mitemc:copper_war_hammer` — premier outil lourd qui mine le minerai de fer vanilla.
- `mitemc:adamantium_dagger` — arme de fin de partie la plus rapide.

## Voir aussi

- [Paliers d'outils](/fr/reference/tool-tiers/) — table bloc → palier requis.
- [Matériaux](/fr/reference/materials/) — génération de minerai, fonte, drops bruts.
- [Recettes](/fr/recipes/) — patrons de craft exacts.

---
title: Coffre-fort
description: Coffre métallique verrouillé au joueur pour le multijoueur.
sidebar:
  order: 9
---

Un **coffre-fort** est un coffre que seul son propriétaire peut ouvrir. Pensé pour les serveurs multijoueurs où des bases partagées ont besoin de stockage privé que ni les hoppers ni les autres joueurs ne peuvent siphonner.

## Coffre-fort en fer — `mitemc:iron_strongbox`

| Propriété                  | Valeur                                          |
|----------------------------|-------------------------------------------------|
| Stockage                   | 27 slots (mise en page d'un coffre simple)      |
| Dureté                     | 5,0                                             |
| Résistance aux explosions  | 1200 (classe obsidienne)                        |
| Outil requis               | Pioche                                          |
| Taille de pile             | 1 (en tant qu'item)                             |
| Propriétaire               | UUID du joueur qui l'a posé                     |

## Fonctionnement

1. **Posez** le coffre-fort. L'UUID du joueur poseur est lié au BE via `setPlacedBy`.
2. **Clic droit** pour ouvrir. Le `useWithoutItem` du bloc lit l'UUID propriétaire du BE :
   - S'il est non défini (legacy), ouvre pour tout le monde.
   - S'il correspond au joueur, ouvre.
   - S'il diverge et que le joueur **n'est pas OP** (niveau de permission ≥ 2), l'ouverture est refusée avec un message traduit.
3. **Cassez-le** pour récupérer. Les contenus tombent au sol (hook `playerWillDestroy`), le bloc lui-même drop via la loot table.

Le contournement OP est intentionnel : les admins serveur peuvent ouvrir n'importe quel coffre-fort. Si vous ne voulez pas cela, surchargez via le système de permissions de votre serveur.

## Craft

```
I I I
I C I    (I = lingot de fer, C = coffre)
I I I
```

8 lingots de fer en anneau autour d'un coffre vanilla.

## Interaction avec les hoppers

Le coffre-fort **n'implémente pas** les interfaces hopper. Les hoppers ne peuvent ni extraire ni insérer — blast-proof et hopper-proof.

## Notes multijoueur

- L'UUID propriétaire persiste à travers les redémarrages (sauvegardé en NBT sous la clé `Owner`).
- Si l'UUID du propriétaire change (rare, mais possible avec serveurs offline ré-clés), le coffre-fort devient orphelin — ouvrez-le avec les outils admin.
- Les coffres-forts ne sont **pas** protégés contre la cassure par le poseur — n'importe qui peut le casser. Les contenus tombent au sol ; l'item du coffre-fort tombe aussi. Traitez-les comme des coffres physiques pouvant être arrachés du mur.

## Variantes futures

Le roadmap réserve la place pour des coffres-forts de tier supérieur après la Phase 7 :

- **Coffre-fort en mithril** — immunité aux explosions + traçage de dimension (alerte le propriétaire si déplacé entre dimensions).
- **Coffre-fort en adamantium** — résiste aussi à la cassure créative.

Pas dans la Phase 6.

## Advancement Phase 6

`mitemc:phase6/strongbox` se déclenche dès que vous avez un coffre-fort en inventaire.

## Voir aussi

- [Enchantements](/fr/reference/enchantments/) — l'autre système de la Phase 6.
- [Outils et armes](/fr/reference/tools-and-weapons/) — pioche requise pour le casser.

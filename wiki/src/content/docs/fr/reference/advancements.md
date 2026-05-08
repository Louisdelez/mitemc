---
title: Advancements
description: Arbre complet d'advancements de toutes les phases plus l'arbre de survie.
sidebar:
  order: 10
---

MITEMC livre **35 advancements** organisées en sept arbres par phase plus un arbre récapitulatif inter-phases.

## Arbres par phase

Chaque phase a sa propre chaîne, affichée dans l'UI advancements vanilla sous son propre onglet.

### Phase 1 — Fondations de survie
```
phase1/root → first_stick → first_flint
```

### Phase 2 — Âge des métaux
```
phase2/root → first_copper → first_silver → first_mithril → first_adamantium
```
`first_adamantium` est de cadre challenge.

### Phase 3 — Hiérarchie de fours
```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```
`netherrack_furnace` est de cadre challenge.

### Phase 4 — Bestiaire
```
phase4/root → first_kill → all_ten
```
`all_ten` est de cadre challenge.

### Phase 5 — Agriculture
```
phase5/root → first_onion → cure_blight (goal) → full_pantry
```
`full_pantry` est challenge demandant 16 oignons + 16 blés + 16 carottes.

### Phase 6 — Enchantements + coffre-fort
```
phase6/root → first_enchant → strongbox
phase6/root → first_enchant → all_seven (challenge)
```

## Arbre de survie (Phase 7 — récap inter-phases)

Douze jalons qui ne remplacent pas les arbres de phase mais offrent une vue plate de complétion :

| Slug                | Trigger                                                 | Cadre     |
|---------------------|---------------------------------------------------------|-----------|
| `origins`           | Premier tick sur un monde MITEMC (root)                 | task      |
| `first_food`        | Consommer n'importe quelle nourriture                   | task      |
| `first_kill`        | Joueur-killed n'importe quelle entité                   | task      |
| `first_metal`       | N'importe quel lingot MITEMC en inventaire              | task      |
| `first_furnace`     | N'importe quel four MITEMC en inventaire                | task      |
| `first_crop`        | Oignon en inventaire                                    | task      |
| `first_enchant`     | Tenir un objet avec un enchantement MITEMC              | task      |
| `first_strongbox`   | Coffre-fort en fer en inventaire                        | task      |
| `first_lore`        | N'importe quel livre de lore en inventaire              | task      |
| `bestiary`          | Abattre une créature de chaque espèce MITEMC            | challenge |
| `mythic`            | Lingot d'adamantium en inventaire                       | challenge |
| `completionist`     | Adamantium + coffre-fort + tous les enchants + oignon + lore | challenge |

Le parent de l'arbre de survie est `survival_tree/origins` (sa propre racine), donc il s'affiche séparément des arbres de phase.

## Triggers utilisés

- `minecraft:tick` — advancements racines
- `minecraft:inventory_changed` — la plupart des jalons (avec prédicat `items`)
- `minecraft:player_killed_entity` — jalons de kill (avec `entity_properties` optionnel pour filtre d'espèce)
- `minecraft:consume_item` — jalons de nourriture
- `minecraft:item_used_on_block` — jalons d'interaction (ex. fumier sur culture brûlée)

## Customisation

Les JSON d'advancements vivent à `data/mitemc/advancements/<phase>/*.json`. Deux genres d'override :

- **Désactiver** : copier le JSON dans un datapack avec `{ "criteria": {} }` et un parent vide — le moteur le traite comme inatteignable.
- **Reskin** : garder les critères, changer icône/titre/description.

Les joueurs qui veulent retirer les challenges en particulier peuvent livrer un petit datapack qui vide leurs critères.

## Tag

`#mitemc:all_enchantments` — utilisé par `phase6/first_enchant`, `phase6/all_seven`, `survival_tree/first_enchant` et `survival_tree/completionist` pour détecter n'importe quel des sept enchantements MITEMC sur un objet.

## Voir aussi

- [Lore](/fr/reference/lore/) — livres narratifs qui valident le `first_lore` de l'arbre de survie.
- [Bestiaire](/fr/bestiary/) — ce qui se chasse pour `all_ten` / `bestiary`.
- [Enchantements](/fr/reference/enchantments/) — ce qui compte pour `first_enchant`.

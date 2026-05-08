---
title: Enchantements
description: Les sept enchantements MITEMC — effets, items et courbes de niveau.
sidebar:
  order: 8
---

La Phase 6 livre **7 enchantements** modelés sur la liste R196 d'Avernite. Cinq sont purement data-driven (définitions JSON) ; deux nécessitent des handlers Java parce que leur comportement modifie le monde de façon inhérente.

## Aperçu rapide

| Enchantement       | Slot      | Items                              | Max | Trigger                       |
|--------------------|-----------|------------------------------------|----:|-------------------------------|
| Hâte               | bottes    | `#enchantable/foot_armor`          | III | Équipé (attribut passif)      |
| Étourdissement     | main      | `#enchantable/weapon`              | II  | Post-attaque                  |
| Grande Fortune     | main      | `#enchantable/mining`              | V   | À la cassure de bloc (loot)   |
| Régénération       | tout      | `#enchantable/armor`               | II  | Tick (passif)                 |
| Fertilité          | main      | `#enchantable/farm_equipment` (houe)| III| Tick lorsqu'en main           |
| Abattage d'arbre   | main      | `#mitemc:tree_felling_axes`        | I   | À la cassure de bûche         |
| Vampirique         | main      | `#enchantable/sword`               | III | Post-attaque                  |

## Fiches détaillées

### Hâte — `mitemc:speed`

Bottes uniquement. Ajoute **+5 % de vitesse de déplacement par niveau** comme modificateur d'attribut `add_multiplied_total`. Cumule normalement avec Vivacité d'âme et les potions.

| Niveau | Bonus de vitesse |
|--------|-----------------:|
| I      | +5 %             |
| II     | +10 %            |
| III    | +15 %            |

### Étourdissement — `mitemc:stun`

Arme. Au coup, applique **Lenteur II** à la victime :
- Niveau I : 1–2 s
- Niveau II : 1,5–3 s

Coups directs uniquement ; les projectiles lancés ne déclenchent pas.

### Grande Fortune — `mitemc:greater_fortune`

Outils de minage. Variante MITEMC de Fortune allant jusqu'à **V** au lieu du III vanilla. Mutuellement exclusive avec la Fortune vanilla (`exclusive_set`).

> **Statut Phase 6 :** l'enchantement existe et est rollable. L'intégration aux loot tables pour vraiment livrer la courbe de rendement est repoussée à une passe 6.5 — gardez l'attente jusque-là.

### Régénération — `mitemc:regeneration`

Armure. Effet de tick : applique **Régénération** toutes les 5 ticks (quart de seconde) au niveau cuit dans :
- Niveau I : Régén I
- Niveau II : Régén II

Le cumul sur plusieurs pièces d'armure prend le plus haut niveau — mettre le même enchant sur plusieurs pièces ne s'additionne *pas*, règle vanilla.

### Fertilité — `mitemc:fertility`

Houe (`#enchantable/farm_equipment`). Quand tenue en main principale, les cultures voisines dans un petit rayon reçoivent des **random ticks bonus** chaque seconde-serveur :

| Niveau | Rayon (cellules) | Ticks bonus / s |
|-------:|-----------------:|----------------:|
| I      | 1×1×1            | 1               |
| II     | 3×1×3            | 2               |
| III    | 5×1×5            | 4               |

Une houe Fertilité III tenue à proximité d'un champ de blé équivaut à une mise à l'os toutes les minutes — mais gratuite. Combinez avec le fumier de la Phase 5 pour des boucles cure-puis-pousse-vite.

### Abattage d'arbre — `mitemc:tree_felling`

Hache uniquement. Niveau unique. À la cassure d'une bûche avec cet enchant en main, le handler fait un BFS depuis la position cassée et abat toutes les bûches connectées du même type, plafonné à **96 bûches** par sécurité. Chaque bûche abattue :

- Drop ses items à sa position.
- Coûte 1 durabilité à la hache.
- Arrête la chaîne si la hache casse.

Le BFS utilise les voisins en 26 directions, donc les arbres en diagonale (jungle, chêne noir) sont gérés.

### Vampirique — `mitemc:vampiric`

Épée. Au coup direct, l'**attaquant** gagne une brève Régénération :
- Niveau I : Régén I, 1–2 s
- Niveau II : Régén II, 1–3 s
- Niveau III : Régén III, 1–4 s

Ne se déclenche pas sur les dégâts indirects (aura, chaînes d'épines).

## Coûts d'enclume

Tous les enchantements MITEMC ont des coûts d'enclume plus élevés que leurs équivalents vanilla — combiner une épée Vampirique III avec une épée fraîche coûte **8 niveaux d'enclume**, Grande Fortune V coûte **16**. Planifiez votre économie d'enchant.

## Notes d'implémentation

- **JSON :** définitions à `data/mitemc/enchantment/*.json`. Les cinq data-driven utilisent les effect components vanilla (`minecraft:attributes`, `minecraft:post_attack`, `minecraft:tick`).
- **Java :** Abattage et Fertilité sont câblés via `TreeFellingHandler` (game bus, `BlockEvent.BreakEvent`) et `FertilityHandler` (game bus, `PlayerTickEvent.Post`). Tous deux lisent le niveau via `ModEnchantments.mainHandLevel(...)`.
- **Tag :** `#mitemc:tree_felling_axes` liste toutes les haches vanilla et MITEMC éligibles pour Abattage d'arbre.

## Voir aussi

- [Outils et armes](/fr/reference/tools-and-weapons/) — sur quoi chaque enchant se pose.
- [Coffre-fort](/fr/reference/strongbox/) — l'autre livraison de la Phase 6.

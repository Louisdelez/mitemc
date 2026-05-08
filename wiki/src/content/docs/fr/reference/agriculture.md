---
title: Agriculture
description: Cultures, brûlure, fumier, météo et température.
sidebar:
  order: 7
---

La Phase 5 transforme l'agriculture du « pose et oublie » en un calendrier de risques : les cultures peuvent pourrir en pleine saison, la pluie accélère et menace à la fois, et les biomes froids brûlent votre faim plus vite.

## Le plant d'oignon

`mitemc:onion_crop` étend `CropBlock` vanilla avec une propriété supplémentaire : **`blighted`** (booléen).

| Propriété  | Valeurs | Effet                                                                        |
|------------|---------|------------------------------------------------------------------------------|
| `age`      | 0–7     | Progression standard                                                         |
| `blighted` | bool    | Si `true`, la croissance est suspendue ; un plant mûr ne donne que des graines |

### Drops

| Condition                       | Drop                                            |
|---------------------------------|-------------------------------------------------|
| Tout âge                        | 1× graines d'oignon                             |
| `age=7`, `blighted=false`       | + 1–2 oignons                                   |
| `age=7`                         | + 0–2 graines bonus (boost Fortune)             |
| `age=7`, `blighted=true`        | seulement les graines — pas d'oignon            |

Oignon : nutrition 2, saturation 0,4 — modeste, conçu pour des recettes de ragoût.

## Brûlure des cultures (blight)

Un plant MITEMC **mûr et non brûlé** a une chance par random-tick de développer la brûlure (`crop_blight_chance`, défaut 0,5 %). Une fois brûlé :

- La croissance est **figée** (pas de progression au-delà d'`age=7`).
- Le bloc retire au hasard à chaque random-tick une chance d'**infecter un voisin horizontal** mûr et sain (`blight_spread_chance`, défaut 10 %).
- La récolte ne donne pas d'oignon (seulement des graines).
- Un clic-droit avec du fumier efface le drapeau `BLIGHTED`.

La propagation est d'un voisin par tick, choisi parmi les 4 directions cardinales. Une ligne d'oignons mûrs laissée sans surveillance finira toute brûlée — planifiez la récolte.

## Fumier

| Source                                   | Comportement                                                         |
|------------------------------------------|----------------------------------------------------------------------|
| Random-tick d'une vache / d'un cochon    | Chance par tick de droper un `mitemc:manure` (défaut 0,01 %)         |
| Clic-droit sur un plant MITEMC brûlé     | Efface le drapeau BLIGHTED, consomme 1 fumier                        |
| Clic-droit sur n'importe quelle culture vanilla | Agit comme de la poudre d'os (avance l'âge aléatoirement)     |

Le fumier **ne fait pas pousser** d'arbres, d'herbe ni de fleurs — uniquement les cultures.

## Effets météo

| Météo  | Effet                                                                              |
|--------|------------------------------------------------------------------------------------|
| Pluie  | Joueur exposé au ciel : faim ×3 (Phase 1)                                          |
| Pluie  | Cultures MITEMC avec accès au ciel : ~20 % de tick de croissance bonus par random-tick |
| Pluie  | Pêche : ~25 % de chance d'un drop bonus (cod ou kelp) par prise                    |

La combinaison croissance bonus + risque de brûlure est intentionnelle : la pluie nourrit vos champs et nourrit la pourriture.

## Température

Quand un joueur se trouve dans un biome dont la température est sous `cold_biome_threshold` (défaut 0,2), le métabolisme basal est multiplié par `cold_biome_mult` (défaut 2,0). Cumuls :

| Conditions                              | Multiplicateur basal effectif vs. base |
|-----------------------------------------|---------------------------------------:|
| Biome chaud, abrité                     | 1,0×                                   |
| Biome chaud, sous la pluie              | 3,0×                                   |
| Biome froid, abrité                     | 2,0×                                   |
| Biome froid, sous la pluie              | 4,0× (3 + 2 − 1, deltas cumulés)       |

Les biomes neigeux et glacés vident la faim vite — embarquez du jerky.

## Chaîne d'advancements de la Phase 5

```
phase5/root  →  first_onion  →  cure_blight (goal)  →  full_pantry (challenge)
```

`full_pantry` demande 16 oignons, 16 blés et 16 carottes — preuve d'une économie alimentaire viable.

## Boutons de configuration

Tous les chiffres de la Phase 5 vivent sous `[phase5]` dans `config/mitemc-common.toml` :

```toml
[phase5.agriculture]
crop_blight_chance     = 0.005
blight_spread_chance   = 0.10
rain_growth_chance     = 0.20
animal_manure_chance   = 0.0001

[phase5.environment]
cold_biome_mult        = 2.0
cold_biome_threshold   = 0.2
rain_fishing_bonus     = 0.25
```

À ajuster selon vos goûts — un serveur « feel vanilla » peut mettre la brûlure à 0 ; un serveur hardcore peut monter à 0,02.

## Voir aussi

- [Vie et faim](/fr/reference/health-and-hunger/) — épuisement basal, pénalité de pluie.
- [Fours](/fr/reference/furnaces/) — que faire de votre récolte.
- [Bestiaire](/fr/bestiary/) — animaux qui drop le fumier et qui ont faim.

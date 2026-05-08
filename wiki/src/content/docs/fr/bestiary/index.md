---
title: Bestiaire
description: Nouvelles créatures introduites par MITEMC.
sidebar:
  order: 1
---

La Phase 4 livre **10 nouvelles espèces hostiles**. Chacune est une sous-classe d'un mob vanilla avec des stats distinctes et un comportement signature ; les modèles geo et textures custom arriveront en passe de polish.

## En un coup d'œil

| Espèce               | PV | ATQ | Spawn               | Signature                                         |
|----------------------|---:|----:|---------------------|---------------------------------------------------|
| Loup gris            | 20 |  6  | Surface overworld   | Toujours hostile aux joueurs ; meutes de 2-4     |
| Araignée des bois    | 14 |  3  | Biomes forestiers   | Grimpe aux murs ; très rapide                     |
| Goule                | 24 |  4  | Couches de grottes  | Morsure : Lenteur IV + Fatigue de minage II 4 s  |
| Spectre              | 18 |  4  | Souterrain          | Coups vident 4 d'épuisement de faim              |
| Ombre                | 16 |  5  | Niveau lumière 0    | Apparaît *uniquement* en obscurité absolue        |
| Traqueur invisible   | 18 |  5,5| Couches de grottes  | Auto-Invisibilité permanente                      |
| Chien des enfers     | 24 |  7  | Nether              | Immunisé au feu ; enflamme la cible 5 s          |
| Araignée démoniaque  | 20 |  5  | Grottes profondes   | Bond sur la cible toutes les 3 s                  |
| Creeper infernal     | 24 |  —  | Nether              | Plus grande explosion ; immunisé au feu           |
| Élémentaire de feu   | 24 |  6  | Grottes nether-like | Feu à distance ; plus coriace que le blaze        |

## Fiches détaillées

### Loup gris — `mitemc:dire_wolf`

Cousin plus grand et méchant du loup vanilla. **Toujours hostile** aux joueurs (court-circuite le comportement apprivoisable de `Wolf`). Apparaît au crépuscule dans les biomes overworld, généralement en meutes.

- **Loot :** 1–2 os.
- **Tactique :** Hachette+ en main, combattez en hauteur ; les meutes ciblent la victime aux PV les plus bas.

### Araignée des bois — `mitemc:wood_spider`

Variante de surface de l'araignée des cavernes, dans les biomes forestiers. Un peu plus grande que la vanilla, pas de morsure empoisonnée — mais très rapide dans la canopée.

- **Loot :** 0–2 ficelles, 0–1 œil d'araignée.
- **Tactique :** Une dague en silex tient leur cadence ; brisez la ligne de vue dans le sous-bois.

### Goule — `mitemc:ghoul`

Variante zombie des grottes. Sa morsure applique **Lenteur IV + Fatigue de minage II** pendant 4 secondes — un effet paralysant qui vous empêche de creuser pour fuir.

- **Loot :** 0–3 chairs putréfiées, 0–1 os.
- **Tactique :** Pas de mêlée dans les tunnels. Marteau de guerre + chemin de retraite obligatoires.

### Spectre — `mitemc:wight`

Variante squelette mort-vivant. **Les coups vident 4 d'épuisement de faim** sur les joueurs — apportez de la nourriture, ou tombez en Faiblesse par la faim en plein combat.

- **Loot :** 0–3 os, 0–2 flèches.
- **Tactique :** Portez du ragoût ou du steak ; finissez vite.

### Ombre — `mitemc:shadow`

Apparaît **uniquement au niveau de lumière 0**. Ne brûle jamais au soleil (elle reste sous terre de toute façon).

- **Loot :** 0–2 chairs putréfiées, 0–1 charbon.
- **Tactique :** Une seule torche tue tout le rayon de spawn. La lumière est la réponse.

### Traqueur invisible — `mitemc:invisible_stalker`

Auto-Invisibilité permanente (renouvelée toutes les 200 ticks). Vous l'entendez avant de le voir.

- **Loot :** 0–2 chairs putréfiées, 0–1 fiole en verre.
- **Tactique :** Écoutez les pas ; une potion projetable de Brillance les démasque.

### Chien des enfers — `mitemc:hellhound`

Loup gris du Nether. Immunisé au feu ; **les coups enflamment la cible 5 s**. Meutes de 1 à 3.

- **Loot :** 1–2 os, 0–1 poudre de blaze.
- **Tactique :** Potion de Résistance au feu avant d'entrer dans les forteresses du Nether.

### Araignée démoniaque — `mitemc:demon_spider`

Variante des grottes profondes. **Bondit périodiquement sur sa cible** avec une forte vélocité verticale. Vous rejoint sur des corniches que vous pensiez sûres.

- **Loot :** 0–2 ficelles, 0–2 yeux d'araignée.
- **Tactique :** Arènes ouvertes uniquement ; jamais combattre sur une corniche d'un bloc.

### Creeper infernal — `mitemc:infernal_creeper`

Variante creeper du Nether. **Rayon d'explosion plus grand** (~5 contre 3 vanilla), immunisé au feu, résistance modeste aux chutes.

- **Loot :** 1–3 poudres à canon, 0–1 verrue du Nether.
- **Tactique :** Comme un creeper, mais distance de sécurité 1,6× plus grande.

### Élémentaire de feu — `mitemc:fire_elemental`

Cousin du blaze, en couches profondes de l'overworld. Apparaît sous Y=0 plutôt que dans le Nether, avec un peu plus de PV et une portée de poursuite de 32 blocs.

- **Loot :** 1–2 verges de blaze.
- **Tactique :** Arc + armure Protection contre le feu. Pas de mêlée sans équipement adapté.

## Poids de spawn

| Classe de biome           | Spawners                                                                |
|---------------------------|-------------------------------------------------------------------------|
| `#minecraft:is_overworld` | Loup gris 8, Araignée des bois 6, Goule 12, Spectre 10, Ombre 4, Traqueur invisible 2, Araignée démoniaque 5, Élémentaire de feu 3 |
| `#minecraft:is_nether`    | Chien des enfers 12, Creeper infernal 8                                 |

Les poids sont des entrées NeoForge BiomeModifier `add_spawns` — surchargeables via datapack.

## Faim des animaux amicaux

La Phase 4 introduit aussi une mécanique de **faim pour les animaux amicaux** (vaches, moutons, cochons, poules) :

- Chaque animal suivi accumule un compteur de faim quand il n'est pas adjacent à de l'herbe / blé / eau.
- Après une journée complète en jeu sans nourriture, l'animal subit 1 dégât de famine.
- Le compteur se réinitialise dès qu'il touche de la nourriture, et récupère 4× plus vite en train de manger.
- Suivi en NBT persistant — survit au déchargement de chunk.

Planifiez vos fermes : les animaux dans des enclos en terre seule mourront. La Phase 5 ajoutera la nourrissage explicite, le fumier, et la soif par-dessus.

## Chaîne d'advancements de la Phase 4

```
phase4/root  →  first_kill  →  all_ten  (challenge)
```

`first_kill` se déclenche au premier kill d'une espèce MITEMC. `all_ten` demande une de chaque espèce — le trophée complétiste du bestiaire.

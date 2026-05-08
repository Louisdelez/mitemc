---
title: Paliers d'outils
description: Quel outil mine quoi.
sidebar:
  order: 2
---

## La chaîne

```
mains → silex → cuivre → fer → argent → mithril → adamantium
```

Chaque palier mine son propre minerai et un palier en dessous. Le fer vanilla se place entre cuivre et argent côté MITEMC et fait le pont naturellement.

## Bloc → palier requis

| Bloc                    | Palier requis | Notes                                                 |
|-------------------------|---------------|-------------------------------------------------------|
| Bois (bûches)           | hachette+     | Pas de bûches à mains nues                            |
| Feuilles                | aucun         | Tapez librement ; chance de faire tomber un bâton     |
| Pierre                  | silex+        | Pioche ou marteau de guerre                           |
| Minerai charbon         | silex+        |                                                       |
| Minerai fer vanilla     | silex+        | Toléré ; cuivre recommandé pour rendement plein       |
| `mitemc:copper_ore`     | silex+        | Drop `raw_copper_chunk`                               |
| `mitemc:silver_ore`     | cuivre+       | **Les outils en pierre ne minent pas l'argent**       |
| `mitemc:mithril_ore`    | argent+       |                                                       |
| `mitemc:adamantium_ore` | mithril+      | Et seulement four en obsidienne pour fondre le lingot |

## Familles d'outils

MITEMC livre **10 familles d'outils** au-delà des pioche/hache/pelle/épée/houe vanilla :

- Gourdin, massue — armes contondantes (recul)
- Hachette, hache de combat — bois + abattage (classe hache)
- Couteau, dague — mêlée rapide, récolte de plantes
- Marteau de guerre — pierre + mêlée lourde (classe pioche)
- Pioche-hache — combo creusement (classe pioche)
- Faux — récolte en zone (classe houe)
- Pelle — creusage classique

La matrice complète de dégâts / vitesse / verrous est dans la [référence Outils et armes](/fr/reference/tools-and-weapons/).

## Chaîne d'advancements de la Phase 2

```
phase2/root  →  first_copper  →  first_silver  →  first_mithril  →  first_adamantium
```

Chaque étape s'affiche en toast et débloque la suivante. `first_adamantium` est une advancement de type challenge (cadre doré).

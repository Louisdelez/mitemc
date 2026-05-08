---
title: Migrer depuis MITE 1.6.4
description: Vous venez du MITE original d'Avernite ? Voici ce qui a changé.
sidebar:
  order: 3
---

Si vous avez joué le MITE original (R196 sur Minecraft 1.6.4), voici l'antisèche pour ce qui passe et ce qui change.

## TL;DR

MITEMC est un **portage fidèle**, pas un remake. L'intention : un joueur 2026 qui installe MITEMC doit avoir l'impression de jouer le mod qu'Avernite a fait — avec toutes les commodités modernes (NeoForge, override datapack, UI multilingue) en dessous.

## Mécaniques portées

| Mécanique MITE R196                                  | Statut MITEMC |
|------------------------------------------------------|---------------|
| Départ 3 cœurs / 3 nourriture, +1 par 5 niveaux XP   | ✓ identique   |
| Métabolisme basal (faim au repos)                    | ✓ identique   |
| Pluie accélère la faim                               | ✓ identique   |
| Faiblesse par la faim (pas de cassure/pose)          | ✓ identique   |
| Bâton depuis les feuilles                            | ✓ identique   |
| 9 familles d'outils (gourdin/massue/hachette/couteau/dague/marteau de guerre/hache de combat/pioche-hache/faux) | ✓ + ajout pelle pour ergonomie |
| 5 matériaux (silex/cuivre/argent/mithril/adamantium) | ✓ identique   |
| Verrous de minage par palier                         | ✓ identique avec système de tags moderne |
| 4 paliers de fours (argile/grès/obsidienne/netherrack)| ✓ identique  |
| Palier de chaleur verrouille les recettes de fonte   | ✓ identique, item-tag-driven |
| 10 mobs hostiles (loup gris, araignée des bois, goule…) | ✓ identique |
| Plant d'oignon + brûlure + fumier                    | ✓ identique   |
| 7 enchantements                                      | ✓ identique, "Grande Fortune" remplace la collision vanilla |
| Coffre-fort (verrouillé au joueur)                   | ✓ identique   |

## Changements de comportement

| Aspect                        | MITE R196 | MITEMC                                                    |
|-------------------------------|-----------|-----------------------------------------------------------|
| Mod loader                    | Aucun (raw) | NeoForge                                                |
| Compatibilité Forge           | Refusée (~500 classes de base) | NeoForge natif — pas de couche compat |
| Override datapack             | Impossible | Toutes les recettes / tags / advancements overridables   |
| Traductions                   | English-ish | EN/FR/DE/ES/IT, parité vérifiée                         |
| Configuration                 | Code-baked | TOML runtime pour les chiffres Phase 1 + Phase 5         |
| Modèles geo custom mobs       | Aucun      | Renderers vanilla en placeholder (modèles custom à venir) |
| Drop d'adamantium             | Lingot direct | Drop maintenant `raw_adamantium_chunk`, fonte four netherrack (pipeline plus propre) |
| Formule durabilité outil      | Basée dureté bloc | Durabilité vanilla pour l'instant (Phase 6.5 livre le Mixin) |

## Pas encore porté

| Feature MITE R196                              | Statut MITEMC          |
|------------------------------------------------|------------------------|
| Crafting temporisé (recettes prennent des ticks) | Liste — Mixin sur completion craft |
| Qualité du combustible (capacité par fuel)     | Infrastructure prête, runtime pas encore en force |
| Modèles geo / textures custom pour nouveaux mobs | Liste                |
| IA quête de nourriture animaux                 | Phase 5.5             |
| Intégration loot Grande Fortune                | Phase 6.5             |
| Journaux de lore in-game depuis les notes d'Avernite | ✓ Fait en 5 lore books Phase 7 |

## Sauvegardes

Les saves MITE 1.6.4 ne sont **pas** transférables. Le format chunk, l'NBT items, les entity types — tout a changé entre MC 1.6.4 et 26.1. Si vous avez un monde MITE chéri, la façon de l'honorer est de prendre des screenshots, puis recommencer.

## IDs identiques ?

Non. MITE 1.6.4 utilisait des IDs numériques. MITEMC utilise des IDs `mitemc:<nom>` namespacés. Exemples :

| MITE R196 (numérique)  | MITEMC (namespacé)             |
|------------------------|--------------------------------|
| Iron Hatchet           | `mitemc:iron_hatchet` (fer vanilla) |
| Copper Pickaxe         | `mitemc:copper_war_hammer`     |
| Mithril Ore            | `mitemc:mithril_ore`           |
| Strongbox              | `mitemc:iron_strongbox`        |

Si vous scriptez avec `/give`, utilisez les nouveaux IDs.

## Communauté du mod

La communauté MITE chinoise (Bilibili, groupes QQ) maintient MITE en vie depuis 2014. MITEMC est un effort séparé ; on les crédite dans [CREDITS.md](https://github.com/Louisdelez/mitemc/blob/main/docs/CREDITS.md). Si vous venez de FishModLoader / ModernMite, MITEMC est un portage moderne parallèle — choisissez l'écosystème qui convient à votre groupe.

## Voir aussi

- [Démarrer](/fr/guides/getting-started/) — installation à neuf.
- [Configuration](/fr/reference/configuration/) — tous les boutons.
- [FAQ](/fr/reference/faq/) — questions courantes.

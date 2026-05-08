---
title: FAQ
description: Questions fréquentes sur MITEMC.
sidebar:
  order: 13
---

## Général

### MITEMC est-il identique à MITE ?

**Non.** MITEMC est un portage du MITE d'Avernite (R196, MC 1.6.4) vers **Minecraft 26.1** sur **NeoForge**, restaurant le design sur des bases modernes. Le MITE original est figé en 1.6.4. Voir [guide de migration](/fr/guides/migration/).

### Pourquoi « MITEMC » ?

Court pour « MITE for Minecraft » + suffixe clair. Le nom MITE original (Minecraft Is Too Easy) est préservé partout où il importe — dans les advancements, le lore et l'esprit du design.

### MITEMC a-t-il besoin de Forge ?

**Non.** MITEMC est un mod NeoForge. NeoForge ≥ 26.1.x requis. NeoForge est le fork communautaire post-2023 de Forge et le standard de facto pour les gros mods de contenu en 2026.

### Puis-je installer MITEMC à côté d'autres mods ?

Oui — les mods NeoForge coexistent par défaut. Points de conflit à surveiller :

- **Autres mods touchant aux attributs joueur** (santé max, faim) peuvent écraser les modificateurs MITEMC. On utilise un modificateur nommé `phase1_max_health` pour éviter les collisions.
- **Autres mods d'agriculture** ajoutant de nouvelles cultures sont fine ; les cultures MITEMC sont namespacées.
- **Autres mods d'enchantement** ajoutant des variantes Fortune-V entrent en conflit avec Grande Fortune — le tag `exclusive_set` devrait auto-résoudre.

## Gameplay

### Je meurs sans cesse au jour 1. C'est intentionnel ?

**Oui.** Trois cœurs signifie qu'un seul coup de zombie prend un tiers de votre vie. Le chemin prévu est cueillette → silex → abri pour la nuit 1, pas l'engagement. Voir [Bases de la survie](/fr/guides/survival-basics/).

### Mes cultures meurent — c'est un bug ?

C'est le **système de brûlure** ([référence agriculture](/fr/reference/agriculture/)). Les cultures mûres ont une petite chance par random-tick de développer la brûlure. Soigner avec du fumier. Ou mettre `crop_blight_chance = 0` dans la [config](/fr/reference/configuration/) si vous n'en voulez pas.

### Pourquoi ne puis-je pas ouvrir ce coffre-fort ?

C'est un [coffre-fort](/fr/reference/strongbox/) que vous n'avez pas posé — seul son propriétaire (poseur) et les OPs peuvent l'ouvrir. Cassez-le (drop le contenu) ou demandez au propriétaire de l'ouvrir.

### Pourquoi ma pioche casse le minerai de fer mais pas le minerai d'argent ?

Le minerai d'argent demande palier cuivre ou plus dans MITEMC. Les paliers de pioche vanilla ne couvrent que le fer. Voir [Paliers d'outils](/fr/reference/tool-tiers/).

### J'ai une pioche Grande Fortune V mais mes drops ne diffèrent pas d'une Fortune III. Pourquoi ?

La Phase 6 livre Grande Fortune comme entrée registry — l'intégration loot table effective est sur la liste Phase 6.5. Utilisez Fortune III vanilla pour l'instant ; ça fonctionne comme attendu.

## Serveur / multijoueur

### Les serveurs MITEMC sont-ils performants ?

La plupart des handlers sont scopés au tick serveur avec des prédicats pas chers. Points de charge connus :

- `FertilityHandler` scanne une petite zone au tick joueur (uniquement quand une houe Fertilité est tenue).
- `AnimalHungerHandler` tourne tous les 100 ticks par animal — bien plafonné.
- `AnimalManureHandler` chance par tick à 0,01 % par vache/cochon — à peine mesurable.

Une passe de profilage est sur la liste pour la Phase 7.5.

### Puis-je désactiver une phase entièrement ?

Pas via un seul switch de config — mais on peut override par système :

- Phase 1 rééquilibrage joueur : `starting_hearts=10`, `starting_food=10`, `basal_exhaustion_per_tick=0.0`.
- Phase 4 mobs : livrer un datapack overridant `data/neoforge/biome_modifier/mitemc_spawns.json` avec spawners vides.
- Phase 5 agriculture : `crop_blight_chance=0`, `animal_manure_chance=0`.

### Permissions ?

Le coffre-fort vérifie le permission level ≥ 2 pour l'override OP. L'intégration permission NeoForge standard s'applique.

## Traductions

### Ma langue n'est pas supportée.

MITEMC livre en anglais, français, allemand, espagnol, italien. Pour ajouter une autre : copier `wiki/src/content/docs/en/` vers un nouveau dossier locale, traduire, ajouter le locale dans `wiki/astro.config.mjs`, et copier `mod/src/main/resources/assets/mitemc/lang/en_us.json` vers le code de votre langue. PRs bienvenues — voir [CONTRIBUTING-TRANSLATIONS](https://github.com/Louisdelez/mitemc/blob/main/wiki/CONTRIBUTING-TRANSLATIONS.md).

### Une traduction est fausse / sonne maladroit.

PRs bienvenues. Voir le même guide.

## Compatibilité

### Quid de l'écosystème communauté MITE chinoise (FishModLoader, ModernMite) ?

MITEMC vise NeoForge directement, alors que FishModLoader est un loader style Fabric pour MC 1.6.4. Plateformes différentes — MITEMC n'est pas un portage du travail FishModLoader. On crédite la communauté MITE moderne dans [CREDITS.md](https://github.com/Louisdelez/mitemc/blob/main/docs/CREDITS.md).

### Les outils en adamantium fonctionneront-ils dans des modpacks ?

Oui — ils étendent les classes vanilla (SwordItem, AxeItem, PickaxeItem) et utilisent le système durabilité/dégâts standard. Tinkers, JEI, REI les voient comme des outils standards.

## Bugs

### J'ai trouvé un bug.

[Ouvrir un issue](https://github.com/Louisdelez/mitemc/issues) avec : version MC, version NeoForge, logs du loader, et reproduction minimale. Le PROGRESS log note les incertitudes API (ex. signature `BlockEvent.CropGrowEvent.Pre`, constante `RecipeBookType.FURNACE`) — ce sont les points d'ajustement les plus probables au premier build.

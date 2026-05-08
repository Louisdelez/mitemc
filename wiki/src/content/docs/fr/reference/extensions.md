---
title: Roadmap extensions
description: Ce qui est prévu au-delà du portage 1:1 fidèle.
sidebar:
  order: 14
---

Le ROADMAP original ferme à la **Phase 8** : couverture wiki à 100 % et cadre de design pour l'expansion post-1:1. Tout ce qui est sous cette ligne est post-portage — la continuation du projet plutôt que son achèvement.

## Règle de design pour les extensions

Chaque feature post-1:1 doit répondre : *Avernite l'aurait-il livrée ?* Si la réponse demande trois paragraphes de justification, ça va dans `mitemc-extended`, pas `mitemc`. Le mod de base reste fidèle.

Conséquences concrètes :

- **Pas de nouvelles dimensions dans le mod de base.** L'Âge mythique existe conceptuellement comme le plateau adamantium ; bâtir une vraie Dimension mythique appartient au mod étendu.
- **Pas d'UI de quêtes dans le mod de base.** Les advancements vanilla sont l'interface diégétique — ajouter un journal de quêtes les concurrencerait.
- **Pas d'arbre de compétences magiques.** La « magie » de MITE est enchantements + matériaux, pas un axe de progression séparé.

## Extensions prévues (`mitemc-extended`, repository futur)

### 1. Dimension mythique

Une nouvelle dimension accessible depuis un cadre de portail crafté en four netherrack. Mobs palier adamantium, recettes de craft mythiques uniquement, structures style raid. **Statut :** notes de design uniquement.

### 2. Biomes étendus

- **Forêt maudite** — biome overworld avec haute chance de brûlure naturelle et spawns d'araignées des bois renforcés.
- **Étendues glaciales** — biome de froid extrême où `cold_biome_mult` vaut 4× au lieu de 2×.
- **Cavernes mythiques** — biome de caverne sous Y=-32 où le minerai d'adamantium se génère et les araignées démoniaques sont 3× plus communes.

**Statut :** brouillons JSON de biome dans `docs/extensions/biomes/` (pas encore rédigés).

### 3. Infrastructure serveur multijoueur

- **Paliers de coffre-fort** — variantes mithril et adamantium avec immunité explosion, traçage de dimension, anti-cassure créative.
- **Enchantements liés au joueur** — enchantements liés à l'UUID, ne peuvent pas être strip en PVP.
- **Commandes serveur uniquement** — `/mitemc reset_player <uuid>`, `/mitemc grant_lore_book all <player>`, etc.

**Statut :** design uniquement.

### 4. Polish qualité (livraison probable avant les extensions)

Reportés des phases 1:1 :

- **Modèles geo + textures custom** pour les 10 mobs hostiles (Phase 4 livre des renderers vanilla en placeholder).
- **Passe textures** pour tous les 50 outils, 4 minerais, raw chunks, lore books — actuellement placeholders.
- **Authoring sons `.ogg`** pour les 4 IDs sonores réservés (Phase 7).
- **Intégration loot Grande Fortune** pour que le niveau V donne effectivement les rolls bonus (Phase 6.5).
- **Application qualité combustible** pour que bois/charbon/lave/verge de blaze verrouillent les paliers de fours (Phase 3.5).
- **IA animale quête de nourriture** pour que vaches/moutons pathfindent vers l'herbe (Phase 5.5).
- **Particules custom** pour transitions blight, flips de lore book, refus de strongbox (Phase 7.5).
- **UI temps de craft custom** — Mixin sur le craft pour forcer recettes temporisées (suite Phase 2.5).

Tracés dans [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md) sous des listes « Tech debt » glissantes.

## Versioning

Le mod de base (`mitemc`) suit du **semver par phase** :

- 0.x.0 — portages pré-release (actuel)
- 1.0.0 — quand les 8 phases sont validées contre un vrai build NeoForge 26.1
- 1.x.0 — passes de patch (Phase X.5 polish)
- 2.0.0 — extensions commencent à livrer (jar `mitemc-extended` séparé ; coexiste avec base)

`mitemc-extended` se versionne indépendamment et dépend de `mitemc` ≥ 1.0.0.

## Politique de contribution pour les extensions

Pour livrer une feature qui n'est pas dans le spec 1:1 :

1. Ouvrir un issue de discussion taggé `extension-proposal`.
2. Identifier l'ancrage MITE R196 *le plus proche* (s'il y en a un). L'invention pure est OK mais doit être honnête.
3. Drafter en PR `mitemc-extended`, pas `mitemc`.
4. La parité de traduction est forcée pour les extensions aussi — mêmes règles i18n s'appliquent.

Le mod de base n'accepte que des features qui se rattachent à l'intention d'Avernite. Les extensions peuvent tout faire.

## Voir aussi

- [Roadmap](https://github.com/MITEMC/mitemc/blob/main/ROADMAP.md) — le plan 1:1 fermé en 8 phases.
- [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md) — log de travail vivant, incluant les listes punch.
- [Crédits](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md) — Avernite, la communauté MITE moderne, et les contributeurs.

---
title: Lore
description: Livres de lore en jeu et philosophie de design.
sidebar:
  order: 11
---

La Phase 7 livre **5 livres de lore** qui font aussi office de journal de design face joueur. Chacun est un item ; clic-droit affiche un passage traduit multi-paragraphes dans le chat dans la langue du joueur. Le texte honore l'esprit des notes de développement d'Avernite du fil forum MITE original.

## Les cinq livres

| ID livre                      | Titre              | Thème                                  |
|-------------------------------|--------------------|----------------------------------------|
| `mitemc:lore_book_origins`    | Origines           | Pourquoi MITE existe                   |
| `mitemc:lore_book_stone_age`  | Âge de pierre      | Phase 1 — la rareté comme tutoriel     |
| `mitemc:lore_book_forge`      | La Forge           | Phases 2–3 — la patience progression   |
| `mitemc:lore_book_deep`       | Les Profondeurs    | Phase 4 — la profondeur comme rampe    |
| `mitemc:lore_book_mythic`     | Âge mythique       | Phase 6+ — la montagne qui existe      |

## Lecture

Clic-droit sur un livre de lore pour imprimer son titre et son corps dans le chat. Le corps est mis en plusieurs paragraphes séparés par des sauts de ligne. Le texte complet vit dans `lang/<locale>.json` aux clés `lore.mitemc.book.<id>.title` et `lore.mitemc.book.<id>.body`.

## Craft

Chaque livre est un craft shapeless : livre vierge vanilla + un objet-marqueur de phase. Aucun livre n'est verrouillé derrière une phase non atteinte, on peut donc les collecter dans le désordre :

| Livre              | Recette                                |
|--------------------|----------------------------------------|
| Origines           | livre vierge + éclat de silex          |
| Âge de pierre      | livre vierge + pierre                  |
| La Forge           | livre vierge + lingot de cuivre        |
| Les Profondeurs    | livre vierge + os                      |
| Âge mythique       | livre vierge + lingot d'adamantium     |

Les objets-marqueurs sont assez petits pour être atteignables dans la phase correspondante mais pas artificiellement verrouillés.

## Philosophie de design

Les livres de lore existent pour deux raisons :

1. **Cohérence narrative** — un mod hardcore sans histoire fait punitif. Un court passage expliquant *pourquoi* une mécanique est là la recadre comme intentionnelle plutôt qu'hostile.
2. **Vitrine de traduction** — les livres sont les passages de prose les plus longs du projet (~3 paragraphes chacun). Ils prouvent que la stack i18n gère du vrai texte, pas seulement des labels.

Pour ajouter de nouveaux livres, le motif est petit :
- Pas besoin de sous-classer `LoreBookItem` ; enregistrez juste un nouveau `LoreBookItem(key, props)` avec une clé string fraîche.
- Ajoutez `lore.mitemc.book.<key>.title` et `lore.mitemc.book.<key>.body` à tous les cinq fichiers `lang/<locale>.json`.
- Optionnel : une recette et un trigger d'arbre de survie.

## Advancement Phase 7

Tenir n'importe quel livre de lore déclenche `mitemc:survival_tree/first_lore`. Tenir les cinq contribue au `survival_tree/completionist`.

## Voir aussi

- [Advancements](/fr/reference/advancements/) — où le lore se branche dans l'arbre de survie.
- [Roadmap](https://github.com/Louisdelez/mitemc/blob/main/ROADMAP.md) — le plan multi-phase complet.

---
title: Lore
description: Libri di lore in gioco e filosofia di design.
sidebar:
  order: 11
---

La Fase 7 porta **5 libri di lore** che fungono anche da diario di design rivolto al giocatore. Ognuno è un oggetto; clic destro mostra un passaggio tradotto a più paragrafi nella chat nella lingua del giocatore. Il testo onora lo spirito delle note di sviluppo di Avernite dal thread originale del forum MITE.

## I cinque libri

| ID libro                     | Titolo            | Tema                                |
|------------------------------|-------------------|-------------------------------------|
| `mitemc:lore_book_origins`   | Origini           | Perché MITE esiste                  |
| `mitemc:lore_book_stone_age` | Età della pietra  | Fase 1 — la scarsità come tutorial  |
| `mitemc:lore_book_forge`     | La Fucina         | Fasi 2–3 — la pazienza progressione |
| `mitemc:lore_book_deep`      | Le Profondità     | Fase 4 — la profondità come rampa   |
| `mitemc:lore_book_mythic`    | Età mitica        | Fase 6+ — la montagna che esiste    |

## Lettura

Clic destro su un libro di lore per stamparne titolo e corpo nella chat. Il corpo è disposto in più paragrafi separati da righe vuote. Il testo completo vive in `lang/<locale>.json` sotto le chiavi `lore.mitemc.book.<id>.title` e `lore.mitemc.book.<id>.body`.

## Crafting

Ogni libro è un crafting shapeless: libro vergine vanilla + un oggetto-marcatore di fase. Nessun libro è bloccato dietro una fase non raggiunta, quindi si possono collezionare in ordine libero:

| Libro              | Ricetta                                |
|--------------------|----------------------------------------|
| Origini            | libro vergine + scheggia di selce      |
| Età della pietra   | libro vergine + pietra                 |
| La Fucina          | libro vergine + lingotto di rame       |
| Le Profondità      | libro vergine + osso                   |
| Età mitica         | libro vergine + lingotto di adamantio  |

I marcatori sono abbastanza piccoli da essere ottenibili nella fase corrispondente senza blocchi artificiali.

## Filosofia di design

I libri di lore esistono per due ragioni:

1. **Coerenza narrativa** — una mod hardcore senza storia sa di punitivo. Un breve passaggio che spiega *perché* una meccanica esiste la inquadra come intenzionale invece che ostile.
2. **Vetrina di traduzione** — i libri sono i passaggi di prosa più lunghi del progetto (~3 paragrafi ciascuno). Dimostrano che lo stack i18n gestisce testo reale, non solo etichette.

Per aggiungere nuovi libri di lore lo schema è piccolo:
- Sottoclasse di `LoreBookItem` *non* serve; basta registrare un nuovo `LoreBookItem(key, props)` con una chiave string fresca.
- Aggiungi `lore.mitemc.book.<key>.title` e `lore.mitemc.book.<key>.body` in tutti e cinque i `lang/<locale>.json`.
- Opzionale: una ricetta e un trigger del survival-tree.

## Traguardo Fase 7

Tenere un qualunque libro di lore scatena `mitemc:survival_tree/first_lore`. Tenerli tutti e cinque contribuisce a `survival_tree/completionist`.

## Vedi anche

- [Traguardi](/it/reference/advancements/) — dove il lore si innesta nel survival-tree.
- [Roadmap](https://github.com/MITEMC/mitemc/blob/main/ROADMAP.md) — il piano multi-fase completo.

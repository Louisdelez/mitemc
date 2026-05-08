---
title: Forni
description: Livelli di calore, qualità del combustibile e matrice di fusione.
sidebar:
  order: 6
---

La catena di fusione di MITEMC sostituisce il «metti minerale nel forno» con una vera progressione. Quattro nuovi blocchi di forno, ciascuno con il proprio livello di calore, regolano quali metalli puoi raffinare.

## La catena

```
Forno d'argilla (0)  →  Forno d'arenaria (1)  →  Forno d'ossidiana (2)  →  Forno di netherrack (3)
```

Il forno vanilla è trattato come **livello 1** — equivalente a un forno d'arenaria per compatibilità.

## Livelli di calore

| Livello | Blocco                  | Luce acceso | Vel. × | Combustibile                                 |
|--------:|-------------------------|------------:|-------:|----------------------------------------------|
|       0 | Forno d'argilla         | 13          | 0,75 × | Carbone, carbone di legna, legno — cottura primitiva |
|       1 | Forno d'arenaria        | 13          | 1,00 × | Come il forno vanilla                        |
|       2 | Forno d'ossidiana       | 14          | 1,40 × | Secchi di lava consigliati                   |
|       3 | Forno di netherrack     | 15          | 1,80 × | Le verghe di blaze sbloccano l'adamantio     |

## Cosa fonde ogni livello

| Ricetta                                  | Liv. min | Tag di blocco                                 |
|------------------------------------------|---------:|-----------------------------------------------|
| Cibo / ferro / rame vanilla              |        0 | (nessuno)                                     |
| `raw_copper_chunk` → `copper_ingot`      |        0 |                                               |
| `raw_silver_chunk` → `silver_ingot`      |        0 |                                               |
| `raw_mithril_chunk` → `mithril_ingot`    |        2 | `#mitemc:requires_obsidian_furnace`           |
| `raw_adamantium_chunk` → `adamantium_ingot` |     3 | `#mitemc:requires_netherrack_furnace`         |

Il blocco passa per tag di oggetti — se il *risultato* di una ricetta è in `#mitemc:requires_obsidian_furnace` e il forno è sotto il livello 2, la ricetta è saltata in silenzio (l'input resta, nessun combustibile consumato).

## Crafting dei forni

| Forno                | Ricetta                                                            |
|----------------------|--------------------------------------------------------------------|
| Forno d'argilla      | 8× terracotta in anello di forno                                   |
| Forno d'arenaria     | 8× arenaria in anello di forno                                     |
| Forno d'ossidiana    | 8× ossidiana + 1 forno vanilla al centro                           |
| Forno di netherrack  | 8× mattoni del Nether + 1 forno d'ossidiana + 1 verga di blaze (in alto a destra) |

Vedi [Ricette](/it/recipes/) per gli schemi visivi.

## Qualità del combustibile

La Fase 3 pone le basi della **qualità del combustibile**, anche se il runtime al momento onora solo i tempi di combustione vanilla. L'infrastruttura è in posizione per differenziare, ad es., legno (calore basso) vs. secchio di lava (calore sostenuto livello ossidiana) vs. verga di blaze (unico combustibile che sblocca il livello netherrack).

Alla prossima passata di datapack, questa tabella diventa canonica:

| Combustibile          | Capacità calorica | Note                                          |
|-----------------------|------------------:|-----------------------------------------------|
| Bastone / assi        | 1                 | Solo livello argilla                          |
| Carbone / carbone di legna | 1            | Solo livello argilla                          |
| Blocco di carbone     | 2                 | Livello arenaria                              |
| Secchio di lava       | 2                 | Arenaria + ossidiana; combustione lunga       |
| Verga di blaze        | 3                 | Richiesta per fusioni livello netherrack      |

## Catena di traguardi della Fase 3

```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```

`netherrack_furnace` è un traguardo sfida (cornice dorata).

## Vedi anche

- [Materiali](/it/reference/materials/) — resa minerali e drop grezzi.
- [Livelli di strumenti](/it/reference/tool-tiers/) — cosa sblocca ogni metallo fuso.
- [Ricette](/it/recipes/) — schemi di crafting esatti per i forni.

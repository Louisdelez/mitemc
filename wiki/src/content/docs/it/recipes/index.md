---
title: Ricette
description: Ricette di crafting introdotte o modificate da MITEMC.
sidebar:
  order: 1
---

Questa sezione si autogenerà dal datapack della mod. Sotto: tutte le ricette di Fase 1 + Fase 2 nell'ordine in cui le scoprirai.

## Fase 1 — Raccolta

### Bastone dalle foglie *(passivo)*
Non è un crafting — le foglie rotte o che decadono hanno 4 % di probabilità di rilasciare un bastone (25 % di quel tasso a decadimento naturale).

## Fase 2 — Crafting di strumenti

Ogni famiglia ha uno schema fisso. Gli slot materiale si riempiono con **schegge di selce** per gli strumenti di selce e con il **lingotto** corrispondente per rame/argento/mithril/adamantio. `B` = bastone, `M` = materiale.

### Mazza — `[ M / M / B ]`
```
. M .
. M .
. B .
```

### Clava — `[ MMM / B / B ]`
```
M M M
. B .
. B .
```

### Asciotta — `[ MM / MB / B ]`
```
M M .
M B .
. B .
```

### Coltello — piccolo (2 caselle)
```
M . .
B . .
```

### Pugnale — piccolo (2 caselle)
```
. M .
. B .
```

### Martello da guerra — `[ MMM / MBM / B ]`
```
M M M
M B M
. B .
```

### Ascia da battaglia — stesso schema del martello da guerra
La forma è identica; la ricetta si distingue per l'ID del risultato.

### Bipenne — `[ MMM / B / B ]`
```
M M M
. B .
. B .
```

### Falce — `[ MM / BM / B ]`
```
M M .
. B M
. B .
```

### Pala — schema vanilla
```
. M .
. B .
. B .
```

## Fusione

| Ingresso             | Uscita         | Metodo   | Tempo |
|----------------------|----------------|----------|-------|
| raw_copper_chunk     | copper_ingot   | smelting | 10 s  |
| raw_copper_chunk     | copper_ingot   | blasting | 5 s   |
| raw_silver_chunk     | silver_ingot   | smelting | 10 s  |
| raw_silver_chunk     | silver_ingot   | blasting | 5 s   |
| raw_mithril_chunk    | mithril_ingot  | smelting | 10 s  |
| raw_mithril_chunk    | mithril_ingot  | blasting | 5 s   |

Il minerale di adamantio droppa il lingotto direttamente — la Fase 3 lo bloccherà dietro un forno di netherrack.

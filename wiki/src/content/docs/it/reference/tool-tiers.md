---
title: Livelli di strumenti
description: Quale strumento estrae cosa.
sidebar:
  order: 2
---

## La catena

```
mani → selce → rame → ferro → argento → mithril → adamantio
```

Ogni livello estrae il proprio minerale e uno sotto. Il ferro vanilla si colloca tra rame e argento di MITEMC e fa da ponte naturale.

## Blocco → livello richiesto

| Blocco                  | Livello richiesto | Note                                                |
|-------------------------|-------------------|-----------------------------------------------------|
| Legno (tronchi)         | asciotta+         | Niente tronchi a mani nude                          |
| Foglie                  | nessuno           | Colpisci liberamente; chance di bastone             |
| Pietra                  | selce+            | Piccone o martello da guerra                        |
| Minerale di carbone     | selce+            |                                                     |
| Minerale di ferro vanilla | selce+          | Tollerato; rame consigliato per resa piena          |
| `mitemc:copper_ore`     | selce+            | Drop `raw_copper_chunk`                             |
| `mitemc:silver_ore`     | rame+             | **Gli strumenti di pietra non estraggono argento**  |
| `mitemc:mithril_ore`    | argento+          |                                                     |
| `mitemc:adamantium_ore` | mithril+          | E solo con forno di ossidiana per fondere il lingotto |

## Famiglie di strumenti

MITEMC porta **10 famiglie di strumenti** oltre a piccone/ascia/pala/spada/zappa vanilla:

- Mazza, clava — armi contundenti (rinculo)
- Asciotta, ascia da battaglia — legno + abbattere (classe ascia)
- Coltello, pugnale — mischia rapida, raccolta piante
- Martello da guerra — pietra + mischia pesante (classe piccone)
- Bipenne — combo di scavo (classe piccone)
- Falce — raccolta ad area (classe zappa)
- Pala — scavo classico

La matrice completa di danno / velocità / blocchi è nel [riferimento Strumenti e armi](/it/reference/tools-and-weapons/).

## Catena di traguardi della Fase 2

```
phase2/root  →  first_copper  →  first_silver  →  first_mithril  →  first_adamantium
```

Ogni passo appare come toast e sblocca il successivo. `first_adamantium` è una sfida (cornice dorata).

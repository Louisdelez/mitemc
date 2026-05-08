---
title: Strumenti e armi
description: Riferimento completo delle 10 famiglie di strumenti di MITEMC.
sidebar:
  order: 4
---

MITEMC porta **10 famiglie di strumenti** — le 9 del MITE di Avernite più una pala per ergonomia. Ogni famiglia è registrata in **5 materiali** (selce, rame, argento, mithril, adamantio), per **50 nuovi oggetti**. Gli strumenti vanilla in ferro, oro, diamante e netherite coesistono; MITEMC non li duplica.

## Matrice delle famiglie

| Famiglia            | Genitore vanilla | Bonus danno  | Velocità attacco | Ruolo                                |
|---------------------|------------------|--------------|-------------------|--------------------------------------|
| Mazza (cudgel)      | tipo spada       | basso (+1)   | -3,4              | Contundente, enfasi sul rinculo      |
| Clava (club)        | tipo spada       | basso+ (+2)  | -3,2              | Più veloce della mazza, meno rinculo |
| Asciotta            | ascia            | medio (+3)   | -3,0              | Piccola ascia, attacco più rapido    |
| Coltello            | tipo spada       | basso (+1)   | -1,8              | Molto veloce, raccolta piante        |
| Pugnale             | tipo spada       | basso+ (+2)  | -1,6              | Sensazione di pugnalata alle spalle  |
| Martello da guerra  | piccone          | alto (+5)    | -3,4              | Pesante; estrae pietra               |
| Ascia da battaglia  | ascia            | alto (+6)    | -3,5              | Lenta, colpo più potente             |
| Bipenne (mattock)   | piccone          | medio (+3)   | -2,8              | Combo piccone + pala                 |
| Falce               | zappa            | medio (+2)   | -2,6              | Raccolta ad area                     |
| Pala                | pala             | basso (+1,5) | -3,0              | Scavo classico                       |

I numeri sono tarature di partenza ereditate dalla matrice di MITE R196 — ogni voce è data-driven e ribilanciabile via il datapack di matrice danni in arrivo.

## Materiale × livello

| Materiale  | Livello di scavo  | Durabilità | Vel. | Bonus danno | Incantabilità |
|------------|-------------------|------------|------|-------------|---------------|
| Selce      | equiv. pietra     | 30         | 3,0  | +0,5        | 6             |
| Rame       | equiv. ferro      | 180        | 5,0  | +1,5        | 12            |
| Ferro      | (vanilla)         | 250        | 6,0  | +2,0        | 14            |
| Argento    | medio             | 400        | 7,0  | +2,0        | 16            |
| Mithril    | alto              | 900        | 9,0  | +3,0        | 22            |
| Adamantio  | apice             | 2200       | 12,0 | +5,0        | 10            |

## Blocchi di scavo

Ogni livello ha un tag di blocchi che **non può** rompere. I livelli alti ereditano i blocchi più bassi.

| Livello     | Non può rompere                              |
|-------------|----------------------------------------------|
| Selce       | `#minecraft:incorrect_for_stone_tool`        |
| Rame        | `#mitemc:needs_silver_tool`                  |
| Argento     | `#mitemc:needs_mithril_tool`                 |
| Mithril     | `#mitemc:needs_adamantium_tool`              |
| Adamantio   | (nessuno — apice)                            |

`#mitemc:needs_silver_tool` include `#mitemc:needs_mithril_tool` che include `#mitemc:needs_adamantium_tool` — l'eredità dei tag fa il lavoro.

## Come leggere un ID di strumento

L'ID dell'oggetto codifica i due assi: `mitemc:<materiale>_<famiglia>`.

Esempi:
- `mitemc:flint_hatchet` — asciotta iniziale per tagliare tronchi.
- `mitemc:copper_war_hammer` — primo strumento pesante che estrae il minerale di ferro vanilla.
- `mitemc:adamantium_dagger` — arma di fine partita più rapida.

## Vedi anche

- [Livelli di strumenti](/it/reference/tool-tiers/) — blocco → livello richiesto.
- [Materiali](/it/reference/materials/) — generazione minerali, fusione, drop grezzi.
- [Ricette](/it/recipes/) — schemi di crafting esatti.

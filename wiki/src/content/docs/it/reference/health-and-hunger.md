---
title: Salute e fame
description: Regole esatte delle statistiche del giocatore in MITEMC.
sidebar:
  order: 1
---

La meccanica simbolo di MITEMC: si parte fragili e si cresce con l'esperienza.

## Valori iniziali

| Statistica           | Vanilla | MITEMC |
|----------------------|---------|--------|
| Cuori massimi        | 10      | **3**  |
| Icone fame massime   | 10      | **3**  |
| Rigenerazione natur. | sì      | lenta  |
| Metabolismo basale   | nessuno | esaurimento passivo |

## Curva di progressione

Ogni **5 livelli di XP** si guadagna **+1 cuore e +1 icona fame**, con tetto al 10/10 vanilla.

| Livello XP | Cuori | Fame |
|------------|-------|------|
| 0          | 3     | 3    |
| 5          | 4     | 4    |
| 10         | 5     | 5    |
| 15         | 6     | 6    |
| 20         | 7     | 7    |
| 25         | 8     | 8    |
| 30         | 9     | 9    |
| 35+        | 10    | 10   |

## Metabolismo basale

Anche fermo, il personaggio consuma energia. Tasso di esaurimento di default: **0,0005 per tick** (0,01 per secondo). A saturazione piena, svuota un'icona fame in circa 3 minuti di gioco.

## Penalità da pioggia

Esposti alla pioggia, l'esaurimento basale è moltiplicato per **3×**. Un tetto o qualunque blocco solido sopra la testa azzera la penalità.

## Debolezza da fame

Quando la fame scende **sotto 1 icona** (valore interno < 1):

- Si applica l'effetto **Debolezza da fame** (indicatore cosmetico).
- Si applica **Lentezza II**.
- **Non puoi rompere o piazzare blocchi**.

Lo stato termina appena mangi qualcosa che riporta la fame a 1 o più.

## Configurazione

Tutti i valori sono regolabili in `config/mitemc-common.toml`. Vedi il [riferimento di configurazione](/it/reference/config/) per il TOML completo.

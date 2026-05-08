---
title: Agricoltura
description: Colture, malattia, letame, meteo e temperatura.
sidebar:
  order: 7
---

La Fase 5 trasforma l'agricoltura da «pianta e dimentica» in un calendario di rischi: le colture possono marcire a metà stagione, la pioggia accelera e minaccia insieme, e i biomi freddi bruciano la fame più in fretta.

## La pianta di cipolla

`mitemc:onion_crop` estende il `CropBlock` vanilla con una proprietà di stato del blocco aggiuntiva: **`blighted`** (booleano).

| Proprietà  | Valori | Effetto                                                              |
|------------|--------|----------------------------------------------------------------------|
| `age`      | 0–7    | Progressione standard                                                |
| `blighted` | bool   | Se `true`, la crescita è sospesa; pianta matura dà solo semi         |

### Drop

| Condizione                      | Drop                                            |
|---------------------------------|-------------------------------------------------|
| Qualunque età                   | 1× semi di cipolla                              |
| `age=7`, `blighted=false`       | + 1–2 cipolle                                   |
| `age=7`                         | + 0–2 semi extra (boost Fortuna)                |
| `age=7`, `blighted=true`        | solo i semi — niente cipolla                    |

Cipolla: nutrizione 2, saturazione 0,4 — modesta, pensata per gli stufati.

## Malattia delle colture (blight)

Una pianta MITEMC **matura e sana** ha una probabilità per random-tick di ammalarsi (`crop_blight_chance`, default 0,5 %). Una volta malata:

- La crescita è **bloccata** (il blocco non supera `age=7`).
- Il blocco lancia per random-tick una probabilità di **infettare un vicino orizzontale** anch'esso maturo e sano (`blight_spread_chance`, default 10 %).
- La raccolta non dà cipolla (solo semi).
- Il clic destro con letame ripulisce il flag `BLIGHTED`.

La propagazione è di un vicino per tick, scelto fra le 4 direzioni cardinali. Una fila di cipolle mature lasciate incustodite finirà tutta malata — pianifica il raccolto.

## Letame

| Fonte                                   | Comportamento                                                            |
|-----------------------------------------|--------------------------------------------------------------------------|
| Random-tick di mucca / maiale           | Probabilità per tick di rilasciare un `mitemc:manure` (default 0,01 %)   |
| Clic destro su una pianta MITEMC malata | Pulisce il flag BLIGHTED, consuma 1 letame                               |
| Clic destro su una qualsiasi coltura vanilla | Funziona come polvere d'ossa (avanza l'età casualmente)             |

Il letame **non fa crescere** alberi, erba né fiori — solo colture.

## Effetti meteo

| Meteo   | Effetto                                                                                  |
|---------|------------------------------------------------------------------------------------------|
| Pioggia | Giocatore esposto al cielo: fame ×3 (Fase 1)                                             |
| Pioggia | Colture MITEMC con accesso al cielo: ~20 % di tick bonus di crescita per random-tick     |
| Pioggia | Pesca: ~25 % di probabilità di drop bonus (merluzzo o kelp) a presa                      |

Il combo crescita bonus + rischio malattia è intenzionale: la pioggia nutre i campi e nutre la marciume.

## Temperatura

Quando un giocatore sta in un bioma con temperatura sotto `cold_biome_threshold` (default 0,2), il metabolismo basale è moltiplicato per `cold_biome_mult` (default 2,0). Cumuli:

| Condizioni                             | Moltiplicatore basale effettivo |
|----------------------------------------|-------------------------------:|
| Bioma caldo, riparato                  | 1,0×                           |
| Bioma caldo, sotto pioggia             | 3,0×                           |
| Bioma freddo, riparato                 | 2,0×                           |
| Bioma freddo, sotto pioggia            | 4,0× (3 + 2 − 1, delta cumulati)|

I biomi nevosi e gelati svuotano la fame in fretta — porta carne secca.

## Catena di traguardi della Fase 5

```
phase5/root  →  first_onion  →  cure_blight (goal)  →  full_pantry (sfida)
```

`full_pantry` richiede 16 cipolle, 16 grano e 16 carote — prova di un'economia alimentare sostenibile.

## Manopole di configurazione

Tutti i numeri della Fase 5 stanno sotto `[phase5]` in `config/mitemc-common.toml`:

```toml
[phase5.agriculture]
crop_blight_chance     = 0.005
blight_spread_chance   = 0.10
rain_growth_chance     = 0.20
animal_manure_chance   = 0.0001

[phase5.environment]
cold_biome_mult        = 2.0
cold_biome_threshold   = 0.2
rain_fishing_bonus     = 0.25
```

Tara a piacere — un server «vanilla feel» può azzerare la malattia; uno hardcore alzarla a 0,02.

## Vedi anche

- [Salute e fame](/it/reference/health-and-hunger/) — esaurimento basale, penalità da pioggia.
- [Forni](/it/reference/furnaces/) — cosa fare del raccolto.
- [Bestiario](/it/bestiary/) — animali che lasciano letame e che hanno fame.

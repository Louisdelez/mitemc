---
title: Materiali
description: Generazione minerali, drop grezzi e fusione.
sidebar:
  order: 5
---

MITEMC aggiunge quattro metalli al ventaglio vanilla: **rame, argento, mithril, adamantio**.
(Ferro, oro, redstone, lapislazzuli, diamante, smeraldo e netherite restano vanilla.)

## Blocchi minerale

| Minerale                   | Sede               | Durezza | Drop XP | Drops                       |
|----------------------------|--------------------|---------|---------|-----------------------------|
| `mitemc:copper_ore`        | pietra overworld   | 3,0     | 0       | `raw_copper_chunk`          |
| `mitemc:silver_ore`        | pietra profonda    | 4,0     | 0–2     | `raw_silver_chunk`          |
| `mitemc:mithril_ore`       | pietra profonda    | 5,0     | 2–5     | `raw_mithril_chunk`         |
| `mitemc:adamantium_ore`    | netherrack         | 7,0     | 4–8     | `adamantium_ingot` (1–2)    |

L'adamantio droppa il lingotto direttamente perché solo i forni alimentati dal Nether sanno fondere la forma grezza, e non distribuiamo ancora un oggetto «adamantio grezzo».

## Requisiti di scavo

| Minerale              | Livello minimo       |
|-----------------------|----------------------|
| `copper_ore`          | selce (equiv. pietra)|
| `silver_ore`          | rame                 |
| `mithril_ore`         | argento              |
| `adamantium_ore`      | mithril              |

Minerale di ferro vanilla: livello rame in MITEMC (vive in `#minecraft:needs_stone_tool` — la selce può estrarlo per regole vanilla, ma lo spirito è «rame o più»).

## Fusione

| Ricetta                          | Tipo     | Tempo  | XP   |
|----------------------------------|----------|--------|------|
| rame grezzo → lingotto rame      | smelting | 200 t  | 0,7  |
| argento grezzo → lingotto argento| smelting | 200 t  | 0,7  |
| mithril grezzo → lingotto mithril| smelting | 200 t  | 0,7  |
| (ognuna sopra)                   | blasting | 100 t  | 0,7  |

La Fase 3 introdurrà forni per livello (argilla, arenaria, ossidiana, netherrack) che filtrano quali metalli si fondono dove. Finché la Fase 3 non arriva, il forno vanilla gestisce tutti e quattro.

## Futuro: varianti deepslate

La Fase 3 aggiungerà varianti deepslate per argento/mithril/adamantio (il Nether resta invariato). Stesse loot table, texture diverse, durezza leggermente maggiore.

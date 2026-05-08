---
title: Migrare da MITE 1.6.4
description: Vieni dal MITE originale di Avernite? Ecco il riassunto.
sidebar:
  order: 3
---

Se hai giocato il MITE originale (R196 su Minecraft 1.6.4), ecco il bigino su cosa si trasferisce e cosa cambia.

## TL;DR

MITEMC è un **port fedele**, non un remake. L'intento: un giocatore 2026 che installa MITEMC dovrebbe sentire di giocare lo stesso mod che fece Avernite — con tutte le comodità moderne (NeoForge, override datapack, UI multilingua) sotto.

## Meccaniche trasferite

| Meccanica MITE R196                                  | Stato MITEMC  |
|------------------------------------------------------|---------------|
| Inizio 3 cuori / 3 fame, +1 ogni 5 livelli XP        | ✓ identico    |
| Metabolismo basale                                   | ✓ identico    |
| Pioggia accelera fame                                | ✓ identico    |
| Debolezza da fame                                    | ✓ identico    |
| Bastone dalle foglie                                 | ✓ identico    |
| 9 famiglie di strumenti                              | ✓ + pala ergonomica |
| 5 materiali (selce/rame/argento/mithril/adamantio)   | ✓ identico    |
| Livelli di scavo                                     | ✓ identico con tag moderni |
| 4 livelli di forni                                   | ✓ identico    |
| Livelli di calore bloccano ricette di fusione        | ✓ identico    |
| 10 mob ostili                                        | ✓ identico    |
| Pianta di cipolla + malattia + letame                | ✓ identico    |
| 7 incantesimi                                        | ✓ identico, "Grande Fortuna" sostituisce la collisione vanilla |
| Cassaforte                                           | ✓ identico    |

## Cambiamenti di comportamento

| Aspetto                       | MITE R196 | MITEMC                                                    |
|-------------------------------|-----------|-----------------------------------------------------------|
| Mod loader                    | Nessuno   | NeoForge                                                  |
| Compatibilità Forge           | Rifiutata | NeoForge nativo                                           |
| Override datapack             | Impossibile | Tutto sovrascrivibile                                   |
| Traduzioni                    | English-ish | EN/FR/DE/ES/IT con parità                               |
| Configurazione                | Code-baked | TOML runtime per Fasi 1 + 5                              |
| Modelli geo dei mob           | Nessuno   | Renderer vanilla come placeholder                         |
| Drop di adamantio             | Lingotto diretto | Drop `raw_adamantium_chunk`, fonde in forno netherrack |
| Durabilità strumenti          | Per durezza blocco | Vanilla per ora                                  |

## Non ancora portato

| Feature MITE R196                               | Stato MITEMC          |
|-------------------------------------------------|-----------------------|
| Crafting cronometrato                           | Lista — Mixin         |
| Qualità del combustibile                        | Infrastruttura pronta |
| Modelli geo / texture custom mob                | Lista                 |
| AI animale ricerca cibo                         | Fase 5.5              |
| Integrazione loot Grande Fortuna                | Fase 6.5              |
| Diari di lore in-game                           | ✓ Fatto come 5 lore book in Fase 7 |

## Save

I save MITE 1.6.4 **non** sono trasferibili. Se hai un mondo MITE caro: screenshot, poi ricominciare.

## ID identici?

No. MITE 1.6.4 usava ID numerici. MITEMC usa `mitemc:<nome>` namespaced.

| MITE R196 (numerico)  | MITEMC (namespace)             |
|-----------------------|--------------------------------|
| Iron Hatchet          | `mitemc:iron_hatchet` (ferro vanilla) |
| Copper Pickaxe        | `mitemc:copper_war_hammer`     |
| Mithril Ore           | `mitemc:mithril_ore`           |
| Strongbox             | `mitemc:iron_strongbox`        |

## Community del mod

La community MITE cinese mantiene MITE vivo dal 2014. MITEMC è uno sforzo separato; riconoscimento in [CREDITS.md](https://github.com/Louisdelez/mitemc/blob/main/docs/CREDITS.md).

## Vedi anche

- [Iniziare](/it/guides/getting-started/)
- [Configurazione](/it/reference/configuration/)
- [FAQ](/it/reference/faq/)

---
title: FAQ
description: Domande frequenti su MITEMC.
sidebar:
  order: 13
---

## Generale

### MITEMC è la stessa cosa di MITE?

**No.** MITEMC è un port del MITE di Avernite (R196, MC 1.6.4) a **Minecraft 26.1** su **NeoForge**. Il MITE originale è congelato a 1.6.4. Vedi [guida di migrazione](/it/guides/migration/).

### Perché «MITEMC»?

Breve per «MITE for Minecraft» + suffisso chiaro.

### MITEMC ha bisogno di Forge?

**No.** È un mod NeoForge. NeoForge ≥ 26.1.x richiesto.

### Posso installare MITEMC accanto ad altri mod?

Sì — i mod NeoForge coesistono di default. Punti di conflitto: altri mod che toccano attributi giocatore, altri mod di agricoltura, altri mod di incantesimi con varianti Fortune-V.

## Gameplay

### Muoio al giorno 1. È intenzionale?

**Sì.** Tre cuori = un colpo di zombie toglie un terzo della vita. Percorso: raccolta → selce → riparo. Vedi [Basi di sopravvivenza](/it/guides/survival-basics/).

### Le mie colture muoiono — bug?

È il **sistema malattia** ([riferimento agricoltura](/it/reference/agriculture/)). Cura col letame o `crop_blight_chance = 0` nella [config](/it/reference/configuration/).

### Perché non si apre questa cassaforte?

È una [cassaforte](/it/reference/strongbox/) che non hai piazzato — solo il proprietario e gli OP possono aprirla.

### Perché il mio piccone rompe minerale di ferro ma non d'argento?

Il minerale d'argento richiede livello rame o superiore in MITEMC. Vedi [Livelli di strumenti](/it/reference/tool-tiers/).

### Il mio piccone Grande Fortuna V non droppa più di Fortuna III. Perché?

La Fase 6 fornisce Grande Fortuna come voce di registry — l'integrazione con loot table è sulla lista Fase 6.5.

## Server / multigiocatore

### I server MITEMC sono performanti?

La maggior parte degli handler sono server-tick con predicati economici. Punti di carico noti: `FertilityHandler`, `AnimalHungerHandler`. Una passata profiler è in lista per Fase 7.5.

### Posso disattivare un'intera fase?

Non con un singolo switch — ma per sistema:
- Fase 1: `starting_hearts=10`, `starting_food=10`, `basal_exhaustion_per_tick=0.0`.
- Fase 4 mob: datapack con spawner vuoti per `data/neoforge/biome_modifier/mitemc_spawns.json`.
- Fase 5: `crop_blight_chance=0`, `animal_manure_chance=0`.

### Permessi?

La cassaforte controlla livello permesso ≥ 2 per l'override OP.

## Traduzioni

### La mia lingua non è supportata.

MITEMC supporta EN/FR/DE/ES/IT. Aggiungere altra: copiare `wiki/src/content/docs/en/`, tradurre, registrare in `wiki/astro.config.mjs`. PR benvenute — vedi [CONTRIBUTING-TRANSLATIONS](https://github.com/MITEMC/mitemc/blob/main/wiki/CONTRIBUTING-TRANSLATIONS.md).

### Una traduzione è sbagliata / suona strana.

PR benvenute.

## Compatibilità

### E la community MITE cinese (FishModLoader, ModernMite)?

MITEMC mira a NeoForge direttamente; FishModLoader è un loader stile Fabric per MC 1.6.4. Piattaforme diverse — MITEMC non è un port di FishModLoader. Riconoscimenti in [CREDITS.md](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md).

### Funzionano gli strumenti di adamantio nei modpack?

Sì — estendono classi vanilla (SwordItem, AxeItem, PickaxeItem). Tinkers, JEI, REI li vedono come standard.

## Bug

### Ho trovato un bug.

[Apri issue](https://github.com/MITEMC/mitemc/issues) con: versione MC, versione NeoForge, log loader, riproduzione minima. Il PROGRESS log nota incertezze API (es. `BlockEvent.CropGrowEvent.Pre`, `RecipeBookType.FURNACE`).

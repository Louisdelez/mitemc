---
title: Roadmap delle estensioni
description: Cosa è previsto oltre il port fedele 1:1.
sidebar:
  order: 14
---

La ROADMAP originale chiude alla **Fase 8**: copertura wiki al 100 % e cornice di design per l'espansione post-1:1. Tutto sotto questa linea è post-port — la continuazione, non il completamento.

## Regola di design per le estensioni

Ogni feature post-1:1 deve rispondere: *Avernite l'avrebbe pubblicata?* Se la risposta richiede tre paragrafi di giustificazione, va in `mitemc-extended`, non `mitemc`.

Conseguenze:

- **Niente nuove dimensioni nel mod base.** L'Età mitica esiste concettualmente come altopiano adamantio.
- **Niente UI di quest nel mod base.** I traguardi vanilla sono l'interfaccia diegetica.
- **Niente albero di abilità magiche.** La «magia» di MITE è incantesimi + materiali.

## Estensioni previste (`mitemc-extended`, repository futuro)

### 1. Dimensione mitica

Una nuova dimensione raggiungibile via portale forgiato in forno netherrack. Mob livello adamantio, ricette mitiche, strutture stile raid. **Stato:** solo note di design.

### 2. Biomi estesi

- **Bosco maledetto** — bioma overworld con alta probabilità di malattia naturale e spawn rinforzati di ragni dei boschi.
- **Lande glaciali** — freddo estremo dove `cold_biome_mult` è 4× invece di 2×.
- **Caverne mitiche** — sotto Y=-32, con minerale di adamantio e ragni demoniaci 3× più comuni.

**Stato:** draft JSON in `docs/extensions/biomes/` (non ancora scritti).

### 3. Infrastruttura server multigiocatore

- **Livelli di cassaforte** — varianti mithril e adamantio con immunità all'esplosione, tracking di dimensione, anti-rottura creativa.
- **Incantesimi legati al giocatore** — UUID-bound, anti-strip PVP.
- **Comandi solo server** — `/mitemc reset_player <uuid>`, `/mitemc grant_lore_book all <player>`.

**Stato:** solo design.

### 4. Rifinitura qualità (probabile prima delle estensioni)

Rinviato dalle fasi 1:1:

- **Modelli geo + texture custom** per i 10 mob ostili.
- **Passata texture** per 50 strumenti, 4 minerali, raw chunks, lore book.
- **Authoring `.ogg`** per i 4 ID di suono riservati (Fase 7).
- **Integrazione loot Grande Fortuna** (Fase 6.5).
- **Applicazione qualità combustibile** (Fase 3.5).
- **AI animale ricerca cibo** (Fase 5.5).
- **Particelle custom** (Fase 7.5).
- **UI tempo crafting custom** (Fase 2.5).

Tracciato in [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md) sotto «Tech debt».

## Versioning

Il mod base segue **semver per fase**:

- 0.x.0 — pre-release (attuale)
- 1.0.0 — quando le 8 fasi sono validate contro un build NeoForge 26.1 reale
- 1.x.0 — passate di patch
- 2.0.0 — le estensioni iniziano a uscire (jar `mitemc-extended` separato)

`mitemc-extended` si versiona indipendentemente e dipende da `mitemc` ≥ 1.0.0.

## Politica di contribuzione

Per feature fuori dallo spec 1:1:

1. Issue di discussione taggato `extension-proposal`.
2. Identificare l'ancora MITE R196 più vicina.
3. Draft come PR a `mitemc-extended`.
4. Parità di traduzione applicata anche alle estensioni.

## Vedi anche

- [Roadmap](https://github.com/MITEMC/mitemc/blob/main/ROADMAP.md)
- [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md)
- [Crediti](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md)

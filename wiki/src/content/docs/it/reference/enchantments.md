---
title: Incantesimi
description: I sette incantesimi MITEMC — effetti, oggetti e curve di livello.
sidebar:
  order: 8
---

La Fase 6 porta **7 incantesimi** modellati sulla lista R196 di Avernite. Cinque sono puramente data-driven (definizioni JSON); due richiedono handler Java perché il loro comportamento altera il mondo per natura.

## Riferimento rapido

| Incantesimo        | Slot       | Oggetti                            | Max | Trigger                       |
|--------------------|------------|------------------------------------|----:|-------------------------------|
| Fretta             | piedi      | `#enchantable/foot_armor`          | III | Equipaggiato (attributo passivo)|
| Stordimento        | mano       | `#enchantable/weapon`              | II  | Post-attacco                  |
| Grande Fortuna     | mano       | `#enchantable/mining`              | V   | Alla rottura blocco (loot)    |
| Rigenerazione      | qualunque  | `#enchantable/armor`               | II  | Tick (passivo)                |
| Fertilità          | mano       | `#enchantable/farm_equipment` (zappa)| III| Tick mentre tenuto            |
| Abbattimento alberi| mano       | `#mitemc:tree_felling_axes`        | I   | Alla rottura tronco           |
| Vampirico          | mano       | `#enchantable/sword`               | III | Post-attacco                  |

## Schede dettagliate

### Fretta — `mitemc:speed`

Solo stivali. Aggiunge **+5 % di velocità per livello** come modificatore `add_multiplied_total`. Si cumula normalmente con Velocità d'anima e pozioni.

| Livello | Bonus velocità |
|---------|--------------:|
| I       | +5 %          |
| II      | +10 %         |
| III     | +15 %         |

### Stordimento — `mitemc:stun`

Arma. Al colpo applica **Lentezza II** alla vittima:
- Livello I: 1–2 s
- Livello II: 1,5–3 s

Solo colpi diretti; i proiettili lanciati non lo attivano.

### Grande Fortuna — `mitemc:greater_fortune`

Strumenti da scavo. Variante MITEMC di Fortuna fino al **V** invece del III vanilla. Mutuamente esclusiva con la Fortuna vanilla (`exclusive_set`).

> **Stato Fase 6:** l'incantesimo esiste ed è rollabile. L'integrazione con loot table per portare davvero la curva di rendimento è rimandata a una passata 6.5.

### Rigenerazione — `mitemc:regeneration`

Armatura. Effetto di tick: applica **Rigenerazione** ogni 5 tick (un quarto di secondo) al livello:
- Livello I: Rigen I
- Livello II: Rigen II

L'accumulo fra più pezzi prende il livello più alto — lo stesso enchant su pezzi multipli non si somma (regola vanilla).

### Fertilità — `mitemc:fertility`

Zappa (`#enchantable/farm_equipment`). Tenuta in mano principale, le colture in un piccolo raggio ricevono **random tick bonus** ogni secondo-server:

| Livello | Raggio (celle) | Tick bonus / s |
|--------:|---------------:|---------------:|
| I       | 1×1×1          | 1              |
| II      | 3×1×3          | 2              |
| III     | 5×1×5          | 4              |

Una zappa Fertilità III tenuta vicino a un campo di grano equivale a una farina d'ossa al minuto — gratis. Combina col letame della Fase 5 per loop cura-poi-cresci-veloce.

### Abbattimento alberi — `mitemc:tree_felling`

Solo asce. Singolo livello. Alla rottura di un tronco con questo enchant in mano, il handler fa un BFS dalla posizione rotta e abbatte ogni tronco connesso dello stesso tipo, capped a **96 tronchi** per sicurezza. Ogni tronco abbattuto:

- Rilascia item alla sua posizione.
- Costa 1 durabilità all'ascia.
- Ferma la catena se l'ascia si rompe.

Il BFS usa i 26 vicini, quindi disposizioni diagonali (giungla, quercia scura) sono gestite.

### Vampirico — `mitemc:vampiric`

Spada. Al colpo diretto l'**attaccante** ottiene una breve Rigenerazione:
- Livello I: Rigen I, 1–2 s
- Livello II: Rigen II, 1–3 s
- Livello III: Rigen III, 1–4 s

Non scatta sui danni indiretti (aura, catene di spine).

## Costi all'incudine

Tutti gli incantesimi MITEMC hanno costi d'incudine più alti dei vanilla — combinare una spada Vampirico III con una fresca costa **8 livelli**, Grande Fortuna V costa **16**. Pianifica la tua economia di incantamento.

## Note di implementazione

- **JSON:** definizioni in `data/mitemc/enchantment/*.json`. I cinque data-driven usano gli effect component vanilla (`minecraft:attributes`, `minecraft:post_attack`, `minecraft:tick`).
- **Java:** Abbattimento e Fertilità sono cablati via `TreeFellingHandler` (game bus, `BlockEvent.BreakEvent`) e `FertilityHandler` (game bus, `PlayerTickEvent.Post`). Entrambi leggono il livello via `ModEnchantments.mainHandLevel(...)`.
- **Tag:** `#mitemc:tree_felling_axes` elenca tutte le asce vanilla e MITEMC eligibili per Abbattimento.

## Vedi anche

- [Strumenti e armi](/it/reference/tools-and-weapons/) — a cosa si attacca ciascun incantesimo.
- [Cassaforte](/it/reference/strongbox/) — l'altra consegna della Fase 6.

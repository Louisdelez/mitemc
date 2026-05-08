---
title: Traguardi
description: Albero completo dei traguardi di tutte le fasi più l'albero di sopravvivenza.
sidebar:
  order: 10
---

MITEMC porta **35 traguardi** organizzati in sette alberi per fase più un albero riepilogativo trasversale.

## Alberi per fase

Ogni fase ha la propria catena di milestone, mostrata nell'UI traguardi vanilla sotto la propria scheda.

### Fase 1 — Fondamenta di sopravvivenza
```
phase1/root → first_stick → first_flint
```

### Fase 2 — Età dei metalli
```
phase2/root → first_copper → first_silver → first_mithril → first_adamantium
```
`first_adamantium` è cornice sfida.

### Fase 3 — Gerarchia dei forni
```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```
`netherrack_furnace` è cornice sfida.

### Fase 4 — Bestiario
```
phase4/root → first_kill → all_ten
```
`all_ten` è cornice sfida.

### Fase 5 — Agricoltura
```
phase5/root → first_onion → cure_blight (goal) → full_pantry
```
`full_pantry` è sfida con 16 cipolle + 16 grano + 16 carote.

### Fase 6 — Incantesimi + cassaforte
```
phase6/root → first_enchant → strongbox
phase6/root → first_enchant → all_seven (sfida)
```

## Albero di sopravvivenza (Fase 7 — trasversale)

Dodici milestone che non sostituiscono gli alberi di fase ma offrono una vista piatta di completamento:

| Slug                | Trigger                                                   | Cornice  |
|---------------------|-----------------------------------------------------------|----------|
| `origins`           | Primo tick in un mondo MITEMC (root)                      | task     |
| `first_food`        | Consumare qualunque cibo                                  | task     |
| `first_kill`        | Player-killed qualunque entità                            | task     |
| `first_metal`       | Qualunque lingotto MITEMC in inventario                   | task     |
| `first_furnace`     | Qualunque forno MITEMC in inventario                      | task     |
| `first_crop`        | Cipolla in inventario                                     | task     |
| `first_enchant`     | Tenere oggetto con incantesimo MITEMC                     | task     |
| `first_strongbox`   | Cassaforte di ferro in inventario                         | task     |
| `first_lore`        | Qualunque libro di lore in inventario                     | task     |
| `bestiary`          | Abbattere una creatura di ogni specie MITEMC              | sfida    |
| `mythic`            | Lingotto di adamantio in inventario                       | sfida    |
| `completionist`     | Adamantio + cassaforte + tutti gli incantesimi + cipolla + lore | sfida |

Il parent dell'albero è `survival_tree/origins` (radice propria), quindi appare separato dagli alberi di fase.

## Trigger usati

- `minecraft:tick` — traguardi root
- `minecraft:inventory_changed` — la maggior parte delle milestone (con predicate `items`)
- `minecraft:player_killed_entity` — milestone di kill (con `entity_properties` opzionale per filtro specie)
- `minecraft:consume_item` — milestone di cibo
- `minecraft:item_used_on_block` — milestone di interazione (es. letame su pianta malata)

## Personalizzazione

I JSON dei traguardi vivono in `data/mitemc/advancements/<phase>/*.json`. Due tipi di override:

- **Disattivare**: copia il JSON in un datapack con `{ "criteria": {} }` e parent vuoto — il motore lo tratta come irraggiungibile.
- **Reskin**: mantieni i criteri, cambia icona/titolo/descrizione.

Chi vuole rimuovere le sfide in particolare può consegnare un piccolo datapack che svuota i loro criteri.

## Tag

`#mitemc:all_enchantments` — usato da `phase6/first_enchant`, `phase6/all_seven`, `survival_tree/first_enchant` e `survival_tree/completionist` per rilevare qualunque dei sette incantesimi MITEMC su un oggetto.

## Vedi anche

- [Lore](/it/reference/lore/) — libri narrativi che validano `first_lore`.
- [Bestiario](/it/bestiary/) — cosa si caccia per `all_ten` / `bestiary`.
- [Incantesimi](/it/reference/enchantments/) — cosa conta per `first_enchant`.

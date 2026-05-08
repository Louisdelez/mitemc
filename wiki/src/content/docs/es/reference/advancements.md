---
title: Logros
description: Árbol completo de logros de todas las fases más el árbol de supervivencia.
sidebar:
  order: 10
---

MITEMC trae **35 logros** organizados en siete árboles por fase más un árbol de resumen entre fases.

## Árboles por fase

Cada fase tiene su propia cadena de hitos, mostrada en la UI vanilla bajo su propia pestaña.

### Fase 1 — Cimientos de supervivencia
```
phase1/root → first_stick → first_flint
```

### Fase 2 — Edad del metal
```
phase2/root → first_copper → first_silver → first_mithril → first_adamantium
```
`first_adamantium` es marco desafío.

### Fase 3 — Jerarquía de hornos
```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```
`netherrack_furnace` es marco desafío.

### Fase 4 — Bestiario
```
phase4/root → first_kill → all_ten
```
`all_ten` es marco desafío.

### Fase 5 — Agricultura
```
phase5/root → first_onion → cure_blight (goal) → full_pantry
```
`full_pantry` es desafío con 16 cebollas + 16 trigo + 16 zanahorias.

### Fase 6 — Encantamientos + caja fuerte
```
phase6/root → first_enchant → strongbox
phase6/root → first_enchant → all_seven (desafío)
```

## Árbol de supervivencia (Fase 7 — entre fases)

Doce hitos que no reemplazan los árboles de fase pero ofrecen una vista plana de completado:

| Slug                | Trigger                                                   | Marco     |
|---------------------|-----------------------------------------------------------|-----------|
| `origins`           | Primer tick en mundo MITEMC (root)                        | task      |
| `first_food`        | Consumir cualquier comida                                 | task      |
| `first_kill`        | Jugador-mata cualquier entidad                            | task      |
| `first_metal`       | Cualquier lingote MITEMC en inventario                    | task      |
| `first_furnace`     | Cualquier horno MITEMC en inventario                      | task      |
| `first_crop`        | Cebolla en inventario                                     | task      |
| `first_enchant`     | Sostener objeto con encantamiento MITEMC                  | task      |
| `first_strongbox`   | Caja fuerte de hierro en inventario                       | task      |
| `first_lore`        | Cualquier libro de lore en inventario                     | task      |
| `bestiary`          | Abatir una criatura de cada especie MITEMC                | desafío   |
| `mythic`            | Lingote de adamantium en inventario                       | desafío   |
| `completionist`     | Adamantium + caja fuerte + todos los encantos + cebolla + lore | desafío |

El padre del árbol es `survival_tree/origins` (su propia raíz), así aparece separado de los árboles de fase.

## Triggers usados

- `minecraft:tick` — logros raíz
- `minecraft:inventory_changed` — la mayoría de hitos (con predicate `items`)
- `minecraft:player_killed_entity` — hitos de matar (con `entity_properties` opcional para filtro de especie)
- `minecraft:consume_item` — hitos de comida
- `minecraft:item_used_on_block` — hitos de interacción (p. ej., estiércol sobre cultivo enfermo)

## Personalización

Los JSON de logros viven en `data/mitemc/advancements/<phase>/*.json`. Dos tipos de override:

- **Desactivar**: copiar el JSON en un datapack con `{ "criteria": {} }` y padre vacío — el motor lo trata como inalcanzable.
- **Reskin**: mantener los criterios, cambiar icono/título/descripción.

Quien quiera quitar los desafíos en concreto puede entregar un datapack pequeño que vacíe sus criterios.

## Tag

`#mitemc:all_enchantments` — usado por `phase6/first_enchant`, `phase6/all_seven`, `survival_tree/first_enchant` y `survival_tree/completionist` para detectar cualquiera de los siete encantamientos MITEMC en un objeto.

## Ver también

- [Lore](/es/reference/lore/) — libros narrativos que cumplen `first_lore`.
- [Bestiario](/es/bestiary/) — qué se caza para `all_ten` / `bestiary`.
- [Encantamientos](/es/reference/enchantments/) — qué cuenta para `first_enchant`.

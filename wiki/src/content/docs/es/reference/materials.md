---
title: Materiales
description: Generación de mineral, drops en bruto y fundición.
sidebar:
  order: 5
---

MITEMC añade cuatro metales al panel vanilla: **cobre, plata, mithril, adamantium**.
(Hierro, oro, redstone, lapislázuli, diamante, esmeralda y netherita siguen vanilla.)

## Bloques de mineral

| Mineral                    | Lugar             | Dureza | Drop XP | Drops                       |
|----------------------------|-------------------|--------|---------|-----------------------------|
| `mitemc:copper_ore`        | piedra overworld  | 3,0    | 0       | `raw_copper_chunk`          |
| `mitemc:silver_ore`        | piedra profunda   | 4,0    | 0–2     | `raw_silver_chunk`          |
| `mitemc:mithril_ore`       | piedra profunda   | 5,0    | 2–5     | `raw_mithril_chunk`         |
| `mitemc:adamantium_ore`    | netherrack        | 7,0    | 4–8     | `adamantium_ingot` (1–2)    |

El adamantium suelta el lingote directo porque solo los hornos alimentados desde el Nether pueden fundir la forma cruda, y aún no enviamos un objeto «adamantium en bruto».

## Requisitos de minado

| Mineral               | Nivel mínimo         |
|-----------------------|----------------------|
| `copper_ore`          | pedernal (equiv. piedra) |
| `silver_ore`          | cobre                |
| `mithril_ore`         | plata                |
| `adamantium_ore`      | mithril              |

Mineral de hierro vanilla: nivel cobre en MITEMC (vive en `#minecraft:needs_stone_tool` — el pedernal puede romperlo por reglas vanilla, pero el espíritu es «cobre o más»).

## Fundición

| Receta                       | Tipo     | Tiempo  | XP   |
|------------------------------|----------|---------|------|
| cobre crudo → lingote cobre  | smelting | 200 t   | 0,7  |
| plata cruda → lingote plata  | smelting | 200 t   | 0,7  |
| mithril crudo → lingote mithril | smelting | 200 t | 0,7  |
| (cada uno arriba)            | blasting | 100 t   | 0,7  |

La Fase 3 introducirá hornos por nivel (arcilla, arenisca, obsidiana, netherrack) que filtran qué metales se funden dónde. Hasta que llegue la Fase 3, el horno vanilla maneja los cuatro.

## Futuro: variantes de pizarra profunda

La Fase 3 añadirá variantes en pizarra profunda para plata/mithril/adamantium (el Nether queda igual). Mismas loot tables, distintas texturas, dureza algo mayor.

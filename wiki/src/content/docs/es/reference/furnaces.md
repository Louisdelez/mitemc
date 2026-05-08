---
title: Hornos
description: Niveles de calor, calidad de combustible y matriz de fundición.
sidebar:
  order: 6
---

La cadena de fundición de MITEMC reemplaza el «meter mineral en el horno» por una progresión real. Cuatro nuevos bloques de horno, cada uno con su nivel de calor, regulan qué metales puedes refinar.

## La cadena

```
Horno de arcilla (0)  →  Horno de arenisca (1)  →  Horno de obsidiana (2)  →  Horno de roca del Nether (3)
```

El horno vanilla se trata como **nivel 1** — equivalente a un horno de arenisca por compatibilidad.

## Niveles de calor

| Nivel | Bloque                      | Luz al encender | Vel. × | Combustible                                 |
|------:|-----------------------------|-----------------:|-------:|---------------------------------------------|
|     0 | Horno de arcilla            | 13               | 0,75 × | Carbón, carbón vegetal, madera — cocción primitiva |
|     1 | Horno de arenisca           | 13               | 1,00 × | Igual que el horno vanilla                  |
|     2 | Horno de obsidiana          | 14               | 1,40 × | Cubos de lava recomendados                  |
|     3 | Horno de roca del Nether    | 15               | 1,80 × | Las varas de blaze desbloquean el adamantium |

## Qué funde cada nivel

| Receta                                   | Nivel mín. | Tag de bloqueo                              |
|------------------------------------------|-----------:|---------------------------------------------|
| Comida / hierro / cobre vanilla          |          0 | (ninguno)                                   |
| `raw_copper_chunk` → `copper_ingot`      |          0 |                                             |
| `raw_silver_chunk` → `silver_ingot`      |          0 |                                             |
| `raw_mithril_chunk` → `mithril_ingot`    |          2 | `#mitemc:requires_obsidian_furnace`         |
| `raw_adamantium_chunk` → `adamantium_ingot` |       3 | `#mitemc:requires_netherrack_furnace`       |

El bloqueo se aplica vía tags de objetos — si el *resultado* de una receta está en `#mitemc:requires_obsidian_furnace` y el horno está por debajo del nivel 2, la receta se omite en silencio (la entrada queda, no se consume combustible).

## Crafteo de los hornos

| Horno                        | Receta                                                            |
|------------------------------|-------------------------------------------------------------------|
| Horno de arcilla             | 8× terracota en anillo de horno                                   |
| Horno de arenisca            | 8× arenisca en anillo de horno                                    |
| Horno de obsidiana           | 8× obsidiana + 1 horno vanilla en el centro                       |
| Horno de roca del Nether     | 8× ladrillos del Nether + 1 horno de obsidiana + 1 vara de blaze (arriba a la derecha) |

Ver [Recetas](/es/recipes/) para los patrones visuales.

## Calidad de combustible

La Fase 3 sienta las bases de la **calidad de combustible**, aunque el runtime hoy honra solo los tiempos de combustión vanilla. La infraestructura está para diferenciar, p. ej., madera (calor bajo) vs. cubo de lava (calor sostenido nivel obsidiana) vs. vara de blaze (único combustible que desbloquea el nivel netherrack).

Cuando llegue la próxima pasada de datapack, esta tabla será canónica:

| Combustible           | Capacidad calórica | Notas                                          |
|-----------------------|-------------------:|------------------------------------------------|
| Palo / tablones       | 1                  | Solo nivel arcilla                             |
| Carbón / carbón veget.| 1                  | Solo nivel arcilla                             |
| Bloque de carbón      | 2                  | Nivel arenisca                                 |
| Cubo de lava          | 2                  | Arenisca + obsidiana; combustión larga         |
| Vara de blaze         | 3                  | Necesaria para fundiciones nivel netherrack    |

## Cadena de logros de la Fase 3

```
phase3/root → clay_oven → obsidian_furnace → netherrack_furnace
```

`netherrack_furnace` es un logro de tipo desafío (marco dorado).

## Ver también

- [Materiales](/es/reference/materials/) — rendimientos de mineral y drops en bruto.
- [Niveles de herramientas](/es/reference/tool-tiers/) — qué desbloquea cada metal fundido.
- [Recetas](/es/recipes/) — patrones de crafteo exactos para los hornos.

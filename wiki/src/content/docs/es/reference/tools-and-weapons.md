---
title: Herramientas y armas
description: Referencia completa de las 10 familias de herramientas de MITEMC.
sidebar:
  order: 4
---

MITEMC trae **10 familias de herramientas** — las 9 del MITE de Avernite más una pala por ergonomía. Cada familia se registra en **5 materiales** (pedernal, cobre, plata, mithril, adamantium), lo que da **50 nuevos objetos**. Las herramientas vanilla de hierro, oro, diamante y netherita coexisten; MITEMC no las duplica.

## Matriz de familias

| Familia            | Padre vanilla | Bonif. daño  | Vel. ataque | Rol                                       |
|--------------------|---------------|--------------|-------------|-------------------------------------------|
| Garrote (cudgel)   | tipo espada   | bajo (+1)    | -3,4        | Contundente, énfasis en retroceso         |
| Maza (club)        | tipo espada   | bajo+ (+2)   | -3,2        | Más rápida que el garrote, menos retroceso |
| Hachuela           | hacha         | medio (+3)   | -3,0        | Hacha pequeña, ataque más rápido          |
| Cuchillo           | tipo espada   | bajo (+1)    | -1,8        | Muy rápido, recolecta plantas             |
| Daga               | tipo espada   | bajo+ (+2)   | -1,6        | Sensación de puñalada por la espalda      |
| Martillo de guerra | pico          | alto (+5)    | -3,4        | Pesado; rompe piedra                      |
| Hacha de batalla   | hacha         | alto (+6)    | -3,5        | Lenta, golpe más fuerte                   |
| Almádena (mattock) | pico          | medio (+3)   | -2,8        | Combo pico + pala                         |
| Guadaña            | azada         | medio (+2)   | -2,6        | Cosecha de plantas en zona                |
| Pala               | pala          | bajo (+1,5)  | -3,0        | Excavación estándar                       |

Las cifras son ajustes iniciales heredados de la matriz de MITE R196 — todas las entradas son data-driven y reequilibrables vía el datapack de matriz de daño que llegará.

## Material × nivel

| Material   | Nivel de minado    | Durabilidad | Vel. | Bonif. daño | Encantabilidad |
|------------|--------------------|-------------|------|-------------|----------------|
| Pedernal   | equiv. piedra      | 30          | 3,0  | +0,5        | 6              |
| Cobre      | equiv. hierro      | 180         | 5,0  | +1,5        | 12             |
| Hierro     | (vanilla)          | 250         | 6,0  | +2,0        | 14             |
| Plata      | medio              | 400         | 7,0  | +2,0        | 16             |
| Mithril    | alto               | 900         | 9,0  | +3,0        | 22             |
| Adamantium | tope               | 2200        | 12,0 | +5,0        | 10             |

## Cierres de minado

Cada nivel tiene un tag de bloques que **no puede** romper. Los niveles altos heredan los cierres bajos.

| Nivel       | No puede romper                              |
|-------------|----------------------------------------------|
| Pedernal    | `#minecraft:incorrect_for_stone_tool`        |
| Cobre       | `#mitemc:needs_silver_tool`                  |
| Plata       | `#mitemc:needs_mithril_tool`                 |
| Mithril     | `#mitemc:needs_adamantium_tool`              |
| Adamantium  | (ninguno — tope)                             |

`#mitemc:needs_silver_tool` incluye `#mitemc:needs_mithril_tool`, que incluye `#mitemc:needs_adamantium_tool` — la herencia de tags hace el trabajo.

## Cómo leer un ID de herramienta

El ID codifica los dos ejes: `mitemc:<material>_<familia>`.

Ejemplos:
- `mitemc:flint_hatchet` — hachuela inicial para talar troncos.
- `mitemc:copper_war_hammer` — primera herramienta pesada que rompe el mineral de hierro vanilla.
- `mitemc:adamantium_dagger` — arma de fin de juego más rápida.

## Ver también

- [Niveles de herramientas](/es/reference/tool-tiers/) — bloque → nivel requerido.
- [Materiales](/es/reference/materials/) — generación, fundición, drops en bruto.
- [Recetas](/es/recipes/) — patrones exactos de crafteo.

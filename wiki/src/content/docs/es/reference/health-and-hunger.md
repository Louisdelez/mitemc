---
title: Salud y hambre
description: Reglas exactas de las estadísticas del jugador en MITEMC.
sidebar:
  order: 1
---

La mecánica emblemática de MITEMC: empieza frágil y se fortalece con la experiencia.

## Valores iniciales

| Estadística         | Vanilla | MITEMC |
|---------------------|---------|--------|
| Corazones máx.      | 10      | **3**  |
| Iconos de hambre    | 10      | **3**  |
| Regeneración natural| sí      | lenta  |
| Metabolismo basal   | ninguno | agotamiento pasivo |

## Curva de progresión

Cada **5 niveles de XP** gana **+1 corazón y +1 icono de hambre**, con tope en el 10/10 vanilla.

| Nivel XP | Corazones | Hambre |
|----------|-----------|--------|
| 0        | 3         | 3      |
| 5        | 4         | 4      |
| 10       | 5         | 5      |
| 15       | 6         | 6      |
| 20       | 7         | 7      |
| 25       | 8         | 8      |
| 30       | 9         | 9      |
| 35+      | 10        | 10     |

## Metabolismo basal

Incluso parado, su personaje gasta energía. Tasa de agotamiento por defecto: **0,0005 por tick** (0,01 por segundo). Con saturación llena, vacía un icono de hambre en unos 3 minutos de juego.

## Penalización por lluvia

Expuesto a la lluvia, el agotamiento basal se multiplica por **3×**. Un techo o cualquier bloque sólido sobre la cabeza anula la penalización.

## Debilidad por hambre

Cuando el hambre cae **por debajo de 1 icono** (valor interno < 1):

- Se aplica el efecto **Debilidad por hambre** (indicador cosmético).
- Se aplica **Lentitud II**.
- **No puede romper ni colocar bloques**.

El estado termina en cuanto come algo que devuelve el hambre a 1 o más.

## Configuración

Todos los valores se ajustan en `config/mitemc-common.toml`. Vea la [referencia de configuración](/es/reference/config/) para el TOML completo.

---
title: Recetas
description: Recetas de crafteo introducidas o modificadas por MITEMC.
sidebar:
  order: 1
---

Esta sección se autogenerará desde el datapack del mod. Abajo: todas las recetas de Fase 1 + Fase 2 en el orden en el que las descubrirás.

## Fase 1 — Recolección

### Palo desde hojas *(pasivo)*
No es un crafteo — las hojas rotas o que decaen tienen 4 % de probabilidad de soltar un palo (25 % de esa tasa al decaer naturalmente).

## Fase 2 — Crafteo de herramientas

Cada familia de herramienta tiene un patrón fijo. Los huecos de material se llenan con **esquirlas de pedernal** para herramientas de pedernal y con el **lingote** correspondiente para cobre/plata/mithril/adamantium. `B` = palo, `M` = material.

### Garrote — `[ M / M / B ]`
```
. M .
. M .
. B .
```

### Maza — `[ MMM / B / B ]`
```
M M M
. B .
. B .
```

### Hachuela — `[ MM / MB / B ]`
```
M M .
M B .
. B .
```

### Cuchillo — pequeño (2 huecos)
```
M . .
B . .
```

### Daga — pequeña (2 huecos)
```
. M .
. B .
```

### Martillo de guerra — `[ MMM / MBM / B ]`
```
M M M
M B M
. B .
```

### Hacha de batalla — mismo patrón que el martillo de guerra
La forma es idéntica; la receta se distingue por el ID del resultado.

### Almádena — `[ MMM / B / B ]`
```
M M M
. B .
. B .
```

### Guadaña — `[ MM / BM / B ]`
```
M M .
. B M
. B .
```

### Pala — patrón vanilla
```
. M .
. B .
. B .
```

## Fundición

| Entrada              | Salida         | Método   | Tiempo |
|----------------------|----------------|----------|--------|
| raw_copper_chunk     | copper_ingot   | smelting | 10 s   |
| raw_copper_chunk     | copper_ingot   | blasting | 5 s    |
| raw_silver_chunk     | silver_ingot   | smelting | 10 s   |
| raw_silver_chunk     | silver_ingot   | blasting | 5 s    |
| raw_mithril_chunk    | mithril_ingot  | smelting | 10 s   |
| raw_mithril_chunk    | mithril_ingot  | blasting | 5 s    |

El mineral de adamantium suelta el lingote directo — la Fase 3 lo bloqueará tras un horno de roca del Nether.

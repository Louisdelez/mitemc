---
title: Encantamientos
description: Los siete encantamientos MITEMC — efectos, objetos y curvas de nivel.
sidebar:
  order: 8
---

La Fase 6 trae **7 encantamientos** modelados sobre la lista R196 de Avernite. Cinco son puramente data-driven (definiciones JSON); dos requieren handlers en Java porque su comportamiento altera el mundo intrínsecamente.

## Resumen rápido

| Encantamiento     | Slot      | Objetos                            | Máx | Trigger                       |
|-------------------|-----------|------------------------------------|----:|-------------------------------|
| Prisa             | botas     | `#enchantable/foot_armor`          | III | Equipado (atributo pasivo)    |
| Aturdimiento      | mano      | `#enchantable/weapon`              | II  | Post-ataque                   |
| Gran Fortuna      | mano      | `#enchantable/mining`              | V   | Al romper bloque (loot bonus) |
| Regeneración      | cualquier | `#enchantable/armor`               | II  | Tick (pasivo)                 |
| Fertilidad        | mano      | `#enchantable/farm_equipment` (azada)| III| Tick mientras se sostiene     |
| Tala de árboles   | mano      | `#mitemc:tree_felling_axes`        | I   | Al romper tronco              |
| Vampírico         | mano      | `#enchantable/sword`               | III | Post-ataque                   |

## Fichas detalladas

### Prisa — `mitemc:speed`

Solo botas. Añade **+5 % de velocidad de movimiento por nivel** como modificador `add_multiplied_total`. Se apila normal con Velocidad del Alma y pociones.

| Nivel | Bonificación |
|-------|------------:|
| I     | +5 %        |
| II    | +10 %       |
| III   | +15 %       |

### Aturdimiento — `mitemc:stun`

Arma. Al impactar, aplica **Lentitud II** a la víctima:
- Nivel I: 1–2 s
- Nivel II: 1,5–3 s

Solo impactos directos; los proyectiles arrojadizos no lo activan.

### Gran Fortuna — `mitemc:greater_fortune`

Picos. Variante MITEMC de Fortuna que llega a **V** en vez del III vanilla. Mutuamente excluyente con Fortuna vanilla (`exclusive_set`).

> **Estado Fase 6:** el encantamiento existe y se puede rolear. La integración con loot tables para entregar la curva de extra-rendimiento queda diferida a una pasada 6.5.

### Regeneración — `mitemc:regeneration`

Armadura. Efecto de tick: aplica **Regeneración** cada 5 ticks (cuarto de segundo) al nivel:
- Nivel I: Regen I
- Nivel II: Regen II

La acumulación entre piezas toma el nivel más alto — el mismo encantamiento en varias piezas no se suma (regla vanilla).

### Fertilidad — `mitemc:fertility`

Azada (`#enchantable/farm_equipment`). Sostenida en mano principal, los cultivos en un pequeño radio reciben **random ticks bonus** cada segundo-servidor:

| Nivel | Radio (celdas) | Ticks bonus / s |
|------:|---------------:|----------------:|
| I     | 1×1×1          | 1               |
| II    | 3×1×3          | 2               |
| III   | 5×1×5          | 4               |

Una azada Fertilidad III sostenida cerca de un trigal equivale aproximadamente a aplicar harina de huesos cada minuto — gratis. Combina con el estiércol de la Fase 5 para bucles cura-luego-crece-rápido.

### Tala de árboles — `mitemc:tree_felling`

Solo hachas. Nivel único. Al romper un tronco con este encantamiento en mano, el handler hace un BFS desde la posición rota y tala todos los troncos conectados del mismo tipo, con tope de **96 troncos** por seguridad. Cada tronco talado:

- Suelta items en su posición.
- Cuesta 1 durabilidad al hacha.
- Detiene la cadena si el hacha se rompe.

El BFS usa los 26 vecinos, así que las disposiciones diagonales (jungla, roble oscuro) se manejan.

### Vampírico — `mitemc:vampiric`

Espada. Al impactar directo, el **atacante** gana Regeneración breve:
- Nivel I: Regen I, 1–2 s
- Nivel II: Regen II, 1–3 s
- Nivel III: Regen III, 1–4 s

No se activa con daño indirecto (aura, cadenas de espinas).

## Costes de yunque

Todos los encantamientos MITEMC tienen costes de yunque mayores que los vanilla — combinar una espada Vampírico III con una nueva cuesta **8 niveles de yunque**, Gran Fortuna V cuesta **16**. Planifica tu economía de encantamiento.

## Notas de implementación

- **JSON:** definiciones en `data/mitemc/enchantment/*.json`. Los cinco data-driven usan effect components vanilla (`minecraft:attributes`, `minecraft:post_attack`, `minecraft:tick`).
- **Java:** Tala y Fertilidad están conectados vía `TreeFellingHandler` (game bus, `BlockEvent.BreakEvent`) y `FertilityHandler` (game bus, `PlayerTickEvent.Post`). Ambos leen el nivel vía `ModEnchantments.mainHandLevel(...)`.
- **Tag:** `#mitemc:tree_felling_axes` lista todas las hachas vanilla y MITEMC elegibles para Tala.

## Ver también

- [Herramientas y armas](/es/reference/tools-and-weapons/) — a qué se aplica cada encantamiento.
- [Caja fuerte](/es/reference/strongbox/) — la otra entrega de la Fase 6.

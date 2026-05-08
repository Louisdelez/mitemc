---
title: Migrar desde MITE 1.6.4
description: ¿Vienes del MITE original de Avernite? Aquí está el resumen.
sidebar:
  order: 3
---

Si jugaste el MITE original (R196 en Minecraft 1.6.4), aquí está la chuleta de qué se mantiene y qué cambia.

## TL;DR

MITEMC es un **port fiel**, no un remake. La intención: un jugador 2026 que instala MITEMC debería sentir que juega el mismo mod que hizo Avernite — con todas las comodidades modernas (NeoForge, override de datapack, UI multilingüe) por debajo.

## Mecánicas trasladadas

| Mecánica MITE R196                                 | Estado MITEMC |
|-----------------------------------------------------|---------------|
| Inicio 3 corazones / 3 hambre, +1 cada 5 niveles XP | ✓ idéntico    |
| Metabolismo basal                                   | ✓ idéntico    |
| Lluvia acelera hambre                               | ✓ idéntico    |
| Debilidad por hambre                                | ✓ idéntico    |
| Palo de hojas                                       | ✓ idéntico    |
| 9 familias de herramientas                          | ✓ + pala ergonómica |
| 5 materiales (pedernal/cobre/plata/mithril/adamantium) | ✓ idéntico |
| Niveles de minado                                   | ✓ idéntico con sistema de tags moderno |
| 4 niveles de hornos                                 | ✓ idéntico    |
| Niveles de calor bloquean recetas de fundición      | ✓ idéntico    |
| 10 mobs hostiles                                    | ✓ idéntico    |
| Cultivo de cebolla + plaga + estiércol              | ✓ idéntico    |
| 7 encantamientos                                    | ✓ idéntico, "Gran Fortuna" reemplaza colisión vanilla |
| Caja fuerte                                         | ✓ idéntico    |

## Cambios de comportamiento

| Aspecto                       | MITE R196 | MITEMC                                                    |
|-------------------------------|-----------|-----------------------------------------------------------|
| Mod loader                    | Ninguno   | NeoForge                                                  |
| Compatibilidad Forge          | Rechazada | NeoForge nativo                                           |
| Override datapack             | Imposible | Todo overridable                                          |
| Traducciones                  | English-ish | EN/FR/DE/ES/IT con paridad                              |
| Configuración                 | Code-baked | TOML runtime para Fase 1 + Fase 5                        |
| Modelos geo de mobs           | Ninguno   | Renderers vanilla como placeholder                        |
| Drop de adamantium            | Lingote directo | Drop `raw_adamantium_chunk`, fundir en horno netherrack |
| Durabilidad herramienta       | Por dureza de bloque | Vanilla por ahora                                |

## No portado todavía

| Feature MITE R196                              | Estado MITEMC          |
|------------------------------------------------|------------------------|
| Crafteo cronometrado                           | Lista — Mixin          |
| Calidad de combustible                         | Infraestructura lista  |
| Modelos geo / texturas custom mobs             | Lista                  |
| IA animal de búsqueda de comida                | Fase 5.5               |
| Integración loot Gran Fortuna                  | Fase 6.5               |
| Diarios de lore in-game                        | ✓ Hecho como 5 lore books en Fase 7 |

## Saves

Los saves MITE 1.6.4 **no** son transferibles. Si tienes un mundo MITE querido: screenshots, luego empezar fresco.

## ¿IDs idénticos?

No. MITE 1.6.4 usaba IDs numéricos. MITEMC usa `mitemc:<nombre>` namespaceado.

| MITE R196 (numérico) | MITEMC (namespace)             |
|----------------------|--------------------------------|
| Iron Hatchet         | `mitemc:iron_hatchet` (hierro vanilla) |
| Copper Pickaxe       | `mitemc:copper_war_hammer`     |
| Mithril Ore          | `mitemc:mithril_ore`           |
| Strongbox            | `mitemc:iron_strongbox`        |

## Comunidad del mod

La comunidad MITE china mantiene MITE vivo desde 2014. MITEMC es un esfuerzo separado; reconocimiento en [CREDITS.md](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md).

## Ver también

- [Empezar](/es/guides/getting-started/)
- [Configuración](/es/reference/configuration/)
- [FAQ](/es/reference/faq/)

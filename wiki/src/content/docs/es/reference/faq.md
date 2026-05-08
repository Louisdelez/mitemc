---
title: FAQ
description: Preguntas frecuentes sobre MITEMC.
sidebar:
  order: 13
---

## General

### ¿MITEMC es lo mismo que MITE?

**No.** MITEMC es un port del MITE de Avernite (R196, MC 1.6.4) a **Minecraft 26.1** sobre **NeoForge**. El MITE original está congelado en 1.6.4. Ver [guía de migración](/es/guides/migration/).

### ¿Por qué «MITEMC»?

Corto para «MITE for Minecraft» + sufijo claro. El nombre original MITE se conserva donde importa.

### ¿Necesita MITEMC Forge?

**No.** MITEMC es un mod NeoForge. NeoForge ≥ 26.1.x requerido.

### ¿Puedo instalar MITEMC junto a otros mods?

Sí — los mods NeoForge coexisten por defecto. Puntos de conflicto: otros mods que tocan atributos de jugador, otros mods de agricultura, otros mods de encantamiento con variantes Fortune-V.

## Gameplay

### Muero el día 1. ¿Es intencional?

**Sí.** Tres corazones significa que un golpe de zombi quita un tercio de vida. Camino: recolectar → pedernal → refugio. Ver [Bases de supervivencia](/es/guides/survival-basics/).

### Mis cultivos mueren — ¿bug?

Es el **sistema de plaga** ([referencia agricultura](/es/reference/agriculture/)). Curar con estiércol o `crop_blight_chance = 0` en la [config](/es/reference/configuration/).

### ¿Por qué no abre esta caja fuerte?

Es una [caja fuerte](/es/reference/strongbox/) que no colocaste — solo el dueño y los OPs pueden abrir.

### ¿Por qué mi pico rompe mineral de hierro pero no mineral de plata?

El mineral de plata exige nivel cobre o más en MITEMC. Ver [Niveles de herramientas](/es/reference/tool-tiers/).

### Mi pico Gran Fortuna V no da más drops que Fortuna III. ¿Por qué?

La Fase 6 entrega Gran Fortuna como entrada de registry — la integración con loot table está en la Fase 6.5.

## Servidor / multijugador

### ¿Los servidores MITEMC son performantes?

La mayoría de handlers son server-tick con predicates baratos. Puntos de carga conocidos: `FertilityHandler`, `AnimalHungerHandler`. Una pasada de profiler está en la lista para Fase 7.5.

### ¿Puedo desactivar una fase entera?

No vía un único switch — pero por sistema:
- Fase 1: `starting_hearts=10`, `starting_food=10`, `basal_exhaustion_per_tick=0.0`.
- Fase 4 mobs: datapack con spawners vacíos para `data/neoforge/biome_modifier/mitemc_spawns.json`.
- Fase 5: `crop_blight_chance=0`, `animal_manure_chance=0`.

### ¿Permisos?

La caja fuerte verifica nivel de permiso ≥ 2 para el override OP.

## Traducciones

### Mi idioma no está soportado.

MITEMC soporta EN/FR/DE/ES/IT. Para añadir otro: copiar `wiki/src/content/docs/en/`, traducir, registrar en `wiki/astro.config.mjs`, copiar `mod/src/main/resources/assets/mitemc/lang/en_us.json`. PRs bienvenidos — ver [CONTRIBUTING-TRANSLATIONS](https://github.com/MITEMC/mitemc/blob/main/wiki/CONTRIBUTING-TRANSLATIONS.md).

### Una traducción es errónea / suena rara.

PRs bienvenidos.

## Compatibilidad

### ¿Y la comunidad MITE china (FishModLoader, ModernMite)?

MITEMC apunta a NeoForge directamente; FishModLoader es un loader estilo Fabric para MC 1.6.4. Plataformas distintas — MITEMC no es port de FishModLoader. Reconocimiento en [CREDITS.md](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md).

### ¿Funcionan las herramientas de adamantium en modpacks?

Sí — extienden clases vanilla (SwordItem, AxeItem, PickaxeItem). Tinkers, JEI, REI las ven como estándar.

## Bugs

### Encontré un bug.

[Abrir issue](https://github.com/MITEMC/mitemc/issues) con: versión MC, versión NeoForge, logs, reproducción mínima. PROGRESS log marca incertidumbres API (ej. `BlockEvent.CropGrowEvent.Pre`, `RecipeBookType.FURNACE`).

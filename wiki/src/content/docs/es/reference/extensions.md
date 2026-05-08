---
title: Roadmap de extensiones
description: Lo previsto más allá del port fiel 1:1.
sidebar:
  order: 14
---

El ROADMAP original cierra en **Fase 8**: cobertura wiki al 100 % y el marco de diseño para expansión post-1:1. Todo bajo esta línea es post-port — la continuación, no la conclusión.

## Regla de diseño para extensiones

Cada feature post-1:1 debe responder: *¿lo habría enviado Avernite?* Si la respuesta requiere tres párrafos de justificación, va a `mitemc-extended`, no a `mitemc`.

Consecuencias:

- **Sin nuevas dimensiones en el mod base.** La Edad mítica existe conceptualmente como meseta adamantium.
- **Sin UI de quests en el mod base.** Los logros vanilla son la interfaz diegética.
- **Sin árbol de habilidades de magia.** La «magia» de MITE es encantamientos + materiales.

## Extensiones planeadas (`mitemc-extended`, repositorio futuro)

### 1. Dimensión mítica

Una nueva dimensión accesible mediante portal forjado en horno netherrack. Mobs de nivel adamantium, recetas míticas, estructuras estilo raid. **Estado:** notas de diseño.

### 2. Biomas extendidos

- **Bosque maldito** — bioma overworld con alta plaga natural y spawns reforzados de arañas de los bosques.
- **Yermos glaciales** — frío extremo donde `cold_biome_mult` es 4× en lugar de 2×.
- **Cavernas míticas** — bajo Y=-32, con mineral de adamantium y arañas demoníacas 3× más comunes.

**Estado:** drafts JSON en `docs/extensions/biomes/` (no escritos aún).

### 3. Infraestructura servidor multijugador

- **Niveles de caja fuerte** — variantes mithril y adamantium con inmunidad a explosiones, tracking de dimensión, anti-rotura creativa.
- **Encantamientos vinculados a jugador** — UUID-bound, anti-strip PVP.
- **Comandos solo de servidor** — `/mitemc reset_player <uuid>`, `/mitemc grant_lore_book all <player>`.

**Estado:** solo diseño.

### 4. Pulido de calidad (probable antes que extensiones)

Diferido de las fases 1:1:

- **Modelos geo + texturas custom** para los 10 mobs hostiles.
- **Pasada de texturas** para 50 herramientas, 4 minerales, raw chunks, lore books.
- **Authoring `.ogg`** para los 4 IDs de sonido reservados (Fase 7).
- **Integración loot Gran Fortuna** (Fase 6.5).
- **Aplicación calidad de combustible** (Fase 3.5).
- **IA animal de búsqueda de comida** (Fase 5.5).
- **Partículas custom** (Fase 7.5).
- **UI de tiempo de craft custom** (Fase 2.5).

Trazadas en [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md) bajo «Tech debt».

## Versionado

El mod base sigue **semver por fase**:

- 0.x.0 — pre-release (actual)
- 1.0.0 — cuando las 8 fases se validen contra build NeoForge 26.1 real
- 1.x.0 — pasadas de patch
- 2.0.0 — extensiones empiezan a entregarse (jar `mitemc-extended` separado)

`mitemc-extended` se versiona independiente y depende de `mitemc` ≥ 1.0.0.

## Política de contribución

Para features fuera del spec 1:1:

1. Issue de discusión etiquetado `extension-proposal`.
2. Identificar el ancla MITE R196 más cercana.
3. Draft como PR a `mitemc-extended`.
4. Paridad de traducción aplicada también a las extensiones.

## Ver también

- [Roadmap](https://github.com/MITEMC/mitemc/blob/main/ROADMAP.md)
- [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md)
- [Créditos](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md)

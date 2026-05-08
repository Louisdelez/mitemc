---
title: Lore
description: Libros de lore en el juego y filosofía de diseño.
sidebar:
  order: 11
---

La Fase 7 trae **5 libros de lore** que también funcionan como diario de diseño orientado al jugador. Cada uno es un objeto; clic derecho muestra un pasaje multipárrafo traducido al idioma del jugador en el chat. El texto honra el espíritu de las notas de desarrollo de Avernite del hilo de foro original de MITE.

## Los cinco libros

| ID libro                      | Título           | Tema                                  |
|-------------------------------|------------------|---------------------------------------|
| `mitemc:lore_book_origins`    | Orígenes         | Por qué existe MITE                   |
| `mitemc:lore_book_stone_age`  | Edad de piedra   | Fase 1 — la escasez como tutorial     |
| `mitemc:lore_book_forge`      | La Fragua        | Fases 2–3 — paciencia como progresión |
| `mitemc:lore_book_deep`       | Las Profundidades| Fase 4 — la profundidad como rampa    |
| `mitemc:lore_book_mythic`     | Edad mítica      | Fase 6+ — la montaña que existe       |

## Lectura

Clic derecho sobre un libro de lore para imprimir título y cuerpo en el chat. El cuerpo se distribuye en varios párrafos separados por líneas en blanco. El texto completo vive en `lang/<locale>.json` bajo las claves `lore.mitemc.book.<id>.title` y `lore.mitemc.book.<id>.body`.

## Crafteo

Cada libro es un crafteo shapeless: libro vacío vanilla + un objeto-marcador de fase. Ningún libro está bloqueado tras una fase no alcanzada, así que se pueden coleccionar en cualquier orden:

| Libro              | Receta                                |
|--------------------|---------------------------------------|
| Orígenes           | libro vacío + esquirla de pedernal    |
| Edad de piedra     | libro vacío + piedra                  |
| La Fragua          | libro vacío + lingote de cobre        |
| Las Profundidades  | libro vacío + hueso                   |
| Edad mítica        | libro vacío + lingote de adamantium   |

Los objetos-marcador son lo bastante pequeños como para conseguirse en la fase correspondiente, sin bloqueo artificial.

## Filosofía de diseño

Los libros de lore existen por dos razones:

1. **Cohesión narrativa** — un mod hardcore sin historia se siente punitivo. Un pasaje breve que explica *por qué* una mecánica está ahí la replantea como intencional en lugar de hostil.
2. **Escaparate de traducción** — los libros son los pasajes de prosa más largos del proyecto (~3 párrafos cada uno). Demuestran que el stack i18n maneja texto real, no solo etiquetas.

Para añadir nuevos libros de lore el patrón es pequeño:
- *No* hace falta subclasear `LoreBookItem`; basta con registrar un nuevo `LoreBookItem(key, props)` con una clave de string fresca.
- Añadir `lore.mitemc.book.<key>.title` y `lore.mitemc.book.<key>.body` a los cinco `lang/<locale>.json`.
- Opcional: una receta y un trigger del árbol de supervivencia.

## Logro Fase 7

Sostener cualquier libro de lore activa `mitemc:survival_tree/first_lore`. Sostener los cinco contribuye a `survival_tree/completionist`.

## Ver también

- [Logros](/es/reference/advancements/) — dónde encaja el lore en el árbol de supervivencia.
- [Roadmap](https://github.com/Louisdelez/mitemc/blob/main/ROADMAP.md) — el plan multi-fase completo.

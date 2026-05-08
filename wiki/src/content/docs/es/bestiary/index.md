---
title: Bestiario
description: Nuevas criaturas introducidas por MITEMC.
sidebar:
  order: 1
---

La Fase 4 trae **10 nuevas especies hostiles**. Cada una es una subclase de un mob vanilla con estadísticas distintas y un comportamiento característico; los modelos geo y texturas personalizadas llegarán en una pasada de pulido.

## De un vistazo

| Especie               | PV | ATQ | Spawn                  | Característico                                      |
|-----------------------|---:|----:|------------------------|-----------------------------------------------------|
| Lobo huargo           | 20 |  6  | Superficie overworld   | Siempre hostil a jugadores; manada de 2-4           |
| Araña de los bosques  | 14 |  3  | Biomas forestales      | Trepa muros; muy rápida                             |
| Gul                   | 24 |  4  | Capas de cuevas        | Mordisco: Lentitud IV + Fatiga minera II 4 s        |
| Espectro              | 18 |  4  | Subterráneo            | Golpes drenan 4 de agotamiento de hambre            |
| Sombra                | 16 |  5  | Luz nivel 0            | Aparece *solo* en oscuridad absoluta                |
| Acechador invisible   | 18 |  5,5| Capas de cuevas        | Auto-Invisibilidad permanente                       |
| Sabueso infernal      | 24 |  7  | Nether                 | Inmune al fuego; incendia al objetivo 5 s           |
| Araña demoníaca       | 20 |  5  | Cuevas profundas       | Salta sobre el objetivo cada 3 s                    |
| Creeper infernal      | 24 |  —  | Nether                 | Mayor radio de explosión; inmune al fuego           |
| Elemental de fuego    | 24 |  6  | Cuevas tipo nether     | Fuego a distancia; más duro que un blaze            |

## Fichas detalladas

### Lobo huargo — `mitemc:dire_wolf`

Primo más grande y feroz del lobo vanilla. **Siempre hostil** al jugador (anula el comportamiento domesticable de `Wolf`). Aparece al crepúsculo en biomas overworld, normalmente en manadas.

- **Botín:** 1–2 huesos.
- **Táctica:** Hachuela+ en mano, lucha en alto; las manadas atacan al de menos PV.

### Araña de los bosques — `mitemc:wood_spider`

Variante de superficie de la araña de cuevas, en biomas forestales. Algo más grande que la vanilla, sin mordisco venenoso — pero muy rápida en la copa.

- **Botín:** 0–2 cuerda, 0–1 ojo de araña.
- **Táctica:** Una daga de pedernal sigue su ritmo; rompe la línea de visión bajo el follaje.

### Gul — `mitemc:ghoul`

Variante zombi de cueva. El mordisco aplica **Lentitud IV + Fatiga minera II** durante 4 s — un efecto paralizante que impide cavar para escapar.

- **Botín:** 0–3 carne podrida, 0–1 hueso.
- **Táctica:** Nada de cuerpo a cuerpo en túneles. Martillo de guerra + ruta de retirada obligatorios.

### Espectro — `mitemc:wight`

Variante esquelética no-muerta. **Los golpes drenan 4 de agotamiento de hambre** al jugador — lleva comida o caerás en Debilidad por hambre en plena pelea.

- **Botín:** 0–3 hueso, 0–2 flechas.
- **Táctica:** Lleva estofado o filete; termina rápido.

### Sombra — `mitemc:shadow`

Aparece **solo a luz nivel 0**. No se quema al sol (de todos modos vive bajo tierra).

- **Botín:** 0–2 carne podrida, 0–1 carbón.
- **Táctica:** Una sola antorcha mata todo el radio de spawn. La luz es la respuesta.

### Acechador invisible — `mitemc:invisible_stalker`

Auto-Invisibilidad permanente (renovada cada 200 ticks). Lo oirás antes de verlo.

- **Botín:** 0–2 carne podrida, 0–1 frasco de cristal.
- **Táctica:** Escucha pasos; una poción arrojadiza de Brillo los descubre.

### Sabueso infernal — `mitemc:hellhound`

Lobo huargo del Nether. Inmune al fuego; **los golpes incendian al objetivo 5 s**. Manadas de 1–3.

- **Botín:** 1–2 hueso, 0–1 polvo de blaze.
- **Táctica:** Poción de Resistencia al fuego antes de entrar a fortalezas del Nether.

### Araña demoníaca — `mitemc:demon_spider`

Variante de cuevas profundas. **Salta sobre su objetivo periódicamente** con gran velocidad vertical. Te alcanzará en repisas que creías seguras.

- **Botín:** 0–2 cuerda, 0–2 ojos de araña.
- **Táctica:** Solo arenas abiertas; jamás luches sobre una repisa de un bloque.

### Creeper infernal — `mitemc:infernal_creeper`

Variante creeper del Nether. **Mayor radio de explosión** (~5 vs vanilla 3), inmune al fuego, resistencia modesta a caídas.

- **Botín:** 1–3 pólvora, 0–1 verruga del Nether.
- **Táctica:** Como un creeper, pero distancia segura 1,6× mayor.

### Elemental de fuego — `mitemc:fire_elemental`

Primo profundo del blaze. Aparece bajo Y=0 en lugar del Nether, con un poco más de PV y rango de persecución de 32 bloques.

- **Botín:** 1–2 varas de blaze.
- **Táctica:** Arco + armadura Protección contra el fuego. Sin equipo adecuado, no entres en cuerpo a cuerpo.

## Pesos de spawn

| Clase de bioma            | Spawners                                                                  |
|---------------------------|---------------------------------------------------------------------------|
| `#minecraft:is_overworld` | Lobo huargo 8, Araña de los bosques 6, Gul 12, Espectro 10, Sombra 4, Acechador invisible 2, Araña demoníaca 5, Elemental de fuego 3 |
| `#minecraft:is_nether`    | Sabueso infernal 12, Creeper infernal 8                                   |

Los pesos son entradas NeoForge BiomeModifier `add_spawns` — sobreescribibles vía datapack.

## Hambre de animales amistosos

La Fase 4 también introduce una mecánica de **hambre para animales amistosos** (vacas, ovejas, cerdos, gallinas):

- Cada animal seguido acumula un contador de hambre cuando no está junto a hierba / trigo / agua.
- Tras un día de juego completo sin alimento, el animal recibe 1 daño por inanición.
- El contador se reinicia al tocar comida y se recupera 4× más rápido al alimentarse.
- Persistido en NBT — sobrevive al descargado del chunk.

Planifica tus granjas: los animales en corrales de tierra morirán. La Fase 5 añadirá alimentación explícita, estiércol y sed encima.

## Cadena de logros de la Fase 4

```
phase4/root  →  first_kill  →  all_ten  (desafío)
```

`first_kill` se activa al primer asesinato de especie MITEMC. `all_ten` requiere una de cada — el trofeo de coleccionista del bestiario.

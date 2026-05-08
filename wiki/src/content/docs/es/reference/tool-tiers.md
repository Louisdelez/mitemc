---
title: Niveles de herramientas
description: Qué herramienta extrae qué.
sidebar:
  order: 2
---

## La cadena

```
manos → pedernal → cobre → hierro → plata → mithril → adamantium
```

Cada nivel extrae su propio mineral y un nivel por debajo. El hierro vanilla queda entre el cobre y la plata de MITEMC y hace de puente natural.

## Bloque → nivel requerido

| Bloque                  | Nivel requerido | Notas                                              |
|-------------------------|-----------------|----------------------------------------------------|
| Madera (troncos)        | hachuela+       | Sin troncos a puño limpio                          |
| Hojas                   | ninguno         | Golpea libre; posibilidad de palo                  |
| Piedra                  | pedernal+       | Pico o martillo de guerra                          |
| Mineral de carbón       | pedernal+       |                                                    |
| Mineral de hierro vanilla | pedernal+     | Permitido; cobre recomendado para rendimiento pleno|
| `mitemc:copper_ore`     | pedernal+       | Suelta `raw_copper_chunk`                          |
| `mitemc:silver_ore`     | cobre+          | **Las herramientas de piedra no rompen plata**     |
| `mitemc:mithril_ore`    | plata+          |                                                    |
| `mitemc:adamantium_ore` | mithril+        | Y solo con horno de obsidiana se funde el lingote  |

## Familias de herramientas

MITEMC trae **10 familias de herramientas** más allá de pico/hacha/pala/espada/azada vanilla:

- Garrote, maza — armas contundentes (retroceso)
- Hachuela, hacha de batalla — madera + tala (clase hacha)
- Cuchillo, daga — cuerpo a cuerpo rápido, recolecta plantas
- Martillo de guerra — piedra + cuerpo a cuerpo pesado (clase pico)
- Almádena — combo de excavación (clase pico)
- Guadaña — cosecha en zona (clase azada)
- Pala — excavación clásica

La matriz completa de daño / velocidad / cierres está en la [referencia Herramientas y armas](/es/reference/tools-and-weapons/).

## Cadena de logros de la Fase 2

```
phase2/root  →  first_copper  →  first_silver  →  first_mithril  →  first_adamantium
```

Cada paso aparece como tostada y desbloquea el siguiente. `first_adamantium` es de tipo desafío (marco dorado).

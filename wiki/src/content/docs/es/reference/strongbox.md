---
title: Caja fuerte
description: Cofre metálico bloqueado al jugador para multijugador.
sidebar:
  order: 9
---

Una **caja fuerte** es un cofre que solo su dueño puede abrir. Pensada para servidores multijugador donde bases compartidas necesitan almacén privado que ni embudos ni otros jugadores puedan vaciar.

## Caja fuerte de hierro — `mitemc:iron_strongbox`

| Propiedad                | Valor                                          |
|--------------------------|------------------------------------------------|
| Almacenamiento           | 27 slots (cofre simple)                        |
| Dureza                   | 5,0                                            |
| Resistencia a explosiones| 1200 (clase obsidiana)                         |
| Herramienta requerida    | Pico                                           |
| Tamaño de pila           | 1 (como objeto)                                |
| Dueño                    | UUID del jugador que la colocó                 |

## Cómo funciona

1. **Colócala.** El UUID del jugador colocador se vincula al BE en `setPlacedBy`.
2. **Clic derecho** para abrir. El `useWithoutItem` lee el UUID dueño del BE:
   - Si no está fijado (legacy), abre para cualquiera.
   - Si coincide con el jugador, abre.
   - Si no coincide y el jugador **no es OP** (nivel de permiso ≥ 2), la apertura se deniega con un mensaje traducido.
3. **Rómpela** para recuperar. El contenido cae al suelo (hook `playerWillDestroy`), el bloque mismo cae vía la loot table.

El override OP es intencional: los admins del servidor pueden abrir cualquier caja fuerte. Si no quieres eso, sobreescribe vía el sistema de permisos.

## Crafteo

```
I I I
I C I    (I = lingote de hierro, C = cofre)
I I I
```

8 lingotes de hierro alrededor de un cofre vanilla.

## Interacción con embudos

La caja fuerte **no implementa** las interfaces de hopper. Los embudos no pueden extraer ni insertar — a prueba de explosiones y de embudos.

## Notas de multijugador

- El UUID del dueño persiste entre reinicios (NBT bajo la clave `Owner`).
- Si el UUID del dueño cambia (raro, pero posible en servidores offline-mode reasignados), la caja queda huérfana — ábrela con herramientas de admin.
- Las cajas fuertes **no** están protegidas contra rotura — cualquiera puede romperla. El contenido cae al suelo; el ítem caja fuerte también. Trátalas como cajas físicas que pueden arrancarse de la pared.

## Variantes futuras

La hoja de ruta reserva sitio para cajas fuertes de niveles superiores tras la Fase 7:

- **Caja fuerte de mithril** — inmunidad a explosiones + seguimiento de dimensión.
- **Caja fuerte de adamantium** — resiste también la rotura en creativo.

No en la Fase 6.

## Logro Fase 6

`mitemc:phase6/strongbox` se activa cuando tienes una caja fuerte en el inventario.

## Ver también

- [Encantamientos](/es/reference/enchantments/) — el otro sistema de la Fase 6.
- [Herramientas y armas](/es/reference/tools-and-weapons/) — pico necesario para romperla.

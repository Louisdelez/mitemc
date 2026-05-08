---
title: Agricultura
description: Cultivos, plagas, estiércol, clima y temperatura.
sidebar:
  order: 7
---

La Fase 5 convierte la agricultura de «planta y olvida» en un calendario de riesgos: los cultivos pueden pudrirse a media temporada, la lluvia acelera y amenaza a la vez, y los biomas fríos consumen el hambre más rápido.

## El cultivo de cebolla

`mitemc:onion_crop` extiende el `CropBlock` vanilla con una propiedad extra de estado de bloque: **`blighted`** (booleano).

| Propiedad  | Valores | Efecto                                                                |
|------------|---------|-----------------------------------------------------------------------|
| `age`      | 0–7     | Progresión estándar                                                   |
| `blighted` | bool    | Si `true`, el crecimiento se detiene; el cultivo maduro solo da semillas |

### Drops

| Condición                       | Drop                                              |
|---------------------------------|---------------------------------------------------|
| Cualquier edad                  | 1× semillas de cebolla                            |
| `age=7`, `blighted=false`       | + 1–2 cebollas                                    |
| `age=7`                         | + 0–2 semillas extra (boost de Fortune)           |
| `age=7`, `blighted=true`        | solo las semillas — sin cebolla                   |

Cebolla: nutrición 2, saturación 0,4 — modesta, pensada para combinarse en estofados.

## Plaga de cultivos (blight)

Un cultivo MITEMC **maduro y sano** tiene una probabilidad por random-tick de enfermar (`crop_blight_chance`, defecto 0,5 %). Una vez enfermo:

- El crecimiento se **detiene** (el bloque no avanzará más allá de `age=7`).
- El bloque tira por random-tick para **infectar a un vecino horizontal** que también esté maduro y sano (`blight_spread_chance`, defecto 10 %).
- Recolectar no da cebolla (solo semillas).
- Clic derecho con estiércol elimina el flag `BLIGHTED`.

La propagación es de un vecino por tick, elegido entre las 4 direcciones cardinales. Una hilera de cebollas maduras desatendidas terminará enferma — planifica la cosecha.

## Estiércol

| Fuente                                   | Comportamiento                                                          |
|------------------------------------------|-------------------------------------------------------------------------|
| Random-tick de vaca / cerdo              | Probabilidad por tick de soltar un `mitemc:manure` (defecto 0,01 %)     |
| Clic derecho sobre un cultivo MITEMC enfermo | Limpia el flag BLIGHTED, consume 1 estiércol                       |
| Clic derecho sobre cualquier cultivo vanilla | Actúa como harina de huesos (avanza la edad al azar)                |

El estiércol **no hace** crecer árboles, hierba ni flores — solo cultivos.

## Efectos del clima

| Clima  | Efecto                                                                                  |
|--------|-----------------------------------------------------------------------------------------|
| Lluvia | Jugador expuesto al cielo: hambre ×3 (Fase 1)                                           |
| Lluvia | Cultivos MITEMC con acceso al cielo: ~20 % tick bonus de crecimiento por random-tick    |
| Lluvia | Pesca: ~25 % de probabilidad de drop bonus (bacalao o kelp) por captura                 |

El combo crecimiento bonus + riesgo de plaga es intencional: la lluvia alimenta tus campos y alimenta la podredumbre.

## Temperatura

Cuando un jugador está en un bioma con temperatura por debajo de `cold_biome_threshold` (defecto 0,2), el metabolismo basal se multiplica por `cold_biome_mult` (defecto 2,0). Acumulaciones:

| Condiciones                            | Multiplicador basal efectivo vs. base |
|----------------------------------------|-------------------------------------:|
| Bioma cálido, resguardado              | 1,0×                                 |
| Bioma cálido, bajo lluvia              | 3,0×                                 |
| Bioma frío, resguardado                | 2,0×                                 |
| Bioma frío, bajo lluvia                | 4,0× (3 + 2 − 1, deltas acumulados)  |

Biomas nevados y helados vacían el hambre rápido — lleva carne seca.

## Cadena de logros de la Fase 5

```
phase5/root  →  first_onion  →  cure_blight (goal)  →  full_pantry (desafío)
```

`full_pantry` requiere 16 cebollas, 16 trigo y 16 zanahorias — prueba de una economía alimentaria viable.

## Botones de configuración

Todos los números de la Fase 5 viven en `[phase5]` en `config/mitemc-common.toml`:

```toml
[phase5.agriculture]
crop_blight_chance     = 0.005
blight_spread_chance   = 0.10
rain_growth_chance     = 0.20
animal_manure_chance   = 0.0001

[phase5.environment]
cold_biome_mult        = 2.0
cold_biome_threshold   = 0.2
rain_fishing_bonus     = 0.25
```

Ajusta a tu gusto — un servidor «sensación vanilla» puede poner la plaga a 0; un hardcore subir a 0,02.

## Ver también

- [Salud y hambre](/es/reference/health-and-hunger/) — agotamiento basal, penalización por lluvia.
- [Hornos](/es/reference/furnaces/) — qué hacer con tu cosecha.
- [Bestiario](/es/bestiary/) — animales que dejan estiércol y necesitan alimentarse.

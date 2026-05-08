---
title: Bestiarium
description: Neue Kreaturen aus MITEMC.
sidebar:
  order: 1
---

Phase 4 liefert **10 neue feindliche Arten**. Jede ist eine Subklasse einer Vanilla-Mob-Basis mit eigenen Werten und einem Signatur-Verhalten; vollständige Custom-Geo-Modelle und Texturen folgen in einer Polish-Runde.

## Auf einen Blick

| Art                  | LP | ATK | Spawn                 | Signatur                                         |
|----------------------|---:|----:|-----------------------|--------------------------------------------------|
| Riesenwolf           | 20 |  6  | Oberweltsoberfläche   | Immer feindselig zu Spielern; Rudel von 2-4      |
| Holzspinne           | 14 |  3  | Waldbiome             | Klettert an Wänden; sehr schnell                 |
| Ghul                 | 24 |  4  | Höhlenebenen          | Biss: Langsamkeit IV + Abbaulähmung II 4 s       |
| Wight                | 18 |  4  | Untertage             | Treffer entziehen 4 Hunger-Erschöpfung           |
| Schatten             | 16 |  5  | Lichtstärke 0         | Erscheint *nur* in absoluter Dunkelheit          |
| Unsichtbarer Stalker | 18 |  5,5| Höhlenebenen          | Permanente Selbst-Unsichtbarkeit                 |
| Höllenhund           | 24 |  7  | Nether                | Feuerimmun; entzündet Ziel für 5 s               |
| Dämonenspinne        | 20 |  5  | Tiefe Höhlen          | Springt alle 3 s aufs Ziel                       |
| Infernal-Creeper     | 24 |  —  | Nether                | Größerer Sprengradius; feuerimmun                |
| Feuerelementar       | 24 |  6  | Nether-artige Höhlen  | Feuerfern; zäher als ein Blaze                   |

## Detailverzeichnisse

### Riesenwolf — `mitemc:dire_wolf`

Größerer, gemeinerer Vetter des Vanilla-Wolfs. **Immer feindselig** zu Spielern (überschreibt das zähmbare Verhalten von `Wolf`). Spawnt zur Dämmerung in Oberwelt-Biomen, meist in Rudeln.

- **Beute:** 1–2 Knochen.
- **Taktik:** Beil+ in der Hand, kämpfe erhöht; Rudel zielen das niedrigste LP an.

### Holzspinne — `mitemc:wood_spider`

Oberflächenvariante der Höhlenspinne in Waldbiomen. Etwas größer als Vanilla, kein Giftbiss — aber sehr schnell im Blätterdach.

- **Beute:** 0–2 Faden, 0–1 Spinnenauge.
- **Taktik:** Ein Feuersteindolch hält das Tempo; Sichtlinie im Unterholz brechen.

### Ghul — `mitemc:ghoul`

Höhlen-Zombie-Variante. Der Biss verleiht **Langsamkeit IV + Abbaulähmung II** für 4 Sekunden — ein Lähmungseffekt, der das Wegheraus-Graben verhindert.

- **Beute:** 0–3 verrottetes Fleisch, 0–1 Knochen.
- **Taktik:** Niemals Nahkampf in Tunneln. Kriegshammer + Rückzugsweg Pflicht.

### Wight — `mitemc:wight`

Untote Skelett-Variante. **Treffer entziehen 4 Hunger-Erschöpfung** beim Spieler — Nahrung mitnehmen oder mitten im Kampf in Hungerschwäche fallen.

- **Beute:** 0–3 Knochen, 0–2 Pfeile.
- **Taktik:** Eintopf oder Steak dabei; schnell beenden.

### Schatten — `mitemc:shadow`

Spawnt **nur bei Lichtstärke 0**. Verbrennt nie in der Sonne (er bleibt sowieso unter Tage).

- **Beute:** 0–2 verrottetes Fleisch, 0–1 Kohle.
- **Taktik:** Eine einzige Fackel tötet den ganzen Spawn-Radius. Licht ist die Antwort.

### Unsichtbarer Stalker — `mitemc:invisible_stalker`

Permanente Selbst-Unsichtbarkeit (alle 200 Ticks erneuert). Du hörst ihn, bevor du ihn siehst.

- **Beute:** 0–2 verrottetes Fleisch, 0–1 Glasflasche.
- **Taktik:** Auf Schritte horchen; Wurftrank des Leuchtens enttarnt sie.

### Höllenhund — `mitemc:hellhound`

Nether-Riesenwolf. Feuerimmun; **Treffer entzünden Ziel 5 s**. Rudel von 1–3.

- **Beute:** 1–2 Knochen, 0–1 Lohenstaub.
- **Taktik:** Feuerresistenz-Trank vor dem Betreten der Nether-Festungen.

### Dämonenspinne — `mitemc:demon_spider`

Tiefenhöhlen-Variante. **Springt periodisch aufs Ziel** mit hoher Vertikalgeschwindigkeit. Erreicht dich auf Vorsprüngen, die du für sicher hieltest.

- **Beute:** 0–2 Faden, 0–2 Spinnenaugen.
- **Taktik:** Nur in offenen Arenen; nie auf 1-Block-Vorsprung kämpfen.

### Infernal-Creeper — `mitemc:infernal_creeper`

Nether-Creeper-Variante. **Größerer Sprengradius** (~5 vs. Vanilla 3), feuerimmun, leichte Fall-Resistenz.

- **Beute:** 1–3 Schießpulver, 0–1 Netherwarze.
- **Taktik:** Wie ein Creeper, aber Sicherheitsabstand 1,6× größer ansetzen.

### Feuerelementar — `mitemc:fire_elemental`

Tiefen-Oberweltvetter des Blaze. Spawnt unter Y=0 statt im Nether, mit etwas mehr LP und 32 Block Verfolgungsreichweite.

- **Beute:** 1–2 Lohenruten.
- **Taktik:** Bogen + Feuerschutz-Rüstung. Kein Nahkampf ohne entsprechende Ausrüstung.

## Spawn-Gewichte

| Biom-Klasse               | Spawner                                                                |
|---------------------------|------------------------------------------------------------------------|
| `#minecraft:is_overworld` | Riesenwolf 8, Holzspinne 6, Ghul 12, Wight 10, Schatten 4, Unsichtbarer Stalker 2, Dämonenspinne 5, Feuerelementar 3 |
| `#minecraft:is_nether`    | Höllenhund 12, Infernal-Creeper 8                                      |

Die Gewichte sind NeoForge-BiomeModifier-`add_spawns`-Einträge — per Datapack überschreibbar.

## Hunger befreundeter Tiere

Phase 4 führt außerdem einen **Hungermechanismus für befreundete Tiere** ein (Kühe, Schafe, Schweine, Hühner):

- Jedes verfolgte Tier füllt einen Hungerzähler, wenn es nicht neben Gras / Weizen / Wasser steht.
- Nach einem vollen In-Game-Tag ohne Nahrung erleidet das Tier 1 Verhungern-Schaden.
- Der Zähler resettet, sobald das Tier Nahrung berührt, und erholt sich beim Fressen 4×-fach.
- Verfolgt in persistentem NBT — übersteht Chunk-Entladen.

Plane deine Farmen entsprechend: Tiere in reinen Erd-Pferchen verhungern. Phase 5 ergänzt explizites Füttern, Mist und Durst.

## Phase-4-Fortschrittskette

```
phase4/root  →  first_kill  →  all_ten  (Herausforderung)
```

`first_kill` löst beim ersten MITEMC-Speziestöten aus. `all_ten` verlangt eines von jeder Art — die Bestiarium-Komplettist-Trophäe.

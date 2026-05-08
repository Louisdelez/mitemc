---
title: Verzauberungen
description: Die sieben MITEMC-Verzauberungen — Effekte, Items und Stufenkurven.
sidebar:
  order: 8
---

Phase 6 liefert **7 Verzauberungen** nach Avernites MITE-R196-Liste. Fünf sind rein datengetrieben (JSON-Definitionen); zwei brauchen Java-Handler, weil ihr Verhalten von Natur aus weltverändernd ist.

## Schnellübersicht

| Verzauberung      | Slot      | Items                              | Max | Auslöser                      |
|-------------------|-----------|------------------------------------|----:|-------------------------------|
| Eile              | Füße      | `#enchantable/foot_armor`          | III | Ausgerüstet (passives Attribut)|
| Betäubung         | Haupthand | `#enchantable/weapon`              | II  | Nach-Angriff                  |
| Großes Glück      | Haupthand | `#enchantable/mining`              | V   | Beim Blockabbau (Loot-Bonus)  |
| Regeneration      | beliebig  | `#enchantable/armor`               | II  | Tick (passiv)                 |
| Fruchtbarkeit     | Haupthand | `#enchantable/farm_equipment` (Hacke)| III| Tick beim Halten              |
| Baumfällen        | Haupthand | `#mitemc:tree_felling_axes`        | I   | Beim Stammabbau               |
| Vampirismus       | Haupthand | `#enchantable/sword`               | III | Nach-Angriff                  |

## Detaillierte Einträge

### Eile — `mitemc:speed`

Nur Stiefel. Fügt **+5 % Bewegungstempo pro Stufe** als `add_multiplied_total`-Attribut hinzu. Stapelt sich normal mit Seelengeschwindigkeit und Tränken.

| Stufe | Tempo-Bonus |
|-------|-----------:|
| I     | +5 %       |
| II    | +10 %      |
| III   | +15 %      |

### Betäubung — `mitemc:stun`

Waffe. Beim Treffer wird **Langsamkeit II** auf das Opfer angewendet:
- Stufe I: 1–2 s
- Stufe II: 1,5–3 s

Nur direkte Treffer; geworfene Projektile lösen es nicht aus.

### Großes Glück — `mitemc:greater_fortune`

Spitzhacken-Klasse. MITEMC-Variante von Glück bis **V** statt Vanilla-III. Gegenseitig ausschließend zum Vanilla-Glück (`exclusive_set`).

> **Phase-6-Status:** die Verzauberung existiert und ist auswürfelbar. Die Loot-Table-Integration für die echte Mehrertragskurve ist auf Phase 6.5 verschoben.

### Regeneration — `mitemc:regeneration`

Rüstung. Tick-Effekt: wendet **Regeneration** alle 5 Ticks (Viertelsekunde) auf der jeweiligen Stufe an:
- Stufe I: Regen I
- Stufe II: Regen II

Mehrteiler-Stapelung nimmt die höchste Stufe — selber Enchant auf mehreren Teilen addiert sich *nicht* (Vanilla-Regel).

### Fruchtbarkeit — `mitemc:fertility`

Hacke (`#enchantable/farm_equipment`). In der Haupthand gehalten erhalten Pflanzen im kleinen Radius **Bonus-Random-Ticks** pro Server-Sekunde:

| Stufe | Radius (Zellen) | Bonus-Ticks / s |
|------:|---------------:|----------------:|
| I     | 1×1×1          | 1               |
| II    | 3×1×3          | 2               |
| III   | 5×1×5          | 4               |

Eine Fruchtbarkeit-III-Hacke neben einem Weizenfeld entspricht etwa einer Knochenmehl-Anwendung pro Minute — kostenlos. Kombiniere mit Mist aus Phase 5 für Heile-dann-Wachse-Loops.

### Baumfällen — `mitemc:tree_felling`

Nur Axt-Klasse. Einzelstufe. Beim Abbau eines Stammblocks mit dieser Verzauberung in der Haupthand führt der Handler eine BFS aus und fällt alle verbundenen Stämme desselben Typs, gedeckelt bei **96 Stämmen** zur Sicherheit. Jeder gefällte Stamm:

- Dropt Items an seiner Position.
- Kostet 1 Haltbarkeit der Axt.
- Stoppt die Kette, wenn die Axt bricht.

Die BFS nutzt 26-Richtungs-Nachbarn, damit diagonale Stämme (Dschungel, Schwarzeiche) erfasst werden.

### Vampirismus — `mitemc:vampiric`

Schwert. Beim direkten Treffer erhält der **Angreifer** kurze Regeneration:
- Stufe I: Regen I, 1–2 s
- Stufe II: Regen II, 1–3 s
- Stufe III: Regen III, 1–4 s

Nicht bei Indirektschaden (Aura, Dornenketten).

## Amboss-Kosten

Alle MITEMC-Verzauberungen haben höhere Amboss-Kosten als Vanilla — Vampirismus III auf ein frisches Schwert kostet **8 Levels**, Großes Glück V kostet **16**. Plane deine Verzauberungswirtschaft.

## Implementierungsnotizen

- **JSON:** Definitionen unter `data/mitemc/enchantment/*.json`. Die fünf Daten-Verzauberungen nutzen Vanilla-Effect-Components (`minecraft:attributes`, `minecraft:post_attack`, `minecraft:tick`).
- **Java:** Baumfällen und Fruchtbarkeit hängen an `TreeFellingHandler` (Game-Bus, `BlockEvent.BreakEvent`) und `FertilityHandler` (Game-Bus, `PlayerTickEvent.Post`). Beide lesen die Stufe via `ModEnchantments.mainHandLevel(...)`.
- **Tag:** `#mitemc:tree_felling_axes` listet alle Vanilla- und MITEMC-Äxte, die für Baumfällen in Frage kommen.

## Siehe auch

- [Werkzeuge & Waffen](/de/reference/tools-and-weapons/) — woran jede Verzauberung haftet.
- [Tresor](/de/reference/strongbox/) — das andere Phase-6-Lieferdatum.

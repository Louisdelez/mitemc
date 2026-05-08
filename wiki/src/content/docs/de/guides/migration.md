---
title: Migration vom MITE 1.6.4
description: Du kommst von Avernites Original-MITE? Hier ist der Spickzettel.
sidebar:
  order: 3
---

Wenn du das Original-MITE (R196 auf Minecraft 1.6.4) gespielt hast, hier der Spickzettel zu dem, was übertragen wird, und was sich ändert.

## TL;DR

MITEMC ist eine **getreue Portierung**, kein Remake. Absicht: ein 2026-Spieler, der MITEMC installiert, soll das Gefühl haben, denselben Mod zu spielen, den Avernite gemacht hat — mit allen modernen Annehmlichkeiten (NeoForge, Datapack-Override, mehrsprachige UI) darunter.

## Übernommene Mechaniken

| MITE-R196-Mechanik                                  | MITEMC-Status |
|-----------------------------------------------------|---------------|
| Start mit 3 Herzen / 3 Hunger, +1 alle 5 XP-Stufen  | ✓ identisch   |
| Grundumsatz (Leerlauf-Hunger)                       | ✓ identisch   |
| Regen beschleunigt Hunger                           | ✓ identisch   |
| Hungerschwäche (kein Abbau/Platzieren)              | ✓ identisch   |
| Stock aus Blättern                                  | ✓ identisch   |
| 9 Werkzeugfamilien (Knüppel/Keule/Beil/Messer/Dolch/Kriegshammer/Streitaxt/Bipenne/Sense) | ✓ + Schaufel ergonomisch ergänzt |
| 5 Materialien (Feuerstein/Kupfer/Silber/Mithril/Adamantium) | ✓ identisch |
| Stufengates für Abbau                               | ✓ identisch mit modernem Tag-System |
| 4 Ofenstufen (Lehm/Sandstein/Obsidian/Netherrack)   | ✓ identisch |
| Hitzestufe sperrt Schmelzrezepte                    | ✓ identisch, item-tag-getrieben |
| 10 feindliche Mobs                                  | ✓ identisch |
| Zwiebelpflanze + Brand + Mist                       | ✓ identisch |
| 7 Verzauberungen                                    | ✓ identisch, „Großes Glück" ersetzt Vanilla-Kollision |
| Tresor (spielergebunden)                            | ✓ identisch |

## Verhaltensänderungen

| Aspekt                          | MITE R196 | MITEMC                                                    |
|---------------------------------|-----------|-----------------------------------------------------------|
| Mod-Loader                      | Keiner    | NeoForge                                                  |
| Forge-Kompatibilität            | Verweigert (~500 Basisklassen) | NeoForge nativ                       |
| Datapack-Override               | Unmöglich | Alle Rezepte / Tags / Fortschritte überschreibbar         |
| Übersetzungen                   | English-ish | EN/FR/DE/ES/IT, paritätsgeprüft                         |
| Konfiguration                   | Code-baked | Runtime-TOML für Phase 1 + Phase 5                       |
| Custom-Geo-Modelle für Mobs     | Keine     | Vanilla-Renderer als Platzhalter (Custom-Modelle ausstehend) |
| Adamantium-Drop                 | Direkt Barren | Dropt jetzt `raw_adamantium_chunk`, Schmelze in Netherrack-Ofen |
| Werkzeug-Haltbarkeitsformel     | Härte-skaliert | Vanilla-Haltbarkeit vorerst (Phase 6.5 bringt Mixin)  |

## Noch nicht portiert

| MITE-R196-Feature                              | MITEMC-Status         |
|------------------------------------------------|-----------------------|
| Zeitbasiertes Crafting                         | Punchliste — Mixin    |
| Brennstoffqualität (Hitzekapazität pro Brennstoff) | Infrastruktur bereit, Runtime nicht erzwungen |
| Custom-Geo-Modelle / Texturen für neue Mobs    | Punchliste            |
| Tier-Suche-Nahrung-AI                          | Phase 5.5             |
| Großes-Glück-Loot-Integration                  | Phase 6.5             |
| In-Game-Lore-Journale aus Avernites Notizen    | ✓ Erledigt als 5 Lore-Bücher in Phase 7 |

## Save-Daten

MITE-1.6.4-Saves sind **nicht** übertragbar. Chunk-Format, Item-NBT, Entity-Typen — alles unwiederbringlich anders zwischen MC 1.6.4 und 26.1. Wenn du eine geliebte MITE-Welt hast: Screenshots machen, dann frisch starten.

## Gleiche IDs?

Nein. MITE 1.6.4 nutzte numerische IDs. MITEMC nutzt `mitemc:<name>`-Namespace-IDs.

| MITE R196 (numerisch)  | MITEMC (Namespace)             |
|------------------------|--------------------------------|
| Iron Hatchet           | `mitemc:iron_hatchet` (Vanilla-Eisen) |
| Copper Pickaxe         | `mitemc:copper_war_hammer`     |
| Mithril Ore            | `mitemc:mithril_ore`           |
| Strongbox              | `mitemc:iron_strongbox`        |

Beim Skripten mit `/give` die neuen IDs verwenden.

## Mod-Community

Die chinesische MITE-Community (Bilibili, QQ) hält MITE seit 2014 am Leben. MITEMC ist ein separates Bestreben; Würdigung in [CREDITS.md](https://github.com/Louisdelez/mitemc/blob/main/docs/CREDITS.md).

## Siehe auch

- [Loslegen](/de/guides/getting-started/) — Frischinstallation.
- [Konfiguration](/de/reference/configuration/) — alle Knöpfe.
- [FAQ](/de/reference/faq/) — häufige Fragen.

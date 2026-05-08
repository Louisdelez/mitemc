---
title: FAQ
description: Häufige Fragen zu MITEMC.
sidebar:
  order: 13
---

## Allgemein

### Ist MITEMC dasselbe wie MITE?

**Nein.** MITEMC ist eine Portierung von Avernites MITE (R196, MC 1.6.4) auf **Minecraft 26.1** unter **NeoForge**. Das Original-MITE ist auf 1.6.4 eingefroren. Siehe [Migrationsleitfaden](/de/guides/migration/).

### Warum „MITEMC"?

Kurz für „MITE für Minecraft" + klares Suffix. Der Original-Name MITE (Minecraft Is Too Easy) bleibt überall erhalten, wo es zählt — in Fortschritten, Lore und im Geist des Designs.

### Braucht MITEMC Forge?

**Nein.** MITEMC ist ein NeoForge-Mod. NeoForge ≥ 26.1.x erforderlich. NeoForge ist der post-2023-Community-Fork von Forge und der De-facto-Standard für inhaltsreiche Mods 2026.

### Kann ich MITEMC neben anderen Mods installieren?

Ja — NeoForge-Mods koexistieren standardmäßig. Konfliktpunkte:

- **Andere Mods, die Spielerattribute berühren** (Max-LP, Hunger) können MITEMCs Modifier überschreiben. Wir nutzen einen benannten `phase1_max_health`-Modifier zur Kollisionsvermeidung.
- **Andere Agrarmods**, die neue Pflanzen einführen, sind in Ordnung; MITEMC-Pflanzen sind namespaced.
- **Andere Verzauberungsmods** mit Fortune-V-Varianten kollidieren mit Großem Glück — der `exclusive_set`-Tag löst das auf.

## Gameplay

### Ich sterbe ständig an Tag 1. Ist das beabsichtigt?

**Ja.** Drei Herzen heißt: ein Zombietreffer kostet ein Drittel Leben. Der vorgesehene Pfad ist Sammeln → Feuerstein → Schutz für Nacht 1, nicht Engagement. Siehe [Überlebensgrundlagen](/de/guides/survival-basics/).

### Meine Pflanzen sterben — Bug?

Es ist das **Brand-System** ([Landwirtschaft](/de/reference/agriculture/)). Reife Pflanzen haben eine kleine Chance pro Random-Tick, Brand zu entwickeln. Mit Mist heilen. Oder `crop_blight_chance = 0` in der [Konfiguration](/de/reference/configuration/) setzen, wenn nicht gewünscht.

### Warum kann ich diesen Tresor nicht öffnen?

Es ist ein [Tresor](/de/reference/strongbox/), den du nicht platziert hast — nur Besitzer (Platzierer) und OPs können öffnen. Abbauen (dropt Inhalte) oder vom Besitzer öffnen lassen.

### Warum baut meine Spitzhacke Eisenerz ab, aber kein Silbererz?

Silbererz braucht Kupfer-Stufe oder höher in MITEMC. Vanilla-Spitzhacken-Stufen decken nur Eisen. Siehe [Werkzeugstufen](/de/reference/tool-tiers/).

### Ich habe eine Großes-Glück-V-Spitzhacke, aber meine Drops sind nicht anders als bei Vanilla-Glück III. Warum?

Phase 6 liefert Großes Glück als Registry-Eintrag — die Loot-Table-Integration für die zusätzlichen Rolls steht auf der Phase-6.5-Liste. Vanilla-Glück III tut's bis dahin.

## Server / Mehrspieler

### Sind MITEMC-Server performant?

Die meisten Handler sind server-tick-scoped mit billigen Predicates. Bekannte Lastpunkte:

- `FertilityHandler` scannt eine kleine Fläche pro Spielertick (nur wenn Fruchtbarkeitshacke gehalten).
- `AnimalHungerHandler` läuft alle 100 Ticks pro Tier — gut gedeckelt.
- `AnimalManureHandler` Tickchance 0,01 % pro Kuh/Schwein — kaum messbar.

Ein Profiler-Lauf steht für Phase 7.5 an.

### Kann ich eine ganze Phase deaktivieren?

Nicht via Einzel-Switch — aber pro System überschreibbar:

- Phase 1: `starting_hearts=10`, `starting_food=10`, `basal_exhaustion_per_tick=0.0`.
- Phase 4 Mobs: Datapack mit leeren Spawnern für `data/neoforge/biome_modifier/mitemc_spawns.json`.
- Phase 5: `crop_blight_chance=0`, `animal_manure_chance=0`.

### Berechtigungen?

Tresor prüft Permission-Level ≥ 2 für den OP-Override. Standard-NeoForge-Berechtigungsintegration gilt.

## Übersetzungen

### Meine Sprache fehlt.

MITEMC liefert in EN/FR/DE/ES/IT. Hinzufügen: `wiki/src/content/docs/en/` in einen neuen Locale-Ordner kopieren, übersetzen, Locale in `wiki/astro.config.mjs` ergänzen, `mod/src/main/resources/assets/mitemc/lang/en_us.json` zur Sprachcode-Datei kopieren. PRs willkommen — siehe [CONTRIBUTING-TRANSLATIONS](https://github.com/MITEMC/mitemc/blob/main/wiki/CONTRIBUTING-TRANSLATIONS.md).

### Eine Übersetzung ist falsch / ungelenk.

PRs willkommen.

## Kompatibilität

### Was ist mit der chinesischen MITE-Community (FishModLoader, ModernMite)?

MITEMC zielt direkt auf NeoForge, FishModLoader ist ein Fabric-artiger Loader für MC 1.6.4. Verschiedene Plattformen — MITEMC ist keine Portierung von FishModLoader-Arbeit. Wir würdigen die moderne MITE-Community in [CREDITS.md](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md).

### Funktionieren Adamantium-Werkzeuge in Modpacks?

Ja — sie erweitern Vanilla-Klassen (SwordItem, AxeItem, PickaxeItem) und nutzen Standard-Haltbarkeit/Schaden. Tinkers, JEI, REI sehen sie als Standardwerkzeuge.

## Bugs

### Ich habe einen Bug gefunden.

[Issue öffnen](https://github.com/MITEMC/mitemc/issues) mit MC-Version, NeoForge-Version, Loader-Logs, minimaler Reproduktion. Das PROGRESS-Log notiert API-Unsicherheiten (z. B. `BlockEvent.CropGrowEvent.Pre`, `RecipeBookType.FURNACE`) — typischste Erst-Build-Anpassungspunkte.

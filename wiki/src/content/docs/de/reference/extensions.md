---
title: Erweiterungen-Roadmap
description: Was über die getreue 1:1-Portierung hinaus geplant ist.
sidebar:
  order: 14
---

Die ursprüngliche ROADMAP schließt mit **Phase 8**: 100 % Wiki-Abdeckung und der Designrahmen für Post-1:1-Erweiterung. Alles unter dieser Linie ist Post-Portierung — Fortsetzung, nicht Vollendung.

## Designregel für Erweiterungen

Jedes Post-1:1-Feature muss beantworten: *Hätte Avernite das geliefert?* Wenn die Antwort drei Absätze Rechtfertigung braucht, gehört es in `mitemc-extended`, nicht `mitemc`. Der Basismod bleibt treu.

Konkrete Konsequenzen:

- **Keine neuen Dimensionen im Basismod.** Das Mythische Zeitalter existiert konzeptuell als Adamantium-Plateau; eine literale Mythische Dimension gehört in extended.
- **Keine Quest-UI im Basismod.** Vanilla-Fortschritte sind die diegetische Schnittstelle.
- **Kein Magie-Skilltree.** MITEs „Magie" ist Verzauberungen + Materialien.

## Geplante Erweiterungen (`mitemc-extended`, künftiges Repo)

### 1. Mythische Dimension

Eine neue Dimension, erreichbar über einen mit Netherrack-Ofen gefertigten Portalrahmen. Adamantium-Stufen-Mobs, mythische Crafting-Rezepte, Raid-Strukturen. **Status:** nur Designnotizen.

### 2. Erweiterte Biome

- **Verfluchter Wald** — Oberweltbiom mit hoher natürlicher Brandchance und verstärkten Holzspinnen-Spawns.
- **Gletscherödland** — Extremkalt-Biom mit `cold_biome_mult` 4× statt 2×.
- **Mythische Höhlen** — Höhlen-Biom unter Y=-32, in dem Adamantium-Erz generiert und Dämonenspinnen 3× häufiger sind.

**Status:** Biom-JSON-Drafts in `docs/extensions/biomes/` (noch nicht verfasst).

### 3. Mehrspieler-Server-Infrastruktur

- **Tresorstufen** — Mithril- und Adamantium-Varianten mit Sprengimmunität, Dimensionstracking, anti-Kreativ-Abbau.
- **Spielergebundene Verzauberungen** — UUID-gebunden, PVP-strip-resistent.
- **Server-Befehle** — `/mitemc reset_player <uuid>`, `/mitemc grant_lore_book all <player>`, etc.

**Status:** nur Design.

### 4. Qualitätspolish (wahrscheinlich vor Erweiterungen)

Aus den 1:1-Phasen verschoben:

- **Custom-Geo-Modelle + Texturen** für die 10 feindlichen Mobs.
- **Texturpass** für 50 Werkzeuge, 4 Erze, Roh-Brocken, Lore-Bücher.
- **Sound-`.ogg`-Authoring** für die 4 reservierten Sound-IDs (Phase 7).
- **Großes-Glück-Loot-Integration** (Phase 6.5).
- **Brennstoffqualität-Erzwingung** (Phase 3.5).
- **Tier-Suche-Nahrung-AI** (Phase 5.5).
- **Custom-Partikel** für Brand-Übergänge, Lore-Buch-Flips, Tresor-Verweigerung (Phase 7.5).
- **Custom-Crafting-Zeit-UI** (Phase 2.5-Folge).

Verfolgt in [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md) unter „Tech debt".

## Versionierung

Der Basismod (`mitemc`) folgt **Semver pro Phase**:

- 0.x.0 — Pre-Release-Portierungen (aktuell)
- 1.0.0 — wenn alle 8 Phasen gegen ein echtes NeoForge-26.1-Build validiert sind
- 1.x.0 — Patch-Pässe (Phase X.5 Polish)
- 2.0.0 — Erweiterungen beginnen zu liefern (separates `mitemc-extended`-Jar)

`mitemc-extended` versioniert eigenständig und hängt von `mitemc` ≥ 1.0.0 ab.

## Beitragspolitik für Erweiterungen

Für Features außerhalb des 1:1-Specs:

1. Diskussions-Issue mit Tag `extension-proposal` öffnen.
2. *Nächstgelegenen* MITE-R196-Anker identifizieren (falls vorhanden). Reine Erfindung okay, aber ehrlich.
3. Als `mitemc-extended`-PR drafften.
4. Übersetzungsparität gilt auch für Erweiterungen — gleiche i18n-Regeln.

Der Basismod akzeptiert nur Features, die zu Avernites Absicht zurückführen. Erweiterungen können alles.

## Siehe auch

- [Roadmap](https://github.com/MITEMC/mitemc/blob/main/ROADMAP.md) — geschlossener 8-Phasen-1:1-Plan.
- [PROGRESS.md](https://github.com/MITEMC/mitemc/blob/main/PROGRESS.md) — Live-Log mit Punchliste.
- [Credits](https://github.com/MITEMC/mitemc/blob/main/docs/CREDITS.md) — Avernite, moderne MITE-Community, Mitwirkende.

---
title: Materialien
description: Erzgenese, Roh-Drops und Schmelze.
sidebar:
  order: 5
---

MITEMC fügt der Vanilla-Materialwelt vier Metalle hinzu: **Kupfer, Silber, Mithril, Adamantium**.
(Eisen, Gold, Redstone, Lapis, Diamant, Smaragd und Netherite bleiben Vanilla.)

## Erzblöcke

| Erz                        | Vorkommen          | Härte | XP-Drop | Drops                       |
|----------------------------|--------------------|-------|---------|-----------------------------|
| `mitemc:copper_ore`        | Oberweltstein      | 3,0   | 0       | `raw_copper_chunk`          |
| `mitemc:silver_ore`        | tiefer Stein       | 4,0   | 0–2     | `raw_silver_chunk`          |
| `mitemc:mithril_ore`       | tiefer Stein       | 5,0   | 2–5     | `raw_mithril_chunk`         |
| `mitemc:adamantium_ore`    | Netherrack         | 7,0   | 4–8     | `adamantium_ingot` (1–2)    |

Adamantium dropt direkt den Barren, weil nur Nether-befeuerte Öfen die Rohform schmelzen können und wir noch keine Roh-Adamantium-Halteinheit ausliefern.

## Abbau-Anforderungen

| Erz                   | Mindestwerkzeugstufe |
|-----------------------|----------------------|
| `copper_ore`          | Feuerstein (Stein)   |
| `silver_ore`          | Kupfer               |
| `mithril_ore`         | Silber               |
| `adamantium_ore`      | Mithril              |

Vanilla-Eisenerz: Kupfer-Stufe in MITEMC (es liegt in `#minecraft:needs_stone_tool` — Feuerstein kann es per Vanilla-Regeln abbauen, gemeint ist aber „Kupfer oder höher").

## Schmelze

| Rezept                       | Typ      | Zeit   | XP   |
|------------------------------|----------|--------|------|
| Rohkupfer → Kupferbarren     | Schmelze | 200 t  | 0,7  |
| Rohsilber → Silberbarren     | Schmelze | 200 t  | 0,7  |
| Rohmithril → Mithrilbarren   | Schmelze | 200 t  | 0,7  |
| (jeweils oben)               | Brennen  | 100 t  | 0,7  |

Phase 3 führt gestufte Öfen ein (Lehm, Sandstein, Obsidian, Netherrack), die regeln, welche Metalle wo schmelzen. Bis Phase 3 erschienen ist, behandelt der Vanilla-Ofen alle vier.

## Zukunft: Tiefenschiefer-Varianten

Phase 3 ergänzt Tiefenschiefer-Varianten für Silber/Mithril/Adamantium (Nether bleibt unverändert). Gleiche Loot-Tables, andere Texturen, leicht höhere Härte.

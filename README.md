# MITEMC — Minecraft Is Too Easy, Modernized

A faithful 1:1 port of the legendary **MITE** mod (Avernite, 2014–2017, MC 1.6.4) to **Minecraft 26.1** on **NeoForge**, plus a complete multilingual wiki.

> _"Minecraft is too easy."_ Still true. Still fixable.

---

## Repository layout

```
MITEMC/
├── mod/        NeoForge mod (Gradle, MC 26.1)
├── wiki/       Astro Starlight site, 5-language i18n
├── docs/       Design notes, CREDITS, EXTENSIONS plan
├── scripts/    Tooling (sync-locales, render-recipes)
├── ROADMAP.md  8-phase 1:1 implementation plan (closed)
├── PROGRESS.md Live work log, per session
├── CHANGELOG.md User-facing per-phase deltas
└── LICENSE     GPL-3.0
```

## Stack

| Component   | Choice                                  | Why                                                       |
|-------------|-----------------------------------------|-----------------------------------------------------------|
| MC version  | 26.1.x (calendar versioning, post-2026) | Latest stable; first version of the new "Tiny Takeover" line |
| Mod loader  | NeoForge                                | De-facto standard for content-heavy mods in 2026          |
| Lang        | Java 21                                 | Required by NeoForge for 26.x                             |
| Mixin       | NeoForge-bundled                        | For surgical base-class behavior (MITE's signature style) |
| Wiki        | Astro Starlight                         | Best built-in i18n, smallest JS bundle, fastest builds    |
| Languages   | EN, FR, DE, ES, IT                      | Both mod (lang JSON) and wiki                             |

## Feature inventory

All 8 phases of the 1:1 port have shipped (see [CHANGELOG.md](./CHANGELOG.md)):

- **Phase 1** — 3-hearts/3-food start, basal metabolism, rain hunger penalty, starvation weakness, leaf-stick foraging
- **Phase 2** — 50 tool items (10 families × 5 materials), 4 ores, raw chunks + ingots, tier-gated mining
- **Phase 3** — 4-tier furnace hierarchy (clay → sandstone → obsidian → netherrack) with smelting gate tags
- **Phase 4** — 10 hostile mobs with custom AI, BiomeModifier-driven spawn weights, friendly-animal hunger
- **Phase 5** — Onion crop with blight system, manure, rain crop growth, rain fishing bonus, cold-biome hunger
- **Phase 6** — 7 enchantments (5 data-driven, 2 Java-backed) + iron strongbox (player-locked metal chest)
- **Phase 7** — 12-step survival tree advancements + 5 lore books with Avernite-spirit prose
- **Phase 8** — Configuration / FAQ / Migration / Extensions wiki articles, recipe-rendering script, ModTags consolidation

Total: **35 advancements**, **52 items**, **9 blocks**, **10 entity types**, **7 enchantments**, **15 game-bus event handlers** — all behind 100% locale parity (EN/FR/DE/ES/IT).

## Beyond the 1:1 port

See [docs/EXTENSIONS.md](./docs/EXTENSIONS.md) and the wiki [extensions roadmap](./wiki/src/content/docs/en/reference/extensions.md). The base mod stays faithful; new content lives in a separate `mitemc-extended` repo when work begins.

## Building

```bash
cd mod && gradle wrapper && ./gradlew runClient   # Java 21 + Gradle once
cd wiki && pnpm install && pnpm dev               # http://localhost:4321
node scripts/sync-locales.mjs                     # CI parity check (currently 0 gaps)
node scripts/render-recipes.mjs                   # markdown table of all recipes
```

## Status

Pre-1.0. All 8 phases logically complete; the **1.0.0** tag will land when the mod is validated against an actual NeoForge 26.1 build (current PROGRESS notes flag a few API signatures to verify on first compile).

## License

GPL-3.0, matching the rest of the modern MITE community ecosystem (MITE Renewed, MITE-RB-2025).
Original MITE design © Avernite. Port respects original intent — see [docs/CREDITS.md](./docs/CREDITS.md).

## Contributing translations

The wiki and mod share an i18n pipeline. See [wiki/CONTRIBUTING-TRANSLATIONS.md](./wiki/CONTRIBUTING-TRANSLATIONS.md).

# MITEMC Roadmap

This is the master plan. Every phase has a definition-of-done; we don't move on until it's met.

## Guiding principles

1. **Faithfulness first, polish second.** The original R196 behavior is canonical. If a modern API can't reproduce it exactly, we Mixin into vanilla rather than approximate.
2. **Data-driven where possible.** Recipes, ore tiers, mob loot, biomes — all in datapack JSON, so the wiki and mod stay in lock-step.
3. **Wiki & mod ship together.** Each phase ends with corresponding wiki articles in all 5 languages. No orphan features.
4. **i18n is not optional.** Every user-visible string goes through `lang/<locale>.json`. No hardcoded strings ever.
5. **Reproducible builds.** Gradle wrapper committed, dependencies pinned. Anyone can `./gradlew build` and get the same artifact.

---

## Phase 0 — Foundations *(current session)*

**Goal:** repo scaffolding, build system green, "hello world" mod loads on MC 26.1, Starlight site builds with 5 locales.

- [x] Repo init, top-level docs (README, ROADMAP, PROGRESS, CREDITS)
- [x] NeoForge Gradle skeleton, `mitemc` mod ID, registries package layout
- [x] Mixin config wired up
- [x] Starlight wiki with `en/fr/de/es/it` locales, common sidebar
- [x] Mod ↔ wiki shared glossary (translation keys aligned)
- [ ] CI: GitHub Actions to build mod + wiki on PR

**DoD:** `./gradlew runClient` boots MC 26.1 with the mod present. `pnpm --filter wiki build` produces 5 locale trees.

## Phase 1 — Core survival rebalance

**Goal:** the iconic "you start with 3 hearts, 3 food, and a stick" feeling.

- Player stats: max health = 3 hearts, max hunger = 3 (10 internal), gain +1 of each per 5 XP levels (cap at vanilla 10)
- Basal metabolism: hunger ticks while idle (configurable rate)
- Starvation weakness: cannot place/break blocks, slow movement, when food < 1
- Rain accelerates hunger (and improves fishing — Phase 5)
- Slowed natural regeneration
- Sticks drop from leaves and spawn near oak trunks (early-game flint pickaxe path)
- Tool requirement: vanilla stone/wood/log block-break gating tightened (no bare hands)

**Data:** advancements `mitemc:phase1/*`, config `phase1.toml`.

**DoD:** new world, you wake up with 3 hearts, can punch leaves to find sticks, can knap flint into a hatchet, can chop a tree.

## Phase 2 — Tools, weapons, materials ✅ *(shipped Session 2, 2026-05-07)*

**Goal:** rebuild MITE's expanded tool+weapon arsenal and material identity.

- New tool types: cudgel, club, hatchet, knife, dagger, war hammer, battle axe, mattock, scythe
- New weapon balance: damage scaling per material per tool type (matrix-driven, datapack)
- Tool durability scales with broken-block hardness (Mixin into `Block#getDestroySpeed` neighborhood)
- Tool-tier mining gates: copper > flint > stone for early ores
- Materials: copper, silver, mithril, adamantium added with full progression
- Crafting: time-based recipes (Mixin into crafting completion: must hold for N ticks scaled by recipe complexity)

**DoD:** every recipe in MITE R196 reachable, durability behavior matches.

## Phase 3 — Furnace hierarchy & ore processing ✅ *(shipped Session 3, 2026-05-07)*

- Clay oven, sandstone oven (cooking + low-tier smelting)
- Stone furnace (vanilla; lesser metals only)
- Obsidian furnace (lava-fueled, mithril-capable)
- Netherrack furnace (blaze-rod fueled, adamantium-capable)
- Smelting recipe gating: tier check at recipe lookup
- Fuel system: fuel quality matters (heat capacity per fuel)

**DoD:** the full smelting chain reproduces R196 outputs and timings.

## Phase 4 — Mobs & combat AI ✅ *(shipped Session 4, 2026-05-07)*

- 10 new hostile entities: dire wolf, wood spider, ghoul, wight, shadow, invisible stalker, hellhound, demon spider, infernal creeper, fire elemental
- Depth-gated spawning (rare → common with depth)
- Persistent aggro on visible target
- Extended detection radius
- Friendly animal needs: hunger/thirst/seek (decay model)

**DoD:** spelunking past Y=0 produces MITE-grade dread.

## Phase 5 — Agriculture, weather, environment ✅ *(shipped Session 5, 2026-05-08)*

- New crops: onion + crop blight mechanic
- Manure as fertilizer
- Weather effects: rain → +hunger, +fishing yield, accelerated crop growth (with blight risk)
- Day/night temperature on hunger (cold accelerates basal rate)

**DoD:** a full in-game year is survivable but punishing.

## Phase 6 — Enchantments, magic, mythic age ✅ *(shipped Session 6, 2026-05-08)*

- 7 MITE enchantments: Speed, Stun, Fortune, Regeneration, Fertility, Tree Felling, Vampiric
- Enchantment cost re-balance for new XP curve
- Mythic-tier items (adamantium-only enchants, set bonuses)
- Strongbox (player-locked metal chest) for multiplayer

## Phase 7 — Achievements, narrative, polish ✅ *(shipped Session 7, 2026-05-08)*

- 12 new advancements forming a survival progression tree
- In-game lore journals (developer notes from Avernite preserved + translated)
- Sound design, particle polish
- Performance pass (profiler-guided)

## Phase 8 — Wiki completion + extension content ✅ *(shipped Session 8, 2026-05-08)*

- Wiki: 100% feature coverage, all 5 locales at parity, illustrations and recipe diagrams autogenerated from datapack
- Post-1:1 extensions plan formalized in [docs/EXTENSIONS.md](./docs/EXTENSIONS.md)

---

## Out-of-scope for the 1:1 port

These are good ideas, but they go in a successor (`mitemc-extended`) once the 1:1 is shipped:

- New dimensions beyond Nether/End
- Built-in quest system
- Skill tree UI

## Per-phase wiki obligations

Each phase ends with corresponding wiki sections written in **English first**, then translated to FR/DE/ES/IT. PRs that add a feature without its wiki page are blocked.

| Phase | Wiki sections delivered                                              |
|-------|----------------------------------------------------------------------|
| 1     | Survival Basics, Health & Hunger, Foraging, Tool Tiers (intro)       |
| 2     | Tools & Weapons reference, Material Identity, Crafting Time          |
| 3     | Smelting Chain, Furnaces, Fuel Quality                               |
| 4     | Bestiary, Mob Mechanics, Animal Husbandry                            |
| 5     | Agriculture, Weather, Environment                                    |
| 6     | Enchantments, Mythic Tier, Strongboxes                               |
| 7     | Advancements Tree, Lore                                              |
| 8     | Indices, search, contribution guide finalization                     |

## Translation policy

- **Source of truth:** English (`en`).
- **Sync tooling:** `scripts/sync-locales.mjs` flags missing keys and stale translations.
- **Style guide:** `wiki/CONTRIBUTING-TRANSLATIONS.md` per-locale (tu/vous, formality, metric units, etc.).
- **Names:** mod IDs and item registry IDs stay English; only display names translate.

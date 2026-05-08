# MITEMC Changelog

User-facing summary of every shipped phase. For raw work logs see [PROGRESS.md](./PROGRESS.md).

The version number scheme is `0.<phase>.0` for in-progress 1:1 ports; `1.0.0` will land when all 8 phases pass against an actual NeoForge 26.1 build.

## 0.8.0 — Phase 8 (Wrap-up + extensions plan)

- Wiki: 4 new reference articles in 5 languages — `configuration.md`, `faq.md`, `extensions.md`, plus `guides/migration.md`.
- `scripts/render-recipes.mjs` — markdown table generator from JSON recipes (also emits `--json` for automation).
- `ModTags` central tag-registry class — one place to find every MITEMC `TagKey<Block>`, `TagKey<Item>`, `TagKey<Enchantment>`.
- `docs/EXTENSIONS.md` — formal post-1:1 plan (Tier 1 polish, Tier 2 content, Tier 3 speculative).
- `CHANGELOG.md` — this file.
- ROADMAP closed.

## 0.7.0 — Phase 7 (Achievements, narrative, polish)

- 12 cross-phase advancements forming the **survival tree**.
- 5 lore book items (`origins`, `stone_age`, `forge`, `deep`, `mythic`) with full Avernite-spirit prose in 5 languages.
- `LoreBookItem` displays translated title + body in chat on right-click.
- 5 lore book recipes (writable book + phase marker).
- `ModSounds` reserves 4 sound event IDs (`.ogg` files deferred).
- 43 new lang keys per locale.
- Wiki: `reference/advancements.md`, `reference/lore.md` × 5 languages.

## 0.6.0 — Phase 6 (Enchantments + strongbox)

- 7 MITEMC enchantments: 5 data-driven (Speed, Stun, Greater Fortune, Regeneration, Vampiric) + 2 Java-backed (Tree Felling, Fertility).
- `TreeFellingHandler` — BFS log chain-break capped at 96 logs.
- `FertilityHandler` — bonus random ticks scaling with hoe enchant level.
- Iron Strongbox — owner-locked 27-slot block (BaseEntityBlock + custom BE), hopper-blocked, OP override.
- Phase 6 advancement chain.
- 18 new lang keys per locale.
- Wiki: `reference/enchantments.md`, `reference/strongbox.md` × 5 languages.

## 0.5.0 — Phase 5 (Agriculture, weather, environment)

- `OnionCropBlock` with `BLIGHTED` boolean property (Phase 1 + custom logic).
- `BlightSpread` propagation to one mature neighbor per tick.
- `OnionItem` (food: 2 nutrition, 0.4 saturation), `ManureItem` (cures blight + bonemeal-like growth).
- 4 new game-bus handlers: `RainCropGrowthHandler`, `RainFishingHandler`, `TemperatureHungerHandler`, `AnimalManureHandler`.
- 7 new config tunables under `[phase5.agriculture]` and `[phase5.environment]`.
- Phase 5 advancement chain.
- 16 crop block models (8 ages × 2 blight states).
- 12 new lang keys per locale.
- Wiki: `reference/agriculture.md` × 5 languages.

## 0.4.0 — Phase 4 (Mobs & combat AI)

- 10 hostile entity classes: dire wolf, wood spider, ghoul, wight, shadow, invisible stalker, hellhound, demon spider, infernal creeper, fire elemental.
- `ModEntities` registry + `MobAttributeEvents` (mod bus) + `MitemcClient` (vanilla renderer placeholders).
- 2 NeoForge BiomeModifier JSONs for overworld and Nether spawn weights.
- `AnimalHungerHandler` — friendly animal starvation model.
- 10 entity loot tables.
- Phase 4 advancement chain (root, first_kill, all_ten challenge).
- 16 new lang keys per locale.
- Wiki: full bestiary rewrite × 5 languages.

## 0.3.0 — Phase 3 (Furnace hierarchy & ore processing)

- `HeatTier` enum (CLAY=0, SANDSTONE=1, OBSIDIAN=2, NETHERRACK=3).
- `MitemcFurnaceBlock` + `MitemcFurnaceBlockEntity` (extends `AbstractFurnaceBlockEntity`).
- 4 furnace blocks (clay oven, sandstone oven, obsidian furnace, netherrack furnace).
- Tag-based smelting tier gates (`requires_obsidian_furnace`, `requires_netherrack_furnace`).
- Adamantium ore now drops `raw_adamantium_chunk`; smelting recipes added.
- Phase 3 advancement chain.
- 17 new lang keys per locale.
- Wiki: `reference/furnaces.md` × 5 languages.

## 0.2.0 — Phase 2 (Tools, weapons, materials)

- `ModToolTiers` for 5 MITEMC tier levels (flint, copper, silver, mithril, adamantium).
- `ToolFamily` enum + `ToolFactory` — 10 tool families wired to vanilla parents (Sword/Axe/Pickaxe/Hoe/Shovel).
- `ModTools.bootstrap()` registers the full 5×10 = **50 tool items**.
- 4 ore blocks + 3 raw chunks + 4 ingots.
- Tag overlays for vanilla mineable/pickaxe and custom needs_X_tool gating.
- 6 smelting recipes + 20 crafting recipes (flint and copper variants of all 10 tool families).
- Phase 2 advancement chain.
- ~80 new lang keys per locale.
- Wiki: `reference/tools-and-weapons.md`, `reference/materials.md` × 5 languages.

## 0.1.0 — Phase 1 (Core survival rebalance)

- 5 game-bus event handlers: `PlayerStatsHandler`, `BasalMetabolismHandler`, `RainHungerHandler`, `StarvationWeaknessHandler`, `LeafStickHandler`.
- `Config.java` with 11 phase-1 tunables.
- 3 starting items + 4 placeholder ingots.
- 3 Phase 1 advancements.
- 5 item models, 5-language lang JSON.
- Wiki: 8 articles × 5 languages (home, getting-started, survival-basics, health-and-hunger, tool-tiers, foraging, bestiary placeholder, recipes placeholder).
- `scripts/sync-locales.mjs` enforcing 100% i18n parity in CI.

## 0.0.0 — Bootstrap

- Repo init, NeoForge mod skeleton (Gradle, `neoforge.mods.toml`, Mixin config).
- Astro Starlight wiki with 5 locales (EN/FR/DE/ES/IT) and Roadmap-mirroring sidebar.
- README, ROADMAP, PROGRESS, CREDITS, LICENSE (MIT).
- GitHub Actions CI (mod build + wiki build + locale parity check).

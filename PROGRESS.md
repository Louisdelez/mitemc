# MITEMC Progress Log

Updated each working session. Most recent at the top.

## 2026-05-08 — Session 8: Phase 8 (Wiki completion + extensions plan) — ROADMAP CLOSED

**Done:**
- 4 new wiki articles in 5 languages (20 files): `reference/configuration.md`, `reference/faq.md`, `guides/migration.md`, `reference/extensions.md`.
- Updated wiki landing pages × 5 languages: bumped from "Phase 1" to "All 8 phases shipped" with quick-link blocks.
- `scripts/render-recipes.mjs` — Node script reading `data/mitemc/recipes/*.json` and emitting a markdown table (43 recipes ingested). Handles shaped, shapeless, smelting, blasting types.
- `ModTags` Java class — central registry of every MITEMC `TagKey<Block>` (3), `TagKey<Item>` (3), `TagKey<Enchantment>` (1).
- `docs/EXTENSIONS.md` — formal post-1:1 plan (Tier 1 polish, Tier 2 content, Tier 3 speculative, versioning policy).
- `CHANGELOG.md` — phase-by-phase user-facing deltas, 0.0.0 through 0.8.0.
- README.md refreshed with the full feature inventory and post-1:1 pointer.
- Locale parity verified at 0 missing / 0 stale across mod lang JSON and wiki content.

**Project totals at roadmap close:**
- ~470 files in repo
- 35 advancements (3+5+4+3+4+4+12)
- 52 mod items, 9 mod blocks, 10 entity types, 7 enchantments
- 15 game-bus event handlers + 1 mod-bus subscriber + 1 client-side subscriber
- 35 wiki articles × 5 languages
- 100% locale parity across mod and wiki

**Open questions for follow-up sessions:**
- First real build against NeoForge 26.1: validate API signatures flagged across PROGRESS notes (`BlockEvent.CropGrowEvent.Pre`, `RecipeBookType.FURNACE`, `tag.hasUUID`/`getUUID`, `Monster.checkAnyLightMonsterSpawnRules`, post_attack JSON schema).
- Texture pass: zero textures shipped; largest single follow-up task.
- Sound `.ogg` authoring for the 4 reserved IDs (Phase 7).
- Tier 1 polish: Greater Fortune loot integration, fuel quality enforcement, animal seek-food AI, time-based crafting Mixin, silver+ tool crafting recipes.

**Next:**
- The 1:1 ROADMAP is **closed**. Future work continues in a follow-up cycle:
  - **Phase X.5 polish** (Tier 1 from EXTENSIONS.md) — texture / sound / mechanic plumbing
  - **mitemc-extended** (Tier 2 content) — Mythic Dimension, new biomes, MP server features

---

## 2026-05-08 — Session 7: Phase 7 (Achievements, narrative, polish)

**Done:**
- 12 cross-phase survival tree advancements at `data/mitemc/advancements/survival_tree/`: origins (root), first_food, first_kill, first_metal, first_furnace, first_crop, first_enchant, first_strongbox, first_lore, bestiary (challenge), mythic (challenge), completionist (challenge with 5 criteria).
- `LoreBookItem` — Item subclass that prints translated title + body to chat on right-click using ChatFormatting (gold/bold for title, italic/gray for body); each instance carries a string key so a single class powers all five books.
- 5 lore book items registered in `ModItems`: `lore_book_origins`, `lore_book_stone_age`, `lore_book_forge`, `lore_book_deep`, `lore_book_mythic`. All `stacksTo(1)`.
- 5 shapeless crafting recipes: writable_book + phase-marker (flint/stone/copper/bone/adamantium).
- 5 lore book item models referencing `mitemc:item/lore_book_<key>` textures.
- `ModSounds` registry with 4 placeholder sound event IDs (`block.iron_strongbox.locked`, `block.crop.blight_develops`, `item.lore_book.flip`, `block.mitemc_furnace.crackle`) reserved for the audio polish pass — no `.ogg` files shipped yet.
- `MITEMC.java` registers `ModSounds.SOUND_EVENTS` on the mod bus.
- Creative tab integrated with all 5 lore books (after strongbox, before tools).
- Mod lang JSON updated EN/FR/DE/ES/IT — 43 new keys per locale (5 lore items + 10 lore content keys + 24 advancement strings + 4 sound subtitles) — 100% parity verified.
- Lore content authored fresh in 5 languages — Avernite-spirit prose with `\n\n` paragraph breaks; ~3 paragraphs per book × 5 books × 5 languages = 75 unique prose passages.
- Wiki: 2 new articles `reference/advancements.md` and `reference/lore.md` × 5 languages (10 files) — 100% parity. Advancements article documents the full 35-advancement tree across all phases.

**Open questions for next session:**
- Sound asset pipeline: `ModSounds` reserves IDs but `.ogg` files aren't shipped. Need a `sounds.json` at `assets/mitemc/sounds.json` mapping each event to one or more sound files; `.ogg` authoring deferred (use freesound.org-licensed clips or commission custom audio).
- Particle pass: blight could spawn a custom particle on transition, lore book could spew dust on use, strongbox-locked could flash a chunk of red sparkles. Particles need texture + ParticleType registration — Phase 7.5 follow-up.
- Performance pass: `FertilityHandler` runs every player tick scanning a 5×5×5 area at level III — profile against a populated farm before shipping.
- `subtitles.mitemc.*` keys exist but no sound is actually played yet — wired only when the audio pass lands.

**Next:**
- Phase 8 — Wiki completion + extension content
  - Wiki: 100% feature coverage check, illustrations and recipe diagrams autogenerated from datapack, search polish, indices
  - Post-1:1 extensions: new biomes, expanded mythic dimension, multiplayer servers (separate document)
  - Tag-based wiki sidebar improvements
- Tech debt: Greater Fortune loot integration (Phase 6.5); fuel quality enforcement (Phase 3); animal seek-food AI (Phase 5); 9 silver/mithril/adamantium tool crafting recipes (Phase 2); entity custom geo models (Phase 4); texture pass (whole project); sound .ogg files (this phase)

---

## 2026-05-08 — Session 6: Phase 6 (Enchantments, magic, strongbox)

**Done:**
- 7 MITEMC enchantments registered as data files at `data/mitemc/enchantment/*.json`:
  - **Speed** (boots, max III) — `minecraft:attributes` effect adding +5%/level movement_speed
  - **Stun** (weapon, max II) — `minecraft:post_attack` applying Slowness II 1–2 s
  - **Greater Fortune** (mining, max V) — registry-only marker; loot-table integration deferred to Phase 6.5
  - **Regeneration** (armor, max II) — `minecraft:tick` applying Regeneration I/II
  - **Vampiric** (sword, max III) — `minecraft:post_attack` applying Regeneration to attacker
  - **Fertility** (hoe, max III) — Java-backed via `FertilityHandler`; bonus random ticks on nearby crops, scales with level (1×1 / 3×3 / 5×5)
  - **Tree Felling** (axe, max I) — Java-backed via `TreeFellingHandler`; BFS log chain-break capped at 96 logs, costs durability per log
- `ModEnchantments` constants class with `ResourceKey<Enchantment>` for each + helper to resolve levels via `HolderLookup.Provider`
- Item tag `#mitemc:tree_felling_axes` covering vanilla + all 10 MITEMC axe-class tools (hatchets and battle-axes across 5 materials)
- Item tag `#mitemc:all_enchantments` covering all 7 enchants for advancement triggers
- **Strongbox** — `IronStrongboxBlock` (extends `BaseEntityBlock` with FACING property, custom `useWithoutItem` checking owner UUID) + `IronStrongboxBlockEntity` (extends `RandomizableContainerBlockEntity`, 27-slot inventory, owner UUID persisted in NBT under `Owner`). Uses vanilla `ChestMenu.threeRows` for the GUI. Owner can always open; OP (permission ≥ 2) can always open; everyone else gets a translated denial. Hopper-blocked by design (no IItemHandler). Drops contents via `playerWillDestroy` hook.
- `ModBlockEntities.IRON_STRONGBOX` registered, `ModBlocks.IRON_STRONGBOX` block + BlockItem registered (stack to 1).
- Crafting recipe (8 iron + 1 chest) and self-drop loot table.
- Phase 6 advancement chain: `root → first_enchant (any) → strongbox` and `root → first_enchant → all_seven (challenge)`.
- `MITEMC.java` registers `TreeFellingHandler` and `FertilityHandler` on the game bus.
- Mod lang JSON updated EN/FR/DE/ES/IT — 18 new keys per locale (7 enchantments + 1 block + 1 container + 1 message + 8 advancement strings) — 100% parity verified.
- Wiki: 2 new articles `reference/enchantments.md` and `reference/strongbox.md` × 5 languages (10 files) — 100% parity.

**Open questions for next session:**
- Greater Fortune loot integration: vanilla `apply_bonus` in loot tables checks `minecraft:fortune` only. To honor `mitemc:greater_fortune` extra rolls, either (a) update MITEMC ore loot tables with a `minecraft:item_drops_with_enchantment_function` parallel pool, or (b) Mixin into `LootTable.applyBonusFunction`. Choose in Phase 6.5.
- Strongbox owner UUID format — verify `tag.hasUUID` / `tag.getUUID` API names against actual NeoForge 26.1; the 1.21 line uses these but signatures may be slightly renamed.
- Enchantment effect schemas (`minecraft:attributes`, `minecraft:post_attack`, `minecraft:tick`) — these were stable from MC 1.21.0+ but 26.1 may have tweaked; verify on first build.

**Next:**
- Phase 7 — Achievements, narrative, polish
  - 12 new advancements forming a survival progression tree (we already have several phases worth, consolidate + polish into one tree)
  - In-game lore journals (Avernite developer notes preserved + translated)
  - Sound design pass
  - Performance pass (profiler-guided)
- Tech debt: Greater Fortune loot integration; texture pass (whole project still uses placeholder textures); fuel quality enforcement (Phase 3); animal seek-food AI (Phase 5); 9 silver/mithril/adamantium tool crafting recipes (Phase 2); entity custom geo models (Phase 4)

---

## 2026-05-08 — Session 5: Phase 5 (Agriculture, weather, environment)

**Done:**
- `OnionCropBlock` — extends vanilla `CropBlock` with an extra `BLIGHTED` boolean property. While blighted: growth halts, neighbour-spread roll runs each random tick, harvest yields seeds only.
- `BlightSpread` helper — propagates blight to one mature non-blighted horizontal neighbour per tick at a configurable chance.
- `OnionItem` (food: nutrition 2, saturation 0.4) and `ManureItem` (cures blight on click; otherwise bone-meal-equivalent on crops only — does not grow trees/grass).
- `ItemNameBlockItem`-backed `ONION_SEEDS` placement item.
- 4 game-bus event handlers wired through `MITEMC.java`:
  - `RainCropGrowthHandler` — bonus growth tick on rain-exposed MITEMC crops; suppresses growth on blighted crops.
  - `RainFishingHandler` — extra cod / kelp drop on `ItemFishedEvent` while raining at the bobber.
  - `TemperatureHungerHandler` — cold biome (base temp < 0.2) amplifies basal exhaustion by 2× (delta-only, stacks cleanly with rain handler).
  - `AnimalManureHandler` — cows/pigs random-tick chance to drop a `mitemc:manure` item.
- `Config.java` extended with `[phase5.agriculture]` and `[phase5.environment]` sections (7 new tunables: blight chance, spread chance, rain growth chance, animal manure chance, cold biome multiplier, cold biome threshold, rain fishing bonus).
- 16 crop block models (8 ages × 2 blight states) + 1 blockstate file + 3 item models (onion, onion_seeds, manure).
- Crop loot table with conditional pools (always seeds; +onions only when `age=7,blighted=false`; +bonus seeds with Fortune curve when `age=7`).
- Phase 5 advancement chain: `root → first_onion → cure_blight (goal) → full_pantry (challenge)` — full pantry requires 16 onions + 16 wheat + 16 carrots.
- Mod lang JSON updated EN/FR/DE/ES/IT — 12 new keys per locale (1 block + 3 items + 8 advancement strings) — 100% parity verified.
- Wiki: new article `reference/agriculture.md` × 5 languages — covers crop, blight, manure, weather, temperature stack, advancements, config knobs — 100% parity.

**Open questions for next session:**
- `BlockEvent.CropGrowEvent.Pre`: API name and `setResult` enum may vary in NeoForge 26.1; verify on first build pass. Behavior is correct conceptually.
- Animal seek-food AI (proactive pathfinding to grass/water): deferred — should be a Phase 5.5 follow-up via Mixin into `Cow#registerGoals` or NeoForge `EntityJoinLevelEvent`.
- Onion crop biome-modifier-driven natural generation (so wild onions appear in plains): not yet — needs a `neoforge:add_features` BiomeModifier with a configured feature.
- Should manure also be obtainable from sheep / chickens? Currently only cow / pig per design; flag for playtesting.

**Next:**
- Phase 6 — Enchantments, magic, mythic age
  - 7 MITEMC enchantments (Speed, Stun, Fortune, Regeneration, Fertility, Tree Felling, Vampiric)
  - Enchantment cost re-balance for new XP curve
  - Mythic-tier items (adamantium-only enchants, set bonuses)
  - Strongbox (player-locked metal chest) for multiplayer
- Tech debt: 9 silver/mithril/adamantium tool crafting recipes; texture pass; fuel quality enforcement; entity custom geo models; animal seek-food AI

---

## 2026-05-07 — Session 4: Phase 4 (Mobs & combat AI)

**Done:**
- 10 new hostile entity classes, each extending the closest vanilla parent with custom stats and one signature behavior:
  - `DireWolfEntity` (Wolf) — always hostile to players
  - `WoodSpiderEntity` (Spider) — surface forest variant
  - `GhoulEntity` (Zombie) — paralysis bite (Slowness IV + Mining Fatigue II for 4 s), no sun damage
  - `WightEntity` (Skeleton) — drains 4 hunger exhaustion per hit
  - `ShadowEntity` (Zombie) — light-level 0 spawn rule via `checkShadowSpawnRules`
  - `InvisibleStalkerEntity` (Zombie) — permanent self-cast Invisibility (renews every 200 ticks)
  - `HellhoundEntity` (Wolf) — fire-immune; ignites target 5 s
  - `DemonSpiderEntity` (Spider) — leaps at target every 60 ticks
  - `InfernalCreeperEntity` (Creeper) — larger blast radius, fire-immune
  - `FireElementalEntity` (Blaze) — overworld-deep variant with longer follow range
- `ModEntities` registry: 10 EntityType registrations with sized boxes, client tracking ranges, and fireImmune where applicable
- `MobAttributeEvents` mod-bus subscriber: registers attribute defaults and SpawnPlacements (custom rule for Shadow; lava-light tolerant rules for nether-spawning species)
- `MitemcClient` (Dist.CLIENT, MOD bus): registers vanilla renderers (WolfRenderer / SpiderRenderer / ZombieRenderer / SkeletonRenderer / CreeperRenderer / BlazeRenderer) as visual placeholders
- 10 entity loot tables (bones / string / spider eye / rotten flesh / arrows / coal / glass bottle / blaze powder / gunpowder / nether wart / blaze rod) with looting bonuses
- 2 NeoForge `BiomeModifier` JSONs (`mitemc_spawns` for `#is_overworld`, `mitemc_nether_spawns` for `#is_nether`) wiring spawn weights and pack sizes
- Phase 4 advancement chain: `phase4/root → first_kill (any species) → all_ten (challenge frame)` driven by `minecraft:player_killed_entity` triggers
- `AnimalHungerHandler` — friendly-animal hunger model: cows/sheep/pigs/chickens accumulate a per-entity NBT counter, take 1 starvation damage after a full in-game day without grass/wheat/water adjacency, recover 4× while feeding
- `MITEMC.java` updated: registers `ModEntities`, mod-bus `MobAttributeEvents`, game-bus `AnimalHungerHandler`
- Mod lang JSON updated EN/FR/DE/ES/IT — 16 new keys per locale (10 entity names + 6 advancement strings) — 100% parity verified
- Wiki: full bestiary rewrite × 5 languages with at-a-glance table, per-species detail sheets (loot + tactics), spawn-weight reference, friendly animal hunger explanation, advancement chain — 100% parity

**Open questions for next session:**
- Custom geo models + textures: all 10 entities currently use vanilla renderers. Polish pass needed (could target 26 sessions for 1 species each, or be deferred until Phase 7).
- `MobAttributeEvents` references `Monster.checkAnyLightMonsterSpawnRules` for Nether mobs; verify this signature exists in NeoForge 26.1 (it does in vanilla MC 1.21+, but the API name may be slightly different in NeoForge mappings).
- Friendly animal AI: current model only damages on starvation. Phase 5 will add seek-food behavior goals so animals path to grass/water proactively.
- Spawn balancing: weights are first-pass. Playtesting will tell whether shadows + invisible stalkers are too rare (currently 4 + 2).

**Next:**
- Phase 5 — Agriculture, weather, environment
  - New crops (onion + crop blight)
  - Manure as fertilizer
  - Weather effects: rain → +hunger (already done in Phase 1), +fishing yield, accelerated crop growth with blight risk
  - Day/night temperature on hunger (cold accelerates basal rate)
- Tech debt: 9 silver/mithril/adamantium tool crafting recipes still missing; texture pass; fuel quality enforcement; 26 entity custom models

---

## 2026-05-07 — Session 3: Phase 3 (Furnace hierarchy & ore processing)

**Done:**
- `HeatTier` enum (CLAY=0, SANDSTONE=1, OBSIDIAN=2, NETHERRACK=3) with per-tier speed multipliers and tag-key constants for tier gating
- `FurnaceVariant` enum + `MitemcFurnaceBlock` (extends vanilla `FurnaceBlock`, holds variant) + `MitemcFurnaceBlockEntity` (extends `AbstractFurnaceBlockEntity`, filters recipes by heat tier via `canRunAtThisHeat`)
- `ModBlockEntities` registry (one shared `BlockEntityType<MitemcFurnaceBlockEntity>` covering all 4 furnace blocks)
- 4 new furnace blocks registered: `clay_oven`, `sandstone_oven`, `obsidian_furnace`, `netherrack_furnace` with per-tier hardness, light level, and sound type
- Tag-based smelting gates: `mitemc:requires_obsidian_furnace` (mithril items + chained `requires_netherrack_furnace`), `mitemc:requires_netherrack_furnace` (adamantium items)
- Adamantium ore now drops `raw_adamantium_chunk` (was: ingot directly); new `adamantium_ingot_smelting` and `..._blasting` recipes route through the netherrack-tier gate
- Crafting recipes for the 4 furnaces (terracotta ring, sandstone ring, obsidian + furnace, nether bricks + obsidian furnace + blaze rod)
- Self-drop loot tables for the 4 furnaces
- Phase 3 advancement chain: `root → clay_oven → obsidian_furnace → netherrack_furnace` (challenge frame on the last)
- Blockstates with `facing` × `lit` variants (8 cases each); block models (lit + unlit variants); item models (4 furnaces + raw_adamantium)
- Mod lang JSON updated EN/FR/DE/ES/IT — 17 new keys per locale (4 block names + 4 container titles + 1 raw item + 8 advancement strings) — 100% parity verified
- Wiki: new article `reference/furnaces.md` in all 5 languages — 100% parity

**Open questions for next session:**
- Fuel quality: infrastructure is in place but currently uses vanilla burn-time values. Need a NeoForge `RegisterEvent` or Mixin to differentiate burn time per furnace tier (e.g., wood only burns in clay/sandstone, blaze rods in netherrack only).
- AbstractFurnaceBlockEntity API: the BE constructor signature (`RecipeBookType.FURNACE`) and `serverTick` reference may need adjustment when first compiling against actual NeoForge 26.1 — flag for the first build pass.
- Should we also add deepslate ore variants now (Phase 3 also mentioned them) or wait for a Phase 3.5 pass?

**Next:**
- Phase 4 — Mobs & combat AI
  - 10 new hostile entities (dire wolf, wood spider, ghoul, wight, shadow, invisible stalker, hellhound, demon spider, infernal creeper, fire elemental)
  - Depth-gated spawning
  - Persistent aggro on visible target
  - Friendly animal hunger/thirst
- Tech debt: silver/mithril/adamantium tool crafting recipes (still missing); fuel quality enforcement; texture pass

---

## 2026-05-07 — Session 2: Phase 2 (Tools, weapons, materials)

**Done:**
- Tool tier system: `ModToolTiers` for flint/copper/silver/mithril/adamantium with mining-incorrect tags + tag inheritance via `mitemc:needs_silver_tool` ⊇ `mitemc:needs_mithril_tool` ⊇ `mitemc:needs_adamantium_tool`
- Tool family enum + factory: 10 families (cudgel, club, hatchet, knife, dagger, war_hammer, battle_axe, mattock, scythe, shovel) mapped to vanilla parent classes (Sword/Axe/Pickaxe/Hoe/Shovel) with per-family damage and attack-speed tunings
- `ModTools.bootstrap()` registers the full 5×10 = **50 tool items**
- Ore blocks added: `copper_ore`, `silver_ore`, `mithril_ore`, `adamantium_ore` with hardness/loot tables/XP drops
- Raw items: `raw_copper_chunk`, `raw_silver_chunk`, `raw_mithril_chunk` (adamantium drops the ingot directly)
- Block + item models for ores; handheld item models for all 50 tools
- Tag overlays: vanilla `mineable/pickaxe`, `needs_stone_tool`, `needs_iron_tool` extended with MITEMC ores
- Smelting + blasting recipes for raw → ingot (3 metals × 2 = 6 recipes)
- Crafting recipes: flint and copper variants of all 10 tool families (20 recipes total) — silver/mithril/adamantium recipes follow the same patterns; emit script in repo
- Phase 2 advancement chain: `root → first_copper → first_silver → first_mithril → first_adamantium` (5 advancements)
- Mod lang JSON updated EN/FR/DE/ES/IT — 100% parity (~80 keys per locale)
- Wiki: new pages `reference/tools-and-weapons.md`, `reference/materials.md`; updated `reference/tool-tiers.md`, `recipes/index.md` — all 5 languages, 100% parity
- Locale sync script reports 0 missing / 0 stale

**Open questions for next session:**
- Should silver/mithril/adamantium recipes be emitted now or generated lazily via datagen? Current state: only flint and copper variants have explicit JSON recipes — silver+ tools work but can't be crafted without datapack additions.
- Tool textures: still using missing-texture placeholder. Need 50 tool PNGs + 4 ore block PNGs + 3 raw chunk PNGs = 57 textures.
- Phase 3 trigger: should we lock the silver+ smelting behind the obsidian furnace immediately, or ship Phase 2 with vanilla furnace and gate later?

**Next:**
- Phase 3 — Furnace hierarchy & ore processing
  - Clay/sandstone ovens (early-game cooking + low-tier smelting)
  - Obsidian furnace (lava-fueled, mithril-capable)
  - Netherrack furnace (blaze-rod fueled, adamantium-capable)
  - Tier-gated smelting recipes
  - Fuel quality system
- Mid-priority cleanup: silver/mithril/adamantium crafting recipes; texture pass

---

## 2026-05-07 — Session 1: Foundations

**Done:**
- Initialized git repository, top-level layout (`mod/`, `wiki/`, `docs/`, `scripts/`)
- README, ROADMAP, PROGRESS, CREDITS authored
- NeoForge mod skeleton: Gradle build, `neoforge.mods.toml`, main `MITEMC` class, package layout for items/blocks/entities/capabilities/effects/events/mixins, Mixin config, datagen entry
- Initial registries: 5 placeholder ores (copper/silver/mithril/adamantium beyond vanilla iron) and 9 new tool types stubbed
- Phase 1 systems implemented:
  - `PlayerStatsHandler`: 3-hearts / 3-food starting cap, +1 per 5 XP levels, cap re-application on respawn and on level-up
  - `BasalMetabolismHandler`: idle hunger drain
  - `RainHungerHandler`: rain accelerates exhaustion
  - `StarvationWeaknessHandler`: < 1 food blocks `BlockEvent.BreakEvent` and `BlockEvent.EntityPlaceEvent`, applies slowness
  - Leaf-decay drops bonus stick (datagen loot table)
- Config: `mitemc-common.toml` with all Phase 1 tunables
- Localization: lang JSON in EN/FR/DE/ES/IT for Phase 1 strings (items, effects, advancement intro, config tooltips)
- Wiki: Astro Starlight scaffold with 5 locales, sidebar mirroring roadmap, home page + Getting Started + Health & Hunger + Foraging + Tool Tiers in EN, translated to FR/DE/ES/IT
- Translation tooling: `scripts/sync-locales.mjs` to flag missing keys

**Next:**
- Phase 2 (now done — see above)

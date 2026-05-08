# Post-1:1 Extensions Plan

The 8-phase ROADMAP captures the **faithful port** of MITE R196. This document captures everything that comes after — features that go beyond what Avernite shipped.

These features will live in a separate `mitemc-extended` repository when work begins. The base `mitemc` mod will not absorb them; the design rule is "would Avernite have shipped this?" and if the answer requires more than one paragraph of justification, it lands here instead.

## Tier 1 — Quality polish (likely first)

These deliverables extend, complete, or polish the 1:1 phases without inventing new content.

### Mob visuals
- Custom geometric models (Geckolib-compatible or vanilla bedrock-style) for the 10 hostile mobs.
- Full texture pass (currently using vanilla renderer placeholders).
- Distinct sound events per species.

### Tool & block textures
- 50 tool item textures (handheld layer0).
- 4 ore textures × overworld + deepslate variants.
- 3 raw chunks + 4 ingot textures.
- 5 lore book textures (cover variants).

### Sound assets
- 4 reserved sound IDs need `.ogg` authoring + `assets/mitemc/sounds.json` mapping:
  - `block.iron_strongbox.locked`
  - `block.crop.blight_develops`
  - `item.lore_book.flip`
  - `block.mitemc_furnace.crackle`

### Particles
- `mitemc:blight_spore` — visible drift around blighted crops.
- `mitemc:lore_dust` — book-flip on right-click.
- `mitemc:strongbox_spark` — refusal flash on locked open attempt.

### Mechanic plumbing (deferred from phases)
- **Greater Fortune** loot integration (Phase 6.5 — extend MITEMC ore loot tables to honor `mitemc:greater_fortune`).
- **Fuel quality** enforcement (Phase 3.5 — Mixin/event so wood/coal/lava/blaze gate furnace tier).
- **Animal seek-food AI** (Phase 5.5 — Mixin into Cow/Sheep/Pig goal registration).
- **Time-based crafting** (Phase 2.5 — Mixin into crafting completion).
- **Silver/mithril/adamantium tool recipes** (Phase 2 follow-up — currently only flint and copper recipe JSONs ship).

## Tier 2 — Content extensions

True new content beyond MITE R196.

### Mythic Dimension
- New dimension type accessible from a netherrack-furnace-crafted portal (analog of vanilla nether portal).
- Adamantium-tier mob ecology.
- Mythic-only structures (raid arenas, treasure vaults).
- Dimension-locked enchantments and items.

### Biome expansions
- **Cursed Forest** — overworld biome with elevated blight chance and stronger wood spider spawns.
- **Glacial Wastes** — extreme cold biome (base temperature < -0.5).
- **Mythic Caverns** — sub-Y=-32 cavern biome with adamantium ore generation and higher demon spider density.

### Multiplayer features
- **Mithril Strongbox** — explosion immunity, dimension-tracking, owner-warning on cross-dimension move.
- **Adamantium Strongbox** — adds anti-creative-break.
- **Player-bound enchantments** — UUID-locked, can't be PVP-stripped.
- **Server commands** — `/mitemc reset_player <uuid>`, `/mitemc grant_lore_book all <player>`, `/mitemc spawn_phase <n>`.

## Tier 3 — Speculative / Long-term

Discussed but not greenlit.

- **Quest journal UI** — would compete with vanilla advancements; rejected on principle.
- **Skill tree** — MITE's progression is already material/enchantment based; rejected.
- **NPC traders for adamantium** — needs significant world-gen work; deferred indefinitely.

## Versioning

The base mod (`mitemc`) versions per-phase. Extensions ship under `mitemc-extended` with its own version line, depending on `mitemc` ≥ 1.0.0.

| Mod jar              | Minimum target   |
|----------------------|------------------|
| `mitemc` 1.0.0       | All 8 phases validated against real NeoForge 26.1 build |
| `mitemc` 1.x.0       | Tier-1 polish per X.5 phases                            |
| `mitemc-extended` 0.1.0 | First Tier-2 content (one of: Mythic Dim, biomes, MP) |

## Working with the punch lists

Rolling tech-debt items live in `PROGRESS.md` under each session's "Open questions" + "Tech debt" sections. The day they get scheduled they migrate from PROGRESS to a tracked GitHub issue, with the corresponding tier label.

## See also

- [`ROADMAP.md`](../ROADMAP.md) — the closed 8-phase 1:1 plan.
- [`PROGRESS.md`](../PROGRESS.md) — live work log.
- [`CHANGELOG.md`](../CHANGELOG.md) — phase-by-phase deltas.

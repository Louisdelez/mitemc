---
title: Bestiary
description: New creatures introduced by MITEMC.
sidebar:
  order: 1
---

Phase 4 ships **10 new hostile species**. Each is a vanilla-base subclass with distinct stats and a single signature behavior; full custom geo models and textures arrive in a polish pass.

## At a glance

| Species             | HP | ATK | Spawn          | Signature                                |
|---------------------|---:|----:|----------------|------------------------------------------|
| Dire Wolf           | 20 |  6  | Overworld surface | Always hostile to players; pack of 2-4 |
| Wood Spider         | 14 |  3  | Forest biomes  | Climbs walls; very fast                  |
| Ghoul               | 24 |  4  | Cave layers    | Bite applies Slowness IV + Mining Fatigue II for 4 s |
| Wight               | 18 |  4  | Underground    | Hits drain 4 hunger exhaustion           |
| Shadow              | 16 |  5  | Light level 0  | Spawns *only* in absolute darkness       |
| Invisible Stalker   | 18 |  5.5| Cave layers    | Permanent self-cast Invisibility         |
| Hellhound           | 24 |  7  | Nether         | Fire-immune; sets target on fire 5 s     |
| Demon Spider        | 20 |  5  | Deep caves     | Leaps at target every 3 s                |
| Infernal Creeper    | 24 |  —  | Nether         | Bigger blast; fire-immune                |
| Fire Elemental      | 24 |  6  | Nether-like caves | Long-range fire; tougher than blaze   |

## Detailed entries

### Dire Wolf — `mitemc:dire_wolf`

Larger, meaner cousin of the vanilla wolf. **Always hostile** to players (overrides the tameable behavior of `Wolf`). Spawns at twilight in overworld biomes, generally in packs.

- **Loot:** 1–2 bones.
- **Tactic:** Hatchet+ in hand, fight on high ground; their packs target the lowest-HP victim.

### Wood Spider — `mitemc:wood_spider`

Forest-biome surface variant of the cave spider. Slightly bigger than vanilla, no poison bite — but very fast on tree canopies.

- **Loot:** 0–2 string, 0–1 spider eye.
- **Tactic:** A flint dagger keeps up with their attack speed; aim to break line-of-sight in undergrowth.

### Ghoul — `mitemc:ghoul`

Cave-dwelling zombie variant. The bite applies **Slowness IV + Mining Fatigue II** for 4 seconds — a paralysis effect that locks you out of mining away to safety.

- **Loot:** 0–3 rotten flesh, 0–1 bone.
- **Tactic:** Don't fight melee in tunnels. War hammer + retreat path mandatory.

### Wight — `mitemc:wight`

Undead skeletal variant. **Hits drain 4 hunger exhaustion** from players — bring food to a fight, or starve into the Starvation Weakness state mid-combat.

- **Loot:** 0–3 bone, 0–2 arrows.
- **Tactic:** Carry stew or steak; finish quickly.

### Shadow — `mitemc:shadow`

Spawns **only at light level 0**. Never burns in sun (it stays below ground anyway).

- **Loot:** 0–2 rotten flesh, 0–1 coal.
- **Tactic:** Place a single torch and the entire spawn radius dies. Light is the answer.

### Invisible Stalker — `mitemc:invisible_stalker`

Permanent self-cast Invisibility (re-applied every 200 ticks). You'll hear it before you see it.

- **Loot:** 0–2 rotten flesh, 0–1 glass bottle.
- **Tactic:** Listen for footsteps; splash potion of Glowing flushes them out.

### Hellhound — `mitemc:hellhound`

Nether-tier dire wolf. Fire-immune; **hits ignite the target for 5 s**. Packs of 1–3.

- **Loot:** 1–2 bone, 0–1 blaze powder.
- **Tactic:** Fire Resistance potion before entering Nether fortresses.

### Demon Spider — `mitemc:demon_spider`

Deep-cave variant. Periodically **leaps at its target** with high vertical velocity. Will reach you on ledges you thought were safe.

- **Loot:** 0–2 string, 0–2 spider eye.
- **Tactic:** Open arenas only; never fight on a 1-block ledge.

### Infernal Creeper — `mitemc:infernal_creeper`

Nether-spawning creeper variant. **Larger blast radius** (~5 vs vanilla's 3), fire-immune, modest fall resistance.

- **Loot:** 1–3 gunpowder, 0–1 nether wart.
- **Tactic:** Same as a creeper, but treat the safe distance as 1.6× larger.

### Fire Elemental — `mitemc:fire_elemental`

Overworld-deep blaze cousin. Spawns in cave layers below Y=0 instead of the Nether, with slightly more health and a 32-block follow range.

- **Loot:** 1–2 blaze rods.
- **Tactic:** Bow + Fire Protection armor. Don't melee unless you're geared up.

## Spawn weights

| Biome class           | Spawners                                                          |
|-----------------------|-------------------------------------------------------------------|
| `#minecraft:is_overworld` | Dire Wolf 8, Wood Spider 6, Ghoul 12, Wight 10, Shadow 4, Invisible Stalker 2, Demon Spider 5, Fire Elemental 3 |
| `#minecraft:is_nether`    | Hellhound 12, Infernal Creeper 8                              |

Weights are NeoForge BiomeModifier `add_spawns` entries — easy to override via datapack.

## Friendly animal hunger

Phase 4 also introduces a **friendly animal hunger** mechanic for cows, sheep, pigs, and chickens:

- Each tracked animal accumulates a hunger counter while not adjacent to grass / wheat / water.
- After a full in-game day without food, the animal takes 1 starvation damage.
- Counter resets when the animal touches food again, and recovers 4× faster while feeding.
- Tracked via persistent NBT — survives chunk unload.

Plan your farms accordingly: animals in dirt-floor pens will starve. Phase 5 will introduce explicit feeding mechanics, manure, and thirst on top of this.

## Phase 4 advancement chain

```
phase4/root  →  first_kill  →  all_ten  (challenge)
```

`first_kill` triggers on the first MITEMC-species kill. `all_ten` requires one of every species — the Bestiary completionist trophy.

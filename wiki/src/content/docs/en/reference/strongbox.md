---
title: Strongbox
description: Player-locked metal chest for multiplayer.
sidebar:
  order: 9
---

A **strongbox** is a chest that only its owner can open. Designed for multiplayer servers where shared bases need private storage that neither hoppers nor other players can siphon.

## Iron Strongbox — `mitemc:iron_strongbox`

| Property         | Value                            |
|------------------|----------------------------------|
| Storage          | 27 slots (single-chest layout)   |
| Hardness         | 5.0                              |
| Blast resistance | 1200 (obsidian-class)            |
| Required tool    | Pickaxe                          |
| Stack size       | 1 (when held as item)            |
| Owner            | UUID of the player who placed it |

## How it works

1. **Place** the strongbox. The placing player's UUID is bound to the BE on `setPlacedBy`.
2. **Right-click** to open. The block's `useWithoutItem` reads the BE's owner UUID:
   - If unset (legacy), opens for anyone.
   - If matches the player, opens.
   - If mismatches and the player **is not OP-level** (permission level ≥ 2), the open is denied with a translated message.
3. **Break** to retrieve. The contents drop on the ground (`playerWillDestroy` pre-hook), the block itself drops via the loot table.

OP override is intentional: server admins can open any strongbox. If you don't want this, override the loot/permissions through your server's permissions plugin.

## Crafting

```
I I I
I C I    (I = iron ingot, C = chest)
I I I
```

8 iron ingots in a ring around a vanilla chest.

## Hopper interaction

Strongbox does **not** implement any hopper-facing interfaces. Hoppers can't extract from or insert into a strongbox — blast-proof, hopper-proof.

## Multiplayer-friendly notes

- Owner UUID persists across server restarts (saved in NBT under key `Owner`).
- If the owner's account changes UUID (rare, but possible with offline-mode servers re-keying), the strongbox effectively becomes orphaned — break it open with admin tools.
- Strongboxes are **not** pickup-blocked by the placer — anyone can break it. The contents drop on the ground; the strongbox item itself drops too. Treat them as physical safes that can be ripped from a wall.

## Future variants

The roadmap reserves room for higher-tier strongboxes once Phase 7 completes:

- **Mithril Strongbox** — explosion immunity + dimension-tracking (warns owner if moved across dimensions).
- **Adamantium Strongbox** — also resists creative-mode break.

These are not in Phase 6.

## Phase 6 advancement

`mitemc:phase6/strongbox` triggers when you have a strongbox in your inventory.

## See also

- [Enchantments](/en/reference/enchantments/) — the other Phase 6 system.
- [Tools & Weapons](/en/reference/tools-and-weapons/) — pickaxe-class needed to break it.

---
title: Tool Tiers
description: Which tool can mine what.
sidebar:
  order: 2
---

## The chain

```
hands → flint → copper → iron → silver → mithril → adamantium
```

Each tier mines its own ore and one tier below. Vanilla iron sits between MITEMC's copper and silver and bridges naturally.

## Block → required tier

| Block                  | Required tier | Notes                                         |
|------------------------|---------------|-----------------------------------------------|
| Wood (logs)            | hatchet+      | No bare-hand log breaks                       |
| Leaves                 | none          | Punch freely; chance to drop a stick          |
| Stone                  | flint+        | Pick or war hammer                            |
| Coal ore               | flint+        |                                               |
| Vanilla iron ore       | flint+        | Allowed; copper recommended for full yield    |
| `mitemc:copper_ore`    | flint+        | Drops `raw_copper_chunk`                      |
| `mitemc:silver_ore`    | copper+       | **Stone tools cannot mine silver**            |
| `mitemc:mithril_ore`   | silver+       |                                               |
| `mitemc:adamantium_ore`| mithril+      | And only obsidian-furnace smelt for the ingot |

## Tool families

MITEMC ships **10 tool families** beyond the vanilla pick/axe/shovel/sword/hoe:

- Cudgel, club — blunt weapons (knockback)
- Hatchet, battle axe — wood + chopping (axe-class)
- Knife, dagger — fast melee, harvest plants
- War hammer — stone + heavy melee (pickaxe-class)
- Mattock — combo dig (pickaxe-class)
- Scythe — area harvest (hoe-class)
- Shovel — vanilla-style digging

For the full damage / attack-speed / mining-gate matrix see the [Tools & Weapons reference](/en/reference/tools-and-weapons/).

## Phase 2 advancement chain

```
phase2/root  →  first_copper  →  first_silver  →  first_mithril  →  first_adamantium
```

Each step displays as a toast and unlocks the next. `first_adamantium` is a challenge-frame advancement (gold border).

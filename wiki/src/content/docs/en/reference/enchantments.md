---
title: Enchantments
description: The seven MITEMC enchantments — effects, items, and level curves.
sidebar:
  order: 8
---

Phase 6 ships **7 enchantments** modeled after Avernite's MITE R196 list. Five are pure data-driven (JSON enchantment definitions); two require Java event handlers because their behavior is inherently world-altering.

## Quick reference

| Enchantment        | Slot      | Items                              | Max | Trigger                     |
|--------------------|-----------|------------------------------------|----:|-----------------------------|
| Haste              | feet      | `#enchantable/foot_armor`          | III | Equipped (passive attribute)|
| Stun               | mainhand  | `#enchantable/weapon`              | II  | Post-attack                 |
| Greater Fortune    | mainhand  | `#enchantable/mining`              | V   | On block break (loot bonus) |
| Regeneration       | any       | `#enchantable/armor`               | II  | Tick (passive)              |
| Fertility          | mainhand  | `#enchantable/farm_equipment` (hoe)| III | Tick while held             |
| Tree Felling       | mainhand  | `#mitemc:tree_felling_axes`        | I   | On log break                |
| Vampiric           | mainhand  | `#enchantable/sword`               | III | Post-attack                 |

## Detailed entries

### Haste — `mitemc:speed`

Boots-only. Adds **+5 % movement speed per level** as an `add_multiplied_total` attribute modifier. Stacks normally with Soul Speed and potion effects.

| Level | Speed bonus |
|-------|------------:|
| I     | +5 %        |
| II    | +10 %       |
| III   | +15 %       |

### Stun — `mitemc:stun`

Weapon. On hit, applies **Slowness II** to the victim:
- Level I: 1–2 seconds
- Level II: 1.5–3 seconds

Direct hits only; thrown projectiles don't trigger it.

### Greater Fortune — `mitemc:greater_fortune`

Pickaxe-class (mining tools). MITEMC-flavored Fortune that goes up to **V** instead of vanilla's III. Mutually exclusive with vanilla Fortune (`exclusive_set: #minecraft:exclusive_set/mining`).

> **Phase 6 status:** the enchantment exists and is rollable. Loot-table integration to actually grant the extra-yield curve is deferred to a Phase 6.5 pass — mark this in expectations until that lands.

### Regeneration — `mitemc:regeneration`

Armor. Tick effect: applies **Regeneration** every 5 ticks (a quarter second) at the level baked in:
- Level I: Regeneration I
- Level II: Regeneration II

Stacks across armor pieces by taking the highest level — wearing the same enchant on multiple pieces does *not* compound, by vanilla rules.

### Fertility — `mitemc:fertility`

Hoe (`#enchantable/farm_equipment`). While held in the main hand, surrounding crops within a small radius receive **bonus random ticks** every server-second:

| Level | Radius (cells) | Bonus ticks / s |
|------:|---------------:|----------------:|
| I     | 1×1×1          | 1               |
| II    | 3×1×3          | 2               |
| III   | 5×1×5          | 4               |

A Fertility III hoe held while idling near a wheat farm is roughly equivalent to bone-mealing every minute — but free. Combine with Phase 5 manure for cured-blight-then-fast-grow loops.

### Tree Felling — `mitemc:tree_felling`

Axe-class only. Single level. On breaking a log block with this enchant in the main hand, the handler runs a BFS from the broken position and chain-breaks every connected log of the same type, capped at **96 logs** for safety. Each felled log:

- Drops items at its position.
- Costs 1 durability on the axe.
- Stops the chain if the axe breaks.

The BFS uses 26-direction neighbours so diagonal log placements (jungle, dark oak) are handled.

### Vampiric — `mitemc:vampiric`

Sword. On direct hit, the **attacker** gains a brief Regeneration:
- Level I: Regen I, 1–2 sec
- Level II: Regen II, 1–3 sec
- Level III: Regen III, 1–4 sec

Doesn't proc on indirect damage (kill aura, thorns chains).

## Anvil costs

All MITEMC enchantments have higher anvil costs than vanilla equivalents — combining a Vampiric III sword with a fresh sword costs **8 anvil levels**, Greater Fortune V costs **16**. Plan your enchant economy.

## Implementation notes

- **JSON:** definitions live at `data/mitemc/enchantment/*.json`. The five data-driven ones use vanilla effect components (`minecraft:attributes`, `minecraft:post_attack`, `minecraft:tick`).
- **Java:** Tree Felling and Fertility are wired through `TreeFellingHandler` (game bus, `BlockEvent.BreakEvent`) and `FertilityHandler` (game bus, `PlayerTickEvent.Post`). Both look up the level via `ModEnchantments.mainHandLevel(...)`.
- **Tag:** `#mitemc:tree_felling_axes` lists every vanilla and MITEMC axe-class tool eligible for the Tree Felling enchantment.

## See also

- [Tools & Weapons](/en/reference/tools-and-weapons/) — what each enchant attaches to.
- [Strongbox](/en/reference/strongbox/) — the other Phase 6 deliverable.

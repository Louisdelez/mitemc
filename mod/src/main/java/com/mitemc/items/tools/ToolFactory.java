package com.mitemc.items.tools;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

/**
 * Factory that maps each MITEMC tool family × tier into a vanilla-compatible Item subclass.
 *
 * The original MITE has 9 weapon/tool families that don't have direct 1:1 vanilla equivalents:
 *
 * | MITE family    | Vanilla parent  | Damage scale | Speed scale | Notes                                  |
 * |----------------|-----------------|--------------|-------------|----------------------------------------|
 * | Cudgel         | SwordItem       | low (+1)     | -1.5 attack | Blunt, knockback emphasis              |
 * | Club           | SwordItem       | low+ (+2)    | -1.7 attack | Faster than cudgel, less knockback     |
 * | Hatchet        | AxeItem         | mid (+3)     | -3.0 attack | Small axe, faster                      |
 * | Knife          | SwordItem       | low (+1)     | -1.0 attack | Very fast, plant harvest               |
 * | Dagger         | SwordItem       | low+ (+2)    | -1.2 attack | Backstab feel; sneak bonus elsewhere   |
 * | War Hammer     | PickaxeItem     | high (+5)    | -3.4 attack | Heavy, mines stone                     |
 * | Battle Axe     | AxeItem         | high (+6)    | -3.5 attack | Slow, heavy strike                     |
 * | Mattock        | PickaxeItem     | mid (+3)     | -2.8 attack | Acts as both pick and shovel           |
 * | Scythe         | HoeItem         | mid (+2)     | -2.6 attack | Area plant harvest behavior in subclass|
 *
 * Tuning above is the spiritual descendant of MITE R196's matrix; precise numbers are
 * tunable per recipe via data components in datagen.
 */
public final class ToolFactory {

    public static Item cudgel(Tier tier)      { return new SwordItem(tier, properties(tier, 1.0f, -3.4f)); }
    public static Item club(Tier tier)        { return new SwordItem(tier, properties(tier, 2.0f, -3.2f)); }
    public static Item hatchet(Tier tier)     { return new AxeItem(tier,   properties(tier, 3.0f, -3.0f)); }
    public static Item knife(Tier tier)       { return new SwordItem(tier, properties(tier, 1.0f, -1.8f)); }
    public static Item dagger(Tier tier)      { return new SwordItem(tier, properties(tier, 2.0f, -1.6f)); }
    public static Item warHammer(Tier tier)   { return new PickaxeItem(tier, properties(tier, 5.0f, -3.4f)); }
    public static Item battleAxe(Tier tier)   { return new AxeItem(tier,   properties(tier, 6.0f, -3.5f)); }
    public static Item mattock(Tier tier)     { return new PickaxeItem(tier, properties(tier, 3.0f, -2.8f)); }
    public static Item scythe(Tier tier)      { return new HoeItem(tier,   properties(tier, 2.0f, -2.6f)); }
    public static Item shovel(Tier tier)      { return new ShovelItem(tier, properties(tier, 1.5f, -3.0f)); }

    private static Item.Properties properties(Tier tier, float damage, float speed) {
        return new Item.Properties().attributes(SwordItem.createAttributes(tier, (int) damage, speed));
    }

    private ToolFactory() {}
}

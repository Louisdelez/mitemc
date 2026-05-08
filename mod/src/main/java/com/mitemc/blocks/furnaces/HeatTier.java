package com.mitemc.blocks.furnaces;

import com.mitemc.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * MITE smelting heat tiers, ordered weakest → strongest.
 *
 * <pre>
 *   CLAY (0)        — clay oven, basic cooking + lesser metals
 *   SANDSTONE (1)   — slightly hotter; same recipes as CLAY
 *   OBSIDIAN (2)    — lava-fueled; can smelt mithril
 *   NETHERRACK (3)  — blaze-rod fueled; can smelt adamantium
 * </pre>
 *
 * The vanilla furnace sits at SANDSTONE-equivalent for our purposes — it is treated as if
 * it had {@code level == 1}, so it can run any recipe that doesn't require OBSIDIAN+.
 *
 * Each tier maps to a "requires" item tag. A recipe whose ingredient or result is in
 * {@code requires_obsidian_furnace} can only run in a furnace with {@code level >= 2}.
 */
public enum HeatTier {
    CLAY(0),
    SANDSTONE(1),
    OBSIDIAN(2),
    NETHERRACK(3);

    public static final TagKey<Item> REQUIRES_OBSIDIAN =
            TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "requires_obsidian_furnace"));
    public static final TagKey<Item> REQUIRES_NETHERRACK =
            TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "requires_netherrack_furnace"));

    public final int level;

    HeatTier(int level) {
        this.level = level;
    }

    /** Smelting speed multiplier for this tier vs. vanilla furnace. */
    public float speedMultiplier() {
        return switch (this) {
            case CLAY       -> 0.75f;  // slower than a vanilla furnace
            case SANDSTONE  -> 1.0f;   // matches vanilla
            case OBSIDIAN   -> 1.4f;   // hotter, faster
            case NETHERRACK -> 1.8f;   // hottest, fastest
        };
    }
}

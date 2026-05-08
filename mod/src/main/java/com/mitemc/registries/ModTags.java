package com.mitemc.registries;

import com.mitemc.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

/**
 * Consolidated central registry of every MITEMC tag key. Existing tag references in
 * {@link com.mitemc.items.tools.ModToolTiers} and {@link com.mitemc.blocks.furnaces.HeatTier}
 * keep their inline definitions for backward compatibility — this class duplicates them so
 * future contributors have one place to look.
 *
 * If you add a new MITEMC tag, add a constant here AND ship the matching JSON file at
 * {@code data/mitemc/tags/<kind>/<name>.json}.
 */
public final class ModTags {

    private ModTags() {}

    /** Block tags — used by tier gates and ore mining requirements. */
    public static final class Blocks {
        public static final TagKey<Block> NEEDS_SILVER_TOOL     = block("needs_silver_tool");
        public static final TagKey<Block> NEEDS_MITHRIL_TOOL    = block("needs_mithril_tool");
        public static final TagKey<Block> NEEDS_ADAMANTIUM_TOOL = block("needs_adamantium_tool");

        private static TagKey<Block> block(String path) {
            return TagKey.create(Registries.BLOCK, id(path));
        }
        private Blocks() {}
    }

    /** Item tags — heat-tier furnace gating, axe-class for tree felling, enchantment marker. */
    public static final class Items {
        public static final TagKey<Item> REQUIRES_OBSIDIAN_FURNACE   = item("requires_obsidian_furnace");
        public static final TagKey<Item> REQUIRES_NETHERRACK_FURNACE = item("requires_netherrack_furnace");
        public static final TagKey<Item> TREE_FELLING_AXES           = item("tree_felling_axes");

        private static TagKey<Item> item(String path) {
            return TagKey.create(Registries.ITEM, id(path));
        }
        private Items() {}
    }

    /** Enchantment tags — the all-mitemc-enchantments set used by Phase 6/7 advancements. */
    public static final class Enchantments {
        public static final TagKey<Enchantment> ALL_ENCHANTMENTS = ench("all_enchantments");

        private static TagKey<Enchantment> ench(String path) {
            return TagKey.create(Registries.ENCHANTMENT, id(path));
        }
        private Enchantments() {}
    }

    private static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
    }
}

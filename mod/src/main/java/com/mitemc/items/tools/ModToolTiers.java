package com.mitemc.items.tools;

import com.mitemc.Constants;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

/**
 * MITEMC tool tiers, ordered weakest → strongest:
 * flint → copper → iron (vanilla) → silver → mithril → adamantium
 *
 * Each tier defines:
 *  - {@code uses}     — base durability
 *  - {@code speed}    — mining speed multiplier
 *  - {@code damage}   — base attack damage bonus
 *  - {@code enchant}  — enchantability
 *  - {@code incorrect}— BlockTags for blocks this tier cannot mine
 *  - {@code repair}   — items that can repair tools of this tier (loose stub here, set in DataGen)
 *
 * The "incorrect blocks" list is the modern equivalent of mining-level gating: if the target block
 * carries the tag, the tier cannot harvest it. We define MITEMC-specific tags below.
 */
public final class ModToolTiers {

    public static final TagKey<Block> NEEDS_FLINT_TOOL =
            TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "needs_flint_tool"));
    public static final TagKey<Block> NEEDS_COPPER_TOOL =
            TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "needs_copper_tool"));
    public static final TagKey<Block> NEEDS_SILVER_TOOL =
            TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "needs_silver_tool"));
    public static final TagKey<Block> NEEDS_MITHRIL_TOOL =
            TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "needs_mithril_tool"));
    public static final TagKey<Block> NEEDS_ADAMANTIUM_TOOL =
            TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "needs_adamantium_tool"));

    /** Flint: starter tier, sub-stone strength. Cannot mine iron-tier+. */
    public static final Tier FLINT = new SimpleTier(
            BlockTags.INCORRECT_FOR_STONE_TOOL, // flint == roughly stone-tier mining capability
            30,    // uses
            3.0F,  // speed
            0.5F,  // damage bonus
            6,     // enchantability
            () -> Ingredient.EMPTY
    );

    /** Copper: bridge between flint and iron. Mines iron ore but not silver+. */
    public static final Tier COPPER = new SimpleTier(
            NEEDS_SILVER_TOOL,
            180,   // ~uses (between iron 250 and stone 131)
            5.0F,
            1.5F,
            12,
            () -> Ingredient.EMPTY
    );

    /** Silver: above iron, below mithril. */
    public static final Tier SILVER = new SimpleTier(
            NEEDS_MITHRIL_TOOL,
            400,
            7.0F,
            2.0F,
            16,
            () -> Ingredient.EMPTY
    );

    /** Mithril: lava-smelted, fast, high enchantability. */
    public static final Tier MITHRIL = new SimpleTier(
            NEEDS_ADAMANTIUM_TOOL,
            900,
            9.0F,
            3.0F,
            22,
            () -> Ingredient.EMPTY
    );

    /** Adamantium: top of MITE's tech tree. Nothing above. */
    public static final Tier ADAMANTIUM = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,  // sentinel: no MITEMC blocks should match this
            2200,
            12.0F,
            5.0F,
            10,    // adamantium is sturdy, not magical
            () -> Ingredient.EMPTY
    );

    private ModToolTiers() {}
}

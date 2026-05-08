package com.mitemc.blocks.furnaces;

public enum FurnaceVariant {
    CLAY_OVEN("clay_oven",                 HeatTier.CLAY),
    SANDSTONE_OVEN("sandstone_oven",       HeatTier.SANDSTONE),
    OBSIDIAN_FURNACE("obsidian_furnace",   HeatTier.OBSIDIAN),
    NETHERRACK_FURNACE("netherrack_furnace", HeatTier.NETHERRACK);

    public final String id;
    public final HeatTier tier;

    FurnaceVariant(String id, HeatTier tier) {
        this.id = id;
        this.tier = tier;
    }
}

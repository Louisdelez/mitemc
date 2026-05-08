package com.mitemc.items.tools;

import net.minecraft.world.item.Tier;

/**
 * MITEMC tool materials. The vanilla iron tier is reused via {@link net.minecraft.world.item.Tiers#IRON}
 * inside {@link ModTools}; we don't reify it here because its tools (iron_pickaxe etc.) already exist.
 */
public enum ToolMaterial {
    FLINT("flint",            ModToolTiers.FLINT),
    COPPER("copper",          ModToolTiers.COPPER),
    SILVER("silver",          ModToolTiers.SILVER),
    MITHRIL("mithril",        ModToolTiers.MITHRIL),
    ADAMANTIUM("adamantium",  ModToolTiers.ADAMANTIUM);

    public final String id;
    public final Tier tier;

    ToolMaterial(String id, Tier tier) {
        this.id = id;
        this.tier = tier;
    }
}

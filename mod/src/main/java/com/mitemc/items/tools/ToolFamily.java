package com.mitemc.items.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

import java.util.function.Function;

/**
 * The 10 MITEMC tool families (9 from MITE R196 plus shovel for ergonomics).
 * Each family exposes a builder that turns a tier into a concrete Item.
 */
public enum ToolFamily {
    CUDGEL("cudgel",         ToolFactory::cudgel),
    CLUB("club",             ToolFactory::club),
    HATCHET("hatchet",       ToolFactory::hatchet),
    KNIFE("knife",           ToolFactory::knife),
    DAGGER("dagger",         ToolFactory::dagger),
    WAR_HAMMER("war_hammer", ToolFactory::warHammer),
    BATTLE_AXE("battle_axe", ToolFactory::battleAxe),
    MATTOCK("mattock",       ToolFactory::mattock),
    SCYTHE("scythe",         ToolFactory::scythe),
    SHOVEL("shovel",         ToolFactory::shovel);

    public final String id;
    public final Function<Tier, Item> builder;

    ToolFamily(String id, Function<Tier, Item> builder) {
        this.id = id;
        this.builder = builder;
    }
}

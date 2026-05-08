package com.mitemc.registries;

import com.mitemc.items.tools.ToolFamily;
import com.mitemc.items.tools.ToolMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.EnumMap;
import java.util.Map;

/**
 * Registers the full Cartesian product of {@link ToolMaterial} × {@link ToolFamily}.
 *
 * Result: 5 materials × 10 families = 50 new tool items, IDs like
 *   mitemc:flint_hatchet, mitemc:copper_war_hammer, mitemc:adamantium_dagger.
 *
 * Lookups: {@code ModTools.get(material, family)}.
 *
 * Vanilla iron, gold, diamond and netherite tools coexist; MITEMC explicitly does not duplicate
 * those tiers for the vanilla tool families (pickaxe, axe, sword, shovel, hoe).
 */
public final class ModTools {

    private static final Map<ToolMaterial, Map<ToolFamily, DeferredHolder<Item, Item>>> TABLE =
            new EnumMap<>(ToolMaterial.class);

    public static void bootstrap() {
        for (ToolMaterial m : ToolMaterial.values()) {
            Map<ToolFamily, DeferredHolder<Item, Item>> row = new EnumMap<>(ToolFamily.class);
            TABLE.put(m, row);
            for (ToolFamily f : ToolFamily.values()) {
                String id = m.id + "_" + f.id;
                row.put(f, ModItems.ITEMS.register(id, () -> f.builder.apply(m.tier)));
            }
        }
    }

    public static DeferredHolder<Item, Item> get(ToolMaterial m, ToolFamily f) {
        return TABLE.get(m).get(f);
    }

    private ModTools() {}
}

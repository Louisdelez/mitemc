package com.mitemc.registries;

import com.mitemc.Constants;
import com.mitemc.items.tools.ToolFamily;
import com.mitemc.items.tools.ToolMaterial;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mitemc"))
                    .icon(() -> ModItems.FLINT_SHARD.get().getDefaultInstance())
                    .displayItems((params, output) -> {
                        // Phase 1
                        output.accept(ModItems.FLINT_SHARD.get());

                        // Phase 2 — raw + ingots
                        output.accept(ModItems.RAW_COPPER.get());
                        output.accept(ModItems.RAW_SILVER.get());
                        output.accept(ModItems.RAW_MITHRIL.get());
                        output.accept(ModItems.COPPER_INGOT.get());
                        output.accept(ModItems.SILVER_INGOT.get());
                        output.accept(ModItems.MITHRIL_INGOT.get());
                        output.accept(ModItems.ADAMANTIUM_INGOT.get());

                        // Phase 2 — ores
                        output.accept(ModBlocks.COPPER_ORE.get().asItem());
                        output.accept(ModBlocks.SILVER_ORE.get().asItem());
                        output.accept(ModBlocks.MITHRIL_ORE.get().asItem());
                        output.accept(ModBlocks.ADAMANTIUM_ORE.get().asItem());

                        // Phase 3 — furnaces
                        output.accept(ModBlocks.CLAY_OVEN.get().asItem());
                        output.accept(ModBlocks.SANDSTONE_OVEN.get().asItem());
                        output.accept(ModBlocks.OBSIDIAN_FURNACE.get().asItem());
                        output.accept(ModBlocks.NETHERRACK_FURNACE.get().asItem());

                        // Phase 5 — agriculture
                        output.accept(ModItems.ONION.get());
                        output.accept(ModItems.ONION_SEEDS.get());
                        output.accept(ModItems.MANURE.get());

                        // Phase 6 — strongbox
                        output.accept(ModBlocks.IRON_STRONGBOX.get().asItem());

                        // Phase 7 — lore books
                        output.accept(ModItems.LORE_BOOK_ORIGINS.get());
                        output.accept(ModItems.LORE_BOOK_STONE_AGE.get());
                        output.accept(ModItems.LORE_BOOK_FORGE.get());
                        output.accept(ModItems.LORE_BOOK_DEEP.get());
                        output.accept(ModItems.LORE_BOOK_MYTHIC.get());

                        // Phase 2 — tools (5 materials × 10 families)
                        for (ToolMaterial m : ToolMaterial.values()) {
                            for (ToolFamily f : ToolFamily.values()) {
                                output.accept(ModTools.get(m, f).get());
                            }
                        }
                    })
                    .build());

    private ModCreativeTabs() {}
}

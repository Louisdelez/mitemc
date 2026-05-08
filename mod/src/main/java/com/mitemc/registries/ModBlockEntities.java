package com.mitemc.registries;

import com.mitemc.Constants;
import com.mitemc.blocks.furnaces.MitemcFurnaceBlockEntity;
import com.mitemc.blocks.strongbox.IronStrongboxBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MitemcFurnaceBlockEntity>> MITEMC_FURNACE =
            BLOCK_ENTITIES.register("mitemc_furnace",
                    () -> BlockEntityType.Builder.of(
                            (pos, state) -> {
                                Block b = state.getBlock();
                                if (b instanceof com.mitemc.blocks.furnaces.MitemcFurnaceBlock mfb) {
                                    return new MitemcFurnaceBlockEntity(pos, state, mfb.getVariant());
                                }
                                // Fallback — shouldn't happen at runtime; registry is wired only to MitemcFurnaceBlock instances.
                                return new MitemcFurnaceBlockEntity(pos, state,
                                        com.mitemc.blocks.furnaces.FurnaceVariant.CLAY_OVEN);
                            },
                            ModBlocks.CLAY_OVEN.get(),
                            ModBlocks.SANDSTONE_OVEN.get(),
                            ModBlocks.OBSIDIAN_FURNACE.get(),
                            ModBlocks.NETHERRACK_FURNACE.get()
                    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IronStrongboxBlockEntity>> IRON_STRONGBOX =
            BLOCK_ENTITIES.register("iron_strongbox",
                    () -> BlockEntityType.Builder.of(IronStrongboxBlockEntity::new,
                            ModBlocks.IRON_STRONGBOX.get()).build(null));

    private ModBlockEntities() {}
}

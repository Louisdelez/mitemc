package com.mitemc.blocks.furnaces;

import com.mitemc.registries.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

/**
 * Common implementation for all four MITEMC furnace blocks. The heat tier is supplied per
 * block instance at registration; the BE reads it back via the variant association.
 */
public class MitemcFurnaceBlock extends FurnaceBlock {

    private final FurnaceVariant variant;

    public MitemcFurnaceBlock(FurnaceVariant variant, Properties properties) {
        super(properties);
        this.variant = variant;
    }

    public FurnaceVariant getVariant() {
        return variant;
    }

    public HeatTier getHeatTier() {
        return variant.tier;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MitemcFurnaceBlockEntity(pos, state, variant);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide
                ? null
                : createTickerHelper(type, ModBlockEntities.MITEMC_FURNACE.get(), MitemcFurnaceBlockEntity::serverTick);
    }
}

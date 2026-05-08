package com.mitemc.blocks.crops;

import com.mitemc.config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

/**
 * Blight propagation: a blighted crop has a small chance per random-tick to flip a neighbouring
 * (mature, non-blighted) crop block of the same type to BLIGHTED.
 */
public final class BlightSpread {

    private BlightSpread() {}

    public static void maybeSpread(ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextDouble() >= Config.BLIGHT_SPREAD_CHANCE.get()) return;

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            BlockPos neighbour = pos.relative(dir);
            BlockState n = level.getBlockState(neighbour);
            if (!(n.getBlock() instanceof OnionCropBlock crop)) continue;
            if (n.getValue(OnionCropBlock.BLIGHTED)) continue;
            if (n.getValue(OnionCropBlock.AGE) < crop.getMaxAge()) continue; // only mature crops blight

            level.setBlock(neighbour, n.setValue(OnionCropBlock.BLIGHTED, true), 2);
            return;
        }
    }

    /** Reflection-friendly access to "any blight property on a block". */
    public static BooleanProperty blightProperty() {
        return OnionCropBlock.BLIGHTED;
    }
}

package com.mitemc.blocks.crops;

import com.mitemc.config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.item.ItemStack;

/**
 * Onion crop. Adds the AGE_7 progression of vanilla {@link CropBlock} and a {@code BLIGHTED}
 * boolean property: while blighted, randomTick growth is suppressed and the crop drops nothing
 * useful unless cured by manure.
 *
 * Blight roll happens per random tick once the crop is mature, with chance configured in
 * {@link Config#CROP_BLIGHT_CHANCE}. Manure right-click clears the BLIGHTED flag (see
 * {@link com.mitemc.items.agriculture.ManureItem}).
 */
public class OnionCropBlock extends CropBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    public static final BooleanProperty BLIGHTED = BooleanProperty.create("blighted");

    public OnionCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(this.getAgeProperty(), 0)
                .setValue(BLIGHTED, false));
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(AGE, BLIGHTED);
    }

    @Override
    public ItemStack getCloneItemStack(net.minecraft.world.level.LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(com.mitemc.registries.ModItems.ONION_SEEDS);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Don't grow while blighted; instead roll for spread.
        if (state.getValue(BLIGHTED)) {
            BlightSpread.maybeSpread(level, pos, random);
            return;
        }

        // Mature crops can develop blight (random per random-tick).
        if (this.isMaxAge(state) && random.nextDouble() < Config.CROP_BLIGHT_CHANCE.get()) {
            level.setBlock(pos, state.setValue(BLIGHTED, true), 2);
            return;
        }

        super.randomTick(state, level, pos, random);
    }

    /** Helper used by manure right-click. */
    public static BlockState clearBlight(BlockState state) {
        return state.is(net.minecraft.tags.BlockTags.CROPS) && state.hasProperty(BLIGHTED)
                ? state.setValue(BLIGHTED, false)
                : state;
    }
}

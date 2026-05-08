package com.mitemc.events;

import com.mitemc.blocks.crops.OnionCropBlock;
import com.mitemc.config.Config;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

/**
 * Bonus crop growth tick during rain — listens to {@link BlockEvent.CropGrowEvent.Pre}, but the
 * cleaner pattern is to add a per-random-tick chance directly. We use a {@code Pre} hook to
 * accelerate a non-blighted crop one extra age when it would otherwise simply tick.
 *
 * Note: NeoForge sometimes refers to this event class in different sub-packages between versions.
 * The handler intentionally references the canonical {@code BlockEvent.CropGrowEvent.Pre} which
 * is present from MC 1.21+ NeoForge.
 */
public final class RainCropGrowthHandler {

    private RainCropGrowthHandler() {}

    @SubscribeEvent
    public static void onCropGrowPre(BlockEvent.CropGrowEvent.Pre event) {
        if (!(event.getLevel() instanceof net.minecraft.server.level.ServerLevel level)) return;
        BlockState state = event.getState();
        if (!(state.getBlock() instanceof OnionCropBlock)) return;
        if (state.getValue(OnionCropBlock.BLIGHTED)) {
            // Suppress vanilla's growth tick on blighted crops — defensive (the block already does this).
            event.setResult(BlockEvent.CropGrowEvent.Pre.Result.DENY);
            return;
        }

        if (level.isRaining() && level.canSeeSky(event.getPos())
                && level.random.nextDouble() < Config.RAIN_CROP_GROWTH_CHANCE.get()) {
            // Allow the tick AND advance one more age via post-event handling
            // (We rely on Result.DEFAULT to let vanilla grow; the bonus is applied here.)
            int age = state.getValue(OnionCropBlock.AGE);
            if (age < 7) {
                level.setBlock(event.getPos(), state.setValue(OnionCropBlock.AGE, age + 1), 2);
            }
        }
    }
}

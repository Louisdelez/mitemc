package com.mitemc.events;

import com.mitemc.config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

/**
 * Decaying or broken leaf blocks have a small chance to drop a vanilla stick. This is the
 * unlocking mechanic for the early-game flint pickaxe path: no wood pickaxe means you need
 * sticks before logs can be processed.
 */
public final class LeafStickHandler {

    private LeafStickHandler() {}

    @SubscribeEvent
    public static void onLeafBreak(BlockEvent.BreakEvent event) {
        if (!Config.STICKS_FROM_LEAVES.get()) return;
        BlockState state = event.getState();
        if (!(state.getBlock() instanceof LeavesBlock)) return;
        if (!(event.getLevel() instanceof ServerLevel level)) return;

        if (level.random.nextDouble() < Config.STICK_FROM_LEAF_CHANCE.get()) {
            BlockPos pos = event.getPos();
            ItemEntity drop = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    new ItemStack(Items.STICK));
            level.addFreshEntity(drop);
        }
    }

    @SubscribeEvent
    public static void onLeafDecay(BlockEvent.NeighborNotifyEvent event) {
        if (!Config.STICKS_FROM_LEAVES.get()) return;
        if (!(event.getLevel() instanceof ServerLevel level)) return;
        BlockState state = event.getState();
        if (!(state.getBlock() instanceof LeavesBlock)) return;
        if (!state.hasProperty(BlockStateProperties.PERSISTENT) || state.getValue(BlockStateProperties.PERSISTENT)) return;

        if (level.random.nextDouble() < Config.STICK_FROM_LEAF_CHANCE.get() * 0.25) {
            BlockPos pos = event.getPos();
            ItemEntity drop = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    new ItemStack(Items.STICK));
            level.addFreshEntity(drop);
        }
    }
}

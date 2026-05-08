package com.mitemc.events;

import com.mitemc.registries.ModEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * Fertility enchantment — while a hoe with the enchant is held in the main hand, surrounding
 * crops within a small radius receive bonus random ticks. Strength scales with level.
 *
 *   Level 1: 1 bonus tick / second on a 3x1x3 area
 *   Level 2: 2 bonus ticks / second on a 5x1x5 area
 *   Level 3: 4 bonus ticks / second on a 7x1x7 area
 */
public final class FertilityHandler {

    private FertilityHandler() {}

    @SubscribeEvent
    public static void onTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (player.tickCount % 20 != 0) return;

        int lvl = ModEnchantments.level(player.getItemBySlot(EquipmentSlot.MAINHAND),
                ModEnchantments.FERTILITY, player.level().registryAccess());
        if (lvl <= 0) return;

        ServerLevel level = (ServerLevel) player.level();
        int radius = lvl * 2 - 1;          // 1, 3, 5
        int ticksToFire = 1 << (lvl - 1);  // 1, 2, 4

        BlockPos origin = player.blockPosition();
        for (int i = 0; i < ticksToFire; i++) {
            int dx = level.random.nextInt(radius * 2 + 1) - radius;
            int dz = level.random.nextInt(radius * 2 + 1) - radius;
            BlockPos pos = origin.offset(dx, 0, dz);
            BlockState s = level.getBlockState(pos);
            if (s.getBlock() instanceof CropBlock) {
                s.randomTick(level, pos, level.random);
            }
        }
    }
}

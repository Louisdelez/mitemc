package com.mitemc.events;

import com.mitemc.config.Config;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;

/**
 * Rainy fishing bonus — when a player catches anything while raining at the bobber, roll for
 * an extra item drop (raw fish or kelp). Configurable via {@link Config#RAIN_FISHING_BONUS_CHANCE}.
 */
public final class RainFishingHandler {

    private RainFishingHandler() {}

    @SubscribeEvent
    public static void onItemFished(ItemFishedEvent event) {
        Player player = event.getEntity();
        FishingHook hook = event.getHookEntity();
        if (player == null || hook == null) return;
        if (!(player.level() instanceof ServerLevel level)) return;
        if (!level.isRainingAt(hook.blockPosition())) return;

        if (level.random.nextDouble() < Config.RAIN_FISHING_BONUS_CHANCE.get()) {
            // Drop a small bonus at the player (kept simple — no fancy table lookup).
            ItemStack bonus = level.random.nextBoolean()
                    ? new ItemStack(Items.COD)
                    : new ItemStack(Items.KELP);
            net.minecraft.world.entity.item.ItemEntity drop = new net.minecraft.world.entity.item.ItemEntity(
                    level, player.getX(), player.getY(), player.getZ(), bonus);
            level.addFreshEntity(drop);
        }
    }
}

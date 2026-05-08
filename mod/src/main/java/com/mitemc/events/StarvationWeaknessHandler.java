package com.mitemc.events;

import com.mitemc.config.Config;
import com.mitemc.registries.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * When food falls below {@code starvation_threshold}: apply MITEMC's starvation weakness effect
 * (cosmetic display) and vanilla slowness, and block break/place actions so the player can't
 * keep working through hunger.
 */
public final class StarvationWeaknessHandler {

    private StarvationWeaknessHandler() {}

    private static boolean isStarving(ServerPlayer player) {
        return player.getFoodData().getFoodLevel() < Config.STARVATION_WEAKNESS_FOOD_THRESHOLD.get();
    }

    @SubscribeEvent
    public static void onTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (player.tickCount % 40 != 0) return;
        if (player.isCreative() || player.isSpectator()) return;

        if (isStarving(player)) {
            player.addEffect(new MobEffectInstance(ModEffects.STARVATION_WEAKNESS, 60, 0, true, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, true, false, true));
        }
    }

    @SubscribeEvent
    public static void onBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer() instanceof ServerPlayer player && isStarving(player)) {
            event.setCanceled(true);
            player.displayClientMessage(Component.translatable("message.mitemc.too_weak_break"), true);
        }
    }

    @SubscribeEvent
    public static void onPlace(BlockEvent.EntityPlaceEvent event) {
        if (event.getEntity() instanceof ServerPlayer player && isStarving(player)) {
            event.setCanceled(true);
            player.displayClientMessage(Component.translatable("message.mitemc.too_weak_place"), true);
        }
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getEntity() instanceof ServerPlayer player && isStarving(player)) {
            // Soft-block: only prevent BlockItem placement; let other interactions through.
            if (event.getItemStack().getItem() instanceof net.minecraft.world.item.BlockItem) {
                event.setCanceled(true);
                player.displayClientMessage(Component.translatable("message.mitemc.too_weak_place"), true);
            }
        }
    }
}

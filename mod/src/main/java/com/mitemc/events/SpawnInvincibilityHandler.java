package com.mitemc.events;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

/**
 * MITE rule: a freshly-spawned player has 30 seconds (600 ticks) of invincibility against
 * attacker damage. Environmental damage (fall, lava, drowning, suffocation, starvation) still
 * applies — only attacker-driven damage is blocked.
 *
 * Tracking is via {@link Player#tickCount}, which Minecraft already maintains and resets on
 * respawn / world load. No persistent state needed.
 */
public final class SpawnInvincibilityHandler {

    public static final int GRACE_PERIOD_TICKS = 600; // 30 seconds at 20 TPS

    private SpawnInvincibilityHandler() {}

    @SubscribeEvent
    public static void onIncomingDamage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (player.isCreative() || player.isSpectator()) return;
        if (player.tickCount >= GRACE_PERIOD_TICKS) return;

        DamageSource source = event.getSource();
        if (source.getEntity() != null) {
            // attacker-driven damage during grace period: cancel
            event.setCanceled(true);
        }
    }
}

package com.mitemc.events;

import com.mitemc.config.Config;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * If the player is exposed to rain, basal exhaustion is multiplied. The basal handler
 * already applied the base rate, so we add the *delta* here to avoid double-charging.
 */
public final class RainHungerHandler {

    private RainHungerHandler() {}

    @SubscribeEvent
    public static void onTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (player.isCreative() || player.isSpectator()) return;
        if (!(player.level() instanceof ServerLevel level)) return;
        if (!level.isRainingAt(player.blockPosition())) return;

        double basal = Config.BASAL_EXHAUSTION_PER_TICK.get();
        double mult  = Config.RAIN_EXHAUSTION_MULTIPLIER.get();
        double extra = basal * (mult - 1.0);
        if (extra <= 0.0) return;

        player.causeFoodExhaustion((float) extra);
    }
}

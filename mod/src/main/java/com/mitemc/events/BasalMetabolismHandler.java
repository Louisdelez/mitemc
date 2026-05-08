package com.mitemc.events;

import com.mitemc.config.Config;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * Idle hunger drain — players lose food even when standing still. Configurable.
 */
public final class BasalMetabolismHandler {

    private BasalMetabolismHandler() {}

    @SubscribeEvent
    public static void onTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (player.isCreative() || player.isSpectator()) return;

        double basal = Config.BASAL_EXHAUSTION_PER_TICK.get();
        if (basal <= 0.0) return;

        // Rain handler may amplify this further; here we apply only the base rate.
        player.causeFoodExhaustion((float) basal);
    }
}

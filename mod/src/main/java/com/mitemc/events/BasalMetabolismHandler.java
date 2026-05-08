package com.mitemc.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * MITE-spirit hunger drain. One unified per-tick handler so the values stay coherent.
 *
 * Per MITE behavior:
 *   - baseline:        0.0001 exhaustion / tick   (≈ slow drain)
 *   - cold biome:      0.00001 / tick             (cold slows metabolism — counter-intuitive but in MITE it's the rule)
 *   - hot biome:       0.001 / tick               (10× faster drain)
 *   - rain on player:  +0.01 / tick               (added on top of baseline)
 *
 * Cold/hot detection uses {@code biome.getBaseTemperature()} thresholds 0.5 / 1.5.
 * The Nether (and other ultrawarm dimensions) treats as hot regardless.
 */
public final class BasalMetabolismHandler {

    private BasalMetabolismHandler() {}

    @SubscribeEvent
    public static void onTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (player.isCreative() || player.isSpectator()) return;
        if (!(player.level() instanceof ServerLevel level)) return;

        boolean ultrawarm = level.dimensionType().ultraWarm();
        float temp = level.getBiome(player.blockPosition()).value().getBaseTemperature();
        boolean hot  = ultrawarm || temp > 1.5f;
        boolean cold = !ultrawarm && temp < 0.5f;

        float basal;
        if (hot)       basal = 0.001f;
        else if (cold) basal = 0.00001f;
        else           basal = 0.0001f;

        player.causeFoodExhaustion(basal);

        if (level.isRainingAt(player.blockPosition())) {
            // MITE: rain adds a flat 0.01 exhaustion / tick on top.
            player.causeFoodExhaustion(0.01f);
        }
    }
}

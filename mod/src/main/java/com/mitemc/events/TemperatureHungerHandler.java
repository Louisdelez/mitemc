package com.mitemc.events;

import com.mitemc.config.Config;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * Cold-biome hunger amplifier. If the player is standing in a biome whose base temperature is
 * below {@link Config#COLD_BIOME_TEMP_THRESHOLD}, basal exhaustion is multiplied by
 * {@link Config#COLD_BIOME_HUNGER_MULT} for the difference (delta only — basal is already
 * applied by {@link BasalMetabolismHandler}, this handler adds the extra).
 */
public final class TemperatureHungerHandler {

    private TemperatureHungerHandler() {}

    @SubscribeEvent
    public static void onTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (player.isCreative() || player.isSpectator()) return;
        if (!(player.level() instanceof ServerLevel level)) return;

        Biome biome = level.getBiome(player.blockPosition()).value();
        float temp = biome.getBaseTemperature();
        double threshold = Config.COLD_BIOME_TEMP_THRESHOLD.get();
        if (temp >= threshold) return;

        double basal = Config.BASAL_EXHAUSTION_PER_TICK.get();
        double mult  = Config.COLD_BIOME_HUNGER_MULT.get();
        double extra = basal * (mult - 1.0);
        if (extra <= 0.0) return;
        player.causeFoodExhaustion((float) extra);
    }
}

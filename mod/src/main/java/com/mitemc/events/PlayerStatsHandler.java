package com.mitemc.events;

import com.mitemc.Constants;
import com.mitemc.config.Config;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * Implements the iconic MITE rule: you start with 3 hearts and 3 food icons,
 * and earn +1 of each every {@code level_interval} XP levels, capped at vanilla 10.
 *
 * The hunger cap is a soft cap — vanilla {@link FoodData} doesn't expose a max,
 * so we clamp the food level on tick.
 */
public final class PlayerStatsHandler {

    private static final AttributeModifier.Operation OP = AttributeModifier.Operation.ADD_VALUE;

    private PlayerStatsHandler() {}

    @SubscribeEvent
    public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            applyStats(player);
        }
    }

    @SubscribeEvent
    public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            applyStats(player);
        }
    }

    @SubscribeEvent
    public static void onChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            applyStats(player);
        }
    }

    @SubscribeEvent
    public static void onTick(PlayerTickEvent.Post event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            // re-apply each second (every 20 ticks) — cheap and resilient against external attribute changes
            if (player.tickCount % 20 == 0) {
                applyStats(player);
            }
            clampFood(player);
        }
    }

    private static void applyStats(ServerPlayer player) {
        int level = player.experienceLevel;
        int interval = Config.HEART_GAIN_LEVEL_INTERVAL.get();
        int starting = Config.STARTING_HEARTS.get();
        int perInterval = Config.HEARTS_PER_LEVELS.get();
        int cap = Config.MAX_HEARTS_CAP.get();

        int targetHearts = Math.min(cap, starting + (level / Math.max(1, interval)) * perInterval);
        double targetMaxHealth = targetHearts * 2.0;

        AttributeInstance attr = player.getAttribute(Attributes.MAX_HEALTH);
        if (attr == null) return;

        // Vanilla baseline = 20.0. We model the difference as a flat modifier so we never trample other mods' modifiers.
        var modifierId = Constants.id("phase1_max_health");
        attr.removeModifier(modifierId);
        double delta = targetMaxHealth - attr.getBaseValue();
        if (delta != 0.0) {
            attr.addPermanentModifier(new AttributeModifier(modifierId, delta, OP));
        }

        if (player.getHealth() > attr.getValue()) {
            player.setHealth((float) attr.getValue());
        }
    }

    private static void clampFood(ServerPlayer player) {
        int level = player.experienceLevel;
        int interval = Config.HEART_GAIN_LEVEL_INTERVAL.get();
        int starting = Config.STARTING_FOOD.get();
        int perInterval = Config.FOOD_PER_LEVELS.get();
        int cap = Config.MAX_FOOD_CAP.get();

        int targetFood = Math.min(cap, starting + (level / Math.max(1, interval)) * perInterval);
        // FoodData stores food on a 0..20 internal scale where 2 internal = 1 icon.
        int targetInternal = targetFood * 2;

        FoodData data = player.getFoodData();
        if (data.getFoodLevel() > targetInternal) {
            data.setFoodLevel(targetInternal);
        }
    }
}

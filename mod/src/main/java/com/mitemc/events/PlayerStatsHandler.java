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
 * Player stats per MITE-spirit rules:
 *  - Max HP scales with XP level: {@code min(20, floor(level/5) * 2 + 6)}
 *    → level 0 = 6 HP (3 hearts), level 5 = 8 HP (4 hearts), …, level 35+ = 20 HP cap.
 *  - Max food icons follow a parallel curve, exposed via the existing config knobs.
 *
 * Why a flat ADD_VALUE modifier rather than setBaseValue: it leaves room for other mods that
 * may add their own modifiers without our re-applies fighting them.
 */
public final class PlayerStatsHandler {

    private static final AttributeModifier.Operation OP = AttributeModifier.Operation.ADD_VALUE;

    /** MITE health curve: every 5 levels gives +2 HP (one heart), starting at 6 HP, capped at 20 HP. */
    public static int targetMaxHealth(int xpLevel) {
        return Math.min(20, (xpLevel / 5) * 2 + 6);
    }

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
            if (player.tickCount % 20 == 0) {
                applyStats(player);
            }
            clampFood(player);
        }
    }

    private static void applyStats(ServerPlayer player) {
        AttributeInstance attr = player.getAttribute(Attributes.MAX_HEALTH);
        if (attr == null) return;

        double target = targetMaxHealth(player.experienceLevel);

        var modifierId = Constants.id("mite_max_health");
        attr.removeModifier(modifierId);
        double delta = target - attr.getBaseValue();
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
        int targetInternal = targetFood * 2;

        FoodData data = player.getFoodData();
        if (data.getFoodLevel() > targetInternal) {
            data.setFoodLevel(targetInternal);
        }
    }
}

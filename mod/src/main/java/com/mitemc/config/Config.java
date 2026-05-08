package com.mitemc.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class Config {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue STARTING_HEARTS;
    public static final ModConfigSpec.IntValue STARTING_FOOD;
    public static final ModConfigSpec.IntValue HEARTS_PER_LEVELS;
    public static final ModConfigSpec.IntValue FOOD_PER_LEVELS;
    public static final ModConfigSpec.IntValue HEART_GAIN_LEVEL_INTERVAL;
    public static final ModConfigSpec.IntValue MAX_HEARTS_CAP;
    public static final ModConfigSpec.IntValue MAX_FOOD_CAP;

    public static final ModConfigSpec.DoubleValue BASAL_EXHAUSTION_PER_TICK;
    public static final ModConfigSpec.DoubleValue RAIN_EXHAUSTION_MULTIPLIER;
    public static final ModConfigSpec.IntValue STARVATION_WEAKNESS_FOOD_THRESHOLD;
    public static final ModConfigSpec.BooleanValue STICKS_FROM_LEAVES;
    public static final ModConfigSpec.DoubleValue STICK_FROM_LEAF_CHANCE;

    // Phase 5 — agriculture, weather, environment
    public static final ModConfigSpec.DoubleValue CROP_BLIGHT_CHANCE;
    public static final ModConfigSpec.DoubleValue BLIGHT_SPREAD_CHANCE;
    public static final ModConfigSpec.DoubleValue RAIN_CROP_GROWTH_CHANCE;
    public static final ModConfigSpec.DoubleValue COLD_BIOME_HUNGER_MULT;
    public static final ModConfigSpec.DoubleValue COLD_BIOME_TEMP_THRESHOLD;
    public static final ModConfigSpec.DoubleValue ANIMAL_MANURE_PER_TICK_CHANCE;
    public static final ModConfigSpec.DoubleValue RAIN_FISHING_BONUS_CHANCE;

    static {
        BUILDER.comment("Phase 1 — Core survival rebalance").push("phase1");

        BUILDER.push("starting_stats");
        STARTING_HEARTS = BUILDER
                .comment("Number of hearts the player starts with (vanilla = 10).")
                .defineInRange("starting_hearts", 3, 1, 10);
        STARTING_FOOD = BUILDER
                .comment("Number of food icons the player starts with (vanilla = 10).")
                .defineInRange("starting_food", 3, 1, 10);
        HEART_GAIN_LEVEL_INTERVAL = BUILDER
                .comment("XP levels needed to gain +1 heart and +1 food icon.")
                .defineInRange("level_interval", 5, 1, 100);
        HEARTS_PER_LEVELS = BUILDER
                .comment("How many hearts gained per interval.")
                .defineInRange("hearts_per_interval", 1, 0, 10);
        FOOD_PER_LEVELS = BUILDER
                .comment("How many food icons gained per interval.")
                .defineInRange("food_per_interval", 1, 0, 10);
        MAX_HEARTS_CAP = BUILDER
                .comment("Hard cap on hearts regardless of level.")
                .defineInRange("max_hearts_cap", 10, 1, 30);
        MAX_FOOD_CAP = BUILDER
                .comment("Hard cap on food icons regardless of level.")
                .defineInRange("max_food_cap", 10, 1, 20);
        BUILDER.pop();

        BUILDER.push("hunger");
        BASAL_EXHAUSTION_PER_TICK = BUILDER
                .comment("Idle exhaustion per server tick (basal metabolism). Vanilla baseline ≈ 0.0.")
                .defineInRange("basal_exhaustion_per_tick", 0.0005, 0.0, 1.0);
        RAIN_EXHAUSTION_MULTIPLIER = BUILDER
                .comment("Multiplier applied to basal exhaustion when the player is exposed to rain.")
                .defineInRange("rain_multiplier", 3.0, 1.0, 20.0);
        STARVATION_WEAKNESS_FOOD_THRESHOLD = BUILDER
                .comment("If the food bar drops below this value the player is too weak to break/place blocks.")
                .defineInRange("starvation_threshold", 1, 0, 20);
        BUILDER.pop();

        BUILDER.push("foraging");
        STICKS_FROM_LEAVES = BUILDER
                .comment("If true, decaying leaves can drop a stick (early-game flint pickaxe path).")
                .define("sticks_from_leaves", true);
        STICK_FROM_LEAF_CHANCE = BUILDER
                .comment("Chance per leaf-decay event to drop a stick.")
                .defineInRange("stick_from_leaf_chance", 0.04, 0.0, 1.0);
        BUILDER.pop();

        BUILDER.pop();

        BUILDER.comment("Phase 5 — Agriculture, weather, environment").push("phase5");

        BUILDER.push("agriculture");
        CROP_BLIGHT_CHANCE = BUILDER
                .comment("Per random-tick chance for a mature MITEMC crop to develop blight.")
                .defineInRange("crop_blight_chance", 0.005, 0.0, 1.0);
        BLIGHT_SPREAD_CHANCE = BUILDER
                .comment("Per random-tick chance that a blighted crop infects an adjacent mature non-blighted crop.")
                .defineInRange("blight_spread_chance", 0.10, 0.0, 1.0);
        RAIN_CROP_GROWTH_CHANCE = BUILDER
                .comment("Per random-tick chance during rain that a non-blighted MITEMC crop gets a bonus growth tick.")
                .defineInRange("rain_growth_chance", 0.20, 0.0, 1.0);
        ANIMAL_MANURE_PER_TICK_CHANCE = BUILDER
                .comment("Per server tick chance that a tracked animal (cow/pig) drops manure.")
                .defineInRange("animal_manure_chance", 0.0001, 0.0, 1.0);
        BUILDER.pop();

        BUILDER.push("environment");
        COLD_BIOME_HUNGER_MULT = BUILDER
                .comment("Multiplier applied to basal exhaustion when the player is in a cold biome (below threshold).")
                .defineInRange("cold_biome_mult", 2.0, 1.0, 20.0);
        COLD_BIOME_TEMP_THRESHOLD = BUILDER
                .comment("Biome temperature below which the cold-biome multiplier kicks in. Vanilla cold biomes ≈ 0.0–0.2.")
                .defineInRange("cold_biome_threshold", 0.2, -2.0, 2.0);
        RAIN_FISHING_BONUS_CHANCE = BUILDER
                .comment("Extra-loot probability rolled on a fishing catch when raining at the bobber.")
                .defineInRange("rain_fishing_bonus", 0.25, 0.0, 1.0);
        BUILDER.pop();

        BUILDER.pop();
    }

    public static final ModConfigSpec SPEC = BUILDER.build();

    private Config() {}
}

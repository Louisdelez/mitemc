package com.mitemc.events;

import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

/**
 * Friendly-animal hunger model. Each tracked animal accumulates a hunger counter that ticks
 * up while it's not adjacent to its preferred food block (grass / wheat / water). At the cap
 * the animal takes a single hunger damage tick, then resets.
 *
 * The counter is persisted via the entity's persistent data (NBT) using a simple long key —
 * survives chunk unload, world save, and dimension change.
 *
 * This is a deliberately lightweight model. Phase 5 will introduce thirst, manure, and the
 * full agricultural loop on top.
 */
public final class AnimalHungerHandler {

    private static final String KEY_HUNGER_TICK = "mitemc:animal_hunger";
    private static final long  HUNGER_DAMAGE_INTERVAL_TICKS = 24_000L; // ~one in-game day
    private static final long  TICK_RATE = 100L; // check every 5 seconds

    private AnimalHungerHandler() {}

    @SubscribeEvent
    public static void onAnimalTick(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof Animal animal)) return;
        if (animal.level().isClientSide) return;
        if (animal.tickCount % TICK_RATE != 0) return;
        if (!isTrackedSpecies(animal)) return;

        var data = animal.getPersistentData();
        long counter = data.getLong(KEY_HUNGER_TICK);

        boolean nearFood = isNearFood(animal);
        if (nearFood) {
            counter = Math.max(0L, counter - TICK_RATE * 4); // recover 4× while feeding
        } else {
            counter += TICK_RATE;
        }

        if (counter >= HUNGER_DAMAGE_INTERVAL_TICKS) {
            animal.hurt(animal.damageSources().source(DamageTypes.STARVE), 1.0F);
            counter = HUNGER_DAMAGE_INTERVAL_TICKS / 2L;
        }
        data.putLong(KEY_HUNGER_TICK, counter);
    }

    private static boolean isTrackedSpecies(Animal a) {
        return a instanceof Cow || a instanceof Sheep || a instanceof Pig || a instanceof Chicken;
    }

    private static boolean isNearFood(Animal animal) {
        BlockPos pos = animal.blockPosition();
        var level = animal.level();
        for (int dx = -2; dx <= 2; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -2; dz <= 2; dz++) {
                    var state = level.getBlockState(pos.offset(dx, dy, dz));
                    if (state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.SHORT_GRASS)
                            || state.is(Blocks.WHEAT) || state.is(Blocks.WATER)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

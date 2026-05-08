package com.mitemc.events;

import com.mitemc.config.Config;
import com.mitemc.registries.ModItems;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

/**
 * Cows and pigs occasionally drop a manure item. Per-tick chance configurable.
 */
public final class AnimalManureHandler {

    private AnimalManureHandler() {}

    @SubscribeEvent
    public static void onAnimalTick(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof Animal animal)) return;
        if (!(animal instanceof Cow || animal instanceof Pig)) return;
        if (animal.level().isClientSide) return;
        if (animal.isBaby()) return;

        if (animal.getRandom().nextDouble() < Config.ANIMAL_MANURE_PER_TICK_CHANCE.get()) {
            net.minecraft.world.entity.item.ItemEntity drop = new net.minecraft.world.entity.item.ItemEntity(
                    animal.level(), animal.getX(), animal.getY(), animal.getZ(),
                    new ItemStack(ModItems.MANURE.get()));
            animal.level().addFreshEntity(drop);
        }
    }
}

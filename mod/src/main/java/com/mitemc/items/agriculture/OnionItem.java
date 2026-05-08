package com.mitemc.items.agriculture;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

/**
 * Onion — modest food. Designed to chain into Phase 5 stew recipes, not as a standalone meal.
 */
public class OnionItem extends Item {
    public OnionItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationModifier(0.4F)
                .build()));
    }
}

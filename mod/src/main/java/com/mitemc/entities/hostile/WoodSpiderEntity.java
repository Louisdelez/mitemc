package com.mitemc.entities.hostile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

/**
 * Wood spider — forest-biome surface variant of the cave spider. Slightly bigger than vanilla
 * spider, no poison bite, but very fast on tree canopies (default Spider AI handles climbing).
 */
public class WoodSpiderEntity extends Spider {

    public WoodSpiderEntity(EntityType<? extends Spider> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Spider.createAttributes()
                .add(Attributes.MAX_HEALTH,    14.0)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.MOVEMENT_SPEED, 0.36);
    }
}

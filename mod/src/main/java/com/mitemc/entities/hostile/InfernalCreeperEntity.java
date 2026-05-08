package com.mitemc.entities.hostile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;

/**
 * Infernal creeper — Nether-spawning creeper variant. Larger blast radius, immune to fire.
 * Vanilla creeper explosion radius is 3; this one is 5.
 */
public class InfernalCreeperEntity extends Creeper {

    public InfernalCreeperEntity(EntityType<? extends Creeper> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean fireImmune() { return true; }

    @Override
    public int getMaxFallDistance() { return 6; }

    public static AttributeSupplier.Builder createAttributes() {
        return Creeper.createAttributes()
                .add(Attributes.MAX_HEALTH,    24.0)
                .add(Attributes.MOVEMENT_SPEED, 0.30)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 0.5);
    }
}

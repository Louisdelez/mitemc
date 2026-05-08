package com.mitemc.entities.hostile;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

/**
 * Invisible stalker — applies vanilla invisibility on itself permanently and re-applies it
 * each tick if it wears off. Holds no items so it stays fully invisible (vanilla invisibility
 * still shows held armor/items, which players find disorienting in MITE-style).
 */
public class InvisibleStalkerEntity extends Zombie {

    public InvisibleStalkerEntity(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean isSunSensitive() { return false; }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide && this.tickCount % 200 == 0) {
            this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 400, 0, false, false));
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Zombie.createAttributes()
                .add(Attributes.MAX_HEALTH,    18.0)
                .add(Attributes.ATTACK_DAMAGE,  5.5)
                .add(Attributes.MOVEMENT_SPEED, 0.27);
    }
}

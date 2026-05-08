package com.mitemc.entities.hostile;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;

/**
 * Ghoul — cave-dwelling zombie variant. Bite causes paralysis (Slowness IV + Mining Fatigue II).
 * No burning in sunlight (these things crawled out of MITE-deep caves; they were happy there).
 */
public class GhoulEntity extends Zombie {

    public GhoulEntity(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean isSunSensitive() { return false; }

    @Override
    public boolean doHurtTarget(net.minecraft.server.level.ServerLevel level, Entity target) {
        boolean hit = super.doHurtTarget(level, target);
        if (hit && target instanceof LivingEntity victim) {
            victim.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 3, false, true));
            victim.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN,      80, 1, false, true));
        }
        return hit;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Zombie.createAttributes()
                .add(Attributes.MAX_HEALTH,    24.0)
                .add(Attributes.ATTACK_DAMAGE,  4.0)
                .add(Attributes.MOVEMENT_SPEED, 0.24);
    }
}

package com.mitemc.entities.hostile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * Demon spider — deep-cave variant. Periodically leaps at its target.
 */
public class DemonSpiderEntity extends Spider {

    public DemonSpiderEntity(EntityType<? extends Spider> type, Level level) {
        super(type, level);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide && this.tickCount % 60 == 0 && this.onGround()) {
            LivingEntity target = this.getTarget();
            if (target != null && this.distanceToSqr(target) < 64.0) {
                Vec3 dir = target.position().subtract(this.position()).normalize().scale(0.7);
                this.setDeltaMovement(dir.x, 0.6, dir.z);
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Spider.createAttributes()
                .add(Attributes.MAX_HEALTH,    20.0)
                .add(Attributes.ATTACK_DAMAGE,  5.0)
                .add(Attributes.MOVEMENT_SPEED, 0.34);
    }
}

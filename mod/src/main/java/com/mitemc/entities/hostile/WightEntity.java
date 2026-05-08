package com.mitemc.entities.hostile;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;

/**
 * Wight — undead. Hits drain hunger from players (devours life-force).
 * Faster than a regular skeleton, no bow.
 */
public class WightEntity extends Skeleton {

    public WightEntity(EntityType<? extends Skeleton> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean doHurtTarget(net.minecraft.server.level.ServerLevel level, Entity target) {
        boolean hit = super.doHurtTarget(level, target);
        if (hit && target instanceof ServerPlayer player) {
            player.causeFoodExhaustion(4.0F);
        }
        return hit;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return AbstractSkeleton.createAttributes()
                .add(Attributes.MAX_HEALTH,    18.0)
                .add(Attributes.ATTACK_DAMAGE,  4.0)
                .add(Attributes.MOVEMENT_SPEED, 0.28);
    }
}

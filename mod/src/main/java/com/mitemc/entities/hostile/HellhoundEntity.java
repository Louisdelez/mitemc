package com.mitemc.entities.hostile;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Hellhound — Nether-tier dire wolf. Immune to fire and lava, sets target on fire on hit.
 */
public class HellhoundEntity extends Wolf {

    public HellhoundEntity(EntityType<? extends Wolf> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean fireImmune() { return true; }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hit = super.doHurtTarget(target);
        if (hit) {
            target.igniteForSeconds(5);
        }
        return hit;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Wolf.createAttributes()
                .add(Attributes.MAX_HEALTH,    24.0)
                .add(Attributes.ATTACK_DAMAGE,  7.0)
                .add(Attributes.MOVEMENT_SPEED, 0.36);
    }
}

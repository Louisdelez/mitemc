package com.mitemc.entities.hostile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

/**
 * Dire wolf — bigger, meaner, surface mob. Spawns in twilight.
 *
 *  HP   20  (vanilla wolf 8)
 *  ATK  6   (vanilla wolf 4)
 *  SPD  0.35 (vanilla wolf 0.30)
 *
 * Always hostile to players (overrides Wolf's tameable bias).
 */
public class DireWolfEntity extends Wolf {

    public DireWolfEntity(EntityType<? extends Wolf> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Wolf.createAttributes()
                .add(Attributes.MAX_HEALTH,        20.0)
                .add(Attributes.ATTACK_DAMAGE,      6.0)
                .add(Attributes.MOVEMENT_SPEED,     0.35)
                .add(Attributes.FOLLOW_RANGE,      24.0);
    }
}

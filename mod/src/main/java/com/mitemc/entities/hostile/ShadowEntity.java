package com.mitemc.entities.hostile;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

/**
 * Shadow — only spawns in light level 0. Enforced via {@link #checkShadowSpawnRules}.
 * Hits do not generate light, so it stays in pitch-darkness.
 */
public class ShadowEntity extends Zombie {

    public ShadowEntity(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean isSunSensitive() { return false; }

    public static boolean checkShadowSpawnRules(EntityType<ShadowEntity> type, ServerLevelAccessor level,
                                                MobSpawnType reason, BlockPos pos, RandomSource random) {
        return level.getMaxLocalRawBrightness(pos) == 0
                && Zombie.checkMonsterSpawnRules(type, level, reason, pos, random);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Zombie.createAttributes()
                .add(Attributes.MAX_HEALTH,    16.0)
                .add(Attributes.ATTACK_DAMAGE,  5.0)
                .add(Attributes.MOVEMENT_SPEED, 0.30);
    }
}

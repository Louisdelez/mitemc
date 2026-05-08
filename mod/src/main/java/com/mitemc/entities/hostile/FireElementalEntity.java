package com.mitemc.entities.hostile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.level.Level;

/**
 * Fire elemental — overworld-deep blaze cousin. Spawns in cave layers below Y=0 instead of
 * the Nether, with slightly more health and a longer follow range.
 */
public class FireElementalEntity extends Blaze {

    public FireElementalEntity(EntityType<? extends Blaze> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Blaze.createAttributes()
                .add(Attributes.MAX_HEALTH,    24.0)
                .add(Attributes.ATTACK_DAMAGE,  6.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.FOLLOW_RANGE,  32.0);
    }
}

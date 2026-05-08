package com.mitemc.events;

import com.mitemc.entities.hostile.DemonSpiderEntity;
import com.mitemc.entities.hostile.DireWolfEntity;
import com.mitemc.entities.hostile.FireElementalEntity;
import com.mitemc.entities.hostile.GhoulEntity;
import com.mitemc.entities.hostile.HellhoundEntity;
import com.mitemc.entities.hostile.InfernalCreeperEntity;
import com.mitemc.entities.hostile.InvisibleStalkerEntity;
import com.mitemc.entities.hostile.ShadowEntity;
import com.mitemc.entities.hostile.WightEntity;
import com.mitemc.entities.hostile.WoodSpiderEntity;
import com.mitemc.registries.ModEntities;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

/**
 * Subscribes to mod-bus lifecycle events to declare attribute defaults and spawn placement
 * predicates for the 10 Phase 4 mobs.
 */
public final class MobAttributeEvents {

    private MobAttributeEvents() {}

    @SubscribeEvent
    public static void onCreateAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.DIRE_WOLF.get(),         DireWolfEntity.createAttributes().build());
        event.put(ModEntities.WOOD_SPIDER.get(),       WoodSpiderEntity.createAttributes().build());
        event.put(ModEntities.GHOUL.get(),             GhoulEntity.createAttributes().build());
        event.put(ModEntities.WIGHT.get(),             WightEntity.createAttributes().build());
        event.put(ModEntities.SHADOW.get(),            ShadowEntity.createAttributes().build());
        event.put(ModEntities.INVISIBLE_STALKER.get(), InvisibleStalkerEntity.createAttributes().build());
        event.put(ModEntities.HELLHOUND.get(),         HellhoundEntity.createAttributes().build());
        event.put(ModEntities.DEMON_SPIDER.get(),      DemonSpiderEntity.createAttributes().build());
        event.put(ModEntities.INFERNAL_CREEPER.get(),  InfernalCreeperEntity.createAttributes().build());
        event.put(ModEntities.FIRE_ELEMENTAL.get(),    FireElementalEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void onRegisterSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        // Default monster rules for most. Shadow gets a custom rule (light level 0).
        event.register(ModEntities.DIRE_WOLF.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);

        event.register(ModEntities.WOOD_SPIDER.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);

        event.register(ModEntities.GHOUL.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);

        event.register(ModEntities.WIGHT.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);

        event.register(ModEntities.SHADOW.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ShadowEntity::checkShadowSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);

        event.register(ModEntities.INVISIBLE_STALKER.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);

        event.register(ModEntities.HELLHOUND.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (et, level, reason, pos, random) -> Monster.checkAnyLightMonsterSpawnRules(et, level, reason, pos, random),
                RegisterSpawnPlacementsEvent.Operation.AND);

        event.register(ModEntities.DEMON_SPIDER.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.AND);

        event.register(ModEntities.INFERNAL_CREEPER.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (et, level, reason, pos, random) -> Monster.checkAnyLightMonsterSpawnRules(et, level, reason, pos, random),
                RegisterSpawnPlacementsEvent.Operation.AND);

        event.register(ModEntities.FIRE_ELEMENTAL.get(),
                RegisterSpawnPlacementsEvent.SpawnPlacementType.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (et, level, reason, pos, random) -> Monster.checkAnyLightMonsterSpawnRules(et, level, reason, pos, random),
                RegisterSpawnPlacementsEvent.Operation.AND);
    }
}

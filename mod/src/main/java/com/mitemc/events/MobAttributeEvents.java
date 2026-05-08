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
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

/**
 * Subscribes to mod-bus lifecycle events to declare attribute defaults for the 10 Phase 4 mobs.
 *
 * Spawn-placement registration: previously this class also called
 * {@code RegisterSpawnPlacementsEvent.register} for each entity. The 5-arg signature differs
 * between MC sub-versions; we currently rely on the BiomeModifier JSON
 * ({@code data/neoforge/biome_modifier/mitemc_*_spawns.json}) to seed spawns instead.
 * Re-add the register calls here once the API path is confirmed for the target NeoForge version.
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
}

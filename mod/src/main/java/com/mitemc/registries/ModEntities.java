package com.mitemc.registries;

import com.mitemc.Constants;
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
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, Constants.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<DireWolfEntity>> DIRE_WOLF =
            ENTITY_TYPES.register("dire_wolf",
                    () -> EntityType.Builder.<DireWolfEntity>of(DireWolfEntity::new, MobCategory.MONSTER)
                            .sized(0.9F, 1.0F).clientTrackingRange(8)
                            .build("dire_wolf"));

    public static final DeferredHolder<EntityType<?>, EntityType<WoodSpiderEntity>> WOOD_SPIDER =
            ENTITY_TYPES.register("wood_spider",
                    () -> EntityType.Builder.<WoodSpiderEntity>of(WoodSpiderEntity::new, MobCategory.MONSTER)
                            .sized(1.4F, 0.9F).clientTrackingRange(8)
                            .build("wood_spider"));

    public static final DeferredHolder<EntityType<?>, EntityType<GhoulEntity>> GHOUL =
            ENTITY_TYPES.register("ghoul",
                    () -> EntityType.Builder.<GhoulEntity>of(GhoulEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F).clientTrackingRange(8)
                            .build("ghoul"));

    public static final DeferredHolder<EntityType<?>, EntityType<WightEntity>> WIGHT =
            ENTITY_TYPES.register("wight",
                    () -> EntityType.Builder.<WightEntity>of(WightEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.99F).clientTrackingRange(8)
                            .build("wight"));

    public static final DeferredHolder<EntityType<?>, EntityType<ShadowEntity>> SHADOW =
            ENTITY_TYPES.register("shadow",
                    () -> EntityType.Builder.<ShadowEntity>of(ShadowEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F).clientTrackingRange(6)
                            .build("shadow"));

    public static final DeferredHolder<EntityType<?>, EntityType<InvisibleStalkerEntity>> INVISIBLE_STALKER =
            ENTITY_TYPES.register("invisible_stalker",
                    () -> EntityType.Builder.<InvisibleStalkerEntity>of(InvisibleStalkerEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F).clientTrackingRange(8)
                            .build("invisible_stalker"));

    public static final DeferredHolder<EntityType<?>, EntityType<HellhoundEntity>> HELLHOUND =
            ENTITY_TYPES.register("hellhound",
                    () -> EntityType.Builder.<HellhoundEntity>of(HellhoundEntity::new, MobCategory.MONSTER)
                            .sized(0.9F, 1.0F).clientTrackingRange(8).fireImmune()
                            .build("hellhound"));

    public static final DeferredHolder<EntityType<?>, EntityType<DemonSpiderEntity>> DEMON_SPIDER =
            ENTITY_TYPES.register("demon_spider",
                    () -> EntityType.Builder.<DemonSpiderEntity>of(DemonSpiderEntity::new, MobCategory.MONSTER)
                            .sized(1.4F, 0.9F).clientTrackingRange(8)
                            .build("demon_spider"));

    public static final DeferredHolder<EntityType<?>, EntityType<InfernalCreeperEntity>> INFERNAL_CREEPER =
            ENTITY_TYPES.register("infernal_creeper",
                    () -> EntityType.Builder.<InfernalCreeperEntity>of(InfernalCreeperEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.7F).clientTrackingRange(8).fireImmune()
                            .build("infernal_creeper"));

    public static final DeferredHolder<EntityType<?>, EntityType<FireElementalEntity>> FIRE_ELEMENTAL =
            ENTITY_TYPES.register("fire_elemental",
                    () -> EntityType.Builder.<FireElementalEntity>of(FireElementalEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.8F).clientTrackingRange(8).fireImmune()
                            .build("fire_elemental"));

    private ModEntities() {}
}

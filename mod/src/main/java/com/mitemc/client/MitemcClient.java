package com.mitemc.client;

import com.mitemc.Constants;
import com.mitemc.registries.ModEntities;
import net.minecraft.client.renderer.entity.BlazeRenderer;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * Client-only setup. Reuses vanilla renderers as placeholders so the entities are visible
 * (with vanilla textures) until custom geo models and textures are produced. Entities behave
 * correctly server-side regardless.
 */
@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public final class MitemcClient {

    private MitemcClient() {}

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Wolf-class
        event.registerEntityRenderer(ModEntities.DIRE_WOLF.get(), WolfRenderer::new);
        event.registerEntityRenderer(ModEntities.HELLHOUND.get(), WolfRenderer::new);

        // Spider-class
        event.registerEntityRenderer(ModEntities.WOOD_SPIDER.get(),  SpiderRenderer::new);
        event.registerEntityRenderer(ModEntities.DEMON_SPIDER.get(), SpiderRenderer::new);

        // Zombie-class
        event.registerEntityRenderer(ModEntities.GHOUL.get(),             ZombieRenderer::new);
        event.registerEntityRenderer(ModEntities.SHADOW.get(),            ZombieRenderer::new);
        event.registerEntityRenderer(ModEntities.INVISIBLE_STALKER.get(), ZombieRenderer::new);

        // Skeleton-class
        event.registerEntityRenderer(ModEntities.WIGHT.get(), SkeletonRenderer::new);

        // Creeper / Blaze
        event.registerEntityRenderer(ModEntities.INFERNAL_CREEPER.get(), CreeperRenderer::new);
        event.registerEntityRenderer(ModEntities.FIRE_ELEMENTAL.get(),   BlazeRenderer::new);
    }
}

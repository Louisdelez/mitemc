package com.mitemc;

import com.mitemc.config.Config;
import com.mitemc.events.AnimalHungerHandler;
import com.mitemc.events.AnimalManureHandler;
import com.mitemc.events.BasalMetabolismHandler;
import com.mitemc.events.FertilityHandler;
import com.mitemc.events.LeafStickHandler;
import com.mitemc.events.MobAttributeEvents;
import com.mitemc.events.PlayerStatsHandler;
import com.mitemc.events.RainFishingHandler;
import com.mitemc.events.RainHungerHandler;
import com.mitemc.events.StarvationWeaknessHandler;
import com.mitemc.events.TemperatureHungerHandler;
import com.mitemc.events.TreeFellingHandler;
import com.mitemc.registries.ModBlockEntities;
import com.mitemc.registries.ModBlocks;
import com.mitemc.registries.ModCreativeTabs;
import com.mitemc.registries.ModEffects;
import com.mitemc.registries.ModEntities;
import com.mitemc.registries.ModItems;
import com.mitemc.registries.ModSounds;
import com.mitemc.registries.ModTools;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Constants.MOD_ID)
public final class MITEMC {

    public MITEMC(IEventBus modBus, ModContainer container) {
        Constants.LOG.info("MITEMC bootstrap — Minecraft Is Too Easy, again.");

        ModTools.bootstrap();
        ModBlocks.registerBlockItems(ModItems.ITEMS);

        ModItems.ITEMS.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modBus);
        ModEntities.ENTITY_TYPES.register(modBus);
        ModEffects.EFFECTS.register(modBus);
        ModSounds.SOUND_EVENTS.register(modBus);
        ModCreativeTabs.TABS.register(modBus);

        // Mod-bus events (registry/lifecycle)
        modBus.register(MobAttributeEvents.class);

        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        // Game-bus events (per-tick / world)
        var gameBus = NeoForge.EVENT_BUS;
        gameBus.register(PlayerStatsHandler.class);
        gameBus.register(BasalMetabolismHandler.class);
        gameBus.register(RainHungerHandler.class);
        gameBus.register(StarvationWeaknessHandler.class);
        gameBus.register(LeafStickHandler.class);
        gameBus.register(AnimalHungerHandler.class);

        // Phase 5 — agriculture, weather, environment
        // Note: RainCropGrowthHandler is currently a no-op stub on this NeoForge version
        // (BlockEvent.CropGrowEvent.Pre signature differs), so we don't register it.
        gameBus.register(RainFishingHandler.class);
        gameBus.register(TemperatureHungerHandler.class);
        gameBus.register(AnimalManureHandler.class);

        // Phase 6 — Java-backed enchantment handlers
        gameBus.register(TreeFellingHandler.class);
        gameBus.register(FertilityHandler.class);
    }
}

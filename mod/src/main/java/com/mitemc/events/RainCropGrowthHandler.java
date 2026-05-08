package com.mitemc.events;

/**
 * Bonus crop growth tick during rain — DISABLED in this MC 1.21.1 build because
 * {@code BlockEvent.CropGrowEvent.Pre} is not present at this NeoForge version path.
 *
 * The intent (accelerate crop growth when raining) can be reimplemented either via:
 *  - A {@code LevelTickEvent} that scans nearby loaded chunks for MITEMC crops, OR
 *  - A Mixin into {@code CropBlock#randomTick} adding a rain-aware pre-step.
 *
 * Phase 5 ships without this hook for now; the rain-fishing-bonus and temperature-hunger
 * handlers still cover the rest of the rainy weather behavior.
 */
public final class RainCropGrowthHandler {
    private RainCropGrowthHandler() {}
    // No event subscriber until the API path is confirmed.
}

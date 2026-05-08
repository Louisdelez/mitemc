package com.mitemc.events;

/**
 * Superseded — temperature-based hunger drain is now applied by {@link BasalMetabolismHandler}
 * so the baseline + temperature + rain values stay coherent in one place. Kept as an empty
 * marker class for backward compatibility.
 */
public final class TemperatureHungerHandler {
    private TemperatureHungerHandler() {}
}

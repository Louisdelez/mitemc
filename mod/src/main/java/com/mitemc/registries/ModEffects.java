package com.mitemc.registries;

import com.mitemc.Constants;
import com.mitemc.effects.StarvationWeaknessEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, Constants.MOD_ID);

    public static final DeferredHolder<MobEffect, StarvationWeaknessEffect> STARVATION_WEAKNESS =
            EFFECTS.register("starvation_weakness", StarvationWeaknessEffect::new);

    private ModEffects() {}
}

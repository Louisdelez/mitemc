package com.mitemc.registries;

import com.mitemc.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Sound event identifiers used by MITEMC. The actual {@code .ogg} files are not yet shipped — these
 * IDs are reserved so future audio passes can drop in samples without churning calling code.
 *
 * Where each sound is referenced today:
 *  - {@link #STRONGBOX_LOCKED}: rejected open of an iron strongbox by a non-owner.
 *  - {@link #BLIGHT_DEVELOPS}: a mature crop transitions to BLIGHTED.
 *  - {@link #LORE_FLIP}: lore book right-click.
 *  - {@link #FURNACE_CRACKLE}: ambient when a higher-tier MITEMC furnace is burning.
 */
public final class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, Constants.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> STRONGBOX_LOCKED =
            register("block.iron_strongbox.locked");
    public static final DeferredHolder<SoundEvent, SoundEvent> BLIGHT_DEVELOPS  =
            register("block.crop.blight_develops");
    public static final DeferredHolder<SoundEvent, SoundEvent> LORE_FLIP        =
            register("item.lore_book.flip");
    public static final DeferredHolder<SoundEvent, SoundEvent> FURNACE_CRACKLE  =
            register("block.mitemc_furnace.crackle");

    private static DeferredHolder<SoundEvent, SoundEvent> register(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    private ModSounds() {}
}

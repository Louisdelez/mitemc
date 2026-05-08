package com.mitemc.registries;

import com.mitemc.Constants;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Optional;

/**
 * MITEMC's seven enchantments. Five are pure data-driven (JSON in {@code data/mitemc/enchantment/}):
 * speed, stun, regeneration, vampiric, greater_fortune. Two are Java-backed via event handlers:
 * tree_felling, fertility — their JSON files exist as registry markers (description + supported_items
 * + slots) but the gameplay logic lives in {@code com.mitemc.events}.
 */
public final class ModEnchantments {

    public static final ResourceKey<Enchantment> SPEED            = key("speed");
    public static final ResourceKey<Enchantment> STUN             = key("stun");
    public static final ResourceKey<Enchantment> GREATER_FORTUNE  = key("greater_fortune");
    public static final ResourceKey<Enchantment> REGENERATION     = key("regeneration");
    public static final ResourceKey<Enchantment> FERTILITY        = key("fertility");
    public static final ResourceKey<Enchantment> TREE_FELLING     = key("tree_felling");
    public static final ResourceKey<Enchantment> VAMPIRIC         = key("vampiric");

    private static ResourceKey<Enchantment> key(String path) {
        return ResourceKey.create(Registries.ENCHANTMENT,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path));
    }

    /**
     * Resolves an enchantment level from an item stack via the supplied {@link HolderLookup}.
     * Returns 0 if the registry doesn't have the enchantment yet (e.g., during early load).
     */
    public static int level(ItemStack stack, ResourceKey<Enchantment> key, HolderLookup.Provider registries) {
        Optional<Holder.Reference<Enchantment>> holder =
                registries.lookupOrThrow(Registries.ENCHANTMENT).get(key);
        return holder.map(h -> stack.getEnchantments().getLevel(h)).orElse(0);
    }

    /** Convenience: resolve from a LivingEntity's main-hand. */
    public static int mainHandLevel(LivingEntity entity, ResourceKey<Enchantment> key) {
        var registries = entity.level().registryAccess();
        return level(entity.getMainHandItem(), key, registries);
    }

    private ModEnchantments() {}
}

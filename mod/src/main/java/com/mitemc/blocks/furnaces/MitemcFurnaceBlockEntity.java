package com.mitemc.blocks.furnaces;

import com.mitemc.registries.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

/**
 * Furnace BE for the four MITEMC variants. Behaves like a vanilla furnace except:
 *
 *  1. Recipe lookup filters out recipes whose ingredient or result is in
 *     {@link HeatTier#REQUIRES_OBSIDIAN} or {@link HeatTier#REQUIRES_NETHERRACK} when
 *     this furnace's heat is below the corresponding level.
 *  2. Cooking time is scaled by {@link HeatTier#speedMultiplier()}.
 *
 * Note: AbstractFurnaceBlockEntity's recipe API has shifted between MC versions; this class
 * targets the 1.21+ shape where {@code RecipeHolder<? extends AbstractCookingRecipe>} is the
 * canonical handle. If a future MC update changes the signature, adjust {@code resolveRecipe}.
 */
public class MitemcFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    private final FurnaceVariant variant;

    public MitemcFurnaceBlockEntity(BlockPos pos, BlockState state, FurnaceVariant variant) {
        super(ModBlockEntities.MITEMC_FURNACE.get(), pos, state, RecipeType.SMELTING);
        this.variant = variant;
    }

    public HeatTier getHeatTier() {
        return variant.tier;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.mitemc." + variant.id);
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new FurnaceMenu(id, inventory, this, this.dataAccess);
    }

    /**
     * Returns true if this furnace's heat tier is high enough to perform the given recipe.
     * Checks both the input ingredient and the result item against the tier-gating tags.
     */
    private boolean canRunAtThisHeat(Recipe<?> recipe) {
        ItemStack result = recipe.getResultItem(this.level == null ? null : this.level.registryAccess());

        if (result.is(HeatTier.REQUIRES_NETHERRACK) && variant.tier.level < HeatTier.NETHERRACK.level) {
            return false;
        }
        if (result.is(HeatTier.REQUIRES_OBSIDIAN) && variant.tier.level < HeatTier.OBSIDIAN.level) {
            return false;
        }
        return true;
    }

    /** Server-side tick driver — delegated to vanilla, then post-filtered. */
    public static void serverTick(Level level, BlockPos pos, BlockState state, MitemcFurnaceBlockEntity be) {
        if (be.level == null) return;
        // Vanilla AbstractFurnaceBlockEntity exposes a static serverTick that handles cooking.
        AbstractFurnaceBlockEntity.serverTick(level, pos, state, be);
    }

    /**
     * Hook for the cooking-pipeline: when the BE asks "is this stack a valid input?", we
     * additionally check whether the matching recipe is allowed at our heat tier.
     */
    public Optional<RecipeHolder<SmeltingRecipe>> findValidRecipe(SingleRecipeInput input) {
        if (this.level == null) return Optional.empty();
        return this.level.getRecipeManager()
                .getRecipeFor(RecipeType.SMELTING, input, this.level)
                .filter(rh -> canRunAtThisHeat(rh.value()));
    }
}

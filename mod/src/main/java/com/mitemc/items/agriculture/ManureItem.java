package com.mitemc.items.agriculture;

import com.mitemc.blocks.crops.OnionCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.CropBlock;

/**
 * Manure: dual-purpose fertilizer.
 *
 *  1. If used on a blighted crop → clears the BLIGHTED flag. The mature crop becomes
 *     harvestable normally again.
 *  2. Otherwise behaves like vanilla bone meal (advance crop age) but only on
 *     {@link CropBlock} instances; cannot accelerate trees or grass like bone meal can.
 *
 * Manure also drops occasionally from cows and pigs (see AnimalManureHandler).
 */
public class ManureItem extends Item {

    public ManureItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        Level level = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Player player = ctx.getPlayer();

        // (1) Cure blight first — manure trumps growth on a blighted plant.
        if (state.getBlock() instanceof OnionCropBlock && state.getValue(OnionCropBlock.BLIGHTED)) {
            if (!level.isClientSide) {
                level.setBlock(pos, state.setValue(OnionCropBlock.BLIGHTED, false), 2);
                level.levelEvent(2005, pos, 0); // bone meal particle
            }
            ItemStack stack = ctx.getItemInHand();
            if (player == null || !player.getAbilities().instabuild) stack.shrink(1);
            return InteractionResult.SUCCESS;
        }

        // (2) Otherwise: bone-meal-like growth on crops only.
        if (state.getBlock() instanceof CropBlock) {
            if (BoneMealItem.growCrop(ctx.getItemInHand(), level, pos)) {
                if (!level.isClientSide) level.levelEvent(2005, pos, 0);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}

package com.mitemc.events;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * Core MITE rule: you can't break "real" blocks with your bare hands.
 *
 * When the player holds nothing (or a non-tool, non-tiered item) and tries to break a block:
 *   - Logs / wood          → speed = 0 (impossible)
 *   - Stone other than cobblestone → speed = 0
 *   - Metal blocks         → speed = 0
 *   - Ice / packed ice     → speed = 0
 *   - Cobblestone          → fast (vanilla speed, MITE convention)
 *   - Soil / grass / dirt  → 0.75× (slower, but possible — you can dig with hands)
 *
 * The hunger consequence: with low food the speed multiplier drops further.
 */
public final class BareHandRestrictionHandler {

    private BareHandRestrictionHandler() {}

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        if (player == null || player.isCreative()) return;

        ItemStack held = player.getMainHandItem();
        BlockState state = event.getState();
        Block block = state.getBlock();

        if (isCobblestoneFamily(block)) {
            // MITE keeps cobblestone fast even bare-hand
            if (event.getOriginalSpeed() < 1.0F) {
                event.setNewSpeed(20.0F);
            }
            return;
        }

        if (isToolHeld(held)) {
            // Player has a real tool — let vanilla speed handle it.
            // Hunger penalty: at <1 food, halve the speed.
            if (player.getFoodData().getFoodLevel() == 0 || player.getHealth() <= 1.0F) {
                event.setNewSpeed(event.getOriginalSpeed() * 0.5F);
            }
            return;
        }

        // Bare hand (or non-tool item). Apply MITE break-speed restrictions.
        if (state.is(BlockTags.LOGS) || state.is(BlockTags.PLANKS)) {
            event.setNewSpeed(0.0F);
            event.setCanceled(true);
            return;
        }

        if (isStoneNonCobble(state) || isMetalBlock(block) || isIceBlock(block)) {
            event.setNewSpeed(0.0F);
            event.setCanceled(true);
            return;
        }

        if (isSoilLike(state)) {
            event.setNewSpeed(event.getOriginalSpeed() * 0.75F);
            return;
        }

        // Block has no entity (so most simple blocks): break very slowly bare-hand.
        if (event.getOriginalSpeed() <= 1.0F) {
            event.setNewSpeed(event.getOriginalSpeed() * 0.05F);
        }
    }

    private static boolean isToolHeld(ItemStack stack) {
        if (stack.isEmpty()) return false;
        var item = stack.getItem();
        return item instanceof TieredItem
                || item instanceof DiggerItem
                || item instanceof PickaxeItem
                || item instanceof AxeItem
                || item instanceof ShovelItem
                || item instanceof HoeItem
                || item instanceof SwordItem
                || item instanceof ShearsItem;
    }

    private static boolean isCobblestoneFamily(Block block) {
        return block == Blocks.COBBLESTONE
                || block == Blocks.COBBLESTONE_SLAB
                || block == Blocks.COBBLESTONE_STAIRS
                || block == Blocks.COBBLESTONE_WALL
                || block == Blocks.MOSSY_COBBLESTONE
                || block == Blocks.MOSSY_COBBLESTONE_SLAB
                || block == Blocks.MOSSY_COBBLESTONE_STAIRS;
    }

    private static boolean isStoneNonCobble(BlockState state) {
        // Anything mineable_with_pickaxe is stone-class; we exclude cobblestone family explicitly above.
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE);
    }

    private static boolean isMetalBlock(Block block) {
        return block == Blocks.IRON_BLOCK
                || block == Blocks.GOLD_BLOCK
                || block == Blocks.COPPER_BLOCK
                || block == Blocks.NETHERITE_BLOCK
                || block == Blocks.IRON_BARS
                || block == Blocks.IRON_DOOR
                || block == Blocks.IRON_TRAPDOOR
                || block == Blocks.RAW_IRON_BLOCK
                || block == Blocks.RAW_GOLD_BLOCK
                || block == Blocks.RAW_COPPER_BLOCK;
    }

    private static boolean isIceBlock(Block block) {
        return block == Blocks.ICE
                || block == Blocks.PACKED_ICE
                || block == Blocks.BLUE_ICE
                || block == Blocks.FROSTED_ICE;
    }

    private static boolean isSoilLike(BlockState state) {
        return state.is(BlockTags.DIRT)
                || state.is(BlockTags.SAND)
                || state.is(Blocks.GRAVEL)
                || state.is(Blocks.GRASS_BLOCK)
                || state.is(Blocks.PODZOL)
                || state.is(Blocks.MYCELIUM);
    }
}

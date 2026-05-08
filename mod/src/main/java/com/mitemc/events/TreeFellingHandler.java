package com.mitemc.events;

import com.mitemc.registries.ModEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Tree Felling enchantment — when a log is broken with an axe carrying this enchant, chain-break
 * all connected logs of the same type (BFS, capped). Players get the drops; the axe's durability
 * costs are aggregated.
 */
public final class TreeFellingHandler {

    private static final int MAX_LOGS = 96; // safety cap so we don't fell biome-spanning oddities

    private TreeFellingHandler() {}

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;
        Player player = event.getPlayer();
        if (player == null || player.isCreative()) return;

        BlockState root = event.getState();
        if (!root.is(BlockTags.LOGS)) return;

        ItemStack tool = player.getMainHandItem();
        int level_ = ModEnchantments.mainHandLevel(player, ModEnchantments.TREE_FELLING);
        if (level_ <= 0) return;

        // BFS from origin, breaking every connected log of same type within MAX_LOGS.
        Set<BlockPos> visited = new HashSet<>();
        Deque<BlockPos> queue = new ArrayDeque<>();
        queue.add(event.getPos());
        visited.add(event.getPos());

        int felled = 0;
        while (!queue.isEmpty() && felled < MAX_LOGS) {
            BlockPos pos = queue.poll();
            BlockState s = level.getBlockState(pos);
            if (!s.is(root.getBlock())) continue;

            level.destroyBlock(pos, true, player); // drop items, aggregate durability
            felled++;
            tool.hurtAndBreak(1, player, net.minecraft.world.entity.EquipmentSlot.MAINHAND);
            if (tool.isEmpty()) break;

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dz = -1; dz <= 1; dz++) {
                        if (dx == 0 && dy == 0 && dz == 0) continue;
                        BlockPos n = pos.offset(dx, dy, dz);
                        if (visited.add(n)) queue.add(n);
                    }
                }
            }
        }
    }
}

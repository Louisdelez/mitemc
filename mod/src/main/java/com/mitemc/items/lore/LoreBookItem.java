package com.mitemc.items.lore;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * A lore book displays an Avernite-style narrative passage on right-click. The text is fully
 * translated via lang JSON keys; each book gets a {@code title} and a {@code body} key. The
 * body's translation may include {@code \n} so chat renders multiple lines.
 */
public class LoreBookItem extends Item {

    private final String key;

    /**
     * @param key short id matching the lang key — e.g., {@code origins}, {@code stone_age}.
     *            Final translation keys: {@code lore.mitemc.book.<key>.title} and
     *            {@code lore.mitemc.book.<key>.body}.
     */
    public LoreBookItem(String key, Properties properties) {
        super(properties.stacksTo(1));
        this.key = key;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            // Title — bold + accent
            player.displayClientMessage(
                    Component.translatable("lore.mitemc.book." + key + ".title")
                            .withStyle(ChatFormatting.GOLD, ChatFormatting.BOLD),
                    false);
            // Body — italic, normal color
            player.displayClientMessage(
                    Component.translatable("lore.mitemc.book." + key + ".body")
                            .withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY),
                    false);
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}

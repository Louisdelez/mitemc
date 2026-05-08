package com.mitemc.registries;

import com.mitemc.Constants;
import com.mitemc.items.agriculture.ManureItem;
import com.mitemc.items.agriculture.OnionItem;
import com.mitemc.items.lore.LoreBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Phase 1 foraging + Phase 2 raw materials and ingots + Phase 5 agriculture + Phase 7 lore books.
 * Tool items (50) are registered indirectly via {@link ModTools}, which uses the same DeferredRegister.
 */
public final class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    // ── Phase 1 ── Primitive foraging
    public static final DeferredHolder<Item, Item> FLINT_SHARD =
            ITEMS.registerSimpleItem("flint_shard", new Item.Properties());

    // ── Phase 2 ── Raw chunks (drop from ore blocks before smelting)
    public static final DeferredHolder<Item, Item> RAW_COPPER =
            ITEMS.registerSimpleItem("raw_copper_chunk", new Item.Properties());
    public static final DeferredHolder<Item, Item> RAW_SILVER =
            ITEMS.registerSimpleItem("raw_silver_chunk", new Item.Properties());
    public static final DeferredHolder<Item, Item> RAW_MITHRIL =
            ITEMS.registerSimpleItem("raw_mithril_chunk", new Item.Properties());
    public static final DeferredHolder<Item, Item> RAW_ADAMANTIUM =
            ITEMS.registerSimpleItem("raw_adamantium_chunk", new Item.Properties());

    // ── Phase 2 ── Ingots
    public static final DeferredHolder<Item, Item> COPPER_INGOT =
            ITEMS.registerSimpleItem("copper_ingot", new Item.Properties());
    public static final DeferredHolder<Item, Item> SILVER_INGOT =
            ITEMS.registerSimpleItem("silver_ingot", new Item.Properties());
    public static final DeferredHolder<Item, Item> MITHRIL_INGOT =
            ITEMS.registerSimpleItem("mithril_ingot", new Item.Properties());
    public static final DeferredHolder<Item, Item> ADAMANTIUM_INGOT =
            ITEMS.registerSimpleItem("adamantium_ingot", new Item.Properties());

    // ── Phase 5 ── Agriculture
    public static final DeferredHolder<Item, OnionItem> ONION =
            ITEMS.register("onion", () -> new OnionItem(new Item.Properties()));

    public static final DeferredHolder<Item, ItemNameBlockItem> ONION_SEEDS =
            ITEMS.register("onion_seeds",
                    () -> new ItemNameBlockItem(ModBlocks.ONION_CROP.get(), new Item.Properties()));

    public static final DeferredHolder<Item, ManureItem> MANURE =
            ITEMS.register("manure", () -> new ManureItem(new Item.Properties()));

    // ── Phase 7 ── Lore books
    public static final DeferredHolder<Item, LoreBookItem> LORE_BOOK_ORIGINS =
            ITEMS.register("lore_book_origins",
                    () -> new LoreBookItem("origins", new Item.Properties()));
    public static final DeferredHolder<Item, LoreBookItem> LORE_BOOK_STONE_AGE =
            ITEMS.register("lore_book_stone_age",
                    () -> new LoreBookItem("stone_age", new Item.Properties()));
    public static final DeferredHolder<Item, LoreBookItem> LORE_BOOK_FORGE =
            ITEMS.register("lore_book_forge",
                    () -> new LoreBookItem("forge", new Item.Properties()));
    public static final DeferredHolder<Item, LoreBookItem> LORE_BOOK_DEEP =
            ITEMS.register("lore_book_deep",
                    () -> new LoreBookItem("deep", new Item.Properties()));
    public static final DeferredHolder<Item, LoreBookItem> LORE_BOOK_MYTHIC =
            ITEMS.register("lore_book_mythic",
                    () -> new LoreBookItem("mythic", new Item.Properties()));

    private ModItems() {}
}

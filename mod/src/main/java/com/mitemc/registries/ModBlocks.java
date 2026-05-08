package com.mitemc.registries;

import com.mitemc.Constants;
import com.mitemc.blocks.crops.OnionCropBlock;
import com.mitemc.blocks.furnaces.FurnaceVariant;
import com.mitemc.blocks.furnaces.MitemcFurnaceBlock;
import com.mitemc.blocks.strongbox.IronStrongboxBlock;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);

    // ── Phase 2 ── Ores ───────────────────────────────────────────────────────────────────
    public static final DeferredBlock<Block> COPPER_ORE = BLOCKS.register("copper_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE).strength(3.0F, 3.0F)
                            .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SILVER_ORE = BLOCKS.register("silver_ore",
            () -> new DropExperienceBlock(UniformInt.of(0, 2),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE).strength(4.0F, 3.0F)
                            .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MITHRIL_ORE = BLOCKS.register("mithril_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE).strength(5.0F, 4.0F)
                            .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ADAMANTIUM_ORE = BLOCKS.register("adamantium_ore",
            () -> new DropExperienceBlock(UniformInt.of(4, 8),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.NETHER).strength(7.0F, 6.0F)
                            .sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops()));

    // ── Phase 3 ── Furnaces ───────────────────────────────────────────────────────────────
    public static final DeferredBlock<MitemcFurnaceBlock> CLAY_OVEN = BLOCKS.register("clay_oven",
            () -> new MitemcFurnaceBlock(FurnaceVariant.CLAY_OVEN,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.TERRACOTTA_ORANGE)
                            .strength(2.0F)
                            .sound(SoundType.STONE)
                            .lightLevel(s -> s.getValue(MitemcFurnaceBlock.LIT) ? 13 : 0)));

    public static final DeferredBlock<MitemcFurnaceBlock> SANDSTONE_OVEN = BLOCKS.register("sandstone_oven",
            () -> new MitemcFurnaceBlock(FurnaceVariant.SANDSTONE_OVEN,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.SAND)
                            .strength(2.5F)
                            .sound(SoundType.STONE)
                            .lightLevel(s -> s.getValue(MitemcFurnaceBlock.LIT) ? 13 : 0)));

    public static final DeferredBlock<MitemcFurnaceBlock> OBSIDIAN_FURNACE = BLOCKS.register("obsidian_furnace",
            () -> new MitemcFurnaceBlock(FurnaceVariant.OBSIDIAN_FURNACE,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLACK)
                            .strength(50.0F, 1200.0F)
                            .sound(SoundType.STONE)
                            .lightLevel(s -> s.getValue(MitemcFurnaceBlock.LIT) ? 14 : 0)));

    public static final DeferredBlock<MitemcFurnaceBlock> NETHERRACK_FURNACE = BLOCKS.register("netherrack_furnace",
            () -> new MitemcFurnaceBlock(FurnaceVariant.NETHERRACK_FURNACE,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.NETHER)
                            .strength(4.0F)
                            .sound(SoundType.NETHER_BRICKS)
                            .lightLevel(s -> s.getValue(MitemcFurnaceBlock.LIT) ? 15 : 0)));

    // ── Phase 5 ── Crops ───────────────────────────────────────────────────────────────────
    public static final DeferredBlock<OnionCropBlock> ONION_CROP = BLOCKS.register("onion_crop",
            () -> new OnionCropBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));

    // ── Phase 6 ── Strongbox ──────────────────────────────────────────────────────────────
    public static final DeferredBlock<IronStrongboxBlock> IRON_STRONGBOX = BLOCKS.register("iron_strongbox",
            () -> new IronStrongboxBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5.0F, 1200.0F)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));

    /** BlockItems for blocks so they appear in inventories and creative tabs. */
    public static void registerBlockItems(DeferredRegister.Items items) {
        items.register("copper_ore",         () -> new BlockItem(COPPER_ORE.get(),         new Item.Properties()));
        items.register("silver_ore",         () -> new BlockItem(SILVER_ORE.get(),         new Item.Properties()));
        items.register("mithril_ore",        () -> new BlockItem(MITHRIL_ORE.get(),        new Item.Properties()));
        items.register("adamantium_ore",     () -> new BlockItem(ADAMANTIUM_ORE.get(),     new Item.Properties()));

        items.register("clay_oven",          () -> new BlockItem(CLAY_OVEN.get(),          new Item.Properties()));
        items.register("sandstone_oven",     () -> new BlockItem(SANDSTONE_OVEN.get(),     new Item.Properties()));
        items.register("obsidian_furnace",   () -> new BlockItem(OBSIDIAN_FURNACE.get(),   new Item.Properties()));
        items.register("netherrack_furnace", () -> new BlockItem(NETHERRACK_FURNACE.get(), new Item.Properties()));

        items.register("iron_strongbox",     () -> new BlockItem(IRON_STRONGBOX.get(),     new Item.Properties().stacksTo(1)));
    }

    private ModBlocks() {}
}

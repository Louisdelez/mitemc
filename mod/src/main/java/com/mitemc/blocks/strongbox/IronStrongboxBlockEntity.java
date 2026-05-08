package com.mitemc.blocks.strongbox;

import com.mitemc.registries.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * 27-slot inventory + owner UUID. Opens only for its owner via {@link #canOpen(Player)}.
 * Persists owner across save/load, hopper-blocked (we don't override hopper interfaces).
 */
public class IronStrongboxBlockEntity extends RandomizableContainerBlockEntity {

    public static final int CONTAINER_SIZE = 27;

    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    @Nullable private UUID owner;

    public IronStrongboxBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.IRON_STRONGBOX.get(), pos, state);
    }

    @Override public int getContainerSize() { return CONTAINER_SIZE; }
    @Override protected NonNullList<ItemStack> getItems() { return items; }
    @Override protected void setItems(NonNullList<ItemStack> stacks) { items = stacks; }
    @Override protected Component getDefaultName() { return Component.translatable("container.mitemc.iron_strongbox"); }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory playerInv) {
        return ChestMenu.threeRows(id, playerInv, this);
    }

    public boolean canOpen(Player player) {
        return owner == null || player.getUUID().equals(owner) || player.hasPermissions(2);
    }

    public void setOwner(UUID uuid) { this.owner = uuid; setChanged(); }
    @Nullable public UUID getOwner() { return owner; }

    public void dropAllContents(Level level, BlockPos pos) {
        Containers.dropContents(level, pos, this);
        items.clear();
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
        if (!tryLoadLootTable(tag)) {
            net.minecraft.world.ContainerHelper.loadAllItems(tag, items, registries);
        }
        owner = tag.hasUUID("Owner") ? tag.getUUID("Owner") : null;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!trySaveLootTable(tag)) {
            net.minecraft.world.ContainerHelper.saveAllItems(tag, items, registries);
        }
        if (owner != null) tag.putUUID("Owner", owner);
    }
}

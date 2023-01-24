package net.yezon.theabyss.block.entity.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public abstract class AbyssContainerBlockEntity extends BlockEntity implements Container, MenuProvider {
    private final int containerSize;
    private LazyOptional<IItemHandler> itemHolder = this.createItemHolder();

    public AbyssContainerBlockEntity(Supplier<? extends BlockEntityType<?>> pType, BlockPos pPos, BlockState pBlockState, int containerSize) {
        super(pType.get(), pPos, pBlockState);
        this.containerSize = containerSize;
    }

    @Override
    public int getContainerSize() {
        return this.containerSize;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.getItems()) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.getItems());
    }
    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }

    protected void loadAdditional(CompoundTag pTag) {
    }

    @Override
    public void load(CompoundTag pTag) {
        this.printContainerDebug();
        this.clearContent();
        ContainerHelper.loadAllItems(pTag, this.getItems());
        this.loadAdditional(pTag);
        super.load(pTag);
    }

    @Override
    public void setChanged() {
        super.setChanged();
    }

    public abstract NonNullList<ItemStack> getItems();

    @Override
    public ItemStack getItem(int pSlot) {
        return this.getItems().get(pSlot);
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return ContainerHelper.removeItem(this.getItems(), pSlot, pAmount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return ContainerHelper.takeItem(this.getItems(), pSlot);
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {
        this.getItems().set(pSlot, pStack);
    }

    @Override
    public void clearContent() {
        this.getItems().clear();
    }

    @Override

    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return ForgeCapabilities.ITEM_HANDLER.orEmpty(cap, this.itemHolder);
    }

    private LazyOptional<IItemHandler> createItemHolder() {
        return LazyOptional.of(() -> new InvWrapper(this));
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.itemHolder.invalidate();
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        this.itemHolder = this.createItemHolder();
    }

    private void printContainerDebug() {
        System.out.printf("container [%s] | contains [%s] %n", Integer.toHexString(this.getItems().hashCode()), this.getItems());
    }
}

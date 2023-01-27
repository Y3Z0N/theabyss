package net.yezon.theabyss.world.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public abstract class TheAbyssContainerMenu extends AbstractContainerMenu {
    private int inventoryLabelX = 0;
    private int inventoryLabelY = 0;

    protected TheAbyssContainerMenu(@Nullable MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
    }

    public void setInventoryLabel(int x, int y) {
        this.inventoryLabelX = x;
        this.inventoryLabelY = y;
    }

    public int getInventoryLabelX() {
        return inventoryLabelX;
    }

    public int getInventoryLabelY() {
        return inventoryLabelY;
    }

    @Override
    public final Slot addSlot(Slot slot) {
        return super.addSlot(slot);
    }

    protected static void onResultSlotTaken(Container craftingContainer) {
        for (int i = 0; i < craftingContainer.getContainerSize(); i++) {
            if (craftingContainer.getItem(i).hasCraftingRemainingItem()) {
                ItemStack craftingRemain = craftingContainer.getItem(i).getCraftingRemainingItem();
                craftingContainer.setItem(i, craftingRemain);
            } else {
                craftingContainer.removeItem(i, 1);
            }
        }
    }
}

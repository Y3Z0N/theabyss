package net.yezon.theabyss.world.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.yezon.theabyss.block.entity.SomniumInfuserBlockEntity;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.init.TheabyssModMenus;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;

public class InfuserMenu extends TheAbyssContainerMenu {

    private final ContainerLevelAccess access;
    private final ContainerData containerData;

    public InfuserMenu(int id, Inventory inv) {
        this(id, inv, new SimpleContainer(SomniumInfuserBlockEntity.CONTAINER_SIZE), ContainerLevelAccess.NULL, new SimpleContainerData(SomniumInfuserBlockEntity.DATA_SIZE));
    }

    public InfuserMenu(int id, Inventory inv, Container container, ContainerLevelAccess access, ContainerData containerData) {
        super(TheabyssModMenus.INFUSER.get(), id);
        this.containerData = containerData;


        super.addSlot(ContainerAndScreenUtils.createFilteredSlot(container, 0, 31, 7, TheabyssModItems.SOMNIUM.get()));
        super.addSlot(ContainerAndScreenUtils.createFilteredSlot(container, 1, 75, 16, TheabyssModItems.LORAN_ENERGY.get()));
        super.addSlot(new Slot(container, 2, 23, 42));
        super.addSlot(new Slot(container, 3, 49, 50));
        super.addSlot(new Slot(container, 4, 101, 50));
        super.addSlot(new Slot(container, 5, 127, 42));
        super.addSlot(ContainerAndScreenUtils.createResultSlot(container, 6, 75, 59));

        ContainerAndScreenUtils.addPlayerInventorySlots(this, inv, 8, 88);
        this.access = access;
        super.addDataSlots(this.containerData);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, TheabyssModBlocks.SOMNIUM_INFUSER.get());
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < 7) {
                if (!this.moveItemStackTo(itemstack1, 7, this.slots.size(), true))
                    return ItemStack.EMPTY;
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (!this.moveItemStackTo(itemstack1, 0, 7, false)) {
                if (index < 7 + 27) {
                    if (!this.moveItemStackTo(itemstack1, 7 + 27, this.slots.size(), true))
                        return ItemStack.EMPTY;
                } else {
                    if (!this.moveItemStackTo(itemstack1, 7, 7 + 27, false))
                        return ItemStack.EMPTY;
                }
                return ItemStack.EMPTY;
            }
            if (itemstack1.getCount() == 0)
                slot.set(ItemStack.EMPTY);
            else
                slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount())
                return ItemStack.EMPTY;
            slot.onTake(playerIn, itemstack1);
        }
        return itemstack;
    }

    public int getProcessBarHeight() {
        return 0;
    }

    @Override
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
    }
}

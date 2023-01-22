package net.yezon.theabyss.world.inventory;

import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.init.TheabyssModMenus;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.recipes.impl.ArcaneStationRecipe;
import net.yezon.theabyss.utils.RecipeUtils;

import javax.annotation.Nullable;

public class ArcaneMenu extends AbstractContainerMenu {
    public static final int CONTAINER_SIZE = 9;
    private static final int RESULT_SLOT_INDEX = 9;
    private final SimpleContainer craftingContainer;
    private final SimpleContainer resultSlot;
    private final ContainerLevelAccess access;
    private final Player player;

    public ArcaneMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public ArcaneMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess access) {
        super(TheabyssModMenus.ARCANE.get(), pContainerId);
        this.access = access;
        this.craftingContainer = new SimpleContainer(CONTAINER_SIZE) {

            @Override
            public void setChanged() {
                slotsChanged(this);
            }
        };
        this.resultSlot = new SimpleContainer(1) {
            @Override
            public void setChanged() {
            }
        };
        this.player = pPlayerInventory.player;

        this.addCustomSlot(0, 44, 7);
        this.addCustomSlot(1, 71, 16);
        this.addCustomSlot(2, 80, 43);
        this.addCustomSlot(3, 71, 70);
        this.addCustomSlot(4, 44, 79);
        this.addCustomSlot(5, 17, 70);
        this.addCustomSlot(6, 8, 43);
        this.addCustomSlot(7, 17, 16);
        this.addCustomSlot(8, 44, 43);

        super.addSlot(new Slot(this.resultSlot, 0, 152, 43) {
            @Override
            public void onTake(Player pPlayer, ItemStack pStack) {
                //checkTakeAchievements(pStack);
                resultTaken();
                TheabyssMod.LOGGER.info("result slot taken [{}] in [{}]", pStack, pPlayer.level.isClientSide ? "CLIENT" : "SEVER");
                super.setChanged();
            }

            @Override
            protected void onQuickCraft(ItemStack pStack, int pAmount) {
                //this.resultTaken();
                TheabyssMod.LOGGER.info("result slot quick taken [{}]", pStack);
            }

            @Override
            public boolean mayPlace(ItemStack pStack) {
                return false;
            }

            private void resultTaken() {
                for (int i = 0; i < craftingContainer.getContainerSize(); i++) {
                    craftingContainer.removeItem(i, 1);
                }
            }
        });

        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                this.addSlot(new Slot(pPlayerInventory, sj + (si + 1) * 9, 8 + sj * 18, 112 + si * 18));
        for (int si = 0; si < 9; ++si)
            this.addSlot(new Slot(pPlayerInventory, si, 8 + si * 18, 170));

    }

    private void addCustomSlot(int index, int x, int y) {
        super.addSlot(new Slot(this.craftingContainer, index, x, y));
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < 10) {
                if (!this.moveItemStackTo(itemstack1, 10, this.slots.size(), true))
                    return ItemStack.EMPTY;
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (!this.moveItemStackTo(itemstack1, 0, 10, false)) {
                if (index < 10 + 27) {
                    if (!this.moveItemStackTo(itemstack1, 10 + 27, this.slots.size(), true))
                        return ItemStack.EMPTY;
                } else {
                    if (!this.moveItemStackTo(itemstack1, 10, 10 + 27, false))
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

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(access, pPlayer, TheabyssModBlocks.ARCANE_WORKBENCH.get());
    }

    @Override
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.access.execute(((level, blockPos) -> clearContainer(pPlayer, this.craftingContainer)));
    }

    @Override
    public void slotsChanged(Container pContainer) {
        this.access.execute((level, pos) -> updateGrid(level, player));
    }

    private void updateGrid(Level level, Player player) {
        if (!level.isClientSide()) {
            ServerPlayer serverPlayer = ((ServerPlayer) player);
            ItemStack itemStack = ItemStack.EMPTY;
            final @Nullable ArcaneStationRecipe recipe = RecipeUtils.getRecipeFor(level, AllRecipeTypes.ARCANE_CRAFTING, this.craftingContainer);

            if (recipe != null) {
                itemStack = recipe.assemble(this.craftingContainer);
            }

            this.resultSlot.setItem(0, itemStack);
            super.setRemoteSlot(RESULT_SLOT_INDEX, itemStack);
            serverPlayer.connection.send(new ClientboundContainerSetSlotPacket(containerId, super.incrementStateId(), RESULT_SLOT_INDEX, itemStack));
        }
    }
}

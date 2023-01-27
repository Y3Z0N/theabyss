package net.yezon.theabyss.world.inventory;

import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.init.TheabyssModMenus;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.recipes.impl.MortarAndPestleRecipe;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import net.yezon.theabyss.utils.RecipeUtils;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MortarMenu extends TheAbyssContainerMenu {
    public static final int CONTAINER_SIZE = 5;
    private final ContainerLevelAccess access;
    private final SimpleContainer craftingContainer;
    private final SimpleContainer resultContainer;
    private final Player player;

    public MortarMenu(int id, Inventory inv) {
        this(id, inv, ContainerLevelAccess.NULL);
    }

    public MortarMenu(int id, Inventory inv, ContainerLevelAccess access) {
        super(TheabyssModMenus.MORTAR.get(), id);
        this.access = access;
        this.player = inv.player;
        this.craftingContainer = new SimpleContainer(CONTAINER_SIZE) {
            @Override
            public void setChanged() {
                slotsChanged(this);
            }
        };
        this.resultContainer = new SimpleContainer(1) {
            @Override
            public void setChanged() {
            }
        };

        this.addCraftingSlot(0, 56, 25);
        this.addCraftingSlot(1, 38, 43);
        this.addCraftingSlot(2, 56, 43);
        this.addCraftingSlot(3, 74, 43);
        this.addCraftingSlot(4, 56, 61);

        super.addSlot(new Slot(this.resultContainer, 0, 134, 43) {
            @Override
            public boolean mayPlace(ItemStack pStack) {
                return false;
            }

            @Override
            public void onTake(Player pPlayer, ItemStack pStack) {
                resultTaken();
                super.setChanged();
            }

            @Override
            protected void onQuickCraft(ItemStack pStack, int pAmount) {
            }

            private void resultTaken() {
                onResultSlotTaken(craftingContainer);
            }
        });

        ContainerAndScreenUtils.addPlayerInventorySlots(this, inv, 8, 101);
    }

    @Override
    public void slotsChanged(Container pContainer) {
        this.access.execute((level, pos) -> gridUpdate(level, this.player));
    }

    private void addCraftingSlot(int index, int x, int y) {
        super.addSlot(new Slot(this.craftingContainer, index, x, y));
    }

    @Override
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.access.execute((level, pos) -> gridUpdate(level, pPlayer));
    }

    public void gridUpdate(Level level, Player player) {
        if (!level.isClientSide()) {
            ServerPlayer serverPlayer = ((ServerPlayer) player);
            ItemStack item = ItemStack.EMPTY;
            final @Nullable MortarAndPestleRecipe recipe = RecipeUtils.getRecipeFor(level, AllRecipeTypes.MORTAR_AND_PESTLE, this.craftingContainer);

            if (recipe != null) {
                item = recipe.assemble(this.craftingContainer);
            }

            this.resultContainer.setItem(0, item);
            super.setRemoteSlot(CONTAINER_SIZE, item);
            serverPlayer.connection.send(new ClientboundContainerSetSlotPacket(containerId, super.incrementStateId(), CONTAINER_SIZE, item));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, TheabyssModBlocks.MORTAR_AND_PESTLE.get());
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < 6) {
                if (!this.moveItemStackTo(itemstack1, 6, this.slots.size(), true))
                    return ItemStack.EMPTY;
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (!this.moveItemStackTo(itemstack1, 0, 6, false)) {
                if (index < 6 + 27) {
                    if (!this.moveItemStackTo(itemstack1, 6 + 27, this.slots.size(), true))
                        return ItemStack.EMPTY;
                } else {
                    if (!this.moveItemStackTo(itemstack1, 6, 6 + 27, false))
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
}

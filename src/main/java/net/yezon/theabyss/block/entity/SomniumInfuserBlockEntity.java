package net.yezon.theabyss.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.yezon.theabyss.block.entity.base.AbyssContainerBlockEntity;
import net.yezon.theabyss.block.entity.base.TickableBlockEntity;
import net.yezon.theabyss.init.TheabyssModBlockEntities;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.recipes.impl.SomniumInfusingRecipe;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import net.yezon.theabyss.utils.RecipeUtils;
import net.yezon.theabyss.world.inventory.InfuserMenu;
import org.jetbrains.annotations.Nullable;

public class SomniumInfuserBlockEntity extends AbyssContainerBlockEntity implements TickableBlockEntity {
    public static final int CONTAINER_SIZE = 7;
    private final int resultSlot = CONTAINER_SIZE - 1;
    public static final int DATA_SIZE = 2;
    public static final int DEFAULT_PROCESS_DURATION = 200;
    private final NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    private int processDuration = DEFAULT_PROCESS_DURATION;
    private int processTime = 0;
    private final ContainerData containerData = new ContainerData() {
        @Override
        public int get(int pIndex) {
            return pIndex == 0 ? processTime : processDuration;
        }

        @Override
        public void set(int pIndex, int pValue) {}

        @Override
        public int getCount() {
            return DATA_SIZE;
        }
    };

    public SomniumInfuserBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(TheabyssModBlockEntities.SOMNIUM_INFUSER, pPos, pBlockState, CONTAINER_SIZE);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public boolean canPlaceItem(int pIndex, ItemStack pStack) {
        return switch (pIndex) {
            case 0 -> pStack.is(TheabyssModItems.SOMNIUM.get());
            case 1 -> pStack.is(TheabyssModItems.LORAN_ENERGY.get());
            default -> pIndex != 6;
        };
    }

    @Override
    public void serverTick(Level level, BlockPos blockPos, BlockState state) {
        if (!this.canProcess()) {
            final @Nullable SomniumInfusingRecipe recipe = RecipeUtils.getRecipeFor(level, AllRecipeTypes.SOMNIUM_INFUSING, this);
            if (recipe != null && this.canStackOutput(recipe)) {
                if (this.isIdle()) {
                     this.processTime = 1;
                     this.processDuration = recipe.getProcessDuration();
                } else if (this.processTime >= this.processDuration) {
                    this.processRecipe(recipe);
                } else {
                    this.processTime++;
                }
            } else {
                resetTime();
            }
        } else {
            resetTime();
        }

        setChanged(level, blockPos, state);
    }



    private void processRecipe(SomniumInfusingRecipe recipe) {
        final ItemStack result = recipe.assemble(this);
        if (this.items.get(resultSlot).isEmpty()) {
            super.setItem(resultSlot, result);
        } else {
            this.items.get(resultSlot).grow(result.getCount());
        }

        for (int i = 0; i < this.items.size() - 1; i++) {
            ItemStack itemStack = items.get(i);
            if (itemStack.hasCraftingRemainingItem()) {
                ItemStack remainingItem = itemStack.getCraftingRemainingItem();
                this.items.set(i, remainingItem);
            } else {
                itemStack.shrink(1);
            }
        }

        this.resetTime();
    }

    private boolean canStackOutput(SomniumInfusingRecipe recipe) {

        if (!this.items.get(this.resultSlot).isEmpty()) {
            ItemStack resultItem = recipe.getResultItem();
            ItemStack resultSlot = this.getItem(this.resultSlot);

            if (resultItem.is(resultSlot.getItem())) {
                final int maxItemStack = Math.min(resultSlot.getMaxStackSize(), this.getMaxStackSize());
                final int remainSpace = maxItemStack - (resultSlot.getCount() + resultItem.getCount());
                return remainSpace > 0;
            } else {
                return false;
            }
        }

        return true;
    }

    private void resetTime() {
        this.processTime = 0;
        this.processDuration = DEFAULT_PROCESS_DURATION;
    }

    public boolean isIdle() {
        return this.processTime <= 0;
    }


    private boolean canProcess() {
        for (int i = 0; i < items.size() - 1; i++) {
            if (super.getItem(i).isEmpty()) {
                return true;
            }
        }

        return false;
    }

    @Nullable
    @Override
    public InfuserMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new InfuserMenu(pContainerId, pPlayerInventory, this, ContainerAndScreenUtils.createLevelAccess(this), this.containerData);
    }

    @Override
    public Component getDisplayName() {
        return TheabyssModBlocks.SOMNIUM_INFUSER.get().getName();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.putInt("processDuration", this.processDuration);
        pTag.putInt("processTime", this.processTime);
        super.saveAdditional(pTag);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag) {
        this.processDuration = pTag.getInt("processDuration");
        this.processTime = pTag.getInt("processTime");
    }
}

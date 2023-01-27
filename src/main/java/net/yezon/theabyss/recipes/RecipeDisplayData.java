package net.yezon.theabyss.recipes;

import com.google.common.base.Preconditions;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.ItemLike;
import net.yezon.theabyss.TheabyssMod;
import oshi.util.tuples.Pair;

import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author KhanhTypo
 */
public record RecipeDisplayData(ResourceLocation jeiPngName, int width, int height,
                                Supplier<? extends ItemLike> tabIcon,
                                @Nullable RecipeViewHolder recipeViewArea,
                                RecipeTransferHolder<? extends AbstractContainerMenu> recipeTransferHolder,
                                @Nullable AnimatedDrawableBuilder animatedDrawable,
                                List<Pair<Integer, Integer>> ingredientMapping, int resultX, int resultY) {
    public static class Builder {
        private final ResourceLocation imageLocation;
        private final int width;
        private final int height;
        private final Supplier<? extends ItemLike> tabIcon;
        private final List<Pair<Integer, Integer>> ingredientMapping;
        private RecipeViewHolder recipeViewArea;
        @Nullable
        private RecipeTransferHolder<? extends AbstractContainerMenu> recipeTransferHolder;
        @Nullable
        private AnimatedDrawableBuilder animatedDrawable;

        public Builder(String imageName, int width, int height, Supplier<? extends ItemLike> tabIcon) {
            this.imageLocation = TheabyssMod.location("textures/jei/" + imageName + (imageName.contains(".png") ? "" : ".png"));
            this.width = width;
            this.height = height;
            this.tabIcon = tabIcon;
            this.ingredientMapping = new LinkedList<>();
        }

        public static Builder builder(String imageName, int width, int height, Supplier<? extends ItemLike> tabIcon) {
            return new Builder(imageName, width, height, tabIcon);
        }

        public Builder addRecipeViewArea(Class<? extends AbstractContainerScreen<?>> screenClass, int x, int y) {
            return addRecipeViewArea(screenClass, x, y, 20, 20);
        }

        public Builder addRecipeViewArea(Class<? extends AbstractContainerScreen<?>> screenClass, int x, int y, int width, int height) {
            this.recipeViewArea = new RecipeViewHolder(screenClass, x, y, width, height);
            return this;
        }

        public <T extends AbstractContainerMenu> Builder addRecipeTransferHandler(Class<T> menuClass, Supplier<? extends MenuType<T>> menuType, int recipeSlotStart, int recipeSlotCount, int inventorySlotStart, int inventorySlotCount) {
            this.recipeTransferHolder = new RecipeTransferHolder<>(menuClass, menuType, recipeSlotStart, recipeSlotCount, inventorySlotStart, inventorySlotCount);
            return this;
        }

        public Builder addIngredient(int x, int y) {
            this.ingredientMapping.add(new Pair<>(x, y));
            return this;
        }

        public Builder addAnimatedDrawable(int u, int v, int width, int height, int x, int y, int tickPerCycle, AnimatedDrawableBuilder.StartFrom from, boolean inverted) {
            this.animatedDrawable = new AnimatedDrawableBuilder(u, v, width, height, x, y, tickPerCycle, from, inverted);
            return this;
        }

        public RecipeDisplayData construct(int resultSlotX, int resultSlotY) {
            Preconditions.checkNotNull(this.recipeViewArea, "Missing recipe view area");
            if (this.recipeTransferHolder == null)
                TheabyssMod.LOGGER.warn("Recipe transfer handler for [{}] is missing", this.imageLocation);
            return new RecipeDisplayData(this.imageLocation, this.width, this.height, this.tabIcon, this.recipeViewArea, this.recipeTransferHolder, this.animatedDrawable, this.ingredientMapping, resultSlotX, resultSlotY);
        }
    }

    public record RecipeViewHolder(Class<? extends AbstractContainerScreen<?>> screenClass, int x, int y, int width,
                                   int height) {
    }

    public record RecipeTransferHolder<T extends AbstractContainerMenu>(Class<T> menuClass,
                                                                        Supplier<? extends MenuType<T>> menuType,
                                                                        int recipeSlotStart, int recipeSlotCount,
                                                                        int inventorySlotStart,
                                                                        int inventorySlotCount) {
    }

    public record AnimatedDrawableBuilder(int u, int v, int width, int height, int x, int y, int tickPerCycle,
                                          StartFrom from,
                                          boolean inverted) {
        public enum StartFrom {
            TOP,
            BOTTOM,
            LEFT,
            RIGHT
        }
    }
}


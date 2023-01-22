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
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public record RecipeDisplayData(ResourceLocation jeiPngName, int width, int height, Supplier<? extends ItemLike> tabIcon,
                                RecipeViewHolder recipeViewArea,
                                RecipeTransferHolder<? extends AbstractContainerMenu> recipeTransferHolder, Map<Integer, Pair<Integer, Integer>> ingredientMapping, int resultX, int resultY) {
    public static class Builder {
        private final ResourceLocation imageLocation;
        private final int width;
        private final int height;
        private final Supplier<? extends ItemLike> tabIcon;
        private final HashMap<Integer, Pair<Integer, Integer>> ingredientMapping;
        private RecipeViewHolder recipeViewArea;
        @Nullable
        private RecipeTransferHolder<? extends AbstractContainerMenu> recipeTransferHolder;

        public Builder(String imageName, int width, int height, Supplier<? extends ItemLike> tabIcon) {
            this.imageLocation = TheabyssMod.location("textures/jei/" + imageName + (imageName.contains(".png") ? "" : ".png"));
            this.width = width;
            this.height = height;
            this.tabIcon = tabIcon;
            this.ingredientMapping = new HashMap<>();
        }

        public static Builder builder(String imageName, int width, int height, Supplier<? extends ItemLike> tabIcon) {
            return new Builder(imageName, width, height, tabIcon);
        }

        public Builder addRecipeViewArea(Class<? extends AbstractContainerScreen<?>> screenClass, int x, int y, int width, int height) {
            this.recipeViewArea = new RecipeViewHolder(screenClass, x, y, width, height);
            return this;
        }

        public <T extends AbstractContainerMenu> Builder addRecipeTransferHandler(Class<T> menuClass, Supplier<? extends MenuType<T>> menuType, int recipeSlotStart, int recipeSlotCount, int inventorySlotStart, int inventorySlotCount) {
            this.recipeTransferHolder = new RecipeTransferHolder<>(menuClass, menuType, recipeSlotStart, recipeSlotCount, inventorySlotStart, inventorySlotCount);
            return this;
        }

        public Builder addIngredient(int index, int x, int y) {
            this.ingredientMapping.put(index, new Pair<>(x, y));
            return this;
        }

        public RecipeDisplayData construct(int resultSlotX, int resultSlotY) {
            Preconditions.checkNotNull(this.recipeViewArea, "Missing recipe view area");
            if (this.recipeTransferHolder == null) TheabyssMod.LOGGER.warn("Recipe transfer handler for [{}] is missing", this.imageLocation);
            return new RecipeDisplayData(this.imageLocation, this.width, this.height, this.tabIcon, this.recipeViewArea, this.recipeTransferHolder, this.ingredientMapping, resultSlotX, resultSlotY);
        }
    }

    public record RecipeViewHolder(Class<? extends AbstractContainerScreen<?>> screenClass, int x, int y, int width, int height) {}
    public record RecipeTransferHolder<T extends AbstractContainerMenu>(Class<T> menuClass, Supplier<? extends MenuType<T>> menuType, int recipeSlotStart, int recipeSlotCount, int inventorySlotStart, int inventorySlotCount) {}
}


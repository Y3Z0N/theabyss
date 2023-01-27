package net.yezon.theabyss.recipes;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

/**
 * @author KhanhTypo
 */
public abstract class TheAbyssRecipe implements Recipe<Container> {
    protected final ResourceLocation recipeId;
    protected final ItemStack result;
    protected final AbyssRecipeType recipeType;
    protected final NonNullList<Ingredient> ingredients;

    public TheAbyssRecipe(ResourceLocation recipeId, ItemStack result, AbyssRecipeType recipeType, NonNullList<Ingredient> ingredients) {
        this.recipeId = recipeId;
        this.result = result;
        this.recipeType = recipeType;
        this.ingredients = ingredients;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return this.result;
    }

    @Override
    public ResourceLocation getId() {
        return this.recipeId;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return this.recipeType.getSerializer();
    }

    @Override
    public RecipeType<?> getType() {
        return this.recipeType.getVanillaType();
    }

    public abstract void toNetwork(FriendlyByteBuf buffer);
}

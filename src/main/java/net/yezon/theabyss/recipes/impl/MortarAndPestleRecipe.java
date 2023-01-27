package net.yezon.theabyss.recipes.impl;

import com.google.common.base.Preconditions;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.recipes.TheAbyssRecipe;
import net.yezon.theabyss.utils.RecipeUtils;

/**
 * @author KhanhTypo
 */
public class MortarAndPestleRecipe extends TheAbyssRecipe {
    public MortarAndPestleRecipe(ResourceLocation recipeId, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(recipeId, result, AllRecipeTypes.MORTAR_AND_PESTLE, ingredients);
        Preconditions.checkState(ingredients.size() == 5);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer) {
        buffer.writeItem(super.getResultItem());
        RecipeUtils.ingredientsToNetwork(buffer, super.getIngredients());
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        Preconditions.checkState(pContainer.getContainerSize() == this.ingredients.size());

        for (int i = 0; i < this.ingredients.size(); i++) {
            if (!ingredients.get(i).test(pContainer.getItem(i))) {
                return false;
            }
        }

        return true;
    }
}

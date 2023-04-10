package net.yezon.theabyss.recipes.impl;

import com.google.common.base.Preconditions;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.yezon.theabyss.data.tag.TheAbyssModItemTags;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.recipes.TheAbyssRecipe;

/**
 * @author KhanhTypo
 */
public class SomniumInfusingRecipe extends TheAbyssRecipe {
    public static final Ingredient SOMNIUM_FUEL = Ingredient.of(TheAbyssModItemTags.IS_SOMNIUM_FUEL);
    public static final Ingredient LORAN_FUEL = Ingredient.of(TheAbyssModItemTags.IS_LORAN_FUEL);
    private final int processTime;

    public SomniumInfusingRecipe(ResourceLocation recipeId, ItemStack result, NonNullList<Ingredient> ingredients, int processTime) {
        super(recipeId, result, AllRecipeTypes.SOMNIUM_INFUSING, ingredients);
        this.processTime = processTime;
        Preconditions.checkState(ingredients.size() == 6, "Somnium Infusing ingredients must have 4 ingredients");
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        for (int i = 0; i < 6; i++) {
            if (!super.ingredients.get(i).test(pContainer.getItem(i))) {
                return false;
            }
        }

        return true;
    }

    public int getProcessDuration() {
        return this.processTime;
    }
}

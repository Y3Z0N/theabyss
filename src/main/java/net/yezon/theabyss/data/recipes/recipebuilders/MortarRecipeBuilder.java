package net.yezon.theabyss.data.recipes.recipebuilders;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.recipes.AllRecipeTypes;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author KhanhTypo
 */
@SuppressWarnings("unused")
public class MortarRecipeBuilder extends TheAbyssRecipeBuilder {
    private final List<Ingredient> ingredients;

    protected MortarRecipeBuilder(ItemStack result, List<Ingredient> ingredients) {
        super(result, AllRecipeTypes.MORTAR_AND_PESTLE);
        this.ingredients = ingredients;
        Preconditions.checkState(ingredients.size() == 5);
        super.unlockedBy("has_mortar_and_pestle", InventoryChangeTrigger.TriggerInstance.hasItems(TheabyssModBlocks.MORTAR_AND_PESTLE.get()));
    }

    public static void buildTwoInputs(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, ItemStack result, Ingredient bottle, Ingredient ingredient1, Ingredient ingredient2) {
        final ResourceLocation alternative = recipeId != null ? new ResourceLocation(recipeId.getNamespace(), recipeId.getPath() + "_alternative") : TheabyssMod.location(RecipeBuilder.getDefaultRecipeId(result.getItem()).getPath() + "_alternative");

        buildRecipe(consumer, alternative, result, ingredient2, ingredient1, bottle, ingredient1, ingredient2);
        buildRecipe(consumer, recipeId, result, ingredient1, ingredient2, bottle, ingredient2, ingredient1);
    }

    public static void buildOneInput(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, ItemStack result, Ingredient bottle, Ingredient ingredient) {
        buildRecipe(consumer, recipeId, result, ingredient, ingredient, bottle, ingredient, ingredient);
    }

    public static void build(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, ItemStack result, Ingredient bottle, Ingredient ingredient1, Ingredient ingredient2, Ingredient ingredient3, Ingredient ingredient4) {
        buildRecipe(consumer, recipeId, result, bottle, ingredient1, ingredient2, bottle, ingredient3, ingredient4);
    }

    private static void buildRecipe(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, ItemStack itemStack, Ingredient... ingredients) {
        saveRecipe(new MortarRecipeBuilder(itemStack, List.of(ingredients)), consumer, recipeId);
    }

    @Override
    protected void toJson(JsonObject jsonObject) {
        final JsonArray array = new JsonArray();
        for (Ingredient ingredient : ingredients) {
            array.add(ingredient.toJson());
        }
        jsonObject.add("ingredients", array);
    }
}

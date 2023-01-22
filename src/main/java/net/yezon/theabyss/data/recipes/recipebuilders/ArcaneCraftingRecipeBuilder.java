package net.yezon.theabyss.data.recipes.recipebuilders;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.recipes.impl.ArcaneStationRecipe;
import net.yezon.theabyss.utils.RecipeUtils;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class ArcaneCraftingRecipeBuilder extends TheAbyssRecipeBuilder {
    private final ArcaneStationRecipe.RecipeMode shape;
    private final List<Ingredient> ingredients;
    private final Ingredient center;

    public ArcaneCraftingRecipeBuilder(ArcaneStationRecipe.RecipeMode shape, List<Ingredient> ingredients, Ingredient center, ItemStack result) {
        super(result, AllRecipeTypes.ARCANE_CRAFTING);
        this.shape = shape;
        this.ingredients = ingredients;
        this.center = center;
        super.unlockedBy("on_arcane_table_crafted", InventoryChangeTrigger.TriggerInstance.hasItems(TheabyssModBlocks.ARCANE_WORKBENCH.get()));
    }

    public static void buildHalf(Consumer<FinishedRecipe> finishedRecipe, @Nullable ResourceLocation recipeId, ItemStack result, ItemLike center, ItemLike ingredient1, ItemLike ingredient2) {
        final ResourceLocation alternativeId = TheabyssMod.location((recipeId != null ? recipeId.getPath() : RecipeUtils.getItemId(result).getPath()) + "_mirrored");

        build(finishedRecipe, alternativeId, result, center, ArcaneStationRecipe.RecipeMode.HALF, ingredient2, ingredient1);
        build(finishedRecipe, recipeId, result, center, ArcaneStationRecipe.RecipeMode.HALF, ingredient1, ingredient2);
    }

    public static void buildFullCircle(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, ItemStack result, ItemLike center, ItemLike ingredient) {
        build(consumer, recipeId, result, center, ArcaneStationRecipe.RecipeMode.FILL, ingredient);
    }

    public static void buildTwoInputs(Consumer<FinishedRecipe> finishedRecipe, @Nullable ResourceLocation recipeId, ItemStack result, ItemLike center, ItemLike ingredient1, ItemLike ingredient2) {
        final ResourceLocation alternativeId = TheabyssMod.location((recipeId != null ? recipeId.getPath() : RecipeUtils.getItemId(result).getPath()) + "_mirrored");

        build(finishedRecipe, alternativeId, result, center, ArcaneStationRecipe.RecipeMode.TWO_INGREDIENTS, ingredient2, ingredient1);
        build(finishedRecipe, recipeId, result, center, ArcaneStationRecipe.RecipeMode.TWO_INGREDIENTS, ingredient1, ingredient2);
    }

    public static void build(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, ItemStack result, ItemLike center, ItemLike... ingredients) {
        build(consumer, recipeId, result, center, ArcaneStationRecipe.RecipeMode.NONE, ingredients);
    }

    private static void build(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, ItemStack result, ItemLike center, ArcaneStationRecipe.RecipeMode shape, ItemLike... ingredients) {
        final ArcaneCraftingRecipeBuilder recipeBuilder = new ArcaneCraftingRecipeBuilder(shape, Arrays.stream(ingredients).map(Ingredient::of).toList(), Ingredient.of(center), result);
        saveRecipe(recipeBuilder, consumer, recipeId);
    }


    @Override
    protected void toJson(JsonObject jsonObject) {
        jsonObject.add("core", this.center.toJson());
        this.shape.toJson(jsonObject, ingredients);
        RecipeUtils.writeResultToJson(jsonObject, super.getRecipeResult());
    }
}

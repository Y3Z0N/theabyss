package net.yezon.theabyss.data.recipes.recipebuilders;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.block.entity.SomniumInfuserBlockEntity;
import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.recipes.AllRecipeTypes;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class SomniumInfusingRecipeBuilder extends TheAbyssRecipeBuilder {
    private final List<Ingredient> ingredients;
    private final int processTime;

    protected SomniumInfusingRecipeBuilder(ItemStack result, List<Ingredient> ingredients) {
        this(result, ingredients, SomniumInfuserBlockEntity.DEFAULT_PROCESS_DURATION);
    }

    protected SomniumInfusingRecipeBuilder(ItemStack result, List<Ingredient> ingredients, int processTime) {
        super(result, AllRecipeTypes.SOMNIUM_INFUSING);
        this.processTime = processTime;
        Preconditions.checkState(ingredients.size() == 4);
        this.ingredients = ingredients;
        super.unlockedBy("has_somnium_infuser", InventoryChangeTrigger.TriggerInstance.hasItems(TheabyssModItems.SOMNIUM_INFUSER.get()));
    }

    public static void buildOneInput(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, RegistryObject<? extends ItemLike> result, Ingredient ingredient) {
        build(consumer, recipeId, result, ingredient, ingredient, ingredient, ingredient);
    }

    public static void buildTwoSidesInput(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, RegistryObject<? extends ItemLike> result, Ingredient ingredient1, Ingredient ingredient2) {
        final ResourceLocation alternative = recipeId != null ? new ResourceLocation(recipeId.getNamespace(), recipeId.getPath() + "_alt") : TheabyssMod.location(result.getId() + "_alt");

        build(consumer, alternative, result, ingredient2, ingredient2, ingredient1, ingredient1);
        build(consumer, recipeId, result, ingredient1, ingredient1, ingredient2, ingredient2);
    }

    public static void buildOneInput(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, int processTime, RegistryObject<? extends ItemLike> result, Ingredient ingredient) {
        build(consumer, recipeId, result, processTime, ingredient, ingredient, ingredient, ingredient);
    }

    public static void buildTwoSidesInput(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, int processTime, RegistryObject<? extends ItemLike> result, Ingredient ingredient1, Ingredient ingredient2) {
        final ResourceLocation alternative = recipeId != null ? new ResourceLocation(recipeId.getNamespace(), recipeId.getPath() + "_alt") : TheabyssMod.location(result.getId() + "_alt");

        build(consumer, alternative, result, processTime, ingredient2, ingredient2, ingredient1, ingredient1);
        build(consumer, recipeId, result, processTime, ingredient1, ingredient1, ingredient2, ingredient2);
    }

    public static void buildTwoInputs(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, RegistryObject<? extends ItemLike> result, Ingredient ingredient1, Ingredient ingredient2) {
        final ResourceLocation alternative = recipeId != null ? new ResourceLocation(recipeId.getNamespace(), recipeId.getPath() + "_alt") : TheabyssMod.location(result.getId().getPath() + "_alt");

        build(consumer, alternative, result, ingredient2, ingredient1, ingredient2, ingredient1);
        build(consumer, recipeId, result, ingredient1, ingredient2, ingredient1, ingredient2);
    }

    public static void buildTwoInputs(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, int processTime, RegistryObject<? extends ItemLike> result, Ingredient ingredient1, Ingredient ingredient2) {
        final ResourceLocation alternative = recipeId != null ? new ResourceLocation(recipeId.getNamespace(), recipeId.getPath() + "_alt") : TheabyssMod.location(result.getId().getPath() + "_alt");

        build(consumer, alternative, result, processTime, ingredient2, ingredient1, ingredient2, ingredient1);
        build(consumer, recipeId, result, processTime, ingredient1, ingredient2, ingredient1, ingredient2);
    }


    public static void build(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, Supplier<? extends ItemLike> result, Ingredient... ingredients) {
        build(consumer, recipeId, result, SomniumInfuserBlockEntity.DEFAULT_PROCESS_DURATION, ingredients);
    }

    public static void build(Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId, Supplier<? extends ItemLike> result, int processTime, Ingredient... ingredients) {
        final SomniumInfusingRecipeBuilder builder = new SomniumInfusingRecipeBuilder(new ItemStack(result.get()), Arrays.asList(ingredients), processTime);
        saveRecipe(builder, consumer, recipeId);
    }


    @Override
    protected void toJson(JsonObject jsonObject) {
        final JsonArray array = new JsonArray(4);
        for (Ingredient ingredient : ingredients) {
            array.add(ingredient.toJson());
        }
        jsonObject.add("ingredients", array);
        jsonObject.addProperty("process_time", this.processTime);
    }
}

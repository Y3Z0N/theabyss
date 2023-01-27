package net.yezon.theabyss.recipes.impl;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.yezon.theabyss.recipes.AllRecipeTypes;

import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;

/**
 * @author KhanhTypo
 */
public class ArcaneStationRecipe implements Recipe<Container> {

    //0 -> 7 is the round
    private final NonNullList<Ingredient> ingredients;
    private final Ingredient core;
    private final ResourceLocation id;
    private final ItemStack result;

    public ArcaneStationRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, Ingredient core, ItemStack result) {
        this.ingredients = ingredients;
        this.core = core;
        this.id = id;
        this.result = result;

        Preconditions.checkState(ingredients.size() == 9);
        ingredients.set(ingredients.size() - 1, this.core);
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        for (int i = 0; i < 8; i++) {
            if (!this.ingredients.get(i).test(pContainer.getItem(i))) return false;
        }

        return this.core.test(pContainer.getItem(8));
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
        return this.result.copy();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return AllRecipeTypes.ARCANE_CRAFTING.getSerializer();
    }

    @Override
    public RecipeType<?> getType() {
        return AllRecipeTypes.ARCANE_CRAFTING.getVanillaType();
    }

    public Ingredient getCenterIngredient() {
        return this.core;
    }

    //FOR SERIALIZING AND DATA-GEN ONLY
    public enum RecipeMode {
        FILL((jsonObject, list) -> {
            Preconditions.checkState(jsonObject.has("ingredient"), "Expected to find an 'ingredient', but not found");
            list.replaceAll(ignored -> Ingredient.fromJson(jsonObject.getAsJsonObject("ingredient")));
        },
                (ingredients, jsonObject) -> {
            Preconditions.checkState(ingredients.size() == 1);
            jsonObject.add("ingredient", ingredients.get(0).toJson());
                }),
        HALF((jsonObject, list) -> {
            Preconditions.checkState(jsonObject.has("first_half") && jsonObject.has("second_half"), "Expected to find 'first_half' and 'second_half', but either of or both is missing");
            for (int i = 0; i < 8; i++) {
                list.set(i, Ingredient.fromJson(jsonObject.getAsJsonObject(i < 4 ? "first_half" : "second_half")));
            }
        },
                (ingredients, jsonObject) -> {
            Preconditions.checkState(ingredients.size() == 2, "Ingredient list just need 2 members for 2 half of the circle, but found " + ingredients.size() + " member(s)");
            jsonObject.add("first_half", ingredients.get(0).toJson());
            jsonObject.add("second_half", ingredients.get(1).toJson());
                }),
        TWO_INGREDIENTS((jsonObject, list) -> {
            Preconditions.checkState(jsonObject.has("first") && jsonObject.has("second"), "Expected to find the 'first' and 'second', but either or both of them is missing");
            for (int i = 0; i < 8; i++) {
                switch (i) {
                    case 0, 2, 4, 6 -> list.set(i, Ingredient.fromJson(jsonObject.getAsJsonObject("first")));
                    case 1, 3, 5, 7 -> list.set(i, Ingredient.fromJson(jsonObject.getAsJsonObject("second")));
                }
            }
        },
                (ingredients, jsonObject) -> {
                    Preconditions.checkState(ingredients.size() == 2, "Ingredient list just need 2 members for 2 half of the circle, but found " + ingredients.size()  + " member(s)");
                    jsonObject.add("first", ingredients.get(0).toJson());
                    jsonObject.add("second", ingredients.get(1).toJson());
                }),

        NONE((jsonObject, list) -> {

        },
                (ingredients, jsonObject) -> {});

        private final BiConsumer<JsonObject, NonNullList<Ingredient>> reader;
        private final BiConsumer<List<Ingredient>, JsonObject> ingredientWriter;

        RecipeMode(BiConsumer<JsonObject, NonNullList<Ingredient>> reader, BiConsumer<List<Ingredient>, JsonObject> ingredientWriter) {
            this.reader = reader;
            this.ingredientWriter = ingredientWriter;
        }

        public static NonNullList<Ingredient> readFromJson(JsonObject modeJson) {
            Preconditions.checkState(!modeJson.isJsonNull(), "JsonObject for recipe 'mode' is missing");
            Preconditions.checkState(modeJson.has("name"), "recipe mode needs a name, but it is missing");
            final NonNullList<Ingredient> ingredients = NonNullList.withSize(9, Ingredient.EMPTY);
            final RecipeMode recipeMode = valueOf(GsonHelper.getAsString(modeJson, "name").toUpperCase(Locale.ROOT));
            recipeMode.reader.accept(modeJson, ingredients);
            return ingredients;
        }

        public void toJson(JsonObject jsonObject, List<Ingredient> ingredients) {
            final JsonObject modeObject = new JsonObject();
            modeObject.addProperty("name", this.name());
            this.ingredientWriter.accept(ingredients, modeObject);
            jsonObject.add("mode", modeObject);
        }
    }
}

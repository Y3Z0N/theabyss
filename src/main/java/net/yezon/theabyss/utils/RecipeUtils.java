package net.yezon.theabyss.utils;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.yezon.theabyss.block.entity.SomniumInfuserBlockEntity;
import net.yezon.theabyss.recipes.AbyssRecipeType;
import net.yezon.theabyss.recipes.impl.ArcaneStationRecipe;
import net.yezon.theabyss.recipes.impl.SomniumInfusingRecipe;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public final class RecipeUtils {
    private RecipeUtils() {
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public static <T extends Container, R extends Recipe<T>> R getRecipeFor(@Nullable Level level, AbyssRecipeType recipeType, T container) {
        Preconditions.checkNotNull(level);
        RecipeManager sidedRecipeManager = level.isClientSide() ? level.getRecipeManager() : ((ServerLevel) level).getServer().getRecipeManager();
        return (R) sidedRecipeManager.getRecipeFor(recipeType.getVanillaType(), container, level).orElse(null);
    }

    public static RecipeSerializer<ArcaneStationRecipe> createArcaneStationSerializer() {
        return new RecipeSerializer<>() {
            @Override
            public ArcaneStationRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
                final ItemStack result = ShapedRecipe.itemStackFromJson(pSerializedRecipe.getAsJsonObject("result"));
                final Ingredient core = Ingredient.fromJson(pSerializedRecipe.getAsJsonObject("core"));
                final NonNullList<Ingredient> ingredients = ArcaneStationRecipe.RecipeMode.readFromJson(pSerializedRecipe.getAsJsonObject("mode"));

                return new ArcaneStationRecipe(pRecipeId, ingredients, core, result);
            }

            @Override
            public ArcaneStationRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
                return new ArcaneStationRecipe(pRecipeId, ingredientsFromNetwork(pBuffer, 8), Ingredient.fromNetwork(pBuffer), pBuffer.readItem());
            }

            @Override
            public void toNetwork(FriendlyByteBuf pBuffer, ArcaneStationRecipe pRecipe) {
                ingredientsToNetwork(pBuffer, pRecipe.getIngredients());
                pRecipe.getCenterIngredient().toNetwork(pBuffer);
            }
        };
    }

    private static NonNullList<Ingredient> ingredientsFromNetwork(FriendlyByteBuf buffer, int size) {
        final NonNullList<Ingredient> ingredients = NonNullList.withSize(size, Ingredient.EMPTY);

        ingredients.replaceAll(ignored -> Ingredient.fromNetwork(buffer));

        return ingredients;
    }

    public static void ingredientsToNetwork(FriendlyByteBuf buffer, NonNullList<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            ingredient.toNetwork(buffer);
        }
    }

    public static JsonObject itemStackToJson(ItemStack itemStack) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(itemStack.getItem())).toString());
        if (itemStack.getCount() > 1) jsonObject.addProperty("count", itemStack.getCount());
        return jsonObject;
    }

    public static void writeResultToJson(JsonObject jsonObject, ItemStack itemStack) {
        jsonObject.add("result", itemStackToJson(itemStack));
    }

    public static ResourceLocation getItemId(ItemStack itemStack) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(itemStack.getItem()));
    }

    @SuppressWarnings("SameParameterValue")
    private static NonNullList<Ingredient> ingredientsFromJson(JsonObject pJsonObject, int expectedSize) {
        final JsonElement jsonElement = pJsonObject.get("ingredients");
        Preconditions.checkState(!jsonElement.isJsonNull() && jsonElement.isJsonArray());
        final JsonArray ingredientArray = jsonElement.getAsJsonArray();
        Preconditions.checkState(ingredientArray.size() == expectedSize);
        final NonNullList<Ingredient> ingredients = NonNullList.withSize(expectedSize, Ingredient.EMPTY);

        for (int i = 0; i < ingredientArray.size(); i++) {
            ingredients.set(i, Ingredient.fromJson(ingredientArray.get(i)));
        }

        return ingredients;
    }

    public static RecipeSerializer<SomniumInfusingRecipe> createSomniumInfusingSerializer() {
        return new RecipeSerializer<>() {
            @Override
            public SomniumInfusingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
                final NonNullList<Ingredient> ingredients = NonNullList.withSize(6, Ingredient.EMPTY);
                ingredients.set(0, SomniumInfusingRecipe.SOMNIUM_FUEL);
                ingredients.set(1, SomniumInfusingRecipe.LORAN_FUEL);
                final List<Ingredient> ingredientList = ingredientsFromJson(pSerializedRecipe, 4);
                for (int i = 0; i < ingredientList.size(); i++) {
                    ingredients.set(i + 2, ingredientList.get(i));
                }


                final ItemStack result = ShapedRecipe.itemStackFromJson(pSerializedRecipe.getAsJsonObject("result"));
                final int processTime = GsonHelper.getAsInt(pSerializedRecipe, "process_time", SomniumInfuserBlockEntity.DEFAULT_PROCESS_DURATION);
                return new SomniumInfusingRecipe(pRecipeId, result, ingredients, processTime);
            }

            @Override
            public SomniumInfusingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
                final NonNullList<Ingredient> ingredient = ingredientsFromNetwork(pBuffer, 4);
                final ItemStack result = pBuffer.readItem();
                final int processTime = pBuffer.readInt();
                return new SomniumInfusingRecipe(pRecipeId, result, ingredient, processTime);
            }

            @Override
            public void toNetwork(FriendlyByteBuf pBuffer, SomniumInfusingRecipe pRecipe) {
                pRecipe.toNetwork(pBuffer);
            }
        };
    }
}

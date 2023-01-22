package net.yezon.theabyss.utils;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.yezon.theabyss.recipes.AbyssRecipeType;
import net.yezon.theabyss.recipes.impl.ArcaneStationRecipe;

import javax.annotation.Nullable;
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
                final ItemStack result = CraftingHelper.getItemStack(pSerializedRecipe.getAsJsonObject("result"), false);
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

    private static void ingredientsToNetwork(FriendlyByteBuf buffer, NonNullList<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            ingredient.toNetwork(buffer);
        }
    }

    private static void ensurePresent(JsonObject json, String memberName) {
        ensureValidJsonElement(json.has(memberName), memberName + " is not present");
    }

    private static void ensureValidJsonElement(boolean condition, @Nullable String errMessage) {
        if (!condition) throw new IllegalStateException(errMessage);
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
}

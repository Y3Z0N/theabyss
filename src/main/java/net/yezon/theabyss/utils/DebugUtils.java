package net.yezon.theabyss.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.yezon.theabyss.TheabyssMod;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class DebugUtils {
    private static final Logger LOGGER = TheabyssMod.LOGGER;

    public static void printStackTraceToLog(Throwable exception) {
        LOGGER.info("---- ABYSS STACK TRACE --- \n {}", exception.getMessage());
        var traces = exception.getStackTrace();
        for (StackTraceElement trace : traces) {
            LOGGER.info(trace.toString());
        }
        LOGGER.info("-------------");
    }

    public static void ingredientUploaded(FriendlyByteBuf buffer, Ingredient ingredient) {
        LOGGER.info("Uploaded : {} - Buffer Size : {}", ingredientToString(ingredient), buffer.capacity());
    }

    public static void ingredientLoaded(FriendlyByteBuf buffer, Ingredient ingredient) {
        LOGGER.info("Loading Ingredient {} at buffer index : {}", ingredientToString(ingredient), buffer.readerIndex());
    }

    private static String ingredientToString(Ingredient ingredient) {
        JsonElement element = ingredient.toJson();
        if (element.isJsonObject()) {
            JsonObject object = element.getAsJsonObject();
            if (object.has("tag")) {
                return "Tag Ingredient [%s]".formatted(object.getAsJsonPrimitive("tag").getAsString());
            } else if (object.has("item")) {
                return "Item Ingredient [%s]".formatted(object.getAsJsonPrimitive("item").getAsString());
            } else if (object.has("items")) {
                return "Multiple Item Ingredients [%s]".formatted(object.getAsJsonArray("items").toString());
            }
        }

        return "Empty Ingredient";
    }

    public static void dumpRecipeInfo(List<Recipe<?>> recipes) {
        final SortedMap<RecipeType<?>, Integer> dumpInfo = new TreeMap<>(Comparator.comparing(Object::toString));
        LOGGER.info("----- Recipe Packet Info -----");
        for (Recipe<?> recipe : recipes) {
            dumpInfo.putIfAbsent(recipe.getType(), 1);
            dumpInfo.computeIfPresent(recipe.getType(), (recipeType, integer) -> integer + 1);
        }

        dumpInfo.forEach((recipeType, integer) -> LOGGER.info("Type {} - Loaded {} recipes", recipeType.toString(), integer));
        LOGGER.info("------------------------------");
    }
}
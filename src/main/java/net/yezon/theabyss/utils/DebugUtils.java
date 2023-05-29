package net.yezon.theabyss.utils;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.yezon.theabyss.TheabyssMod;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class DebugUtils {
    private static final Logger LOGGER = TheabyssMod.LOGGER;

    public static void printStackTraceToLog(Throwable exception) {
        LOGGER.error("Exception caught !", exception);
    }

    public static void printStackTrace(StackTraceElement... traces) {
        LOGGER.info("-------------");
        for (StackTraceElement trace : traces) {
            LOGGER.info(trace.toString());
        }
        LOGGER.info("-------------");
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
package net.yezon.theabyss.recipes;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ModRecipeCategories {
    public static final Map<RecipeBookType, RecipeBookCategories> CATEGORIES_LIST_MAP = new HashMap<>();
    public static final RecipeBookType ARCANE_CRAFTING = RecipeBookType.create("arcane_crafting");
    public static final RecipeBookType MORTAR_AND_PESTLE = RecipeBookType.create("mortar_and_pestle");
    public static final RecipeBookType SOMNIUM_INFUSING = RecipeBookType.create("somnium_infusing");

    @SubscribeEvent
    public static void registerCategory(RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(ARCANE_CRAFTING, List.of(Objects.requireNonNull(CATEGORIES_LIST_MAP.put(ARCANE_CRAFTING, RecipeBookCategories.create("arcane_category", new ItemStack(AllRecipeTypes.ARCANE_CRAFTING.getDisplayData().tabIcon().get()))))));
        event.registerBookCategories(MORTAR_AND_PESTLE, List.of(Objects.requireNonNull(CATEGORIES_LIST_MAP.put(MORTAR_AND_PESTLE, RecipeBookCategories.create("mortar_category", new ItemStack(AllRecipeTypes.MORTAR_AND_PESTLE.getDisplayData().tabIcon().get()))))));
        event.registerBookCategories(SOMNIUM_INFUSING, List.of(Objects.requireNonNull(CATEGORIES_LIST_MAP.put(SOMNIUM_INFUSING, (RecipeBookCategories.create("somnium_category", new ItemStack(AllRecipeTypes.SOMNIUM_INFUSING.getDisplayData().tabIcon().get())))))));

        event.registerRecipeCategoryFinder(AllRecipeTypes.ARCANE_CRAFTING.getVanillaType(), recipe -> CATEGORIES_LIST_MAP.get(ARCANE_CRAFTING));
        event.registerRecipeCategoryFinder(AllRecipeTypes.MORTAR_AND_PESTLE.getVanillaType(), recipe -> CATEGORIES_LIST_MAP.get(MORTAR_AND_PESTLE));
        event.registerRecipeCategoryFinder(AllRecipeTypes.SOMNIUM_INFUSING.getVanillaType(), recipe -> CATEGORIES_LIST_MAP.get(SOMNIUM_INFUSING));
    }
}

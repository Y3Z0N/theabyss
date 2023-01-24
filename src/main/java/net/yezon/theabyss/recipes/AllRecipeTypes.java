package net.yezon.theabyss.recipes;

import net.minecraft.network.chat.Component;
import net.yezon.theabyss.client.gui.ArcaneScreen;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.init.TheabyssModMenus;
import net.yezon.theabyss.recipes.impl.ArcaneStationRecipe;
import net.yezon.theabyss.utils.RecipeUtils;
import net.yezon.theabyss.world.inventory.ArcaneMenu;

import java.util.LinkedList;
import java.util.List;

public class AllRecipeTypes {

    //bc we are not registering not many recipes, LinkedList is used to * slightly * improve the performance
    public static final List<AbyssRecipeType> ALL_RECIPE_TYPES = new LinkedList<>();

    public static final AbyssRecipeType ARCANE_CRAFTING;
    //public static final AbyssRecipeType SOMNIUM_INFUSING;

    static {
        ARCANE_CRAFTING = new AbyssRecipeType("arcane_crafting",
                RecipeUtils::createArcaneStationSerializer,
                ArcaneStationRecipe.class,
                Component.translatable("jei.title.arcane_crafting"),
                RecipeDisplayData.Builder
                        .builder("arcane_station.png", 176, 102, TheabyssModBlocks.ARCANE_WORKBENCH)
                        .addIngredient(0, 44, 7)
                        .addIngredient(1, 71, 16)
                        .addIngredient(2, 80, 43)
                        .addIngredient(3, 71, 70)

                        .addIngredient(4,44, 79)
                        .addIngredient(5, 17, 70)
                        .addIngredient(6, 8, 43)
                        .addIngredient(7, 17, 16)

                        .addIngredient(8, 44, 43)
                        .addRecipeViewArea(ArcaneScreen.class,150, 87, 20, 20)
                        .addRecipeTransferHandler(ArcaneMenu.class, TheabyssModMenus.ARCANE, 0, 9, 10, 36)
                        .construct(152, 43)
        );
    }

    static void staticInit() {}
}

package net.yezon.theabyss.recipes;

import net.minecraft.network.chat.Component;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.init.TheabyssModMenus;
import net.yezon.theabyss.recipes.impl.ArcaneStationRecipe;
import net.yezon.theabyss.recipes.impl.MortarAndPestleRecipe;
import net.yezon.theabyss.recipes.impl.SomniumInfusingRecipe;
import net.yezon.theabyss.utils.RecipeUtils;
import net.yezon.theabyss.world.inventory.ArcaneMenu;
import net.yezon.theabyss.world.inventory.InfuserMenu;
import net.yezon.theabyss.world.inventory.MortarMenu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author KhanhTypo
 */
public class AllRecipeTypes {
    //bc we are not registering not many recipes, LinkedList is used to * slightly * improve the performance
    public static final List<AbyssRecipeType> ALL_RECIPE_TYPES = new LinkedList<>();

    public static final AbyssRecipeType ARCANE_CRAFTING;
    public static final AbyssRecipeType SOMNIUM_INFUSING;
    public static final AbyssRecipeType MORTAR_AND_PESTLE;

    static {
        ARCANE_CRAFTING = new AbyssRecipeType("arcane_crafting",
                RecipeUtils::createArcaneStationSerializer,
                ArcaneStationRecipe.class,
                Component.translatable("jei.theabyss.title.arcane_crafting"),
                RecipeDisplayData.Builder
                        .builder("arcane_station.png", 176, 102, TheabyssModBlocks.ARCANE_WORKBENCH)
                        .addIngredient(44, 7)
                        .addIngredient(71, 16)
                        .addIngredient(80, 43)
                        .addIngredient(71, 70)

                        .addIngredient(44, 79)
                        .addIngredient(17, 70)
                        .addIngredient(8, 43)
                        .addIngredient(17, 16)

                        .addIngredient(44, 43)
                        //.addRecipeViewArea(ArcaneScreen.class, 150, 87)
                        .addRecipeTransferHandler(ArcaneMenu.class, TheabyssModMenus.ARCANE, 0, 9, 10, 36)
                        .construct(152, 43)
        );

        SOMNIUM_INFUSING = new AbyssRecipeType("somnium_infusing",
                RecipeUtils::createSomniumInfusingSerializer,
                SomniumInfusingRecipe.class,
                Component.translatable("jei.theabyss.title.somnium_infusing"),
                RecipeDisplayData.Builder
                        .builder("somnium_infuser.png", 176, 82, TheabyssModBlocks.SOMNIUM_INFUSER)
                        .addIngredient(35, 7)
                        .addIngredient(79, 16)
                        .addIngredient(27, 42)
                        .addIngredient(53, 50)
                        .addIngredient(105, 50)
                        .addIngredient(131, 42)
                        .addRecipeTransferHandler(InfuserMenu.class, TheabyssModMenus.INFUSER, 0, 6, 7, 36)
                        .addAnimatedDrawable(179, 0, 2, 25, 86, 33, 30, RecipeDisplayData.AnimatedDrawableBuilder.StartFrom.TOP, false)
                        //.addRecipeViewArea(InfuserScreen.class, 150, 64)
                        .construct(79, 59)
        );

        MORTAR_AND_PESTLE = new AbyssRecipeType("mortar_and_pestle",
                RecipeUtils::createMortarAndPestleRecipe,
                MortarAndPestleRecipe.class,
                Component.translatable("block.theabyss.mortar_and_pestle"),
                RecipeDisplayData.Builder.builder("mortar_and_pestle.png", 176, 99, TheabyssModBlocks.MORTAR_AND_PESTLE)
                        .addIngredient(44, 25)
                        .addIngredient(26, 43)
                        .addIngredient(44, 43)
                        .addIngredient(62, 43)
                        .addIngredient(44, 61)
                        //.addRecipeViewArea(MortarScreen.class,151, 78)
                        .addRecipeTransferHandler(MortarMenu.class, TheabyssModMenus.MORTAR, 0, 5, 6, 36)
                        .construct(134, 43)
        );
    }

    static void staticInit() {
    }
}

package net.yezon.theabyss.data;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.data.recipes.TheAbyssRecipeProvider;
import net.yezon.theabyss.data.tag.TheAbyssTagProvider;
import net.yezon.theabyss.recipes.AbyssRecipeType;
import net.yezon.theabyss.recipes.AllRecipeTypes;

import java.util.List;
import java.util.Locale;

/**
 * @author KhanhTypo
 */
@Mod.EventBusSubscriber(modid = TheabyssMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGathering {

    private DataGathering() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        final DataGenerator generator = event.getGenerator();
        final ExistingFileHelper fileHelper = event.getExistingFileHelper();
        generator.addProvider(event.includeServer(), new TheAbyssRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new TheAbyssTagProvider(generator, fileHelper));

    }

    @SubscribeEvent
    public static void registerCategory(RegisterRecipeBookCategoriesEvent event) {
        for (AbyssRecipeType recipeType : AllRecipeTypes.ALL_RECIPE_TYPES) {
            String recipeBookTypeName = recipeType.getId().getPath().toUpperCase(Locale.ROOT);
            event.registerBookCategories(RecipeBookType.create(recipeBookTypeName), List.of(RecipeBookCategories.create(recipeBookTypeName, new ItemStack(recipeType.getData().tabIcon().get()))));
            event.registerRecipeCategoryFinder(recipeType.getVanillaType(), recipe -> RecipeBookCategories.valueOf(recipeBookTypeName));
        }
    }
}

package net.yezon.theabyss.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.compat.jei.categories.ArcaneRecipeCategory;
import net.yezon.theabyss.compat.jei.categories.MortarRecipeCategory;
import net.yezon.theabyss.compat.jei.categories.SomniumInfuserCategory;
import net.yezon.theabyss.compat.jei.helpers.AbstractRecipeCategory;

import java.util.ArrayList;

/**
 * @author KhanhPham05 - KhanhTypo (1.18.2)
 * @author Y3Z0n (1.16.5)
 */
@JeiPlugin
public class AbyssJeiPlugin implements IModPlugin {
    public static final ResourceLocation PLUGIN_ID = new ResourceLocation(TheabyssMod.MODID, "jei_plugin");
    private final ArrayList<AbstractRecipeCategory<?>> recipeCategory = new ArrayList<>();

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        recipeCategory.forEach(recipe -> recipe.registerRecipes(registration));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        recipeCategory.forEach(recipe -> registration.addRecipeCatalyst(new ItemStack(recipe.getCatalystIcon()), recipe.getRecipeType()));
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers helper = registration.getJeiHelpers();
        MortarRecipeCategory mortarRecipe = new MortarRecipeCategory(helper);
        SomniumInfuserCategory somniumInfuserCategory = new SomniumInfuserCategory(helper);
        ArcaneRecipeCategory arcaneRecipeCategory = new ArcaneRecipeCategory(helper);

        recipeCategory.add(mortarRecipe);
        recipeCategory.add(somniumInfuserCategory);
        recipeCategory.add(arcaneRecipeCategory);
        registration.addRecipeCategories(recipeCategory.toArray(new AbstractRecipeCategory<?>[0]));
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
       recipeCategory.forEach(recipe -> recipe.registerTransferHandler(registration));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        recipeCategory.forEach(recipe -> recipe.registerShowRecipeZone(registration));
    }
}

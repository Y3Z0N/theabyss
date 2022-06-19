package net.yezon.theabyss.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

abstract class AbstractRecipeCategory<T> implements IRecipeCategory<T> {
    protected final IJeiHelpers helpers;
    protected final IDrawable tabIcon;

    public AbstractRecipeCategory(IJeiHelpers helpers) {
        this.helpers = helpers;
        IGuiHelper guiHelper = helpers.getGuiHelper();

        this.tabIcon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(getCatalystIcon()));
    }

    @Override
    public final IDrawable getIcon() {
        return tabIcon;
    }

    abstract void registerRecipes(IRecipeRegistration registration);

    abstract Item getCatalystIcon();

    public abstract RecipeType<T> getRecipeType();
}

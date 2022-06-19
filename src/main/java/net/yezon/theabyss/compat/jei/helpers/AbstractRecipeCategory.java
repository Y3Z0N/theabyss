package net.yezon.theabyss.compat.jei.helpers;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public abstract class AbstractRecipeCategory<T extends AbstractRecipeCategoryWrapper> implements IRecipeCategory<T> {
    protected final IJeiHelpers helpers;
    protected final IDrawable tabIcon;
    protected final Component title;
    protected final IDrawable background;
    protected final RecipeType<T> recipeType;
    protected final IGuiHelper guiHelper;

    public AbstractRecipeCategory(IJeiHelpers helpers, RecipeType<T> recipeType, Component title, CategoryGuiHelper backgroundHelper) {
        this.helpers = helpers;
        this.guiHelper = helpers.getGuiHelper();
        this.title = title;
        this.background = backgroundHelper.drawBackground(guiHelper);
        this.tabIcon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(getCatalystIcon()));
        this.recipeType = recipeType;
    }

    @Override
    public final Class<? extends T> getRecipeClass() {
        return recipeType.getRecipeClass();
    }

    @Override
    public final ResourceLocation getUid() {
        return recipeType.getUid();
    }

    @Override
    public final IDrawable getBackground() {
        return background;
    }

    @Override
    public final Component getTitle() {
        return title;
    }

    @Override
    public final IDrawable getIcon() {
        return tabIcon;
    }


    public abstract void registerRecipes(IRecipeRegistration registration);

    public abstract Item getCatalystIcon();

    public final RecipeType<T> getRecipeType() {
        return recipeType;
    }

    public abstract void registerShowRecipeZone(IGuiHandlerRegistration registration);

    public abstract void registerTransferHandler(IRecipeTransferRegistration registration);

    public abstract void setRecipe(IRecipeLayoutBuilder builder, T recipe, IFocusGroup focuses);
}

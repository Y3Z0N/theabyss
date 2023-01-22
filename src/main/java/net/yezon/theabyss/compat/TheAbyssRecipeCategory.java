package net.yezon.theabyss.compat;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.recipes.AbyssRecipeType;
import net.yezon.theabyss.recipes.RecipeDisplayData;
import oshi.util.tuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class TheAbyssRecipeCategory implements IRecipeCategory<Recipe<Container>> {
    public static final Map<AbyssRecipeType, TheAbyssRecipeCategory> CATEGORY_MAP = new HashMap<>();
    private final RecipeType<Recipe<Container>> jeiRecipeType;
    private final AbyssRecipeType abyssRecipeType;
    private final IDrawable background;
    private final IDrawable icon;
    private final Map<Integer, Pair<Integer, Integer>> ingredientMapping;
    private final RecipeDisplayData recipeViewData;

    public TheAbyssRecipeCategory(IGuiHelper guiHelper, AbyssRecipeType abyssRecipeType) {
        this.jeiRecipeType = new RecipeType<>(abyssRecipeType.getId(), abyssRecipeType.getRecipeClass());
        this.abyssRecipeType = abyssRecipeType;

        this.recipeViewData = abyssRecipeType.getData();
        this.background = guiHelper.createDrawable(abyssRecipeType.getData().jeiPngName(), 0, 0, recipeViewData.width(), recipeViewData.height());
        this.icon = guiHelper.createDrawableItemStack(new ItemStack(recipeViewData.tabIcon().get()));
        this.ingredientMapping = recipeViewData.ingredientMapping();

        CATEGORY_MAP.put(abyssRecipeType, this);
        TheabyssMod.LOGGER.info("Registering JEI recipe tab for [{}]", abyssRecipeType.getId());
    }

    @Override
    public RecipeType<Recipe<Container>> getRecipeType() {
        return this.jeiRecipeType;
    }

    @Override
    public Component getTitle() {
        return this.abyssRecipeType.getRecipeTitle();
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, Recipe<Container> recipe, IFocusGroup focuses) {
        this.ingredientMapping.forEach((index, position) -> builder.addSlot(RecipeIngredientRole.INPUT, position.getA(), position.getB()).addIngredients(recipe.getIngredients().get(index)));
        builder.addSlot(RecipeIngredientRole.OUTPUT, this.recipeViewData.resultX(), this.recipeViewData.resultY()).addItemStack(recipe.getResultItem());
    }
}

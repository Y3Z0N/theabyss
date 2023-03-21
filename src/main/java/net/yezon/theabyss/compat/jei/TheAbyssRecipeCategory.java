package net.yezon.theabyss.compat.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
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

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TheAbyssRecipeCategory implements IRecipeCategory<Recipe<Container>> {
    public static final Map<AbyssRecipeType, TheAbyssRecipeCategory> CATEGORY_MAP = new HashMap<>();
    private final RecipeType<Recipe<Container>> jeiRecipeType;
    private final AbyssRecipeType abyssRecipeType;
    private final IDrawableStatic background;
    private final IDrawable icon;
    private final List<Pair<Integer, Integer>> ingredientMapping;
    private final RecipeDisplayData recipeViewData;
    @Nullable
    private final IDrawableAnimated drawableAnimated;
    private int animateOffsetX = 0;
    private int animateOffsetY = 0;

    public TheAbyssRecipeCategory(IGuiHelper guiHelper, AbyssRecipeType abyssRecipeType) {
        this.jeiRecipeType = new RecipeType<>(abyssRecipeType.getId(), abyssRecipeType.getRecipeClass());
        this.abyssRecipeType = abyssRecipeType;

        this.recipeViewData = abyssRecipeType.getDisplayData();
        this.background = guiHelper.createDrawable(abyssRecipeType.getDisplayData().jeiPngName(), 0, 0, recipeViewData.width(), recipeViewData.height());
        this.icon = guiHelper.createDrawableItemStack(new ItemStack(recipeViewData.tabIcon().get()));
        this.ingredientMapping = recipeViewData.ingredientMapping();

        if (abyssRecipeType.getDisplayData().animatedDrawable() != null) {
            final RecipeDisplayData.AnimatedDrawableBuilder builder = abyssRecipeType.getDisplayData().animatedDrawable();
            final IDrawableStatic drawableStatic = guiHelper.createDrawable(abyssRecipeType.getDisplayData().jeiPngName(), builder.u(), builder.v(), builder.width(), builder.height());
            this.drawableAnimated = guiHelper.createAnimatedDrawable(drawableStatic, builder.tickPerCycle(), startDirection(builder.from()), builder.inverted());
            this.animateOffsetX = builder.x();
            this.animateOffsetY = builder.y();
        } else {
            this.drawableAnimated = null;
        }

        CATEGORY_MAP.put(abyssRecipeType, this);
        TheabyssMod.LOGGER.info("Registering JEI recipe tab for [{}]", abyssRecipeType.getId());
    }

    private static IDrawableAnimated.StartDirection startDirection(RecipeDisplayData.AnimatedDrawableBuilder.StartFrom from) {
        return IDrawableAnimated.StartDirection.valueOf(from.name().toUpperCase(Locale.ROOT));
    }

    @Override
    public void draw(Recipe<Container> recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        if (this.drawableAnimated != null) {
            this.drawableAnimated.draw(stack, this.animateOffsetX, this.animateOffsetY);
        }
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
        for (int i = 0; i < this.ingredientMapping.size(); i++) {
            Pair<Integer, Integer> position = this.ingredientMapping.get(i);
            builder.addSlot(RecipeIngredientRole.INPUT, position.getA(), position.getB())
                    .addIngredients(recipe.getIngredients().get(i));
        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, this.recipeViewData.resultX(), this.recipeViewData.resultY()).addItemStack(recipe.getResultItem());
    }
}

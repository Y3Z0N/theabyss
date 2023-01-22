package net.yezon.theabyss.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.recipes.AbyssRecipeType;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.recipes.RecipeDisplayData;

import java.util.function.Supplier;

@JeiPlugin()
public class TheAbyssJeiPlugin implements IModPlugin {
    public static final ResourceLocation PLUGIN_ID = TheabyssMod.location("jei_recipes_plugin");
    private final Supplier<ClientLevel> clientLevel = () -> Minecraft.getInstance().level;

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(AllRecipeTypes.ALL_RECIPE_TYPES.stream().map(abyssRecipeType -> new TheAbyssRecipeCategory(helper, abyssRecipeType)).toArray(TheAbyssRecipeCategory[]::new));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        AllRecipeTypes.ALL_RECIPE_TYPES.forEach(recipeType -> {
            registration.addRecipes(
                    this.getJeiType(recipeType),
                    recipeType.getAllRecipes(this.clientLevel.get())
            );
        });
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        AllRecipeTypes.ALL_RECIPE_TYPES.forEach(recipeType -> {
            registration.addRecipeCatalyst(new ItemStack(recipeType.getData().tabIcon().get()), TheAbyssRecipeCategory.CATEGORY_MAP.get(recipeType).getRecipeType());
        });
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        AllRecipeTypes.ALL_RECIPE_TYPES.forEach(recipeType -> {
            RecipeType<?> jeiRecipeType = this.getJeiType(recipeType);
            RecipeDisplayData.RecipeViewHolder holder = recipeType.getData().recipeViewArea();
            registration.addRecipeClickArea(holder.screenClass(), holder.x(), holder.y(), holder.width(), holder.height(), jeiRecipeType);
        });
    }

    private RecipeType<Recipe<Container>> getJeiType(AbyssRecipeType recipeType) {
        return TheAbyssRecipeCategory.CATEGORY_MAP.get(recipeType).getRecipeType();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        AllRecipeTypes.ALL_RECIPE_TYPES.forEach(
                recipeType -> {
                    final RecipeDisplayData.RecipeTransferHolder<? extends AbstractContainerMenu> holder = recipeType.getData().recipeTransferHolder();
                    registration.addRecipeTransferHandler(holder.menuClass(),
                            ((MenuType<AbstractContainerMenu>) holder.menuType().get()),
                            this.getJeiType(recipeType),
                            holder.recipeSlotStart(),
                            holder.recipeSlotCount(),
                            holder.inventorySlotStart(),
                            holder.inventorySlotCount());
                }
        );
    }
}

package net.yezon.theabyss.compat.jei.categories;

import com.google.common.collect.ImmutableList;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.client.gui.MortarScreen;
import net.yezon.theabyss.compat.jei.helpers.AbstractRecipeCategory;
import net.yezon.theabyss.compat.jei.helpers.AbstractRecipeCategoryWrapper;
import net.yezon.theabyss.compat.jei.helpers.CategoryGuiHelper;
import net.yezon.theabyss.item.essence.EssenceItem;

import java.util.List;
import java.util.function.Supplier;

import static net.yezon.theabyss.init.TheabyssModItems.*;

@SuppressWarnings("removal")
public
class MortarRecipeCategory extends AbstractRecipeCategory<MortarRecipeCategory.Wrapper> {
    public static final ResourceLocation GUI_LOCATION = new ResourceLocation(TheabyssMod.MODID, "textures/jei/mortar_and_pestle.png");
    private static final ResourceLocation Uid = new ResourceLocation(TheabyssMod.MODID, "mortar_recipes");
    public MortarRecipeCategory(IJeiHelpers helpers) {
        super(helpers, new RecipeType<>(Uid, Wrapper.class), new TranslatableComponent("jei.abyss.mortar_and_pestle"), new CategoryGuiHelper(GUI_LOCATION, 0, 0, 176, 99));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<Wrapper> recipes = ImmutableList.of(
                Wrapper.wrap(CRIMSON_POWDER).putRecipe(CRIMSON_CRYSTAL_SHARD, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(ABYSS_POWDER).putRecipe(ABYSS_CRYSTAL_SHARD, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(AUREL_POWDER).putRecipe(AUREL_CRYSTAL_SHARD, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(CAVERNA_POWDER).putRecipe(CAVERNA_CRYSTAL, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(ENDER_POWDER).putRecipe(ENDER_CRYSTAL_SHARD, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(FROST_POWDER).putRecipe(FROST_CRYSTAL_SHARD, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(HOLLOW_POWDER).putRecipe(HOLLOW_CRYSTAL_SHARD, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(WARPED_POWDER).putRecipe(WARPED_CRYSTAL_SHARD, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(VIT_POWDER).putRecipe(VITAE_STONE, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(FEAR_POWDER).putRecipe(ROKA_HORN, ANTI_FEAR_ESSENCE),
                Wrapper.wrap(ARDOR_POWDER).putCrossRecipe(VITAE_DUST, LORAN, BOTTLE_OF_SOMNIUM),
                Wrapper.wrap(TENEBRIS_POWDER).putCrossRecipe(ROKA_HORN, CAVERNA_POWDER, ANTI_FEAR_ESSENCE)
        );
        registration.addRecipes(recipeType, recipes);
    }

    @Override
    public void registerShowRecipeZone(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(MortarScreen.class, 155, 46, 13, 14, recipeType);
    }

    @Override
    public void registerTransferHandler(IRecipeTransferRegistration registration) {
        //registration.addRecipeTransferHandler(MortarMenu.class, RECIPE_TYPE, 1, 5, 6, 42 - 6);
    }

    @Override
    public Item getCatalystIcon() {
        return MORTAR_AND_PESTLE.get();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, Wrapper recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 25).addItemStack(recipe.getInputs().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 43).addItemStack(recipe.getInputs().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 43).addItemStack(recipe.getInputs().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 43).addItemStack(recipe.getInputs().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 61).addItemStack(recipe.getInputs().get(4));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 43).addItemStack(recipe.getResult());
    }

    public static final class Wrapper extends AbstractRecipeCategoryWrapper {
        public Wrapper(Item result) {
            super(result);
        }

        private static Wrapper wrap(Supplier<Item> result) {
            return new Wrapper(result.get());
        }


        //      0
        //    1 2 3
        //      4
        public Wrapper putRecipe(Supplier<Item> shards, Supplier<? extends EssenceItem> essenceItem) {
            for (int i = 0; i <= 4; i++) {
                if (i == 2) inputs.add(essenceItem.get().getStackOfSelf());
                else inputs.add(new ItemStack(shards.get()));
            }

            return this;
        }

        //                   vertical
        //      horizontal   essence    horizontal
        //                   vertical
        public Wrapper putCrossRecipe(Supplier<Item> vertical, Supplier<Item> horizontal, Supplier<? extends EssenceItem> essenceItem) {
            inputs.add(makeStack(vertical));
            inputs.add(makeStack(horizontal));
            inputs.add(essenceItem.get().getStackOfSelf());
            inputs.add(makeStack(horizontal));
            inputs.add(makeStack(vertical));


            return this;
        }
    }
}
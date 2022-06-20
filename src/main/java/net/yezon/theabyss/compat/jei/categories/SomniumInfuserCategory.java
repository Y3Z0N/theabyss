package net.yezon.theabyss.compat.jei.categories;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
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
import net.minecraft.world.item.Items;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.client.gui.InfuserScreen;
import net.yezon.theabyss.compat.jei.helpers.AbstractRecipeCategory;
import net.yezon.theabyss.compat.jei.helpers.AbstractRecipeCategoryWrapper;
import net.yezon.theabyss.compat.jei.helpers.CategoryGuiHelper;
import net.yezon.theabyss.init.TheabyssModItems;

import java.util.List;
import java.util.function.Supplier;

import static net.yezon.theabyss.init.TheabyssModItems.*;

/**
 * @author KhanhPham05 - KhanhTypo
 */
public class SomniumInfuserCategory extends AbstractRecipeCategory<SomniumInfuserCategory.Wrapper> {
    public static final ResourceLocation UID = new ResourceLocation(TheabyssMod.MODID, "somnium_infusing");
    public static final ResourceLocation GUI_LOCATION = new ResourceLocation(TheabyssMod.MODID, "textures/jei/somnium_infuser.png");
    private final IDrawableAnimated processBarAnimated;

    public SomniumInfuserCategory(IJeiHelpers helpers) {
        super(helpers, new RecipeType<>(UID, Wrapper.class), new TranslatableComponent("abyss.jei.somnium_infusing"), new CategoryGuiHelper(GUI_LOCATION, 0, 0, 176, 82));
        IDrawableStatic processBar = guiHelper.createDrawable(GUI_LOCATION, 179, 0, 2, 26);
        this.processBarAnimated = super.guiHelper.createAnimatedDrawable(processBar, 15, IDrawableAnimated.StartDirection.TOP, false);
    }

    @Override
    public void draw(Wrapper recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        processBarAnimated.draw(stack, 87, 32);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<Wrapper> recipes = ImmutableList.of(
                Wrapper.wrap(IMMORTAL_SUBSTANCE.get()).putRecipe(APPLE_OF_IMMORTALITY, () -> Items.APPLE, APPLE_OF_IMMORTALITY, () -> Items.APPLE),
                Wrapper.wrap(SOMNIUM_COOLDOWN_UPGRADE.get()).putRecipe(NODE_SHARD, CRYSTAL_HAND, NODE_SHARD, CRYSTAL_HAND),
                Wrapper.wrap(SOMNIUM_DAMAGE_UPRAGDE.get()).putRecipe(ROKA_HORN, ELDER_EYE, CRYSTAL_HAND, CREEPER_DUST),
                Wrapper.wrap(ANTI_FEAR_ESSENCE.get()).putRecipe(ROKA_HORN, ROKA_HORN, ROKA_HORN, ROKA_HORN),
                Wrapper.wrap(SOMNIUM_REGEN_UPGRADE.get()).putRecipe(ROKA_HORN, PHANTOM_ESSENCE, BOTTLE_OF_SOMNIUM, SLIME_STAGE_4),
                Wrapper.wrap(SOMNIUM_UPGRADE.get()).putRecipe(ROKA_HORN, NODE_SHARD, PHANTOM_SOUL_ITEM, SOUL_HEART),
                Wrapper.wrap(ANTI_INFECT_ESSENCE.get()).putRecipe(ROTTEN_FLESH, ROTTEN_FLESH, ROTTEN_FLESH, ROTTEN_FLESH),
                Wrapper.wrap(LURKER_JUICE.get()).putRecipe(LURKER_SOBBER, LURKER_SOBBER, LURKER_SOBBER, LURKER_SOBBER)
        );
        registration.addRecipes(recipeType, recipes);
    }

    @Override
    public Item getCatalystIcon() {
        return TheabyssModItems.SOMNIUM_INFUSER.get();
    }

    @Override
    public void registerShowRecipeZone(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(InfuserScreen.class, 155, 46, 13, 14, recipeType);
    }

    @Override
    public void registerTransferHandler(IRecipeTransferRegistration registration) {
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, Wrapper recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 28, 42).addItemStack(recipe.getInputs().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 50).addItemStack(recipe.getInputs().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 106, 50).addItemStack(recipe.getInputs().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 132, 42).addItemStack(recipe.getInputs().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 36, 11).addItemStack(recipe.makeStack(SOMNIUM));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 16).addItemStack(recipe.makeStack(LORAN_ENERGY));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(recipe.getResult());
    }

    public static final class Wrapper extends AbstractRecipeCategoryWrapper {
        public Wrapper(Item result) {
            super(result);
        }

        private static Wrapper wrap(Item result) {
            return new Wrapper(result);
        }

        //      0                        3
        //          1     OUTPUT    2
        //
        // 4 = Somnium Fuel
        // 5 = Loran Energy
        public Wrapper putRecipe(Supplier<Item> input0, Supplier<Item> input1, Supplier<? extends Item> input2, Supplier<Item> input3) {
            super.putItem(input0).putItem(input1).putItem(input2).putItem(input3);//.putItem(SOMNIUM).putItem(LORAN_ENERGY);
            return this;
        }
    }
}

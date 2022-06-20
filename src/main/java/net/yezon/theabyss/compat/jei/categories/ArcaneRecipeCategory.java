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
import net.minecraft.world.item.Items;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.client.gui.ArcaneScreen;
import net.yezon.theabyss.compat.jei.helpers.AbstractRecipeCategory;
import net.yezon.theabyss.compat.jei.helpers.AbstractRecipeCategoryWrapper;
import net.yezon.theabyss.compat.jei.helpers.CategoryGuiHelper;
import net.yezon.theabyss.init.TheabyssModItems;

import java.util.List;
import java.util.function.Supplier;

import static net.yezon.theabyss.init.TheabyssModItems.*;

public class ArcaneRecipeCategory extends AbstractRecipeCategory<ArcaneRecipeCategory.Wrapper> {
    public static final ResourceLocation UID = new ResourceLocation(TheabyssMod.MODID, "arcane_station");
    public static final ResourceLocation GUI_LOCATION = new ResourceLocation(TheabyssMod.MODID, "textures/jei/arcane_station.png");

    public ArcaneRecipeCategory(IJeiHelpers helpers) {
        super(helpers, new RecipeType<>(UID, Wrapper.class), new TranslatableComponent("abyss.jei.arcane_station"), new CategoryGuiHelper(GUI_LOCATION, 0, 0, 176, 102));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<Wrapper> recipeWrapper = ImmutableList.of(
                Wrapper.wrap(RING_OF_TELEPORT).putRecipe(RING_OF_RING, ENDER_POWDER, MUTATED_ENDERPEARL),
                Wrapper.wrap(RING_OF_EAGLE).putRecipe(RING_OF_RING, ENDER_POWDER, SCORPION_EYE),
                Wrapper.wrap(RING_OF_INVISIBILITY).putRecipe(RING_OF_RING, HOLLOW_CRYSTAL_SHARD),
                Wrapper.wrap(RING_OF_OCEAN).putRecipe(RING_OF_RING, () -> Items.WATER_BUCKET, LORAN),
                Wrapper.wrap(RING_OF_THUNDER).putRecipe(RING_OF_RING, ABYSS_POWDER, ARDOR_POWDER),
                Wrapper.wrap(RING_OF_FREEZE).putRecipe(RING_OF_RING, FROST_POWDER, CAVERNA_POWDER),
                Wrapper.wrap(RING_OF_JUGGER).putRecipe(RING_OF_RING, ABYSS_CRYSTAL_SHARD, ROKA_HORN),
                Wrapper.wrap(RING_OF_TIME).putRecipe(RING_OF_FREEZE, HOLLOW_CRYSTAL_SHARD, INCORYTHE_GEM),
                Wrapper.wrap(RING_OF_SPEED).putRecipe(RING_OF_RING, ENDER_CRYSTAL_SHARD, NODE_SHARD),
                Wrapper.wrap(RING_OF_FIRE).putRecipe(RING_OF_RING, CRIMSON_POWDER, () -> Items.BLAZE_POWDER),
                Wrapper.wrap(RING_OF_FIRESTRIKE).putRecipe(RING_OF_FIRE, CRIMSON_CRYSTAL_SHARD, () -> Items.BLAZE_POWDER),
                Wrapper.wrap(RING_OF_FIRESTORM).putRecipe(RING_OF_FIRESTRIKE, CRIMSON_CRYSTAL_SHARD, () -> Items.BLAZE_POWDER),
                Wrapper.wrap(RING_OF_TELEKINETIC).putRecipe(RING_OF_FIRESTRIKE, ENDER_CRYSTAL_SHARD, HOLLOW_CRYSTAL_SHARD),
                Wrapper.wrap(RING_OF_BLACKSTRIKE).putRecipe(RING_OF_TELEKINETIC, ENDER_POWDER, HOLLOW_CRYSTAL_SHARD),
                Wrapper.wrap(RING_OF_CURSE).putRecipe(RING_OF_BLACKSTRIKE, FEAR_POWDER, HOLLOW_CRYSTAL_SHARD),
                Wrapper.wrap(RING_OF_REG).putRecipe(RING_OF_RING, AUREL_POWDER, VITAE_STONE),
                Wrapper.wrap(RING_OF_ENDER_CHEST).putRecipe(RING_OF_RING, ENDER_CRYSTAL_SHARD, CAVERNA_CRYSTAL),
                Wrapper.wrap(RING_OF_SLIDE).putRecipe(RING_OF_RING, () -> Items.ELYTRA, ENDER_CRYSTAL_SHARD),
                Wrapper.wrap(RING_OF_HOME).putRecipe(RING_OF_RING, () -> Items.WHITE_BED, ENDER_CRYSTAL_SHARD),
                Wrapper.wrap(RING_OF_NATURE).putRecipe(RING_OF_RING, () -> Items.BONE),
                Wrapper.wrap(RING_OF_FLIGHT).putRecipe(RING_OF_SLIDE, () -> Items.ELYTRA, ENDER_CRYSTAL_SHARD),
                Wrapper.wrap(RING_OF_POCKET_BOX).putRecipe(RING_OF_RING, VIT_POWDER, () -> Items.ENDER_CHEST),
                Wrapper.wrap(RING_OF_SEEKER).putRecipe(RING_OF_RING, KNIGHT_INGOT, TENEBRIS_POWDER),
                Wrapper.wrap(RING_OF_ELECTRO).putRecipe(RING_OF_RING, ARDOR_POWDER, THUNDER_STONE),
                Wrapper.wrap(RING_OF_FANGS).putRecipe(RING_OF_RING, ARDOR_POWDER, KNIGHT_SHARD)
        );
        registration.addRecipes(recipeType, recipeWrapper);
    }

    @Override
    public Item getCatalystIcon() {
        return TheabyssModItems.ARCANE_WORKBENCH.get();
    }

    @Override
    public void registerShowRecipeZone(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ArcaneScreen.class, 157, 62, 13, 14, recipeType);
    }

    @Override
    public void registerTransferHandler(IRecipeTransferRegistration registration) {

    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, Wrapper recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT,44, 43).addItemStack(recipe.getInputs().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT,71, 16).addItemStack(recipe.getInputs().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,80, 43).addItemStack(recipe.getInputs().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT,71, 70).addItemStack(recipe.getInputs().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,44, 79).addItemStack(recipe.getInputs().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT,17, 70).addItemStack(recipe.getInputs().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,8, 43).addItemStack(recipe.getInputs().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT,17, 16).addItemStack(recipe.getInputs().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT,44, 7).addItemStack(recipe.getInputs().get(2));
        builder.addSlot(RecipeIngredientRole.OUTPUT,152, 43).addItemStack(recipe.getResult());

    }

    public static final class Wrapper extends AbstractRecipeCategoryWrapper {
        public Wrapper(Item result) {
            super(result);
        }

        public static Wrapper wrap(Supplier<Item> result) {
            return new Wrapper(result.get());
        }

        public Wrapper putRecipe(Supplier<Item> ring, Supplier<Item> input0, Supplier<Item> input1) {
            super.putItem(ring).putItem(input0).putItem(input1);
            return this;
        }

        public Wrapper putRecipe(Supplier<Item> ring, Supplier<Item> input) {
            return putRecipe(ring, input, input);
        }
    }
}

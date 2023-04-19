package net.yezon.theabyss.data.recipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.data.recipes.recipebuilders.ArcaneCraftingRecipeBuilder;
import net.yezon.theabyss.data.recipes.recipebuilders.MortarRecipeBuilder;
import net.yezon.theabyss.data.recipes.recipebuilders.SomniumInfusingRecipeBuilder;
import net.yezon.theabyss.data.recipes.recipebuilders.TheAbyssRecipeBuilder;
import net.yezon.theabyss.recipes.impl.ArcaneStationRecipe;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static net.yezon.theabyss.init.TheabyssModItems.*;

/**
 * @author KhanhTypo
 */
public class TheAbyssRecipeProvider extends RecipeProvider {
    public TheAbyssRecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        this.buildArcaneRecipes(consumer);
        this.buildSomniumInfusingRecipes(consumer);
        this.buildMortarAndPestleRecipe(consumer);

    }

    private void buildMortarAndPestleRecipe(Consumer<FinishedRecipe> consumer) {
        MortarRecipeBuilder.buildOneInput(consumer, null,
                new ItemStack(CRIMSON_POWDER.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(CRIMSON_CRYSTAL_SHARD.get()));

        MortarRecipeBuilder.buildOneInput(consumer, null,
                new ItemStack(ABYSS_POWDER.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(ABYSS_CRYSTAL_SHARD.get()));

        MortarRecipeBuilder.buildOneInput(consumer, null,
                new ItemStack(AUREL_POWDER.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(AUREL_CRYSTAL_ORE.get()));

        MortarRecipeBuilder.buildOneInput(consumer, null,
                new ItemStack(ENDER_POWDER.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(ENDER_CRYSTAL_SHARD.get()));

        MortarRecipeBuilder.buildOneInput(consumer, null,
                new ItemStack(FROST_POWDER.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(FROST_CRYSTAL_SHARD.get()));

        MortarRecipeBuilder.buildOneInput(consumer, null,
                new ItemStack(HOLLOW_POWDER.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(HOLLOW_CRYSTAL_SHARD.get()));

        MortarRecipeBuilder.buildOneInput(consumer, null,
                new ItemStack(WARPED_POWDER.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(WARPED_CRYSTAL_SHARD.get()));

        MortarRecipeBuilder.buildOneInput(consumer, null,
                new ItemStack(VIT_POWDER.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(VITAE_STONE.get()));

        MortarRecipeBuilder.buildOneInput(consumer, null,
                new ItemStack(FEAR_POWDER.get()),
                Ingredient.of(ANTI_FEAR_ESSENCE.get()),
                Ingredient.of(ROKA_HORN.get()));

        MortarRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(ARDOR_POWDER.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(LORAN.get()),
                Ingredient.of(VITAE_DUST.get()));

        MortarRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(TENEBRIS_POWDER.get()),
                Ingredient.of(ANTI_FEAR_ESSENCE.get()),
                Ingredient.of(CAVERNA_POWDER.get()),
                Ingredient.of(ROKA_HORN.get()));
    }

    private void buildSomniumInfusingRecipes(Consumer<FinishedRecipe> consumer) {
        SomniumInfusingRecipeBuilder.buildTwoInputs(consumer, null,
                IMMORTAL_SUBSTANCE,
                Ingredient.of(APPLE_OF_IMMORTALITY.get()),
                Ingredient.of(Items.APPLE));
        SomniumInfusingRecipeBuilder.buildTwoInputs(consumer, null,
                SOMNIUM_COOLDOWN_UPGRADE,
                Ingredient.of(NODE_SHARD.get()),
                Ingredient.of(CRYSTAL_HAND.get()));
        SomniumInfusingRecipeBuilder.build(consumer, null,
                SOMNIUM_DAMAGE_UPRAGDE,
                Ingredient.of(ROKA_HORN.get()),
                Ingredient.of(ELDER_EYE.get()),
                Ingredient.of(CRYSTAL_HAND.get()),
                Ingredient.of(CREEPER_DUST.get()));
        SomniumInfusingRecipeBuilder.buildOneInput(consumer, null,
                ANTI_FEAR_ESSENCE,
                Ingredient.of(ROKA_HORN.get()));
        SomniumInfusingRecipeBuilder.build(consumer, null,
                SOMNIUM_REGEN_UPGRADE,
                Ingredient.of(ROKA_HORN.get()),
                Ingredient.of(PHANTOM_ESSENCE.get()),
                Ingredient.of(BOTTLE_OF_SOMNIUM.get()),
                Ingredient.of(INFECTED_SLIME.get()));
        SomniumInfusingRecipeBuilder.build(consumer, null,
                SOMNIUM_UPGRADE,
                Ingredient.of(ROKA_HORN.get()),
                Ingredient.of(NODE_SHARD.get()),
                Ingredient.of(PHANTOM_SOUL_ITEM.get()),
                Ingredient.of(SOUL_HEART.get()));
        SomniumInfusingRecipeBuilder.buildOneInput(consumer, null,
                ANTI_INFECT_ESSENCE,
                Ingredient.of(ROTTEN_FLESH.get()));
        SomniumInfusingRecipeBuilder.buildOneInput(consumer, null,
                LURKER_JUICE,
                Ingredient.of(LURKER_SOBBER.get()));
    }

    private void buildArcaneRecipes(Consumer<FinishedRecipe> consumer) {
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_TELEPORT.get()),
                RING_OF_RING.get(),
                ENDER_POWDER.get(),
                MUTATED_ENDERPEARL.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_EAGLE.get()),
                RING_OF_RING.get(),
                ENDER_POWDER.get(),
                SCORPION_EYE.get());
        ArcaneCraftingRecipeBuilder.buildFullCircle(consumer, null,
                new ItemStack(RING_OF_INVISIBILITY.get()),
                RING_OF_RING.get(),
                HOLLOW_CRYSTAL_SHARD.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_OCEAN.get()),
                RING_OF_RING.get(),
                Items.WATER_BUCKET,
                LORAN.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_THUNDER.get()),
                RING_OF_RING.get(),
                ABYSS_POWDER.get(),
                ARDOR_POWDER.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_FREEZE.get()),
                RING_OF_RING.get(),
                FROST_POWDER.get(),
                CAVERNA_POWDER.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_TIME.get()),
                RING_OF_FREEZE.get(),
                HOLLOW_POWDER.get(),
                INCORYTHE_GEM.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_SPEED.get()),
                RING_OF_RING.get(),
                ENDER_CRYSTAL_SHARD.get(),
                NODE_SHARD.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_FIRE.get()),
                RING_OF_RING.get(),
                CRIMSON_POWDER.get(),
                Items.BLAZE_POWDER);
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_FIRESTRIKE.get()),
                RING_OF_FIRE.get(),
                CRIMSON_CRYSTAL_SHARD.get(),
                Items.BLAZE_POWDER);
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_FIRESTORM.get()),
                RING_OF_FIRESTRIKE.get(),
                CRIMSON_CRYSTAL_SHARD.get(),
                Items.BLAZE_POWDER);
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_TELEKINETIC.get()),
                RING_OF_RING.get(),
                ENDER_CRYSTAL_SHARD.get(),
                HOLLOW_CRYSTAL_SHARD.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_BLACKSTRIKE.get()),
                RING_OF_TELEKINETIC.get(),
                ENDER_POWDER.get(),
                HOLLOW_CRYSTAL_SHARD.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_CURSE.get()),
                RING_OF_BLACKSTRIKE.get(),
                FEAR_POWDER.get(),
                HOLLOW_CRYSTAL_SHARD.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_REG.get()),
                RING_OF_RING.get(),
                AUREL_POWDER.get(),
                VITAE_STONE.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_ENDER_CHEST.get()),
                RING_OF_RING.get(),
                ENDER_CRYSTAL_SHARD.get(),
                CAVERNA_CRYSTAL.get());
        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_SLIDE.get()),
                RING_OF_RING.get(),
                Items.ELYTRA,
                ENDER_CRYSTAL_SHARD.get());

        TheAbyssRecipeBuilder.saveRecipe(
                new ArcaneCraftingRecipeBuilder(
                        ArcaneStationRecipe.RecipeMode.TWO_INGREDIENTS,
                        List.of(Ingredient.of(ItemTags.BEDS), Ingredient.of(ENDER_CRYSTAL_SHARD.get())),
                        Ingredient.of(RING_OF_RING.get()),
                        new ItemStack(RING_OF_HOME.get())),
                consumer, null
        );

        TheAbyssRecipeBuilder.saveRecipe(
                new ArcaneCraftingRecipeBuilder(
                        ArcaneStationRecipe.RecipeMode.TWO_INGREDIENTS,
                        List.of(Ingredient.of(ENDER_CRYSTAL_SHARD.get()), Ingredient.of(ItemTags.BEDS)),
                        Ingredient.of(RING_OF_RING.get()),
                        new ItemStack(RING_OF_HOME.get())),
                consumer, TheabyssMod.location("%s_mirrored".formatted(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(RING_OF_HOME.get())).getPath())));

        ArcaneCraftingRecipeBuilder.buildFullCircle(consumer, null,
                new ItemStack(RING_OF_NATURE.get()),
                RING_OF_RING.get(),
                Items.BONE);

        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_FLIGHT.get()),
                RING_OF_SLIDE.get(),
                Items.ELYTRA,
                ENDER_CRYSTAL_SHARD.get());

        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_POCKET_BOX.get()),
                RING_OF_RING.get(),
                VIT_POWDER.get(),
                Items.ENDER_CHEST);

        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_SEEKER.get()),
                RING_OF_RING.get(),
                KNIGHT_INGOT.get(),
                TENEBRIS_POWDER.get());

        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_ELECTRO.get()),
                RING_OF_RING.get(),
                ARDOR_POWDER.get(),
                THUNDER_STONE.get());

        ArcaneCraftingRecipeBuilder.buildTwoInputs(consumer, null,
                new ItemStack(RING_OF_FANGS.get()),
                RING_OF_RING.get(),
                ARDOR_POWDER.get(),
                KNIGHT_SHARD.get());
    }
}

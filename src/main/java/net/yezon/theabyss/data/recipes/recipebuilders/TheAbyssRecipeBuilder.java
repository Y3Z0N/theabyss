package net.yezon.theabyss.data.recipes.recipebuilders;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.recipes.AbyssRecipeType;
import net.yezon.theabyss.utils.RecipeUtils;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author KhanhTypo
 */
public abstract class TheAbyssRecipeBuilder implements RecipeBuilder {
    protected final Advancement.Builder advancementBuilder;
    private final ItemStack result;
    private final RecipeSerializer<?> recipeSerializer;

    protected TheAbyssRecipeBuilder(ItemStack result, AbyssRecipeType recipeSerializer) {
        this.result = result;
        this.advancementBuilder = Advancement.Builder.advancement();
        this.recipeSerializer = recipeSerializer.getSerializer();
    }

    public static void saveRecipe(RecipeBuilder recipeBuilder, Consumer<FinishedRecipe> consumer, @Nullable ResourceLocation recipeId) {
        if (recipeId == null) {
            recipeBuilder.save(consumer);
        } else {
            recipeBuilder.save(consumer, recipeId);
        }
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ResourceLocation recipeId = TheabyssMod.location(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(this.getResult())).getPath());
        this.save(pFinishedRecipeConsumer, recipeId);
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String recipePath) {
        this.save(pFinishedRecipeConsumer, TheabyssMod.location(recipePath));
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancementBuilder.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return this.result.getItem();
    }

    public ItemStack getRecipeResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        pFinishedRecipeConsumer.accept(new ImplementedFinishedRecipe(pRecipeId, this));
    }

    protected abstract void toJson(JsonObject jsonObject);

    private record ImplementedFinishedRecipe(ResourceLocation recipeId,
                                             TheAbyssRecipeBuilder builder) implements FinishedRecipe {

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            this.builder.toJson(pJson);
            pJson.add("result", RecipeUtils.itemStackToJson(this.builder.getRecipeResult()));
        }

        @Override
        public ResourceLocation getId() {
            return TheabyssMod.location(this.getSerializerName() + this.recipeId.getPath());
        }

        @Override
        public RecipeSerializer<?> getType() {
            return this.builder.recipeSerializer;
        }

        @Override
        public JsonObject serializeAdvancement() {
            return this.builder.advancementBuilder.serializeToJson();
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return TheabyssMod.location("recipes/" + this.getSerializerName() + this.recipeId.getPath());
        }

        private String getSerializerName() {
            return Objects.requireNonNull(ForgeRegistries.RECIPE_SERIALIZERS.getKey(this.getType())).getPath() + "/";
        }
    }
}

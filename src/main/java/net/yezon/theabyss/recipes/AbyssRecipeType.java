package net.yezon.theabyss.recipes;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yezon.theabyss.TheabyssMod;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author KhanhTypo
 */
public class AbyssRecipeType {
    public static final DeferredRegister<RecipeType<?>> TYPE_REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, TheabyssMod.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TheabyssMod.MODID);

    private final ResourceLocation id;
    private final RecipeDisplayData data;
    private final RegistryObject<RecipeType<Recipe<Container>>> recipeType;
    private final Class<? extends Recipe<Container>> recipeClass;
    private final Component recipeTitle;
    private final RegistryObject<RecipeSerializer<? extends Recipe<Container>>> serializer;

    public AbyssRecipeType(String name, Supplier<RecipeSerializer<? extends Recipe<Container>>> serializer, Class<? extends Recipe<Container>> recipeClass, Component recipeTitle, RecipeDisplayData displayData) {
        this.id = new ResourceLocation(TheabyssMod.MODID, name);
        this.recipeType = TYPE_REGISTRY.register(name, () -> RecipeType.simple(AbyssRecipeType.this.getId()));
        this.recipeClass = recipeClass;
        this.recipeTitle = recipeTitle;
        this.serializer = SERIALIZER_REGISTRY.register(name, serializer);
        this.data = displayData;
        AllRecipeTypes.ALL_RECIPE_TYPES.add(this);
    }

    public static void registerBus(IEventBus bus) {
        TYPE_REGISTRY.register(bus);
        SERIALIZER_REGISTRY.register(bus);
        AllRecipeTypes.staticInit();
    }

    public final RecipeType<Recipe<Container>> getVanillaType() {
        return this.recipeType.get();
    }

    public final RecipeSerializer<? extends Recipe<Container>> getSerializer() {
        return this.serializer.get();
    }

    public ResourceLocation getId() {
        return id;
    }

    public RecipeDisplayData getDisplayData() {
        return data;
    }

    public Class<? extends Recipe<Container>> getRecipeClass() {
        return recipeClass;
    }

    public Component getRecipeTitle() {
        return recipeTitle;
    }

    public List<Recipe<Container>> getAllRecipes(Level level) {
        List<Recipe<Container>> list =  level.getRecipeManager().getAllRecipesFor(this.getVanillaType());
        TheabyssMod.LOGGER.info("Gathering [{}] recipes for type [{}]", list.size(), this.getId());
        return list;
    }
}

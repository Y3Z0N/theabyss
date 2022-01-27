package net.yezon.theabyss.JeiPlugin;

import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.item.WarpedPowderItem;
import net.yezon.theabyss.item.WarpedCrystalShardItem;
import net.yezon.theabyss.item.VitaeStoneItem;
import net.yezon.theabyss.item.VitaeDustItem;
import net.yezon.theabyss.item.VitPowderItem;
import net.yezon.theabyss.item.TenebrisPowderItem;
import net.yezon.theabyss.item.RokaHornItem;
import net.yezon.theabyss.item.LoranItem;
import net.yezon.theabyss.item.HollowPowderItem;
import net.yezon.theabyss.item.HollowCrystalShardItem;
import net.yezon.theabyss.item.FrostPowderItem;
import net.yezon.theabyss.item.FrostCrystalShardItem;
import net.yezon.theabyss.item.FearPowderItem;
import net.yezon.theabyss.item.EnderPowderItem;
import net.yezon.theabyss.item.EnderCrystalShardItem;
import net.yezon.theabyss.item.CrimsonPowderItem;
import net.yezon.theabyss.item.CrimsonCrystalShardItem;
import net.yezon.theabyss.item.CavernaPowderItem;
import net.yezon.theabyss.item.CavernaCrystalItem;
import net.yezon.theabyss.item.BottleOfSomniumItem;
import net.yezon.theabyss.item.AurelPowderItem;
import net.yezon.theabyss.item.AurelCrystalShardItem;
import net.yezon.theabyss.item.ArdorPowderItem;
import net.yezon.theabyss.item.AntiFearEssenceItem;
import net.yezon.theabyss.item.AbyssPowderItem;
import net.yezon.theabyss.item.AbyssCrystalShardItem;
import net.yezon.theabyss.block.MortarAndPestleBlock;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.IModPlugin;

import java.util.List;
import java.util.ArrayList;

@mezz.jei.api.JeiPlugin
public class MortaJeiPlugin implements IModPlugin {
	public static IJeiHelpers jeiHelper;

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("theabyss", "default");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		jeiHelper = registration.getJeiHelpers();
		registration.addRecipeCategories(new InfuseBlockJeiCategory(jeiHelper.getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addRecipes(generateInfuseBlockRecipes2(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes3(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes4(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes5(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes6(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes7(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes8(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes9(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes10(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes11(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes12(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes13(), InfuseBlockJeiCategory.Uid);
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes2() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); //
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); //
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); //
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(CrimsonPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes3() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(AbyssCrystalShardItem.block)); //
		inputs.add(new ItemStack(AbyssCrystalShardItem.block)); //
		inputs.add(new ItemStack(AbyssCrystalShardItem.block)); //
		inputs.add(new ItemStack(AbyssCrystalShardItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(AbyssPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes4() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(AurelCrystalShardItem.block)); //
		inputs.add(new ItemStack(AurelCrystalShardItem.block)); //
		inputs.add(new ItemStack(AurelCrystalShardItem.block)); //
		inputs.add(new ItemStack(AurelCrystalShardItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(AurelPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes5() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(CavernaCrystalItem.block)); //
		inputs.add(new ItemStack(CavernaCrystalItem.block)); //
		inputs.add(new ItemStack(CavernaCrystalItem.block)); //
		inputs.add(new ItemStack(CavernaCrystalItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(CavernaPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes6() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); //
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); //
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); //
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(EnderPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes7() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(FrostCrystalShardItem.block)); //
		inputs.add(new ItemStack(FrostCrystalShardItem.block)); //
		inputs.add(new ItemStack(FrostCrystalShardItem.block)); //
		inputs.add(new ItemStack(FrostCrystalShardItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(FrostPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes8() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); //
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); //
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); //
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(HollowPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes9() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(WarpedCrystalShardItem.block)); //
		inputs.add(new ItemStack(WarpedCrystalShardItem.block)); //
		inputs.add(new ItemStack(WarpedCrystalShardItem.block)); //
		inputs.add(new ItemStack(WarpedCrystalShardItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(WarpedPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes10() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(VitaeStoneItem.block)); //
		inputs.add(new ItemStack(VitaeStoneItem.block)); //
		inputs.add(new ItemStack(VitaeStoneItem.block)); //
		inputs.add(new ItemStack(VitaeStoneItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(VitPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes11() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RokaHornItem.block)); //
		inputs.add(new ItemStack(RokaHornItem.block)); //
		inputs.add(new ItemStack(RokaHornItem.block)); //
		inputs.add(new ItemStack(RokaHornItem.block)); //
		inputs.add(new ItemStack(AntiFearEssenceItem.block)); // Essence
		outputs.add(new ItemStack(FearPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes12() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(LoranItem.block)); //
		inputs.add(new ItemStack(VitaeDustItem.block)); //
		inputs.add(new ItemStack(LoranItem.block)); //
		inputs.add(new ItemStack(VitaeDustItem.block)); //
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // Essence
		outputs.add(new ItemStack(ArdorPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes13() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(CavernaPowderItem.block)); //
		inputs.add(new ItemStack(RokaHornItem.block)); //
		inputs.add(new ItemStack(CavernaPowderItem.block)); //
		inputs.add(new ItemStack(RokaHornItem.block)); //
		inputs.add(new ItemStack(AntiFearEssenceItem.block)); // Essence
		outputs.add(new ItemStack(TenebrisPowderItem.block)); // Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	// ((Slot) ((Map) invobj).get((int) (5))).decrStackSize((int) (8)); - This Is How We Check For How Many Items Are Needed
	// }.getAmount((int) (1)) == 8 && new Object() { - Check How Many Resources Are Needed To Craft For JEI Plugin
	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(MortarAndPestleBlock.block), InfuseBlockJeiCategory.Uid);
	}

	public static class InfuseBlockJeiCategory implements IRecipeCategory<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> {
		private static ResourceLocation Uid = new ResourceLocation("theabyss", "mortarcategory");
		private static final int input1 = 0; // THE NUMBER = SLOTID
		private static final int input2 = 2; // THE NUMBER = SLOTID
		private static final int input3 = 3; // THE NUMBER = SLOTID
		private static final int input4 = 4; // THE NUMBER = SLOTID
		private static final int input5 = 5; // THE NUMBER = SLOTID
		private static final int output1 = 1; // THE NUMBER = SLOTID
		// ...
		private final String title;
		private final IDrawable background;

		public InfuseBlockJeiCategory(IGuiHelper guiHelper) {
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			int ValX = ((int) ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).HudX));
			int ValY = ((int) ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).HudY));
			this.title = "Mortar And Pestle";
			this.background = guiHelper.createDrawable(new ResourceLocation("theabyss", "textures/morta_gui.png"), -1, -1, 176, 200);
		}

		@Override
		public ResourceLocation getUid() {
			return Uid;
		}

		@Override
		public Class<? extends InfuseBlockRecipeWrapper> getRecipeClass() {
			return InfuseBlockJeiCategory.InfuseBlockRecipeWrapper.class;
		}

		@Override
		public String getTitle() {
			return title;
		}

		@Override
		public IDrawable getBackground() {
			return background;
		}

		@Override
		public IDrawable getIcon() {
			return null;
		}

		@Override
		public void setIngredients(InfuseBlockRecipeWrapper recipeWrapper, IIngredients iIngredients) {
			iIngredients.setInputs(VanillaTypes.ITEM, recipeWrapper.getInput());
			iIngredients.setOutputs(VanillaTypes.ITEM, recipeWrapper.getOutput());
			// ...
		}

		@Override
		public void setRecipe(IRecipeLayout iRecipeLayout, InfuseBlockRecipeWrapper recipeWrapper, IIngredients iIngredients) {
			IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
			stacks.init(input1, true, 26, 43); //Item
			stacks.set(input1, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
			// ,,,
			stacks.init(input2, true, 44, 25); //Item
			stacks.set(input2, iIngredients.getInputs(VanillaTypes.ITEM).get(1));
			// ,,,
			stacks.init(input3, true, 62, 43); //Item
			stacks.set(input3, iIngredients.getInputs(VanillaTypes.ITEM).get(2));
			// ,,,
			stacks.init(input4, true, 44, 61); //Item
			stacks.set(input4, iIngredients.getInputs(VanillaTypes.ITEM).get(3));
			// ,,,
			stacks.init(input5, true, 44, 43); //Essence
			stacks.set(input5, iIngredients.getInputs(VanillaTypes.ITEM).get(4));
			// ,,,
			stacks.init(output1, false, 134, 43); //Output
			stacks.set(output1, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
			// ...
		}

		public static class InfuseBlockRecipeWrapper {
			private ArrayList input;
			private ArrayList output;

			public InfuseBlockRecipeWrapper(ArrayList input, ArrayList output) {
				this.input = input;
				this.output = output;
			}

			public ArrayList getInput() {
				return input;
			}

			public ArrayList getOutput() {
				return output;
			}
		}
	}
}

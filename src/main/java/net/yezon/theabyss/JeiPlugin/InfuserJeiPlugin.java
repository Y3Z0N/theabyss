package net.yezon.theabyss.JeiPlugin;

import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.item.SoulHeartItem;
import net.yezon.theabyss.item.SomniumUpgradeItem;
import net.yezon.theabyss.item.SomniumRegenUpgradeItem;
import net.yezon.theabyss.item.SomniumItem;
import net.yezon.theabyss.item.SomniumDamageUpragdeItem;
import net.yezon.theabyss.item.SomniumCooldownUpgradeItem;
import net.yezon.theabyss.item.SlimeStage4Item;
import net.yezon.theabyss.item.RottenFleshItem;
import net.yezon.theabyss.item.RokaHornItem;
import net.yezon.theabyss.item.PhantomSoulItemItem;
import net.yezon.theabyss.item.PhantomEssenceItem;
import net.yezon.theabyss.item.NodeShardItem;
import net.yezon.theabyss.item.LurkerSobberItem;
import net.yezon.theabyss.item.LurkerJuiceItem;
import net.yezon.theabyss.item.LoranEnergyItem;
import net.yezon.theabyss.item.ImmortalSubstanceItem;
import net.yezon.theabyss.item.ElderEyeItem;
import net.yezon.theabyss.item.CrystalHandItem;
import net.yezon.theabyss.item.CreeperDustItem;
import net.yezon.theabyss.item.BottleOfSomniumItem;
import net.yezon.theabyss.item.AppleOfImmortalityItem;
import net.yezon.theabyss.item.AntiInfectEssenceItem;
import net.yezon.theabyss.item.AntiFearEssenceItem;
import net.yezon.theabyss.block.SomniumInfuserBlock;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
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
public class InfuserJeiPlugin implements IModPlugin {
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
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes2() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(AppleOfImmortalityItem.block)); // 0
		inputs.add(new ItemStack(Items.APPLE)); // 1
		inputs.add(new ItemStack(AppleOfImmortalityItem.block)); // SOMNIUM USE ALWAYS 2
		inputs.add(new ItemStack(Items.APPLE)); // SOMNIUM USE ALWAYS 3
		inputs.add(new ItemStack(LoranEnergyItem.block)); // LORAN ENERGY USE ALWAYS 4
		inputs.add(new ItemStack(SomniumItem.block)); // SOMNIUM USE ALWAYS 5
		outputs.add(new ItemStack(ImmortalSubstanceItem.block));
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes3() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(NodeShardItem.block)); // 0
		inputs.add(new ItemStack(CrystalHandItem.block)); // 1
		inputs.add(new ItemStack(NodeShardItem.block)); // SOMNIUM USE ALWAYS 2
		inputs.add(new ItemStack(CrystalHandItem.block)); // SOMNIUM USE ALWAYS 3
		inputs.add(new ItemStack(LoranEnergyItem.block)); // LORAN ENERGY USE ALWAYS 4
		inputs.add(new ItemStack(SomniumItem.block)); // SOMNIUM USE ALWAYS 5
		outputs.add(new ItemStack(SomniumCooldownUpgradeItem.block));
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes4() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RokaHornItem.block)); // 0
		inputs.add(new ItemStack(ElderEyeItem.block)); // 1
		inputs.add(new ItemStack(CrystalHandItem.block)); // SOMNIUM USE ALWAYS 2
		inputs.add(new ItemStack(CreeperDustItem.block)); // SOMNIUM USE ALWAYS 3
		inputs.add(new ItemStack(LoranEnergyItem.block)); // LORAN ENERGY USE ALWAYS 4
		inputs.add(new ItemStack(SomniumItem.block)); // SOMNIUM USE ALWAYS 5
		outputs.add(new ItemStack(SomniumDamageUpragdeItem.block));
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes5() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RokaHornItem.block)); // 0
		inputs.add(new ItemStack(RokaHornItem.block)); // 1
		inputs.add(new ItemStack(RokaHornItem.block)); // SOMNIUM USE ALWAYS 2
		inputs.add(new ItemStack(RokaHornItem.block)); // SOMNIUM USE ALWAYS 3
		inputs.add(new ItemStack(LoranEnergyItem.block)); // LORAN ENERGY USE ALWAYS 4
		inputs.add(new ItemStack(SomniumItem.block)); // SOMNIUM USE ALWAYS 5
		outputs.add(new ItemStack(AntiFearEssenceItem.block));
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes6() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RokaHornItem.block)); // 0
		inputs.add(new ItemStack(PhantomEssenceItem.block)); // 1
		inputs.add(new ItemStack(BottleOfSomniumItem.block)); // SOMNIUM USE ALWAYS 2
		inputs.add(new ItemStack(SlimeStage4Item.block)); // SOMNIUM USE ALWAYS 3
		inputs.add(new ItemStack(LoranEnergyItem.block)); // LORAN ENERGY USE ALWAYS 4
		inputs.add(new ItemStack(SomniumItem.block)); // SOMNIUM USE ALWAYS 5
		outputs.add(new ItemStack(SomniumRegenUpgradeItem.block));
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes7() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RokaHornItem.block)); // 0
		inputs.add(new ItemStack(NodeShardItem.block)); // SOMNIUM USE ALWAYS 2
		inputs.add(new ItemStack(PhantomSoulItemItem.block)); // SOMNIUM USE ALWAYS 3
		inputs.add(new ItemStack(SoulHeartItem.block)); // SOMNIUM USE ALWAYS 5
		inputs.add(new ItemStack(LoranEnergyItem.block)); // LORAN ENERGY USE ALWAYS 4
		inputs.add(new ItemStack(SomniumItem.block)); // SOMNIUM USE ALWAYS 5
		outputs.add(new ItemStack(SomniumUpgradeItem.block));
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes8() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RottenFleshItem.block)); // 0
		inputs.add(new ItemStack(RottenFleshItem.block)); // SOMNIUM USE ALWAYS 2
		inputs.add(new ItemStack(RottenFleshItem.block)); // SOMNIUM USE ALWAYS 3
		inputs.add(new ItemStack(RottenFleshItem.block)); // SOMNIUM USE ALWAYS 5
		inputs.add(new ItemStack(LoranEnergyItem.block)); // LORAN ENERGY USE ALWAYS 4
		inputs.add(new ItemStack(SomniumItem.block)); // SOMNIUM USE ALWAYS 5
		outputs.add(new ItemStack(AntiInfectEssenceItem.block));
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes9() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(LurkerSobberItem.block)); // 0
		inputs.add(new ItemStack(LurkerSobberItem.block)); // SOMNIUM USE ALWAYS 2
		inputs.add(new ItemStack(LurkerSobberItem.block)); // SOMNIUM USE ALWAYS 3
		inputs.add(new ItemStack(LurkerSobberItem.block)); // SOMNIUM USE ALWAYS 5
		inputs.add(new ItemStack(LoranEnergyItem.block)); // LORAN ENERGY USE ALWAYS 4
		inputs.add(new ItemStack(SomniumItem.block)); // SOMNIUM USE ALWAYS 5
		outputs.add(new ItemStack(LurkerJuiceItem.block));
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(SomniumInfuserBlock.block), InfuseBlockJeiCategory.Uid);
	}

	public static class InfuseBlockJeiCategory implements IRecipeCategory<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> {
		private static ResourceLocation Uid = new ResourceLocation("theabyss", "infuseblockcategory");
		private static final int input1 = 0; // THE NUMBER = SLOTID
		private static final int input2 = 2; // THE NUMBER = SLOTID
		private static final int input3 = 3; // THE NUMBER = SLOTID
		private static final int input4 = 4; // THE NUMBER = SLOTID
		private static final int input5 = 5; // THE NUMBER = SLOTID
		private static final int input6 = 6; // THE NUMBER = SLOTID
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
			this.title = "Infuse Bench";
			this.background = guiHelper.createDrawable(new ResourceLocation("theabyss", "textures/somnium_infuser_gui.png"), -1, -1, 176, 166);
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
			stacks.init(input1, true, 28, 42);
			stacks.set(input1, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
			// ,,,
			stacks.init(input2, true, 54, 50);
			stacks.set(input2, iIngredients.getInputs(VanillaTypes.ITEM).get(1));
			// ,,,
			stacks.init(input3, true, 106, 50);
			stacks.set(input3, iIngredients.getInputs(VanillaTypes.ITEM).get(2));
			// ,,,
			stacks.init(input4, true, 132, 42);
			stacks.set(input4, iIngredients.getInputs(VanillaTypes.ITEM).get(3));
			// ,,,
			stacks.init(input5, true, 80, 16); //Loran Energy
			stacks.set(input5, iIngredients.getInputs(VanillaTypes.ITEM).get(4));
			// ,,,
			stacks.init(input6, true, 36, 11); // Somnium
			stacks.set(input6, iIngredients.getInputs(VanillaTypes.ITEM).get(5));
			// ,,,
			stacks.init(output1, false, 80, 59);
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

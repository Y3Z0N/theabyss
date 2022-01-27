package net.yezon.theabyss.JeiPlugin;

import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.item.VitaeStoneItem;
import net.yezon.theabyss.item.VitPowderItem;
import net.yezon.theabyss.item.ThunderStoneItem;
import net.yezon.theabyss.item.TenebrisPowderItem;
import net.yezon.theabyss.item.ScorpionEyeItem;
import net.yezon.theabyss.item.RokaHornItem;
import net.yezon.theabyss.item.RingOfTimeItem;
import net.yezon.theabyss.item.RingOfThunderItem;
import net.yezon.theabyss.item.RingOfTeleportItem;
import net.yezon.theabyss.item.RingOfTelekineticItem;
import net.yezon.theabyss.item.RingOfSpeedItem;
import net.yezon.theabyss.item.RingOfSlideItem;
import net.yezon.theabyss.item.RingOfSeekerItem;
import net.yezon.theabyss.item.RingOfRingItem;
import net.yezon.theabyss.item.RingOfRegItem;
import net.yezon.theabyss.item.RingOfPocketBoxItem;
import net.yezon.theabyss.item.RingOfOceanItem;
import net.yezon.theabyss.item.RingOfNatureItem;
import net.yezon.theabyss.item.RingOfJuggerItem;
import net.yezon.theabyss.item.RingOfInvisibilityItem;
import net.yezon.theabyss.item.RingOfHomeItem;
import net.yezon.theabyss.item.RingOfFreezeItem;
import net.yezon.theabyss.item.RingOfFlightItem;
import net.yezon.theabyss.item.RingOfFirestrikeItem;
import net.yezon.theabyss.item.RingOfFirestormItem;
import net.yezon.theabyss.item.RingOfFireItem;
import net.yezon.theabyss.item.RingOfFangsItem;
import net.yezon.theabyss.item.RingOfEnderChestItem;
import net.yezon.theabyss.item.RingOfElectroItem;
import net.yezon.theabyss.item.RingOfEagleItem;
import net.yezon.theabyss.item.RingOfCurseItem;
import net.yezon.theabyss.item.RingOfBlackstrikeItem;
import net.yezon.theabyss.item.NodeShardItem;
import net.yezon.theabyss.item.MutatedEnderpearlItem;
import net.yezon.theabyss.item.LoranItem;
import net.yezon.theabyss.item.KnightShardItem;
import net.yezon.theabyss.item.KnightIngotItem;
import net.yezon.theabyss.item.IncorytheGemItem;
import net.yezon.theabyss.item.HollowPowderItem;
import net.yezon.theabyss.item.HollowCrystalShardItem;
import net.yezon.theabyss.item.FrostPowderItem;
import net.yezon.theabyss.item.FearPowderItem;
import net.yezon.theabyss.item.EnderPowderItem;
import net.yezon.theabyss.item.EnderCrystalShardItem;
import net.yezon.theabyss.item.CrimsonPowderItem;
import net.yezon.theabyss.item.CrimsonCrystalShardItem;
import net.yezon.theabyss.item.CavernaPowderItem;
import net.yezon.theabyss.item.CavernaCrystalItem;
import net.yezon.theabyss.item.AurelPowderItem;
import net.yezon.theabyss.item.ArdorPowderItem;
import net.yezon.theabyss.item.AbyssPowderItem;
import net.yezon.theabyss.item.AbyssCrystalShardItem;
import net.yezon.theabyss.block.ArcaneWorkbenchBlock;

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
public class ArcaneJeiPlugin implements IModPlugin {
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
		registration.addRecipes(generateInfuseBlockRecipes14(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes15(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes16(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes17(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes18(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes19(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes20(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes21(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes22(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes23(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes24(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes25(), InfuseBlockJeiCategory.Uid);
		registration.addRecipes(generateInfuseBlockRecipes26(), InfuseBlockJeiCategory.Uid);
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes2() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderPowderItem.block)); //
		inputs.add(new ItemStack(MutatedEnderpearlItem.block)); //
		inputs.add(new ItemStack(EnderPowderItem.block)); //
		inputs.add(new ItemStack(MutatedEnderpearlItem.block)); //
		inputs.add(new ItemStack(EnderPowderItem.block)); //
		inputs.add(new ItemStack(MutatedEnderpearlItem.block)); //
		inputs.add(new ItemStack(EnderPowderItem.block)); //
		inputs.add(new ItemStack(MutatedEnderpearlItem.block)); //
		outputs.add(new ItemStack(RingOfTeleportItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes3() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderPowderItem.block)); //
		inputs.add(new ItemStack(ScorpionEyeItem.block)); //
		inputs.add(new ItemStack(EnderPowderItem.block)); //
		inputs.add(new ItemStack(ScorpionEyeItem.block)); //
		inputs.add(new ItemStack(EnderPowderItem.block)); //
		inputs.add(new ItemStack(ScorpionEyeItem.block)); //
		inputs.add(new ItemStack(EnderPowderItem.block)); //
		inputs.add(new ItemStack(ScorpionEyeItem.block)); //
		outputs.add(new ItemStack(RingOfEagleItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes4() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfInvisibilityItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes5() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.WATER_BUCKET)); // Should Be A Ring As Input
		inputs.add(new ItemStack(LoranItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.WATER_BUCKET)); // Should Be A Ring As Input
		inputs.add(new ItemStack(LoranItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.WATER_BUCKET)); // Should Be A Ring As Input
		inputs.add(new ItemStack(LoranItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.WATER_BUCKET)); // Should Be A Ring As Input
		inputs.add(new ItemStack(LoranItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfOceanItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes6() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AbyssPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AbyssPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AbyssPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AbyssPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfThunderItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes7() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(FrostPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CavernaPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(FrostPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CavernaPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(FrostPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CavernaPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(FrostPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CavernaPowderItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfFreezeItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes8() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AbyssCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(RokaHornItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AbyssCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(RokaHornItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AbyssCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(RokaHornItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AbyssCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(RokaHornItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfJuggerItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes9() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfFreezeItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(IncorytheGemItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(IncorytheGemItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(IncorytheGemItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(IncorytheGemItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfTimeItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes10() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(NodeShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(NodeShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(NodeShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(NodeShardItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfSpeedItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes11() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfFireItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes12() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfFireItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfFirestrikeItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes13() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfFirestrikeItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CrimsonCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BLAZE_ROD)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfFirestormItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes14() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfTelekineticItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes15() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfTelekineticItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfBlackstrikeItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes16() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfBlackstrikeItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(FearPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(FearPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(FearPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(FearPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(HollowCrystalShardItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfCurseItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes17() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AurelPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(VitaeStoneItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AurelPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(VitaeStoneItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AurelPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(VitaeStoneItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(AurelPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(VitaeStoneItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfRegItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes18() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CavernaCrystalItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CavernaCrystalItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CavernaCrystalItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(CavernaCrystalItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfEnderChestItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes19() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ELYTRA)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ELYTRA)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ELYTRA)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ELYTRA)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfSlideItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes20() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.WHITE_BED)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.WHITE_BED)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.WHITE_BED)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.WHITE_BED)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfHomeItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes21() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BONE)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BONE)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BONE)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BONE)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BONE)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BONE)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BONE)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.BONE)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfNatureItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes22() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfSlideItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ELYTRA)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ELYTRA)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ELYTRA)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ELYTRA)); // Should Be A Ring As Input
		inputs.add(new ItemStack(EnderCrystalShardItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfFlightItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes23() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(VitPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ENDER_CHEST)); // Should Be A Ring As Input
		inputs.add(new ItemStack(VitPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ENDER_CHEST)); // Should Be A Ring As Input
		inputs.add(new ItemStack(VitPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ENDER_CHEST)); // Should Be A Ring As Input
		inputs.add(new ItemStack(VitPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(Items.ENDER_CHEST)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfPocketBoxItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes24() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(KnightIngotItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(TenebrisPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(KnightIngotItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(TenebrisPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(KnightIngotItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(TenebrisPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(KnightIngotItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(TenebrisPowderItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfSeekerItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes25() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ThunderStoneItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ThunderStoneItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ThunderStoneItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ThunderStoneItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfElectroItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	private List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> generateInfuseBlockRecipes26() {
		List<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(RingOfRingItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(KnightShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(KnightShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(KnightShardItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(ArdorPowderItem.block)); // Should Be A Ring As Input
		inputs.add(new ItemStack(KnightShardItem.block)); // Should Be A Ring As Input
		outputs.add(new ItemStack(RingOfFangsItem.block)); // Shoould Be A Ring As Result
		recipes.add(new InfuseBlockJeiCategory.InfuseBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	// ((Slot) ((Map) invobj).get((int) (5))).decrStackSize((int) (8)); - This Is How We Check For How Many Items Are Needed
	// }.getAmount((int) (1)) == 8 && new Object() { - Check How Many Resources Are Needed To Craft For JEI Plugin
	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ArcaneWorkbenchBlock.block), InfuseBlockJeiCategory.Uid);
	}

	public static class InfuseBlockJeiCategory implements IRecipeCategory<InfuseBlockJeiCategory.InfuseBlockRecipeWrapper> {
		private static ResourceLocation Uid = new ResourceLocation("theabyss", "arcanecategory");
		private static final int input1 = 0; // THE NUMBER = SLOTID
		private static final int input2 = 2; // THE NUMBER = SLOTID
		private static final int input3 = 3; // THE NUMBER = SLOTID
		private static final int input4 = 4; // THE NUMBER = SLOTID
		private static final int input5 = 5; // THE NUMBER = SLOTID
		private static final int input6 = 6; // THE NUMBER = SLOTID
		private static final int input7 = 7; // THE NUMBER = SLOTID
		private static final int input8 = 8; // THE NUMBER = SLOTID
		private static final int input9 = 9; // THE NUMBER = SLOTID
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
			this.title = "Arcane";
			this.background = guiHelper.createDrawable(new ResourceLocation("theabyss", "textures/arcane_gui.png"), -1, -1, 176, 200);
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
			stacks.init(input1, true, 44, 43);
			stacks.set(input1, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
			// ,,,
			stacks.init(input2, true, 8, 43);
			stacks.set(input2, iIngredients.getInputs(VanillaTypes.ITEM).get(1));
			// ,,,
			stacks.init(input3, true, 17, 16);
			stacks.set(input3, iIngredients.getInputs(VanillaTypes.ITEM).get(2));
			// ,,,
			stacks.init(input4, true, 44, 7);
			stacks.set(input4, iIngredients.getInputs(VanillaTypes.ITEM).get(3));
			// ,,,
			stacks.init(input5, true, 71, 16); //Loran Energy
			stacks.set(input5, iIngredients.getInputs(VanillaTypes.ITEM).get(4));
			// ,,,
			stacks.init(input6, true, 80, 43); // Somnium
			stacks.set(input6, iIngredients.getInputs(VanillaTypes.ITEM).get(5));
			// ,,,
			stacks.init(input7, true, 71, 70); // Somnium
			stacks.set(input7, iIngredients.getInputs(VanillaTypes.ITEM).get(6));
			// ,,,
			stacks.init(input8, true, 44, 79); // Somnium
			stacks.set(input8, iIngredients.getInputs(VanillaTypes.ITEM).get(7));
			// ,,,
			stacks.init(input9, true, 17, 70); // Somnium
			stacks.set(input9, iIngredients.getInputs(VanillaTypes.ITEM).get(8));
			// ,,,
			stacks.init(output1, false, 152, 43);
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

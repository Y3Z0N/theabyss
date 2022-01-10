
package net.yezon.theabyss.item;

import net.yezon.theabyss.itemgroup.TheAbyssItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@TheAbyss.Processor.Tag
public class RingOfEnderChestItem extends TheAbyss.Processor {
	public static final TranslationTextComponent field_220115_d = new TranslationTextComponent("item.theabyss.ringofender");
	@ObjectHolder("theabyss:ring_of_ender_chest")
	public static final Item block = null;
	public RingOfEnderChestItem(TheAbyss instance) {
		super(instance, 1133);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TheAbyssItemGroup.tab).maxDamage(250).rarity(Rarity.UNCOMMON));
			setRegistryName("ring_of_ender_chest");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}

			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
	{
		
		EnderChestInventory enderChest = player.getInventoryEnderChest();
		
		if (enderChest != null)
		{
			if (!world.isRemote)
			{
				
				 player.openContainer(new SimpleNamedContainerProvider((p_220114_1_, p_220114_2_, p_220114_3_) -> {
		               return ChestContainer.createGeneric9X3(p_220114_1_, p_220114_2_, enderChest);
		               
		            }, field_220115_d));
			}
		}
		return new ActionResult<ItemStack>(ActionResultType.PASS, player.getHeldItem(hand));
	}


		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
list.add(new StringTextComponent("\u18B1 0.0 \u18B4 100.0 \u18B9 Right Click"));
list.add(new StringTextComponent("\u00A7bAbility\u00A7f: Your Ender Chest to go!"));
list.add(new StringTextComponent("It uses \u00A7b0 percent somnium\u00A7f."));
list.add(new StringTextComponent(""));
list.add(new StringTextComponent("This item must be produced in the \u00A7bArcane Workbench.\u00A7f"));
		}
	}
}

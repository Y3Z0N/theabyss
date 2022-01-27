
package net.yezon.theabyss.item;

import net.yezon.theabyss.itemgroup.TheAbyssItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@TheAbyss.Processor.Tag
public class LurkerSobberItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:lurker_sobber")
	public static final Item block = null;

	public LurkerSobberItem(TheAbyss instance) {
		super(instance, 128);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TheAbyssItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE));
			setRegistryName("lurker_sobber");
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
			return 1F;
		}
	}
}

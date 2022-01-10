
package net.yezon.theabyss.item;

import net.yezon.theabyss.itemgroup.TheAbyssItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@TheAbyss.Processor.Tag
public class CookedDeerBeefItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:cooked_deer_beef")
	public static final Item block = null;

	public CookedDeerBeefItem(TheAbyss instance) {
		super(instance, 135);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(TheAbyssItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(0.3f)

							.build()));
			setRegistryName("cooked_deer_beef");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}


package net.yezon.theabyss.item;

import net.yezon.theabyss.itemgroup.TheAbyssToolsItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@TheAbyss.Processor.Tag
public class AberytheHoeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:aberythe_hoe")
	public static final Item block = null;

	public AberytheHoeItem(TheAbyss instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 7.5f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 11;
			}

			public int getEnchantability() {
				return 8;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AberytheGemItem.block));
			}
		}, 0, -2f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("aberythe_hoe"));
	}
}

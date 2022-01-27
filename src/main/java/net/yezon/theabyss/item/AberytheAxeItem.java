
package net.yezon.theabyss.item;

import net.yezon.theabyss.itemgroup.TheAbyssToolsItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

@TheAbyss.Processor.Tag
public class AberytheAxeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:aberythe_axe")
	public static final Item block = null;

	public AberytheAxeItem(TheAbyss instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 7.5f;
			}

			public float getAttackDamage() {
				return 10f;
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
		}, 1, -1.5f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("aberythe_axe"));
	}
}

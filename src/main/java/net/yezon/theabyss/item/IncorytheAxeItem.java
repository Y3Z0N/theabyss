
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
public class IncorytheAxeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:incorythe_axe")
	public static final Item block = null;

	public IncorytheAxeItem(TheAbyss instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 13.8f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 42;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(IncorytheGemItem.block));
			}
		}, 1, -3f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("incorythe_axe"));
	}
}

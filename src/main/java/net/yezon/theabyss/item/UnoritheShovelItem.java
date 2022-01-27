
package net.yezon.theabyss.item;

import net.yezon.theabyss.itemgroup.TheAbyssToolsItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@TheAbyss.Processor.Tag
public class UnoritheShovelItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:unorithe_shovel")
	public static final Item block = null;

	public UnoritheShovelItem(TheAbyss instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 14.5f;
			}

			public float getAttackDamage() {
				return 8.1f;
			}

			public int getHarvestLevel() {
				return 9;
			}

			public int getEnchantability() {
				return 51;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(UnoritheIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("unorithe_shovel"));
	}
}

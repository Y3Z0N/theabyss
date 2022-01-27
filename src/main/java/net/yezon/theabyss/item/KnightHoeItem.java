
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
public class KnightHoeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:knight_hoe")
	public static final Item block = null;

	public KnightHoeItem(TheAbyss instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 15.5f;
			}

			public float getAttackDamage() {
				return 11.3f;
			}

			public int getHarvestLevel() {
				return 13;
			}

			public int getEnchantability() {
				return 51;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(KnightIngotItem.block));
			}
		}, 0, -2f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("knight_hoe"));
	}
}

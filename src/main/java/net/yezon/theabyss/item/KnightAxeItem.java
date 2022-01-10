
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
public class KnightAxeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:knight_axe")
	public static final Item block = null;

	public KnightAxeItem(TheAbyss instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 20.5f;
			}

			public int getHarvestLevel() {
				return 8;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(KnightIngotItem.block));
			}
		}, 1, -2f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("knight_axe"));
	}
}

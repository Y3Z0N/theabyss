
package net.yezon.theabyss.item;

import net.yezon.theabyss.itemgroup.TheAbyssToolsItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@TheAbyss.Processor.Tag
public class KnightPickAxeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:knight_pick_axe")
	public static final Item block = null;

	public KnightPickAxeItem(TheAbyss instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 14.5f;
			}

			public float getAttackDamage() {
				return 12f;
			}

			public int getHarvestLevel() {
				return 10;
			}

			public int getEnchantability() {
				return 52;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(KnightIngotItem.block));
			}
		}, 1, -1.5f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("knight_pick_axe"));
	}
}

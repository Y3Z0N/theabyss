
package net.yezon.theabyss.item;

import net.yezon.theabyss.itemgroup.TheAbyssWeaponsItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@TheAbyss.Processor.Tag
public class IncorytheSwordItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:incorythe_sword")
	public static final Item block = null;

	public IncorytheSwordItem(TheAbyss instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 28f;
			}

			public float getAttackDamage() {
				return 4.5f;
			}

			public int getHarvestLevel() {
				return 40;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(IncorytheGemItem.block));
			}
		}, 3, -1.5f, new Item.Properties().group(TheAbyssWeaponsItemGroup.tab)) {
		}.setRegistryName("incorythe_sword"));
	}
}

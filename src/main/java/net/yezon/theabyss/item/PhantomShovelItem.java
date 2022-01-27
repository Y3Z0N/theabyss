
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
public class PhantomShovelItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:phantom_shovel")
	public static final Item block = null;

	public PhantomShovelItem(TheAbyss instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 5.8f;
			}

			public int getHarvestLevel() {
				return 8;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PhantomIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("phantom_shovel"));
	}
}

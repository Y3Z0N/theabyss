
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
public class PhantomSwordItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:phantom_sword")
	public static final Item block = null;

	public PhantomSwordItem(TheAbyss instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 40f;
			}

			public float getAttackDamage() {
				return 8.5f;
			}

			public int getHarvestLevel() {
				return 50;
			}

			public int getEnchantability() {
				return 40;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PhantomEssenceItem.block));
			}
		}, 3, -1.8f, new Item.Properties().group(TheAbyssWeaponsItemGroup.tab)) {
		}.setRegistryName("phantom_sword"));
	}
}

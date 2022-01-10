
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
public class FusionSwordItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:fusion_sword")
	public static final Item block = null;

	public FusionSwordItem(TheAbyss instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1600;
			}

			public float getEfficiency() {
				return 33f;
			}

			public float getAttackDamage() {
				return 8.2f;
			}

			public int getHarvestLevel() {
				return 50;
			}

			public int getEnchantability() {
				return 40;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FusionIngotItem.block));
			}
		}, 3, -1.8f, new Item.Properties().group(TheAbyssWeaponsItemGroup.tab)) {
		}.setRegistryName("fusion_sword"));
	}
}


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
public class FusionHoeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:fusion_hoe")
	public static final Item block = null;

	public FusionHoeItem(TheAbyss instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1600;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 5.5f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FusionIngotItem.block));
			}
		}, 0, -1f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("fusion_hoe"));
	}
}

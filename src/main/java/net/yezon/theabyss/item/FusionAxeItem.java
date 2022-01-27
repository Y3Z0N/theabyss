
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
public class FusionAxeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:fusion_axe")
	public static final Item block = null;

	public FusionAxeItem(TheAbyss instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1600;
			}

			public float getEfficiency() {
				return 30f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FusionIngotItem.block));
			}
		}, 1, -1f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("fusion_axe"));
	}
}

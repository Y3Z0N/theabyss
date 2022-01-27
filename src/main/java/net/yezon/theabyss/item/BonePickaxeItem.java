
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
public class BonePickaxeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:bone_pickaxe")
	public static final Item block = null;

	public BonePickaxeItem(TheAbyss instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 323;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 17;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FixedBoneItem.block));
			}
		}, 1, -3f, new Item.Properties().group(TheAbyssToolsItemGroup.tab)) {
		}.setRegistryName("bone_pickaxe"));
	}
}


package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

public class AboranysAxeItem extends AxeItem {
	public AboranysAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 1200;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 11.5f;
			}

			public int getLevel() {
				return 16;
			}

			public int getEnchantmentValue() {
				return 8;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheabyssModItems.ABORANYS_GEM.get()));
			}
		}, 1, -2f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_TOOLS));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}

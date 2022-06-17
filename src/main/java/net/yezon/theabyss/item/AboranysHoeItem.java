
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

public class AboranysHoeItem extends HoeItem {
	public AboranysHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 1200;
			}

			public float getSpeed() {
				return 7.5f;
			}

			public float getAttackDamageBonus() {
				return 4.2f;
			}

			public int getLevel() {
				return 11;
			}

			public int getEnchantmentValue() {
				return 8;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 0, -2f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_TOOLS));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}


package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

public class AberytheHoeItem extends HoeItem {
	public AberytheHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 1000;
			}

			public float getSpeed() {
				return 7.5f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 11;
			}

			public int getEnchantmentValue() {
				return 8;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheabyssModItems.ABERYTHE_GEM.get()));
			}
		}, 0, -2f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_TOOLS));
	}
}

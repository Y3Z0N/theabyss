
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

public class KnightHoeItem extends HoeItem {
	public KnightHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 4000;
			}

			public float getSpeed() {
				return 15.5f;
			}

			public float getAttackDamageBonus() {
				return 11.3f;
			}

			public int getLevel() {
				return 13;
			}

			public int getEnchantmentValue() {
				return 51;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheabyssModItems.KNIGHT_INGOT.get()));
			}
		}, 0, -2f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_TOOLS));
	}
}

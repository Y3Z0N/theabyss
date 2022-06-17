
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;

public class BrickedKnightSwordItem extends SwordItem {
	public BrickedKnightSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 1600;
			}

			public float getSpeed() {
				return 40f;
			}

			public float getAttackDamageBonus() {
				return 13f;
			}

			public int getLevel() {
				return 50;
			}

			public int getEnchantmentValue() {
				return 40;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -2f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_WEAPONS));
	}
}

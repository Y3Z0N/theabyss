
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class UnoritheSwordItem extends SwordItem {
	public UnoritheSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 3000;
			}

			public float getSpeed() {
				return 40f;
			}

			public float getAttackDamageBonus() {
				return 12f;
			}

			public int getLevel() {
				return 50;
			}

			public int getEnchantmentValue() {
				return 40;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheabyssModItems.UNORITHE_INGOT.get()));
			}
		}, 3, -1.4f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_WEAPONS));
	}
}

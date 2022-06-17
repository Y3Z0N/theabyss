
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class AberytheSwordItem extends SwordItem {
	public AberytheSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 1000;
			}

			public float getSpeed() {
				return 10f;
			}

			public float getAttackDamageBonus() {
				return 4.4f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 100;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheabyssModItems.ABERYTHE_GEM.get()));
			}
		}, 3, -2.2000000000000002f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_WEAPONS));
	}
}

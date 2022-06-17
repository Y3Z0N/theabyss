
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

public class UnoritheAxeItem extends AxeItem {
	public UnoritheAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 3000;
			}

			public float getSpeed() {
				return 14f;
			}

			public float getAttackDamageBonus() {
				return 16.5f;
			}

			public int getLevel() {
				return 8;
			}

			public int getEnchantmentValue() {
				return 50;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheabyssModItems.UNORITHE_INGOT.get()));
			}
		}, 1, -2f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_TOOLS));
	}
}

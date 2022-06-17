
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class UnorithePickAxeItem extends PickaxeItem {
	public UnorithePickAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 3000;
			}

			public float getSpeed() {
				return 14.5f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 10;
			}

			public int getEnchantmentValue() {
				return 52;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheabyssModItems.UNORITHE_INGOT.get()));
			}
		}, 1, -1.5f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_TOOLS));
	}
}

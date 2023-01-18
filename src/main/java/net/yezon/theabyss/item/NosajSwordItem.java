
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.BrikedKnightSwordToolInHandTickevent;
import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class NosajSwordItem extends SwordItem {
	public NosajSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 10000;
			}

			public float getSpeed() {
				return 40f;
			}

			public float getAttackDamageBonus() {
				return 21f;
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
		}, 3, -1f, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_IN_DEV));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			BrikedKnightSwordToolInHandTickevent.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}

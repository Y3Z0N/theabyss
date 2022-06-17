
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class EyeOfAbyssItem extends Item {
	public EyeOfAbyssItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}

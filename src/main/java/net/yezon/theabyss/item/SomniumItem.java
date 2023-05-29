
package net.yezon.theabyss.item;

import net.yezon.theabyss.eventhandlers.GetSomniumAdvEventHandler;
import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class SomniumItem extends Item {
	public SomniumItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		GetSomniumAdvEventHandler.execute(entity);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			GetSomniumAdvEventHandler.execute(entity);
		GetSomniumAdvEventHandler.execute(entity);
	}
}

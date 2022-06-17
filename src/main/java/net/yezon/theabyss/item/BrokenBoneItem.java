
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.PhantomSoulItemItemInInventoryTickEvent;
import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class BrokenBoneItem extends Item {
	public BrokenBoneItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		PhantomSoulItemItemInInventoryTickEvent.execute(entity);
	}
}

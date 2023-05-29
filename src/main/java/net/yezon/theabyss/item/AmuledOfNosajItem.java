
package net.yezon.theabyss.item;

import net.yezon.theabyss.eventhandlers.AmuledOfNosajEffectEventHandler;
import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class AmuledOfNosajItem extends Item {
	public AmuledOfNosajItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).durability(100).rarity(Rarity.EPIC));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("When in Inventory:"));
		list.add(Component.literal("\u00A7b[+] Resistance I"));
		list.add(Component.literal("\u00A7b[+] Fire Resistance I"));
		list.add(Component.literal("\u00A7b[+] Water Breathing I"));
		list.add(Component.literal("\u00A7b[+] Haste I"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			AmuledOfNosajEffectEventHandler.execute(entity);
		AmuledOfNosajEffectEventHandler.execute(entity);
	}
}

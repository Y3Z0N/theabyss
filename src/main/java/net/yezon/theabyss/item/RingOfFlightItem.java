
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.ApplyRingOfFlightevent;
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

public class RingOfFlightItem extends Item {
	public RingOfFlightItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).durability(100).rarity(Rarity.RARE));
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
list.add(Component.literal("\uEF02 10.0 \uEF04 100.0 \uEF03 Right Click"));
		list.add(Component.translatable("tooltip.theabyss.ring_of_flight"));
		list.add(Component.literal(""));
		list.add(Component.translatable("tooltip.theabyss.ring_crafting"));
		list.add(Component.translatable("tooltip.theabyss.ring_consume"));
		list.add(Component.literal(""));
		list.add(Component.translatable("tooltip.theabyss.ring_upgrade"));
}


	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			ApplyRingOfFlightevent.execute(entity, itemstack);
		ApplyRingOfFlightevent.execute(entity, itemstack);
	}
}

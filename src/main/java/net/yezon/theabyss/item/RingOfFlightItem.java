
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.ApplyRingOfFlightEvent;
import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
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
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	list.add(new TextComponent("\u18B1 10.0 \u18B4 100.0 \u18B9 Right Click"));
list.add(new TextComponent("\u00A7bAbility\u00A7f: You can fly while holding in main or off-hand."));
list.add(new TextComponent("It uses \u00A7b10 percent somnium\u00A7f by default but can be improved with potions."));
list.add(new TextComponent(""));
list.add(new TextComponent("This item must be produced in the \u00A7bArcane Workbench.\u00A7f"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			ApplyRingOfFlightEvent.execute(entity, itemstack);
		ApplyRingOfFlightEvent.execute(entity, itemstack);
	}
}

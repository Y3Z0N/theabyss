
package net.yezon.theabyss.item;

import net.yezon.theabyss.eventhandlers.ApplyRingOfSeekerEventHandler;
import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import java.util.List;

public class RingOfSeekerItem extends Item {
	public RingOfSeekerItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).durability(250).rarity(Rarity.RARE));
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
list.add(Component.literal("\uEF02 50.0 \uEF04 100.0 \uEF03 Right Click"));
		list.add(Component.translatable("tooltip.theabyss.ring_of_seeker"));
		list.add(Component.literal(""));
		list.add(Component.translatable("tooltip.theabyss.ring_crafting"));
		list.add(Component.translatable("tooltip.theabyss.ring_consume"));
		list.add(Component.literal(""));
		list.add(Component.translatable("tooltip.theabyss.ring_upgrade"));
}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ApplyRingOfSeekerEventHandler.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}

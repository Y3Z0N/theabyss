
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.ApplyRingOfFreezeevent;
import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.List;

public class RingOfFreezeItem extends Item {
	public RingOfFreezeItem() {
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
  list.add(Component.literal("\uEF02 35.0 \uEF04 100.0 \uEF03 Right Click"));
		list.add(Component.translatable("tooltip.theabyss.ring_of_freeze"));
		list.add(Component.literal(""));
		list.add(Component.translatable("tooltip.theabyss.ring_crafting"));
		list.add(Component.translatable("tooltip.theabyss.ring_consume"));
		list.add(Component.literal(""));
		list.add(Component.translatable("tooltip.theabyss.ring_upgrade"));
}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		ApplyRingOfFreezeevent.execute(world, x, y, z, entity, itemstack);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ApplyRingOfFreezeevent.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}

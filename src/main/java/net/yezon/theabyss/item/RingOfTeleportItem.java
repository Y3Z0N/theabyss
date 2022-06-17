
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.ApplyRingOfTeleportEvent;
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
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class RingOfTeleportItem extends Item {
	public RingOfTeleportItem() {
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
		list.add(new TextComponent("\u18B1 20.0 \u18B4 100.0 \u18B9 Right Click"));
list.add(new TextComponent("\u00A7bAbility\u00A7f: You can teleport / teleport entities to your position"));
list.add(new TextComponent("It uses \u00A7b20 percent somnium\u00A7f by default but can be improved with potions."));
list.add(new TextComponent(""));
list.add(new TextComponent("This item must be produced in the \u00A7bArcane Workbench.\u00A7f"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		ApplyRingOfTeleportEvent.execute(world, x, y, z, entity, itemstack);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		ApplyRingOfTeleportEvent.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return retval;
	}
}

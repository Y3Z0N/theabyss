
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.ApplyRingOfNatureEvent;
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
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class RingOfNatureItem extends Item {
	public RingOfNatureItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).durability(250).rarity(Rarity.UNCOMMON));
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
list.add(new TextComponent("\u18B1 8.0 \u18B4 100.0 \u18B9 Right Click"));
list.add(new TextComponent("\u00A7bAbility\u00A7f: Let grow everything in a 3x3 block square."));
list.add(new TextComponent("It uses \u00A7b8 percent somnium\u00A7f by default but can be improved with potions."));
list.add(new TextComponent(""));
list.add(new TextComponent("This item must be produced in the \u00A7bArcane Workbench.\u00A7f"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		ApplyRingOfNatureEvent.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return retval;
	}
}

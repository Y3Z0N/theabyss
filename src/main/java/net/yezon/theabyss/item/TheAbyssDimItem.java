
package net.yezon.theabyss.item;

import net.yezon.theabyss.world.dimension.TheAbyssDimDimension;
import net.yezon.theabyss.events.StartSpreadAbyssEvent;
import net.yezon.theabyss.itemgroup.TheAbyssItemGroup;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Map;
import java.util.HashMap;

public class TheAbyssDimItem extends Item {
	@ObjectHolder("theabyss:the_abyss")
	public static final Item block = null;
	public TheAbyssDimItem() {
		super(new Item.Properties().group(TheAbyssItemGroup.tab).maxDamage(64));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (world.isAirBlock(pos) && true)
				TheAbyssDimDimension.portal.portalSpawn(world, pos);
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				StartSpreadAbyssEvent.executeEvent($_dependencies);
			}
			itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
			return ActionResultType.SUCCESS;
		}
	}
}

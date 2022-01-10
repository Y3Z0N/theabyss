
package net.yezon.theabyss.item;

import net.yezon.theabyss.world.dimension.TheAbyssDimGroundlandsDimension;
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

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class TheAbyssDimGroundlandsItem extends Item {
	@ObjectHolder("theabyss:ground_lands")
	public static final Item block = null;

	public TheAbyssDimGroundlandsItem() {
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
			boolean success = false;
			if (world.isAirBlock(pos) && true) {
				TheAbyssDimGroundlandsDimension.portal.portalSpawn(world, pos);
				itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
				success = true;
			}

			StartSpreadAbyssEvent
					.executeEvent(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ActionResultType.SUCCESS;
		}
	}
}

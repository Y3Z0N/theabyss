package net.yezon.theabyss.events;

import net.yezon.theabyss.block.SpreadDirtBlock;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import java.util.Map;

public class StartSpreadAbyssEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY() - 1), (int) (entity.getPosZ())),
				SpreadDirtBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY() - 2), (int) (entity.getPosZ())),
				SpreadDirtBlock.block.getDefaultState(), 3);
	}
}

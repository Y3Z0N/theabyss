package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TreeGenEvent {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.DIRT.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.INFECTED_GRASS.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.GRASS_SMALL.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.GRASS_MIDDLE.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.GRASS_BIG.get()) {
			return true;
		}
		return false;
	}
}

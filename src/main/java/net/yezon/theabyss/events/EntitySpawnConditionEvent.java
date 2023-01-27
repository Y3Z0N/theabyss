package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class EntitySpawnConditionEvent {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.BLARU_MOSS.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.STONE.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.DIRT.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.ROMA_MUD.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.ROMA_MUD_2.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TheabyssModBlocks.COBBLE_STONE.get();
	}
}

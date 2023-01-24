package net.yezon.theabyss.events;

import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GlitchBlockBlockRemoveOnTimeEvent {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		TheabyssMod.queueServerWork(200, () -> {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		});
	}
}

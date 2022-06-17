package net.yezon.theabyss.events;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CaveGenCheckerEvent {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !world.canSeeSkyFromBelowWater(new BlockPos(x, y, z));
	}
}

package net.yezon.theabyss.eventhandlers;

import net.minecraft.world.level.LevelAccessor;

public class MagicianSpawnEventHandler {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().isRaining()) {
			return true;
		}
		return false;
	}
}

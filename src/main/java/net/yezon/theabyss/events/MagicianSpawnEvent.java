package net.yezon.theabyss.events;

import net.minecraft.world.level.LevelAccessor;

public class MagicianSpawnevent {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().isRaining()) {
			return true;
		}
		return false;
	}
}

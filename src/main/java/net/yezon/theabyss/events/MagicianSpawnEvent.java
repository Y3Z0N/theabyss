package net.yezon.theabyss.events;

import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.IWorld;

import java.util.Map;

public class MagicianSpawnEvent {

	public static boolean executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		if (world.getWorldInfo().isRaining()) {
			return true;
		}
		return false;
	}
}

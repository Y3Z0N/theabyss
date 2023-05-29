package net.yezon.theabyss.eventhandlers;

import net.minecraft.world.entity.Entity;

public class FirePlantEffectEventHandler {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(5);
	}
}

package net.yezon.theabyss.events;

import net.minecraft.world.entity.Entity;

public class FirePlantEffectEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(5);
	}
}

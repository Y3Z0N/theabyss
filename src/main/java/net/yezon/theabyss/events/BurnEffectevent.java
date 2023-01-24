package net.yezon.theabyss.events;

import net.minecraft.world.entity.Entity;

public class BurnEffectevent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(8);
	}
}

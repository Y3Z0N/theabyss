package net.yezon.theabyss.eventhandlers;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class VealusMeramusCollideEventHandler {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.hurt(DamageSource.CACTUS, 2);
	}
}

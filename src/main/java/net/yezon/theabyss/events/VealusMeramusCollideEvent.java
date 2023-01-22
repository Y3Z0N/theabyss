package net.yezon.theabyss.events;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class VealusMeramusCollideEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.hurt(DamageSource.CACTUS, 2);
	}
}

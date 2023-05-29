package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.init.TheabyssModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ApplyGhostDeactivateEventHandler {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(TheabyssModMobEffects.GHOST.get());
	}
}

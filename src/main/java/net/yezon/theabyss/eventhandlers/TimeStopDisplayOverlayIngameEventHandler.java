package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.init.TheabyssModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class TimeStopDisplayOverlayIngameEventHandler {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TheabyssModMobEffects.TIME_STOP_POTION_EFFECT.get()) : false;
	}
}

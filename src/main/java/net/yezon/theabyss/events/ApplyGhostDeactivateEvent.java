package net.yezon.theabyss.events;

import net.yezon.theabyss.potion.GhostPotionEffect;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class ApplyGhostDeactivateEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(GhostPotionEffect.potion);
		}
	}
}

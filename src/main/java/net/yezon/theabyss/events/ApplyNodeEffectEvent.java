package net.yezon.theabyss.events;

import net.yezon.theabyss.potion.NodePotionPotionEffect;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class ApplyNodeEffectEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event ApplyNodeEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(NodePotionPotionEffect.potion, (int) 200, (int) 0));
	}
}
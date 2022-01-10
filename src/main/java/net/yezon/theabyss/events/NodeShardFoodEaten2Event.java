package net.yezon.theabyss.events;

import net.yezon.theabyss.potion.NodePotionPotionEffect;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class NodeShardFoodEaten2Event {

	public static void executeEvent(Map<String, Object> dependencies) {
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(NodePotionPotionEffect.potion, (int) 200, (int) 0));
	}
}

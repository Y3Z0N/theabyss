package net.yezon.theabyss.events;

import net.yezon.theabyss.TheabyssMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class BackUpFlyCT2Event {

	public static void executeEvent(Map<String, Object> dependencies) {
		Entity entity = (Entity) dependencies.get("entity");
		entity.fallDistance = (float) ((-1));
		System.out.println(entity.rotationPitch);
		entity.setMotion((entity.getMotion().getX()), (entity.rotationPitch * (-0.0031)), (entity.getMotion().getZ()));
	}
}

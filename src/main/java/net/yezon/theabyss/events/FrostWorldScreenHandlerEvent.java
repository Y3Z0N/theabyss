package net.yezon.theabyss.events;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

public class FrostWorldScreenHandlerevent {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("theabyss:frost_world")));
	}
}

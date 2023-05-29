package net.yezon.theabyss.eventhandlers;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

public class GhostVisionOverlayDisplayOverlayIngameEventHandler {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("theabyss:the_abyss")));
	}
}

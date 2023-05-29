package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class PlayerBodyDespawnEventHandler {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TheabyssMod.queueServerWork(800, () -> {
			if (!entity.level.isClientSide())
				entity.discard();
		});
	}
}

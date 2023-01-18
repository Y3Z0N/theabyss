package net.yezon.theabyss.events;

import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class PlayerBodyDespawnevent {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TheabyssMod.queueServerWork(800, () -> {
			if (!entity.level.isClientSide())
				entity.discard();
		});
	}
}

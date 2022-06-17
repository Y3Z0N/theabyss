package net.yezon.theabyss.events;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class CursedAuraActiveEvent {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 10, 20, 10, 20, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LAVA, x, y, z, 10, 20, 10, 20, 0.01);
	}
}

package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.init.TheabyssModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

public class RingOfBlackStrikeParticleEventHandler {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 5, 0.0105, 0.05, 0.005, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.PHANTOM_FIRE.get()), x, y, z, 10, 0.05, 0.05, 0.05, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.PHANTOM_FIRE.get()), x, y, z, 2, 0.08, 0.08, 0.08, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.PHANTOM_SPECTRUM.get()), x, y, z, 1, 0.01, 0.01, 0.01, 0.01);
	}
}

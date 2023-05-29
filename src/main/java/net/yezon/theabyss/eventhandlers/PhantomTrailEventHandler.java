package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.init.TheabyssModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class PhantomTrailEventHandler {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.PHANTOM_ATTACK_PARTICLE.get()), x, y, z, 4, 0.014, 0.014, 0.014, 0.65);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.PHANTOM_ATTACK_PARTICLE_2.get()), x, y, z, 3, 0.03, 0.03, 0.03, 0.65);
	}
}

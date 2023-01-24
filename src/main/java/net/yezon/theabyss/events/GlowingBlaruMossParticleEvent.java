package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class GlowingBlaruMossParticleEvent {
	public static void execute(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_CYAN.get()), (entity.getX()), y, (entity.getZ()), 1, 1, 0.01, 1, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_BRIGHT_CYAN.get()), (entity.getX()), y, (entity.getZ()), 1, 1, 0.01, 1, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_LIGHT_CYAN.get()), (entity.getX()), y, (entity.getZ()), 1, 1, 0.01, 1, 0.01);
	}
}

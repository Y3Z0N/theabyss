package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

public class GhostEventEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 5, 0.05, 1.5, 0.05, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 5, 0.05, 1.5, 0.05, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.PHANTOM_FIRE.get()), x, y, z, 5, 0.05, 1.5, 0.05, 0.01);
		entity.setDeltaMovement(new Vec3(0, 0.05, 0));
		TheabyssMod.queueServerWork(100, () -> {
			if (!entity.level.isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.05, 1.5, 0.05, 0.01);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.PHANTOM_FIRE.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.05, 1.5, 0.05, 0.01);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.05, 1.5, 0.05, 0.01);
		});
	}
}

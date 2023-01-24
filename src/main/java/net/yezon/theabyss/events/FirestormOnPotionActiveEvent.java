package net.yezon.theabyss.events;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class FirestormOnPotionActiveEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					entityiterator.hurt(DamageSource.ON_FIRE, 1);
					entityiterator.setSecondsOnFire(5);
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 10, 40, 30, 40, 0.01);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 6, 40, 30, 40, 0.01);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LAVA, x, y, z, 20, 40, 30, 40, 0.01);
			}
		}
	}
}

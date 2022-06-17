package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class DimensionalCrackTicksEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_LIGHT_CYAN.get()), x, y, z, 20, 1.5, 2, 1.5, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_CYAN.get()), x, y, z, 10, 1, 2, 1, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_BRIGHT_CYAN.get()), x, y, z, 15, 2, 2, 2, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_BRIGHT_CYAN.get()), x, y, z, 5, 0.1, 2, 0.1, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_LIGHT_CYAN.get()), x, y, z, 5, 0.1, 2, 0.1, 0.01);
		if (Math.random() < 0.003) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 40, 0, (true), (true)));
					if (entityiterator instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, (true), (true)));
					entityiterator.setDeltaMovement(new Vec3((entity.getX()), 0.03, (entity.getZ())));
				}
			}
		}
	}
}

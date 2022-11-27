package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.init.TheabyssModMobEffects;
import net.yezon.theabyss.init.TheabyssModEntities;
import net.yezon.theabyss.entity.NightBladeBossCloneEntity;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class NightBladeBossAbilityEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.004) {
			{
				Entity _ent = entity;
				_ent.teleportTo((x + 1), (y + 2), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((x + 1), (y + 2), z, _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 2, 0.1, 1, 0.1, 0.1);
		} else if (Math.random() < 0.004) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + 1), (z + 1));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 1), (z + 1), _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 2, 0.1, 1, 0.1, 0.1);
		}
		if (Math.random() < 0.003) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20, 1, (false), (false)));
						if (entityiterator instanceof Player) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo((x - 3), (y + 10), (z + 3));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((x - 3), (y + 10), (z + 3), _ent.getYRot(), _ent.getXRot());
							}
						}
						if (entityiterator instanceof Monster) {
							{
								Entity _ent = entity;
								_ent.teleportTo(x, (y + 10), z);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(x, (y + 10), z, _ent.getYRot(), _ent.getXRot());
							}
							{
								Entity _ent = entityiterator;
								_ent.teleportTo(x, (y + 10), z);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(x, (y + 10), z, _ent.getYRot(), _ent.getXRot());
							}
						}
						TheabyssMod.queueServerWork(200, () -> {
							entity.setNoGravity((false));
							entityiterator.setNoGravity((false));
						});
						entity.setNoGravity((true));
						entityiterator.setNoGravity((true));
					}
				}
			}
		}
		if (Math.random() < 0.0025) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn
								.moveTo(Vec3.atBottomCenterOf(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(TheabyssModMobEffects.WEAK_ELECTRICITY.get(), 60, 0, (false), (false)));
					}
				}
			}
		}
		if (Math.random() < 0.0025) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn
								.moveTo(Vec3.atBottomCenterOf(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					if (!(entityiterator == entity)) {
						entityiterator.setSecondsOnFire(1);
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.END_SWORD_PT.get()), x, y, z, 40, 15, 15, 15, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 5, 15, 15, 15, 0.01);
		if (Math.random() < 0.0001) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new NightBladeBossCloneEntity(TheabyssModEntities.NIGHT_BLADE_BOSS_CLONE.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new NightBladeBossCloneEntity(TheabyssModEntities.NIGHT_BLADE_BOSS_CLONE.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() instanceof LiquidBlock) {
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x + 1, y - 1, z), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x + 1, y - 1, z + 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x + 1, y - 1, z - 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x - 1, y - 1, z - 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x - 1, y - 1, z + 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, x + 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, x - 1), Blocks.ICE.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() instanceof LiquidBlock) {
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x + 1, y - 1, z), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x + 1, y - 1, z + 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x + 1, y - 1, z - 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x - 1, y - 1, z - 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x - 1, y - 1, z + 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, x + 1), Blocks.ICE.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, x - 1), Blocks.ICE.defaultBlockState(), 3);
		}
	}
}

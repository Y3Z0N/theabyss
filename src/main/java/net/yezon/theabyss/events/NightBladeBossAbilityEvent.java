package net.yezon.theabyss.events;

import net.yezon.theabyss.potion.WeakElectricityPotionEffect;
import net.yezon.theabyss.particle.EndSwordPTParticle;
import net.yezon.theabyss.entity.NightBladeBossCloneEntity;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.Blocks;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class NightBladeBossAbilityEvent {

	public static void executeEvent(Map<String, Object> dependencies) {

		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (Math.random() < 0.004) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((x + 1), (y + 2), z);
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 1), (y + 2), z, _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, z, (int) 2, 0.1, 1, 0.1, 0.1);
			}
		} else if (Math.random() < 0.004) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(x, (y + 1), (z + 1));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y + 1), (z + 1), _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, z, (int) 2, 0.1, 1, 0.1, 0.1);
			}
		}
		if (Math.random() < 0.003) {
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
						new AxisAlignedBB(x - (100 / 2d), y - (100 / 2d), z - (100 / 2d), x + (100 / 2d), y + (100 / 2d), z + (100 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator)
									.addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 20, (int) 1, (false), (false)));
						if (entityiterator instanceof PlayerEntity) {
							{
								Entity _ent = entityiterator;
								_ent.setPositionAndUpdate((x - 3), (y + 10), (z + 3));
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((x - 3), (y + 10), (z + 3), _ent.rotationYaw,
											_ent.rotationPitch, Collections.emptySet());
								}
							}
						}
						if (entityiterator instanceof MonsterEntity) {
							{
								Entity _ent = entity;
								_ent.setPositionAndUpdate(x, (y + 10), z);
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y + 10), z, _ent.rotationYaw, _ent.rotationPitch,
											Collections.emptySet());
								}
							}
							{
								Entity _ent = entityiterator;
								_ent.setPositionAndUpdate(x, (y + 10), z);
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y + 10), z, _ent.rotationYaw, _ent.rotationPitch,
											Collections.emptySet());
								}
							}
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								entity.setNoGravity((false));
								entityiterator.setNoGravity((false));
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 200);
						entity.setNoGravity((true));
						entityiterator.setNoGravity((true));
					}
				}
			}
		}
		if (Math.random() < 0.0025) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (40 / 2d), y - (40 / 2d), z - (40 / 2d), x + (40 / 2d), y + (40 / 2d), z + (40 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(
								new BlockPos((int) (entityiterator.getPosX()), (int) (entityiterator.getPosY()), (int) (entityiterator.getPosZ()))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator)
									.addPotionEffect(new EffectInstance(WeakElectricityPotionEffect.potion, (int) 60, (int) 0, (false), (false)));
					}
				}
			}
		}
		if (Math.random() < 0.0025) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (40 / 2d), y - (40 / 2d), z - (40 / 2d), x + (40 / 2d), y + (40 / 2d), z + (40 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(
								new BlockPos((int) (entityiterator.getPosX()), (int) (entityiterator.getPosY()), (int) (entityiterator.getPosZ()))));
						_ent.setEffectOnly(true);
						((World) world).addEntity(_ent);
					}
					if (!(entityiterator == entity)) {
						entityiterator.setFire((int) 1);
					}
				}
			}
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(EndSwordPTParticle.particle, x, y, z, (int) 40, 15, 15, 15, 0.01);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.LARGE_SMOKE, x, y, z, (int) 5, 15, 15, 15, 0.01);
		}
		if (Math.random() < 0.0001) {
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NightBladeBossCloneEntity.CustomEntity(NightBladeBossCloneEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new NightBladeBossCloneEntity.CustomEntity(NightBladeBossCloneEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() instanceof FlowingFluidBlock) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z - 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (x + 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (x - 1)), Blocks.ICE.getDefaultState(), 3);
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() instanceof FlowingFluidBlock) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z - 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (x + 1)), Blocks.ICE.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (x - 1)), Blocks.ICE.getDefaultState(), 3);
		}
	}
}

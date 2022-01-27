package net.yezon.theabyss.events;

import net.yezon.theabyss.item.SoulHeartItem;
import net.yezon.theabyss.item.EyeOfAbyssItem;
import net.yezon.theabyss.entity.NightbladeBossEntity;
import net.yezon.theabyss.block.StoneBrickPillarIgnitedBlock;
import net.yezon.theabyss.block.StoneBrickPillarBlock;
import net.yezon.theabyss.block.NightAltarBlock;
import net.yezon.theabyss.block.NightAltarActivatedBlock;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

public class NightbladeSummonHandlerEvent {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			BlockState state = world.getBlockState(event.getPos());
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("direction", event.getFace());
			dependencies.put("blockstate", state);
			dependencies.put("event", event);
			executeEvent(dependencies);
		}
	}

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event NightbladeSummonHandler!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == EyeOfAbyssItem.block
				&& NightAltarBlock.block == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()) {
			if ((world.getBlockState(new BlockPos((int) (x + 6), (int) (y + 5), (int) z))).getBlock() == StoneBrickPillarIgnitedBlock.block
					&& (world.getBlockState(new BlockPos((int) (x - 6), (int) (y + 5), (int) z))).getBlock() == StoneBrickPillarIgnitedBlock.block
					&& (world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 6)))).getBlock() == StoneBrickPillarIgnitedBlock.block
					&& (world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 6)))).getBlock() == StoneBrickPillarIgnitedBlock.block
					&& (world.getBlockState(new BlockPos((int) (x + 3), (int) (y + 4), (int) (z - 3))))
							.getBlock() == StoneBrickPillarIgnitedBlock.block
					&& (world.getBlockState(new BlockPos((int) (x + 3), (int) (y + 4), (int) (z + 3))))
							.getBlock() == StoneBrickPillarIgnitedBlock.block
					&& (world.getBlockState(new BlockPos((int) (x - 3), (int) (y + 4), (int) (z + 3))))
							.getBlock() == StoneBrickPillarIgnitedBlock.block
					&& (world.getBlockState(new BlockPos((int) (x - 3), (int) (y + 4), (int) (z - 3))))
							.getBlock() == StoneBrickPillarIgnitedBlock.block) {
				(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = NightAltarActivatedBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					TileEntity _te = world.getTileEntity(_bp);
					CompoundNBT _bnbt = null;
					if (_te != null) {
						_bnbt = _te.write(new CompoundNBT());
						_te.remove();
					}
					world.setBlockState(_bp, _bs, 3);
					if (_bnbt != null) {
						_te = world.getTileEntity(_bp);
						if (_te != null) {
							try {
								_te.read(_bso, _bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if ((world.getBlockState(new BlockPos((int) (x + 6), (int) (y + 5), (int) z))).getBlock() == StoneBrickPillarIgnitedBlock.block
						&& (world.getBlockState(new BlockPos((int) (x - 6), (int) (y + 5), (int) z))).getBlock() == StoneBrickPillarIgnitedBlock.block
						&& (world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 6)))).getBlock() == StoneBrickPillarIgnitedBlock.block
						&& (world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 6)))).getBlock() == StoneBrickPillarIgnitedBlock.block
						&& (world.getBlockState(new BlockPos((int) (x + 3), (int) (y + 4), (int) (z - 3))))
								.getBlock() == StoneBrickPillarIgnitedBlock.block
						&& (world.getBlockState(new BlockPos((int) (x + 3), (int) (y + 4), (int) (z + 3))))
								.getBlock() == StoneBrickPillarIgnitedBlock.block
						&& (world.getBlockState(new BlockPos((int) (x - 3), (int) (y + 4), (int) (z + 3))))
								.getBlock() == StoneBrickPillarIgnitedBlock.block
						&& (world.getBlockState(new BlockPos((int) (x - 3), (int) (y + 4), (int) (z - 3))))
								.getBlock() == StoneBrickPillarIgnitedBlock.block) {
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
							world.setBlockState(new BlockPos((int) (x + 6), (int) (y + 5), (int) z), StoneBrickPillarBlock.block.getDefaultState(),
									3);
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
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
							world.setBlockState(new BlockPos((int) (x - 6), (int) (y + 5), (int) z), StoneBrickPillarBlock.block.getDefaultState(),
									3);
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 40);
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
							world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 6)), StoneBrickPillarBlock.block.getDefaultState(),
									3);
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 60);
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
							world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 6)), StoneBrickPillarBlock.block.getDefaultState(),
									3);
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 80);
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
							world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 4), (int) (z - 3)),
									StoneBrickPillarBlock.block.getDefaultState(), 3);
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
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
							world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 4), (int) (z + 3)),
									StoneBrickPillarBlock.block.getDefaultState(), 3);
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 120);
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
							world.setBlockState(new BlockPos((int) (x - 3), (int) (y + 4), (int) (z + 3)),
									StoneBrickPillarBlock.block.getDefaultState(), 3);
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 140);
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
							world.setBlockState(new BlockPos((int) (x - 3), (int) (y + 4), (int) (z - 3)),
									StoneBrickPillarBlock.block.getDefaultState(), 3);
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 160);
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
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), NightAltarBlock.block.getDefaultState(), 3);
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(true);
								((World) world).addEntity(_ent);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new NightbladeBossEntity.CustomEntity(NightbladeBossEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 180);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("that \u00A7bdoes\u00A7f not work ..."), (true));
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("that \u00A7bdoes\u00A7f not work ..."), (true));
				}
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == SoulHeartItem.block
				&& StoneBrickPillarBlock.block == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()) {
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = StoneBrickPillarIgnitedBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				TileEntity _te = world.getTileEntity(_bp);
				CompoundNBT _bnbt = null;
				if (_te != null) {
					_bnbt = _te.write(new CompoundNBT());
					_te.remove();
				}
				world.setBlockState(_bp, _bs, 3);
				if (_bnbt != null) {
					_te = world.getTileEntity(_bp);
					if (_te != null) {
						try {
							_te.read(_bso, _bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
		}
	}
}

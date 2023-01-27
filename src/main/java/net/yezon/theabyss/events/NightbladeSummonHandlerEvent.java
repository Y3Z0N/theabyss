package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.init.TheabyssModEntities;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.entity.NightbladeBossEntity;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.Map;

@Mod.EventBusSubscriber
public class NightbladeSummonHandlerEvent {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.EYE_OF_ABYSS.get()
				&& TheabyssModBlocks.NIGHT_ALTAR.get() == (world.getBlockState(new BlockPos(x, y, z))).getBlock()) {
			if ((world.getBlockState(new BlockPos(x + 6, y + 5, z))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
					&& (world.getBlockState(new BlockPos(x - 6, y + 5, z))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
					&& (world.getBlockState(new BlockPos(x, y + 5, z + 6))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
					&& (world.getBlockState(new BlockPos(x, y + 5, z - 6))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
					&& (world.getBlockState(new BlockPos(x + 3, y + 4, z - 3))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
					&& (world.getBlockState(new BlockPos(x + 3, y + 4, z + 3))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
					&& (world.getBlockState(new BlockPos(x - 3, y + 4, z + 3))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
					&& (world.getBlockState(new BlockPos(x - 3, y + 4, z - 3))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()) {
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = TheabyssModBlocks.NIGHT_ALTAR_ACTIVATED.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					BlockEntity _be = world.getBlockEntity(_bp);
					CompoundTag _bnbt = null;
					if (_be != null) {
						_bnbt = _be.saveWithFullMetadata();
						_be.setRemoved();
					}
					world.setBlock(_bp, _bs, 3);
					if (_bnbt != null) {
						_be = world.getBlockEntity(_bp);
						if (_be != null) {
							try {
								_be.load(_bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_eye.death")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if ((world.getBlockState(new BlockPos(x + 6, y + 5, z))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
						&& (world.getBlockState(new BlockPos(x - 6, y + 5, z))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
						&& (world.getBlockState(new BlockPos(x, y + 5, z + 6))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
						&& (world.getBlockState(new BlockPos(x, y + 5, z - 6))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
						&& (world.getBlockState(new BlockPos(x + 3, y + 4, z - 3))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
						&& (world.getBlockState(new BlockPos(x + 3, y + 4, z + 3))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
						&& (world.getBlockState(new BlockPos(x - 3, y + 4, z + 3))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get()
						&& (world.getBlockState(new BlockPos(x - 3, y + 4, z - 3))).getBlock() == TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED
								.get()) {
					TheabyssMod.queueServerWork(20, () -> {
						world.setBlock(new BlockPos(x + 6, y + 5, z), TheabyssModBlocks.STONE_BRICK_PILLAR.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
					});
					TheabyssMod.queueServerWork(40, () -> {
						world.setBlock(new BlockPos(x - 6, y + 5, z), TheabyssModBlocks.STONE_BRICK_PILLAR.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
					});
					TheabyssMod.queueServerWork(60, () -> {
						world.setBlock(new BlockPos(x, y + 5, z + 6), TheabyssModBlocks.STONE_BRICK_PILLAR.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
					});
					TheabyssMod.queueServerWork(80, () -> {
						world.setBlock(new BlockPos(x, y + 5, z - 6), TheabyssModBlocks.STONE_BRICK_PILLAR.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
					});
					TheabyssMod.queueServerWork(100, () -> {
						world.setBlock(new BlockPos(x + 3, y + 4, z - 3), TheabyssModBlocks.STONE_BRICK_PILLAR.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
					});
					TheabyssMod.queueServerWork(120, () -> {
						world.setBlock(new BlockPos(x + 3, y + 4, z + 3), TheabyssModBlocks.STONE_BRICK_PILLAR.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
					});
					TheabyssMod.queueServerWork(140, () -> {
						world.setBlock(new BlockPos(x - 3, y + 4, z + 3), TheabyssModBlocks.STONE_BRICK_PILLAR.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
					});
					TheabyssMod.queueServerWork(160, () -> {
						world.setBlock(new BlockPos(x - 3, y + 4, z - 3), TheabyssModBlocks.STONE_BRICK_PILLAR.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
					});
					TheabyssMod.queueServerWork(180, () -> {
						world.setBlock(new BlockPos(x, y, z), TheabyssModBlocks.NIGHT_ALTAR.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new NightbladeBossEntity(TheabyssModEntities.NIGHTBLADE_BOSS.get(), _level);
							entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()),
										MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					});
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("that \u00A7bdoes\u00A7f not work ..."), (true));
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("that \u00A7bdoes\u00A7f not work ..."), (true));
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.SOUL_HEART.get()
				&& TheabyssModBlocks.STONE_BRICK_PILLAR.get() == (world.getBlockState(new BlockPos(x, y, z))).getBlock()) {
			((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = TheabyssModBlocks.STONE_BRICK_PILLAR_IGNITED.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata();
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
							SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
	}
}

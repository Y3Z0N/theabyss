package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Random;

public class ApplyRingOfPocketRoomEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(TheabyssModItems.RING_OF_POCKET_BOX.get()))
				: false) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana < 50
							* (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("you don't have enough \u00A7benergy"), (true));
			} else {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(),
							(int) (500 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaCooldown));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_teleport")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_teleport")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (itemstack.getItem() == TheabyssModItems.RING_OF_POCKET_BOX.get()) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY,
						new ResourceLocation("theabyss:pocket_dimension")))) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
										_level.getServer(), null).withSuppressedOutput(),
								("execute in minecraft:overworld run tp " + entity.getDisplayName().getString() + " "
										+ Math.round((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new TheabyssModVariables.PlayerVariables())).SaveX)
										+ " "
										+ Math.round((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new TheabyssModVariables.PlayerVariables())).SaveY)
										+ " " + Math.round((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new TheabyssModVariables.PlayerVariables())).SaveZ)));
				} else if ((entity.level.dimension()) == (Level.OVERWORLD)) {
					if (!((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TheabyssModVariables.PlayerVariables())).PocketDimension == true)) {
						{
							double _setval = (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).Mana
									- 50 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade;
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Mana = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.round(entity.getX());
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.round(entity.getY());
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveY = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.round(entity.getZ());
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveZ = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private LevelAccessor world;

							public void start(LevelAccessor world, int waitTicks) {
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
								if (entity instanceof LivingEntity _entity)
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 80, 0, (false), (false)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											("execute in theabyss:pocket_dimension run tp " + entity.getDisplayName().getString() + " 0 2000 0"));
								{
									boolean _setval = true;
									entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PocketDimension = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = TheabyssModVariables.WorldVariables.get(world).PocketDimensionX + 9;
									entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PocketPlayerX = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 82;
									entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PocketPlayerY = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = TheabyssModVariables.WorldVariables.get(world).PocketDimensionZ + 9;
									entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PocketPlayerZ = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 1);
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private LevelAccessor world;

							public void start(LevelAccessor world, int waitTicks) {
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
								if (world instanceof ServerLevel _origLevel) {
									LevelAccessor _worldorig = world;
									world = _origLevel.getServer().getLevel(
											ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("theabyss:pocket_dimension")));
									if (world != null) {
										if (world instanceof ServerLevel _serverworld) {
											StructureTemplate template = _serverworld.getStructureManager()
													.getOrCreate(new ResourceLocation("theabyss", "pocket_room"));
											if (template != null) {
												template.placeInWorld(_serverworld,
														new BlockPos(Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionX), 80,
																Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionZ)),
														new BlockPos(Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionX), 80,
																Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionZ)),
														new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
																.setIgnoreEntities(false),
														_serverworld.random, 3);
											}
										}
										TheabyssModVariables.WorldVariables.get(world).PocketDimensionX = Math
												.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionX) + Math.round(20);
										TheabyssModVariables.WorldVariables.get(world).syncData(world);
									}
									world = _worldorig;
								}
								TheabyssModVariables.WorldVariables.get(world).PocketDimensionX = Math
										.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionX) + Math.round(20);
								TheabyssModVariables.WorldVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 4);
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private LevelAccessor world;

							public void start(LevelAccessor world, int waitTicks) {
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
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											("execute in theabyss:pocket_dimension run tp " + entity.getDisplayName().getString() + " "
													+ Math.round((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new TheabyssModVariables.PlayerVariables())).PocketPlayerX)
													+ " 82 "
													+ Math.round((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new TheabyssModVariables.PlayerVariables())).PocketPlayerZ)));
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 6);
					} else {
						{
							double _setval = Math.round(entity.getX());
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.round(entity.getY());
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveY = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.round(entity.getZ());
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveZ = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).Mana
									- 50 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade;
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Mana = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private LevelAccessor world;

							public void start(LevelAccessor world, int waitTicks) {
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
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											("execute in theabyss:pocket_dimension run tp " + entity.getDisplayName().getString() + " "
													+ Math.round((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new TheabyssModVariables.PlayerVariables())).PocketPlayerX)
													+ " 82 "
													+ Math.round((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new TheabyssModVariables.PlayerVariables())).PocketPlayerZ)));
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 2);
					}
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent("you have to be in overworld to do this"), (false));
				}
			}
		}
	}
}

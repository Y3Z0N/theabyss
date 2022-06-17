package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.stream.Collectors;
import java.util.Random;
import java.util.List;
import java.util.Comparator;

public class ApplyRingOfFangsEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(TheabyssModItems.RING_OF_FANGS.get()))
				: false) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana < 50
							* (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("you don't have enough \u00A7benergy"), (true));
			} else {
				if (itemstack.getItem() == TheabyssModItems.RING_OF_FANGS.get()) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(),
							(int) (140 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaCooldown));
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
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, z), Vec2.ZERO,
							_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "summon minecraft:evoker_fangs");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, z), Vec2.ZERO,
							_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "summon minecraft:evoker_fangs");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 2)), Vec2.ZERO,
							_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "summon minecraft:evoker_fangs");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 2)), Vec2.ZERO,
							_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "summon minecraft:evoker_fangs");
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
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 5);
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
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, (z - 2)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, (z + 2)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, (z + 2)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, (z - 2)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 10);
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
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 4), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 4), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, (z + 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z + 4)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z + 4)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, (z + 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 4), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 4), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, (z - 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z - 4)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z - 4)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, (z - 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 15);
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
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 5), y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 5), y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 5)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 5)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 20);
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
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
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
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, z), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, (z - 2)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, (z + 2)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, (z + 2)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, (z - 2)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 5);
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
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 4), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 4), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, (z + 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z + 4)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z + 4)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, (z + 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 4), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 4), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, (z - 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z - 4)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z - 4)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, (z - 3)), Vec2.ZERO, _level, 4, "",
													new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 10);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 25);
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).FriendMode == true) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(35 / 2d), e -> true)
								.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (!(entityiterator instanceof Player)) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands()
												.performCommand(new CommandSourceStack(CommandSource.NULL,
														new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
														Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null)
														.withSuppressedOutput(), "summon minecraft:evoker_fangs");
								}
							}
						}
					}
				} else {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(35 / 2d), e -> true)
								.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands()
											.performCommand(new CommandSourceStack(CommandSource.NULL,
													new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO,
													_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
													"summon minecraft:evoker_fangs");
							}
						}
					}
				}
			}
		}
	}
}

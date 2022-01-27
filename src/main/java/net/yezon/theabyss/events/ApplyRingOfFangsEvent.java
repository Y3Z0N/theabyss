package net.yezon.theabyss.events;

import net.yezon.theabyss.item.RingOfFangsItem;
import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ApplyRingOfFangsEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event ApplyRingOfFangs!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheabyssMod.LOGGER.warn("Failed to load dependency itemstack for Event ApplyRingOfFangs!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RingOfFangsItem.block)) : false) {
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Mana < 50
							* (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("you don't have enough \u00A7benergy"), (true));
				}
			} else {
				if (itemstack.getItem() == RingOfFangsItem.block) {
					{
						ItemStack _ist = itemstack;
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(),
							(int) (140 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaCooldown));
				{
					double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).Mana
							- 50 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaUpgrade);
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 2), y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon minecraft:evoker_fangs");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 2), y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon minecraft:evoker_fangs");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, (z + 2)), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon minecraft:evoker_fangs");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, (z - 2)), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon minecraft:evoker_fangs");
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 1), y, (z - 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 1), y, (z - 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 1), y, (z + 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 1), y, (z + 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 5);
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 3), y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 3), y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, (z + 3)), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, (z - 3)), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 2), y, (z - 2)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 2), y, (z + 2)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 2), y, (z + 2)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 2), y, (z - 2)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 10);
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 4), y, (z - 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 4), y, (z + 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 3), y, (z + 3)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 1), y, (z + 4)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 1), y, (z + 4)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 3), y, (z + 3)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 4), y, (z + 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 4), y, (z - 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 3), y, (z - 3)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 1), y, (z - 4)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 1), y, (z - 4)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 3), y, (z - 3)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 15);
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 5), y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 5), y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, (z + 5)), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, (z - 5)), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 1), y, (z - 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 1), y, (z - 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 1), y, (z + 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 1), y, (z + 1)), Vector2f.ZERO, (ServerWorld) world, 4,
											"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:evoker_fangs");
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
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 3), y, z), Vector2f.ZERO, (ServerWorld) world,
													4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 3), y, z), Vector2f.ZERO, (ServerWorld) world,
													4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, (z + 3)), Vector2f.ZERO, (ServerWorld) world,
													4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, (z - 3)), Vector2f.ZERO, (ServerWorld) world,
													4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 2), y, (z - 2)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 2), y, (z + 2)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 2), y, (z + 2)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 2), y, (z - 2)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
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
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 4), y, (z - 1)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 4), y, (z + 1)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 3), y, (z + 3)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 1), y, (z + 4)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 1), y, (z + 4)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 3), y, (z + 3)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 4), y, (z + 1)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 4), y, (z - 1)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 3), y, (z - 3)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x - 1), y, (z - 4)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 1), y, (z - 4)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 3), y, (z - 3)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 10);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 25);
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).FriendMode == true) {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (35 / 2d), y - (35 / 2d), z - (35 / 2d), x + (35 / 2d), y + (35 / 2d), z + (35 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (!(entityiterator instanceof PlayerEntity)) {
									if (world instanceof ServerWorld) {
										((World) world).getServer().getCommandManager().handleCommand(
												new CommandSource(ICommandSource.DUMMY,
														new Vector3d((entityiterator.getPosX()), (entityiterator.getPosY()),
																(entityiterator.getPosZ())),
														Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
														((World) world).getServer(), null).withFeedbackDisabled(),
												"summon minecraft:evoker_fangs");
									}
								}
							}
						}
					}
				} else {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (35 / 2d), y - (35 / 2d), z - (35 / 2d), x + (35 / 2d), y + (35 / 2d), z + (35 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(
													new CommandSource(ICommandSource.DUMMY,
															new Vector3d((entityiterator.getPosX()), (entityiterator.getPosY()),
																	(entityiterator.getPosZ())),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
													"summon minecraft:evoker_fangs");
								}
							}
						}
					}
				}
			}
		}
	}
}

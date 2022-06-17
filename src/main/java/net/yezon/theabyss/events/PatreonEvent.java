package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PatreonEvent {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheabyssModVariables.PlayerVariables())).P4 == true
				|| (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).P5 == true) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).FireworkOnJoin == true) {
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
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
											_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"summon firework_rocket ~ ~ ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 100);
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
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
											_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"summon firework_rocket ~ ~ ~ {LifeTime:25,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 110);
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
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
											_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"summon firework_rocket ~ ~ ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 120);
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
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
											_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"summon firework_rocket ~ ~ ~ {LifeTime:25,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 130);
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
									new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
											_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
									"summon firework_rocket ~ ~ ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 140);
			}
		}
		if ((entity.getDisplayName().getString()).equals("Y3Z0N")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("TheLightBlueGame")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("Shadyyyy_")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("TheCatsKing")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("releaseHUN")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("Alda_Moin")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P5 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("SoggyTacoZ")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P5 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("TheseChatban")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P4 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

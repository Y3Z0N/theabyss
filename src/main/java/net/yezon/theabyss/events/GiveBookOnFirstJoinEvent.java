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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GiveBookOnFirstJoinEvent {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheabyssModVariables.PlayerVariables())).FirstJoin == false) {
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
					if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TheabyssModVariables.PlayerVariables())).LPMMode == true) {
						{
							boolean _setval = true;
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstJoin = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = true;
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SleepEvent = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = true;
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SleepEvent2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = true;
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RadioEvent = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = true;
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.EA_Intro = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = entity.getDisplayName().getString();
							entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Playername = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
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
								if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TheabyssModVariables.PlayerVariables())).EternalAbyss == true) {
									if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).BookSpawn == false) {
										{
											boolean _setval = true;
											entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.BookSpawn = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											boolean _setval = true;
											entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.FirstJoin = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											String _setval = entity.getDisplayName().getString();
											entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Playername = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else {
									if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).BookSpawn == false) {
										{
											boolean _setval = true;
											entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.EA_Intro = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											boolean _setval = true;
											entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.BookSpawn = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof Player _player && !_player.level.isClientSide())
											_player.displayClientMessage(
													new TextComponent(("Thank you \u00A7b" + entity.getDisplayName().getString())), (false));
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
															new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
													("tellraw " + entity.getDisplayName().getString()
															+ " [\"\",{\"text\":\"for playing \"},{\"text\":\"the abyss 2\",\"color\":\"dark_aqua\"},{\"text\":\"! it would be cool if you can support me and my mods on patreon! click here to \"},{\"text\":\"[DONATE]\",\"color\":\"dark_aqua\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.patreon.com/y3z0n\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"click me to donate on Patreon!\"}}]"));
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
															new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
													("give " + entity.getDisplayName().getString() + " theabyss:guide_book"));
										{
											boolean _setval = true;
											entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.FirstJoin = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											String _setval = entity.getDisplayName().getString();
											entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Playername = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 5);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 5);
		}
	}
}

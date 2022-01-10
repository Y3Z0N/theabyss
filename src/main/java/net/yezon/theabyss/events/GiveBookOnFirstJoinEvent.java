package net.yezon.theabyss.events;

import net.yezon.theabyss.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class GiveBookOnFirstJoinEvent {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeEvent(dependencies);
		}
	}

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Capabilities.PlayerVariables())).FirstJoin == false) {
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
					if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).LPMMode == true) {
						{
							boolean _setval = (true);
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FirstJoin = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (true);
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SleepEvent = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (true);
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SleepEvent2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (true);
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RadioEvent = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (true);
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.EA_Intro = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (entity.getDisplayName().getString());
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Playername = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
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
								if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new Capabilities.PlayerVariables())).EternalAbyss == true) {
									if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new Capabilities.PlayerVariables())).BookSpawn == false) {
										if (entity instanceof ServerPlayerEntity) {
											Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("theabyss:unlock_the_book"));
											AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
											if (!_ap.isDone()) {
												Iterator _iterator = _ap.getRemaningCriteria().iterator();
												while (_iterator.hasNext()) {
													String _criterion = (String) _iterator.next();
													((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
												}
											}
										}
										{
											boolean _setval = (true);
											entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.BookSpawn = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											boolean _setval = (true);
											entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.FirstJoin = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											String _setval = (entity.getDisplayName().getString());
											entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Playername = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else {
									if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new Capabilities.PlayerVariables())).BookSpawn == false) {
										{
											boolean _setval = (true);
											entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.EA_Intro = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof ServerPlayerEntity) {
											Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("theabyss:unlock_the_book"));
											AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
											if (!_ap.isDone()) {
												Iterator _iterator = _ap.getRemaningCriteria().iterator();
												while (_iterator.hasNext()) {
													String _criterion = (String) _iterator.next();
													((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
												}
											}
										}
										{
											boolean _setval = (true);
											entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.BookSpawn = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(
													new StringTextComponent(("Thank you \u00A7b" + entity.getDisplayName().getString())), (false));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
																	.withFeedbackDisabled(),
													("tellraw " + entity.getDisplayName().getString()
															+ " [\"\",{\"text\":\"for playing \"},{\"text\":\"the abyss 2\",\"color\":\"dark_aqua\"},{\"text\":\"! it would be cool if you can support me and my mods on patreon! click here to \"},{\"text\":\"[DONATE]\",\"color\":\"dark_aqua\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.patreon.com/y3z0n\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"click me to donate on Patreon!\"}}]"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
																	.withFeedbackDisabled(),
													("give " + entity.getDisplayName().getString() + " theabyss:guide_book"));
										}
										{
											boolean _setval = (true);
											entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.FirstJoin = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											String _setval = (entity.getDisplayName().getString());
											entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Playername = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 5);
		}
	}
}

package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import javax.annotation.Nullable;

import java.util.Iterator;

@Mod.EventBusSubscriber
public class SleepEvent2Event {
	@SubscribeEvent
	public static void onEntityEndSleep(PlayerWakeUpEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == (Level.OVERWORLD)) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).SleepEvent == true) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).SleepEvent2 == false) {
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SleepEvent2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = entity.getX();
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SaveX = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = entity.getY();
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SaveY = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = entity.getZ();
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SaveZ = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SaveHP = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SaveFD = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
										_level.getServer(), null).withSuppressedOutput(),
								("execute in theabyss:dream run tp " + entity.getDisplayName().getString() + " 100 75 100"));
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 3, (false), (false)));
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
										new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())),
												Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
										("playsound theabyss:dream_event_1_sweep master " + entity.getDisplayName().getString()));
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 570);
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
								_entity.setHealth((float) (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TheabyssModVariables.PlayerVariables())).SaveHP);
							if (entity instanceof Player _player)
								_player.getFoodData().setFoodLevel((int) (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TheabyssModVariables.PlayerVariables())).SaveFD);
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
												_level.getServer(), null).withSuppressedOutput(),
										("execute in minecraft:overworld run tp " + entity.getDisplayName().getString() + " "
												+ (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new TheabyssModVariables.PlayerVariables())).SaveX
												+ " "
												+ (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new TheabyssModVariables.PlayerVariables())).SaveY
												+ " " + (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new TheabyssModVariables.PlayerVariables())).SaveZ));
							if (entity instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1, (false), (false)));
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 600);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
										_level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
								("playsound theabyss:dream_event_2 master " + entity.getDisplayName().getString()));
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
							if (entity instanceof Player _player && !_player.level.isClientSide())
								_player.displayClientMessage(
										new TextComponent(("\u00A7b" + entity.getDisplayName().getString() + "\u00A7f: what was this?")), (true));
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 618);
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("theabyss:strange_rem_phases"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemainingCriteria().iterator();
							while (_iterator.hasNext())
								_player.getAdvancements().award(_adv, (String) _iterator.next());
						}
					}
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("theabyss:story_adv"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemainingCriteria().iterator();
							while (_iterator.hasNext())
								_player.getAdvancements().award(_adv, (String) _iterator.next());
						}
					}
				}
			}
		}
	}
}

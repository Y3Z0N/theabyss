package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraftforge.eventbus.api.SubscribeEvent;
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

import java.util.Iterator;

public class RadioEventEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == (Level.OVERWORLD)) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).SleepEvent == true) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).SleepEvent2 == true) {
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
								("execute in theabyss:radio run tp " + entity.getDisplayName().getString() + " " + (entity.getX() + 250) + " 100 "
										+ (entity.getZ() - 250)));
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
					}.start(world, 1500);
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("theabyss:loran_adv"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemainingCriteria().iterator();
							while (_iterator.hasNext())
								_player.getAdvancements().award(_adv, (String) _iterator.next());
						}
					}
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("theabyss:flora_adv"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemainingCriteria().iterator();
							while (_iterator.hasNext())
								_player.getAdvancements().award(_adv, (String) _iterator.next());
						}
					}
					if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TheabyssModVariables.PlayerVariables())).RadioEvent == false) {
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
									_player.displayClientMessage(new TextComponent("find and collect \u00A7bloran"), (true));
								{
									boolean _setval = true;
									entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.RadioEvent = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 100);
					}
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent("you should go to \u00A7bsleep \u00A7ffirst.."), (false));
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("you should go to \u00A7bsleep \u00A7ffirst.."), (false));
			}
		}
	}
}

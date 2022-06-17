package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModMobEffects;
import net.yezon.theabyss.entity.PlayerBodyEntity;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.TextComponent;

public class ReturnToBodyEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(PlayerBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TheabyssModMobEffects.AFTER_LIFE.get());
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FoundBody = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(TheabyssModMobEffects.TANTRUM.get(), 200, 1, (false), (false)));
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
					{
						boolean _setval = false;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FoundBody = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 80);
		}
		if (!world.getEntitiesOfClass(PlayerBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), 256, 256, 256), e -> true).isEmpty()) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TheabyssModMobEffects.AFTER_LIFE.get()) : false) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("your \u00A7bbody\u00A7f is nearby .."), (true));
			}
		}
	}
}

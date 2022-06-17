package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;

public class AfterLifePotionEndEvent {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
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
						.orElse(new TheabyssModVariables.PlayerVariables())).FoundBody == true) {
					if (entity instanceof ServerPlayer _player)
						_player.setGameMode(GameType.SURVIVAL);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(20);
				} else {
					if (entity instanceof ServerPlayer _player)
						_player.setGameMode(GameType.SURVIVAL);
					entity.hurt(DamageSource.GENERIC, 100);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 20);
	}
}

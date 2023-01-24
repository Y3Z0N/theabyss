package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.TheabyssMod;

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
		TheabyssMod.queueServerWork(20, () -> {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).FoundBody == true) {
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.SURVIVAL);
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(20);
			} else {
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.SURVIVAL);
				entity.hurt(DamageSource.GENERIC, 100);
			}
		});
	}
}

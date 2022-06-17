package net.yezon.theabyss.events;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;

public class PXSurvivalEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.SURVIVAL);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("The Abyss: \u00A73Gamemode set to Survival Mode"), (false));
	}
}

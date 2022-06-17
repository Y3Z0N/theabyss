package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class CheckForPrologEvent {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheabyssModVariables.PlayerVariables())).Prolog == true) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).RadioEvent == false) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("that doesn't seem to work you are \u00A7btired\u00A7f.."), (true));
				return false;
			}
			return true;
		}
		return true;
	}
}

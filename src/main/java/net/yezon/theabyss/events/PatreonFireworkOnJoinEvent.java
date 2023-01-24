package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class PatreonFireworkOnJoinEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).FireworkOnJoin == false) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FireworkOnJoin = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7b[THE ABYSS]\u00A7f Fireworks On Join: \u00A7bEnabled"), (false));
		} else {
			{
				boolean _setval = false;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FireworkOnJoin = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7b[THE ABYSS]\u00A7f Fireworks On Join: \u00A7bDisabled"), (false));
		}
	}
}

package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import java.util.HashMap;

public class SetzCommandExecutedEvent {
	public static void execute(Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
			entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HudY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Y SET TO: " + (entity
					.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).HudY)),
					(false));
	}
}

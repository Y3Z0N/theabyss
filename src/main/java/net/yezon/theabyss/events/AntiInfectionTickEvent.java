package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraft.world.entity.Entity;

public class AntiInfectionTickEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheabyssModVariables.PlayerVariables())).Infected > 0.05) {
			{
				double _setval = (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).Infected - 0.005;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Infected = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

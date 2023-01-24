package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraft.world.entity.Entity;

public class ManaboostCommandEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 100;
			entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Mana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}

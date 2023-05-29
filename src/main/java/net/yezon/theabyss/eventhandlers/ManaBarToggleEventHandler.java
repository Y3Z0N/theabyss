package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraft.world.entity.Entity;

public class ManaBarToggleEventHandler {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).EnableManaBar
				&& (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).SomniumHandler) == true;
	}
}

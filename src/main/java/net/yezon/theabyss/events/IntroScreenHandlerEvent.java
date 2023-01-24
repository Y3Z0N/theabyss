package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraft.world.entity.Entity;

public class IntroScreenHandlerEvent {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).EA_Intro == false
				&& (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).EternalAbyss == true;
	}
}

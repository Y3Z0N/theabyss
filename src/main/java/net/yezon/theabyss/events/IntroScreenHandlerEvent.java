package net.yezon.theabyss.events;

import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class IntroScreenHandlerEvent {

	public static boolean executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event IntroScreenHandler!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Capabilities.PlayerVariables())).EA_Intro == false
				&& (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).EternalAbyss == true;
	}
}

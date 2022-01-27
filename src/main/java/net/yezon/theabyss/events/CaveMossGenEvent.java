package net.yezon.theabyss.events;

import net.yezon.theabyss.TheabyssMod;

import java.util.Map;

public class CaveMossGenEvent {

	public static boolean executeEvent(Map<String, Object> dependencies) {
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		return y < 55;
	}
}

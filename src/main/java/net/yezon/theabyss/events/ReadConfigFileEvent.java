package net.yezon.theabyss.events;

import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class ReadConfigFileEvent {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeEvent(dependencies);
		}
	}

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event ReadConfigFile!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		File config = new File("config", File.separator + "theabyss2.json");
		{
			try {
				BufferedReader configReader = new BufferedReader(new FileReader(config));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = configReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				configReader.close();
				JsonObject file = new Gson().fromJson(jsonstringbuilder.toString(), JsonObject.class);
				{
					boolean _setval = file.get("LPM Mode").getAsBoolean();
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.LPMMode = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = file.get("EA Mode").getAsBoolean();
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EternalAbyss = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = file.get("Potion Multiplier For Armor Abilites").getAsDouble();
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ArmorPotionLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = file.get("Somnium Bar X").getAsDouble();
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HudX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = file.get("Somnium Bar Y").getAsDouble();
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HudY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = file.get("Disable Somnium Bar when Empty").getAsBoolean();
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EmptySomnium = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = file.get("Enable Fear Effect").getAsBoolean();
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.FearEffect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = file.get("Enable Prolog [If Disabled, You Can Instantly Enter A Portal]").getAsBoolean();
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Prolog = _setval;
						capability.syncPlayerVariables(entity);
					});
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

package net.yezon.theabyss.events;

import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class GenerateConfigFileEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event GenerateConfigFile!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		File config = new File("config", File.separator + "theabyss2.json");
		if (!config.exists()) {
			try {
				config.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
			JsonObject file = new JsonObject();
			file.addProperty("LPM Mode", (false));
			file.addProperty("EA Mode", (false));
			file.addProperty("Somnium Bar X", 0);
			file.addProperty("Somnium Bar Y", 0);
			file.addProperty("Disable Somnium Bar when Empty", (false));
			file.addProperty("Potion Multiplier For Armor Abilites", 0);
			file.addProperty("Enable Fear Effect", (true));
			file.addProperty("Enable Prolog [If Disabled, You Can Instantly Enter A Portal]", (true));
			try {
				FileWriter configfw = new FileWriter(config);
				configfw.write(mainGSONBuilderVariable.toJson(file));
				configfw.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Creating config file.."), (false));
		}
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent("Config file created! saved in .minecraft/config/theabyss2.json"), (false));
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 100);
	}
}

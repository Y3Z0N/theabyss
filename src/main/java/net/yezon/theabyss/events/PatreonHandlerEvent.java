package net.yezon.theabyss.events;

import net.yezon.theabyss.particle.RenderLightCyanParticle;
import net.yezon.theabyss.particle.RenderBrightCyanParticle;
import net.yezon.theabyss.particle.EndSwordPTParticle;
import net.yezon.theabyss.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class PatreonHandlerEvent {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeEvent(dependencies);
			}
		}
	}

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Capabilities.PlayerVariables())).WalkParticles == true) {
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).P4 == true
					|| (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).P5 == true
					|| (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).P6 == true
					|| (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).PX == true) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(EndSwordPTParticle.particle, x, y, z, (int) 5, 0.055, 0.055, 0.055, 0.015);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(RenderLightCyanParticle.particle, x, y, z, (int) 2, 0.055, 0.055, 0.055, 0.015);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(RenderBrightCyanParticle.particle, x, y, z, (int) 2, 0.055, 0.055, 0.055, 0.015);
				}
			}
		}
	}
}

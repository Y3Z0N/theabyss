package net.yezon.theabyss.events;

import net.yezon.theabyss.particle.RenderCyanParticle;
import net.yezon.theabyss.particle.RenderBrightCyanParticle;
import net.yezon.theabyss.particle.EndSwordPTParticle;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;

import java.util.Map;

public class TeleportTrailEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(RenderCyanParticle.particle, x, y, z, (int) 40, 0.1, 0.1, 0.1, 0.05);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(EndSwordPTParticle.particle, x, y, z, (int) 30, 0.1, 0.1, 0.1, 0.05);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(RenderBrightCyanParticle.particle, x, y, z, (int) 20, 0.1, 0.1, 0.1, 0.05);
		}
	}
}

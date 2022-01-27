package net.yezon.theabyss.events;

import net.yezon.theabyss.particle.PhantomAttackParticleParticle;
import net.yezon.theabyss.particle.PhantomAttackParticle2Particle;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;

import java.util.Map;

public class PhantomTrailEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(PhantomAttackParticleParticle.particle, x, y, z, (int) 4, 0.014, 0.014, 0.014, 0.65);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(PhantomAttackParticle2Particle.particle, x, y, z, (int) 3, 0.03, 0.03, 0.03, 0.65);
		}
	}
}

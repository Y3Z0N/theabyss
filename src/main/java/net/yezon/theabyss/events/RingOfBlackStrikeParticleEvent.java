package net.yezon.theabyss.events;

import net.yezon.theabyss.particle.PhantomSpectrumParticle;
import net.yezon.theabyss.particle.PhantomFireParticle;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import java.util.Map;

public class RingOfBlackStrikeParticleEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.LARGE_SMOKE, x, y, z, (int) 5, 0.0105, 0.05, 0.005, 0.1);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(PhantomFireParticle.particle, x, y, z, (int) 10, 0.05, 0.05, 0.05, 0.1);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(PhantomFireParticle.particle, x, y, z, (int) 2, 0.08, 0.08, 0.08, 0.1);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(PhantomSpectrumParticle.particle, x, y, z, (int) 1, 0.01, 0.01, 0.01, 0.01);
		}
	}
}

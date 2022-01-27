package net.yezon.theabyss.events;

import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collections;

public class NightbladeBossDodgeOnHurtEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event NightbladeBossDodgeOnHurt!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (Math.random() < 0.3) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((x + 2), (y + 2), z);
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((x + 2), (y + 2), z, _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, z, (int) 3, 0.1, 1, 0.1, 0.1);
			}
		} else if (Math.random() < 0.3) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(x, (y + 2), (z + 2));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y + 2), (z + 2), _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, z, (int) 3, 0.1, 1, 0.1, 0.1);
			}
		}
	}
}

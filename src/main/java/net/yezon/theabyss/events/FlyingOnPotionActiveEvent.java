package net.yezon.theabyss.events;

import net.yezon.theabyss.potion.FlyingPotionEffect;
import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class FlyingOnPotionActiveEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event FlyingOnPotionActive!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Mana
					- 0.5 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).ManaUpgrade);
			entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Mana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).startFallFlying();
		}
		entity.setMotion((Math.sin(Math.toRadians(entity.rotationYaw + 180)) * 1.5), Math.sin(Math.toRadians(0 - entity.rotationPitch)),
				(Math.cos(Math.toRadians(entity.rotationYaw)) * 1.5));
		entity.fallDistance = (float) (0);
		if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Capabilities.PlayerVariables())).Mana < 1.5) {
			for (int index0 = 0; index0 < (int) (3); index0++) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(FlyingPotionEffect.potion);
				}
				entity.fallDistance = (float) (0);
			}
		} else if (entity.isOnGround()) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(FlyingPotionEffect.potion);
			}
			for (int index1 = 0; index1 < (int) (3); index1++) {
				entity.fallDistance = (float) (0);
			}
		}
	}
}

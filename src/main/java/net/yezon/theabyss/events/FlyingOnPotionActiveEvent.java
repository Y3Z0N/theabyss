package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModMobEffects;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class FlyingOnPotionActiveEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).Mana
					- 0.5 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade;
			entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Mana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), Math.sin(Math.toRadians(0 - entity.getXRot())), (Math.cos(Math.toRadians(entity.getYRot())) * 1.5)));
		entity.fallDistance = 0;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).Mana < 1.5) {
			for (int index0 = 0; index0 < (int) (3); index0++) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(TheabyssModMobEffects.FLYING.get());
				entity.fallDistance = 0;
			}
		} else if (entity.isOnGround()) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TheabyssModMobEffects.FLYING.get());
			for (int index1 = 0; index1 < (int) (3); index1++) {
				entity.fallDistance = 0;
			}
		}
	}
}

package net.yezon.theabyss.events;

import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class GlacerytheArmorHelmetAbilityEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event GlacerytheArmorHelmetAbility!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, (int) 60,
					(int) (0 + (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).ArmorPotionLevel),
					(false), (false)));
	}
}

package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.init.TheabyssModMobEffects;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;

public class JellyFishHandlerEventHandler {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			entity.hurt(DamageSource.GENERIC, 1);
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(TheabyssModMobEffects.FROST_POISON.get(), 200, 0, (false), (false)));
		}
	}
}

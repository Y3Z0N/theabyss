
package net.yezon.theabyss.potion;

import net.yezon.theabyss.eventhandlers.FirestormOnPotionActiveEventHandler;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FirestormMobEffect extends MobEffect {
	public FirestormMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.firestorm";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FirestormOnPotionActiveEventHandler.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

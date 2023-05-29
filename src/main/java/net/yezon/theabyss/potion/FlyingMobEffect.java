
package net.yezon.theabyss.potion;

import net.yezon.theabyss.eventhandlers.FlyingOnPotionActiveEventHandler;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FlyingMobEffect extends MobEffect {
	public FlyingMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10027060);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.flying";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FlyingOnPotionActiveEventHandler.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}


package net.yezon.theabyss.potion;

import net.yezon.theabyss.eventhandlers.TantrumOnPotionEventHandler;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class TantrumMobEffect extends MobEffect {
	public TantrumMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16711785);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.tantrum";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TantrumOnPotionEventHandler.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

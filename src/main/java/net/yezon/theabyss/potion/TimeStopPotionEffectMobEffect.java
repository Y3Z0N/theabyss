
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.TimeStopParticlesevent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class TimeStopPotionEffectMobEffect extends MobEffect {
	public TimeStopPotionEffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13421569);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.time_stop_potion_effect";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TimeStopParticlesevent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

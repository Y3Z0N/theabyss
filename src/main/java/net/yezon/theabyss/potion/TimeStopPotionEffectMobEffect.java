
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.TimeStopPotionEffectPotionStartedappliedEvent;
import net.yezon.theabyss.events.TimeStopParticlesEvent;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
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
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		TimeStopPotionEffectPotionStartedappliedEvent.execute(

		);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TimeStopParticlesEvent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

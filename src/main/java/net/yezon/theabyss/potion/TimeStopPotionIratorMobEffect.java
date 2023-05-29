
package net.yezon.theabyss.potion;

import net.yezon.theabyss.eventhandlers.TimeStopPotionIratorOnPotionActiveTickEventHandler;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class TimeStopPotionIratorMobEffect extends MobEffect {
	public TimeStopPotionIratorMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13421569);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.time_stop_potion_irator";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		TimeStopPotionIratorOnPotionActiveTickEventHandler.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TimeStopPotionIratorOnPotionActiveTickEventHandler.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

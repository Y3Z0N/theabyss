
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.FearPotionStartedappliedEvent;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FearMobEffect extends MobEffect {
	public FearMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777165);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.fear";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		FearPotionStartedappliedEvent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}


package net.yezon.theabyss.potion;

import net.yezon.theabyss.eventhandlers.ReturnToBodyEventHandler;
import net.yezon.theabyss.eventhandlers.AfterLifePotionStartEventHandler;
import net.yezon.theabyss.eventhandlers.AfterLifePotionEndEventHandler;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AfterLifeMobEffect extends MobEffect {
	public AfterLifeMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10092442);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.after_life";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		AfterLifePotionStartEventHandler.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ReturnToBodyEventHandler.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		AfterLifePotionEndEventHandler.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

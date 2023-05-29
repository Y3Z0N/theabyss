
package net.yezon.theabyss.potion;

import net.yezon.theabyss.eventhandlers.GhostPotionStartEventHandler;
import net.yezon.theabyss.eventhandlers.GhostPotionEndEventHandler;
import net.yezon.theabyss.eventhandlers.GhostOnPotionActiveEventHandler;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class GhostMobEffect extends MobEffect {
	public GhostMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -2500135);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.ghost";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		GhostPotionStartEventHandler.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		GhostOnPotionActiveEventHandler.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		GhostPotionEndEventHandler.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

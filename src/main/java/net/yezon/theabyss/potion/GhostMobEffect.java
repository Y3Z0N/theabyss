
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.GhostPotionStartevent;
import net.yezon.theabyss.events.GhostPotionEndevent;
import net.yezon.theabyss.events.GhostOnPotionActiveevent;

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
		GhostPotionStartevent.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		GhostOnPotionActiveevent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		GhostPotionEndevent.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

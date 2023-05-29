
package net.yezon.theabyss.potion;

import net.yezon.theabyss.eventhandlers.ImmortalPotionExpiresEventHandler;
import net.yezon.theabyss.eventhandlers.ImmortalPotionActiveEventHandler;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ImmortalMobEffect extends MobEffect {
	public ImmortalMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16751002);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.immortal";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ImmortalPotionActiveEventHandler.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		ImmortalPotionExpiresEventHandler.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

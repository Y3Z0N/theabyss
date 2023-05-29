
package net.yezon.theabyss.potion;

import net.yezon.theabyss.eventhandlers.FrostPoisonOActiveEventHandler;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FrostPoisonMobEffect extends MobEffect {
	public FrostPoisonMobEffect() {
		super(MobEffectCategory.NEUTRAL, -3342337);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.frost_poison";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FrostPoisonOActiveEventHandler.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

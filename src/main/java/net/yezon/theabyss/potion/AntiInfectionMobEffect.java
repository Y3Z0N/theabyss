
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.AntiInfectionTickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AntiInfectionMobEffect extends MobEffect {
	public AntiInfectionMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.anti_infection";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AntiInfectionTickEvent.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

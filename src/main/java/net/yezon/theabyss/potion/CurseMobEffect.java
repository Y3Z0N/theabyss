
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.CurseOnPotionActiveTickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CurseMobEffect extends MobEffect {
	public CurseMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.curse";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CurseOnPotionActiveTickEvent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

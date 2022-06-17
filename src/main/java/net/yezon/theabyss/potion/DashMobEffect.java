
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.DashEffectActiveEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DashMobEffect extends MobEffect {
	public DashMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.dash";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DashEffectActiveEvent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

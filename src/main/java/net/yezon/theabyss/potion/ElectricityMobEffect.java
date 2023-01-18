
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.ElectricityOnEffectActiveevent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ElectricityMobEffect extends MobEffect {
	public ElectricityMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.electricity";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ElectricityOnEffectActiveevent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

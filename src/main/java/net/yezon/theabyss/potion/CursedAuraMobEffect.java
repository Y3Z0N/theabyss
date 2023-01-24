
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.CursedAuraActiveEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CursedAuraMobEffect extends MobEffect {
	public CursedAuraMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.cursed_aura";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CursedAuraActiveEvent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

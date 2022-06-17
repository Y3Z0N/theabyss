
package net.yezon.theabyss.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AntiFearPotionMobEffect extends MobEffect {
	public AntiFearPotionMobEffect() {
		super(MobEffectCategory.NEUTRAL, -52225);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.anti_fear_potion";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

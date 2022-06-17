
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.NodeParticlesEvent;
import net.yezon.theabyss.events.NodeEffectEvent;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class NodePotionMobEffect extends MobEffect {
	public NodePotionMobEffect() {
		super(MobEffectCategory.NEUTRAL, -65281);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.node_potion";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		NodeEffectEvent.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		NodeParticlesEvent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}

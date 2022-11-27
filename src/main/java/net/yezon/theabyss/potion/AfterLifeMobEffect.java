
package net.yezon.theabyss.potion;

import net.yezon.theabyss.events.ReturnToBodyEvent;
import net.yezon.theabyss.events.AfterLifePotionStartEvent;
import net.yezon.theabyss.events.AfterLifePotionEndEvent;

import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;

import com.mojang.blaze3d.vertex.PoseStack;

public class AfterLifeMobEffect extends MobEffect {
	public AfterLifeMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10092442);
	}

	@Override
	public String getDescriptionId() {
		return "effect.theabyss.after_life";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		AfterLifePotionStartEvent.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ReturnToBodyEvent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		AfterLifePotionEndEvent.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientMobEffectExtensions> consumer) {
		consumer.accept(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, PoseStack poseStack, int x,
					int y, int blitOffset) {
				return false;
			}
		});
	}
}

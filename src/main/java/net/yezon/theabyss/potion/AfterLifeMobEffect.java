package net.yezon.theabyss.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.yezon.theabyss.events.AfterLifePotionEndevent;
import net.yezon.theabyss.events.AfterLifePotionStartevent;
import net.yezon.theabyss.events.ReturnToBodyevent;

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
        AfterLifePotionStartevent.execute(entity);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        ReturnToBodyevent.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        AfterLifePotionEndevent.execute(entity.level, entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}

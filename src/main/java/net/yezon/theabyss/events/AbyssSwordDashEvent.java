package net.yezon.theabyss.events;

import net.yezon.theabyss.potion.FlyingPotionEffect;
import net.yezon.theabyss.potion.DashPotionEffect;
import net.yezon.theabyss.item.AbyssSwordItem;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.util.Hand;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class AbyssSwordDashEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.isOnGround()) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 14, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DashPotionEffect.potion, (int) 20, (int) 0, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("/playsound theabyss:dash master " + entity.getDisplayName().getString() + " ~ ~ ~ 0.75"));
				}
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			entity.setMotion(0, 0.2, 0);
			entity.setMotion((Math.sin(Math.toRadians(entity.rotationYaw + 180)) * 1.5), Math.sin(Math.toRadians(0 - entity.rotationPitch)),
					(Math.cos(Math.toRadians(entity.rotationYaw)) * 1.5));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(AbyssSwordItem.block, (int) 50);
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 50, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(FlyingPotionEffect.potion, (int) 50, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DashPotionEffect.potion, (int) 40, (int) 0, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("/playsound theabyss:dash master " + entity.getDisplayName().getString() + " ~ ~ ~ 0.75"));
				}
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			entity.setMotion(0, 0.2, 0);
			entity.setMotion((Math.sin(Math.toRadians(entity.rotationYaw + 180)) * 1.5), Math.sin(Math.toRadians(0 - entity.rotationPitch)),
					(Math.cos(Math.toRadians(entity.rotationYaw)) * 1.5));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(AbyssSwordItem.block, (int) 50);
		}
	}
}

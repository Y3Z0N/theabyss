package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModMobEffects;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class UseDashEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isOnGround()) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 14, 2, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(TheabyssModMobEffects.DASH.get(), 20, 0, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("/playsound theabyss:dash master " + entity.getDisplayName().getString() + " ~ ~ ~ 0.75"));
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("/playsound theabyss:nightblade_attack master " + entity.getDisplayName().getString() + " ~ ~ ~ 0.75"));
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			entity.setDeltaMovement(new Vec3(0, 0.2, 0));
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), Math.sin(Math.toRadians(0 - entity.getXRot())), (Math.cos(Math.toRadians(entity.getYRot())) * 1.5)));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(TheabyssModItems.ABYSS_SWORD.get(), 50);
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 50, 2, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(TheabyssModMobEffects.FLYING.get(), 50, 2, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(TheabyssModMobEffects.DASH.get(), 40, 0, (false), (false)));
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("/playsound theabyss:dash master " + entity.getDisplayName().getString() + " ~ ~ ~ 0.75"));
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("/playsound theabyss:nightblade_attack master " + entity.getDisplayName().getString() + " ~ ~ ~ 0.75"));
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			entity.setDeltaMovement(new Vec3(0, 0.2, 0));
			entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 1.5), Math.sin(Math.toRadians(0 - entity.getXRot())), (Math.cos(Math.toRadians(entity.getYRot())) * 1.5)));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(TheabyssModItems.ABYSS_SWORD.get(), 50);
		}
	}
}

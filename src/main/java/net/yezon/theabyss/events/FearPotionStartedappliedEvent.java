package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModMobEffects;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class FearPotionStartedappliedEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("\u00A7fYou're \u00A75scared\u00A7f. \u00A7fTake care"), (true));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands()
					.performCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
									_level.getServer(), null).withSuppressedOutput(),
							("/playsound theabyss:fear_event master " + entity.getDisplayName().getString()));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 550, 0, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 620, 1, (false), (false)));
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(TheabyssModMobEffects.FEAR.get(), 620, 1, (false), (false)));
				}
			}
		}
	}
}

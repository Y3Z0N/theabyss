package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.init.TheabyssModMobEffects;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.stream.Collectors;
import java.util.Random;
import java.util.List;
import java.util.Comparator;

public class TimeTotemEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 5) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(24);
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(TheabyssModItems.TOTEM_OF_TIME.get()));
			if (entity instanceof Player _playerHasItem
					? _playerHasItem.getInventory().contains(new ItemStack(TheabyssModItems.TOTEM_OF_TIME.get()))
					: false) {
				if (itemstack.getItem() == TheabyssModItems.TOTEM_OF_TIME.get()) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(25, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:phantom_hurt")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:phantom_hurt")),
							SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.END_SWORD_PT.get()), x, y, z, 10, 0.5, 0.5, 0.5, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y, z, 1, 0.5, 0.5, 0.5, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 2, 0.5, 0.5, 0.5, 1);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 40, (false), (false)));
						if (entityiterator instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(TheabyssModMobEffects.TIME_STOP_POTION_IRATOR.get(), 200, 40, (false), (false)));
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(TheabyssModMobEffects.TIME_STOP_POTION_EFFECT.get(), 200, 0));
					}
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 200);
		}
	}
}

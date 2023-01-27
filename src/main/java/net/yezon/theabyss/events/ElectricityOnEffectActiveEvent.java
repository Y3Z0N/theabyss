package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.init.TheabyssModMobEffects;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class ElectricityOnEffectActiveEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.ELECTRICITY_ANIMATED.get()), x, y, z, 10, 0.1, 1, 0.1, 0.02);
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1, (false), (false)));
		entity.hurt(DamageSource.MAGIC,
				(float) (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheabyssModMobEffects.ELECTRICITY.get())
						? _livEnt.getEffect(TheabyssModMobEffects.ELECTRICITY.get()).getAmplifier()
						: 0) - (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 6.5));
		if (Math.random() < 0.05) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_elec")), SoundSource.HOSTILE, (float) 1.2,
							1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_elec")),
							SoundSource.HOSTILE, (float) 1.2, 1, false);
				}
			}
		}
	}
}

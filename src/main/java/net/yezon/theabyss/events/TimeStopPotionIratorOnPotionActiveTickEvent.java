package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModParticleTypes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class TimeStopPotionIratorOnPotionActiveTickEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, 0, 0));
		{
			Entity _ent = entity;
			_ent.setYRot(entity.getYRot());
			_ent.setXRot(entity.getXRot());
			_ent.setYBodyRot(_ent.getYRot());
			_ent.setYHeadRot(_ent.getYRot());
			_ent.yRotO = _ent.getYRot();
			_ent.xRotO = _ent.getXRot();
			if (_ent instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.END_SWORD_PT.get()), x, y, z, 1, 0.02, 0.8, 0.02, 0.1);
	}
}

package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModParticleTypes;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

public class GhostEventEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 5, 0.05, 1.5, 0.05, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 5, 0.05, 1.5, 0.05, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.PHANTOM_FIRE.get()), x, y, z, 5, 0.05, 1.5, 0.05, 0.01);
		entity.setDeltaMovement(new Vec3(0, 0.05, 0));
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (!entity.level.isClientSide())
					entity.discard();
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.05, 1.5, 0.05, 0.01);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.PHANTOM_FIRE.get()), (entity.getX()), (entity.getY()),
							(entity.getZ()), 5, 0.05, 1.5, 0.05, 0.01);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.05, 1.5, 0.05, 0.01);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 100);
	}
}

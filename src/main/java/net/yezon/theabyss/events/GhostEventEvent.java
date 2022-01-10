package net.yezon.theabyss.events;

import net.yezon.theabyss.particle.PhantomFireParticle;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import java.util.Map;

public class GhostEventEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, z, (int) 5, 0.05, 1.5, 0.05, 0.01);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.LARGE_SMOKE, x, y, z, (int) 5, 0.05, 1.5, 0.05, 0.01);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(PhantomFireParticle.particle, x, y, z, (int) 5, 0.05, 1.5, 0.05, 0.01);
		}
		entity.setMotion(0, 0.05, 0);
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
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
				if (!entity.world.isRemote())
					entity.remove();
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.LARGE_SMOKE, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
							(int) 5, 0.05, 1.5, 0.05, 0.01);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(PhantomFireParticle.particle, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
							(int) 5, 0.05, 1.5, 0.05, 0.01);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), (int) 5,
							0.05, 1.5, 0.05, 0.01);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 100);
	}
}

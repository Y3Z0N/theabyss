package net.yezon.theabyss.events;

import net.yezon.theabyss.particle.RenderLightCyanParticle;
import net.yezon.theabyss.particle.RenderCyanParticle;
import net.yezon.theabyss.particle.RenderBrightCyanParticle;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class DimensionalCrackTicksEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(RenderLightCyanParticle.particle, x, y, z, (int) 20, 1.5, 2, 1.5, 0.01);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(RenderCyanParticle.particle, x, y, z, (int) 10, 1, 2, 1, 0.01);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(RenderBrightCyanParticle.particle, x, y, z, (int) 15, 2, 2, 2, 0.01);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(RenderBrightCyanParticle.particle, x, y, z, (int) 5, 0.1, 2, 0.1, 0.01);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(RenderLightCyanParticle.particle, x, y, z, (int) 5, 0.1, 2, 0.1, 0.01);
		}
		if (Math.random() < 0.003) {
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
				_ent.setEffectOnly(true);
				((World) world).addEntity(_ent);
			}
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (entityiterator instanceof LivingEntity)
						((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 40, (int) 0, (true), (true)));
					if (entityiterator instanceof LivingEntity)
						((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 1, (true), (true)));
					entityiterator.setMotion((entity.getPosX()), 0.03, (entity.getPosZ()));
				}
			}
		}
	}
}

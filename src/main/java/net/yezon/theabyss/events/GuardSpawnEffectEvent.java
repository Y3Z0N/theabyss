package net.yezon.theabyss.events;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

public class GuardSpawnEffectEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setCustomName(new TextComponent((entity.getDisplayName().getString())));
		if (Math.random() < 0.08) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}

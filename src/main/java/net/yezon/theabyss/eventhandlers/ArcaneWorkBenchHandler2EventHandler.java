package net.yezon.theabyss.eventhandlers;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class ArcaneWorkBenchHandler2EventHandler {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		RingOfSeekerBenchEventHandler.execute(entity);
		RingOfPocketboxBenchEventHandler.execute(entity);
		RingOfFlightBenchEventHandler.execute(entity);
		RingOfNatureBenchEventHandler.execute(entity);
		RingOfHomeBenchEventHandler.execute(entity);
		RingOfSlideBenchEventHandler.execute(entity);
		RingOfEnderchestBenchEventHandler.execute(entity);
		RingOfRegBenchEventHandler.execute(world, x, y, z, entity);
		RingOfCurseBenchEventHandler.execute(entity);
		RingOfBlackstrikeBenchEventHandler.execute(entity);
		RingOfTelekineticBenchEventHandler.execute(entity);
		RingOfFirestormBenchEventHandler.execute(entity);
		RingOfFirestrikeBenchEventHandler.execute(entity);
		RingOfFireBenchEventHandler.execute(entity);
		RingOfSpeedBenchEventHandler.execute(world, x, y, z, entity);
		RingOfTimeBenchEventHandler.execute(entity);
		RingOfJuggerBenchEventHandler.execute(entity);
		RingOfFreezeBenchEventHandler.execute(world, x, y, z, entity);
		RingOfThunderBenchEventHandler.execute(entity);
		RingOfOceanBenchEventHandler.execute(entity);
		RingOfInvBenchEventHandler.execute(entity);
		RingOfEagleBenchEventHandler.execute(entity);
		RingOfTeleportBenchEventHandler.execute(entity);
	}
}

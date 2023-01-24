package net.yezon.theabyss.events;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class ArcaneWorkBenchHandler2Event {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		RingOfSeekerBenchEvent.execute(entity);
		RingOfPocketboxBenchEvent.execute(entity);
		RingOfFlightBenchEvent.execute(entity);
		RingOfNatureBenchEvent.execute(entity);
		RingOfHomeBenchEvent.execute(entity);
		RingOfSlideBenchEvent.execute(entity);
		RingOfEnderchestBenchEvent.execute(entity);
		RingOfRegBenchEvent.execute(world, x, y, z, entity);
		RingOfCurseBenchEvent.execute(entity);
		RingOfBlackstrikeBenchEvent.execute(entity);
		RingOfTelekineticBenchEvent.execute(entity);
		RingOfFirestormBenchEvent.execute(entity);
		RingOfFirestrikeBenchEvent.execute(entity);
		RingOfFireBenchEvent.execute(entity);
		RingOfSpeedBenchEvent.execute(world, x, y, z, entity);
		RingOfTimeBenchEvent.execute(entity);
		RingOfJuggerBenchEvent.execute(entity);
		RingOfFreezeBenchEvent.execute(world, x, y, z, entity);
		RingOfThunderBenchEvent.execute(entity);
		RingOfOceanBenchEvent.execute(entity);
		RingOfInvBenchEvent.execute(entity);
		RingOfEagleBenchEvent.execute(entity);
		RingOfTeleportBenchEvent.execute(entity);
	}
}

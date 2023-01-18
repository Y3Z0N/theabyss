package net.yezon.theabyss.events;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class ArcaneWorkBenchHandler2event {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		RingOfSeekerBenchevent.execute(entity);
		RingOfPocketboxBenchevent.execute(entity);
		RingOfFlightBenchevent.execute(entity);
		RingOfNatureBenchevent.execute(entity);
		RingOfHomeBenchevent.execute(entity);
		RingOfSlideBenchevent.execute(entity);
		RingOfEnderchestBenchevent.execute(entity);
		RingOfRegBenchevent.execute(world, x, y, z, entity);
		RingOfCurseBenchevent.execute(entity);
		RingOfBlackstrikeBenchevent.execute(entity);
		RingOfTelekineticBenchevent.execute(entity);
		RingOfFirestormBenchevent.execute(entity);
		RingOfFirestrikeBenchevent.execute(entity);
		RingOfFireBenchevent.execute(entity);
		RingOfSpeedBenchevent.execute(world, x, y, z, entity);
		RingOfTimeBenchevent.execute(entity);
		RingOfJuggerBenchevent.execute(entity);
		RingOfFreezeBenchevent.execute(world, x, y, z, entity);
		RingOfThunderBenchevent.execute(entity);
		RingOfOceanBenchevent.execute(entity);
		RingOfInvBenchevent.execute(entity);
		RingOfEagleBenchevent.execute(entity);
		RingOfTeleportBenchevent.execute(entity);
	}
}

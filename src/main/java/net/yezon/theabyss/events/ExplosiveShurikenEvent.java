package net.yezon.theabyss.events;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;

public class ExplosiveShurikenEvent {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, (float) 1.17, Explosion.BlockInteraction.DESTROY);
	}
}

package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;

public class PatreonGetDisc1EventHandler {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level && !_level.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheabyssModItems.CYANIDE_THEME.get()));
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}

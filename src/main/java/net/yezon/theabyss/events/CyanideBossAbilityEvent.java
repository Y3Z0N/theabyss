package net.yezon.theabyss.events;

import net.yezon.theabyss.block.GlitchBlockBlock;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

public class CyanideBossAbilityEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (Math.random() < 0.005) {
			world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 5), (int) z), GlitchBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 3), (int) (y + 5), (int) z), GlitchBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 3)), GlitchBlockBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 3)), GlitchBlockBlock.block.getDefaultState(), 3);
		}
	}
}

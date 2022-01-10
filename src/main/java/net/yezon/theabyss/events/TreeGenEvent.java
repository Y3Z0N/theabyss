package net.yezon.theabyss.events;

import net.yezon.theabyss.block.InfectedGrassBlock;
import net.yezon.theabyss.block.GrassSmallBlock;
import net.yezon.theabyss.block.GrassMiddleBlock;
import net.yezon.theabyss.block.GrassBigBlock;
import net.yezon.theabyss.block.DirtBlock;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

public class TreeGenEvent {

	public static boolean executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == DirtBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == InfectedGrassBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == GrassSmallBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == GrassMiddleBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == GrassBigBlock.block) {
			return true;
		}
		return false;
	}
}

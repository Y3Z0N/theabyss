package net.yezon.theabyss.events;

import net.yezon.theabyss.block.SpreadDirtBlock;
import net.yezon.theabyss.block.DirtBlock;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

public class BackupspreadEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.POPPY) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.SUNFLOWER) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.DANDELION) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.FERN) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.DIRT.getDefaultState(), 3);
		}
		if (Math.random() >= 0.1) {
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() >= 0.05) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
		}
	}
}

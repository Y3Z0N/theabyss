package net.yezon.theabyss.events;

import net.yezon.theabyss.block.WartRootBlock;
import net.yezon.theabyss.block.TenuemFireBlock;
import net.yezon.theabyss.block.SpreadDirtBlock;
import net.yezon.theabyss.block.SaturniaVersaBlock;
import net.yezon.theabyss.block.RikomiVersaBlock;
import net.yezon.theabyss.block.LumusMaximusBlock;
import net.yezon.theabyss.block.LumaGrassBlock;
import net.yezon.theabyss.block.LoranBushBlock;
import net.yezon.theabyss.block.LoranBush2Block;
import net.yezon.theabyss.block.DirtBlock;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

public class PortalSpreadAbyssEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS) {
			if (Math.random() < 0.5) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = LoranBushBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = LumaGrassBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.TALL_GRASS) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
				BlockState _bs = WartRootBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.POPPY) {
			if (Math.random() < 0.5) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = LoranBushBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = LumaGrassBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.POPPY) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
			if (Math.random() < 0.5) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = SaturniaVersaBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = RikomiVersaBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.BLUE_ORCHID) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
			if (Math.random() < 0.5) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = LumaGrassBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = SaturniaVersaBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.ROSE_BUSH) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
			if (Math.random() < 0.5) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = SaturniaVersaBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = TenuemFireBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.PINK_TULIP) {
			if (Math.random() < 0.5) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = LumusMaximusBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = WartRootBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.DANDELION) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
				BlockState _bs = LoranBush2Block.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.FERN) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
		} else if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DirtBlock.block.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.DIRT.getDefaultState(), 3);
		}
		if (Math.random() >= 0.03) {
			if (Math.random() <= 0.5) {
				if (!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.5) {
				if (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.5) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.5) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
				if (!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
				if (!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
				if (!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
				if (!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
				if (!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.AIR)) {
					if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.GRASS_BLOCK) {
						world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), SpreadDirtBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (Math.random() <= 0.2) {
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

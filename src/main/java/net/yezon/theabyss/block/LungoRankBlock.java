
package net.yezon.theabyss.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class LungoRankBlock extends SugarCaneBlock {
	public LungoRankBlock() {
		super(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().sound(SoundType.WEEPING_VINES).instabreak()
				.hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 5).noLootTable().noCollission());
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.PLAINS;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos blockpos, RandomSource random) {
		if (world.isEmptyBlock(blockpos.above())) {
			int i = 1;
			for (; world.getBlockState(blockpos.below(i)).is(this); ++i);
			if (i < 14) {
				int j = blockstate.getValue(AGE);
				if (ForgeHooks.onCropsGrowPre(world, blockpos, blockstate, true)) {
					if (j == 15) {
						world.setBlockAndUpdate(blockpos.above(), defaultBlockState());
						world.setBlock(blockpos, blockstate.setValue(AGE, 0), 4);
					} else
						world.setBlock(blockpos, blockstate.setValue(AGE, j + 1), 4);
				}
			}
		}
	}
}


package net.yezon.theabyss.block;

import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import java.util.Random;

public class AurelRankBlock extends SugarCaneBlock {
	public AurelRankBlock() {
		super(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.GRASS).instabreak().noDrops());
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.NONE;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return groundState.is(this) || groundState.is(TheabyssModBlocks.STONE.get())

		;
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.CAVE;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos blockpos, Random random) {
		if (world.isEmptyBlock(blockpos.above())) {
			int i = 1;
			for (; world.getBlockState(blockpos.below(i)).is(this); ++i);
			if (i < 6) {
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

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(TheabyssModBlocks.AUREL_RANK.get(), renderType -> renderType == RenderType.cutout());
	}
}

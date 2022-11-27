
package net.yezon.theabyss.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class LumusFlowerBlock extends SugarCaneBlock {
	public LumusFlowerBlock() {
		super(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().sound(SoundType.GRASS).instabreak().hasPostProcess((bs, br, bp) -> true)
				.emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 3).noCollission());
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this));
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

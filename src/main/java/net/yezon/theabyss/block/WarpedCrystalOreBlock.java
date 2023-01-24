
package net.yezon.theabyss.block;

import org.checkerframework.checker.units.qual.s;

import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.common.PlantType;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class WarpedCrystalOreBlock extends FlowerBlock {
	public WarpedCrystalOreBlock() {
		super(MobEffects.SATURATION, 0,
				BlockBehaviour.Properties.of(Material.PLANT)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("theabyss:crystal_break")), () -> new SoundEvent(new ResourceLocation("block.stone.step")),
								() -> new SoundEvent(new ResourceLocation("block.stone.place")), () -> new SoundEvent(new ResourceLocation("block.stone.hit")), () -> new SoundEvent(new ResourceLocation("block.stone.fall"))))
						.instabreak().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 3).noCollission());
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
		return Collections.singletonList(new ItemStack(TheabyssModBlocks.WARPED_CRYSTAL_ORE.get()));
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(Blocks.WARPED_NYLIUM);
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.NETHER;
	}
}

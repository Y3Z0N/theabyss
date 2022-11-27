package net.yezon.theabyss.world.features.treedecorators;

import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;

public class FungalForestFruitDecorator extends CocoaDecorator {
	public static final FungalForestFruitDecorator INSTANCE = new FungalForestFruitDecorator();
	public static com.mojang.serialization.Codec<FungalForestFruitDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		ForgeRegistries.TREE_DECORATOR_TYPES.register("fungal_forest_tree_fruit_decorator", tdt);
	}

	public FungalForestFruitDecorator() {
		super(0.2f);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(TreeDecorator.Context pContext) {
		RandomSource randomsource = pContext.random();
		if (!(randomsource.nextFloat() >= 0.2F)) {
			List<BlockPos> list = pContext.logs();
			int i = list.get(0).getY();
			list.stream().filter((p_69980_) -> {
				return p_69980_.getY() - i <= 2;
			}).forEach((p_226026_) -> {
				for (Direction direction : Direction.Plane.HORIZONTAL) {
					if (randomsource.nextFloat() <= 0.25F) {
						Direction direction1 = direction.getOpposite();
						BlockPos blockpos = p_226026_.offset(direction1.getStepX(), 0, direction1.getStepZ());
						if (pContext.isAir(blockpos)) {
							pContext.setBlock(blockpos, TheabyssModBlocks.BLARU_LEAVES.get().defaultBlockState());
						}
					}
				}
			});
		}
	}
}

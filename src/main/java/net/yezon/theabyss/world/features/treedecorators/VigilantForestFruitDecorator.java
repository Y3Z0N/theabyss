package net.yezon.theabyss.world.features.treedecorators;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;

public class VigilantForestFruitDecorator extends CocoaDecorator {
	public static final VigilantForestFruitDecorator INSTANCE = new VigilantForestFruitDecorator();
	public static com.mojang.serialization.Codec<VigilantForestFruitDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		ForgeRegistries.TREE_DECORATOR_TYPES.register("vigilant_forest_tree_fruit_decorator", tdt);
	}

	public VigilantForestFruitDecorator() {
		super(0.2f);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(TreeDecorator.Context context) {
		RandomSource randomsource = context.random();
		if (!(randomsource.nextFloat() >= 0.2F)) {
			List<BlockPos> list = context.logs();
			int i = list.get(0).getY();
			list.stream().filter((p_69980_) -> {
				return p_69980_.getY() - i <= 2;
			}).forEach((p_226026_) -> {
				for (Direction direction : Direction.Plane.HORIZONTAL) {
					if (randomsource.nextFloat() <= 0.25F) {
						Direction direction1 = direction.getOpposite();
						BlockPos blockpos = p_226026_.offset(direction1.getStepX(), 0, direction1.getStepZ());
						if (context.isAir(blockpos)) {
							context.setBlock(blockpos, Blocks.AIR.defaultBlockState());
						}
					}
				}
			});
		}
	}
}

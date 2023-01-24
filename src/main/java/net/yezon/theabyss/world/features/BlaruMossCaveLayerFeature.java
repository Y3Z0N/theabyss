
package net.yezon.theabyss.world.features;

import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.configurations.BlockPileConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.BlockPileFeature;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Holder;

import java.util.List;

public class BlaruMossCaveLayerFeature extends BlockPileFeature {
	public static BlaruMossCaveLayerFeature FEATURE = null;
	public static Holder<ConfiguredFeature<BlockPileConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new BlaruMossCaveLayerFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("theabyss:blaru_moss_cave_layer", FEATURE,
				new BlockPileConfiguration(BlockStateProvider.simple(TheabyssModBlocks.GLOWING_BLARU_MOSS.get().defaultBlockState())));
		PLACED_FEATURE = PlacementUtils.register("theabyss:blaru_moss_cave_layer", CONFIGURED_FEATURE,
				List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR), RarityFilter.onAverageOnceEvery(1)));
		return FEATURE;
	}

	public BlaruMossCaveLayerFeature() {
		super(BlockPileConfiguration.CODEC);
	}
}

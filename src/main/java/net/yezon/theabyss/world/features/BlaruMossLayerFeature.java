
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

public class BlaruMossLayerFeature extends BlockPileFeature {
	public static BlaruMossLayerFeature FEATURE = null;
	public static Holder<ConfiguredFeature<BlockPileConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new BlaruMossLayerFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("theabyss:blaru_moss_layer", FEATURE,
				new BlockPileConfiguration(BlockStateProvider.simple(TheabyssModBlocks.GLOWING_BLARU_MOSS.get().defaultBlockState())));
		PLACED_FEATURE = PlacementUtils.register("theabyss:blaru_moss_layer", CONFIGURED_FEATURE,
				List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), RarityFilter.onAverageOnceEvery(1)));
		return FEATURE;
	}

	public BlaruMossLayerFeature() {
		super(BlockPileConfiguration.CODEC);
	}
}

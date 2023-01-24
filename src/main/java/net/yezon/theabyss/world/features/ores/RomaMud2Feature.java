
package net.yezon.theabyss.world.features.ores;

import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraft.world.level.levelgen.structure.templatesystem.BlockStateMatchTest;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.Set;
import java.util.List;

public class RomaMud2Feature extends OreFeature {
	public static RomaMud2Feature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new RomaMud2Feature();
		CONFIGURED_FEATURE = FeatureUtils.register("theabyss:roma_mud_2", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(TheabyssModBlocks.ROMA_MUD.get().defaultBlockState()), TheabyssModBlocks.ROMA_MUD_2.get().defaultBlockState())), 32));
		PLACED_FEATURE = PlacementUtils.register("theabyss:roma_mud_2", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(32), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(40), VerticalAnchor.absolute(200)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("theabyss:the_abyss")));

	public RomaMud2Feature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;
		return super.place(context);
	}
}

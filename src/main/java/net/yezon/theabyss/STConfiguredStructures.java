package net.yezon.theabyss;

import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;

public class STConfiguredStructures {
	public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_HOUSE = STStructures.RUN_DOWN_HOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_FOREST_HUT = STStructures.FOREST_HUT.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_CASTLE = STStructuresLand.CASTLE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static StructureFeature<?, ?> CONFIGURED_ABYLAGER_HUT = STStructuresLand.ABYLAGER_HUT.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);
	public static void registerConfiguredStructures() {
		Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
		Registry.register(registry, new ResourceLocation("theabyss", "configured_run_down_house"), CONFIGURED_RUN_DOWN_HOUSE);
		Registry.register(registry, new ResourceLocation("theabyss", "forest_hut"), CONFIGURED_FOREST_HUT);
		Registry.register(registry, new ResourceLocation("theabyss", "castle"), CONFIGURED_CASTLE);
		Registry.register(registry, new ResourceLocation("theabyss", "abylager_hut"), CONFIGURED_ABYLAGER_HUT);
		// FlatGenerationSettings.STRUCTURES.put(STStructures.RUN_DOWN_HOUSE.get(),
		// CONFIGURED_RUN_DOWN_HOUSE);
		 FlatGenerationSettings.STRUCTURES.put(STStructures.RUN_DOWN_HOUSE.get(), CONFIGURED_RUN_DOWN_HOUSE);
		 FlatGenerationSettings.STRUCTURES.put(STStructures.FOREST_HUT.get(), CONFIGURED_FOREST_HUT);
		 FlatGenerationSettings.STRUCTURES.put(STStructuresLand.CASTLE.get(), CONFIGURED_CASTLE);
		 FlatGenerationSettings.STRUCTURES.put(STStructuresLand.ABYLAGER_HUT.get(), CONFIGURED_ABYLAGER_HUT);
	}
}

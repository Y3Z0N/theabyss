
package net.yezon.theabyss.world.biome;

import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.List;

public class FungalForestBiome {
	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-3345409).waterColor(-11817068).waterFogColor(-13213597)
				.skyColor(-3345409).foliageColorOverride(-6180170).grassColorOverride(-15774392)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("theabyss:biome_ruma_ambience")))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("theabyss:biome_ruma_music")), 12000, 24000, true))
				.ambientParticle(new AmbientParticleSettings((SimpleParticleType) (TheabyssModParticleTypes.WAND_THUNDER_PT.get()), 0.03f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("theabyss:seagrass_fungal_forest", AquaticFeatures.SEAGRASS_SHORT, AquaticPlacements.seagrassPlacement(5)));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("theabyss:disk_sand_fungal_forest", FeatureUtils.register("theabyss:disk_sand_fungal_forest", Feature.DISK,
						new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.SAND),
								BlockPredicate.matchesBlocks(List.of(TheabyssModBlocks.TANTRA_GRASS.get(), TheabyssModBlocks.TANTRA_DIRT.get())),
								UniformInt.of(2, 6), 2)),
						List.of(CountPlacement.of(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("theabyss:disk_gravel_fungal_forest",
				FeatureUtils.register("theabyss:disk_gravel_fungal_forest", Feature.DISK,
						new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL),
								BlockPredicate.matchesBlocks(List.of(TheabyssModBlocks.TANTRA_GRASS.get(), TheabyssModBlocks.TANTRA_DIRT.get())),
								UniformInt.of(2, 5), 2)),
				List.of(CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.BAT, 15, 1, 15));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.5f).downfall(0.3f).specialEffects(effects)
				.mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}

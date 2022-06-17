
package net.yezon.theabyss.world.biome;

import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.List;

public class TheAbyssPlainsBiomeBiome {
	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-15129037).waterColor(-13421773).waterFogColor(-13421773)
				.skyColor(-15129037).foliageColorOverride(-14867914).grassColorOverride(-13355711)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("theabyss:abyss_ambience")))
				.ambientAdditionsSound(new AmbientAdditionsSettings(new SoundEvent(new ResourceLocation("theabyss:random_fx")), 0.0111D))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("theabyss:the_abyss_music")), 12000, 24000, true))
				.ambientParticle(new AmbientParticleSettings((SimpleParticleType) (TheabyssModParticleTypes.SPURS_BIOME_01.get()), 0.03f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("theabyss:disk_gravel_plains",
						FeatureUtils.register("theabyss:disk_gravel_plains", Feature.DISK,
								new DiskConfiguration(Blocks.GRAVEL.defaultBlockState(), UniformInt.of(2, 5), 2,
										List.of(TheabyssModBlocks.INFECTED_GRASS.get().defaultBlockState(),
												TheabyssModBlocks.DIRT.get().defaultBlockState()))),
						List.of(CountPlacement.of(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.BAT, 15, 1, 15));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.NONE).temperature(0.7f)
				.downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build())
				.build();
	}

	public static void init() {
	}
}

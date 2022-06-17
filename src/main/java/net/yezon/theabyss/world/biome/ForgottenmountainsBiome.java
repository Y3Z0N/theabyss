
package net.yezon.theabyss.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.ParticleTypes;

public class ForgottenmountainsBiome {
	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-4131073).waterColor(-13421721).waterFogColor(-4737097)
				.skyColor(-4131073).foliageColorOverride(-2688257).grassColorOverride(-3933953)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("theabyss:frost_world_ambience")))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("theabyss:the_abyss_music")), 12000, 24000, true))
				.ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.02f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addIcebergs(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.LIGHTNING_BOLT, 10, 1, 1));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.SNOW).biomeCategory(Biome.BiomeCategory.NONE).temperature(-1f)
				.downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build())
				.build();
	}

	public static void init() {
	}
}


package net.yezon.theabyss.world.biome;

import net.yezon.theabyss.init.TheabyssModParticleTypes;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.SimpleParticleType;

public class MudPlainsBiome {
	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-16376551).waterColor(-16301778).waterFogColor(-15588065).skyColor(-16376551).foliageColorOverride(-16301779).grassColorOverride(-13293758)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("theabyss:abyss_ambience"))).ambientAdditionsSound(new AmbientAdditionsSettings(new SoundEvent(new ResourceLocation("theabyss:random_fx")), 0.0111D))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("theabyss:the_abyss_music")), 12000, 24000, true))
				.ambientParticle(new AmbientParticleSettings((SimpleParticleType) (TheabyssModParticleTypes.SPURS_BIOME_01.get()), 0.03f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.6f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}

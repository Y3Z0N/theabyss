
package net.yezon.theabyss.world.biome;

import net.yezon.theabyss.block.SnowBlockBlock;
import net.yezon.theabyss.block.DarkStoneBlock;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.ParticleEffectAmbience;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.client.audio.BackgroundMusicSelector;

@TheAbyss.Processor.Tag
public class ForgottenmountainsBiome extends TheAbyss.Processor {
	public static Biome biome;

	public ForgottenmountainsBiome(TheAbyss instance) {
		super(instance, 593);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-4131073).setWaterColor(-13421721).setWaterFogColor(-4737097)
						.withSkyColor(-4131073).withFoliageColor(-2688257).withGrassColor(-3933953)
						.setAmbientSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("theabyss:frost_world_ambience")))
						.setMusic(new BackgroundMusicSelector((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("theabyss:the_abyss_music")), 12000, 24000, true))
						.setParticle(new ParticleEffectAmbience(ParticleTypes.ASH, 0.02f)).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(SnowBlockBlock.block.getDefaultState(),
								DarkStoneBlock.block.getDefaultState(), DarkStoneBlock.block.getDefaultState())));
				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withIcebergs(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.LIGHTNING_BOLT, 10, 1, 1));
				biome = new Biome.Builder().precipitation(Biome.RainType.SNOW).category(Biome.Category.NONE).depth(0.7f).scale(1.6f).temperature(-1f)
						.downfall(0.5f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("theabyss:forgottenmountains"));
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}

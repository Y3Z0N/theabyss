
/*
 *    Y3 was here UwU ^-^
 */
package net.yezon.theabyss.init;

import net.yezon.theabyss.world.biome.WaywardseaBiome;
import net.yezon.theabyss.world.biome.TheAbyssPlainsBiomeBiome;
import net.yezon.theabyss.world.biome.TheAbyssJungleBiome;
import net.yezon.theabyss.world.biome.TheAbyssBiomeBiome;
import net.yezon.theabyss.world.biome.SlimeForestBiomeBiome;
import net.yezon.theabyss.world.biome.RoggenForestBiome;
import net.yezon.theabyss.world.biome.RadioBiomeBiome;
import net.yezon.theabyss.world.biome.PocketBiomeBiome;
import net.yezon.theabyss.world.biome.MudPlainsBiome;
import net.yezon.theabyss.world.biome.InfectedLakeBiome;
import net.yezon.theabyss.world.biome.FungalForestBiome;
import net.yezon.theabyss.world.biome.ForgottenmountainsBiome;
import net.yezon.theabyss.world.biome.DreamBiomeBiome;
import net.yezon.theabyss.world.biome.AybssMountainBiome;
import net.yezon.theabyss.world.biome.AbyssPhantomBiomeBiome;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.biome.Biome;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheabyssModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, TheabyssMod.MODID);
	public static final RegistryObject<Biome> BLUE_FOREST = REGISTRY.register("blue_forest", () -> TheAbyssBiomeBiome.createBiome());
	public static final RegistryObject<Biome> BLUE_MOUNTAIN = REGISTRY.register("blue_mountain", () -> AybssMountainBiome.createBiome());
	public static final RegistryObject<Biome> PHANTOM_CRATE = REGISTRY.register("phantom_crate", () -> AbyssPhantomBiomeBiome.createBiome());
	public static final RegistryObject<Biome> SLIME_FOREST = REGISTRY.register("slime_forest", () -> SlimeForestBiomeBiome.createBiome());
	public static final RegistryObject<Biome> BLUE_JUNGLE = REGISTRY.register("blue_jungle", () -> TheAbyssJungleBiome.createBiome());
	public static final RegistryObject<Biome> PLAINS = REGISTRY.register("plains", () -> TheAbyssPlainsBiomeBiome.createBiome());
	public static final RegistryObject<Biome> MUD_PLAINS = REGISTRY.register("mud_plains", () -> MudPlainsBiome.createBiome());
	public static final RegistryObject<Biome> WAYWARDSEA = REGISTRY.register("waywardsea", () -> WaywardseaBiome.createBiome());
	public static final RegistryObject<Biome> FORGOTTENMOUNTAINS = REGISTRY.register("forgottenmountains",
			() -> ForgottenmountainsBiome.createBiome());
	public static final RegistryObject<Biome> FUNGAL_FOREST = REGISTRY.register("fungal_forest", () -> FungalForestBiome.createBiome());
	public static final RegistryObject<Biome> ROGGEN_FOREST = REGISTRY.register("roggen_forest", () -> RoggenForestBiome.createBiome());
	public static final RegistryObject<Biome> DREAM_BIOME = REGISTRY.register("dream_biome", () -> DreamBiomeBiome.createBiome());
	public static final RegistryObject<Biome> RADIO_BIOME = REGISTRY.register("radio_biome", () -> RadioBiomeBiome.createBiome());
	public static final RegistryObject<Biome> POCKET_BIOME = REGISTRY.register("pocket_biome", () -> PocketBiomeBiome.createBiome());
	public static final RegistryObject<Biome> INFECTED_LAKE = REGISTRY.register("infected_lake", () -> InfectedLakeBiome.createBiome());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TheAbyssBiomeBiome.init();
			AybssMountainBiome.init();
			AbyssPhantomBiomeBiome.init();
			SlimeForestBiomeBiome.init();
			TheAbyssJungleBiome.init();
			TheAbyssPlainsBiomeBiome.init();
			MudPlainsBiome.init();
			WaywardseaBiome.init();
			ForgottenmountainsBiome.init();
			FungalForestBiome.init();
			RoggenForestBiome.init();
			DreamBiomeBiome.init();
			RadioBiomeBiome.init();
			PocketBiomeBiome.init();
			InfectedLakeBiome.init();
		});
	}
}

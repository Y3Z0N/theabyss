
  
package net.yezon.theabyss.init;

import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class TheabyssModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TheabyssMod.MODID);
	public static final RegistryObject<SimpleParticleType> END_SWORD_PT = REGISTRY.register("end_sword_pt", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SPURS_BIOME_01 = REGISTRY.register("spurs_biome_01", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> UDPT = REGISTRY.register("udpt", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> WAND_THUNDER_PT = REGISTRY.register("wand_thunder_pt",
			() -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ECHOLOT_BUBBLE = REGISTRY.register("echolot_bubble", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> FIRE_FLY_PARTICLE = REGISTRY.register("fire_fly_particle",
			() -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> NODE_PARTICLE = REGISTRY.register("node_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PHANTOM_ATTACK_PARTICLE = REGISTRY.register("phantom_attack_particle",
			() -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PHANTOM_ATTACK_PARTICLE_2 = REGISTRY.register("phantom_attack_particle_2",
			() -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> KNIGHT_SWORD_PT = REGISTRY.register("knight_sword_pt",
			() -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SHINNY_CYAN = REGISTRY.register("shinny_cyan", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> RENDER_CYAN = REGISTRY.register("render_cyan", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> RENDER_LIGHT_CYAN = REGISTRY.register("render_light_cyan",
			() -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> RENDER_BRIGHT_CYAN = REGISTRY.register("render_bright_cyan",
			() -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PHANTOM_FIRE = REGISTRY.register("phantom_fire", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ELECTRICITY_ANIMATED = REGISTRY.register("electricity_animated",
			() -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PHANTOM_SPECTRUM = REGISTRY.register("phantom_spectrum",
			() -> new SimpleParticleType(true));
}

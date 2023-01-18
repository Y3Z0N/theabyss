
  
package net.yezon.theabyss.init;

import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public class TheabyssModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TheabyssMod.MODID);
	public static final RegistryObject<SoundEvent> PHANTOM_HURT = REGISTRY.register("phantom_hurt",
			() -> new SoundEvent(new ResourceLocation("theabyss", "phantom_hurt")));
	public static final RegistryObject<SoundEvent> PHANTOM_AMBIENT = REGISTRY.register("phantom_ambient",
			() -> new SoundEvent(new ResourceLocation("theabyss", "phantom_ambient")));
	public static final RegistryObject<SoundEvent> PHANTOM_ATTACK = REGISTRY.register("phantom_attack",
			() -> new SoundEvent(new ResourceLocation("theabyss", "phantom_attack")));
	public static final RegistryObject<SoundEvent> AMBIENTMUSIC = REGISTRY.register("ambientmusic",
			() -> new SoundEvent(new ResourceLocation("theabyss", "ambientmusic")));
	public static final RegistryObject<SoundEvent> ECHOLOT_AMBIENT = REGISTRY.register("echolot_ambient",
			() -> new SoundEvent(new ResourceLocation("theabyss", "echolot_ambient")));
	public static final RegistryObject<SoundEvent> AMBIENT_JUMPSCARE_EFFECT = REGISTRY.register("ambient_jumpscare_effect",
			() -> new SoundEvent(new ResourceLocation("theabyss", "ambient_jumpscare_effect")));
	public static final RegistryObject<SoundEvent> END_GAME_MUSIC_CYANIDEX = REGISTRY.register("end_game_music_cyanidex",
			() -> new SoundEvent(new ResourceLocation("theabyss", "end_game_music_cyanidex")));
	public static final RegistryObject<SoundEvent> END_GAME_MUSIC = REGISTRY.register("end_game_music",
			() -> new SoundEvent(new ResourceLocation("theabyss", "end_game_music")));
	public static final RegistryObject<SoundEvent> BIOME_RUMA_AMBIENCE = REGISTRY.register("biome_ruma_ambience",
			() -> new SoundEvent(new ResourceLocation("theabyss", "biome_ruma_ambience")));
	public static final RegistryObject<SoundEvent> BIOME_RUMA_MUSIC = REGISTRY.register("biome_ruma_music",
			() -> new SoundEvent(new ResourceLocation("theabyss", "biome_ruma_music")));
	public static final RegistryObject<SoundEvent> ABYSS_AMBIENCE = REGISTRY.register("abyss_ambience",
			() -> new SoundEvent(new ResourceLocation("theabyss", "abyss_ambience")));
	public static final RegistryObject<SoundEvent> RESONATOR_AMBIENCE = REGISTRY.register("resonator_ambience",
			() -> new SoundEvent(new ResourceLocation("theabyss", "resonator_ambience")));
	public static final RegistryObject<SoundEvent> BROKEN_RADIO = REGISTRY.register("broken_radio",
			() -> new SoundEvent(new ResourceLocation("theabyss", "broken_radio")));
	public static final RegistryObject<SoundEvent> DREAM_EVENT_1 = REGISTRY.register("dream_event_1",
			() -> new SoundEvent(new ResourceLocation("theabyss", "dream_event_1")));
	public static final RegistryObject<SoundEvent> DREAM_EVENT_1_SWEEP = REGISTRY.register("dream_event_1_sweep",
			() -> new SoundEvent(new ResourceLocation("theabyss", "dream_event_1_sweep")));
	public static final RegistryObject<SoundEvent> RAPTOR_HURT = REGISTRY.register("raptor_hurt",
			() -> new SoundEvent(new ResourceLocation("theabyss", "raptor_hurt")));
	public static final RegistryObject<SoundEvent> RAPTOR_DIE = REGISTRY.register("raptor_die",
			() -> new SoundEvent(new ResourceLocation("theabyss", "raptor_die")));
	public static final RegistryObject<SoundEvent> RAPTOR_IDLE = REGISTRY.register("raptor_idle",
			() -> new SoundEvent(new ResourceLocation("theabyss", "raptor_idle")));
	public static final RegistryObject<SoundEvent> CRYSTAL_GOLEM_IDLE = REGISTRY.register("crystal_golem_idle",
			() -> new SoundEvent(new ResourceLocation("theabyss", "crystal_golem_idle")));
	public static final RegistryObject<SoundEvent> CRYSTAL_GOLEM_HURT = REGISTRY.register("crystal_golem_hurt",
			() -> new SoundEvent(new ResourceLocation("theabyss", "crystal_golem_hurt")));
	public static final RegistryObject<SoundEvent> CRYSTAL_GOLEM_DIE = REGISTRY.register("crystal_golem_die",
			() -> new SoundEvent(new ResourceLocation("theabyss", "crystal_golem_die")));
	public static final RegistryObject<SoundEvent> LIZARD_IDLE = REGISTRY.register("lizard_idle",
			() -> new SoundEvent(new ResourceLocation("theabyss", "lizard_idle")));
	public static final RegistryObject<SoundEvent> DEER_HURT = REGISTRY.register("deer_hurt",
			() -> new SoundEvent(new ResourceLocation("theabyss", "deer_hurt")));
	public static final RegistryObject<SoundEvent> DEER_IDLE = REGISTRY.register("deer_idle",
			() -> new SoundEvent(new ResourceLocation("theabyss", "deer_idle")));
	public static final RegistryObject<SoundEvent> SPELL_OF_TELEPORT = REGISTRY.register("spell_of_teleport",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_teleport")));
	public static final RegistryObject<SoundEvent> SPELL_OF_FREEZE = REGISTRY.register("spell_of_freeze",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_freeze")));
	public static final RegistryObject<SoundEvent> SPELL_OF_JUGGER = REGISTRY.register("spell_of_jugger",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_jugger")));
	public static final RegistryObject<SoundEvent> SPELL_OF_INVISIBILITY = REGISTRY.register("spell_of_invisibility",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_invisibility")));
	public static final RegistryObject<SoundEvent> SPELL_OF_TIME = REGISTRY.register("spell_of_time",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_time")));
	public static final RegistryObject<SoundEvent> SPELL_OF_TELEKINETIC = REGISTRY.register("spell_of_telekinetic",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_telekinetic")));
	public static final RegistryObject<SoundEvent> SPELL_OF_WATER = REGISTRY.register("spell_of_water",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_water")));
	public static final RegistryObject<SoundEvent> SPELL_OF_FIRE = REGISTRY.register("spell_of_fire",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_fire")));
	public static final RegistryObject<SoundEvent> SPELL_OF_REGEN = REGISTRY.register("spell_of_regen",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_regen")));
	public static final RegistryObject<SoundEvent> SPELL_OF_GHOST = REGISTRY.register("spell_of_ghost",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_ghost")));
	public static final RegistryObject<SoundEvent> SPELL_OF_MISC = REGISTRY.register("spell_of_misc",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_misc")));
	public static final RegistryObject<SoundEvent> BIOME_MOUNTAINS = REGISTRY.register("biome_mountains",
			() -> new SoundEvent(new ResourceLocation("theabyss", "biome_mountains")));
	public static final RegistryObject<SoundEvent> DREAM_EVENT_2 = REGISTRY.register("dream_event_2",
			() -> new SoundEvent(new ResourceLocation("theabyss", "dream_event_2")));
	public static final RegistryObject<SoundEvent> SOMNIUM_INFUSER_BUBBLE = REGISTRY.register("somnium_infuser_bubble",
			() -> new SoundEvent(new ResourceLocation("theabyss", "somnium_infuser_bubble")));
	public static final RegistryObject<SoundEvent> ABYSSAUR_IDLE = REGISTRY.register("abyssaur_idle",
			() -> new SoundEvent(new ResourceLocation("theabyss", "abyssaur_idle")));
	public static final RegistryObject<SoundEvent> ABYSSAUR_DEATH = REGISTRY.register("abyssaur_death",
			() -> new SoundEvent(new ResourceLocation("theabyss", "abyssaur_death")));
	public static final RegistryObject<SoundEvent> ABYSSAUR_HURT = REGISTRY.register("abyssaur_hurt",
			() -> new SoundEvent(new ResourceLocation("theabyss", "abyssaur_hurt")));
	public static final RegistryObject<SoundEvent> ABYSSAUR_ATTACK = REGISTRY.register("abyssaur_attack",
			() -> new SoundEvent(new ResourceLocation("theabyss", "abyssaur_attack")));
	public static final RegistryObject<SoundEvent> FART = REGISTRY.register("fart", () -> new SoundEvent(new ResourceLocation("theabyss", "fart")));
	public static final RegistryObject<SoundEvent> VERSA_WHALE_IDLE = REGISTRY.register("versa_whale_idle",
			() -> new SoundEvent(new ResourceLocation("theabyss", "versa_whale_idle")));
	public static final RegistryObject<SoundEvent> CRYSTAL_BREAK = REGISTRY.register("crystal_break",
			() -> new SoundEvent(new ResourceLocation("theabyss", "crystal_break")));
	public static final RegistryObject<SoundEvent> FEAR_EVENT = REGISTRY.register("fear_event",
			() -> new SoundEvent(new ResourceLocation("theabyss", "fear_event")));
	public static final RegistryObject<SoundEvent> ZOMBIE_IDLE = REGISTRY.register("zombie_idle",
			() -> new SoundEvent(new ResourceLocation("theabyss", "zombie_idle")));
	public static final RegistryObject<SoundEvent> ZOMBIE_DEATH = REGISTRY.register("zombie_death",
			() -> new SoundEvent(new ResourceLocation("theabyss", "zombie_death")));
	public static final RegistryObject<SoundEvent> ZOMBIE_HURT = REGISTRY.register("zombie_hurt",
			() -> new SoundEvent(new ResourceLocation("theabyss", "zombie_hurt")));
	public static final RegistryObject<SoundEvent> THE_ABYSS_MUSIC = REGISTRY.register("the_abyss_music",
			() -> new SoundEvent(new ResourceLocation("theabyss", "the_abyss_music")));
	public static final RegistryObject<SoundEvent> DASH = REGISTRY.register("dash", () -> new SoundEvent(new ResourceLocation("theabyss", "dash")));
	public static final RegistryObject<SoundEvent> SPELL_OF_ELEC = REGISTRY.register("spell_of_elec",
			() -> new SoundEvent(new ResourceLocation("theabyss", "spell_of_elec")));
	public static final RegistryObject<SoundEvent> WOLF_IDLE = REGISTRY.register("wolf_idle",
			() -> new SoundEvent(new ResourceLocation("theabyss", "wolf_idle")));
	public static final RegistryObject<SoundEvent> WOLF_HURT = REGISTRY.register("wolf_hurt",
			() -> new SoundEvent(new ResourceLocation("theabyss", "wolf_hurt")));
	public static final RegistryObject<SoundEvent> WOLF_DIE = REGISTRY.register("wolf_die",
			() -> new SoundEvent(new ResourceLocation("theabyss", "wolf_die")));
	public static final RegistryObject<SoundEvent> BLUE_FOREST_AMBIENCE = REGISTRY.register("blue_forest_ambience",
			() -> new SoundEvent(new ResourceLocation("theabyss", "blue_forest_ambience")));
	public static final RegistryObject<SoundEvent> BLUE_MOUNTAINS_AMBIENCE = REGISTRY.register("blue_mountains_ambience",
			() -> new SoundEvent(new ResourceLocation("theabyss", "blue_mountains_ambience")));
	public static final RegistryObject<SoundEvent> BLUE_JUNGLE_AMBIENCE = REGISTRY.register("blue_jungle_ambience",
			() -> new SoundEvent(new ResourceLocation("theabyss", "blue_jungle_ambience")));
	public static final RegistryObject<SoundEvent> FROST_WORLD_AMBIENCE = REGISTRY.register("frost_world_ambience",
			() -> new SoundEvent(new ResourceLocation("theabyss", "frost_world_ambience")));
	public static final RegistryObject<SoundEvent> PHANTOM_CRATE_AMBIENCE = REGISTRY.register("phantom_crate_ambience",
			() -> new SoundEvent(new ResourceLocation("theabyss", "phantom_crate_ambience")));
	public static final RegistryObject<SoundEvent> SLIME_FOREST_AMBIENCE = REGISTRY.register("slime_forest_ambience",
			() -> new SoundEvent(new ResourceLocation("theabyss", "slime_forest_ambience")));
	public static final RegistryObject<SoundEvent> RANDOM_FX = REGISTRY.register("random_fx",
			() -> new SoundEvent(new ResourceLocation("theabyss", "random_fx")));
	public static final RegistryObject<SoundEvent> INFECTED_WARDEN_IDLE = REGISTRY.register("infected_warden_idle",
			() -> new SoundEvent(new ResourceLocation("theabyss", "infected_warden_idle")));
	public static final RegistryObject<SoundEvent> SEEKER_AMBIENT = REGISTRY.register("seeker_ambient",
			() -> new SoundEvent(new ResourceLocation("theabyss", "seeker_ambient")));
	public static final RegistryObject<SoundEvent> NIGHTBLADE_ATTACK = REGISTRY.register("nightblade_attack",
			() -> new SoundEvent(new ResourceLocation("theabyss", "nightblade_attack")));
	public static final RegistryObject<SoundEvent> WOOD_PLACE = REGISTRY.register("wood_place",
			() -> new SoundEvent(new ResourceLocation("theabyss", "wood_place")));
	public static final RegistryObject<SoundEvent> WOOD_STEP = REGISTRY.register("wood_step",
			() -> new SoundEvent(new ResourceLocation("theabyss", "wood_step")));
}

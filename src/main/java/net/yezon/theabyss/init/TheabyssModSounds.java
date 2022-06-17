
/*
 *    Y3 was here UwU ^-^
 */
package net.yezon.theabyss.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheabyssModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("theabyss", "phantom_hurt"), new SoundEvent(new ResourceLocation("theabyss", "phantom_hurt")));
		REGISTRY.put(new ResourceLocation("theabyss", "phantom_ambient"), new SoundEvent(new ResourceLocation("theabyss", "phantom_ambient")));
		REGISTRY.put(new ResourceLocation("theabyss", "phantom_attack"), new SoundEvent(new ResourceLocation("theabyss", "phantom_attack")));
		REGISTRY.put(new ResourceLocation("theabyss", "ambientmusic"), new SoundEvent(new ResourceLocation("theabyss", "ambientmusic")));
		REGISTRY.put(new ResourceLocation("theabyss", "echolot_ambient"), new SoundEvent(new ResourceLocation("theabyss", "echolot_ambient")));
		REGISTRY.put(new ResourceLocation("theabyss", "ambient_jumpscare_effect"),
				new SoundEvent(new ResourceLocation("theabyss", "ambient_jumpscare_effect")));
		REGISTRY.put(new ResourceLocation("theabyss", "end_game_music_cyanidex"),
				new SoundEvent(new ResourceLocation("theabyss", "end_game_music_cyanidex")));
		REGISTRY.put(new ResourceLocation("theabyss", "end_game_music"), new SoundEvent(new ResourceLocation("theabyss", "end_game_music")));
		REGISTRY.put(new ResourceLocation("theabyss", "biome_ruma_ambience"),
				new SoundEvent(new ResourceLocation("theabyss", "biome_ruma_ambience")));
		REGISTRY.put(new ResourceLocation("theabyss", "biome_ruma_music"), new SoundEvent(new ResourceLocation("theabyss", "biome_ruma_music")));
		REGISTRY.put(new ResourceLocation("theabyss", "abyss_ambience"), new SoundEvent(new ResourceLocation("theabyss", "abyss_ambience")));
		REGISTRY.put(new ResourceLocation("theabyss", "resonator_ambience"), new SoundEvent(new ResourceLocation("theabyss", "resonator_ambience")));
		REGISTRY.put(new ResourceLocation("theabyss", "broken_radio"), new SoundEvent(new ResourceLocation("theabyss", "broken_radio")));
		REGISTRY.put(new ResourceLocation("theabyss", "dream_event_1"), new SoundEvent(new ResourceLocation("theabyss", "dream_event_1")));
		REGISTRY.put(new ResourceLocation("theabyss", "dream_event_1_sweep"),
				new SoundEvent(new ResourceLocation("theabyss", "dream_event_1_sweep")));
		REGISTRY.put(new ResourceLocation("theabyss", "raptor_hurt"), new SoundEvent(new ResourceLocation("theabyss", "raptor_hurt")));
		REGISTRY.put(new ResourceLocation("theabyss", "raptor_die"), new SoundEvent(new ResourceLocation("theabyss", "raptor_die")));
		REGISTRY.put(new ResourceLocation("theabyss", "raptor_idle"), new SoundEvent(new ResourceLocation("theabyss", "raptor_idle")));
		REGISTRY.put(new ResourceLocation("theabyss", "crystal_golem_idle"), new SoundEvent(new ResourceLocation("theabyss", "crystal_golem_idle")));
		REGISTRY.put(new ResourceLocation("theabyss", "crystal_golem_hurt"), new SoundEvent(new ResourceLocation("theabyss", "crystal_golem_hurt")));
		REGISTRY.put(new ResourceLocation("theabyss", "crystal_golem_die"), new SoundEvent(new ResourceLocation("theabyss", "crystal_golem_die")));
		REGISTRY.put(new ResourceLocation("theabyss", "lizard_idle"), new SoundEvent(new ResourceLocation("theabyss", "lizard_idle")));
		REGISTRY.put(new ResourceLocation("theabyss", "deer_hurt"), new SoundEvent(new ResourceLocation("theabyss", "deer_hurt")));
		REGISTRY.put(new ResourceLocation("theabyss", "deer_idle"), new SoundEvent(new ResourceLocation("theabyss", "deer_idle")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_teleport"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_teleport")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_freeze"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_freeze")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_jugger"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_jugger")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_invisibility"),
				new SoundEvent(new ResourceLocation("theabyss", "spell_of_invisibility")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_time"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_time")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_telekinetic"),
				new SoundEvent(new ResourceLocation("theabyss", "spell_of_telekinetic")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_water"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_water")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_fire"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_fire")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_regen"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_regen")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_ghost"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_ghost")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_misc"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_misc")));
		REGISTRY.put(new ResourceLocation("theabyss", "biome_mountains"), new SoundEvent(new ResourceLocation("theabyss", "biome_mountains")));
		REGISTRY.put(new ResourceLocation("theabyss", "dream_event_2"), new SoundEvent(new ResourceLocation("theabyss", "dream_event_2")));
		REGISTRY.put(new ResourceLocation("theabyss", "somnium_infuser_bubble"),
				new SoundEvent(new ResourceLocation("theabyss", "somnium_infuser_bubble")));
		REGISTRY.put(new ResourceLocation("theabyss", "abyssaur_idle"), new SoundEvent(new ResourceLocation("theabyss", "abyssaur_idle")));
		REGISTRY.put(new ResourceLocation("theabyss", "abyssaur_death"), new SoundEvent(new ResourceLocation("theabyss", "abyssaur_death")));
		REGISTRY.put(new ResourceLocation("theabyss", "abyssaur_hurt"), new SoundEvent(new ResourceLocation("theabyss", "abyssaur_hurt")));
		REGISTRY.put(new ResourceLocation("theabyss", "abyssaur_attack"), new SoundEvent(new ResourceLocation("theabyss", "abyssaur_attack")));
		REGISTRY.put(new ResourceLocation("theabyss", "fart"), new SoundEvent(new ResourceLocation("theabyss", "fart")));
		REGISTRY.put(new ResourceLocation("theabyss", "versa_whale_idle"), new SoundEvent(new ResourceLocation("theabyss", "versa_whale_idle")));
		REGISTRY.put(new ResourceLocation("theabyss", "crystal_break"), new SoundEvent(new ResourceLocation("theabyss", "crystal_break")));
		REGISTRY.put(new ResourceLocation("theabyss", "fear_event"), new SoundEvent(new ResourceLocation("theabyss", "fear_event")));
		REGISTRY.put(new ResourceLocation("theabyss", "zombie_idle"), new SoundEvent(new ResourceLocation("theabyss", "zombie_idle")));
		REGISTRY.put(new ResourceLocation("theabyss", "zombie_death"), new SoundEvent(new ResourceLocation("theabyss", "zombie_death")));
		REGISTRY.put(new ResourceLocation("theabyss", "zombie_hurt"), new SoundEvent(new ResourceLocation("theabyss", "zombie_hurt")));
		REGISTRY.put(new ResourceLocation("theabyss", "the_abyss_music"), new SoundEvent(new ResourceLocation("theabyss", "the_abyss_music")));
		REGISTRY.put(new ResourceLocation("theabyss", "dash"), new SoundEvent(new ResourceLocation("theabyss", "dash")));
		REGISTRY.put(new ResourceLocation("theabyss", "spell_of_elec"), new SoundEvent(new ResourceLocation("theabyss", "spell_of_elec")));
		REGISTRY.put(new ResourceLocation("theabyss", "wolf_idle"), new SoundEvent(new ResourceLocation("theabyss", "wolf_idle")));
		REGISTRY.put(new ResourceLocation("theabyss", "wolf_hurt"), new SoundEvent(new ResourceLocation("theabyss", "wolf_hurt")));
		REGISTRY.put(new ResourceLocation("theabyss", "wolf_die"), new SoundEvent(new ResourceLocation("theabyss", "wolf_die")));
		REGISTRY.put(new ResourceLocation("theabyss", "blue_forest_ambience"),
				new SoundEvent(new ResourceLocation("theabyss", "blue_forest_ambience")));
		REGISTRY.put(new ResourceLocation("theabyss", "blue_mountains_ambience"),
				new SoundEvent(new ResourceLocation("theabyss", "blue_mountains_ambience")));
		REGISTRY.put(new ResourceLocation("theabyss", "blue_jungle_ambience"),
				new SoundEvent(new ResourceLocation("theabyss", "blue_jungle_ambience")));
		REGISTRY.put(new ResourceLocation("theabyss", "frost_world_ambience"),
				new SoundEvent(new ResourceLocation("theabyss", "frost_world_ambience")));
		REGISTRY.put(new ResourceLocation("theabyss", "phantom_crate_ambience"),
				new SoundEvent(new ResourceLocation("theabyss", "phantom_crate_ambience")));
		REGISTRY.put(new ResourceLocation("theabyss", "slime_forest_ambience"),
				new SoundEvent(new ResourceLocation("theabyss", "slime_forest_ambience")));
		REGISTRY.put(new ResourceLocation("theabyss", "random_fx"), new SoundEvent(new ResourceLocation("theabyss", "random_fx")));
		REGISTRY.put(new ResourceLocation("theabyss", "infected_warden_idle"),
				new SoundEvent(new ResourceLocation("theabyss", "infected_warden_idle")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}

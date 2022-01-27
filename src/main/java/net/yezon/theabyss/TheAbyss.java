package net.yezon.theabyss;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Block;
import net.yezon.theabyss.server.Capabilities;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class TheAbyss {
	public final List<Processor> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
	public final List<Supplier<Enchantment>> enchantments = new ArrayList<>();
	public static Map<ResourceLocation, net.minecraft.util.SoundEvent> sounds = new HashMap<>();

	public TheAbyss() {
		sounds.put(new ResourceLocation("theabyss", "phantom_hurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "phantom_hurt")));
		sounds.put(new ResourceLocation("theabyss", "phantom_ambient"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "phantom_ambient")));
		sounds.put(new ResourceLocation("theabyss", "phantom_attack"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "phantom_attack")));
		sounds.put(new ResourceLocation("theabyss", "ambientmusic"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "ambientmusic")));
		sounds.put(new ResourceLocation("theabyss", "echolot_ambient"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "echolot_ambient")));
		sounds.put(new ResourceLocation("theabyss", "ambient_jumpscare_effect"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "ambient_jumpscare_effect")));
		sounds.put(new ResourceLocation("theabyss", "end_game_music_cyanidex"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "end_game_music_cyanidex")));
		sounds.put(new ResourceLocation("theabyss", "end_game_music"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "end_game_music")));
		sounds.put(new ResourceLocation("theabyss", "biome_ruma_ambience"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "biome_ruma_ambience")));
		sounds.put(new ResourceLocation("theabyss", "biome_ruma_music"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "biome_ruma_music")));
		sounds.put(new ResourceLocation("theabyss", "abyss_ambience"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "abyss_ambience")));
		sounds.put(new ResourceLocation("theabyss", "resonator_ambience"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "resonator_ambience")));
		sounds.put(new ResourceLocation("theabyss", "broken_radio"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "broken_radio")));
		sounds.put(new ResourceLocation("theabyss", "dream_event_1"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "dream_event_1")));
		sounds.put(new ResourceLocation("theabyss", "dream_event_1_sweep"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "dream_event_1_sweep")));
		sounds.put(new ResourceLocation("theabyss", "raptor_hurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "raptor_hurt")));
		sounds.put(new ResourceLocation("theabyss", "raptor_die"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "raptor_die")));
		sounds.put(new ResourceLocation("theabyss", "raptor_idle"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "raptor_idle")));
		sounds.put(new ResourceLocation("theabyss", "crystal_golem_idle"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "crystal_golem_idle")));
		sounds.put(new ResourceLocation("theabyss", "crystal_golem_hurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "crystal_golem_hurt")));
		sounds.put(new ResourceLocation("theabyss", "crystal_golem_die"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "crystal_golem_die")));
		sounds.put(new ResourceLocation("theabyss", "lizard_idle"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "lizard_idle")));
		sounds.put(new ResourceLocation("theabyss", "deer_hurt"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "deer_hurt")));
		sounds.put(new ResourceLocation("theabyss", "deer_idle"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "deer_idle")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_teleport"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_teleport")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_freeze"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_freeze")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_jugger"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_jugger")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_invisibility"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_invisibility")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_time"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_time")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_telekinetic"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_telekinetic")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_water"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_water")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_fire"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_fire")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_regen"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_regen")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_ghost"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_ghost")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_misc"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_misc")));
		sounds.put(new ResourceLocation("theabyss", "biome_mountains"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "biome_mountains")));
		sounds.put(new ResourceLocation("theabyss", "dream_event_2"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "dream_event_2")));
		sounds.put(new ResourceLocation("theabyss", "somnium_infuser_bubble"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "somnium_infuser_bubble")));
		sounds.put(new ResourceLocation("theabyss", "abyssaur_idle"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "abyssaur_idle")));
		sounds.put(new ResourceLocation("theabyss", "abyssaur_death"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "abyssaur_death")));
		sounds.put(new ResourceLocation("theabyss", "abyssaur_hurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "abyssaur_hurt")));
		sounds.put(new ResourceLocation("theabyss", "abyssaur_attack"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "abyssaur_attack")));
		sounds.put(new ResourceLocation("theabyss", "fart"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "fart")));
		sounds.put(new ResourceLocation("theabyss", "versa_whale_idle"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "versa_whale_idle")));
		sounds.put(new ResourceLocation("theabyss", "crystal_break"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "crystal_break")));
		sounds.put(new ResourceLocation("theabyss", "fear_event"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "fear_event")));
		sounds.put(new ResourceLocation("theabyss", "zombie_idle"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "zombie_idle")));
		sounds.put(new ResourceLocation("theabyss", "zombie_death"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "zombie_death")));
		sounds.put(new ResourceLocation("theabyss", "zombie_hurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "zombie_hurt")));
		sounds.put(new ResourceLocation("theabyss", "the_abyss_music"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "the_abyss_music")));
		sounds.put(new ResourceLocation("theabyss", "dash"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "dash")));
		sounds.put(new ResourceLocation("theabyss", "spell_of_elec"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "spell_of_elec")));
		sounds.put(new ResourceLocation("theabyss", "wolf_idle"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "wolf_idle")));
		sounds.put(new ResourceLocation("theabyss", "wolf_hurt"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "wolf_hurt")));
		sounds.put(new ResourceLocation("theabyss", "wolf_die"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "wolf_die")));
		sounds.put(new ResourceLocation("theabyss", "blue_forest_ambience"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "blue_forest_ambience")));
		sounds.put(new ResourceLocation("theabyss", "blue_mountains_ambience"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "blue_mountains_ambience")));
		sounds.put(new ResourceLocation("theabyss", "blue_jungle_ambience"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "blue_jungle_ambience")));
		sounds.put(new ResourceLocation("theabyss", "frost_world_ambience"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "frost_world_ambience")));
		sounds.put(new ResourceLocation("theabyss", "phantom_crate_ambience"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "phantom_crate_ambience")));
		sounds.put(new ResourceLocation("theabyss", "slime_forest_ambience"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "slime_forest_ambience")));
		sounds.put(new ResourceLocation("theabyss", "random_fx"), new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "random_fx")));
		sounds.put(new ResourceLocation("theabyss", "infected_warden_idle"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("theabyss", "infected_warden_idle")));
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("theabyss").getFile().getScanResult();
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(Processor.Tag.class.getName())) {
					Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
					if (clazz.getSuperclass() == TheAbyss.Processor.class)
						elements.add((TheAbyss.Processor) clazz.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(elements);
		elements.forEach(TheAbyss.Processor::initElements);
		MinecraftForge.EVENT_BUS.register(new Capabilities(this));
	}

	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		for (Map.Entry<ResourceLocation, net.minecraft.util.SoundEvent> sound : sounds.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}

	private int messageID = 0;

	public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		TheabyssMod.PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	public List<Processor> getElements() {
		return elements;
	}

	public List<Supplier<Block>> getBlocks() {
		return blocks;
	}

	public List<Supplier<Item>> getItems() {
		return items;
	}

	public List<Supplier<EntityType<?>>> getEntities() {
		return entities;
	}

	public List<Supplier<Enchantment>> getEnchantments() {
		return enchantments;
	}

	public static class Processor implements Comparable<Processor> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}

		protected final TheAbyss elements;
		protected final int sortid;

		public Processor(TheAbyss elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLCommonSetupEvent event) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
		}

		@Override
		public int compareTo(Processor other) {
			return this.sortid - other.sortid;
		}
	}
}

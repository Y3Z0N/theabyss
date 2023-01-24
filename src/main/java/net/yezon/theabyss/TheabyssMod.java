
package net.yezon.theabyss;

import software.bernie.geckolib3.GeckoLib;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModSounds;
import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.init.TheabyssModMobEffects;
import net.yezon.theabyss.init.TheabyssModMenus;
import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.init.TheabyssModFluids;
import net.yezon.theabyss.init.TheabyssModFluidTypes;
import net.yezon.theabyss.init.TheabyssModFeatures;
import net.yezon.theabyss.init.TheabyssModEntities;
import net.yezon.theabyss.init.TheabyssModBlocks;
import net.yezon.theabyss.init.TheabyssModBlockEntities;
import net.yezon.theabyss.init.TheabyssModBiomes;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("theabyss")
public class TheabyssMod {
	public static final Logger LOGGER = LogManager.getLogger(TheabyssMod.class);
	public static final String MODID = "theabyss";

	public TheabyssMod() {
		MinecraftForge.EVENT_BUS.register(this);
		TheabyssModTabs.load();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		TheabyssModSounds.REGISTRY.register(bus);
		TheabyssModBlocks.REGISTRY.register(bus);
		TheabyssModItems.REGISTRY.register(bus);
		TheabyssModEntities.REGISTRY.register(bus);
		TheabyssModBlockEntities.REGISTRY.register(bus);
		TheabyssModFeatures.REGISTRY.register(bus);
		TheabyssModFluids.REGISTRY.register(bus);
		TheabyssModFluidTypes.REGISTRY.register(bus);

		TheabyssModMobEffects.REGISTRY.register(bus);

		TheabyssModParticleTypes.REGISTRY.register(bus);
		TheabyssModMenus.REGISTRY.register(bus);
		TheabyssModBiomes.REGISTRY.register(bus);
		GeckoLib.initialize();
	}

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new AbstractMap.SimpleEntry(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}

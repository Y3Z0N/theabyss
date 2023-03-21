package net.yezon.theabyss;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.yezon.theabyss.client.gui.ArcaneScreen;
import net.yezon.theabyss.client.gui.InfuserScreen;
import net.yezon.theabyss.client.gui.MortarScreen;
import net.yezon.theabyss.init.*;
import net.yezon.theabyss.recipes.AbyssRecipeType;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.recipes.RecipeDisplayData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod("theabyss")
public class TheabyssMod {
    public static final Logger LOGGER = LogManager.getLogger(TheabyssMod.class);
    public static final String MODID = "theabyss";
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static final List<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ArrayList<>();
    private static int messageID = 0;

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

        bus.addListener(this::clientSetup);
        AbyssRecipeType.registerBus(bus);
        GeckoLib.initialize();
    }

    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
                                             BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MODID, path);
    }

    private void clientSetup(FMLClientSetupEvent t) {
        AllRecipeTypes.MORTAR_AND_PESTLE.getDisplayData().setRecipeViewArea(RecipeDisplayData.RecipeViewHolder.of(MortarScreen.class, 151, 78));
        AllRecipeTypes.ARCANE_CRAFTING.getDisplayData().setRecipeViewArea(RecipeDisplayData.RecipeViewHolder.of(ArcaneScreen.class, 150, 87));
        AllRecipeTypes.SOMNIUM_INFUSING.getDisplayData().setRecipeViewArea(RecipeDisplayData.RecipeViewHolder.of(InfuserScreen.class, 150, 64));
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

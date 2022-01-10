package net.yezon.theabyss;

import com.mojang.serialization.Codec;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

/**
import net.mrscauthd.boss_tools.itemgroup.SpaceTheabyssSpawnEggsItemGroup;
import net.mrscauthd.boss_tools.entity.AlienEntity;
*/

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.CreatureEntity;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@TheAbyss.Processor.Tag
public class MobInnet extends TheAbyss.Processor {
    /**
     * Do not remove this constructor
     */
    public MobInnet(TheAbyss instance) {
        super(instance, 901);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // RenderingRegistry.registerEntityRenderingHandler(STEntitys.ROCKET.get(),
        // ((IRenderFactory) RocketRenderer::new));
        // RenderingRegistry.registerEntityRenderingHandler(ALIEN.get(),
        // ((IRenderFactory) AlienRenderer::new));
    }

    @Override
    public void initElements() {
       // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        //bus.addGenericListener(Structure.class, this::onRegisterStructures);
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
      //  forgeBus.addListener(EventPriority.HIGH, this::biomeModificationa);

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        STStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        STStructuresLand.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        modEventBus.addListener(this::setup2);
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
    }
    public void setup2(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            STStructures.setupStructures();
            STStructuresLand.setupStructures();
            STConfiguredStructures.registerConfiguredStructures();
        });
    }

    public void biomeModification(final BiomeLoadingEvent event) {
        RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (event.getName().equals(new ResourceLocation("theabyss:blue_jungle"))) {
            event.getGeneration().getStructures().add(() -> STConfiguredStructures.CONFIGURED_RUN_DOWN_HOUSE);
        }
        RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (event.getName().equals(new ResourceLocation("minecraft:plains"))) {
            event.getGeneration().getStructures().add(() -> STConfiguredStructures.CONFIGURED_FOREST_HUT);
        }
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (event.getName().equals(new ResourceLocation("minecraft:forest"))) {
            event.getGeneration().getStructures().add(() -> STConfiguredStructures.CONFIGURED_FOREST_HUT);
        }
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (event.getName().equals(new ResourceLocation("theabyss:plains"))) {
            event.getGeneration().getStructures().add(() -> STConfiguredStructures.CONFIGURED_CASTLE);
        }
                RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        if (event.getName().equals(new ResourceLocation("theabyss:blue_forest"))) {
            event.getGeneration().getStructures().add(() -> STConfiguredStructures.CONFIGURED_ABYLAGER_HUT);
        }
       // event.getGeneration().getStructures().add(() -> STConfiguredStructures.CONFIGURED_RUN_DOWN_HOUSE);
    }
    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();
            try {
                if (GETCODEC_METHOD == null)
                    GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR_CODEC.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkProvider().generator));
                if (cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            } catch (Exception e) {
                // StructureTutorialMain.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }
            if(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.getDimensionType().equals(World.OVERWORLD)){
                return;
            }
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
            tempMap.putIfAbsent(STStructures.RUN_DOWN_HOUSE.get(), DimensionStructuresSettings.field_236191_b_.get(STStructures.RUN_DOWN_HOUSE.get()));
            //  serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_() = tempMap;
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;


            tempMap.putIfAbsent(STStructures.FOREST_HUT.get(), DimensionStructuresSettings.field_236191_b_.get(STStructures.FOREST_HUT.get()));
            //  serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_() = tempMap;
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;

            tempMap.putIfAbsent(STStructuresLand.CASTLE.get(), DimensionStructuresSettings.field_236191_b_.get(STStructuresLand.CASTLE.get()));
            //  serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_() = tempMap;
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;

            tempMap.putIfAbsent(STStructuresLand.ABYLAGER_HUT.get(), DimensionStructuresSettings.field_236191_b_.get(STStructuresLand.ABYLAGER_HUT.get()));
            //  serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_() = tempMap;
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
            
        }
    }


    @Override
    public void init(FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
        });
    }

    @Override
    public void serverLoad(FMLServerStartingEvent event) {
    }
}
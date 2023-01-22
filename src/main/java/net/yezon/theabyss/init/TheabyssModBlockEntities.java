package net.yezon.theabyss.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.block.entity.*;

public class TheabyssModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
            TheabyssMod.MODID);

    private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
                                                               BlockEntityType.BlockEntitySupplier<?> supplier) {
        return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }    public static final RegistryObject<BlockEntityType<?>> SOMNIUM_EXTRACTOR = register("somnium_extractor", TheabyssModBlocks.SOMNIUM_EXTRACTOR,
            SomniumExtractorBlockEntity::new);
    //public static final RegistryObject<BlockEntityType<?>> ARCANE_WORKBENCH = register("arcane_workbench", TheabyssModBlocks.ARCANE_WORKBENCH,
    //		ArcaneWorkbenchBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> RESEARCH_TABLE = register("research_table", TheabyssModBlocks.RESEARCH_TABLE,
            ResearchTableBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> CRYSTAL_CUTTER = register("crystal_cutter", TheabyssModBlocks.CRYSTAL_CUTTER,
            CrystalCutterBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> SOMNIUM_INFUSER = register("somnium_infuser", TheabyssModBlocks.SOMNIUM_INFUSER,
            SomniumInfuserBlockEntity::new);
    public static final RegistryObject<BlockEntityType<?>> MORTAR_AND_PESTLE = register("mortar_and_pestle", TheabyssModBlocks.MORTAR_AND_PESTLE,
            MortarAndPestleBlockEntity::new);


}

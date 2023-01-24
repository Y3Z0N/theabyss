
  
package net.yezon.theabyss.init;

import net.yezon.theabyss.block.entity.SomniumInfuserBlockEntity;
import net.yezon.theabyss.block.entity.SomniumExtractorBlockEntity;
import net.yezon.theabyss.block.entity.ResearchTableBlockEntity;
import net.yezon.theabyss.block.entity.MortarAndPestleBlockEntity;
import net.yezon.theabyss.block.entity.CrystalCutterBlockEntity;
import net.yezon.theabyss.block.entity.ArcaneWorkbenchBlockEntity;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class TheabyssModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
			TheabyssMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> SOMNIUM_EXTRACTOR = register("somnium_extractor", TheabyssModBlocks.SOMNIUM_EXTRACTOR,
			SomniumExtractorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ARCANE_WORKBENCH = register("arcane_workbench", TheabyssModBlocks.ARCANE_WORKBENCH,
			ArcaneWorkbenchBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RESEARCH_TABLE = register("research_table", TheabyssModBlocks.RESEARCH_TABLE,
			ResearchTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CRYSTAL_CUTTER = register("crystal_cutter", TheabyssModBlocks.CRYSTAL_CUTTER,
			CrystalCutterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SOMNIUM_INFUSER = register("somnium_infuser", TheabyssModBlocks.SOMNIUM_INFUSER,
			SomniumInfuserBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MORTAR_AND_PESTLE = register("mortar_and_pestle", TheabyssModBlocks.MORTAR_AND_PESTLE,
			MortarAndPestleBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}

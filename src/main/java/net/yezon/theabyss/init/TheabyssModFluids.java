
  
package net.yezon.theabyss.init;

import net.yezon.theabyss.fluid.ArenoFluid;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class TheabyssModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, TheabyssMod.MODID);
	public static final RegistryObject<FlowingFluid> ARENO = REGISTRY.register("areno", () -> new ArenoFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_ARENO = REGISTRY.register("flowing_areno", () -> new ArenoFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(ARENO.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ARENO.get(), RenderType.translucent());
		}
	}
}



package net.yezon.theabyss.init;

import net.yezon.theabyss.fluid.types.ArenoFluidType;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

public class TheabyssModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TheabyssMod.MODID);
	public static final RegistryObject<FluidType> ARENO_TYPE = REGISTRY.register("areno", () -> new ArenoFluidType());
}


package net.yezon.theabyss.fluid;

import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.init.TheabyssModFluids;
import net.yezon.theabyss.init.TheabyssModFluidTypes;
import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

public abstract class ArenoFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> TheabyssModFluidTypes.ARENO_TYPE.get(),
			() -> TheabyssModFluids.ARENO.get(), () -> TheabyssModFluids.FLOWING_ARENO.get()).explosionResistance(100f)
			.bucket(() -> TheabyssModItems.ARENO_BUCKET.get()).block(() -> (LiquidBlock) TheabyssModBlocks.ARENO.get());

	private ArenoFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (TheabyssModParticleTypes.RENDER_CYAN.get());
	}

	public static class Source extends ArenoFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends ArenoFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}

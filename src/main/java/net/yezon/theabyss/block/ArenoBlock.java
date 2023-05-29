
package net.yezon.theabyss.block;

import org.checkerframework.checker.units.qual.s;

import net.yezon.theabyss.eventhandlers.ArenoDamageHandlerEventHandler;
import net.yezon.theabyss.init.TheabyssModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class ArenoBlock extends LiquidBlock {
	public ArenoBlock() {
		super(() -> TheabyssModFluids.ARENO.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 15).noCollission().noLootTable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		ArenoDamageHandlerEventHandler.execute(entity);
	}
}

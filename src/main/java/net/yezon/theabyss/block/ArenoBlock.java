
package net.yezon.theabyss.block;

import org.checkerframework.checker.units.qual.s;

import net.yezon.theabyss.init.TheabyssModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

public class ArenoBlock extends LiquidBlock {
	public ArenoBlock() {
		super(() -> TheabyssModFluids.ARENO.get(), BlockBehaviour.Properties.of(Material.LAVA).strength(100f).hasPostProcess((bs, br, bp) -> true)
				.emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 15).noCollission().noLootTable());
	}
}

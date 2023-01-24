
package net.yezon.theabyss.block;

import org.checkerframework.checker.units.qual.s;

import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffects;

import java.util.List;
import java.util.Collections;

public class IcoraFlowerBlock extends FlowerBlock {
	public IcoraFlowerBlock() {
		super(MobEffects.SATURATION, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).instabreak().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 1).noCollission());
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(TheabyssModItems.ICORA_NUGGET.get()));
	}
}

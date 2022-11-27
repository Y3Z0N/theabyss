
package net.yezon.theabyss.block;

import net.yezon.theabyss.events.ThunderFlowerEffectEvent;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Collections;

public class ThunderFlowerBlock extends FlowerBlock {
	public ThunderFlowerBlock() {
		super(MobEffects.SATURATION, 0,
				BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).instabreak().lightLevel(s -> 5).noCollission());
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(TheabyssModItems.THUNDER_DUST.get()));
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		ThunderFlowerEffectEvent.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}

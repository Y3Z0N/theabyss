
package net.yezon.theabyss.block;

import net.yezon.theabyss.itemgroup.TheAbyssItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@TheAbyss.Processor.Tag
public class BlackVoidBlock extends TheAbyss.Processor {
	@ObjectHolder("theabyss:black_void")
	public static final Block block = null;

	public BlackVoidBlock(TheAbyss instance) {
		super(instance, 389);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(TheAbyssItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0));
			setRegistryName("black_void");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
package net.yezon.theabyss.events;

import net.yezon.theabyss.item.AutoSmeltPickAxeItem;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import java.util.Map;

public class AutoSmeltPickAxeBlockDestroyedWithToolEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		boolean removeBlock = false;
		if (AutoSmeltPickAxeItem.block.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))) == true) {
			if (!(((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
					new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))), ((World) world))
					.isPresent())
							? ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											(World) world)
									.get().getRecipeOutput().copy()
							: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				removeBlock = (true);
			} else {
				removeBlock = (false);
			}
			if (removeBlock == true) {
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			} else {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
							new BlockPos((int) x, (int) y, (int) z));
					world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
				}
			}
		}
	}
}

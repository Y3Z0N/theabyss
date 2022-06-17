
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.JungleMelonEffectEvent;
import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class LumusFruitFoodItem extends Item {
	public LumusFruitFoodItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).stacksTo(8).rarity(Rarity.RARE)
				.food((new FoodProperties.Builder()).nutrition(6).saturationMod(1f).alwaysEat()

						.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		JungleMelonEffectEvent.execute(entity);
		return retval;
	}
}

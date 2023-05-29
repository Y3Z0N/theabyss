
package net.yezon.theabyss.item;

import net.yezon.theabyss.eventhandlers.JungleMelonEffectEventHandler;
import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class JungleMelonItemItem extends Item {
	public JungleMelonItemItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).stacksTo(8).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(6).saturationMod(1f).alwaysEat()

				.build()));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		JungleMelonEffectEventHandler.execute(entity);
		return retval;
	}
}

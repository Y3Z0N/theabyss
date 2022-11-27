
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import java.util.List;

public class RingOfEnderChestItem extends Item {
	public static final Component CONTAINER_TITLE;

	public RingOfEnderChestItem() {
		super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).durability(250).rarity(Rarity.UNCOMMON));
	}

	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		PlayerEnderChestContainer enderChest = player.getEnderChestInventory();
		if (enderChest != null) {
			if (!world.isClientSide) {
				player.openMenu(new SimpleMenuProvider((p_220114_1_, p_220114_2_, p_220114_3_) -> {
					return ChestMenu.threeRows(p_220114_1_, p_220114_2_, enderChest);
				}, CONTAINER_TITLE));
			}
		}
		return new InteractionResultHolder<ItemStack>(InteractionResult.PASS, player.getItemInHand(hand));
	}

	    static {
        CONTAINER_TITLE = Component.translatable("item.theabyss.ring_of_ender_chest");
    }

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\uEF02 0.0 \uEF04 100.0 \uEF03 Right Click"));
		list.add(Component.translatable("tooltip.theabyss.ring_of_enderchest"));
		list.add(Component.literal(""));
		list.add(Component.translatable("tooltip.theabyss.ring_crafting"));
		list.add(Component.translatable("tooltip.theabyss.ring_consume"));
		list.add(Component.literal(""));
		list.add(Component.translatable("tooltip.theabyss.ring_upgrade"));
	}


}



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
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;


import javax.annotation.Nullable;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

import java.util.List;

public class RingOfEnderChestItem extends Item 
{

public static final TranslatableComponent CONTAINER_TITLE = new TranslatableComponent("item.theabyss.ring_of_ender_chest");

	public RingOfEnderChestItem() 
	{
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

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);

		list.add(new TextComponent("\u18B1 0.0 \u18B4 100.0 \u18B9 Right Click"));
list.add(new TextComponent("\u00A7bAbility\u00A7f: Your Ender Chest to go!"));
list.add(new TextComponent("It uses \u00A7b0 percent somnium\u00A7f."));
list.add(new TextComponent(""));
list.add(new TextComponent("This item must be produced in the \u00A7bArcane Workbench.\u00A7f"));
	}
}

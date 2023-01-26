package net.yezon.theabyss.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.yezon.theabyss.events.GetLoranEnergyAdvevent;
import net.yezon.theabyss.init.TheabyssModTabs;

import javax.annotation.Nullable;
import java.util.List;

public class LoranEnergyItem extends Item {
    public LoranEnergyItem() {
        super(new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS).durability(64).rarity(Rarity.RARE));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.EAT;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack itemstack) {
        return true;
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, @Nullable Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.literal("pure energy for abyss weapons and wands"));
    }

    @Override
    public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
        super.onCraftedBy(itemstack, world, entity);
        GetLoranEnergyAdvevent.execute(entity);
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected)
            GetLoranEnergyAdvevent.execute(entity);
        GetLoranEnergyAdvevent.execute(entity);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return getDurability(stack) - 1 > 0;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        super.setDamage(stack, stack.getDamageValue() + 1);
        return stack;
    }

    private int getDurability(ItemStack itemStack) {
        return itemStack.getMaxDamage() - itemStack.getDamageValue();
    }
}

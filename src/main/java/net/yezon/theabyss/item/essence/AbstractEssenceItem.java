package net.yezon.theabyss.item.essence;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AbstractEssenceItem extends Item implements EssenceItem{
    public AbstractEssenceItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public final ItemStack getStackOfSelf() {
        return new ItemStack(this);
    }
}

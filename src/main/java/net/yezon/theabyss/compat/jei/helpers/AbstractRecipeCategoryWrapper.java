package net.yezon.theabyss.compat.jei.helpers;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.function.Supplier;

public abstract class AbstractRecipeCategoryWrapper {
    protected final ArrayList<ItemStack> inputs = new ArrayList<>();
    protected final Item result;

    public AbstractRecipeCategoryWrapper(Item result) {
        this.result = result;
    }

    protected ItemStack makeStack(Supplier<Item> item) {
        return new ItemStack(item.get());
    }

    public ArrayList<ItemStack> getInputs() {
        return inputs;
    }

    public ItemStack getResult() {
        return new ItemStack(result);
    }
}

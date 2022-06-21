package net.yezon.theabyss.compat.jei.helpers;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * @author KhanhPham05 - KhanhTypo (1.18.2)
 * @author Y3Z0n (1.16.5)
 */
public abstract class AbstractRecipeCategoryWrapper {
    protected final ArrayList<ItemStack> inputs = new ArrayList<>();
    protected final Item result;

    public AbstractRecipeCategoryWrapper(Item result) {
        this.result = result;
    }

    public ItemStack makeStack(Supplier<? extends Item> item) {
        return new ItemStack(item.get());
    }

    public ArrayList<ItemStack> getInputs() {
        return inputs;
    }

    public ItemStack getResult() {
        return new ItemStack(result);
    }

    public AbstractRecipeCategoryWrapper putItem(Supplier<? extends Item> item) {
        this.inputs.add(makeStack(item));
        return this;
    }
}

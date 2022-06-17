package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.item.ItemStack;

public class TestEvent {
	public static ItemStack execute() {
		return new ItemStack(TheabyssModItems.BOTTLE_OF_SOMNIUM.get());
	}
}

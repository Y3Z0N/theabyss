
package net.yezon.theabyss.itemgroup;

import net.yezon.theabyss.item.BookIconItem;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@TheAbyss.Processor.Tag
public class TheAbyssItemGroup extends TheAbyss.Processor {
	public TheAbyssItemGroup(TheAbyss instance) {
		super(instance, 553);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabthe_abyss") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BookIconItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}

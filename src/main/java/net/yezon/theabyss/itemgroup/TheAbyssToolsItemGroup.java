
package net.yezon.theabyss.itemgroup;

import net.yezon.theabyss.item.UnorithePickAxeItem;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@TheAbyss.Processor.Tag
public class TheAbyssToolsItemGroup extends TheAbyss.Processor {
	public TheAbyssToolsItemGroup(TheAbyss instance) {
		super(instance, 557);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabthe_abyss_tools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(UnorithePickAxeItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}

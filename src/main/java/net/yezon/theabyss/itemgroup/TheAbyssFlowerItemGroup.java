
package net.yezon.theabyss.itemgroup;

import net.yezon.theabyss.block.LoranFlowerBlock;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@TheAbyss.Processor.Tag
public class TheAbyssFlowerItemGroup extends TheAbyss.Processor {
	public TheAbyssFlowerItemGroup(TheAbyss instance) {
		super(instance, 558);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabthe_abyss_flower") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(LoranFlowerBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}

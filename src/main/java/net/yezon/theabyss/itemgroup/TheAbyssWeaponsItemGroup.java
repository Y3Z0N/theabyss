
package net.yezon.theabyss.itemgroup;

import net.yezon.theabyss.item.FusionSwordItem;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@TheAbyss.Processor.Tag
public class TheAbyssWeaponsItemGroup extends TheAbyss.Processor {
	public TheAbyssWeaponsItemGroup(TheAbyss instance) {
		super(instance, 559);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabthe_abyss_weapons") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(FusionSwordItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}

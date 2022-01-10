
package net.yezon.theabyss.itemgroup;

import net.yezon.theabyss.item.NightHunterAbl2Item;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@TheAbyss.Processor.Tag
public class TheAbyssEntityItemGroup extends TheAbyss.Processor {
	public TheAbyssEntityItemGroup(TheAbyss instance) {
		super(instance, 564);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabthe_abyss_entity") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NightHunterAbl2Item.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}

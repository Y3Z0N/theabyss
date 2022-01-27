
package net.yezon.theabyss.itemgroup;

import net.yezon.theabyss.item.IncorytheArmorItem;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@TheAbyss.Processor.Tag
public class TheAbyssArmorItemGroup extends TheAbyss.Processor {
	public TheAbyssArmorItemGroup(TheAbyss instance) {
		super(instance, 556);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabthe_abyss_armor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(IncorytheArmorItem.body);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}

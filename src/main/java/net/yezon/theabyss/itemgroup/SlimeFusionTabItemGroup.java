
package net.yezon.theabyss.itemgroup;

import net.yezon.theabyss.item.MutatedEnderpearlItem;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@TheAbyss.Processor.Tag
public class SlimeFusionTabItemGroup extends TheAbyss.Processor {
	public SlimeFusionTabItemGroup(TheAbyss instance) {
		super(instance, 573);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabslime_fusion_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MutatedEnderpearlItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}


/*
 *    Y3 was here UwU ^-^
 */
package net.yezon.theabyss.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class TheabyssModTabs {
	public static CreativeModeTab TAB_THE_ABYSS;
	public static CreativeModeTab TAB_THE_ABYSS_ARMOR;
	public static CreativeModeTab TAB_THE_ABYSS_TOOLS;
	public static CreativeModeTab TAB_THE_ABYSS_FLOWER;
	public static CreativeModeTab TAB_THE_ABYSS_WEAPONS;
	public static CreativeModeTab TAB_THE_ABYSS_ENTITY;
	public static CreativeModeTab TAB_SLIME_FUSION_TAB;

	public static void load() {
		TAB_THE_ABYSS = new CreativeModeTab("tabthe_abyss") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TheabyssModItems.BOOK_ICON.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_THE_ABYSS_ARMOR = new CreativeModeTab("tabthe_abyss_armor") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TheabyssModItems.INCORYTHE_ARMOR_CHESTPLATE.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_THE_ABYSS_TOOLS = new CreativeModeTab("tabthe_abyss_tools") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TheabyssModItems.UNORITHE_PICK_AXE.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_THE_ABYSS_FLOWER = new CreativeModeTab("tabthe_abyss_flower") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TheabyssModBlocks.LORAN_FLOWER.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_THE_ABYSS_WEAPONS = new CreativeModeTab("tabthe_abyss_weapons") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TheabyssModItems.FUSION_SWORD.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_THE_ABYSS_ENTITY = new CreativeModeTab("tabthe_abyss_entity") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TheabyssModItems.NIGHT_HUNTER_ABL_2.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_SLIME_FUSION_TAB = new CreativeModeTab("tabslime_fusion_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TheabyssModItems.MUTATED_ENDERPEARL.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}

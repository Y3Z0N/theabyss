
package net.yezon.theabyss.item;

import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

@TheAbyss.Processor.Tag
public class NightbladeThemeItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:nightblade_theme")
	public static final Item block = null;

	public NightbladeThemeItem(TheAbyss instance) {
		super(instance, 1143);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, TheAbyss.sounds.get(new ResourceLocation("theabyss:end_game_music")),
					new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("nightblade_theme");
		}
	}
}


package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModSounds;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class CyanideThemeItem extends RecordItem {
	public CyanideThemeItem() {
		super(0, TheabyssModSounds.REGISTRY.get(new ResourceLocation("theabyss:end_game_music_cyanidex")),
				new Item.Properties().tab(null).stacksTo(1).rarity(Rarity.RARE));
	}
}


package net.yezon.theabyss.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class NightbladeThemeItem extends RecordItem {
	public NightbladeThemeItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:end_game_music")), new Item.Properties().tab(null).stacksTo(1).rarity(Rarity.RARE), 0);
	}
}

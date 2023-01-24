
 
package net.yezon.theabyss.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class TheabyssModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == TheabyssModItems.LORAN.get())
			event.setBurnTime(2600);
		else if (itemstack.getItem() == TheabyssModBlocks.LORAN_ORE.get().asItem())
			event.setBurnTime(6800);
	}
}

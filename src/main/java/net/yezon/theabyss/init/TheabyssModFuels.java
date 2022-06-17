
/*
 *    Y3 was here UwU ^-^
 */
package net.yezon.theabyss.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

@Mod.EventBusSubscriber
public class TheabyssModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == TheabyssModItems.LORAN.get())
			event.setBurnTime(2600);
		else if (event.getItemStack().getItem() == TheabyssModBlocks.LORAN_ORE.get().asItem())
			event.setBurnTime(6800);
	}
}

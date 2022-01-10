
package net.yezon.theabyss.fuel;

import net.yezon.theabyss.block.LoranOreBlock;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

@Mod.EventBusSubscriber
public class LoranBlockFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == LoranOreBlock.block.asItem())
			event.setBurnTime(6800);
	}
}

package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.configuration.AbyssConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TickEvent {
	@SubscribeEvent
	public static void onPlayerTick(net.minecraftforge.event.TickEvent.PlayerTickEvent event) {
		if (event.phase == net.minecraftforge.event.TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (double) AbyssConfiguration.SOMNIUM_BAR_X.get();
			entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HudX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) AbyssConfiguration.SOMNIUM_BAR_Y.get();
			entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HudY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}

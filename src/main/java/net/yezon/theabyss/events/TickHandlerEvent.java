package net.yezon.theabyss.events;

import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.GameType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.Map;
import java.util.HashMap;

public class TickHandlerEvent {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeEvent(dependencies);
			}
		}
	}

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event TickHandler!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Capabilities.PlayerVariables())).Mana > 100)) {
			{
				double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).Mana
						+ 0.04 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Capabilities.PlayerVariables())).ManaRegenUpgrade);
				entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Capabilities.PlayerVariables())).EmptySomnium == true) {
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Mana > 1) {
				{
					boolean _setval = (true);
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EnableManaBar = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (false);
					entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EnableManaBar = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			{
				boolean _setval = (true);
				entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EnableManaBar = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity.isInWater() || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			{
				boolean _setval = (false);
				entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SomniumHandler = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = (true);
				entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SomniumHandler = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

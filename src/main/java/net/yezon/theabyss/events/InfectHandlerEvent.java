package net.yezon.theabyss.events;

import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.GameType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.Map;
import java.util.HashMap;

public class InfectHandlerEvent {
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
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event InfectHandler!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!(new Object() {
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
		}.checkGamemode(entity))) {
			if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("theabyss:the_abyss")))) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).Infected < 1) {
					{
						double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Capabilities.PlayerVariables())).Infected + 0.00015);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Infected = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).Infected > 0.05) {
					{
						double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Capabilities.PlayerVariables())).Infected - 0.005);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Infected = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Infected > 0.95) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("infection").setDamageBypassesArmor(), (float) 1);
				}
			}
			if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("theabyss:frost_world")))) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).Freeze < 1) {
					{
						double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Capabilities.PlayerVariables())).Freeze + 0.00005);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Freeze = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).Freeze > 0.05) {
					{
						double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Capabilities.PlayerVariables())).Freeze - 0.005);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Freeze = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Freeze > 0.95) {
				if (Math.random() < 0.05) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).attackEntityFrom(new DamageSource("freeze").setDamageBypassesArmor(), (float) 1);
					}
				}
			}
		}
	}
}

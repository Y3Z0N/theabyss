
package net.yezon.theabyss.network;

import net.yezon.theabyss.world.inventory.PatreonScreenMenu;
import net.yezon.theabyss.eventhandlers.PatreonWalkParticlesEventHandler;
import net.yezon.theabyss.eventhandlers.PatreonGetDisc2EventHandler;
import net.yezon.theabyss.eventhandlers.PatreonGetDisc1EventHandler;
import net.yezon.theabyss.eventhandlers.PatreonFireworkOnJoinEventHandler;
import net.yezon.theabyss.eventhandlers.PatreonDeathParticleEventHandler;
import net.yezon.theabyss.eventhandlers.PXSurvivalEventHandler;
import net.yezon.theabyss.eventhandlers.PXSpectatorEventHandler;
import net.yezon.theabyss.eventhandlers.PXOpSwordEventHandler;
import net.yezon.theabyss.eventhandlers.PXCreativeEventHandler;
import net.yezon.theabyss.eventhandlers.GiveRingOfFireworkEventHandler;
import net.yezon.theabyss.eventhandlers.GiveRingOfFartEventHandler;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PatreonScreenButtonMessage {
	private final int buttonID, x, y, z;

	public PatreonScreenButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PatreonScreenButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PatreonScreenButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PatreonScreenButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = PatreonScreenMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PatreonGetDisc1EventHandler.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			PatreonGetDisc2EventHandler.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			PatreonFireworkOnJoinEventHandler.execute(entity);
		}
		if (buttonID == 3) {

			PatreonDeathParticleEventHandler.execute(entity);
		}
		if (buttonID == 4) {

			GiveRingOfFireworkEventHandler.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			PatreonWalkParticlesEventHandler.execute(entity);
		}
		if (buttonID == 6) {

			GiveRingOfFartEventHandler.execute(world, x, y, z);
		}
		if (buttonID == 7) {

			PXCreativeEventHandler.execute(entity);
		}
		if (buttonID == 8) {

			PXSurvivalEventHandler.execute(entity);
		}
		if (buttonID == 9) {

			PXSpectatorEventHandler.execute(entity);
		}
		if (buttonID == 10) {

			PXOpSwordEventHandler.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TheabyssMod.addNetworkMessage(PatreonScreenButtonMessage.class, PatreonScreenButtonMessage::buffer, PatreonScreenButtonMessage::new, PatreonScreenButtonMessage::handler);
	}
}

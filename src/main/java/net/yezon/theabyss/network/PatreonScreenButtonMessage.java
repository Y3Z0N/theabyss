
package net.yezon.theabyss.network;

import net.yezon.theabyss.world.inventory.PatreonScreenMenu;
import net.yezon.theabyss.events.PatreonWalkParticlesEvent;
import net.yezon.theabyss.events.PatreonGetDisc2Event;
import net.yezon.theabyss.events.PatreonGetDisc1Event;
import net.yezon.theabyss.events.PatreonFireworkOnJoinEvent;
import net.yezon.theabyss.events.PatreonDeathParticleEvent;
import net.yezon.theabyss.events.PXSurvivalEvent;
import net.yezon.theabyss.events.PXSpectatorEvent;
import net.yezon.theabyss.events.PXOpSwordEvent;
import net.yezon.theabyss.events.PXCreativeEvent;
import net.yezon.theabyss.events.GiveRingOfFireworkEvent;
import net.yezon.theabyss.events.GiveRingOfFartEvent;
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

			PatreonGetDisc1Event.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			PatreonGetDisc2Event.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			PatreonFireworkOnJoinEvent.execute(entity);
		}
		if (buttonID == 3) {

			PatreonDeathParticleEvent.execute(entity);
		}
		if (buttonID == 4) {

			GiveRingOfFireworkEvent.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			PatreonWalkParticlesEvent.execute(entity);
		}
		if (buttonID == 6) {

			GiveRingOfFartEvent.execute(world, x, y, z);
		}
		if (buttonID == 7) {

			PXCreativeEvent.execute(entity);
		}
		if (buttonID == 8) {

			PXSurvivalEvent.execute(entity);
		}
		if (buttonID == 9) {

			PXSpectatorEvent.execute(entity);
		}
		if (buttonID == 10) {

			PXOpSwordEvent.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TheabyssMod.addNetworkMessage(PatreonScreenButtonMessage.class, PatreonScreenButtonMessage::buffer, PatreonScreenButtonMessage::new,
				PatreonScreenButtonMessage::handler);
	}
}

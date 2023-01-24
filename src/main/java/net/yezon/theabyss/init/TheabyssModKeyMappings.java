
package net.yezon.theabyss.init;

import org.lwjgl.glfw.GLFW;

import net.yezon.theabyss.network.GhostFireAttackMessage;
import net.yezon.theabyss.network.GhostDeactivateMessage;
import net.yezon.theabyss.network.GhostAttackMessage;
import net.yezon.theabyss.network.FriendleyFireBMessage;
import net.yezon.theabyss.network.FriendleyFireAMessage;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TheabyssModKeyMappings {
	public static final KeyMapping GHOST_ATTACK = new KeyMapping("key.theabyss.ghost_attack", GLFW.GLFW_KEY_X, "key.categories.abyss") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheabyssMod.PACKET_HANDLER.sendToServer(new GhostAttackMessage(0, 0));
				GhostAttackMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				GHOST_ATTACK_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - GHOST_ATTACK_LASTPRESS);
				TheabyssMod.PACKET_HANDLER.sendToServer(new GhostAttackMessage(1, dt));
				GhostAttackMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping GHOST_FIRE_ATTACK = new KeyMapping("key.theabyss.ghost_fire_attack", GLFW.GLFW_KEY_C, "key.categories.abyss") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheabyssMod.PACKET_HANDLER.sendToServer(new GhostFireAttackMessage(0, 0));
				GhostFireAttackMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				GHOST_FIRE_ATTACK_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - GHOST_FIRE_ATTACK_LASTPRESS);
				TheabyssMod.PACKET_HANDLER.sendToServer(new GhostFireAttackMessage(1, dt));
				GhostFireAttackMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping GHOST_DEACTIVATE = new KeyMapping("key.theabyss.ghost_deactivate", GLFW.GLFW_KEY_V, "key.categories.abyss") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheabyssMod.PACKET_HANDLER.sendToServer(new GhostDeactivateMessage(0, 0));
				GhostDeactivateMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				GHOST_DEACTIVATE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - GHOST_DEACTIVATE_LASTPRESS);
				TheabyssMod.PACKET_HANDLER.sendToServer(new GhostDeactivateMessage(1, dt));
				GhostDeactivateMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FRIENDLEY_FIRE_A = new KeyMapping("key.theabyss.friendley_fire_a", GLFW.GLFW_KEY_RIGHT, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheabyssMod.PACKET_HANDLER.sendToServer(new FriendleyFireAMessage(0, 0));
				FriendleyFireAMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FRIENDLEY_FIRE_B = new KeyMapping("key.theabyss.friendley_fire_b", GLFW.GLFW_KEY_LEFT, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheabyssMod.PACKET_HANDLER.sendToServer(new FriendleyFireBMessage(0, 0));
				FriendleyFireBMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABIL_DEBUG = new KeyMapping("key.theabyss.abil_debug", GLFW.GLFW_KEY_DOWN, "key.categories.misc");
	private static long GHOST_ATTACK_LASTPRESS = 0;
	private static long GHOST_FIRE_ATTACK_LASTPRESS = 0;
	private static long GHOST_DEACTIVATE_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(GHOST_ATTACK);
		event.register(GHOST_FIRE_ATTACK);
		event.register(GHOST_DEACTIVATE);
		event.register(FRIENDLEY_FIRE_A);
		event.register(FRIENDLEY_FIRE_B);
		event.register(ABIL_DEBUG);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				GHOST_ATTACK.consumeClick();
				GHOST_FIRE_ATTACK.consumeClick();
				GHOST_DEACTIVATE.consumeClick();
				FRIENDLEY_FIRE_A.consumeClick();
				FRIENDLEY_FIRE_B.consumeClick();
			}
		}
	}
}


package net.yezon.theabyss.client.gui;

import net.yezon.theabyss.world.inventory.PatreonScreenMenu;
import net.yezon.theabyss.events.TierXEvent;
import net.yezon.theabyss.events.Tier5Event;
import net.yezon.theabyss.events.Tier4Event;
import net.yezon.theabyss.events.Tier3Event;
import net.yezon.theabyss.network.PatreonScreenButtonMessage;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PatreonScreenScreen extends AbstractContainerScreen<PatreonScreenMenu> {
	private final static HashMap<String, Object> guistate = PatreonScreenMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PatreonScreenScreen(PatreonScreenMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("theabyss:textures/screens/patreon_screen.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.theabyss.patreon_screen.label_patreon_level"), 6, 7, -13421773);
		if (TierXEvent.execute(entity))
			this.font.draw(poseStack, Component.translatable("gui.theabyss.patreon_screen.label_dev_tools"), -119, 7, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 25, 125, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_get_disc_1"), e -> {
					if (Tier3Event.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(0, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Tier3Event.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 52, 125, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_get_disc_2"), e -> {
					if (Tier4Event.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(1, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Tier4Event.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 79, 125, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_firework_on_join"), e -> {
					if (Tier4Event.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(2, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Tier4Event.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 106, 125, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_particles_on_death"), e -> {
					if (Tier4Event.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(3, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Tier4Event.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 133, 125, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_ring_of_firework"), e -> {
					if (Tier4Event.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(4, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Tier4Event.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 160, 125, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_particles_while_walk"), e -> {
					if (Tier4Event.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(5, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Tier4Event.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 187, 125, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_ring_of_fart"), e -> {
					if (Tier5Event.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(6, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (Tier5Event.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + -119, this.topPos + 25, 67, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_creative"), e -> {
					if (TierXEvent.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(7, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (TierXEvent.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + -119, this.topPos + 52, 67, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_survival"), e -> {
					if (TierXEvent.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(8, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (TierXEvent.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + -119, this.topPos + 79, 67, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_spectator"), e -> {
					if (TierXEvent.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(9, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (TierXEvent.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addRenderableWidget(new Button(this.leftPos + -119, this.topPos + 106, 67, 20,
				Component.translatable("gui.theabyss.patreon_screen.button_op_sword"), e -> {
					if (TierXEvent.execute(entity)) {
						TheabyssMod.PACKET_HANDLER.sendToServer(new PatreonScreenButtonMessage(10, x, y, z));
						PatreonScreenButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (TierXEvent.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}

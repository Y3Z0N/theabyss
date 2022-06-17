
package net.yezon.theabyss.client.gui;

import net.yezon.theabyss.world.inventory.WikiGuiMenu;
import net.yezon.theabyss.network.WikiGuiButtonMessage;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WikiGuiScreen extends AbstractContainerScreen<WikiGuiMenu> {
	private final static HashMap<String, Object> guistate = WikiGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public WikiGuiScreen(WikiGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

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
		this.font.draw(poseStack, "Getting Started", -119, -29, -16724788);
		this.font.draw(poseStack, "Unlike older versions you will not find any loran in the overworld. ", -119, -11, -1);
		this.font.draw(poseStack, "If you think you are ready for The Abyss Dimension you have probably  ", -119, -2, -1);
		this.font.draw(poseStack, "slept once and twice. If you haven't you will need to sleep once and then ", -119, 7, -1);
		this.font.draw(poseStack, "sleep another time. Each time you will be dreaming about the abyss.", -119, 16, -1);
		this.font.draw(poseStack, "After the second dream, you will need to find an Abandoned House", -119, 43, -1);
		this.font.draw(poseStack, "in a forest or plains. In there you will find a Broken Radio. ", -119, 52, -1);
		this.font.draw(poseStack, "You must then right click it which will teleport you to  ", -119, 61, -1);
		this.font.draw(poseStack, "the dream dimension again. The only difference is that you can see ", -119, 70, -1);
		this.font.draw(poseStack, "loran plants. You will be teleported back after some time so collect as ", -119, 79, -1);
		this.font.draw(poseStack, "much Loran as possible as this is the easiest way to get it.", -119, 88, -1);
		this.font.draw(poseStack, "Creating the Portal", -119, 115, -26368);
		this.font.draw(poseStack, "You will then need to craft 10 Unstable Obsidian and a Portal Activator. ", -119, 124, -1);
		this.font.draw(poseStack, "Placing the Obsidian in a portal format and lighting it with the Activator ", -119, 133, -1);
		this.font.draw(poseStack, "will create the portal.", -119, 142, -1);
		this.font.draw(poseStack, "If you need help and get stuck, click this button to go to the wiki page.", -119, 160, -39373);
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
		this.addRenderableWidget(new Button(this.leftPos + -119, this.topPos + 178, 70, 20, new TextComponent("Open Wiki"), e -> {
			if (true) {
				TheabyssMod.PACKET_HANDLER.sendToServer(new WikiGuiButtonMessage(0, x, y, z));
				WikiGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}

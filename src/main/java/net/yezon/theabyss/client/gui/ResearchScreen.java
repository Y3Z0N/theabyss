package net.yezon.theabyss.client.gui;

import net.yezon.theabyss.world.inventory.ResearchMenu;
import net.yezon.theabyss.network.ResearchButtonMessage;
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

public class ResearchScreen extends AbstractContainerScreen<ResearchMenu> {
	private final static HashMap<String, Object> guistate = ResearchMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_research;

	public ResearchScreen(ResearchMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("theabyss:textures/screens/research.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/screens/research_gui.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + 0, 0, 0, 256, 256, 256, 256);

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
		this.font.draw(poseStack, Component.translatable("gui.theabyss.research.label_research_table"), 6, 7, -6684724);
		this.font.draw(poseStack, Component.translatable("gui.theabyss.research.label_cost"), 78, 25, -6684724);
		this.font.draw(poseStack, Component.translatable("gui.theabyss.research.label_5_xp_levels"), 105, 25, -16724788);
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
		button_research = new Button(this.leftPos + 78, this.topPos + 42, 65, 20, Component.translatable("gui.theabyss.research.button_research"), e -> {
			if (true) {
				TheabyssMod.PACKET_HANDLER.sendToServer(new ResearchButtonMessage(0, x, y, z));
				ResearchButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_research", button_research);
		this.addRenderableWidget(button_research);
	}
}

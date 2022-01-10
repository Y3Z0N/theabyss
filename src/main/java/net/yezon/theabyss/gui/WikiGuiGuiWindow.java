
package net.yezon.theabyss.gui;

import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class WikiGuiGuiWindow extends ContainerScreen<WikiGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = WikiGuiGui.guistate;

	public WikiGuiGuiWindow(WikiGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Getting Started", -119, -29, -16724788);
		this.font.drawString(ms, "Unlike older versions you will not find any loran in the overworld. ", -119, -11, -1);
		this.font.drawString(ms, "If you think you are ready for The Abyss Dimension you have probably  ", -119, -2, -1);
		this.font.drawString(ms, "slept once and twice. If you haven't you will need to sleep once and then ", -119, 7, -1);
		this.font.drawString(ms, "sleep another time. Each time you will be dreaming about the abyss.", -119, 16, -1);
		this.font.drawString(ms, "After the second dream, you will need to find an Abandoned House", -119, 43, -1);
		this.font.drawString(ms, "in a forest or plains. In there you will find a Broken Radio. ", -119, 52, -1);
		this.font.drawString(ms, "You must then right click it which will teleport you to  ", -119, 61, -1);
		this.font.drawString(ms, "the dream dimension again. The only difference is that you can see ", -119, 70, -1);
		this.font.drawString(ms, "loran plants. You will be teleported back after some time so collect as ", -119, 79, -1);
		this.font.drawString(ms, "much Loran as possible as this is the easiest way to get it.", -119, 88, -1);
		this.font.drawString(ms, "Creating the Portal", -119, 115, -26368);
		this.font.drawString(ms, "You will then need to craft 10 Unstable Obsidian and a Portal Activator. ", -119, 124, -1);
		this.font.drawString(ms, "Placing the Obsidian in a portal format and lighting it with the Activator ", -119, 133, -1);
		this.font.drawString(ms, "will create the portal.", -119, 142, -1);
		this.font.drawString(ms, "If you need help and get stuck, click this button to go to the wiki page.", -119, 160, -39373);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + -119, this.guiTop + 178, 70, 20, new StringTextComponent("Open Wiki"), e -> {
			if (true) {
				TheabyssMod.PACKET_HANDLER.sendToServer(new WikiGuiGui.ButtonPressedMessage(0, x, y, z));
				WikiGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}

package net.yezon.theabyss.gui.overlay;

import net.yezon.theabyss.Capabilities;

import net.yezon.theabyss.events.ManaBarToggleEvent;
import net.yezon.theabyss.events.Mana95Event;
import net.yezon.theabyss.events.Mana95HalfEvent;
import net.yezon.theabyss.events.Mana90Event;
import net.yezon.theabyss.events.Mana90HalfEvent;
import net.yezon.theabyss.events.Mana80Event;
import net.yezon.theabyss.events.Mana80HalfEvent;
import net.yezon.theabyss.events.Mana70Event;
import net.yezon.theabyss.events.Mana70HalfEvent;
import net.yezon.theabyss.events.Mana60Event;
import net.yezon.theabyss.events.Mana60HalfEvent;
import net.yezon.theabyss.events.Mana50Event;
import net.yezon.theabyss.events.Mana50HalfEvent;
import net.yezon.theabyss.events.Mana40Event;
import net.yezon.theabyss.events.Mana40HalfEvent;
import net.yezon.theabyss.events.Mana30Event;
import net.yezon.theabyss.events.Mana30HalfEvent;
import net.yezon.theabyss.events.Mana20Event;
import net.yezon.theabyss.events.Mana20HalfEvent;
import net.yezon.theabyss.events.Mana10Event;
import net.yezon.theabyss.events.Mana10HalfEvent;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.google.common.collect.ImmutableMap;

@TheAbyss.Processor.Tag
public class SomniumOverlayOverlay extends TheAbyss.Processor {
	public SomniumOverlayOverlay(TheAbyss instance) {
		super(instance, 1150);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2 + 10;
			int posY = (event.getWindow().getScaledHeight()) - 49;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			int ValX = ((int) ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).HudX));
			int ValY = ((int) ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				    .orElse(new Capabilities.PlayerVariables())).HudY));
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (ManaBarToggleEvent.executeEvent(ImmutableMap.of("entity", entity))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 8 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 16 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 24 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 32 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 40 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 48 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 56 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 64 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_none_icon.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 72 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				if (Mana10HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana20HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 8 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana30HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 16 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana40HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 24 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana50HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 32 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana60HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 40 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana70HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 48 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana80HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 56 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana90HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 64 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana95HalfEvent.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_half_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 72 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana10Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana20Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 8 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana30Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 16 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana40Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 24 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana50Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 32 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana60Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 40 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana70Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 48 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana80Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 56 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana90Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 64 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
				if (Mana95Event.executeEvent(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("theabyss:textures/mana_icon.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 72 + ValX, posY + ValY, + 0, 0, 0, 9, 9, 9, 9);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}

package net.yezon.theabyss.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.yezon.theabyss.events.ManaBarToggleevent;
import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SomniumBarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth() / 2 + 10;
		int h = event.getWindow().getGuiScaledHeight() - 49;
		int posX = w;
		int posY = h;
		Level _world = null;
		double _x = 0;
		double _y = 0;
		double _z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			_world = entity.level;
			_x = entity.getX();
			_y = entity.getY();
			_z = entity.getZ();
		}
		Level world = _world;
		double x = _x;
		double y = _y;
		double z = _z;
		int HudX = ((int) ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheabyssModVariables.PlayerVariables())).HudX));
		int HudY = ((int) ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheabyssModVariables.PlayerVariables())).HudY));
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
				GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (ManaBarToggleevent.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 0, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 8, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 16, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 24, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 32, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 40, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 48, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 56, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 64, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_none_icon.png"));
			Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 72, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 4) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 0, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 14) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 8, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 24) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 16, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 34) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 24, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 44) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 32, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 54) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 40, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 64) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 48, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 74) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 56, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 84) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 64, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 94) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_half_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 72, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 9) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 0, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 19) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 8, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 29) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 16, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 39) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 24, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 49) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 32, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 59) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 40, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 69) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 48, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 79) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 56, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 89) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 64, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana > 99) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/mana_icon.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), posX + HudX + 72, posY + HudY + 0, 0, 0, 9, 9, 9, 9);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}

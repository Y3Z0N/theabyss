package net.yezon.theabyss.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.client.gui.base.TheAbyssContainerScreen;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import net.yezon.theabyss.world.inventory.InfuserMenu;

public class InfuserScreen extends TheAbyssContainerScreen<InfuserMenu> {
    private static final ResourceLocation texture = TheabyssMod.location("textures/screens/somnium_infuser_gui.png");

    public InfuserScreen(InfuserMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
    }

    @Override
    public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderTooltip(ms, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, texture);
        super.blit(poseStack, super.leftPos, super.topPos, 0, 0, 176, 170);
        RenderSystem.disableBlend();
    }

    @Override
    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
        super.font.draw(poseStack, super.playerInventoryTitle, 7, 78, ContainerAndScreenUtils.FONT_COLOR);
        ContainerAndScreenUtils.drawRightText(poseStack, super.font, super.title, 172, 4);
    }
}

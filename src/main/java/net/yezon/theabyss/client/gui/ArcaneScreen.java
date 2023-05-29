package net.yezon.theabyss.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import net.yezon.theabyss.world.inventory.ArcaneMenu;

public class ArcaneScreen extends AbstractContainerScreen<ArcaneMenu> {
    public static final ResourceLocation GUI = TheabyssMod.location("textures/screens/arcane_gui.png");

    public ArcaneScreen(ArcaneMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
    }

    @Override
    public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderTooltip(ms, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
        ContainerAndScreenUtils.setupContainerScreen(this, ms, GUI, 176, 194);
        ContainerAndScreenUtils.drawRecipeViewBox(this, ms, AllRecipeTypes.ARCANE_CRAFTING, 176, 0);
    }


    @Override
    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
        super.font.draw(poseStack, super.playerInventoryTitle, 7, 98, ContainerAndScreenUtils.FONT_COLOR);
        ContainerAndScreenUtils.drawRightText(poseStack, this, 172, 4);
    }
}

package net.yezon.theabyss.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.ModList;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import net.yezon.theabyss.world.inventory.ArcaneMenu;

public class ArcaneScreen extends AbstractContainerScreen<ArcaneMenu> {
    public ArcaneScreen(ArcaneMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.imageWidth = 176;
        this.imageHeight = 200;
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

        RenderSystem.setShaderTexture(0, new ResourceLocation("theabyss:textures/screens/arcane_gui.png"));
        blit(ms, super.leftPos, super.topPos, 0, 0, 176, 194);

        if (ModList.get().isLoaded("jei")) {
            blit(ms, super.leftPos + 150, super.topPos + 87, 176, 0, 20, 20);
            ContainerAndScreenUtils.drawGuiItem(this, Items.KNOWLEDGE_BOOK, 152, 91);
        }

        RenderSystem.disableBlend();
    }


    @Override
    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
        super.font.draw(poseStack, super.playerInventoryTitle, 7, 98, ContainerAndScreenUtils.FONT_COLOR);
        ContainerAndScreenUtils.drawRightText(poseStack, this, 172, 4);
    }
}

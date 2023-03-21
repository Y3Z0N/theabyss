package net.yezon.theabyss.client.gui.base;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import net.yezon.theabyss.world.inventory.TheAbyssContainerMenu;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public abstract class TheAbyssContainerScreen<T extends TheAbyssContainerMenu> extends AbstractContainerScreen<T> {
    public TheAbyssContainerScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        super.inventoryLabelX = pMenu.getInventoryLabelX();
        super.inventoryLabelY = pMenu.getInventoryLabelY();
    }

    public void setTitleLabelCornerPosition(int width) {
        super.titleLabelX = width - 3;
    }

    @Override
    protected void renderLabels(@Nonnull PoseStack pPoseStack, int pMouseX, int pMouseY) {
        super.font.draw(pPoseStack, super.playerInventoryTitle, super.inventoryLabelX, super.inventoryLabelY, ContainerAndScreenUtils.FONT_COLOR);
        ContainerAndScreenUtils.drawRightText(pPoseStack, this, super.titleLabelX, 3);
    }
}

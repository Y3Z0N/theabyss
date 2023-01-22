package net.yezon.theabyss.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class ContainerAndScreenUtils {
    public static final int FONT_COLOR = 0xff99ffcc;

    private ContainerAndScreenUtils() {
    }

    public static <T extends AbstractContainerMenu> SimpleMenuProvider createSimpleMenuProvider(Supplier<MenuType<T>> supplier, Component key, Level level) {
        return new SimpleMenuProvider(((pContainerId, pPlayerInventory, pPlayer) -> supplier.get().create(pContainerId, pPlayerInventory)), key);
    }

    public static void drawRightText(PoseStack poseStack, AbstractContainerScreen<?> screen, int cornerX, int cornerY) {
        drawRightText(poseStack, screen.getMinecraft().font, screen.getTitle(), cornerX, cornerY);
    }

    public static void drawRightText(PoseStack poseStack, Font fontDrawer, Component component, int cornerX, int cornerY) {
        final FormattedCharSequence visualText = component.getVisualOrderText();
        int titleLength = fontDrawer.width(visualText);

        fontDrawer.draw(poseStack, visualText, cornerX - titleLength, cornerY, FONT_COLOR);
    }

    public static void drawGuiItem(AbstractContainerScreen<?> screen, ItemLike icon, int x, int y) {
        screen.getMinecraft().getItemRenderer().renderGuiItem(new ItemStack(icon), screen.getGuiLeft() + x, screen.getGuiTop() + y);
    }
}

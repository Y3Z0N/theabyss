package net.yezon.theabyss.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.client.gui.base.TheAbyssContainerScreen;
import net.yezon.theabyss.recipes.AllRecipeTypes;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import net.yezon.theabyss.world.inventory.MortarMenu;

public class MortarScreen extends TheAbyssContainerScreen<MortarMenu> {
    public static final ResourceLocation GUI = TheabyssMod.location("textures/screens/mortar_and_pestle.png");

    public MortarScreen(MortarMenu container, Inventory inventory, Component text) {
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
        ContainerAndScreenUtils.setupContainerScreen(this, ms, GUI, 176, 183);
        ContainerAndScreenUtils.drawRecipeViewBox(this, ms, AllRecipeTypes.MORTAR_AND_PESTLE, 176, 0);
    }
}

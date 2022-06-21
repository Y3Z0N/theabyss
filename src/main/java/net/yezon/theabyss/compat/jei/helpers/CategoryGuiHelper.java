package net.yezon.theabyss.compat.jei.helpers;

import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.resources.ResourceLocation;

/**
 * @author KhanhPham05 - KhanhTypo (1.18.2)
 * @author Y3Z0n (1.16.5)
 */
public record CategoryGuiHelper(ResourceLocation location, int x, int y, int width, int height) {
    public IDrawable drawBackground(IGuiHelper helper) {
        return helper.createDrawable(location, x, y, width, height);
    }
}

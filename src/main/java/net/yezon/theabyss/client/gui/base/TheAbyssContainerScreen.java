package net.yezon.theabyss.client.gui.base;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.yezon.theabyss.world.inventory.TheAbyssContainerMenu;

public abstract class TheAbyssContainerScreen<T extends TheAbyssContainerMenu> extends AbstractContainerScreen<T> {
    public TheAbyssContainerScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        super.inventoryLabelX = pMenu.getInventoryLabelX();
        super.inventoryLabelY = pMenu.getInventoryLabelY();
    }
}

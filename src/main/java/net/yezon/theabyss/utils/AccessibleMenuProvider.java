package net.yezon.theabyss.utils;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;

/**
 * @author KhanhTypo
 */
@FunctionalInterface
public interface AccessibleMenuProvider<T extends AbstractContainerMenu> {
    T createMenu(int containerId, Inventory inventory, ContainerLevelAccess access);
}

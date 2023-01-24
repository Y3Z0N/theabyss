package net.yezon.theabyss.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import net.yezon.theabyss.block.entity.base.AbyssContainerBlockEntity;
import net.yezon.theabyss.block.entity.base.TickableBlockEntity;
import net.yezon.theabyss.recipes.AbyssRecipeType;
import net.yezon.theabyss.recipes.RecipeDisplayData;
import net.yezon.theabyss.world.inventory.TheAbyssContainerMenu;

import javax.annotation.Nullable;
import java.util.function.BiFunction;
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

    public static ContainerLevelAccess createLevelAccess(@Nullable BlockEntity blockEntity) {
        return blockEntity == null ? ContainerLevelAccess.NULL :
                blockEntity.getLevel() != null ? ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()) : ContainerLevelAccess.NULL;
    }

    public static void drawRecipeViewBox(AbstractContainerScreen<?> screen, PoseStack poseStack, AbyssRecipeType recipeType, int uOffset, int vOffset) {
        final RecipeDisplayData.RecipeViewHolder holder = recipeType.getData().recipeViewArea();
        drawRecipeViewBox(screen, poseStack, holder.x(), holder.y(), uOffset, vOffset, holder.width(), holder.height());
    }

    public static void drawRecipeViewBox(AbstractContainerScreen<?> screen, PoseStack poseStack, int x, int y, int uOffset, int vOffset, int width, int height) {
        final boolean isJeiInstalled = ModList.get().isLoaded("jei");
        if (isJeiInstalled) {
            final int xPos = screen.getGuiLeft() + x;
            final int yPos = screen.getGuiTop() + y;

            screen.blit(poseStack, xPos, yPos, uOffset, vOffset, width, height);

            drawGuiItem(screen, Items.KNOWLEDGE_BOOK, xPos + 2, yPos + 2);

        }
    }

    @Deprecated
    public static <T extends AbyssContainerBlockEntity> InteractionResult tryOpenContainer(Level pLevel, Player pPlayer, BlockPos pos, BlockState state, BiFunction<BlockPos, BlockState, T> containerProvider) {
        if (!pLevel.isClientSide()) {
            pPlayer.openMenu(containerProvider.apply(pos, state));
            return InteractionResult.CONSUME;
        }

        return InteractionResult.SUCCESS;
    }

    public static <T extends BlockEntity & TickableBlockEntity> BlockEntityTicker<T> getSidedTicker(Level pLevel) {
        return pLevel.isClientSide() ? TickableBlockEntity::staticClientTick : TickableBlockEntity::staticServerTick;
    }

    public static Slot createFilteredSlot(Container container, int index, int x, int y, ItemLike filtered) {
        return new Slot(container, index, x, y) {
            @Override
            public boolean mayPlace(ItemStack pStack) {
                return pStack.is(filtered.asItem());
            }
        };
    }

    public static Slot createResultSlot(Container container, int index, int x, int y) {
        return new Slot(container, index, x, y) {
            @Override
            public boolean mayPlace(ItemStack pStack) {
                return false;
            }
        };
    }

    public static void addPlayerInventorySlots(TheAbyssContainerMenu menu, Inventory inv, int x, int y) {
        for (int si = 0; si < 3; ++si)
            for (int sj = 0; sj < 9; ++sj)
                menu.addSlot(new Slot(inv, sj + (si + 1) * 9, x + sj * 18, y + si * 18));
        for (int si = 0; si < 9; ++si)
            menu.addSlot(new Slot(inv, si, x + si * 18, y + 58));

        menu.setInventoryLabel(x, y - 10);
    }
}

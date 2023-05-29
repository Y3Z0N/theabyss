package net.yezon.theabyss.block.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.yezon.theabyss.block.entity.base.AbyssContainerBlockEntity;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public abstract class TheAbyssEntityBlock<T extends AbyssContainerBlockEntity> extends BaseEntityBlock implements EntityBlock {
    public TheAbyssEntityBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public final InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            this.openContainer(pLevel.getBlockEntity(pPos), pPlayer);
            return InteractionResult.CONSUME;
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    protected abstract void openContainer(@Nullable BlockEntity blockEntity, Player player);

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            if (pLevel.getBlockEntity(pPos) instanceof Container containerBlock) {
                if (!pLevel.isClientSide()) {
                    Containers.dropContents(pLevel, pPos, containerBlock);
                }

                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public abstract T newBlockEntity(BlockPos pPos, BlockState pState);
}

package net.yezon.theabyss.block.base;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.yezon.theabyss.block.entity.base.AbyssContainerBlockEntity;
import net.yezon.theabyss.block.entity.base.TickableBlockEntity;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class TheAbyssTickableEntityBlock<T extends AbyssContainerBlockEntity & TickableBlockEntity> extends TheAbyssEntityBlock<T> {

    public TheAbyssTickableEntityBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    @Nullable
    public abstract <A extends BlockEntity> BlockEntityTicker<A> getTicker(Level pLevel, BlockState pState, BlockEntityType<A> serverType);
}

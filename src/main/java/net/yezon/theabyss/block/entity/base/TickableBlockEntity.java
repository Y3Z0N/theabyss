package net.yezon.theabyss.block.entity.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public interface TickableBlockEntity {
    static <E extends BlockEntity & TickableBlockEntity> void staticClientTick(Level level, BlockPos blockPos, BlockState state, E e) {
        e.clientTick(level, blockPos, state);
    }

    static <E extends BlockEntity & TickableBlockEntity> void staticServerTick(Level level, BlockPos blockPos, BlockState state, E e) {
        e.serverTick(level, blockPos, state);
    }

    default void clientTick(Level level, BlockPos blockPos, BlockState state) {
    }

    default void serverTick(Level level, BlockPos blockPos, BlockState state) {
    }
}

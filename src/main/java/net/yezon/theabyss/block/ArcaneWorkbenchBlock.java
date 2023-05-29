package net.yezon.theabyss.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yezon.theabyss.world.inventory.ArcaneMenu;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class ArcaneWorkbenchBlock extends Block {
    public static final VoxelShape SHAPE = Stream.of(
            Block.box(2.5, 8, 1, 3.5, 10, 2),
            Block.box(0, 0, 0, 16, 9, 16),
            Block.box(4, 8.25, 4, 12, 9.25, 12),
            Block.box(1.5, 8, 2, 2.5, 10, 3),
            Block.box(2, 9, 1.5, 3, 11, 2.5),
            Block.box(9.5, 8, 12.5, 10.5, 10, 13.5),
            Block.box(8.5, 8, 13.5, 9.5, 10, 14.5),
            Block.box(9, 9, 13, 10, 11, 14),
            Block.box(14, 8, 7.5, 15, 10, 8.5),
            Block.box(13, 8, 8.5, 14, 10, 9.5),
            Block.box(13.5, 9, 8, 14.5, 11, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public ArcaneWorkbenchBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1f, 10f).noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            player.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return getName();
                }

                @Override
                public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
                    return new ArcaneMenu(pContainerId, pPlayerInventory, ContainerLevelAccess.create(level, pos));
                }
            });
        }
        return InteractionResult.PASS;
    }
}

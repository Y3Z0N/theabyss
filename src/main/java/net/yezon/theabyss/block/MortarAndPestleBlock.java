package net.yezon.theabyss.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraftforge.network.NetworkHooks;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import net.yezon.theabyss.world.inventory.MortarMenu;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

@SuppressWarnings("deprecation")
public class MortarAndPestleBlock extends Block {
    public static final VoxelShape SHAPE = Stream.of(
            Block.box(8, 2.5, 7.5, 10, 4.5, 10.5),
            Block.box(8.5, 3.53073, 2.30448, 9.5, 4.53073, 10.30448),
            Block.box(12, 0, 4, 13, 4, 12),
            Block.box(3, 0, 4, 4, 4, 12),
            Block.box(4, 0, 3, 12, 4, 4),
            Block.box(4, 0, 12, 12, 4, 13),
            Block.box(4, 0, 4, 12, 1, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public MortarAndPestleBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1f, 10f).noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide()) {
            entity.openMenu(ContainerAndScreenUtils.createMenuProvider(this.getName(), ContainerLevelAccess.create(world, pos), MortarMenu::new));
            return InteractionResult.CONSUME;
        }

        return InteractionResult.sidedSuccess(world.isClientSide());
    }

}

package net.yezon.theabyss.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yezon.theabyss.block.base.TheAbyssTickableEntityBlock;
import net.yezon.theabyss.block.entity.SomniumInfuserBlockEntity;
import net.yezon.theabyss.init.TheabyssModBlockEntities;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.stream.Stream;

public class SomniumInfuserBlock extends TheAbyssTickableEntityBlock<SomniumInfuserBlockEntity> {
    public static final VoxelShape SHAPE = Stream.of(
            Block.box(7, 0, 7, 9, 14, 9),
            Block.box(9, 0, 5, 15, 2, 11),
            Block.box(2, 0, 1, 8, 2, 7),
            Block.box(1.5, 0, 9, 7.5, 2, 15),
            Block.box(6, 11, 6, 7, 13, 7),
            Block.box(6, 4, 6, 7, 6, 7),
            Block.box(9, 11, 6, 10, 13, 7),
            Block.box(9, 4, 6, 10, 6, 7),
            Block.box(9, 11, 9, 10, 13, 10),
            Block.box(9, 4, 9, 10, 6, 10),
            Block.box(6, 11, 9, 7, 13, 10),
            Block.box(6, 4, 9, 7, 6, 10),
            Block.box(4.5, 6, 9.5, 6.5, 11, 11.5),
            Block.box(2, 2, 12.5, 4, 7, 14.5),
            Block.box(4.5, 6, 4.5, 6.5, 11, 6.5),
            Block.box(9.5, 6, 4.5, 11.5, 11, 6.5),
            Block.box(9.5, 6, 9.5, 11.5, 11, 11.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public SomniumInfuserBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1f, 10f).lightLevel(s -> 2).noOcclusion()
                .hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).isRedstoneConductor((bs, br, bp) -> false));
    }

    @Override
    public @Nullable <A extends BlockEntity> BlockEntityTicker<A> getTicker(Level pLevel, BlockState pState, BlockEntityType<A> serverType) {
        return createTickerHelper(serverType, TheabyssModBlockEntities.SOMNIUM_INFUSER.get(), ContainerAndScreenUtils.getSidedTicker(pLevel));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected void openContainer(@Nullable BlockEntity blockEntity, Player player) {
        if (blockEntity instanceof SomniumInfuserBlockEntity somniumInfuser) {
            player.openMenu(somniumInfuser);
        }
    }

    @Override
    public SomniumInfuserBlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SomniumInfuserBlockEntity(pPos, pState);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.isClientSide()) {
            Optional<SomniumInfuserBlockEntity> blockEntity = pLevel.getBlockEntity(pPos, TheabyssModBlockEntities.SOMNIUM_INFUSER.get());
            if (blockEntity.isPresent()) {
                if (!blockEntity.get().isIdle()) {
                    pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() - 0.5d, pPos.getY() + 1, pPos.getZ() - 0.5d, 0, 0, 0);
                }
            }
        }
    }
}

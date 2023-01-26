package net.yezon.theabyss.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.yezon.theabyss.block.base.TheAbyssTickableEntityBlock;
import net.yezon.theabyss.block.entity.SomniumInfuserBlockEntity;
import net.yezon.theabyss.init.TheabyssModBlockEntities;
import net.yezon.theabyss.utils.ContainerAndScreenUtils;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SomniumInfuserBlock extends TheAbyssTickableEntityBlock<SomniumInfuserBlockEntity> {
    public SomniumInfuserBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1f, 10f).lightLevel(s -> 2).noOcclusion()
                .hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).isRedstoneConductor((bs, br, bp) -> false));
    }

    @Override
    public @Nullable <A extends BlockEntity> BlockEntityTicker<A> getTicker(Level pLevel, BlockState pState, BlockEntityType<A> serverType) {
        return createTickerHelper(serverType, TheabyssModBlockEntities.SOMNIUM_INFUSER.get(), ContainerAndScreenUtils.getSidedTicker(pLevel));
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


package net.yezon.theabyss.block;

import net.yezon.theabyss.events.EcholotEffectEvent;
import net.yezon.theabyss.events.EcholotAmbienceEvent;
import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.Minecraft;

import java.util.Random;

public class EcholotTopBlock extends Block {
	public EcholotTopBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(-1, 3600000).lightLevel(s -> 3).noCollission()
				.noOcclusion().randomTicks().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.isRedstoneConductor((bs, br, bp) -> false).noDrops());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.IGNORE;
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, Random random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		EcholotAmbienceEvent.execute(world, x, y, z);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState blockstate, Level world, BlockPos pos, Random random) {
		super.animateTick(blockstate, world, pos, random);
		Player entity = Minecraft.getInstance().player;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		for (int l = 0; l < 15; ++l) {
			double x0 = x + 0.5 + (random.nextFloat() - 0.5) * 0.4000000014901161D;
			double y0 = y + 1.2 + (random.nextFloat() - 0.5) * 0.4000000014901161D * 100;
			double z0 = z + 0.5 + (random.nextFloat() - 0.5) * 0.4000000014901161D;
			world.addParticle((SimpleParticleType) (TheabyssModParticleTypes.ECHOLOT_BUBBLE.get()), x0, y0, z0, 0, 0, 0);
		}
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		EcholotEffectEvent.execute(entity);
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(TheabyssModBlocks.ECHOLOT_TOP.get(), renderType -> renderType == RenderType.cutout());
	}
}

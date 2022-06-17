
package net.yezon.theabyss.world.dimension;

import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.DimensionSpecialEffects;

import java.util.Set;
import java.util.HashSet;

import com.google.common.collect.ImmutableSet;

@Mod.EventBusSubscriber
public class DreamDimension {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Fixers {
		@SubscribeEvent
		public static void registerFillerBlocks(FMLCommonSetupEvent event) {
			Set<Block> replaceableBlocks = new HashSet<>();
			replaceableBlocks.add(TheabyssModBlocks.BLACK_VOID.get());
			replaceableBlocks.add(TheabyssModBlocks.BLACK_VOID.get());
			replaceableBlocks.add(TheabyssModBlocks.BLACK_VOID.get());
			event.enqueueWork(() -> {
				WorldCarver.CAVE.replaceableBlocks = new ImmutableSet.Builder<Block>().addAll(WorldCarver.CAVE.replaceableBlocks)
						.addAll(replaceableBlocks).build();
				WorldCarver.CANYON.replaceableBlocks = new ImmutableSet.Builder<Block>().addAll(WorldCarver.CANYON.replaceableBlocks)
						.addAll(replaceableBlocks).build();
			});
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void registerDimensionSpecialEffects(FMLClientSetupEvent event) {
			DimensionSpecialEffects customEffect = new DimensionSpecialEffects(128, true, DimensionSpecialEffects.SkyType.NORMAL, false, false) {
				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return new Vec3(0, 0, 0);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return true;
				}
			};
			event.enqueueWork(() -> DimensionSpecialEffects.EFFECTS.put(new ResourceLocation("theabyss:dream"), customEffect));
		}
	}
}

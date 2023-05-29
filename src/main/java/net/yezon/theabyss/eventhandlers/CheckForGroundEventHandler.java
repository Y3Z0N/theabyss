package net.yezon.theabyss.eventhandlers;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class CheckForGroundEventHandler {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x - 6, y, z - 6))).getBlock() == Blocks.AIR || (world.getBlockState(new BlockPos(x - 6, y - 6, z - 6))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos(x - 6, y - 5, z - 6))).getBlock() == Blocks.AIR) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("theabyss", "test"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x - 6, y - 12, z - 6), new BlockPos(x - 6, y - 12, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}

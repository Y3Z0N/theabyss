package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

public class ApplyPocketPortEvent {
	public static void execute(LevelAccessor world) {
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("theabyss:pocket_dimension")));
			if (world != null) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("theabyss", "pocket_room"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionX), 80, Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionZ)),
								new BlockPos(Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionX), 80, Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionZ)),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
				TheabyssModVariables.WorldVariables.get(world).PocketDimensionX = Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionX) + Math.round(20);
				TheabyssModVariables.WorldVariables.get(world).syncData(world);
			}
			world = _worldorig;
		}
		TheabyssModVariables.WorldVariables.get(world).PocketDimensionX = Math.round(TheabyssModVariables.WorldVariables.get(world).PocketDimensionX) + Math.round(20);
		TheabyssModVariables.WorldVariables.get(world).syncData(world);
	}
}

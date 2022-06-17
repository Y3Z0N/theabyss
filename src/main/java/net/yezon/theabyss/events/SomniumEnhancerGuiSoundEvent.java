package net.yezon.theabyss.events;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SomniumEnhancerGuiSoundEvent {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL,
						(float) 0.3, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
						SoundSource.NEUTRAL, (float) 0.3, 1, false);
			}
		}
	}
}

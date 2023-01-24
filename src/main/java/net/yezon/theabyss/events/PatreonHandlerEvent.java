package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModParticleTypes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PatreonHandlerEvent {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).WalkParticles == true) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).P4 == true
					|| (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).P5 == true
					|| (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).P6 == true
					|| (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).PX == true) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.END_SWORD_PT.get()), x, y, z, 5, 0.055, 0.055, 0.055, 0.015);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_LIGHT_CYAN.get()), x, y, z, 2, 0.055, 0.055, 0.055, 0.015);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.RENDER_BRIGHT_CYAN.get()), x, y, z, 2, 0.055, 0.055, 0.055, 0.015);
			}
		}
	}
}

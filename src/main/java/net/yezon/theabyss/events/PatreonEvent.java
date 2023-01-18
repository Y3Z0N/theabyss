package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Patreonevent {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level, event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheabyssModVariables.PlayerVariables())).P4 == true
				|| (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).P5 == true) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).FireworkOnJoin == true) {
				TheabyssMod.queueServerWork(100, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
										_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon firework_rocket ~ ~ ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
				});
				TheabyssMod.queueServerWork(110, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
										_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon firework_rocket ~ ~ ~ {LifeTime:25,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
				});
				TheabyssMod.queueServerWork(120, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
										_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon firework_rocket ~ ~ ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
				});
				TheabyssMod.queueServerWork(130, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
										_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon firework_rocket ~ ~ ~ {LifeTime:25,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
				});
				TheabyssMod.queueServerWork(140, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO,
										_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon firework_rocket ~ ~ ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("Y3Z0N")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("Dev")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("TheLightBlueGame")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P5 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("Shadyyyy_")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P5 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("TheCatsKing")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P5 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("releaseHUN")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P5 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("Alda_Moin")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P5 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("SoggyTacoZ")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P5 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getDisplayName().getString()).equals("TheseChatban")) {
			{
				boolean _setval = true;
				entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.P4 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

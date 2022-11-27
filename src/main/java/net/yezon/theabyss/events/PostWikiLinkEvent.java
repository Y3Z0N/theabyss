package net.yezon.theabyss.events;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class PostWikiLinkEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(
					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(),
							null).withSuppressedOutput(),
					("tellraw " + entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"The Abyss\",\"color\":\"aqua\"},{\"text\":\": Click \"},{\"text\":\"here\",\"color\":\"aqua\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://theabyssmod.fandom.com/wiki/The_Abyss_Chapter_II_Wiki\"}},{\"text\":\" to open the The Abyss: The Other Side Wiki.\"}]"));
	}
}

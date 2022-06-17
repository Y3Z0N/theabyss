package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class ApplyRingOfFireworkEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(TheabyssModItems.RING_OF_FIREWORK.get()))
				: false) {
			if (itemstack.getItem() == TheabyssModItems.RING_OF_FIREWORK.get()) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
									_level.getServer(), null).withSuppressedOutput(),
							"summon firework_rocket ~ ~ ~ {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2651799],FadeColors:[I;2651799]}],Flight:1}}}}");
			}
		}
	}
}

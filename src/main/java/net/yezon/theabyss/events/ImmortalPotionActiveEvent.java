package net.yezon.theabyss.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class ImmortalPotionActiveEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getAbilities().invulnerable = (true);
			_player.onUpdateAbilities();
		}
	}
}

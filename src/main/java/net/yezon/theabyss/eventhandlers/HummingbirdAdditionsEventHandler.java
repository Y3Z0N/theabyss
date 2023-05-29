package net.yezon.theabyss.eventhandlers;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class HummingbirdAdditionsEventHandler {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.05) {
			{
				Entity _ent = entity;
				_ent.teleportTo((x + 1), (y + 2), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((x + 1), (y + 2), z, _ent.getYRot(), _ent.getXRot());
			}
		} else if (Math.random() < 0.05) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + 1), (z + 1));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 1), (z + 1), _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}

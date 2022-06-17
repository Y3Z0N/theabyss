package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModParticleTypes;
import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.entity.MutatedEnderpearlEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Random;

public class ApplyRingOfTeleportEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(TheabyssModItems.RING_OF_TELEPORT.get()))
				: false) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana < 20
							* (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("you don't have enough \u00A7benergy"), (true));
			} else {
				if (itemstack.getItem() == TheabyssModItems.RING_OF_TELEPORT.get()) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(),
								(int) (80 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TheabyssModVariables.PlayerVariables())).ManaCooldown));
					if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
						MutatedEnderpearlEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 10,
								(float) (0.5 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TheabyssModVariables.PlayerVariables())).ManaDamage),
								0);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TheabyssModParticleTypes.END_SWORD_PT.get()), x, y, z, 10, 0, 1, 0, 1);
				}
				{
					double _setval = (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TheabyssModVariables.PlayerVariables())).Mana
							- 20 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade;
					entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}

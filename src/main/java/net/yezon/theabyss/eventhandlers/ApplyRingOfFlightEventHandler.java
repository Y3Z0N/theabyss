package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.network.chat.Component;

public class ApplyRingOfFlightEventHandler {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.RING_OF_FLIGHT.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.RING_OF_FLIGHT.get()) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).Mana < 0.5
					* (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof Player _player) {
					_player.getAbilities().flying = (false);
					_player.onUpdateAbilities();
				}
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("ring.theabyss.low_energy").getString())), (true));
			} else {
				if (itemstack.getItem() == TheabyssModItems.RING_OF_FLIGHT.get()) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt((int) 0.0001, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				if (entity instanceof Player _player) {
					_player.getAbilities().flying = (true);
					_player.onUpdateAbilities();
				}
				{
					double _setval = (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).Mana
							- 0.5 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade;
					entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.RING_OF_FLIGHT.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.RING_OF_FLIGHT.get())) {
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = (false);
				_player.onUpdateAbilities();
			}
		}
	}
}

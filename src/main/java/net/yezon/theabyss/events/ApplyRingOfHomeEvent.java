package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class ApplyRingOfHomeevent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(TheabyssModItems.RING_OF_HOME.get()))
				: false) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).RingOfHome == true) {
				if (!((entity.level.dimension()) == (Level.OVERWORLD))) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("ring.theabyss.overworld").getString())), (true));
				} else {
					if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TheabyssModVariables.PlayerVariables())).Mana < 50
									* (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade) {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("ring.theabyss.low_energy").getString())), (true));
					} else {
						if (itemstack.getItem() == TheabyssModItems.RING_OF_HOME.get()) {
							{
								ItemStack _ist = itemstack;
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(),
									(int) (1500 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).ManaCooldown));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_teleport")),
										SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_teleport")),
										SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							Entity _ent = entity;
							_ent.teleportTo(
									((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).HomeX),
									((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).HomeY),
									((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).HomeZ));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(
										((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new TheabyssModVariables.PlayerVariables())).HomeX),
										((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new TheabyssModVariables.PlayerVariables())).HomeY),
										((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new TheabyssModVariables.PlayerVariables())).HomeZ),
										_ent.getYRot(), _ent.getXRot());
						}
						{
							double _setval = (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).Mana
									- 50 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
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
	}
}

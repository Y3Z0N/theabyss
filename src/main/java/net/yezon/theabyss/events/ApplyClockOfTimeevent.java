package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class ApplyClockOfTimeevent {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem && _playerHasItem.getInventory().contains(new ItemStack(TheabyssModItems.CLOCK_OF_TIME.get()))) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana < 50
							* (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade) {
				Player _player = (Player) entity;
				if (!_player.level.isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("ring.theabyss.low_energy").getString())), (true));
			} else {
				if (!(entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).ClockActive) {
					if (itemstack.getItem() == TheabyssModItems.CLOCK_OF_TIME.get()) {
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
					{
						double _setval = Math.round(entity.getX());
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockX = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Math.round(entity.getY());
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockY = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Math.round(entity.getZ());
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockZ = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Math.round(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SaveHP = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Math.round(entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0);
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SaveFD = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockActive = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("ring.theabyss.timestamp").getString())), (true));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7btimestamp \u00A7fcreated!"), (false));
				} else {
					if (itemstack.getItem() == TheabyssModItems.CLOCK_OF_TIME.get()) {
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
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
					if (entity instanceof Player _player)
						_player.getFoodData().setFoodLevel((int) (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new TheabyssModVariables.PlayerVariables())).SaveFD);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new TheabyssModVariables.PlayerVariables())).SaveHP);
					{
						Entity _ent = entity;
						_ent.teleportTo(
								((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TheabyssModVariables.PlayerVariables())).ClockX),
								((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TheabyssModVariables.PlayerVariables())).ClockY),
								((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TheabyssModVariables.PlayerVariables())).ClockZ));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(
									((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).ClockX),
									((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).ClockY),
									((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new TheabyssModVariables.PlayerVariables())).ClockZ),
									_ent.getYRot(), _ent.getXRot());
					}
					{
						boolean _setval = false;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockActive = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_teleport")), SoundSource.NEUTRAL, 1,
									1);
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_teleport")), SoundSource.NEUTRAL, 1,
									1, false);
						}
					}
				}
			}
		}
	}
}

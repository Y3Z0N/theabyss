package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.entity.RingOfFireStrikeAttackEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class ApplyRingOfFirestrikeEvent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(TheabyssModItems.RING_OF_FIRESTRIKE.get()))
				: false) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana < 25
							* (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("you don't have enough \u00A7benergy"), (true));
			} else {
				if (itemstack.getItem() == TheabyssModItems.RING_OF_FIRESTRIKE.get()) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(),
							(int) (20 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaCooldown));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_fire")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_fire")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
					RingOfFireStrikeAttackEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), (float) 1.5,
							(float) (3 + (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaDamage),
							2);
				}
				{
					double _setval = (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TheabyssModVariables.PlayerVariables())).Mana
							- 25 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
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

package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;
import java.util.Map;

public class ResearchTableHandlerEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) > 5) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModBlocks.CRIMSON_CRYSTAL_ORE.get().asItem()) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).CrimsonCrystalResearch == false) {
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CrimsonCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_research").getString())),
								(false));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_researched").getString())),
								(false));
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModBlocks.WARPED_CRYSTAL_ORE.get().asItem()) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).WarpedCrystalResearch == false) {
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.WarpedCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_research").getString())),
								(false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_researched").getString())),
								(false));
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModBlocks.FROST_CRYSTAL_ORE.get().asItem()) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).FrostCrystalResearch == false) {
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FrostCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_research").getString())),
								(false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_researched").getString())),
								(false));
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModBlocks.ABYSS_CRYSTAL_ORE.get().asItem()) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).AbyssCrystalResearch == false) {
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AbyssCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_research").getString())),
								(false));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_researched").getString())),
								(false));
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModBlocks.HOLLOW_CRYSTAL_ORE.get().asItem()) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).HollowCrystalResearch == false) {
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.HollowCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_research").getString())),
								(false));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_researched").getString())),
								(false));
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModBlocks.ENDER_CRYSTAL_ORE.get().asItem()) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).EnderCrystalResearch == false) {
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.EnderCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_research").getString())),
								(false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_researched").getString())),
								(false));
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModBlocks.CAVERNA_CRYSTAL_ORE.get().asItem()) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).CavernaCrystalResearch == false) {
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CavernaCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_research").getString())),
								(false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_researched").getString())),
								(false));
				}
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModBlocks.AUREL_CRYSTAL_ORE.get().asItem()) {
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).AurelCrystalResearch == false) {
					{
						boolean _setval = true;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AurelCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_research").getString())),
								(false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_researched").getString())),
								(false));
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("note.theabyss.crystal_no_xp").getString())), (false));
		}
	}
}

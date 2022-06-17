package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModBlocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;

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
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You researched the Crimson Crystal! This crystal consists of 50% lava, 20% air and 30% obsidian. It can be used for rings that need the energy of fire."),
								(false));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Crimson Crystal! This crystal consists of 50% lava, 20% air and 30% obsidian. It can be used for rings that need the energy of fire."),
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
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You researched the Warped Crystal! This crystal consists of 10% lava, 40% air and 50% earth. It can be used for rings that need the energy of healing."),
								(false));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Warped Crystal! This crystal consists of 10% lava, 40% air and 50% earth. It can be used for rings that need the energy of healing."),
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
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You researched the Frost Crystal! This crystal consists of 80% ice, 10% air and 10% organs. It can be used for rings that need the energy of frost."),
								(false));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Frost Crystal! This crystal consists of 80% ice, 10% air and 10% organs. It can be used for rings that need the energy of frost."),
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
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You researched the Abyss Crystal! This crystal consists of 60% souls, 20% organs and 20% loran energy. It can be used for rings that need the energy of souls."),
								(false));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Abyss Crystal! This crystal consists of 60% souls, 20% organs and 20% loran energy. It can be used for rings that need the energy of souls."),
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
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You researched the Hollow Crystal! This crystal consists of 40% souls, 40% venom and 20% phantom aura. It can be used for rings that need the energy of curse."),
								(false));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Hollow Crystal! This crystal consists of 40% souls, 40% venom and 20% phantom aura. It can be used for rings that need the energy of curse."),
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
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You researched the Ender Crystal! This crystal consists of 60% ender aura, 10% poison and 30% dragon aura. It can be used for rings that need the energy of wandering."),
								(false));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Ender Crystal! This crystal consists of 60% ender aura, 10% poison and 30% dragon aura. It can be used for rings that need the energy of wandering."),
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
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You researched the Caverna Crystal! This crystal consists of 20% cave aura, 10% poison and 30% magma aura. It can be used for rings that need the energy of darkness."),
								(false));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Caverna Crystal! This crystal consists of 20% cave aura, 10% poison and 30% magma aura. It can be used for rings that need the energy of darkness."),
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
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You researched the Aurel Crystal! This crystal consists of 20% cave aura, 70% light and 10% poison aura. It can be used for rings that need the energy of light."),
								(false));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					if (entity instanceof Player _player)
						_player.giveExperienceLevels(-(5));
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(20);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Aurel Crystal! This crystal consists of 20% cave aura, 70% light and 10% poison aura. It can be used for rings that need the energy of light."),
								(false));
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7bResearch:\u00A7f You don't have enough XP Levels to research this!"), (false));
		}
	}
}

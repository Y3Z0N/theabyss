package net.yezon.theabyss.events;

import net.yezon.theabyss.block.WarpedCrystalOreBlock;
import net.yezon.theabyss.block.HollowCrystalOreBlock;
import net.yezon.theabyss.block.FrostCrystalOreBlock;
import net.yezon.theabyss.block.EnderCrystalOreBlock;
import net.yezon.theabyss.block.CrimsonCrystalOreBlock;
import net.yezon.theabyss.block.CavernaCrystalOreBlock;
import net.yezon.theabyss.block.AurelCrystalOreBlock;
import net.yezon.theabyss.block.AbyssCrystalOreBlock;
import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class ResearchTableHandlerEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event ResearchTableHandler!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) > 5) {
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == CrimsonCrystalOreBlock.block.asItem()) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).CrimsonCrystalResearch == false) {
					{
						boolean _setval = (true);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CrimsonCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You researched the Crimson Crystal! This crystal consists of 50% lava, 20% air and 30% obsidian. It can be used for rings that need the energy of fire."),
								(false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 20);
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).addExperienceLevel(-((int) 5));
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Crimson Crystal! This crystal consists of 50% lava, 20% air and 30% obsidian. It can be used for rings that need the energy of fire."),
								(false));
					}
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == WarpedCrystalOreBlock.block.asItem()) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).WarpedCrystalResearch == false) {
					{
						boolean _setval = (true);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.WarpedCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You researched the Warped Crystal! This crystal consists of 10% lava, 40% air and 50% earth. It can be used for rings that need the energy of healing."),
								(false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).addExperienceLevel(-((int) 5));
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Warped Crystal! This crystal consists of 10% lava, 40% air and 50% earth. It can be used for rings that need the energy of healing."),
								(false));
					}
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == FrostCrystalOreBlock.block.asItem()) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).FrostCrystalResearch == false) {
					{
						boolean _setval = (true);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FrostCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You researched the Frost Crystal! This crystal consists of 80% ice, 10% air and 10% organs. It can be used for rings that need the energy of frost."),
								(false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).addExperienceLevel(-((int) 5));
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Frost Crystal! This crystal consists of 80% ice, 10% air and 10% organs. It can be used for rings that need the energy of frost."),
								(false));
					}
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == AbyssCrystalOreBlock.block.asItem()) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).AbyssCrystalResearch == false) {
					{
						boolean _setval = (true);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AbyssCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You researched the Abyss Crystal! This crystal consists of 60% souls, 20% organs and 20% loran energy. It can be used for rings that need the energy of souls."),
								(false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 20);
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).addExperienceLevel(-((int) 5));
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Abyss Crystal! This crystal consists of 60% souls, 20% organs and 20% loran energy. It can be used for rings that need the energy of souls."),
								(false));
					}
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == HollowCrystalOreBlock.block.asItem()) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).HollowCrystalResearch == false) {
					{
						boolean _setval = (true);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.HollowCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You researched the Hollow Crystal! This crystal consists of 40% souls, 40% venom and 20% phantom aura. It can be used for rings that need the energy of curse."),
								(false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 20);
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).addExperienceLevel(-((int) 5));
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Hollow Crystal! This crystal consists of 40% souls, 40% venom and 20% phantom aura. It can be used for rings that need the energy of curse."),
								(false));
					}
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == EnderCrystalOreBlock.block.asItem()) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).EnderCrystalResearch == false) {
					{
						boolean _setval = (true);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.EnderCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You researched the Ender Crystal! This crystal consists of 60% ender aura, 10% poison and 30% dragon aura. It can be used for rings that need the energy of wandering."),
								(false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).addExperienceLevel(-((int) 5));
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Ender Crystal! This crystal consists of 60% ender aura, 10% poison and 30% dragon aura. It can be used for rings that need the energy of wandering."),
								(false));
					}
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == CavernaCrystalOreBlock.block.asItem()) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).CavernaCrystalResearch == false) {
					{
						boolean _setval = (true);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CavernaCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You researched the Caverna Crystal! This crystal consists of 20% cave aura, 10% poison and 30% magma aura. It can be used for rings that need the energy of darkness."),
								(false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).addExperienceLevel(-((int) 5));
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Caverna Crystal! This crystal consists of 20% cave aura, 10% poison and 30% magma aura. It can be used for rings that need the energy of darkness."),
								(false));
					}
				}
			}
			if ((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getItem() == AurelCrystalOreBlock.block.asItem()) {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).AurelCrystalResearch == false) {
					{
						boolean _setval = (true);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AurelCrystalResearch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You researched the Aurel Crystal! This crystal consists of 20% cave aura, 70% light and 10% poison aura. It can be used for rings that need the energy of light."),
								(false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A7bResearch:\u00A7f You can now process this crystal in a crystal cutter!"), (false));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).addExperienceLevel(-((int) 5));
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A7bResearch:\u00A7f You already researched the Aurel Crystal! This crystal consists of 20% cave aura, 70% light and 10% poison aura. It can be used for rings that need the energy of light."),
								(false));
					}
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("\u00A7bResearch:\u00A7f You don't have enough XP Levels to research this!"), (false));
			}
		}
	}
}

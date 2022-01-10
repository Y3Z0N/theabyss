package net.yezon.theabyss.events;

import net.yezon.theabyss.item.WarpedCrystalItem;
import net.yezon.theabyss.item.HollowCrystalItem;
import net.yezon.theabyss.item.FrostCrystalItem;
import net.yezon.theabyss.item.EndCrystalItem;
import net.yezon.theabyss.item.CrimsonCrystalItem;
import net.yezon.theabyss.item.AbyssCrystalItem;
import net.yezon.theabyss.Capabilities;
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
			}.getItemStack((int) (0))).getItem() == CrimsonCrystalItem.block) {
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
			}.getItemStack((int) (0))).getItem() == WarpedCrystalItem.block) {
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
			}.getItemStack((int) (0))).getItem() == FrostCrystalItem.block) {
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
			}.getItemStack((int) (0))).getItem() == AbyssCrystalItem.block) {
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
			}.getItemStack((int) (0))).getItem() == HollowCrystalItem.block) {
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
			}.getItemStack((int) (0))).getItem() == EndCrystalItem.block) {
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
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("\u00A7bResearch:\u00A7f You don't have enough XP Levels to research this!"), (false));
			}
		}
	}
}

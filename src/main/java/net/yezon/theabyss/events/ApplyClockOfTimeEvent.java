package net.yezon.theabyss.events;

import net.yezon.theabyss.item.ClockOfTimeItem;
import net.yezon.theabyss.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;
import java.util.Collections;

public class ApplyClockOfTimeEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheabyssMod.LOGGER.warn("Failed to load dependency itemstack for Event ApplyClockOfTime!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ClockOfTimeItem.block)) : false) {
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Mana < 50
							* (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("you don't have enough \u00A7benergy"), (true));
				}
			} else {
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).ClockActive == false) {
					if (itemstack.getItem() == ClockOfTimeItem.block) {
						{
							ItemStack _ist = itemstack;
							if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamage(0);
							}
						}
					}
					{
						double _setval = Math.round(entity.getPosX());
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockX = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Math.round(entity.getPosY());
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockY = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Math.round(entity.getPosZ());
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockZ = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Math.round((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SaveHP = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Math.round((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SaveFD = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = (true);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockActive = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7btimestamp \u00A7fcreated!"), (false));
					}
				} else {
					if (itemstack.getItem() == ClockOfTimeItem.block) {
						{
							ItemStack _ist = itemstack;
							if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamage(0);
							}
						}
					}
					{
						double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Capabilities.PlayerVariables())).Mana
								- 50 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new Capabilities.PlayerVariables())).ManaUpgrade);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getFoodStats()
								.setFoodLevel((int) ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new Capabilities.PlayerVariables())).SaveFD));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Capabilities.PlayerVariables())).SaveHP));
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(
								((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new Capabilities.PlayerVariables())).ClockX),
								((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new Capabilities.PlayerVariables())).ClockY),
								((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new Capabilities.PlayerVariables())).ClockZ));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(
									((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new Capabilities.PlayerVariables())).ClockX),
									((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new Capabilities.PlayerVariables())).ClockY),
									((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new Capabilities.PlayerVariables())).ClockZ),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
					{
						boolean _setval = (false);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ClockActive = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ())),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("theabyss:spell_of_teleport")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("theabyss:spell_of_teleport")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				}
			}
		}
	}
}

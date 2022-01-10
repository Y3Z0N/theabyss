package net.yezon.theabyss.events;

import net.yezon.theabyss.potion.CursedAuraPotionEffect;
import net.yezon.theabyss.potion.CursePotionEffect;
import net.yezon.theabyss.item.RingOfCurseItem;
import net.yezon.theabyss.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ApplyRingOfCurseEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheabyssMod.LOGGER.warn("Failed to load dependency itemstack for Event ApplyRingOfCurse!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RingOfCurseItem.block)) : false) {
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Mana < 50
							* (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("you don't have enough \u00A7benergy"), (true));
				}
			} else {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 300, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(CursedAuraPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
				if (itemstack.getItem() == RingOfCurseItem.block) {
					{
						ItemStack _ist = itemstack;
						if (_ist.attemptDamageItem((int) 4, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).FriendMode == true) {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (400 / 2d), y - (400 / 2d), z - (400 / 2d), x + (400 / 2d), y + (400 / 2d), z + (400 / 2d)),
								null).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (!(entityiterator instanceof PlayerEntity)) {
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator)
												.addPotionEffect(
														new EffectInstance(Effects.SLOWNESS, (int) 200,
																(int) (0 + (entity
																		.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
																		.orElse(new Capabilities.PlayerVariables())).ManaDamage),
																(false), (false)));
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator)
												.addPotionEffect(
														new EffectInstance(Effects.NAUSEA, (int) 100,
																(int) (1 + (entity
																		.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
																		.orElse(new Capabilities.PlayerVariables())).ManaDamage),
																(false), (false)));
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator)
												.addPotionEffect(
														new EffectInstance(Effects.WEAKNESS, (int) 300,
																(int) (0 + (entity
																		.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
																		.orElse(new Capabilities.PlayerVariables())).ManaDamage),
																(false), (false)));
									if (entityiterator instanceof LivingEntity)
										((LivingEntity) entityiterator)
												.addPotionEffect(
														new EffectInstance(CursePotionEffect.potion, (int) 300,
																(int) (0 + (entity
																		.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
																		.orElse(new Capabilities.PlayerVariables())).ManaDamage),
																(false), (false)));
								}
							}
						}
					}
				} else {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (400 / 2d), y - (400 / 2d), z - (400 / 2d), x + (400 / 2d), y + (400 / 2d), z + (400 / 2d)),
								null).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addPotionEffect(
													new EffectInstance(Effects.SLOWNESS, (int) 200,
															(int) (0 + (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new Capabilities.PlayerVariables())).ManaDamage),
															(false), (false)));
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addPotionEffect(
													new EffectInstance(Effects.NAUSEA, (int) 100,
															(int) (1 + (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new Capabilities.PlayerVariables())).ManaDamage),
															(false), (false)));
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addPotionEffect(
													new EffectInstance(Effects.WEAKNESS, (int) 300,
															(int) (0 + (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new Capabilities.PlayerVariables())).ManaDamage),
															(false), (false)));
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addPotionEffect(
													new EffectInstance(CursePotionEffect.potion, (int) 300,
															(int) (0 + (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new Capabilities.PlayerVariables())).ManaDamage),
															(false), (false)));
							}
						}
					}
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(),
							(int) (4000 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaCooldown));
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_ghost")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_ghost")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
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
			}
		}
	}
}

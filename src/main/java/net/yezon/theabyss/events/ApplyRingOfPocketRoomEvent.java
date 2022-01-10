package net.yezon.theabyss.events;

import net.yezon.theabyss.item.RingOfPocketBoxItem;
import net.yezon.theabyss.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Mirror;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.Random;
import java.util.Map;

public class ApplyRingOfPocketRoomEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheabyssMod.LOGGER.warn("Failed to load dependency itemstack for Event ApplyRingOfPocketRoom!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RingOfPocketBoxItem.block)) : false) {
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Mana < 50
							* (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("you don't have enough \u00A7benergy"), (true));
				}
			} else {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(),
							(int) (500 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaCooldown));
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_teleport")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:spell_of_teleport")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (itemstack.getItem() == RingOfPocketBoxItem.block) {
					{
						ItemStack _ist = itemstack;
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("theabyss:pocket_dimension")))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute in minecraft:overworld run tp " + entity.getDisplayName().getString() + " "
										+ Math.round((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new Capabilities.PlayerVariables())).SaveX)
										+ " "
										+ Math.round((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new Capabilities.PlayerVariables())).SaveY)
										+ " " + Math.round((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new Capabilities.PlayerVariables())).SaveZ)));
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					if (!((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).PocketDimension == true)) {
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
						{
							double _setval = Math.round(entity.getPosX());
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.round(entity.getPosY());
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveY = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.round(entity.getPosZ());
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveZ = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity)
											.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 80, (int) 0, (false), (false)));
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute in theabyss:pocket_dimension run tp " + entity.getDisplayName().getString() + " 0 2000 0"));
								}
								{
									boolean _setval = (true);
									entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PocketDimension = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (Capabilities.WorldVariables.get(world).PocketDimensionX + 9);
									entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PocketPlayerX = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 82;
									entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PocketPlayerY = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (Capabilities.WorldVariables.get(world).PocketDimensionZ + 9);
									entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PocketPlayerZ = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 1);
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								if (world instanceof ServerWorld) {
									IWorld _worldorig = world;
									world = ((ServerWorld) world).getServer().getWorld(
											RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("theabyss:pocket_dimension")));
									if (world != null) {
										if (world instanceof ServerWorld) {
											Template template = ((ServerWorld) world).getStructureTemplateManager()
													.getTemplateDefaulted(new ResourceLocation("theabyss", "pocket_room"));
											if (template != null) {
												template.func_237144_a_((ServerWorld) world, new BlockPos(
														(int) Math.round(Capabilities.WorldVariables.get(world).PocketDimensionX), (int) 80,
														(int) Math.round(Capabilities.WorldVariables.get(world).PocketDimensionZ)),
														new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
																.setIgnoreEntities(false),
														((World) world).rand);
											}
										}
										Capabilities.WorldVariables.get(world).PocketDimensionX = (Math
												.round(Capabilities.WorldVariables.get(world).PocketDimensionX) + Math.round(20));
										Capabilities.WorldVariables.get(world).syncData(world);
									}
									world = _worldorig;
								}
								Capabilities.WorldVariables.get(world).PocketDimensionX = (Math
										.round(Capabilities.WorldVariables.get(world).PocketDimensionX) + Math.round(20));
								Capabilities.WorldVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 4);
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute in theabyss:pocket_dimension run tp " + entity.getDisplayName().getString() + " "
													+ Math.round((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new Capabilities.PlayerVariables())).PocketPlayerX)
													+ " 82 "
													+ Math.round((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new Capabilities.PlayerVariables())).PocketPlayerZ)));
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 6);
					} else {
						{
							double _setval = Math.round(entity.getPosX());
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.round(entity.getPosY());
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveY = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = Math.round(entity.getPosZ());
							entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SaveZ = _setval;
								capability.syncPlayerVariables(entity);
							});
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
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute in theabyss:pocket_dimension run tp " + entity.getDisplayName().getString() + " "
													+ Math.round((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new Capabilities.PlayerVariables())).PocketPlayerX)
													+ " 82 "
													+ Math.round((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new Capabilities.PlayerVariables())).PocketPlayerZ)));
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 2);
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("you have to be in overworld to do this"), (false));
					}
				}
			}
		}
	}
}

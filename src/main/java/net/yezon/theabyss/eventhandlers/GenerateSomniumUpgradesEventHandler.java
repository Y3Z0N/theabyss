package net.yezon.theabyss.eventhandlers;

import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;

public class GenerateSomniumUpgradesEventHandler {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.LORAN_ENERGY
					.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.ROKA_HORN
						.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.NODE_SHARD.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.PHANTOM_SOUL_ITEM.get()) {
							if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
									.getItem() == TheabyssModItems.SOUL_HEART.get()) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 16)) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(1)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(2)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(3)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(4)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(6)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									{
										ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY);
										if (_ist.hurt(8, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(TheabyssModItems.SOMNIUM_UPGRADE.get());
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1));
										((Slot) _slots.get(0)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.LORAN_ENERGY
					.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.ROKA_HORN
						.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.PHANTOM_ESSENCE.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
							if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
									.getItem() == TheabyssModItems.INFECTED_SLIME.get()) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 16)) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(1)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(2)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(3)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(4)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(6)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									{
										ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY);
										if (_ist.hurt(8, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(TheabyssModItems.SOMNIUM_REGEN_UPGRADE.get());
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1));
										((Slot) _slots.get(0)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.LORAN_ENERGY
					.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.ROKA_HORN
						.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.ROKA_HORN.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.ROKA_HORN.get()) {
							if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
									.getItem() == TheabyssModItems.ROKA_HORN.get()) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 16)) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(1)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(2)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(3)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(4)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(6)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									{
										ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY);
										if (_ist.hurt(8, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(TheabyssModItems.ANTI_FEAR_ESSENCE.get());
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1));
										((Slot) _slots.get(0)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.LORAN_ENERGY
					.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.ROKA_HORN
						.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.ELDER_EYE.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.CRYSTAL_HAND.get()) {
							if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
									.getItem() == TheabyssModItems.CREEPER_DUST.get()) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 16)) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(1)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(2)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(3)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(4)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(6)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									{
										ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY);
										if (_ist.hurt(8, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(TheabyssModItems.SOMNIUM_DAMAGE_UPRAGDE.get());
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1));
										((Slot) _slots.get(0)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.LORAN_ENERGY
					.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.CRYSTAL_HAND
						.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.NODE_SHARD.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.CRYSTAL_HAND.get()) {
							if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
									.getItem() == TheabyssModItems.NODE_SHARD.get()) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 16)) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(1)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(2)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(3)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(4)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(6)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									{
										ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY);
										if (_ist.hurt(8, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(TheabyssModItems.SOMNIUM_COOLDOWN_UPGRADE.get());
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1));
										((Slot) _slots.get(0)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.LORAN_ENERGY
					.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.APPLE_OF_IMMORTALITY.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Items.APPLE) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.APPLE_OF_IMMORTALITY.get()) {
							if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Items.APPLE) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 16)) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(1)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(2)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(3)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(4)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(6)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									{
										ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY);
										if (_ist.hurt(8, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(TheabyssModItems.IMMORTAL_SUBSTANCE.get());
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1));
										((Slot) _slots.get(0)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.LORAN_ENERGY
					.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.ROTTEN_FLESH
						.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.ROTTEN_FLESH.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.ROTTEN_FLESH.get()) {
							if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
									.getItem() == TheabyssModItems.ROTTEN_FLESH.get()) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 16)) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(1)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(2)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(3)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(4)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(6)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									{
										ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY);
										if (_ist.hurt(8, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(TheabyssModItems.ANTI_INFECT_ESSENCE.get());
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1));
										((Slot) _slots.get(0)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(6)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == TheabyssModItems.LORAN_ENERGY
					.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.LURKER_SOBBER.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.LURKER_SOBBER.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.LURKER_SOBBER.get()) {
							if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
									.getItem() == TheabyssModItems.LURKER_SOBBER.get()) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) == 16)) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(1)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(2)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(3)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(4)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										((Slot) _slots.get(6)).remove(1);
										_player.containerMenu.broadcastChanges();
									}
									{
										ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY);
										if (_ist.hurt(8, RandomSource.create(), null)) {
											_ist.shrink(1);
											_ist.setDamageValue(0);
										}
									}
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack _setstack = new ItemStack(TheabyssModItems.LURKER_JUICE.get());
										_setstack.setCount((int) (new Object() {
											public int getAmount(int sltid) {
												if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
													ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
													if (stack != null)
														return stack.getCount();
												}
												return 0;
											}
										}.getAmount(0) + 1));
										((Slot) _slots.get(0)).set(_setstack);
										_player.containerMenu.broadcastChanges();
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

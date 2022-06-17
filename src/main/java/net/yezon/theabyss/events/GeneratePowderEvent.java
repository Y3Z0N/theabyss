package net.yezon.theabyss.events;

import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;

public class GeneratePowderEvent {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.ABYSS_CRYSTAL_SHARD.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.ABYSS_CRYSTAL_SHARD.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.ABYSS_CRYSTAL_SHARD.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.ABYSS_CRYSTAL_SHARD.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.ABYSS_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.AUREL_CRYSTAL_SHARD.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.AUREL_CRYSTAL_SHARD.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.AUREL_CRYSTAL_SHARD.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.AUREL_CRYSTAL_SHARD.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.AUREL_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.CAVERNA_CRYSTAL.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.CAVERNA_CRYSTAL.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.CAVERNA_CRYSTAL.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.CAVERNA_CRYSTAL.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.CAVERNA_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.CRIMSON_CRYSTAL_SHARD.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.CRIMSON_CRYSTAL_SHARD.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.CRIMSON_CRYSTAL_SHARD.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.CRIMSON_CRYSTAL_SHARD.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.CRIMSON_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.ENDER_CRYSTAL_SHARD.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.ENDER_CRYSTAL_SHARD.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.ENDER_CRYSTAL_SHARD.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.ENDER_CRYSTAL_SHARD.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.ENDER_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.FROST_CRYSTAL_SHARD.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.FROST_CRYSTAL_SHARD.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.FROST_CRYSTAL_SHARD.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.FROST_CRYSTAL_SHARD.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.FROST_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.HOLLOW_CRYSTAL_SHARD.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.HOLLOW_CRYSTAL_SHARD.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.HOLLOW_CRYSTAL_SHARD.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.HOLLOW_CRYSTAL_SHARD.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.HOLLOW_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.WARPED_CRYSTAL_SHARD.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.WARPED_CRYSTAL_SHARD.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.WARPED_CRYSTAL_SHARD.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.WARPED_CRYSTAL_SHARD.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.WARPED_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.ANTI_FEAR_ESSENCE.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.ROKA_HORN.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.ROKA_HORN.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.ROKA_HORN.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.ROKA_HORN.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.WARPED_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.VITAE_STONE.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.VITAE_STONE.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.VITAE_STONE.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.VITAE_STONE.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.VIT_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.BOTTLE_OF_SOMNIUM.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.LORAN.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.VITAE_DUST.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.LORAN.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.VITAE_DUST.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.ARDOR_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(5)).getItem()
				: ItemStack.EMPTY).getItem() == TheabyssModItems.ANTI_FEAR_ESSENCE.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == TheabyssModItems.CAVERNA_POWDER.get()) {
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
						.getItem() == TheabyssModItems.ROKA_HORN.get()) {
					if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
							.getItem() == TheabyssModItems.CAVERNA_POWDER.get()) {
						if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
								&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
								.getItem() == TheabyssModItems.ROKA_HORN.get()) {
							if (!(new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
											&& _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(0) == 16)) {
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(3)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(4)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									((Slot) _slots.get(5)).remove(1);
									_player.containerMenu.broadcastChanges();
								}
								{
									ItemStack _ist = (entity instanceof ServerPlayer _plrSlotItem
											&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
													? ((Slot) _slt.get(5)).getItem()
													: ItemStack.EMPTY);
									if (_ist.hurt(8, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
										&& _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(TheabyssModItems.TENEBRIS_POWDER.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
													&& _current.get() instanceof Map _slots) {
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
							}
						}
					}
				}
			}
		}
	}
}

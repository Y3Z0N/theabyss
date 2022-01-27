package net.yezon.theabyss.events;

import net.yezon.theabyss.item.SoulHeartItem;
import net.yezon.theabyss.item.SomniumUpgradeItem;
import net.yezon.theabyss.item.SomniumRegenUpgradeItem;
import net.yezon.theabyss.item.SomniumItem;
import net.yezon.theabyss.item.SomniumDamageUpragdeItem;
import net.yezon.theabyss.item.SomniumCooldownUpgradeItem;
import net.yezon.theabyss.item.SlimeStage4Item;
import net.yezon.theabyss.item.RottenFleshItem;
import net.yezon.theabyss.item.RokaHornItem;
import net.yezon.theabyss.item.PhantomSoulItemItem;
import net.yezon.theabyss.item.PhantomEssenceItem;
import net.yezon.theabyss.item.NodeShardItem;
import net.yezon.theabyss.item.LurkerSobberItem;
import net.yezon.theabyss.item.LurkerJuiceItem;
import net.yezon.theabyss.item.LoranEnergyItem;
import net.yezon.theabyss.item.ImmortalSubstanceItem;
import net.yezon.theabyss.item.ElderEyeItem;
import net.yezon.theabyss.item.CrystalHandItem;
import net.yezon.theabyss.item.CreeperDustItem;
import net.yezon.theabyss.item.BottleOfSomniumItem;
import net.yezon.theabyss.item.AppleOfImmortalityItem;
import net.yezon.theabyss.item.AntiInfectEssenceItem;
import net.yezon.theabyss.item.AntiFearEssenceItem;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;

public class GenerateSomniumUpgradesEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event GenerateSomniumUpgrades!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
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
		}.getItemStack((int) (6))).getItem() == SomniumItem.block) {
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
			}.getItemStack((int) (5))).getItem() == LoranEnergyItem.block) {
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
				}.getItemStack((int) (1))).getItem() == RokaHornItem.block) {
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
					}.getItemStack((int) (2))).getItem() == NodeShardItem.block) {
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
						}.getItemStack((int) (3))).getItem() == PhantomSoulItemItem.block) {
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
							}.getItemStack((int) (4))).getItem() == SoulHeartItem.block) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0)) == 16)) {
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (3))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (4))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (6))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										ItemStack _ist = (new Object() {
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
										}.getItemStack((int) (5)));
										if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									if (entity instanceof PlayerEntity) {
										Container _current = ((PlayerEntity) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												ItemStack _setstack = new ItemStack(SomniumUpgradeItem.block);
												_setstack.setCount((int) (new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof ServerPlayerEntity) {
															Container _current = ((ServerPlayerEntity) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
																	if (stack != null)
																		return stack.getCount();
																}
															}
														}
														return 0;
													}
												}.getAmount((int) (0)) + 1));
												((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
												_current.detectAndSendChanges();
											}
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1, false);
									}
								}
							}
						}
					}
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
		}.getItemStack((int) (6))).getItem() == SomniumItem.block) {
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
			}.getItemStack((int) (5))).getItem() == LoranEnergyItem.block) {
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
				}.getItemStack((int) (1))).getItem() == RokaHornItem.block) {
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
					}.getItemStack((int) (2))).getItem() == PhantomEssenceItem.block) {
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
						}.getItemStack((int) (3))).getItem() == BottleOfSomniumItem.block) {
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
							}.getItemStack((int) (4))).getItem() == SlimeStage4Item.block) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0)) == 16)) {
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (3))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (4))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (6))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										ItemStack _ist = (new Object() {
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
										}.getItemStack((int) (5)));
										if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									if (entity instanceof PlayerEntity) {
										Container _current = ((PlayerEntity) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												ItemStack _setstack = new ItemStack(SomniumRegenUpgradeItem.block);
												_setstack.setCount((int) (new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof ServerPlayerEntity) {
															Container _current = ((ServerPlayerEntity) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
																	if (stack != null)
																		return stack.getCount();
																}
															}
														}
														return 0;
													}
												}.getAmount((int) (0)) + 1));
												((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
												_current.detectAndSendChanges();
											}
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1, false);
									}
								}
							}
						}
					}
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
		}.getItemStack((int) (6))).getItem() == SomniumItem.block) {
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
			}.getItemStack((int) (5))).getItem() == LoranEnergyItem.block) {
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
				}.getItemStack((int) (1))).getItem() == RokaHornItem.block) {
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
					}.getItemStack((int) (2))).getItem() == RokaHornItem.block) {
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
						}.getItemStack((int) (3))).getItem() == RokaHornItem.block) {
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
							}.getItemStack((int) (4))).getItem() == RokaHornItem.block) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0)) == 16)) {
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (3))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (4))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (6))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										ItemStack _ist = (new Object() {
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
										}.getItemStack((int) (5)));
										if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									if (entity instanceof PlayerEntity) {
										Container _current = ((PlayerEntity) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												ItemStack _setstack = new ItemStack(AntiFearEssenceItem.block);
												_setstack.setCount((int) (new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof ServerPlayerEntity) {
															Container _current = ((ServerPlayerEntity) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
																	if (stack != null)
																		return stack.getCount();
																}
															}
														}
														return 0;
													}
												}.getAmount((int) (0)) + 1));
												((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
												_current.detectAndSendChanges();
											}
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1, false);
									}
								}
							}
						}
					}
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
		}.getItemStack((int) (6))).getItem() == SomniumItem.block) {
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
			}.getItemStack((int) (5))).getItem() == LoranEnergyItem.block) {
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
				}.getItemStack((int) (1))).getItem() == RokaHornItem.block) {
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
					}.getItemStack((int) (2))).getItem() == ElderEyeItem.block) {
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
						}.getItemStack((int) (3))).getItem() == CrystalHandItem.block) {
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
							}.getItemStack((int) (4))).getItem() == CreeperDustItem.block) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0)) == 16)) {
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (3))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (4))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (6))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										ItemStack _ist = (new Object() {
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
										}.getItemStack((int) (5)));
										if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									if (entity instanceof PlayerEntity) {
										Container _current = ((PlayerEntity) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												ItemStack _setstack = new ItemStack(SomniumDamageUpragdeItem.block);
												_setstack.setCount((int) (new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof ServerPlayerEntity) {
															Container _current = ((ServerPlayerEntity) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
																	if (stack != null)
																		return stack.getCount();
																}
															}
														}
														return 0;
													}
												}.getAmount((int) (0)) + 1));
												((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
												_current.detectAndSendChanges();
											}
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1, false);
									}
								}
							}
						}
					}
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
		}.getItemStack((int) (6))).getItem() == SomniumItem.block) {
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
			}.getItemStack((int) (5))).getItem() == LoranEnergyItem.block) {
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
				}.getItemStack((int) (1))).getItem() == CrystalHandItem.block) {
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
					}.getItemStack((int) (2))).getItem() == NodeShardItem.block) {
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
						}.getItemStack((int) (3))).getItem() == CrystalHandItem.block) {
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
							}.getItemStack((int) (4))).getItem() == NodeShardItem.block) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0)) == 16)) {
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (3))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (4))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (6))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										ItemStack _ist = (new Object() {
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
										}.getItemStack((int) (5)));
										if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									if (entity instanceof PlayerEntity) {
										Container _current = ((PlayerEntity) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												ItemStack _setstack = new ItemStack(SomniumCooldownUpgradeItem.block);
												_setstack.setCount((int) (new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof ServerPlayerEntity) {
															Container _current = ((ServerPlayerEntity) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
																	if (stack != null)
																		return stack.getCount();
																}
															}
														}
														return 0;
													}
												}.getAmount((int) (0)) + 1));
												((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
												_current.detectAndSendChanges();
											}
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1, false);
									}
								}
							}
						}
					}
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
		}.getItemStack((int) (6))).getItem() == SomniumItem.block) {
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
			}.getItemStack((int) (5))).getItem() == LoranEnergyItem.block) {
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
				}.getItemStack((int) (1))).getItem() == AppleOfImmortalityItem.block) {
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
					}.getItemStack((int) (2))).getItem() == Items.APPLE) {
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
						}.getItemStack((int) (3))).getItem() == AppleOfImmortalityItem.block) {
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
							}.getItemStack((int) (4))).getItem() == Items.APPLE) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0)) == 16)) {
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (3))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (4))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (6))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										ItemStack _ist = (new Object() {
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
										}.getItemStack((int) (5)));
										if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									if (entity instanceof PlayerEntity) {
										Container _current = ((PlayerEntity) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												ItemStack _setstack = new ItemStack(ImmortalSubstanceItem.block);
												_setstack.setCount((int) (new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof ServerPlayerEntity) {
															Container _current = ((ServerPlayerEntity) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
																	if (stack != null)
																		return stack.getCount();
																}
															}
														}
														return 0;
													}
												}.getAmount((int) (0)) + 1));
												((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
												_current.detectAndSendChanges();
											}
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1, false);
									}
								}
							}
						}
					}
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
		}.getItemStack((int) (6))).getItem() == SomniumItem.block) {
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
			}.getItemStack((int) (5))).getItem() == LoranEnergyItem.block) {
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
				}.getItemStack((int) (1))).getItem() == RottenFleshItem.block) {
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
					}.getItemStack((int) (2))).getItem() == RottenFleshItem.block) {
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
						}.getItemStack((int) (3))).getItem() == RottenFleshItem.block) {
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
							}.getItemStack((int) (4))).getItem() == RottenFleshItem.block) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0)) == 16)) {
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (3))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (4))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (6))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										ItemStack _ist = (new Object() {
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
										}.getItemStack((int) (5)));
										if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									if (entity instanceof PlayerEntity) {
										Container _current = ((PlayerEntity) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												ItemStack _setstack = new ItemStack(AntiInfectEssenceItem.block);
												_setstack.setCount((int) (new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof ServerPlayerEntity) {
															Container _current = ((ServerPlayerEntity) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
																	if (stack != null)
																		return stack.getCount();
																}
															}
														}
														return 0;
													}
												}.getAmount((int) (0)) + 1));
												((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
												_current.detectAndSendChanges();
											}
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1, false);
									}
								}
							}
						}
					}
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
		}.getItemStack((int) (6))).getItem() == SomniumItem.block) {
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
			}.getItemStack((int) (5))).getItem() == LoranEnergyItem.block) {
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
				}.getItemStack((int) (1))).getItem() == LurkerSobberItem.block) {
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
					}.getItemStack((int) (2))).getItem() == LurkerSobberItem.block) {
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
						}.getItemStack((int) (3))).getItem() == LurkerSobberItem.block) {
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
							}.getItemStack((int) (4))).getItem() == LurkerSobberItem.block) {
								if (!(new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) entity).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
													if (stack != null)
														return stack.getCount();
												}
											}
										}
										return 0;
									}
								}.getAmount((int) (0)) == 16)) {
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (2))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (3))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (4))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										Entity _ent = entity;
										if (_ent instanceof ServerPlayerEntity) {
											Container _current = ((ServerPlayerEntity) _ent).openContainer;
											if (_current instanceof Supplier) {
												Object invobj = ((Supplier) _current).get();
												if (invobj instanceof Map) {
													((Slot) ((Map) invobj).get((int) (6))).decrStackSize((int) (1));
													_current.detectAndSendChanges();
												}
											}
										}
									}
									{
										ItemStack _ist = (new Object() {
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
										}.getItemStack((int) (5)));
										if (_ist.attemptDamageItem((int) 8, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									if (entity instanceof PlayerEntity) {
										Container _current = ((PlayerEntity) entity).openContainer;
										if (_current instanceof Supplier) {
											Object invobj = ((Supplier) _current).get();
											if (invobj instanceof Map) {
												ItemStack _setstack = new ItemStack(LurkerJuiceItem.block);
												_setstack.setCount((int) (new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof ServerPlayerEntity) {
															Container _current = ((ServerPlayerEntity) entity).openContainer;
															if (_current instanceof Supplier) {
																Object invobj = ((Supplier) _current).get();
																if (invobj instanceof Map) {
																	ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
																	if (stack != null)
																		return stack.getCount();
																}
															}
														}
														return 0;
													}
												}.getAmount((int) (0)) + 1));
												((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
												_current.detectAndSendChanges();
											}
										}
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("theabyss:somnium_infuser_bubble")),
												SoundCategory.NEUTRAL, (float) 0.3, (float) 1, false);
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

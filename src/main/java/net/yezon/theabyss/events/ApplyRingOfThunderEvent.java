package net.yezon.theabyss.events;

import net.yezon.theabyss.item.RingOfThunderItem;
import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ApplyRingOfThunderEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event ApplyRingOfThunder!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheabyssMod.LOGGER.warn("Failed to load dependency itemstack for Event ApplyRingOfThunder!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RingOfThunderItem.block)) : false) {
			if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Capabilities.PlayerVariables())).Mana < 60
							* (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("you don't have enough \u00A7benergy"), (true));
				}
			} else {
				if (itemstack.getItem() == RingOfThunderItem.block) {
					{
						ItemStack _ist = itemstack;
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
				if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Capabilities.PlayerVariables())).FriendMode == true) {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (40 / 2d), y - (40 / 2d), z - (40 / 2d), x + (40 / 2d), y + (40 / 2d), z + (40 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (!(entityiterator instanceof PlayerEntity)) {
									if (world instanceof ServerWorld) {
										LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
										_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (entityiterator.getPosX()),
												(int) (entityiterator.getPosY()), (int) (entityiterator.getPosZ()))));
										_ent.setEffectOnly(false);
										((World) world).addEntity(_ent);
									}
									entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
											(float) (3 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new Capabilities.PlayerVariables())).ManaDamage));
								}
							}
						}
					}
				} else {
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (40 / 2d), y - (40 / 2d), z - (40 / 2d), x + (40 / 2d), y + (40 / 2d), z + (40 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (world instanceof ServerWorld) {
									LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
									_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (entityiterator.getPosX()),
											(int) (entityiterator.getPosY()), (int) (entityiterator.getPosZ()))));
									_ent.setEffectOnly(false);
									((World) world).addEntity(_ent);
								}
								entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT,
										(float) (3 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new Capabilities.PlayerVariables())).ManaDamage));
							}
						}
					}
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(),
							(int) (140 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Capabilities.PlayerVariables())).ManaCooldown));
				{
					double _setval = ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Capabilities.PlayerVariables())).Mana
							- 60 * (entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
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

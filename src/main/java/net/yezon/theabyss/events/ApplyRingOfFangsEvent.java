package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class ApplyRingOfFangsevent {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(TheabyssModItems.RING_OF_FANGS.get()))
				: false) {
			if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheabyssModVariables.PlayerVariables())).Mana < 50
							* (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("ring.theabyss.low_energy").getString())), (true));
			} else {
				if (itemstack.getItem() == TheabyssModItems.RING_OF_FANGS.get()) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(),
							(int) (140 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaCooldown));
				{
					double _setval = (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TheabyssModVariables.PlayerVariables())).Mana
							- 50 * (entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new TheabyssModVariables.PlayerVariables())).ManaUpgrade;
					entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, z),
							Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"summon minecraft:evoker_fangs");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, z),
							Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"summon minecraft:evoker_fangs");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 2)),
							Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"summon minecraft:evoker_fangs");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 2)),
							Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"summon minecraft:evoker_fangs");
				TheabyssMod.queueServerWork(5, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z - 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z - 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z + 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z + 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
				});
				TheabyssMod.queueServerWork(10, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, z), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, z), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 3)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 3)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, (z - 2)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, (z + 2)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, (z + 2)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, (z - 2)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
				});
				TheabyssMod.queueServerWork(15, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 4), y, (z - 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 4), y, (z + 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, (z + 3)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z + 4)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z + 4)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, (z + 3)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 4), y, (z + 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 4), y, (z - 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, (z - 3)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z - 4)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z - 4)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, (z - 3)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
				});
				TheabyssMod.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 5), y, z), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 5), y, z), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 5)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 5)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
				});
				TheabyssMod.queueServerWork(25, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z - 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z - 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z + 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z + 1)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"summon minecraft:evoker_fangs");
					TheabyssMod.queueServerWork(5, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, z), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, z), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 3)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 3)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, (z - 2)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 2), y, (z + 2)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, (z + 2)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 2), y, (z - 2)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
					});
					TheabyssMod.queueServerWork(10, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 4), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 4), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, (z + 3)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z + 4)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z + 4)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, (z + 3)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 4), y, (z + 1)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 4), y, (z - 1)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 3), y, (z - 3)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, (z - 4)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, (z - 4)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + 3), y, (z - 3)), Vec2.ZERO, _level, 4, "",
													Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon minecraft:evoker_fangs");
					});
				});
				if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheabyssModVariables.PlayerVariables())).FriendMode == true) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(35 / 2d), e -> true)
								.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (!(entityiterator instanceof Player)) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands()
												.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
														new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
														Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
														.withSuppressedOutput(), "summon minecraft:evoker_fangs");
								}
							}
						}
					}
				} else {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(35 / 2d), e -> true)
								.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands()
											.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
													new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO,
													_level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"summon minecraft:evoker_fangs");
							}
						}
					}
				}
			}
		}
	}
}

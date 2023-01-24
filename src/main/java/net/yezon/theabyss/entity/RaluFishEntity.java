
package net.yezon.theabyss.entity;

import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.init.TheabyssModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

public class RaluFishEntity extends Squid {
	public RaluFishEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheabyssModEntities.RALU_FISH.get(), world);
	}

	public RaluFishEntity(EntityType<RaluFishEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (RaluFishEntity.this.isInWater())
					RaluFishEntity.this.setDeltaMovement(RaluFishEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !RaluFishEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - RaluFishEntity.this.getX();
					double dy = this.wantedY - RaluFishEntity.this.getY();
					double dz = this.wantedZ - RaluFishEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * RaluFishEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					RaluFishEntity.this.setYRot(this.rotlerp(RaluFishEntity.this.getYRot(), f, 10));
					RaluFishEntity.this.yBodyRot = RaluFishEntity.this.getYRot();
					RaluFishEntity.this.yHeadRot = RaluFishEntity.this.getYRot();
					if (RaluFishEntity.this.isInWater()) {
						RaluFishEntity.this.setSpeed((float) RaluFishEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						RaluFishEntity.this.setXRot(this.rotlerp(RaluFishEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(RaluFishEntity.this.getXRot() * (float) (Math.PI / 180.0));
						RaluFishEntity.this.setZza(f3 * f1);
						RaluFishEntity.this.setYya((float) (f1 * dy));
					} else {
						RaluFishEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					RaluFishEntity.this.setSpeed(0);
					RaluFishEntity.this.setYya(0);
					RaluFishEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1, 40));
	}

	@Override
	public MobType getMobType() {
		return MobType.WATER;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(TheabyssModItems.FISH.get()));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	public static void init() {
		SpawnPlacements.register(TheabyssModEntities.RALU_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 6);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.3);
		return builder;
	}
}

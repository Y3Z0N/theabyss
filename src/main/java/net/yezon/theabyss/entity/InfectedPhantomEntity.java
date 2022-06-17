
package net.yezon.theabyss.entity;

import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.init.TheabyssModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

import java.util.Set;
import java.util.Random;

@Mod.EventBusSubscriber
public class InfectedPhantomEntity extends Monster implements RangedAttackMob {
	private static final Set<ResourceLocation> SPAWN_BIOMES = Set.of(new ResourceLocation("theabyss:phantom_crate"));

	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		if (SPAWN_BIOMES.contains(event.getName()))
			event.getSpawns().getSpawner(MobCategory.MONSTER)
					.add(new MobSpawnSettings.SpawnerData(TheabyssModEntities.INFECTED_PHANTOM.get(), 60, 1, 2));
	}

	public InfectedPhantomEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheabyssModEntities.INFECTED_PHANTOM.get(), world);
	}

	public InfectedPhantomEntity(EntityType<InfectedPhantomEntity> type, Level world) {
		super(type, world);
		xpReward = 15;
		setNoAi(false);
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8, 20) {
			@Override
			protected Vec3 getPosition() {
				Random random = InfectedPhantomEntity.this.getRandom();
				double dir_x = InfectedPhantomEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = InfectedPhantomEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = InfectedPhantomEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(6, new MeleeAttackGoal(this, 0.001, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}
		});
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
			@Override
			public boolean canContinueToUse() {
				return this.canUse();
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(TheabyssModItems.PHANTOM_SOUL_ITEM.get()));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:phantom_ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:phantom_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:phantom_hurt"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source == DamageSource.FALL)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		if (source == DamageSource.LIGHTNING_BOLT)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		PhantomAttackEntity.shoot(this, target);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
	}

	public static void init() {
		SpawnPlacements.register(TheabyssModEntities.INFECTED_PHANTOM.get(), SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL
						&& Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 2);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 2);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 2);
		builder = builder.add(Attributes.FLYING_SPEED, 0.3);
		return builder;
	}
}

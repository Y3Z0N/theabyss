
package net.yezon.theabyss.entity;

import net.yezon.theabyss.eventhandlers.PhantomTrailEventHandler;
import net.yezon.theabyss.eventhandlers.PhantomEffectEventHandler;
import net.yezon.theabyss.eventhandlers.ArtifactOfPhantomsAbilityEventHandler;
import net.yezon.theabyss.init.TheabyssModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class ArtifactOfPhantomsEntity extends AbstractArrow implements ItemSupplier {
	public ArtifactOfPhantomsEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(TheabyssModEntities.ARTIFACT_OF_PHANTOMS.get(), world);
	}

	public ArtifactOfPhantomsEntity(EntityType<? extends ArtifactOfPhantomsEntity> type, Level world) {
		super(type, world);
	}

	public ArtifactOfPhantomsEntity(EntityType<? extends ArtifactOfPhantomsEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public ArtifactOfPhantomsEntity(EntityType<? extends ArtifactOfPhantomsEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(Blocks.AIR);
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void playerTouch(Player entity) {
		super.playerTouch(entity);
		ArtifactOfPhantomsAbilityEventHandler.execute(this.level, this.getX(), this.getY(), this.getZ(), entity);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		PhantomEffectEventHandler.execute(this.level, this.getX(), this.getY(), this.getZ(), entityHitResult.getEntity());
	}

	@Override
	public void tick() {
		super.tick();
		PhantomTrailEventHandler.execute(this.level, this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static ArtifactOfPhantomsEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		ArtifactOfPhantomsEntity entityarrow = new ArtifactOfPhantomsEntity(TheabyssModEntities.ARTIFACT_OF_PHANTOMS.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(true);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:phantom_attack")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static ArtifactOfPhantomsEntity shoot(LivingEntity entity, LivingEntity target) {
		ArtifactOfPhantomsEntity entityarrow = new ArtifactOfPhantomsEntity(TheabyssModEntities.ARTIFACT_OF_PHANTOMS.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(2.8);
		entityarrow.setKnockback(1);
		entityarrow.setCritArrow(true);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("theabyss:phantom_attack")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}

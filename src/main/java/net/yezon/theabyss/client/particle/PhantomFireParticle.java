
package net.yezon.theabyss.client.particle;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;

@OnlyIn(Dist.CLIENT)
public class PhantomFireParticle extends TextureSheetParticle {
	public static PhantomFireParticleProvider provider(SpriteSet spriteSet) {
		return new PhantomFireParticleProvider(spriteSet);
	}

	public static class PhantomFireParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public PhantomFireParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
				double zSpeed) {
			return new PhantomFireParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected PhantomFireParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.7999999999999999f, 0.5f);
		this.quadSize *= 2f;
		this.lifetime = (int) Math.max(1, 10 + (this.random.nextInt(40) - 20));
		this.gravity = 0f;
		this.hasPhysics = true;
		this.xd = vx * 0.001;
		this.yd = vy * 0.001;
		this.zd = vz * 0.001;
		this.setSpriteFromAge(spriteSet);
	}

	@Override
	public int getLightColor(float partialTick) {
		return 15728880;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_LIT;
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.removed) {
			this.setSprite(this.spriteSet.get((this.age / 2) % 7 + 1, 7));
		}
	}
}

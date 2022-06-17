
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
public class PhantomSpectrumParticle extends TextureSheetParticle {
	public static PhantomSpectrumParticleProvider provider(SpriteSet spriteSet) {
		return new PhantomSpectrumParticleProvider(spriteSet);
	}

	public static class PhantomSpectrumParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public PhantomSpectrumParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
				double zSpeed) {
			return new PhantomSpectrumParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected PhantomSpectrumParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(1f, 1f);
		this.quadSize *= 8f;
		this.lifetime = (int) Math.max(1, 10 + (this.random.nextInt(40) - 20));
		this.gravity = 0f;
		this.hasPhysics = false;
		this.xd = vx * 1;
		this.yd = vy * 1;
		this.zd = vz * 1;
		this.pickSprite(spriteSet);
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
	}
}

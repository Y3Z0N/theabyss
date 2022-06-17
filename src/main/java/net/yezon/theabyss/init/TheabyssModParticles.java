
/*
 *    Y3 was here UwU ^-^
 */
package net.yezon.theabyss.init;

import net.yezon.theabyss.client.particle.WandThunderPTParticle;
import net.yezon.theabyss.client.particle.UDPTParticle;
import net.yezon.theabyss.client.particle.SpursBiome01Particle;
import net.yezon.theabyss.client.particle.ShinnyCyanParticle;
import net.yezon.theabyss.client.particle.RenderLightCyanParticle;
import net.yezon.theabyss.client.particle.RenderCyanParticle;
import net.yezon.theabyss.client.particle.RenderBrightCyanParticle;
import net.yezon.theabyss.client.particle.PhantomSpectrumParticle;
import net.yezon.theabyss.client.particle.PhantomFireParticle;
import net.yezon.theabyss.client.particle.PhantomAttackParticleParticle;
import net.yezon.theabyss.client.particle.PhantomAttackParticle2Particle;
import net.yezon.theabyss.client.particle.NodeParticleParticle;
import net.yezon.theabyss.client.particle.KnightSwordPTParticle;
import net.yezon.theabyss.client.particle.FireFlyParticleParticle;
import net.yezon.theabyss.client.particle.EndSwordPTParticle;
import net.yezon.theabyss.client.particle.ElectricityAnimatedParticle;
import net.yezon.theabyss.client.particle.EcholotBubbleParticle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheabyssModParticles {
	@SubscribeEvent
	public static void registerParticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.END_SWORD_PT.get(),
				EndSwordPTParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.SPURS_BIOME_01.get(),
				SpursBiome01Particle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.UDPT.get(), UDPTParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.WAND_THUNDER_PT.get(),
				WandThunderPTParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.ECHOLOT_BUBBLE.get(),
				EcholotBubbleParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.FIRE_FLY_PARTICLE.get(),
				FireFlyParticleParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.NODE_PARTICLE.get(),
				NodeParticleParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.PHANTOM_ATTACK_PARTICLE.get(),
				PhantomAttackParticleParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.PHANTOM_ATTACK_PARTICLE_2.get(),
				PhantomAttackParticle2Particle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.KNIGHT_SWORD_PT.get(),
				KnightSwordPTParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.SHINNY_CYAN.get(),
				ShinnyCyanParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.RENDER_CYAN.get(),
				RenderCyanParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.RENDER_LIGHT_CYAN.get(),
				RenderLightCyanParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.RENDER_BRIGHT_CYAN.get(),
				RenderBrightCyanParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.PHANTOM_FIRE.get(),
				PhantomFireParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.ELECTRICITY_ANIMATED.get(),
				ElectricityAnimatedParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) TheabyssModParticleTypes.PHANTOM_SPECTRUM.get(),
				PhantomSpectrumParticle::provider);
	}
}

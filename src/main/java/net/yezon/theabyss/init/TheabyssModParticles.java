
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
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheabyssModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(TheabyssModParticleTypes.END_SWORD_PT.get(), EndSwordPTParticle::provider);
		event.register(TheabyssModParticleTypes.SPURS_BIOME_01.get(), SpursBiome01Particle::provider);
		event.register(TheabyssModParticleTypes.UDPT.get(), UDPTParticle::provider);
		event.register(TheabyssModParticleTypes.WAND_THUNDER_PT.get(), WandThunderPTParticle::provider);
		event.register(TheabyssModParticleTypes.ECHOLOT_BUBBLE.get(), EcholotBubbleParticle::provider);
		event.register(TheabyssModParticleTypes.FIRE_FLY_PARTICLE.get(), FireFlyParticleParticle::provider);
		event.register(TheabyssModParticleTypes.NODE_PARTICLE.get(), NodeParticleParticle::provider);
		event.register(TheabyssModParticleTypes.PHANTOM_ATTACK_PARTICLE.get(), PhantomAttackParticleParticle::provider);
		event.register(TheabyssModParticleTypes.PHANTOM_ATTACK_PARTICLE_2.get(), PhantomAttackParticle2Particle::provider);
		event.register(TheabyssModParticleTypes.KNIGHT_SWORD_PT.get(), KnightSwordPTParticle::provider);
		event.register(TheabyssModParticleTypes.SHINNY_CYAN.get(), ShinnyCyanParticle::provider);
		event.register(TheabyssModParticleTypes.RENDER_CYAN.get(), RenderCyanParticle::provider);
		event.register(TheabyssModParticleTypes.RENDER_LIGHT_CYAN.get(), RenderLightCyanParticle::provider);
		event.register(TheabyssModParticleTypes.RENDER_BRIGHT_CYAN.get(), RenderBrightCyanParticle::provider);
		event.register(TheabyssModParticleTypes.PHANTOM_FIRE.get(), PhantomFireParticle::provider);
		event.register(TheabyssModParticleTypes.ELECTRICITY_ANIMATED.get(), ElectricityAnimatedParticle::provider);
		event.register(TheabyssModParticleTypes.PHANTOM_SPECTRUM.get(), PhantomSpectrumParticle::provider);
	}
}

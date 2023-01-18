
  
package net.yezon.theabyss.init;

import net.yezon.theabyss.client.renderer.VersaWhaleRenderer;
import net.yezon.theabyss.client.renderer.TheRokaRenderer;
import net.yezon.theabyss.client.renderer.SummonedSeekerRenderer;
import net.yezon.theabyss.client.renderer.SummonedHollowSeekerRenderer;
import net.yezon.theabyss.client.renderer.SoulGuardRenderer;
import net.yezon.theabyss.client.renderer.SlimeSpiderRenderer;
import net.yezon.theabyss.client.renderer.ShatteredZombieRenderer;
import net.yezon.theabyss.client.renderer.SeekerRenderer;
import net.yezon.theabyss.client.renderer.ScorpionRenderer;
import net.yezon.theabyss.client.renderer.RingOfFireStrikeAttackRenderer;
import net.yezon.theabyss.client.renderer.RingOfBlackStrikeAttackRenderer;
import net.yezon.theabyss.client.renderer.RaptorRenderer;
import net.yezon.theabyss.client.renderer.RaluFishRenderer;
import net.yezon.theabyss.client.renderer.PoweredWolfRenderer;
import net.yezon.theabyss.client.renderer.PlayerBodyRenderer;
import net.yezon.theabyss.client.renderer.NightbladeBossRenderer;
import net.yezon.theabyss.client.renderer.NightBladeBossCloneRenderer;
import net.yezon.theabyss.client.renderer.MudZombieRenderer;
import net.yezon.theabyss.client.renderer.MagicianRenderer;
import net.yezon.theabyss.client.renderer.LuroFishRenderer;
import net.yezon.theabyss.client.renderer.LokusRenderer;
import net.yezon.theabyss.client.renderer.LizardRenderer;
import net.yezon.theabyss.client.renderer.LaroFishRenderer;
import net.yezon.theabyss.client.renderer.JungleLurkerRenderer;
import net.yezon.theabyss.client.renderer.InfectedZombieRenderer;
import net.yezon.theabyss.client.renderer.InfectedWolfRenderer;
import net.yezon.theabyss.client.renderer.InfectedSpiderRenderer;
import net.yezon.theabyss.client.renderer.InfectedPhantomRenderer;
import net.yezon.theabyss.client.renderer.InfectedCreeperRenderer;
import net.yezon.theabyss.client.renderer.InfcetedCowRenderer;
import net.yezon.theabyss.client.renderer.IceSkeletonRenderer;
import net.yezon.theabyss.client.renderer.IceKnightRenderer;
import net.yezon.theabyss.client.renderer.HyliaFoxRenderer;
import net.yezon.theabyss.client.renderer.HauntedSkeletonRenderer;
import net.yezon.theabyss.client.renderer.GuardRenderer;
import net.yezon.theabyss.client.renderer.GlowPugRenderer;
import net.yezon.theabyss.client.renderer.FrostSpiderRenderer;
import net.yezon.theabyss.client.renderer.EndSpiderRenderer;
import net.yezon.theabyss.client.renderer.ElderRenderer;
import net.yezon.theabyss.client.renderer.DeerRenderer;
import net.yezon.theabyss.client.renderer.CrystalGolemRenderer;
import net.yezon.theabyss.client.renderer.BrainWalkerRenderer;
import net.yezon.theabyss.client.renderer.AbyssaurRenderer;
import net.yezon.theabyss.client.renderer.AbyssalLionRenderer;
import net.yezon.theabyss.client.renderer.AbylagerRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheabyssModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TheabyssModEntities.SHURIKEN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.SHURIKEN_EXPLOSIVE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.MUTATED_ENDERPEARL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.THE_ROKA.get(), TheRokaRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.ICE_SKELETON.get(), IceSkeletonRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.ICE_KNIGHT.get(), IceKnightRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.NIGHTBLADE_BOSS.get(), NightbladeBossRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.NIGHT_BLADE_BOSS_CLONE.get(), NightBladeBossCloneRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.DEER.get(), DeerRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.LARO_FISH.get(), LaroFishRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.LURO_FISH.get(), LuroFishRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.RALU_FISH.get(), RaluFishRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.HYLIA_FOX.get(), HyliaFoxRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.CRYSTAL_GOLEM.get(), CrystalGolemRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.ABYSSAUR.get(), AbyssaurRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.MAGICIAN.get(), MagicianRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.SOUL_GUARD.get(), SoulGuardRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.INFECTED_SPIDER.get(), InfectedSpiderRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.INFECTED_CREEPER.get(), InfectedCreeperRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.GUARD.get(), GuardRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.MUD_ZOMBIE.get(), MudZombieRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.INFECTED_ZOMBIE.get(), InfectedZombieRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.RAPTOR.get(), RaptorRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.END_SPIDER.get(), EndSpiderRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.LIZARD.get(), LizardRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.ELDER.get(), ElderRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.JUNGLE_LURKER.get(), JungleLurkerRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.SLIME_SPIDER.get(), SlimeSpiderRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.SCORPION.get(), ScorpionRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.SEEKER.get(), SeekerRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.PLAYER_BODY.get(), PlayerBodyRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.HAUNTED_SKELETON.get(), HauntedSkeletonRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.SHATTERED_ZOMBIE.get(), ShatteredZombieRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.SUMMONED_SEEKER.get(), SummonedSeekerRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.INFECTED_WOLF.get(), InfectedWolfRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.INFECTED_PHANTOM.get(), InfectedPhantomRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.POWERED_WOLF.get(), PoweredWolfRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.BRAIN_WALKER.get(), BrainWalkerRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.VERSA_WHALE.get(), VersaWhaleRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.LOKUS.get(), LokusRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.FROST_SPIDER.get(), FrostSpiderRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.GLOW_PUG.get(), GlowPugRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.ABYSSAL_LION.get(), AbyssalLionRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.INFCETED_COW.get(), InfcetedCowRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.ABYLAGER.get(), AbylagerRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.PHANTOM_ATTACK.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.RING_OF_FIRE_STRIKE_ATTACK.get(), RingOfFireStrikeAttackRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.RING_OF_BLACK_STRIKE_ATTACK.get(), RingOfBlackStrikeAttackRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.SUMMONED_HOLLOW_SEEKER.get(), SummonedHollowSeekerRenderer::new);
		event.registerEntityRenderer(TheabyssModEntities.ARTIFACT_OF_PHANTOMS.get(), ThrownItemRenderer::new);
	}
}

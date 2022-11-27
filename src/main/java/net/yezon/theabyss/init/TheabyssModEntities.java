
package net.yezon.theabyss.init;

import net.yezon.theabyss.entity.VersaWhaleEntity;
import net.yezon.theabyss.entity.TheRokaEntity;
import net.yezon.theabyss.entity.SummonedSeekerEntity;
import net.yezon.theabyss.entity.SummonedHollowSeekerEntity;
import net.yezon.theabyss.entity.SpectralSpawnEntity;
import net.yezon.theabyss.entity.SpectralEntityEntity;
import net.yezon.theabyss.entity.SoulGuardEntity;
import net.yezon.theabyss.entity.SlimeSpiderEntity;
import net.yezon.theabyss.entity.ShurikenExplosiveEntity;
import net.yezon.theabyss.entity.ShurikenEntity;
import net.yezon.theabyss.entity.ShatteredZombieEntity;
import net.yezon.theabyss.entity.SeekerEntity;
import net.yezon.theabyss.entity.ScorpionEntity;
import net.yezon.theabyss.entity.RingOfFireStrikeAttackEntity;
import net.yezon.theabyss.entity.RingOfBlackStrikeAttackEntity;
import net.yezon.theabyss.entity.RaptorEntity;
import net.yezon.theabyss.entity.RaluFishEntity;
import net.yezon.theabyss.entity.PoweredWolfEntity;
import net.yezon.theabyss.entity.PlayerBodyEntity;
import net.yezon.theabyss.entity.PhantomAttackEntity;
import net.yezon.theabyss.entity.NightbladeBossEntity;
import net.yezon.theabyss.entity.NightHunterEntity;
import net.yezon.theabyss.entity.NightHunterAbl2Entity;
import net.yezon.theabyss.entity.NightBladeBossCloneEntity;
import net.yezon.theabyss.entity.MutatedEnderpearlEntity;
import net.yezon.theabyss.entity.MudZombieEntity;
import net.yezon.theabyss.entity.MagicianEntity;
import net.yezon.theabyss.entity.MagicalDeerEntity;
import net.yezon.theabyss.entity.LuroFishEntity;
import net.yezon.theabyss.entity.LokusEntity;
import net.yezon.theabyss.entity.LizardEntity;
import net.yezon.theabyss.entity.LaroFishFlyEntity;
import net.yezon.theabyss.entity.LaroFishEntity;
import net.yezon.theabyss.entity.JungleLurkerEntity;
import net.yezon.theabyss.entity.InfectedZombieEntity;
import net.yezon.theabyss.entity.InfectedWolfEntity;
import net.yezon.theabyss.entity.InfectedSpiderEntity;
import net.yezon.theabyss.entity.InfectedPhantomEntity;
import net.yezon.theabyss.entity.InfectedCreeperEntity;
import net.yezon.theabyss.entity.InfcetedCowEntity;
import net.yezon.theabyss.entity.IceSkeletonEntity;
import net.yezon.theabyss.entity.IceKnightEntity;
import net.yezon.theabyss.entity.HyliaFoxEntity;
import net.yezon.theabyss.entity.HauntedSkeletonEntity;
import net.yezon.theabyss.entity.GuardEntity;
import net.yezon.theabyss.entity.GlowPugEntity;
import net.yezon.theabyss.entity.FrostSpiderEntity;
import net.yezon.theabyss.entity.FireFlyEntity;
import net.yezon.theabyss.entity.EyelieAttackEntity;
import net.yezon.theabyss.entity.EndSpiderEntity;
import net.yezon.theabyss.entity.ElderEntity;
import net.yezon.theabyss.entity.DeerEntity;
import net.yezon.theabyss.entity.CrystalGolemEntity;
import net.yezon.theabyss.entity.BrainWalkerEntity;
import net.yezon.theabyss.entity.AbyssaurEntity;
import net.yezon.theabyss.entity.AbyssalLionEntity;
import net.yezon.theabyss.entity.AbylagerEntity;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheabyssModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheabyssMod.MODID);
	public static final RegistryObject<EntityType<ShurikenEntity>> SHURIKEN = register("projectile_shuriken",
			EntityType.Builder.<ShurikenEntity>of(ShurikenEntity::new, MobCategory.MISC).setCustomClientFactory(ShurikenEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShurikenExplosiveEntity>> SHURIKEN_EXPLOSIVE = register("projectile_shuriken_explosive",
			EntityType.Builder.<ShurikenExplosiveEntity>of(ShurikenExplosiveEntity::new, MobCategory.MISC)
					.setCustomClientFactory(ShurikenExplosiveEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MutatedEnderpearlEntity>> MUTATED_ENDERPEARL = register("projectile_mutated_enderpearl",
			EntityType.Builder.<MutatedEnderpearlEntity>of(MutatedEnderpearlEntity::new, MobCategory.MISC)
					.setCustomClientFactory(MutatedEnderpearlEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TheRokaEntity>> THE_ROKA = register("the_roka",
			EntityType.Builder.<TheRokaEntity>of(TheRokaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(TheRokaEntity::new).fireImmune().sized(0.8f, 2.6f));
	public static final RegistryObject<EntityType<FireFlyEntity>> FIRE_FLY = register("fire_fly",
			EntityType.Builder.<FireFlyEntity>of(FireFlyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(20)
					.setUpdateInterval(3).setCustomClientFactory(FireFlyEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<IceSkeletonEntity>> ICE_SKELETON = register("ice_skeleton",
			EntityType.Builder.<IceSkeletonEntity>of(IceSkeletonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IceSkeletonEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IceKnightEntity>> ICE_KNIGHT = register("ice_knight",
			EntityType.Builder.<IceKnightEntity>of(IceKnightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(18).setUpdateInterval(3).setCustomClientFactory(IceKnightEntity::new).fireImmune()
					.sized(0.8f, 1.7999999999999998f));
	public static final RegistryObject<EntityType<NightbladeBossEntity>> NIGHTBLADE_BOSS = register("nightblade_boss",
			EntityType.Builder.<NightbladeBossEntity>of(NightbladeBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NightbladeBossEntity::new).fireImmune()
					.sized(0.8f, 1.7999999999999998f));
	public static final RegistryObject<EntityType<NightBladeBossCloneEntity>> NIGHT_BLADE_BOSS_CLONE = register("night_blade_boss_clone",
			EntityType.Builder.<NightBladeBossCloneEntity>of(NightBladeBossCloneEntity::new, MobCategory.MONSTER)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(20).setUpdateInterval(3)
					.setCustomClientFactory(NightBladeBossCloneEntity::new).fireImmune().sized(0.8f, 1.7999999999999998f));
	public static final RegistryObject<EntityType<DeerEntity>> DEER = register("deer",
			EntityType.Builder.<DeerEntity>of(DeerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(20)
					.setUpdateInterval(3).setCustomClientFactory(DeerEntity::new).fireImmune().sized(0.9f, 1.4f));
	public static final RegistryObject<EntityType<LaroFishFlyEntity>> LARO_FISH_FLY = register("laro_fish_fly",
			EntityType.Builder.<LaroFishFlyEntity>of(LaroFishFlyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LaroFishFlyEntity::new)

					.sized(1f, 1f));
	public static final RegistryObject<EntityType<LaroFishEntity>> LARO_FISH = register("laro_fish",
			EntityType.Builder.<LaroFishEntity>of(LaroFishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(LaroFishEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LuroFishEntity>> LURO_FISH = register("luro_fish",
			EntityType.Builder.<LuroFishEntity>of(LuroFishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(LuroFishEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RaluFishEntity>> RALU_FISH = register("ralu_fish",
			EntityType.Builder.<RaluFishEntity>of(RaluFishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(RaluFishEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HyliaFoxEntity>> HYLIA_FOX = register("hylia_fox",
			EntityType.Builder.<HyliaFoxEntity>of(HyliaFoxEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(HyliaFoxEntity::new).fireImmune().sized(0.8f, 0.8f));
	public static final RegistryObject<EntityType<CrystalGolemEntity>> CRYSTAL_GOLEM = register("crystal_golem",
			EntityType.Builder.<CrystalGolemEntity>of(CrystalGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrystalGolemEntity::new).fireImmune().sized(0.8f, 3.2f));
	public static final RegistryObject<EntityType<AbyssaurEntity>> ABYSSAUR = register("abyssaur",
			EntityType.Builder.<AbyssaurEntity>of(AbyssaurEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(AbyssaurEntity::new).fireImmune().sized(0.8f, 2.4f));
	public static final RegistryObject<EntityType<MagicianEntity>> MAGICIAN = register("magician",
			EntityType.Builder.<MagicianEntity>of(MagicianEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(MagicianEntity::new).fireImmune().sized(0.6f, 2.8000000000000003f));
	public static final RegistryObject<EntityType<SoulGuardEntity>> SOUL_GUARD = register("soul_guard",
			EntityType.Builder.<SoulGuardEntity>of(SoulGuardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(18).setUpdateInterval(3).setCustomClientFactory(SoulGuardEntity::new).fireImmune()
					.sized(0.8f, 1.7999999999999998f));
	public static final RegistryObject<EntityType<InfectedSpiderEntity>> INFECTED_SPIDER = register("infected_spider",
			EntityType.Builder.<InfectedSpiderEntity>of(InfectedSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(30).setUpdateInterval(3).setCustomClientFactory(InfectedSpiderEntity::new).fireImmune()
					.sized(1.4f, 1.2000000000000002f));
	public static final RegistryObject<EntityType<InfectedCreeperEntity>> INFECTED_CREEPER = register("infected_creeper",
			EntityType.Builder.<InfectedCreeperEntity>of(InfectedCreeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(40).setUpdateInterval(3).setCustomClientFactory(InfectedCreeperEntity::new).fireImmune().sized(0.6f, 1.7f));
	public static final RegistryObject<EntityType<GuardEntity>> GUARD = register("guard",
			EntityType.Builder.<GuardEntity>of(GuardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(20)
					.setUpdateInterval(3).setCustomClientFactory(GuardEntity::new).fireImmune().sized(0.8f, 1.7999999999999998f));
	public static final RegistryObject<EntityType<MudZombieEntity>> MUD_ZOMBIE = register("mud_zombie",
			EntityType.Builder.<MudZombieEntity>of(MudZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(30).setUpdateInterval(3).setCustomClientFactory(MudZombieEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<InfectedZombieEntity>> INFECTED_ZOMBIE = register("infected_zombie",
			EntityType.Builder.<InfectedZombieEntity>of(InfectedZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(30).setUpdateInterval(3).setCustomClientFactory(InfectedZombieEntity::new).fireImmune().sized(0.6f, 1.7f));
	public static final RegistryObject<EntityType<RaptorEntity>> RAPTOR = register("raptor",
			EntityType.Builder.<RaptorEntity>of(RaptorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(RaptorEntity::new)

					.sized(1.5f, 1.2f));
	public static final RegistryObject<EntityType<EndSpiderEntity>> END_SPIDER = register("end_spider",
			EntityType.Builder.<EndSpiderEntity>of(EndSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(40).setUpdateInterval(3).setCustomClientFactory(EndSpiderEntity::new).fireImmune()
					.sized(0.8f, 1.2000000000000002f));
	public static final RegistryObject<EntityType<NightHunterEntity>> NIGHT_HUNTER = register("night_hunter",
			EntityType.Builder.<NightHunterEntity>of(NightHunterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(20).setUpdateInterval(3).setCustomClientFactory(NightHunterEntity::new)

					.sized(0.8f, 1.8f));
	public static final RegistryObject<EntityType<LizardEntity>> LIZARD = register("lizard",
			EntityType.Builder.<LizardEntity>of(LizardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(LizardEntity::new).fireImmune().sized(0.8f, 0.6f));
	public static final RegistryObject<EntityType<ElderEntity>> ELDER = register("elder",
			EntityType.Builder.<ElderEntity>of(ElderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(ElderEntity::new).fireImmune().sized(0.8f, 2.5f));
	public static final RegistryObject<EntityType<JungleLurkerEntity>> JUNGLE_LURKER = register("jungle_lurker",
			EntityType.Builder.<JungleLurkerEntity>of(JungleLurkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(JungleLurkerEntity::new).fireImmune()
					.sized(0.6f, 1.7999999999999998f));
	public static final RegistryObject<EntityType<SlimeSpiderEntity>> SLIME_SPIDER = register("slime_spider",
			EntityType.Builder.<SlimeSpiderEntity>of(SlimeSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(35).setUpdateInterval(3).setCustomClientFactory(SlimeSpiderEntity::new).fireImmune()
					.sized(1.4f, 1.2000000000000002f));
	public static final RegistryObject<EntityType<ScorpionEntity>> SCORPION = register("scorpion",
			EntityType.Builder.<ScorpionEntity>of(ScorpionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(30)
					.setUpdateInterval(3).setCustomClientFactory(ScorpionEntity::new).fireImmune().sized(1.4f, 1f));
	public static final RegistryObject<EntityType<SeekerEntity>> SEEKER = register("seeker",
			EntityType.Builder.<SeekerEntity>of(SeekerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100)
					.setUpdateInterval(3).setCustomClientFactory(SeekerEntity::new).fireImmune().sized(0.7999999999999999f, 2f));
	public static final RegistryObject<EntityType<PlayerBodyEntity>> PLAYER_BODY = register("player_body",
			EntityType.Builder.<PlayerBodyEntity>of(PlayerBodyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PlayerBodyEntity::new)

					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HauntedSkeletonEntity>> HAUNTED_SKELETON = register("haunted_skeleton",
			EntityType.Builder.<HauntedSkeletonEntity>of(HauntedSkeletonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HauntedSkeletonEntity::new).fireImmune()
					.sized(0.6f, 1.9000000000000001f));
	public static final RegistryObject<EntityType<ShatteredZombieEntity>> SHATTERED_ZOMBIE = register("shattered_zombie",
			EntityType.Builder.<ShatteredZombieEntity>of(ShatteredZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(30).setUpdateInterval(3).setCustomClientFactory(ShatteredZombieEntity::new).fireImmune()
					.sized(0.6f, 1.7000000000000002f));
	public static final RegistryObject<EntityType<SummonedSeekerEntity>> SUMMONED_SEEKER = register("summoned_seeker",
			EntityType.Builder.<SummonedSeekerEntity>of(SummonedSeekerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(SummonedSeekerEntity::new).fireImmune()
					.sized(0.7999999999999999f, 2f));
	public static final RegistryObject<EntityType<MagicalDeerEntity>> MAGICAL_DEER = register("magical_deer",
			EntityType.Builder.<MagicalDeerEntity>of(MagicalDeerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(20).setUpdateInterval(3).setCustomClientFactory(MagicalDeerEntity::new).fireImmune().sized(0.9f, 1.4f));
	public static final RegistryObject<EntityType<InfectedWolfEntity>> INFECTED_WOLF = register("infected_wolf",
			EntityType.Builder.<InfectedWolfEntity>of(InfectedWolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InfectedWolfEntity::new).fireImmune()
					.sized(0.7999999999999999f, 1.2000000000000002f));
	public static final RegistryObject<EntityType<InfectedPhantomEntity>> INFECTED_PHANTOM = register("infected_phantom",
			EntityType.Builder.<InfectedPhantomEntity>of(InfectedPhantomEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InfectedPhantomEntity::new).fireImmune()
					.sized(0.7999999999999999f, 2f));
	public static final RegistryObject<EntityType<PoweredWolfEntity>> POWERED_WOLF = register("powered_wolf",
			EntityType.Builder.<PoweredWolfEntity>of(PoweredWolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PoweredWolfEntity::new).fireImmune()
					.sized(0.7999999999999999f, 1.2f));
	public static final RegistryObject<EntityType<BrainWalkerEntity>> BRAIN_WALKER = register("brain_walker",
			EntityType.Builder.<BrainWalkerEntity>of(BrainWalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BrainWalkerEntity::new).fireImmune()
					.sized(0.6f, 1.5999999999999999f));
	public static final RegistryObject<EntityType<VersaWhaleEntity>> VERSA_WHALE = register("versa_whale",
			EntityType.Builder.<VersaWhaleEntity>of(VersaWhaleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VersaWhaleEntity::new)

					.sized(1.7999999999999998f, 2f));
	public static final RegistryObject<EntityType<LokusEntity>> LOKUS = register("lokus",
			EntityType.Builder.<LokusEntity>of(LokusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(20)
					.setUpdateInterval(3).setCustomClientFactory(LokusEntity::new).fireImmune().sized(0.8f, 2.5f));
	public static final RegistryObject<EntityType<FrostSpiderEntity>> FROST_SPIDER = register("frost_spider",
			EntityType.Builder.<FrostSpiderEntity>of(FrostSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(35).setUpdateInterval(3).setCustomClientFactory(FrostSpiderEntity::new).fireImmune()
					.sized(1.4f, 1.2000000000000002f));
	public static final RegistryObject<EntityType<GlowPugEntity>> GLOW_PUG = register("glow_pug",
			EntityType.Builder.<GlowPugEntity>of(GlowPugEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(GlowPugEntity::new)

					.sized(0.7999999999999999f, 0.8f));
	public static final RegistryObject<EntityType<AbyssalLionEntity>> ABYSSAL_LION = register("abyssal_lion",
			EntityType.Builder.<AbyssalLionEntity>of(AbyssalLionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AbyssalLionEntity::new).fireImmune()
					.sized(0.7999999999999999f, 1.5f));
	public static final RegistryObject<EntityType<InfcetedCowEntity>> INFCETED_COW = register("infceted_cow",
			EntityType.Builder.<InfcetedCowEntity>of(InfcetedCowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(30).setUpdateInterval(3).setCustomClientFactory(InfcetedCowEntity::new)

					.sized(0.8f, 1.4f));
	public static final RegistryObject<EntityType<AbylagerEntity>> ABYLAGER = register("abylager",
			EntityType.Builder.<AbylagerEntity>of(AbylagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(AbylagerEntity::new).fireImmune().sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<NightHunterAbl2Entity>> NIGHT_HUNTER_ABL_2 = register("projectile_night_hunter_abl_2",
			EntityType.Builder.<NightHunterAbl2Entity>of(NightHunterAbl2Entity::new, MobCategory.MISC)
					.setCustomClientFactory(NightHunterAbl2Entity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EyelieAttackEntity>> EYELIE_ATTACK = register("projectile_eyelie_attack",
			EntityType.Builder.<EyelieAttackEntity>of(EyelieAttackEntity::new, MobCategory.MISC).setCustomClientFactory(EyelieAttackEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PhantomAttackEntity>> PHANTOM_ATTACK = register("projectile_phantom_attack",
			EntityType.Builder.<PhantomAttackEntity>of(PhantomAttackEntity::new, MobCategory.MISC).setCustomClientFactory(PhantomAttackEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SpectralEntityEntity>> SPECTRAL_ENTITY = register("spectral_entity",
			EntityType.Builder.<SpectralEntityEntity>of(SpectralEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(1).setUpdateInterval(3).setCustomClientFactory(SpectralEntityEntity::new)

					.sized(0.4f, 0.1f));
	public static final RegistryObject<EntityType<SpectralSpawnEntity>> SPECTRAL_SPAWN = register("projectile_spectral_spawn",
			EntityType.Builder.<SpectralSpawnEntity>of(SpectralSpawnEntity::new, MobCategory.MISC).setCustomClientFactory(SpectralSpawnEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RingOfFireStrikeAttackEntity>> RING_OF_FIRE_STRIKE_ATTACK = register(
			"projectile_ring_of_fire_strike_attack",
			EntityType.Builder.<RingOfFireStrikeAttackEntity>of(RingOfFireStrikeAttackEntity::new, MobCategory.MISC)
					.setCustomClientFactory(RingOfFireStrikeAttackEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RingOfBlackStrikeAttackEntity>> RING_OF_BLACK_STRIKE_ATTACK = register(
			"projectile_ring_of_black_strike_attack",
			EntityType.Builder.<RingOfBlackStrikeAttackEntity>of(RingOfBlackStrikeAttackEntity::new, MobCategory.MISC)
					.setCustomClientFactory(RingOfBlackStrikeAttackEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SummonedHollowSeekerEntity>> SUMMONED_HOLLOW_SEEKER = register("summoned_hollow_seeker",
			EntityType.Builder.<SummonedHollowSeekerEntity>of(SummonedHollowSeekerEntity::new, MobCategory.CREATURE)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3)
					.setCustomClientFactory(SummonedHollowSeekerEntity::new).fireImmune().sized(0.7999999999999999f, 2f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TheRokaEntity.init();
			FireFlyEntity.init();
			IceSkeletonEntity.init();
			IceKnightEntity.init();
			NightbladeBossEntity.init();
			NightBladeBossCloneEntity.init();
			DeerEntity.init();
			LaroFishFlyEntity.init();
			LaroFishEntity.init();
			LuroFishEntity.init();
			RaluFishEntity.init();
			HyliaFoxEntity.init();
			CrystalGolemEntity.init();
			AbyssaurEntity.init();
			MagicianEntity.init();
			SoulGuardEntity.init();
			InfectedSpiderEntity.init();
			InfectedCreeperEntity.init();
			GuardEntity.init();
			MudZombieEntity.init();
			InfectedZombieEntity.init();
			RaptorEntity.init();
			EndSpiderEntity.init();
			NightHunterEntity.init();
			LizardEntity.init();
			ElderEntity.init();
			JungleLurkerEntity.init();
			SlimeSpiderEntity.init();
			ScorpionEntity.init();
			SeekerEntity.init();
			PlayerBodyEntity.init();
			HauntedSkeletonEntity.init();
			ShatteredZombieEntity.init();
			SummonedSeekerEntity.init();
			MagicalDeerEntity.init();
			InfectedWolfEntity.init();
			InfectedPhantomEntity.init();
			PoweredWolfEntity.init();
			BrainWalkerEntity.init();
			VersaWhaleEntity.init();
			LokusEntity.init();
			FrostSpiderEntity.init();
			GlowPugEntity.init();
			AbyssalLionEntity.init();
			InfcetedCowEntity.init();
			AbylagerEntity.init();
			SpectralEntityEntity.init();
			SummonedHollowSeekerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(THE_ROKA.get(), TheRokaEntity.createAttributes().build());
		event.put(FIRE_FLY.get(), FireFlyEntity.createAttributes().build());
		event.put(ICE_SKELETON.get(), IceSkeletonEntity.createAttributes().build());
		event.put(ICE_KNIGHT.get(), IceKnightEntity.createAttributes().build());
		event.put(NIGHTBLADE_BOSS.get(), NightbladeBossEntity.createAttributes().build());
		event.put(NIGHT_BLADE_BOSS_CLONE.get(), NightBladeBossCloneEntity.createAttributes().build());
		event.put(DEER.get(), DeerEntity.createAttributes().build());
		event.put(LARO_FISH_FLY.get(), LaroFishFlyEntity.createAttributes().build());
		event.put(LARO_FISH.get(), LaroFishEntity.createAttributes().build());
		event.put(LURO_FISH.get(), LuroFishEntity.createAttributes().build());
		event.put(RALU_FISH.get(), RaluFishEntity.createAttributes().build());
		event.put(HYLIA_FOX.get(), HyliaFoxEntity.createAttributes().build());
		event.put(CRYSTAL_GOLEM.get(), CrystalGolemEntity.createAttributes().build());
		event.put(ABYSSAUR.get(), AbyssaurEntity.createAttributes().build());
		event.put(MAGICIAN.get(), MagicianEntity.createAttributes().build());
		event.put(SOUL_GUARD.get(), SoulGuardEntity.createAttributes().build());
		event.put(INFECTED_SPIDER.get(), InfectedSpiderEntity.createAttributes().build());
		event.put(INFECTED_CREEPER.get(), InfectedCreeperEntity.createAttributes().build());
		event.put(GUARD.get(), GuardEntity.createAttributes().build());
		event.put(MUD_ZOMBIE.get(), MudZombieEntity.createAttributes().build());
		event.put(INFECTED_ZOMBIE.get(), InfectedZombieEntity.createAttributes().build());
		event.put(RAPTOR.get(), RaptorEntity.createAttributes().build());
		event.put(END_SPIDER.get(), EndSpiderEntity.createAttributes().build());
		event.put(NIGHT_HUNTER.get(), NightHunterEntity.createAttributes().build());
		event.put(LIZARD.get(), LizardEntity.createAttributes().build());
		event.put(ELDER.get(), ElderEntity.createAttributes().build());
		event.put(JUNGLE_LURKER.get(), JungleLurkerEntity.createAttributes().build());
		event.put(SLIME_SPIDER.get(), SlimeSpiderEntity.createAttributes().build());
		event.put(SCORPION.get(), ScorpionEntity.createAttributes().build());
		event.put(SEEKER.get(), SeekerEntity.createAttributes().build());
		event.put(PLAYER_BODY.get(), PlayerBodyEntity.createAttributes().build());
		event.put(HAUNTED_SKELETON.get(), HauntedSkeletonEntity.createAttributes().build());
		event.put(SHATTERED_ZOMBIE.get(), ShatteredZombieEntity.createAttributes().build());
		event.put(SUMMONED_SEEKER.get(), SummonedSeekerEntity.createAttributes().build());
		event.put(MAGICAL_DEER.get(), MagicalDeerEntity.createAttributes().build());
		event.put(INFECTED_WOLF.get(), InfectedWolfEntity.createAttributes().build());
		event.put(INFECTED_PHANTOM.get(), InfectedPhantomEntity.createAttributes().build());
		event.put(POWERED_WOLF.get(), PoweredWolfEntity.createAttributes().build());
		event.put(BRAIN_WALKER.get(), BrainWalkerEntity.createAttributes().build());
		event.put(VERSA_WHALE.get(), VersaWhaleEntity.createAttributes().build());
		event.put(LOKUS.get(), LokusEntity.createAttributes().build());
		event.put(FROST_SPIDER.get(), FrostSpiderEntity.createAttributes().build());
		event.put(GLOW_PUG.get(), GlowPugEntity.createAttributes().build());
		event.put(ABYSSAL_LION.get(), AbyssalLionEntity.createAttributes().build());
		event.put(INFCETED_COW.get(), InfcetedCowEntity.createAttributes().build());
		event.put(ABYLAGER.get(), AbylagerEntity.createAttributes().build());
		event.put(SPECTRAL_ENTITY.get(), SpectralEntityEntity.createAttributes().build());
		event.put(SUMMONED_HOLLOW_SEEKER.get(), SummonedHollowSeekerEntity.createAttributes().build());
	}
}

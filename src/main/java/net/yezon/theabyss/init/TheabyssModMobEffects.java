

package net.yezon.theabyss.init;

import net.yezon.theabyss.potion.WeakElectricityMobEffect;
import net.yezon.theabyss.potion.TimeStopPotionIratorMobEffect;
import net.yezon.theabyss.potion.TimeStopPotionEffectMobEffect;
import net.yezon.theabyss.potion.TantrumMobEffect;
import net.yezon.theabyss.potion.NodePotionMobEffect;
import net.yezon.theabyss.potion.ImmortalMobEffect;
import net.yezon.theabyss.potion.GhostMobEffect;
import net.yezon.theabyss.potion.FrostPoisonMobEffect;
import net.yezon.theabyss.potion.FlyingMobEffect;
import net.yezon.theabyss.potion.FirestormMobEffect;
import net.yezon.theabyss.potion.FearMobEffect;
import net.yezon.theabyss.potion.ElectricityMobEffect;
import net.yezon.theabyss.potion.DashMobEffect;
import net.yezon.theabyss.potion.CursedAuraMobEffect;
import net.yezon.theabyss.potion.CurseMobEffect;
import net.yezon.theabyss.potion.AntiInfectionMobEffect;
import net.yezon.theabyss.potion.AntiFearPotionMobEffect;
import net.yezon.theabyss.potion.AfterLifeMobEffect;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class TheabyssModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TheabyssMod.MODID);
	public static final RegistryObject<MobEffect> FEAR = REGISTRY.register("fear", () -> new FearMobEffect());
	public static final RegistryObject<MobEffect> NODE_POTION = REGISTRY.register("node_potion", () -> new NodePotionMobEffect());
	public static final RegistryObject<MobEffect> TIME_STOP_POTION_EFFECT = REGISTRY.register("time_stop_potion_effect",
			() -> new TimeStopPotionEffectMobEffect());
	public static final RegistryObject<MobEffect> TIME_STOP_POTION_IRATOR = REGISTRY.register("time_stop_potion_irator",
			() -> new TimeStopPotionIratorMobEffect());
	public static final RegistryObject<MobEffect> CURSE = REGISTRY.register("curse", () -> new CurseMobEffect());
	public static final RegistryObject<MobEffect> CURSED_AURA = REGISTRY.register("cursed_aura", () -> new CursedAuraMobEffect());
	public static final RegistryObject<MobEffect> ANTI_FEAR_POTION = REGISTRY.register("anti_fear_potion", () -> new AntiFearPotionMobEffect());
	public static final RegistryObject<MobEffect> TANTRUM = REGISTRY.register("tantrum", () -> new TantrumMobEffect());
	public static final RegistryObject<MobEffect> GHOST = REGISTRY.register("ghost", () -> new GhostMobEffect());
	public static final RegistryObject<MobEffect> FLYING = REGISTRY.register("flying", () -> new FlyingMobEffect());
	public static final RegistryObject<MobEffect> FIRESTORM = REGISTRY.register("firestorm", () -> new FirestormMobEffect());
	public static final RegistryObject<MobEffect> AFTER_LIFE = REGISTRY.register("after_life", () -> new AfterLifeMobEffect());
	public static final RegistryObject<MobEffect> IMMORTAL = REGISTRY.register("immortal", () -> new ImmortalMobEffect());
	public static final RegistryObject<MobEffect> FROST_POISON = REGISTRY.register("frost_poison", () -> new FrostPoisonMobEffect());
	public static final RegistryObject<MobEffect> DASH = REGISTRY.register("dash", () -> new DashMobEffect());
	public static final RegistryObject<MobEffect> ELECTRICITY = REGISTRY.register("electricity", () -> new ElectricityMobEffect());
	public static final RegistryObject<MobEffect> WEAK_ELECTRICITY = REGISTRY.register("weak_electricity", () -> new WeakElectricityMobEffect());
	public static final RegistryObject<MobEffect> ANTI_INFECTION = REGISTRY.register("anti_infection", () -> new AntiInfectionMobEffect());
}

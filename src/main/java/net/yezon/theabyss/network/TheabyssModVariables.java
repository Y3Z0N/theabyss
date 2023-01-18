package net.yezon.theabyss.network;

import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheabyssModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		TheabyssMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new,
				SavedDataSyncMessage::handler);
		TheabyssMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.SaveFD = original.SaveFD;
			clone.SaveY = original.SaveY;
			clone.SaveZ = original.SaveZ;
			clone.BookSpawn = original.BookSpawn;
			clone.SaveX = original.SaveX;
			clone.SaveHP = original.SaveHP;
			clone.SleepEvent = original.SleepEvent;
			clone.Mana = original.Mana;
			clone.WandAbility = original.WandAbility;
			clone.RadioEvent = original.RadioEvent;
			clone.AbyssCloak = original.AbyssCloak;
			clone.ManaBarToggle = original.ManaBarToggle;
			clone.ManaBlinkAnimation = original.ManaBlinkAnimation;
			clone.ManaUpgrade = original.ManaUpgrade;
			clone.ManaRegenUpgrade = original.ManaRegenUpgrade;
			clone.SleepEvent2 = original.SleepEvent2;
			clone.GetConfigVersion = original.GetConfigVersion;
			clone.ArmorPotionLevel = original.ArmorPotionLevel;
			clone.FearEffect = original.FearEffect;
			clone.EnableSomnium = original.EnableSomnium;
			clone.Prolog = original.Prolog;
			clone.ManaCooldown = original.ManaCooldown;
			clone.ManaDurability = original.ManaDurability;
			clone.ManaDamage = original.ManaDamage;
			clone.Playername = original.Playername;
			clone.PlayerRep = original.PlayerRep;
			clone.NightbladeY = original.NightbladeY;
			clone.NightbladeX = original.NightbladeX;
			clone.NightbladeZ = original.NightbladeZ;
			clone.HomeY = original.HomeY;
			clone.HomeZ = original.HomeZ;
			clone.HomeX = original.HomeX;
			clone.RingOfHome = original.RingOfHome;
			clone.PocketPlayerZ = original.PocketPlayerZ;
			clone.PocketPlayerY = original.PocketPlayerY;
			clone.PocketPlayerX = original.PocketPlayerX;
			clone.PocketDimension = original.PocketDimension;
			clone.ClockX = original.ClockX;
			clone.ClockY = original.ClockY;
			clone.ClockZ = original.ClockZ;
			clone.ClockActive = original.ClockActive;
			clone.FoundBody = original.FoundBody;
			clone.DestriyAfterLifeItem = original.DestriyAfterLifeItem;
			clone.FireworkOnJoin = original.FireworkOnJoin;
			clone.ParticlesOnDeath = original.ParticlesOnDeath;
			clone.WalkParticles = original.WalkParticles;
			clone.P3 = original.P3;
			clone.P4 = original.P4;
			clone.P5 = original.P5;
			clone.P6 = original.P6;
			clone.NetherX = original.NetherX;
			clone.NetherY = original.NetherY;
			clone.NetherZ = original.NetherZ;
			clone.EndX = original.EndX;
			clone.EndY = original.EndY;
			clone.EndZ = original.EndZ;
			clone.AbyssX = original.AbyssX;
			clone.AbyssY = original.AbyssY;
			clone.AbyssZ = original.AbyssZ;
			clone.OverworldX = original.OverworldX;
			clone.OverworldY = original.OverworldY;
			clone.OverworldZ = original.OverworldZ;
			clone.CrimsonCrystalResearch = original.CrimsonCrystalResearch;
			clone.WarpedCrystalResearch = original.WarpedCrystalResearch;
			clone.EnderCrystalResearch = original.EnderCrystalResearch;
			clone.AbyssCrystalResearch = original.AbyssCrystalResearch;
			clone.FrostCrystalResearch = original.FrostCrystalResearch;
			clone.HollowCrystalResearch = original.HollowCrystalResearch;
			clone.LPMMode = original.LPMMode;
			clone.EnableManaBar = original.EnableManaBar;
			clone.FirstJoin = original.FirstJoin;
			clone.PX = original.PX;
			clone.HudX = original.HudX;
			clone.HudY = original.HudY;
			clone.HasAbsorb = original.HasAbsorb;
			clone.HasArmor = original.HasArmor;
			clone.HasExtraHP = original.HasExtraHP;
			clone.BarComp = original.BarComp;
			clone.EmptySomnium = original.EmptySomnium;
			clone.SomniumHandler = original.SomniumHandler;
			clone.EternalAbyss = original.EternalAbyss;
			clone.EA_Intro = original.EA_Intro;
			clone.FriendMode = original.FriendMode;
			clone.Infected = original.Infected;
			clone.Freeze = original.Freeze;
			clone.CavernaCrystalResearch = original.CavernaCrystalResearch;
			clone.AurelCrystalResearch = original.AurelCrystalResearch;
			clone.HolyPlayer = original.HolyPlayer;
			clone.ConfigBook = original.ConfigBook;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					TheabyssMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					TheabyssMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					TheabyssMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "theabyss_worldvars";
		public double MobLevel = 0;
		public double PocketDimensionX = 0;
		public double PocketDimensionZ = 0;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			MobLevel = nbt.getDouble("MobLevel");
			PocketDimensionX = nbt.getDouble("PocketDimensionX");
			PocketDimensionZ = nbt.getDouble("PocketDimensionZ");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("MobLevel", MobLevel);
			nbt.putDouble("PocketDimensionX", PocketDimensionX);
			nbt.putDouble("PocketDimensionZ", PocketDimensionZ);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				TheabyssMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "theabyss_mapvars";
		public double XTest = 0.0;
		public double ZTest = 0;
		public boolean FullSomnium = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			XTest = nbt.getDouble("XTest");
			ZTest = nbt.getDouble("ZTest");
			FullSomnium = nbt.getBoolean("FullSomnium");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("XTest", XTest);
			nbt.putDouble("ZTest", ZTest);
			nbt.putBoolean("FullSomnium", FullSomnium);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				TheabyssMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e),
						MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("theabyss", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double SaveFD = 0;
		public double SaveY = 0;
		public double SaveZ = 0;
		public boolean BookSpawn = false;
		public double SaveX = 0;
		public double SaveHP = 0;
		public boolean SleepEvent = false;
		public double Mana = 0;
		public String WandAbility = "";
		public boolean RadioEvent = false;
		public boolean AbyssCloak = false;
		public boolean ManaBarToggle = false;
		public boolean ManaBlinkAnimation = false;
		public double ManaUpgrade = 1.0;
		public double ManaRegenUpgrade = 0;
		public boolean SleepEvent2 = false;
		public String GetConfigVersion = "";
		public double ArmorPotionLevel = 0.0;
		public boolean FearEffect = true;
		public boolean EnableSomnium = true;
		public boolean Prolog = true;
		public double ManaCooldown = 1.0;
		public double ManaDurability = 1.0;
		public double ManaDamage = 0;
		public String Playername = "";
		public double PlayerRep = 0;
		public double NightbladeY = 0;
		public double NightbladeX = 0;
		public double NightbladeZ = 0;
		public double HomeY = 0;
		public double HomeZ = 0;
		public double HomeX = 0;
		public boolean RingOfHome = false;
		public double PocketPlayerZ = 0;
		public double PocketPlayerY = 0;
		public double PocketPlayerX = 0;
		public boolean PocketDimension = false;
		public double ClockX = 0;
		public double ClockY = 0;
		public double ClockZ = 0;
		public boolean ClockActive = false;
		public boolean FoundBody = false;
		public boolean DestriyAfterLifeItem = false;
		public boolean FireworkOnJoin = false;
		public boolean ParticlesOnDeath = false;
		public boolean WalkParticles = false;
		public boolean P3 = false;
		public boolean P4 = false;
		public boolean P5 = false;
		public boolean P6 = false;
		public double NetherX = 0;
		public double NetherY = 0;
		public double NetherZ = 0;
		public double EndX = 0;
		public double EndY = 0;
		public double EndZ = 0;
		public double AbyssX = 0;
		public double AbyssY = 0;
		public double AbyssZ = 0;
		public double OverworldX = 0;
		public double OverworldY = 0;
		public double OverworldZ = 0;
		public boolean CrimsonCrystalResearch = false;
		public boolean WarpedCrystalResearch = false;
		public boolean EnderCrystalResearch = false;
		public boolean AbyssCrystalResearch = false;
		public boolean FrostCrystalResearch = false;
		public boolean HollowCrystalResearch = false;
		public boolean LPMMode = false;
		public boolean EnableManaBar = false;
		public boolean FirstJoin = false;
		public boolean PX = false;
		public double HudX = 0;
		public double HudY = 0;
		public boolean HasAbsorb = false;
		public boolean HasArmor = false;
		public boolean HasExtraHP = false;
		public boolean BarComp = false;
		public boolean EmptySomnium = false;
		public boolean SomniumHandler = false;
		public boolean EternalAbyss = false;
		public boolean EA_Intro = false;
		public boolean FriendMode = false;
		public double Infected = 0;
		public double Freeze = 0;
		public boolean CavernaCrystalResearch = false;
		public boolean AurelCrystalResearch = false;
		public boolean HolyPlayer = false;
		public boolean ConfigBook = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				TheabyssMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("SaveFD", SaveFD);
			nbt.putDouble("SaveY", SaveY);
			nbt.putDouble("SaveZ", SaveZ);
			nbt.putBoolean("BookSpawn", BookSpawn);
			nbt.putDouble("SaveX", SaveX);
			nbt.putDouble("SaveHP", SaveHP);
			nbt.putBoolean("SleepEvent", SleepEvent);
			nbt.putDouble("Mana", Mana);
			nbt.putString("WandAbility", WandAbility);
			nbt.putBoolean("RadioEvent", RadioEvent);
			nbt.putBoolean("AbyssCloak", AbyssCloak);
			nbt.putBoolean("ManaBarToggle", ManaBarToggle);
			nbt.putBoolean("ManaBlinkAnimation", ManaBlinkAnimation);
			nbt.putDouble("ManaUpgrade", ManaUpgrade);
			nbt.putDouble("ManaRegenUpgrade", ManaRegenUpgrade);
			nbt.putBoolean("SleepEvent2", SleepEvent2);
			nbt.putString("GetConfigVersion", GetConfigVersion);
			nbt.putDouble("ArmorPotionLevel", ArmorPotionLevel);
			nbt.putBoolean("FearEffect", FearEffect);
			nbt.putBoolean("EnableSomnium", EnableSomnium);
			nbt.putBoolean("Prolog", Prolog);
			nbt.putDouble("ManaCooldown", ManaCooldown);
			nbt.putDouble("ManaDurability", ManaDurability);
			nbt.putDouble("ManaDamage", ManaDamage);
			nbt.putString("Playername", Playername);
			nbt.putDouble("PlayerRep", PlayerRep);
			nbt.putDouble("NightbladeY", NightbladeY);
			nbt.putDouble("NightbladeX", NightbladeX);
			nbt.putDouble("NightbladeZ", NightbladeZ);
			nbt.putDouble("HomeY", HomeY);
			nbt.putDouble("HomeZ", HomeZ);
			nbt.putDouble("HomeX", HomeX);
			nbt.putBoolean("RingOfHome", RingOfHome);
			nbt.putDouble("PocketPlayerZ", PocketPlayerZ);
			nbt.putDouble("PocketPlayerY", PocketPlayerY);
			nbt.putDouble("PocketPlayerX", PocketPlayerX);
			nbt.putBoolean("PocketDimension", PocketDimension);
			nbt.putDouble("ClockX", ClockX);
			nbt.putDouble("ClockY", ClockY);
			nbt.putDouble("ClockZ", ClockZ);
			nbt.putBoolean("ClockActive", ClockActive);
			nbt.putBoolean("FoundBody", FoundBody);
			nbt.putBoolean("DestriyAfterLifeItem", DestriyAfterLifeItem);
			nbt.putBoolean("FireworkOnJoin", FireworkOnJoin);
			nbt.putBoolean("ParticlesOnDeath", ParticlesOnDeath);
			nbt.putBoolean("WalkParticles", WalkParticles);
			nbt.putBoolean("P3", P3);
			nbt.putBoolean("P4", P4);
			nbt.putBoolean("P5", P5);
			nbt.putBoolean("P6", P6);
			nbt.putDouble("NetherX", NetherX);
			nbt.putDouble("NetherY", NetherY);
			nbt.putDouble("NetherZ", NetherZ);
			nbt.putDouble("EndX", EndX);
			nbt.putDouble("EndY", EndY);
			nbt.putDouble("EndZ", EndZ);
			nbt.putDouble("AbyssX", AbyssX);
			nbt.putDouble("AbyssY", AbyssY);
			nbt.putDouble("AbyssZ", AbyssZ);
			nbt.putDouble("OverworldX", OverworldX);
			nbt.putDouble("OverworldY", OverworldY);
			nbt.putDouble("OverworldZ", OverworldZ);
			nbt.putBoolean("CrimsonCrystalResearch", CrimsonCrystalResearch);
			nbt.putBoolean("WarpedCrystalResearch", WarpedCrystalResearch);
			nbt.putBoolean("EnderCrystalResearch", EnderCrystalResearch);
			nbt.putBoolean("AbyssCrystalResearch", AbyssCrystalResearch);
			nbt.putBoolean("FrostCrystalResearch", FrostCrystalResearch);
			nbt.putBoolean("HollowCrystalResearch", HollowCrystalResearch);
			nbt.putBoolean("LPMMode", LPMMode);
			nbt.putBoolean("EnableManaBar", EnableManaBar);
			nbt.putBoolean("FirstJoin", FirstJoin);
			nbt.putBoolean("PX", PX);
			nbt.putDouble("HudX", HudX);
			nbt.putDouble("HudY", HudY);
			nbt.putBoolean("HasAbsorb", HasAbsorb);
			nbt.putBoolean("HasArmor", HasArmor);
			nbt.putBoolean("HasExtraHP", HasExtraHP);
			nbt.putBoolean("BarComp", BarComp);
			nbt.putBoolean("EmptySomnium", EmptySomnium);
			nbt.putBoolean("SomniumHandler", SomniumHandler);
			nbt.putBoolean("EternalAbyss", EternalAbyss);
			nbt.putBoolean("EA_Intro", EA_Intro);
			nbt.putBoolean("FriendMode", FriendMode);
			nbt.putDouble("Infected", Infected);
			nbt.putDouble("Freeze", Freeze);
			nbt.putBoolean("CavernaCrystalResearch", CavernaCrystalResearch);
			nbt.putBoolean("AurelCrystalResearch", AurelCrystalResearch);
			nbt.putBoolean("HolyPlayer", HolyPlayer);
			nbt.putBoolean("ConfigBook", ConfigBook);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			SaveFD = nbt.getDouble("SaveFD");
			SaveY = nbt.getDouble("SaveY");
			SaveZ = nbt.getDouble("SaveZ");
			BookSpawn = nbt.getBoolean("BookSpawn");
			SaveX = nbt.getDouble("SaveX");
			SaveHP = nbt.getDouble("SaveHP");
			SleepEvent = nbt.getBoolean("SleepEvent");
			Mana = nbt.getDouble("Mana");
			WandAbility = nbt.getString("WandAbility");
			RadioEvent = nbt.getBoolean("RadioEvent");
			AbyssCloak = nbt.getBoolean("AbyssCloak");
			ManaBarToggle = nbt.getBoolean("ManaBarToggle");
			ManaBlinkAnimation = nbt.getBoolean("ManaBlinkAnimation");
			ManaUpgrade = nbt.getDouble("ManaUpgrade");
			ManaRegenUpgrade = nbt.getDouble("ManaRegenUpgrade");
			SleepEvent2 = nbt.getBoolean("SleepEvent2");
			GetConfigVersion = nbt.getString("GetConfigVersion");
			ArmorPotionLevel = nbt.getDouble("ArmorPotionLevel");
			FearEffect = nbt.getBoolean("FearEffect");
			EnableSomnium = nbt.getBoolean("EnableSomnium");
			Prolog = nbt.getBoolean("Prolog");
			ManaCooldown = nbt.getDouble("ManaCooldown");
			ManaDurability = nbt.getDouble("ManaDurability");
			ManaDamage = nbt.getDouble("ManaDamage");
			Playername = nbt.getString("Playername");
			PlayerRep = nbt.getDouble("PlayerRep");
			NightbladeY = nbt.getDouble("NightbladeY");
			NightbladeX = nbt.getDouble("NightbladeX");
			NightbladeZ = nbt.getDouble("NightbladeZ");
			HomeY = nbt.getDouble("HomeY");
			HomeZ = nbt.getDouble("HomeZ");
			HomeX = nbt.getDouble("HomeX");
			RingOfHome = nbt.getBoolean("RingOfHome");
			PocketPlayerZ = nbt.getDouble("PocketPlayerZ");
			PocketPlayerY = nbt.getDouble("PocketPlayerY");
			PocketPlayerX = nbt.getDouble("PocketPlayerX");
			PocketDimension = nbt.getBoolean("PocketDimension");
			ClockX = nbt.getDouble("ClockX");
			ClockY = nbt.getDouble("ClockY");
			ClockZ = nbt.getDouble("ClockZ");
			ClockActive = nbt.getBoolean("ClockActive");
			FoundBody = nbt.getBoolean("FoundBody");
			DestriyAfterLifeItem = nbt.getBoolean("DestriyAfterLifeItem");
			FireworkOnJoin = nbt.getBoolean("FireworkOnJoin");
			ParticlesOnDeath = nbt.getBoolean("ParticlesOnDeath");
			WalkParticles = nbt.getBoolean("WalkParticles");
			P3 = nbt.getBoolean("P3");
			P4 = nbt.getBoolean("P4");
			P5 = nbt.getBoolean("P5");
			P6 = nbt.getBoolean("P6");
			NetherX = nbt.getDouble("NetherX");
			NetherY = nbt.getDouble("NetherY");
			NetherZ = nbt.getDouble("NetherZ");
			EndX = nbt.getDouble("EndX");
			EndY = nbt.getDouble("EndY");
			EndZ = nbt.getDouble("EndZ");
			AbyssX = nbt.getDouble("AbyssX");
			AbyssY = nbt.getDouble("AbyssY");
			AbyssZ = nbt.getDouble("AbyssZ");
			OverworldX = nbt.getDouble("OverworldX");
			OverworldY = nbt.getDouble("OverworldY");
			OverworldZ = nbt.getDouble("OverworldZ");
			CrimsonCrystalResearch = nbt.getBoolean("CrimsonCrystalResearch");
			WarpedCrystalResearch = nbt.getBoolean("WarpedCrystalResearch");
			EnderCrystalResearch = nbt.getBoolean("EnderCrystalResearch");
			AbyssCrystalResearch = nbt.getBoolean("AbyssCrystalResearch");
			FrostCrystalResearch = nbt.getBoolean("FrostCrystalResearch");
			HollowCrystalResearch = nbt.getBoolean("HollowCrystalResearch");
			LPMMode = nbt.getBoolean("LPMMode");
			EnableManaBar = nbt.getBoolean("EnableManaBar");
			FirstJoin = nbt.getBoolean("FirstJoin");
			PX = nbt.getBoolean("PX");
			HudX = nbt.getDouble("HudX");
			HudY = nbt.getDouble("HudY");
			HasAbsorb = nbt.getBoolean("HasAbsorb");
			HasArmor = nbt.getBoolean("HasArmor");
			HasExtraHP = nbt.getBoolean("HasExtraHP");
			BarComp = nbt.getBoolean("BarComp");
			EmptySomnium = nbt.getBoolean("EmptySomnium");
			SomniumHandler = nbt.getBoolean("SomniumHandler");
			EternalAbyss = nbt.getBoolean("EternalAbyss");
			EA_Intro = nbt.getBoolean("EA_Intro");
			FriendMode = nbt.getBoolean("FriendMode");
			Infected = nbt.getDouble("Infected");
			Freeze = nbt.getDouble("Freeze");
			CavernaCrystalResearch = nbt.getBoolean("CavernaCrystalResearch");
			AurelCrystalResearch = nbt.getBoolean("AurelCrystalResearch");
			HolyPlayer = nbt.getBoolean("HolyPlayer");
			ConfigBook = nbt.getBoolean("ConfigBook");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.SaveFD = message.data.SaveFD;
					variables.SaveY = message.data.SaveY;
					variables.SaveZ = message.data.SaveZ;
					variables.BookSpawn = message.data.BookSpawn;
					variables.SaveX = message.data.SaveX;
					variables.SaveHP = message.data.SaveHP;
					variables.SleepEvent = message.data.SleepEvent;
					variables.Mana = message.data.Mana;
					variables.WandAbility = message.data.WandAbility;
					variables.RadioEvent = message.data.RadioEvent;
					variables.AbyssCloak = message.data.AbyssCloak;
					variables.ManaBarToggle = message.data.ManaBarToggle;
					variables.ManaBlinkAnimation = message.data.ManaBlinkAnimation;
					variables.ManaUpgrade = message.data.ManaUpgrade;
					variables.ManaRegenUpgrade = message.data.ManaRegenUpgrade;
					variables.SleepEvent2 = message.data.SleepEvent2;
					variables.GetConfigVersion = message.data.GetConfigVersion;
					variables.ArmorPotionLevel = message.data.ArmorPotionLevel;
					variables.FearEffect = message.data.FearEffect;
					variables.EnableSomnium = message.data.EnableSomnium;
					variables.Prolog = message.data.Prolog;
					variables.ManaCooldown = message.data.ManaCooldown;
					variables.ManaDurability = message.data.ManaDurability;
					variables.ManaDamage = message.data.ManaDamage;
					variables.Playername = message.data.Playername;
					variables.PlayerRep = message.data.PlayerRep;
					variables.NightbladeY = message.data.NightbladeY;
					variables.NightbladeX = message.data.NightbladeX;
					variables.NightbladeZ = message.data.NightbladeZ;
					variables.HomeY = message.data.HomeY;
					variables.HomeZ = message.data.HomeZ;
					variables.HomeX = message.data.HomeX;
					variables.RingOfHome = message.data.RingOfHome;
					variables.PocketPlayerZ = message.data.PocketPlayerZ;
					variables.PocketPlayerY = message.data.PocketPlayerY;
					variables.PocketPlayerX = message.data.PocketPlayerX;
					variables.PocketDimension = message.data.PocketDimension;
					variables.ClockX = message.data.ClockX;
					variables.ClockY = message.data.ClockY;
					variables.ClockZ = message.data.ClockZ;
					variables.ClockActive = message.data.ClockActive;
					variables.FoundBody = message.data.FoundBody;
					variables.DestriyAfterLifeItem = message.data.DestriyAfterLifeItem;
					variables.FireworkOnJoin = message.data.FireworkOnJoin;
					variables.ParticlesOnDeath = message.data.ParticlesOnDeath;
					variables.WalkParticles = message.data.WalkParticles;
					variables.P3 = message.data.P3;
					variables.P4 = message.data.P4;
					variables.P5 = message.data.P5;
					variables.P6 = message.data.P6;
					variables.NetherX = message.data.NetherX;
					variables.NetherY = message.data.NetherY;
					variables.NetherZ = message.data.NetherZ;
					variables.EndX = message.data.EndX;
					variables.EndY = message.data.EndY;
					variables.EndZ = message.data.EndZ;
					variables.AbyssX = message.data.AbyssX;
					variables.AbyssY = message.data.AbyssY;
					variables.AbyssZ = message.data.AbyssZ;
					variables.OverworldX = message.data.OverworldX;
					variables.OverworldY = message.data.OverworldY;
					variables.OverworldZ = message.data.OverworldZ;
					variables.CrimsonCrystalResearch = message.data.CrimsonCrystalResearch;
					variables.WarpedCrystalResearch = message.data.WarpedCrystalResearch;
					variables.EnderCrystalResearch = message.data.EnderCrystalResearch;
					variables.AbyssCrystalResearch = message.data.AbyssCrystalResearch;
					variables.FrostCrystalResearch = message.data.FrostCrystalResearch;
					variables.HollowCrystalResearch = message.data.HollowCrystalResearch;
					variables.LPMMode = message.data.LPMMode;
					variables.EnableManaBar = message.data.EnableManaBar;
					variables.FirstJoin = message.data.FirstJoin;
					variables.PX = message.data.PX;
					variables.HudX = message.data.HudX;
					variables.HudY = message.data.HudY;
					variables.HasAbsorb = message.data.HasAbsorb;
					variables.HasArmor = message.data.HasArmor;
					variables.HasExtraHP = message.data.HasExtraHP;
					variables.BarComp = message.data.BarComp;
					variables.EmptySomnium = message.data.EmptySomnium;
					variables.SomniumHandler = message.data.SomniumHandler;
					variables.EternalAbyss = message.data.EternalAbyss;
					variables.EA_Intro = message.data.EA_Intro;
					variables.FriendMode = message.data.FriendMode;
					variables.Infected = message.data.Infected;
					variables.Freeze = message.data.Freeze;
					variables.CavernaCrystalResearch = message.data.CavernaCrystalResearch;
					variables.AurelCrystalResearch = message.data.AurelCrystalResearch;
					variables.HolyPlayer = message.data.HolyPlayer;
					variables.ConfigBook = message.data.ConfigBook;
				}
			});
			context.setPacketHandled(true);
		}
	}
}

package net.yezon.theabyss.server;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.yezon.theabyss.TheAbyss;
import net.yezon.theabyss.TheabyssMod;

import java.util.function.Supplier;

public class Capabilities {
	public Capabilities(TheAbyss elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				TheabyssMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				TheabyssMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				TheabyssMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "theabyss_worldvars";
		public double MobLevel = 0;
		public double PocketDimensionX = 0;
		public double PocketDimensionZ = 0;

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			MobLevel = nbt.getDouble("MobLevel");
			PocketDimensionX = nbt.getDouble("PocketDimensionX");
			PocketDimensionZ = nbt.getDouble("PocketDimensionZ");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("MobLevel", MobLevel);
			nbt.putDouble("PocketDimensionX", PocketDimensionX);
			nbt.putDouble("PocketDimensionZ", PocketDimensionZ);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				TheabyssMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "theabyss_mapvars";
		public double XTest = 0.0;
		public double ZTest = 0;
		public boolean FullSomnium = false;

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			XTest = nbt.getDouble("XTest");
			ZTest = nbt.getDouble("ZTest");
			FullSomnium = nbt.getBoolean("FullSomnium");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("XTest", XTest);
			nbt.putDouble("ZTest", ZTest);
			nbt.putBoolean("FullSomnium", FullSomnium);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				TheabyssMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("theabyss", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("SaveFD", instance.SaveFD);
			nbt.putDouble("SaveY", instance.SaveY);
			nbt.putDouble("SaveZ", instance.SaveZ);
			nbt.putBoolean("BookSpawn", instance.BookSpawn);
			nbt.putDouble("SaveX", instance.SaveX);
			nbt.putDouble("SaveHP", instance.SaveHP);
			nbt.putBoolean("SleepEvent", instance.SleepEvent);
			nbt.putDouble("Mana", instance.Mana);
			nbt.putString("WandAbility", instance.WandAbility);
			nbt.putBoolean("RadioEvent", instance.RadioEvent);
			nbt.putBoolean("AbyssCloak", instance.AbyssCloak);
			nbt.putBoolean("ManaBarToggle", instance.ManaBarToggle);
			nbt.putBoolean("ManaBlinkAnimation", instance.ManaBlinkAnimation);
			nbt.putDouble("ManaUpgrade", instance.ManaUpgrade);
			nbt.putDouble("ManaRegenUpgrade", instance.ManaRegenUpgrade);
			nbt.putBoolean("SleepEvent2", instance.SleepEvent2);
			nbt.putString("GetConfigVersion", instance.GetConfigVersion);
			nbt.putDouble("ArmorPotionLevel", instance.ArmorPotionLevel);
			nbt.putBoolean("FearEffect", instance.FearEffect);
			nbt.putBoolean("EnableSomnium", instance.EnableSomnium);
			nbt.putBoolean("Prolog", instance.Prolog);
			nbt.putDouble("ManaCooldown", instance.ManaCooldown);
			nbt.putDouble("ManaDurability", instance.ManaDurability);
			nbt.putDouble("ManaDamage", instance.ManaDamage);
			nbt.putString("Playername", instance.Playername);
			nbt.putDouble("PlayerRep", instance.PlayerRep);
			nbt.putDouble("NightbladeY", instance.NightbladeY);
			nbt.putDouble("NightbladeX", instance.NightbladeX);
			nbt.putDouble("NightbladeZ", instance.NightbladeZ);
			nbt.putDouble("HomeY", instance.HomeY);
			nbt.putDouble("HomeZ", instance.HomeZ);
			nbt.putDouble("HomeX", instance.HomeX);
			nbt.putBoolean("RingOfHome", instance.RingOfHome);
			nbt.putDouble("PocketPlayerZ", instance.PocketPlayerZ);
			nbt.putDouble("PocketPlayerY", instance.PocketPlayerY);
			nbt.putDouble("PocketPlayerX", instance.PocketPlayerX);
			nbt.putBoolean("PocketDimension", instance.PocketDimension);
			nbt.putDouble("ClockX", instance.ClockX);
			nbt.putDouble("ClockY", instance.ClockY);
			nbt.putDouble("ClockZ", instance.ClockZ);
			nbt.putBoolean("ClockActive", instance.ClockActive);
			nbt.putBoolean("FoundBody", instance.FoundBody);
			nbt.putBoolean("DestriyAfterLifeItem", instance.DestriyAfterLifeItem);
			nbt.putBoolean("FireworkOnJoin", instance.FireworkOnJoin);
			nbt.putBoolean("ParticlesOnDeath", instance.ParticlesOnDeath);
			nbt.putBoolean("WalkParticles", instance.WalkParticles);
			nbt.putBoolean("P3", instance.P3);
			nbt.putBoolean("P4", instance.P4);
			nbt.putBoolean("P5", instance.P5);
			nbt.putBoolean("P6", instance.P6);
			nbt.putDouble("NetherX", instance.NetherX);
			nbt.putDouble("NetherY", instance.NetherY);
			nbt.putDouble("NetherZ", instance.NetherZ);
			nbt.putDouble("EndX", instance.EndX);
			nbt.putDouble("EndY", instance.EndY);
			nbt.putDouble("EndZ", instance.EndZ);
			nbt.putDouble("AbyssX", instance.AbyssX);
			nbt.putDouble("AbyssY", instance.AbyssY);
			nbt.putDouble("AbyssZ", instance.AbyssZ);
			nbt.putDouble("OverworldX", instance.OverworldX);
			nbt.putDouble("OverworldY", instance.OverworldY);
			nbt.putDouble("OverworldZ", instance.OverworldZ);
			nbt.putBoolean("CrimsonCrystalResearch", instance.CrimsonCrystalResearch);
			nbt.putBoolean("WarpedCrystalResearch", instance.WarpedCrystalResearch);
			nbt.putBoolean("EnderCrystalResearch", instance.EnderCrystalResearch);
			nbt.putBoolean("AbyssCrystalResearch", instance.AbyssCrystalResearch);
			nbt.putBoolean("FrostCrystalResearch", instance.FrostCrystalResearch);
			nbt.putBoolean("HollowCrystalResearch", instance.HollowCrystalResearch);
			nbt.putBoolean("LPMMode", instance.LPMMode);
			nbt.putBoolean("EnableManaBar", instance.EnableManaBar);
			nbt.putBoolean("FirstJoin", instance.FirstJoin);
			nbt.putBoolean("PX", instance.PX);
			nbt.putDouble("HudX", instance.HudX);
			nbt.putDouble("HudY", instance.HudY);
			nbt.putBoolean("HasAbsorb", instance.HasAbsorb);
			nbt.putBoolean("HasArmor", instance.HasArmor);
			nbt.putBoolean("HasExtraHP", instance.HasExtraHP);
			nbt.putBoolean("BarComp", instance.BarComp);
			nbt.putBoolean("EmptySomnium", instance.EmptySomnium);
			nbt.putBoolean("SomniumHandler", instance.SomniumHandler);
			nbt.putBoolean("EternalAbyss", instance.EternalAbyss);
			nbt.putBoolean("EA_Intro", instance.EA_Intro);
			nbt.putBoolean("FriendMode", instance.FriendMode);
			nbt.putDouble("Infected", instance.Infected);
			nbt.putDouble("Freeze", instance.Freeze);
			nbt.putBoolean("CavernaCrystalResearch", instance.CavernaCrystalResearch);
			nbt.putBoolean("AurelCrystalResearch", instance.AurelCrystalResearch);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.SaveFD = nbt.getDouble("SaveFD");
			instance.SaveY = nbt.getDouble("SaveY");
			instance.SaveZ = nbt.getDouble("SaveZ");
			instance.BookSpawn = nbt.getBoolean("BookSpawn");
			instance.SaveX = nbt.getDouble("SaveX");
			instance.SaveHP = nbt.getDouble("SaveHP");
			instance.SleepEvent = nbt.getBoolean("SleepEvent");
			instance.Mana = nbt.getDouble("Mana");
			instance.WandAbility = nbt.getString("WandAbility");
			instance.RadioEvent = nbt.getBoolean("RadioEvent");
			instance.AbyssCloak = nbt.getBoolean("AbyssCloak");
			instance.ManaBarToggle = nbt.getBoolean("ManaBarToggle");
			instance.ManaBlinkAnimation = nbt.getBoolean("ManaBlinkAnimation");
			instance.ManaUpgrade = nbt.getDouble("ManaUpgrade");
			instance.ManaRegenUpgrade = nbt.getDouble("ManaRegenUpgrade");
			instance.SleepEvent2 = nbt.getBoolean("SleepEvent2");
			instance.GetConfigVersion = nbt.getString("GetConfigVersion");
			instance.ArmorPotionLevel = nbt.getDouble("ArmorPotionLevel");
			instance.FearEffect = nbt.getBoolean("FearEffect");
			instance.EnableSomnium = nbt.getBoolean("EnableSomnium");
			instance.Prolog = nbt.getBoolean("Prolog");
			instance.ManaCooldown = nbt.getDouble("ManaCooldown");
			instance.ManaDurability = nbt.getDouble("ManaDurability");
			instance.ManaDamage = nbt.getDouble("ManaDamage");
			instance.Playername = nbt.getString("Playername");
			instance.PlayerRep = nbt.getDouble("PlayerRep");
			instance.NightbladeY = nbt.getDouble("NightbladeY");
			instance.NightbladeX = nbt.getDouble("NightbladeX");
			instance.NightbladeZ = nbt.getDouble("NightbladeZ");
			instance.HomeY = nbt.getDouble("HomeY");
			instance.HomeZ = nbt.getDouble("HomeZ");
			instance.HomeX = nbt.getDouble("HomeX");
			instance.RingOfHome = nbt.getBoolean("RingOfHome");
			instance.PocketPlayerZ = nbt.getDouble("PocketPlayerZ");
			instance.PocketPlayerY = nbt.getDouble("PocketPlayerY");
			instance.PocketPlayerX = nbt.getDouble("PocketPlayerX");
			instance.PocketDimension = nbt.getBoolean("PocketDimension");
			instance.ClockX = nbt.getDouble("ClockX");
			instance.ClockY = nbt.getDouble("ClockY");
			instance.ClockZ = nbt.getDouble("ClockZ");
			instance.ClockActive = nbt.getBoolean("ClockActive");
			instance.FoundBody = nbt.getBoolean("FoundBody");
			instance.DestriyAfterLifeItem = nbt.getBoolean("DestriyAfterLifeItem");
			instance.FireworkOnJoin = nbt.getBoolean("FireworkOnJoin");
			instance.ParticlesOnDeath = nbt.getBoolean("ParticlesOnDeath");
			instance.WalkParticles = nbt.getBoolean("WalkParticles");
			instance.P3 = nbt.getBoolean("P3");
			instance.P4 = nbt.getBoolean("P4");
			instance.P5 = nbt.getBoolean("P5");
			instance.P6 = nbt.getBoolean("P6");
			instance.NetherX = nbt.getDouble("NetherX");
			instance.NetherY = nbt.getDouble("NetherY");
			instance.NetherZ = nbt.getDouble("NetherZ");
			instance.EndX = nbt.getDouble("EndX");
			instance.EndY = nbt.getDouble("EndY");
			instance.EndZ = nbt.getDouble("EndZ");
			instance.AbyssX = nbt.getDouble("AbyssX");
			instance.AbyssY = nbt.getDouble("AbyssY");
			instance.AbyssZ = nbt.getDouble("AbyssZ");
			instance.OverworldX = nbt.getDouble("OverworldX");
			instance.OverworldY = nbt.getDouble("OverworldY");
			instance.OverworldZ = nbt.getDouble("OverworldZ");
			instance.CrimsonCrystalResearch = nbt.getBoolean("CrimsonCrystalResearch");
			instance.WarpedCrystalResearch = nbt.getBoolean("WarpedCrystalResearch");
			instance.EnderCrystalResearch = nbt.getBoolean("EnderCrystalResearch");
			instance.AbyssCrystalResearch = nbt.getBoolean("AbyssCrystalResearch");
			instance.FrostCrystalResearch = nbt.getBoolean("FrostCrystalResearch");
			instance.HollowCrystalResearch = nbt.getBoolean("HollowCrystalResearch");
			instance.LPMMode = nbt.getBoolean("LPMMode");
			instance.EnableManaBar = nbt.getBoolean("EnableManaBar");
			instance.FirstJoin = nbt.getBoolean("FirstJoin");
			instance.PX = nbt.getBoolean("PX");
			instance.HudX = nbt.getDouble("HudX");
			instance.HudY = nbt.getDouble("HudY");
			instance.HasAbsorb = nbt.getBoolean("HasAbsorb");
			instance.HasArmor = nbt.getBoolean("HasArmor");
			instance.HasExtraHP = nbt.getBoolean("HasExtraHP");
			instance.BarComp = nbt.getBoolean("BarComp");
			instance.EmptySomnium = nbt.getBoolean("EmptySomnium");
			instance.SomniumHandler = nbt.getBoolean("SomniumHandler");
			instance.EternalAbyss = nbt.getBoolean("EternalAbyss");
			instance.EA_Intro = nbt.getBoolean("EA_Intro");
			instance.FriendMode = nbt.getBoolean("FriendMode");
			instance.Infected = nbt.getDouble("Infected");
			instance.Freeze = nbt.getDouble("Freeze");
			instance.CavernaCrystalResearch = nbt.getBoolean("CavernaCrystalResearch");
			instance.AurelCrystalResearch = nbt.getBoolean("AurelCrystalResearch");
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

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				TheabyssMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
		if (!event.isWasDeath()) {
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
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
				}
			});
			context.setPacketHandled(true);
		}
	}
}

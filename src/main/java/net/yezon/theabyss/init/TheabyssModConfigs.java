package net.yezon.theabyss.init;

import net.yezon.theabyss.configuration.AbyssConfiguration;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TheabyssMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheabyssModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AbyssConfiguration.SPEC, "theabyss.toml");
		});
	}
}

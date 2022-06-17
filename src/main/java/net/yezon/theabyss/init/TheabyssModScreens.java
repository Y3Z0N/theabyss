
/*
 *    Y3 was here UwU ^-^
 */
package net.yezon.theabyss.init;

import net.yezon.theabyss.client.gui.WikiGuiScreen;
import net.yezon.theabyss.client.gui.ResearchScreen;
import net.yezon.theabyss.client.gui.PatreonScreenScreen;
import net.yezon.theabyss.client.gui.MortarScreen;
import net.yezon.theabyss.client.gui.InfuserScreen;
import net.yezon.theabyss.client.gui.ExtractorScreen;
import net.yezon.theabyss.client.gui.CutterScreen;
import net.yezon.theabyss.client.gui.ArcaneScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheabyssModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TheabyssModMenus.PATREON_SCREEN, PatreonScreenScreen::new);
			MenuScreens.register(TheabyssModMenus.WIKI_GUI, WikiGuiScreen::new);
			MenuScreens.register(TheabyssModMenus.INFUSER, InfuserScreen::new);
			MenuScreens.register(TheabyssModMenus.CUTTER, CutterScreen::new);
			MenuScreens.register(TheabyssModMenus.ARCANE, ArcaneScreen::new);
			MenuScreens.register(TheabyssModMenus.RESEARCH, ResearchScreen::new);
			MenuScreens.register(TheabyssModMenus.EXTRACTOR, ExtractorScreen::new);
			MenuScreens.register(TheabyssModMenus.MORTAR, MortarScreen::new);
		});
	}
}

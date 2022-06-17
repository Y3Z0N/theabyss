
/*
 *    Y3 was here UwU ^-^
 */
package net.yezon.theabyss.init;

import net.yezon.theabyss.world.inventory.WikiGuiMenu;
import net.yezon.theabyss.world.inventory.ResearchMenu;
import net.yezon.theabyss.world.inventory.PatreonScreenMenu;
import net.yezon.theabyss.world.inventory.MortarMenu;
import net.yezon.theabyss.world.inventory.InfuserMenu;
import net.yezon.theabyss.world.inventory.ExtractorMenu;
import net.yezon.theabyss.world.inventory.CutterMenu;
import net.yezon.theabyss.world.inventory.ArcaneMenu;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheabyssModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<PatreonScreenMenu> PATREON_SCREEN = register("patreon_screen",
			(id, inv, extraData) -> new PatreonScreenMenu(id, inv, extraData));
	public static final MenuType<WikiGuiMenu> WIKI_GUI = register("wiki_gui", (id, inv, extraData) -> new WikiGuiMenu(id, inv, extraData));
	public static final MenuType<InfuserMenu> INFUSER = register("infuser", (id, inv, extraData) -> new InfuserMenu(id, inv, extraData));
	public static final MenuType<CutterMenu> CUTTER = register("cutter", (id, inv, extraData) -> new CutterMenu(id, inv, extraData));
	public static final MenuType<ArcaneMenu> ARCANE = register("arcane", (id, inv, extraData) -> new ArcaneMenu(id, inv, extraData));
	public static final MenuType<ResearchMenu> RESEARCH = register("research", (id, inv, extraData) -> new ResearchMenu(id, inv, extraData));
	public static final MenuType<ExtractorMenu> EXTRACTOR = register("extractor", (id, inv, extraData) -> new ExtractorMenu(id, inv, extraData));
	public static final MenuType<MortarMenu> MORTAR = register("mortar", (id, inv, extraData) -> new MortarMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}

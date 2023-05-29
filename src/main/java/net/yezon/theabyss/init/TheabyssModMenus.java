

package net.yezon.theabyss.init;

import net.yezon.theabyss.world.inventory.ResearchMenu;
import net.yezon.theabyss.world.inventory.PatreonScreenMenu;
import net.yezon.theabyss.world.inventory.MortarMenu;
import net.yezon.theabyss.world.inventory.InfuserMenu;
import net.yezon.theabyss.world.inventory.ExtractorMenu;
import net.yezon.theabyss.world.inventory.CutterMenu;
import net.yezon.theabyss.world.inventory.ArcaneMenu;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class TheabyssModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TheabyssMod.MODID);
	public static final RegistryObject<MenuType<PatreonScreenMenu>> PATREON_SCREEN = REGISTRY.register("patreon_screen",
			() -> IForgeMenuType.create(PatreonScreenMenu::new));
	public static final RegistryObject<MenuType<InfuserMenu>> INFUSER = REGISTRY.register("infuser", () -> new MenuType<>(InfuserMenu::new));
	public static final RegistryObject<MenuType<CutterMenu>> CUTTER = REGISTRY.register("cutter", () -> IForgeMenuType.create(CutterMenu::new));
	public static final RegistryObject<MenuType<ArcaneMenu>> ARCANE = REGISTRY.register("arcane", () -> new MenuType<>(ArcaneMenu::new));
	public static final RegistryObject<MenuType<ResearchMenu>> RESEARCH = REGISTRY.register("research",
			() -> IForgeMenuType.create(ResearchMenu::new));
	public static final RegistryObject<MenuType<ExtractorMenu>> EXTRACTOR = REGISTRY.register("extractor",
			() -> IForgeMenuType.create(ExtractorMenu::new));
	public static final RegistryObject<MenuType<MortarMenu>> MORTAR = REGISTRY.register("mortar", () ->  new MenuType<>(MortarMenu::new));
}

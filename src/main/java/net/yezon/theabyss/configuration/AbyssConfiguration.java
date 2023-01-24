package net.yezon.theabyss.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class AbyssConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SOMNIUM_BAR;
	public static final ForgeConfigSpec.ConfigValue<Double> SOMNIUM_BAR_Y;
	public static final ForgeConfigSpec.ConfigValue<Double> SOMNIUM_BAR_X;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GIVE_BOOK;
	public static final ForgeConfigSpec.ConfigValue<Double> ENTITY_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_MAGIC;
	public static final ForgeConfigSpec.ConfigValue<Double> ORE_RARITY;
	public static final ForgeConfigSpec.ConfigValue<Boolean> POTATO_MODE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> MODPACK_MODE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ETERNAL_MODE;
	static {
		BUILDER.push("GUI");
		SOMNIUM_BAR = BUILDER.comment("Enable the somnium bar above the food bar.").define("Enable Somnium Bar", true);
		SOMNIUM_BAR_Y = BUILDER.comment("Move the somnium bar along the Y axis.").define("Somnium Bar Y", (double) 0);
		SOMNIUM_BAR_X = BUILDER.comment("Move the somnium bar along the X axis.").define("Somnium Bar X", (double) 0);
		BUILDER.pop();
		BUILDER.push("GUIDE");
		GIVE_BOOK = BUILDER.comment("Give the player the official The Abyss guide book.").define("Spawn Book", true);
		BUILDER.pop();
		BUILDER.push("MOD");
		ENTITY_LEVEL = BUILDER.comment("Set the difficulty of the abyss entities. The default value is 5. The minimum is 0, and the maximum is 10.").define("Difficulty", (double) 5);
		ENABLE_MAGIC = BUILDER.comment("Set this to false if you don't want to use magic. It is recommended to keep it set to true.").define("Enable Magic", true);
		ORE_RARITY = BUILDER.comment("The higher the number, the more likely rare ores like Incorythe Ore will generate in the abyss dimension. The default value is 25. The minimum value is 10, and the maximum value is 64.").define("Ore Rarity",
				(double) 25);
		POTATO_MODE = BUILDER.comment("If set to true, the mod will decrease particles and reduce AI path finding checks to improve overall performance. It is not recommended to set this to true.").define("Enable Potato Mode", false);
		MODPACK_MODE = BUILDER.comment("If Modpack mode is set to true, it will patch mods like Botania, Ars Nouveau, and other mods to prevent them from spawning structures, flowers, or entities inside the abyss dimension.")
				.define("Enable Modpack Mode", false);
		ETERNAL_MODE = BUILDER.comment("This is just for the Eternal Abyss modpack. Do not set this to true unless you want to crash your client or server. This mode requires a core mod! Here be dragons.").define("Enable Eternal Mode", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}

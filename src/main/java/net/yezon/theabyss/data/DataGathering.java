package net.yezon.theabyss.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.data.recipes.TheAbyssRecipeProvider;

@Mod.EventBusSubscriber(modid = TheabyssMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGathering {

    private DataGathering() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeServer(), new TheAbyssRecipeProvider(generator));
    }
}

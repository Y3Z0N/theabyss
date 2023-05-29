package net.yezon.theabyss.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.data.recipes.TheAbyssRecipeProvider;
import net.yezon.theabyss.data.tag.TheAbyssTagProvider;

/**
 * @author KhanhTypo
 */
@Mod.EventBusSubscriber(modid = TheabyssMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGathering {

    private DataGathering() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        final DataGenerator generator = event.getGenerator();
        final ExistingFileHelper fileHelper = event.getExistingFileHelper();
        generator.addProvider(event.includeServer(), new TheAbyssRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new TheAbyssTagProvider(generator, fileHelper));
    }
}

package net.yezon.theabyss.data.tag;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.yezon.theabyss.TheabyssMod;

@SuppressWarnings("deprecation")
public class TheAbyssTagProvider extends TagsProvider<Item> {

    public TheAbyssTagProvider(DataGenerator p_126546_, ExistingFileHelper existingFileHelper) {
        super(p_126546_, Registry.ITEM, TheabyssMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        TheAbyssModItemTags.ALL_TAGS.forEach((tag, item) -> super.tag(tag).add(item));
    }
}

package net.yezon.theabyss.data.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.init.TheabyssModItems;

import java.util.HashMap;


@SuppressWarnings("SameParameterValue")
public class TheAbyssModItemTags {
    public static final HashMap<TagKey<Item>, Item> ALL_TAGS = new HashMap<>();

    public static final TagKey<Item> IS_SOMNIUM_FUEL = createTag(TheabyssMod.MODID, "is_somnium_fuel", TheabyssModItems.SOMNIUM.get());
    public static final TagKey<Item> IS_LORAN_FUEL = createTag(TheabyssMod.MODID, "is_loran_energy", TheabyssModItems.LORAN_ENERGY.get());

    private static TagKey<Item> createTag(String prefix, String suffix, Item item) {
        TagKey<Item> tag = ItemTags.create(new ResourceLocation(prefix, suffix));
        ALL_TAGS.put(tag, item);
        return tag;
    }
}

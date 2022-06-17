
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.IncorytheArmorBodyAbilityEvent;
import net.yezon.theabyss.events.IncorytheArmorAbilityEvent;
import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public abstract class FloriteArmorItem extends ArmorItem {
	public FloriteArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 50;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{6, 6, 8, 6}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 45;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TheabyssModItems.INCORYTHE_GEM.get()));
			}

			@Override
			public String getName() {
				return "florite_armor";
			}

			@Override
			public float getToughness() {
				return 4f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.5f;
			}
		}, slot, properties);
	}

	public static class Helmet extends FloriteArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_ARMOR));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/incorythe__layer_1.png";
		}
	}

	public static class Chestplate extends FloriteArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_ARMOR));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("[+] \u00A7bStrength Buff"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/incorythe__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			IncorytheArmorBodyAbilityEvent.execute(entity);
		}
	}

	public static class Leggings extends FloriteArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_ARMOR));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/incorythe__layer_2.png";
		}
	}

	public static class Boots extends FloriteArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(TheabyssModTabs.TAB_THE_ABYSS_ARMOR));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("[+] \u00A7bSpeed Buff"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/incorythe__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			IncorytheArmorAbilityEvent.execute(entity);
		}
	}
}

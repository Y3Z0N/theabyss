
package net.yezon.theabyss.item;

import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public abstract class FusionedUnoritheArmorItem extends ArmorItem {
	public FusionedUnoritheArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 70;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{7, 9, 9, 7}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 50;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT), new ItemStack(TheabyssModItems.UNORITHE_INGOT.get()));
			}

			@Override
			public String getName() {
				return "fusioned_unorithe_armor";
			}

			@Override
			public float getToughness() {
				return 10f;
			}

			@Override
			public float getKnockbackResistance() {
				return 1f;
			}
		}, slot, properties);
	}

	public static class Helmet extends FusionedUnoritheArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(TheabyssModTabs.TAB_SLIME_FUSION_TAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/unorithe___layer_1.png";
		}
	}

	public static class Chestplate extends FusionedUnoritheArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(TheabyssModTabs.TAB_SLIME_FUSION_TAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/unorithe___layer_1.png";
		}
	}

	public static class Leggings extends FusionedUnoritheArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(TheabyssModTabs.TAB_SLIME_FUSION_TAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/unorithe___layer_2.png";
		}
	}

	public static class Boots extends FusionedUnoritheArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(TheabyssModTabs.TAB_SLIME_FUSION_TAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/unorithe___layer_1.png";
		}
	}
}

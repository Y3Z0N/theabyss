
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.GlacerytheArmorHelmetAbilityEvent;
import net.yezon.theabyss.events.GlacerytheArmorBootsAbilityEvent;
import net.yezon.theabyss.init.TheabyssModTabs;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Items;
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

public abstract class FusionedGlacerytheArmorItem extends ArmorItem {
	public FusionedGlacerytheArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 40;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{6, 6, 6, 6}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 15;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_diamond"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT), new ItemStack(TheabyssModItems.GLACERYTHE_GEM.get()));
			}

			@Override
			public String getName() {
				return "fusioned_glacerythe_armor";
			}

			@Override
			public float getToughness() {
				return 3f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		}, slot, properties);
	}

	public static class Helmet extends FusionedGlacerytheArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(TheabyssModTabs.TAB_SLIME_FUSION_TAB));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("[+] \u00A7bConduit Power Buff"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/ice__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			GlacerytheArmorHelmetAbilityEvent.execute(entity);
		}
	}

	public static class Chestplate extends FusionedGlacerytheArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(TheabyssModTabs.TAB_SLIME_FUSION_TAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/ice__layer_1.png";
		}
	}

	public static class Leggings extends FusionedGlacerytheArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(TheabyssModTabs.TAB_SLIME_FUSION_TAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/ice__layer_2.png";
		}
	}

	public static class Boots extends FusionedGlacerytheArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(TheabyssModTabs.TAB_SLIME_FUSION_TAB));
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(new TextComponent("[+] \u00A7bDolphins Grace Buff"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "theabyss:textures/models/armor/ice__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			GlacerytheArmorBootsAbilityEvent.execute(entity);
		}
	}
}

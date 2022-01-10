
package net.yezon.theabyss.item;

import net.yezon.theabyss.events.ApplyRingOfFlightEvent;
import net.yezon.theabyss.itemgroup.TheAbyssItemGroup;
import net.yezon.theabyss.TheAbyss;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@TheAbyss.Processor.Tag
public class RingOfFlightItem extends TheAbyss.Processor {
	@ObjectHolder("theabyss:ring_of_flight")
	public static final Item block = null;
	public RingOfFlightItem(TheAbyss instance) {
		super(instance, 151);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TheAbyssItemGroup.tab).maxDamage(100).rarity(Rarity.RARE));
			setRegistryName("ring_of_flight");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
list.add(new StringTextComponent("\u18B1 10.0 \u18B4 100.0 \u18B9 Right Click"));
list.add(new StringTextComponent("\u00A7bAbility\u00A7f: You can fly while holding in main or off-hand."));
list.add(new StringTextComponent("It uses \u00A7b10 percent somnium\u00A7f by default but can be improved with potions."));
list.add(new StringTextComponent(""));
list.add(new StringTextComponent("This item must be produced in the \u00A7bArcane Workbench.\u00A7f"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (selected) {
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				ApplyRingOfFlightEvent.executeEvent($_dependencies);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				ApplyRingOfFlightEvent.executeEvent($_dependencies);
			}
		}
	}
}

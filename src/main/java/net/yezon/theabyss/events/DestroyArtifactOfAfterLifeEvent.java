package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModItems;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import java.util.Random;

public class DestroyArtifactOfAfterLifeEvent {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheabyssModVariables.PlayerVariables())).DestriyAfterLifeItem == true) {
			if (itemstack.getItem() == TheabyssModItems.ARTIFACT_OF_AFTER_LIFE.get()) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(25, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					{
						boolean _setval = false;
						entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DestriyAfterLifeItem = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 25);
		}
	}
}

package net.yezon.theabyss.events;

import net.yezon.theabyss.item.ArtifactOfAfterLifeItem;
import net.yezon.theabyss.server.Capabilities;
import net.yezon.theabyss.TheabyssMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

public class DestroyArtifactOfAfterLifeEvent {

	public static void executeEvent(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheabyssMod.LOGGER.warn("Failed to load dependency entity for Event DestroyArtifactOfAfterLife!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheabyssMod.LOGGER.warn("Failed to load dependency itemstack for Event DestroyArtifactOfAfterLife!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Capabilities.PlayerVariables())).DestriyAfterLifeItem == true) {
			if (itemstack.getItem() == ArtifactOfAfterLifeItem.block) {
				{
					ItemStack _ist = itemstack;
					if (_ist.attemptDamageItem((int) 25, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
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
						boolean _setval = (false);
						entity.getCapability(Capabilities.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DestriyAfterLifeItem = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 25);
		}
	}
}

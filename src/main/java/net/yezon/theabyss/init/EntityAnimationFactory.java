package net.yezon.theabyss.init;

import net.yezon.theabyss.entity.InfectedDragonflyEntity;
import net.yezon.theabyss.entity.HummingbirdEntity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

@Mod.EventBusSubscriber
public class EntityAnimationFactory {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		if (event != null && event.getEntity() != null) {
			if (event.getEntity() instanceof InfectedDragonflyEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationEventHandler = animation;
				}
			}
			if (event.getEntity() instanceof HummingbirdEntity syncable) {
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationEventHandler = animation;
				}
			}
		}
	}
}

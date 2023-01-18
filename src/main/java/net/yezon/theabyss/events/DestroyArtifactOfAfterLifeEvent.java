package net.yezon.theabyss.events;

import net.yezon.theabyss.network.TheabyssModVariables;
import net.yezon.theabyss.init.TheabyssModItems;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

public class DestroyArtifactOfAfterLifeevent {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheabyssModVariables.PlayerVariables())).DestriyAfterLifeItem == true) {
			if (itemstack.getItem() == TheabyssModItems.ARTIFACT_OF_AFTER_LIFE.get()) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(25, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			TheabyssMod.queueServerWork(25, () -> {
				{
					boolean _setval = false;
					entity.getCapability(TheabyssModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DestriyAfterLifeItem = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}

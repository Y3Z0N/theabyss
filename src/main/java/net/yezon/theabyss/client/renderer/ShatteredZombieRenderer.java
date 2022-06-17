
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.ShatteredZombieEntity;
import net.yezon.theabyss.client.model.Modelzombie1;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class ShatteredZombieRenderer extends MobRenderer<ShatteredZombieEntity, Modelzombie1<ShatteredZombieEntity>> {
	public ShatteredZombieRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelzombie1(context.bakeLayer(Modelzombie1.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<ShatteredZombieEntity, Modelzombie1<ShatteredZombieEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/shattered_zombie_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ShatteredZombieEntity entity) {
		return new ResourceLocation("theabyss:textures/shattered_zombie.png");
	}
}

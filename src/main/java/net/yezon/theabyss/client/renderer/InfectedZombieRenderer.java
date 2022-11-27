
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.InfectedZombieEntity;
import net.yezon.theabyss.client.model.Modelzombie1;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class InfectedZombieRenderer extends MobRenderer<InfectedZombieEntity, Modelzombie1<InfectedZombieEntity>> {
	public InfectedZombieRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelzombie1(context.bakeLayer(Modelzombie1.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<InfectedZombieEntity, Modelzombie1<InfectedZombieEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/infected_zombie_skeleton_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(InfectedZombieEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/infected_zombie_skeleton.png");
	}
}

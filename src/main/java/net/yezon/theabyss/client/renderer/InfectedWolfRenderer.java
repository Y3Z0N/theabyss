
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.InfectedWolfEntity;
import net.yezon.theabyss.client.model.Modelabyss_wolf;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class InfectedWolfRenderer extends MobRenderer<InfectedWolfEntity, Modelabyss_wolf<InfectedWolfEntity>> {
	public InfectedWolfRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelabyss_wolf(context.bakeLayer(Modelabyss_wolf.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<InfectedWolfEntity, Modelabyss_wolf<InfectedWolfEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/abyss_wolf_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(InfectedWolfEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/abyss_wolf.png");
	}
}

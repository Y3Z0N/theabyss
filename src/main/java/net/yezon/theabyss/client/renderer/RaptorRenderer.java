
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.RaptorEntity;
import net.yezon.theabyss.client.model.Modelabyss_raptor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class RaptorRenderer extends MobRenderer<RaptorEntity, Modelabyss_raptor<RaptorEntity>> {
	public RaptorRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelabyss_raptor(context.bakeLayer(Modelabyss_raptor.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<RaptorEntity, Modelabyss_raptor<RaptorEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/the_abyss_raptor_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(RaptorEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/the_abyss_raptor.png");
	}
}

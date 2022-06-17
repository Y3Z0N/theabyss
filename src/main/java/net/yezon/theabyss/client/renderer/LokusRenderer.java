
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.LokusEntity;
import net.yezon.theabyss.client.model.Modelancient_seeker;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class LokusRenderer extends MobRenderer<LokusEntity, Modelancient_seeker<LokusEntity>> {
	public LokusRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelancient_seeker(context.bakeLayer(Modelancient_seeker.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<LokusEntity, Modelancient_seeker<LokusEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/lokus_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(LokusEntity entity) {
		return new ResourceLocation("theabyss:textures/lokus.png");
	}
}


package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.DeerEntity;
import net.yezon.theabyss.client.model.Modeldeer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class DeerRenderer extends MobRenderer<DeerEntity, Modeldeer<DeerEntity>> {
	public DeerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldeer(context.bakeLayer(Modeldeer.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<DeerEntity, Modeldeer<DeerEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/deer_glow_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(DeerEntity entity) {
		return new ResourceLocation("theabyss:textures/deer.png");
	}
}


package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.MagicalDeerEntity;
import net.yezon.theabyss.client.model.Modeldeer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class MagicalDeerRenderer extends MobRenderer<MagicalDeerEntity, Modeldeer<MagicalDeerEntity>> {
	public MagicalDeerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldeer(context.bakeLayer(Modeldeer.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<MagicalDeerEntity, Modeldeer<MagicalDeerEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/pink_deer_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(MagicalDeerEntity entity) {
		return new ResourceLocation("theabyss:textures/pink_deer.png");
	}
}

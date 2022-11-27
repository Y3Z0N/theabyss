
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.MagicianEntity;
import net.yezon.theabyss.client.model.Modelmagician;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class MagicianRenderer extends MobRenderer<MagicianEntity, Modelmagician<MagicianEntity>> {
	public MagicianRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmagician(context.bakeLayer(Modelmagician.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<MagicianEntity, Modelmagician<MagicianEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/magician_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(MagicianEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/magician.png");
	}
}


package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.VersaWhaleEntity;
import net.yezon.theabyss.client.model.Modelwhale;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class VersaWhaleRenderer extends MobRenderer<VersaWhaleEntity, Modelwhale<VersaWhaleEntity>> {
	public VersaWhaleRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwhale(context.bakeLayer(Modelwhale.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<VersaWhaleEntity, Modelwhale<VersaWhaleEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/versa_whale_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(VersaWhaleEntity entity) {
		return new ResourceLocation("theabyss:textures/versa_whale.png");
	}
}

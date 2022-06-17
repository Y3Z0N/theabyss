
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.InfectedSpiderEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

public class InfectedSpiderRenderer extends MobRenderer<InfectedSpiderEntity, SpiderModel<InfectedSpiderEntity>> {
	public InfectedSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
		this.addLayer(new EyesLayer<InfectedSpiderEntity, SpiderModel<InfectedSpiderEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/infected_spidder_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(InfectedSpiderEntity entity) {
		return new ResourceLocation("theabyss:textures/infected_spider.png");
	}
}

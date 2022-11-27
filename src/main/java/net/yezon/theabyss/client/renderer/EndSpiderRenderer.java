
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.EndSpiderEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

public class EndSpiderRenderer extends MobRenderer<EndSpiderEntity, SpiderModel<EndSpiderEntity>> {
	public EndSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
		this.addLayer(new EyesLayer<EndSpiderEntity, SpiderModel<EndSpiderEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/end_spider_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(EndSpiderEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/end_spider.png");
	}
}

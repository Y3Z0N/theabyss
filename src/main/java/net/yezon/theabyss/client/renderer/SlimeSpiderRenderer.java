
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.SlimeSpiderEntity;
import net.yezon.theabyss.client.model.Modelslime_spider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class SlimeSpiderRenderer extends MobRenderer<SlimeSpiderEntity, Modelslime_spider<SlimeSpiderEntity>> {
	public SlimeSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelslime_spider(context.bakeLayer(Modelslime_spider.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<SlimeSpiderEntity, Modelslime_spider<SlimeSpiderEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/green_spider_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SlimeSpiderEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/green_spider.png");
	}
}


package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.FrostSpiderEntity;
import net.yezon.theabyss.client.model.Modelfrost_spider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class FrostSpiderRenderer extends MobRenderer<FrostSpiderEntity, Modelfrost_spider<FrostSpiderEntity>> {
	public FrostSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfrost_spider(context.bakeLayer(Modelfrost_spider.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FrostSpiderEntity entity) {
		return new ResourceLocation("theabyss:textures/frost_spider.png");
	}
}

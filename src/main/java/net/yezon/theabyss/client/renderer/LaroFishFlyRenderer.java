
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.LaroFishFlyEntity;
import net.yezon.theabyss.client.model.Modelfish1;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class LaroFishFlyRenderer extends MobRenderer<LaroFishFlyEntity, Modelfish1<LaroFishFlyEntity>> {
	public LaroFishFlyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfish1(context.bakeLayer(Modelfish1.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<LaroFishFlyEntity, Modelfish1<LaroFishFlyEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/laro_fish.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(LaroFishFlyEntity entity) {
		return new ResourceLocation("theabyss:textures/laro_fish.png");
	}
}

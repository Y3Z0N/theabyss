
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.RaluFishEntity;
import net.yezon.theabyss.client.model.Modelfish3;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class RaluFishRenderer extends MobRenderer<RaluFishEntity, Modelfish3<RaluFishEntity>> {
	public RaluFishRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfish3(context.bakeLayer(Modelfish3.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<RaluFishEntity, Modelfish3<RaluFishEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/ralu_fish.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(RaluFishEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/ralu_fish.png");
	}
}

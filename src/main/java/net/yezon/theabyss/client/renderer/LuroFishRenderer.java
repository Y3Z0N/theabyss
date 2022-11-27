
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.LuroFishEntity;
import net.yezon.theabyss.client.model.Modelfish2;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class LuroFishRenderer extends MobRenderer<LuroFishEntity, Modelfish2<LuroFishEntity>> {
	public LuroFishRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfish2(context.bakeLayer(Modelfish2.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<LuroFishEntity, Modelfish2<LuroFishEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/luro_fish.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(LuroFishEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/luro_fish.png");
	}
}

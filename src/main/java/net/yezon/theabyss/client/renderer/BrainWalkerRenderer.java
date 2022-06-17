
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.BrainWalkerEntity;
import net.yezon.theabyss.client.model.Modelbrain;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class BrainWalkerRenderer extends MobRenderer<BrainWalkerEntity, Modelbrain<BrainWalkerEntity>> {
	public BrainWalkerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbrain(context.bakeLayer(Modelbrain.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<BrainWalkerEntity, Modelbrain<BrainWalkerEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/brain_walker.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(BrainWalkerEntity entity) {
		return new ResourceLocation("theabyss:textures/firefly_entity.png");
	}
}

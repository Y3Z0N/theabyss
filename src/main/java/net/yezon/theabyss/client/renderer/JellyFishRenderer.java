
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.JellyFishEntity;
import net.yezon.theabyss.client.model.Modelinfected_jellyfish;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class JellyFishRenderer extends MobRenderer<JellyFishEntity, Modelinfected_jellyfish<JellyFishEntity>> {
	public JellyFishRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelinfected_jellyfish(context.bakeLayer(Modelinfected_jellyfish.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<JellyFishEntity, Modelinfected_jellyfish<JellyFishEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/jelly_fish.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JellyFishEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/jelly_fish.png");
	}
}

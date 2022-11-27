
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.ScorpionEntity;
import net.yezon.theabyss.client.model.Modelscorpion;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class ScorpionRenderer extends MobRenderer<ScorpionEntity, Modelscorpion<ScorpionEntity>> {
	public ScorpionRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelscorpion(context.bakeLayer(Modelscorpion.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<ScorpionEntity, Modelscorpion<ScorpionEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/the_abyss_scorpion_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ScorpionEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/the_abyss_scropion.png");
	}
}

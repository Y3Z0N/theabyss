
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.LizardEntity;
import net.yezon.theabyss.client.model.Modelsoul_lizard;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class LizardRenderer extends MobRenderer<LizardEntity, Modelsoul_lizard<LizardEntity>> {
	public LizardRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsoul_lizard(context.bakeLayer(Modelsoul_lizard.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<LizardEntity, Modelsoul_lizard<LizardEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/the_abyss_lizard.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(LizardEntity entity) {
		return new ResourceLocation("theabyss:textures/the_abyss_lizard.png");
	}
}

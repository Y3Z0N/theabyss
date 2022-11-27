
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.JungleLurkerEntity;
import net.yezon.theabyss.client.model.Modelabyss_lurker;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class JungleLurkerRenderer extends MobRenderer<JungleLurkerEntity, Modelabyss_lurker<JungleLurkerEntity>> {
	public JungleLurkerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelabyss_lurker(context.bakeLayer(Modelabyss_lurker.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<JungleLurkerEntity, Modelabyss_lurker<JungleLurkerEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/the_abyss_lurker_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JungleLurkerEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/the_abyss_lurker.png");
	}
}


package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.GlowPugEntity;
import net.yezon.theabyss.client.model.Modelglow_pug;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class GlowPugRenderer extends MobRenderer<GlowPugEntity, Modelglow_pug<GlowPugEntity>> {
	public GlowPugRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelglow_pug(context.bakeLayer(Modelglow_pug.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<GlowPugEntity, Modelglow_pug<GlowPugEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/glow_pug_texture_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GlowPugEntity entity) {
		return new ResourceLocation("theabyss:textures/glow_pug_texture.png");
	}
}


package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.ElderEntity;
import net.yezon.theabyss.client.model.Modelelder_entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class ElderRenderer extends MobRenderer<ElderEntity, Modelelder_entity<ElderEntity>> {
	public ElderRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelelder_entity(context.bakeLayer(Modelelder_entity.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<ElderEntity, Modelelder_entity<ElderEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/elder_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(ElderEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/elder_layer.png");
	}
}

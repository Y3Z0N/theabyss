
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.HyliaFoxEntity;
import net.yezon.theabyss.client.model.Modelhylia_fox;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class HyliaFoxRenderer extends MobRenderer<HyliaFoxEntity, Modelhylia_fox<HyliaFoxEntity>> {
	public HyliaFoxRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelhylia_fox(context.bakeLayer(Modelhylia_fox.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<HyliaFoxEntity, Modelhylia_fox<HyliaFoxEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/hylia_fox_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(HyliaFoxEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/hylia_fox.png");
	}
}

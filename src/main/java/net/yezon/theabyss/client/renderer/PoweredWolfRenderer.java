
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.PoweredWolfEntity;
import net.yezon.theabyss.client.model.Modelabyss_wolf;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class PoweredWolfRenderer extends MobRenderer<PoweredWolfEntity, Modelabyss_wolf<PoweredWolfEntity>> {
	public PoweredWolfRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelabyss_wolf(context.bakeLayer(Modelabyss_wolf.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<PoweredWolfEntity, Modelabyss_wolf<PoweredWolfEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/powered_wolf_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(PoweredWolfEntity entity) {
		return new ResourceLocation("theabyss:textures/powered_wolf.png");
	}
}

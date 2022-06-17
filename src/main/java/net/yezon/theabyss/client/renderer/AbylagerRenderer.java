
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.AbylagerEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

public class AbylagerRenderer extends MobRenderer<AbylagerEntity, VillagerModel<AbylagerEntity>> {
	public AbylagerRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
		this.addLayer(new EyesLayer<AbylagerEntity, VillagerModel<AbylagerEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/abylager_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AbylagerEntity entity) {
		return new ResourceLocation("theabyss:textures/abylager.png");
	}
}

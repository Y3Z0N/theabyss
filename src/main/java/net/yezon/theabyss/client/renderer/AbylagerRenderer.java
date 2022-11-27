
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.AbylagerEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class AbylagerRenderer extends MobRenderer<AbylagerEntity, VillagerModel<AbylagerEntity>> {
	public AbylagerRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
		this.addLayer(new EyesLayer<AbylagerEntity, VillagerModel<AbylagerEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/abylager_glowing_layer.png"));
			}
		});
	}

	@Override
	protected void scale(AbylagerEntity villager, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(AbylagerEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/abylager.png");
	}
}

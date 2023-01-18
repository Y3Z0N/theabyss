
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.AbyssalLionEntity;
import net.yezon.theabyss.client.model.Modelabyssal_lion;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import com.mojang.blaze3d.vertex.PoseStack;

public class AbyssalLionRenderer extends MobRenderer<AbyssalLionEntity, Modelabyssal_lion<AbyssalLionEntity>> {
	public AbyssalLionRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelabyssal_lion(context.bakeLayer(Modelabyssal_lion.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<AbyssalLionEntity, Modelabyssal_lion<AbyssalLionEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/abyssal_lion_glow.png"));
			}
		});
	}

	protected void scale(AbyssalLionEntity entity, PoseStack posestack, float partialTicks) {
		posestack.scale(0.5f, 0.5f, 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AbyssalLionEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/abyssal_lion.png");
	}
}


package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.HauntedSkeletonEntity;
import net.yezon.theabyss.client.model.Modelskeleton_abyss;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class HauntedSkeletonRenderer extends MobRenderer<HauntedSkeletonEntity, Modelskeleton_abyss<HauntedSkeletonEntity>> {
	public HauntedSkeletonRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeleton_abyss(context.bakeLayer(Modelskeleton_abyss.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<HauntedSkeletonEntity, Modelskeleton_abyss<HauntedSkeletonEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/haunted_skeleton_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(HauntedSkeletonEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/haunted_skeleton.png");
	}
}

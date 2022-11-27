
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.IceSkeletonEntity;
import net.yezon.theabyss.client.model.Modelskeleton_abyss;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class IceSkeletonRenderer extends MobRenderer<IceSkeletonEntity, Modelskeleton_abyss<IceSkeletonEntity>> {
	public IceSkeletonRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeleton_abyss(context.bakeLayer(Modelskeleton_abyss.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<IceSkeletonEntity, Modelskeleton_abyss<IceSkeletonEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/ice_skeleton_glow_22.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(IceSkeletonEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/ice_skeleton_22.png");
	}
}

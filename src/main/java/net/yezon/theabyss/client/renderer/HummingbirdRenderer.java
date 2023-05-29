
package net.yezon.theabyss.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.yezon.theabyss.entity.model.HummingbirdModel;
import net.yezon.theabyss.entity.layer.HummingbirdLayer;
import net.yezon.theabyss.entity.HummingbirdEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class HummingbirdRenderer extends GeoEntityRenderer<HummingbirdEntity> {
	public HummingbirdRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new HummingbirdModel());
		this.shadowRadius = 0.8f;
		this.addLayer(new HummingbirdLayer(this));
	}

	@Override
	public RenderType getRenderType(HummingbirdEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}

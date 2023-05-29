
package net.yezon.theabyss.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.yezon.theabyss.entity.model.InfectedDragonflyModel;
import net.yezon.theabyss.entity.layer.InfectedDragonflyLayer;
import net.yezon.theabyss.entity.InfectedDragonflyEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class InfectedDragonflyRenderer extends GeoEntityRenderer<InfectedDragonflyEntity> {
	public InfectedDragonflyRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new InfectedDragonflyModel());
		this.shadowRadius = 0.6f;
		this.addLayer(new InfectedDragonflyLayer(this));
	}

	@Override
	public RenderType getRenderType(InfectedDragonflyEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}

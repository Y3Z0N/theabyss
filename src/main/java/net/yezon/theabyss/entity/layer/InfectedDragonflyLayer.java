package net.yezon.theabyss.entity.layer;

import software.bernie.geckolib3.renderers.geo.IGeoRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.PoseStack;

public class InfectedDragonflyLayer extends GeoLayerRenderer {
	private static final ResourceLocation LAYER = new ResourceLocation("theabyss", "textures/entities/dragonfly_glowing_layer.png");
	private static final ResourceLocation MODEL = new ResourceLocation("theabyss", "geo/dragonfly.geo.json");

	public InfectedDragonflyLayer(IGeoRenderer<?> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Entity entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		RenderType cameo = RenderType.eyes(LAYER);
		matrixStackIn.pushPose();
		matrixStackIn.scale(1.0f, 1.0f, 1.0f);
		matrixStackIn.translate(0.0d, 0.0d, 0.0d);
		this.getRenderer().render(this.getEntityModel().getModel(MODEL), entityLivingBaseIn, partialTicks, cameo, matrixStackIn, bufferIn, bufferIn.getBuffer(cameo), packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
		matrixStackIn.popPose();
	}
}

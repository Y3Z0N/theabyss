package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.VersaWhaleEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class VersaWhaleRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(VersaWhaleEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelversa_whale(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/versa_whale.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/versa_whale_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelversa_whale extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer top_jaw;
		private final ModelRenderer bottom_jaw;
		private final ModelRenderer torso;
		private final ModelRenderer tail;
		private final ModelRenderer tail_2;
		private final ModelRenderer RIGHT_FIN;
		private final ModelRenderer right_back_fin_r1;
		private final ModelRenderer LEFT_FIN;
		private final ModelRenderer left_back_fin_r1;

		public Modelversa_whale() {
			textureWidth = 512;
			textureHeight = 512;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			top_jaw = new ModelRenderer(this);
			top_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(top_jaw);
			top_jaw.setTextureOffset(242, 54).addBox(-14.0F, -24.0F, -61.0F, 25.0F, 5.0F, 46.0F, 0.0F, false);
			top_jaw.setTextureOffset(162, 192).addBox(-14.0F, -19.0F, -61.0F, 25.0F, 11.0F, 46.0F, 0.0F, false);
			bottom_jaw = new ModelRenderer(this);
			bottom_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
			top_jaw.addChild(bottom_jaw);
			bottom_jaw.setTextureOffset(0, 223).addBox(-14.0F, -19.0F, -61.0F, 25.0F, 11.0F, 46.0F, 0.0F, false);
			bottom_jaw.setTextureOffset(233, 0).addBox(-14.0F, -8.0F, -61.0F, 25.0F, 8.0F, 46.0F, 0.0F, false);
			bottom_jaw.setTextureOffset(96, 176).addBox(-1.5F, 0.0F, -55.0F, 0.0F, 12.0F, 47.0F, 0.0F, false);
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 24.0F, 0.0F);
			torso.setTextureOffset(0, 0).addBox(-29.0F, -11.0F, -15.0F, 55.0F, 0.0F, 73.0F, 0.0F, false);
			torso.setTextureOffset(0, 123).addBox(-17.0F, -24.0F, -15.0F, 31.0F, 27.0F, 73.0F, 0.0F, false);
			torso.setTextureOffset(0, 24).addBox(-1.5F, -49.0F, -15.0F, 0.0F, 25.0F, 74.0F, 0.0F, false);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(-0.75F, 11.25F, 57.25F);
			tail.setTextureOffset(128, 18).addBox(-13.25F, -10.25F, -0.25F, 25.0F, 21.0F, 55.0F, 0.0F, false);
			tail_2 = new ModelRenderer(this);
			tail_2.setRotationPoint(-0.75F, -2.0F, 55.0F);
			tail.addChild(tail_2);
			tail_2.setTextureOffset(164, 118).addBox(-8.5F, -8.25F, -0.25F, 17.0F, 17.0F, 57.0F, 0.0F, false);
			tail_2.setTextureOffset(83, 123).addBox(-21.5F, -0.25F, 37.75F, 43.0F, 0.0F, 52.0F, 0.0F, false);
			RIGHT_FIN = new ModelRenderer(this);
			RIGHT_FIN.setRotationPoint(0.0F, 24.0F, 0.0F);
			right_back_fin_r1 = new ModelRenderer(this);
			right_back_fin_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			RIGHT_FIN.addChild(right_back_fin_r1);
			setRotationAngle(right_back_fin_r1, 0.6545F, 0.0F, -0.7854F);
			right_back_fin_r1.setTextureOffset(0, 208).addBox(10.0F, 23.0F, 27.0F, 0.0F, 44.0F, 15.0F, 0.0F, false);
			right_back_fin_r1.setTextureOffset(0, 93).addBox(14.0F, -1.0F, -10.0F, 0.0F, 69.0F, 30.0F, 0.0F, false);
			LEFT_FIN = new ModelRenderer(this);
			LEFT_FIN.setRotationPoint(0.0F, 24.0F, 0.0F);
			left_back_fin_r1 = new ModelRenderer(this);
			left_back_fin_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			LEFT_FIN.addChild(left_back_fin_r1);
			setRotationAngle(left_back_fin_r1, 0.6545F, 0.0F, 0.7854F);
			left_back_fin_r1.setTextureOffset(142, 234).addBox(-12.0F, 25.0F, 27.0F, 0.0F, 42.0F, 15.0F, 0.0F, false);
			left_back_fin_r1.setTextureOffset(0, 0).addBox(-17.0F, 0.0F, -10.0F, 0.0F, 68.0F, 30.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			torso.render(matrixStack, buffer, packedLight, packedOverlay);
			tail.render(matrixStack, buffer, packedLight, packedOverlay);
			RIGHT_FIN.render(matrixStack, buffer, packedLight, packedOverlay);
			LEFT_FIN.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.LEFT_FIN.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.tail_2.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.RIGHT_FIN.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
